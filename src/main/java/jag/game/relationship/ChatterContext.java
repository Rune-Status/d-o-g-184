package jag.game.relationship;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public abstract class ChatterContext {

    public final int capacity;

    public final Chatter[] chatters;
    public final HashMap displayNameCache;
    public final HashMap previousNameCache;
    public Comparator comparator;

    public int count;

    public ChatterContext(int capacity) {
        count = 0;
        comparator = null;
        this.capacity = capacity;
        chatters = newArray(capacity);
        displayNameCache = new HashMap(capacity / 8);
        previousNameCache = new HashMap(capacity / 8);
    }

    public Chatter getChatterByAnyName(NamePair name) {
        Chatter chatter = getChatterByDisplayName(name);
        return chatter != null ? chatter : getChatterByPreviousName(name);
    }

    public Chatter addAndCache(NamePair displayName, NamePair previousName) {
        if (getChatterByDisplayName(displayName) != null) {
            throw new IllegalStateException();
        }
        Chatter chatter = newChatter();
        chatter.setName(displayName, previousName);
        add(chatter);
        cache(chatter);
        return chatter;
    }

    public final int indexOf(Chatter chatter) {
        for (int i = 0; i < count; ++i) {
            if (chatters[i] == chatter) {
                return i;
            }
        }

        return -1;
    }

    public final void uncache(Chatter chatter) {
        if (displayNameCache.remove(chatter.displayName) == null) {
            throw new IllegalStateException();
        }

        if (chatter.previousName != null) {
            previousNameCache.remove(chatter.previousName);
        }

    }

    public Chatter getChatterByDisplayName(NamePair name) {
        return !name.isFormattedPresent() ? null : (Chatter) displayNameCache.get(name);
    }

    public int getCount() {
        return count;
    }

    public boolean isFull() {
        return capacity == count;
    }

    public final void sort() {
        if (comparator == null) {
            Arrays.sort(chatters, 0, count);
        } else {
            Arrays.sort(chatters, 0, count, comparator);
        }

    }

    public boolean isCached(NamePair name) {
        if (!name.isFormattedPresent()) {
            return false;
        }
        return displayNameCache.containsKey(name) || previousNameCache.containsKey(name);
    }

    public Chatter getChatterByPreviousName(NamePair name) {
        return !name.isFormattedPresent() ? null : (Chatter) previousNameCache.get(name);
    }

    abstract Chatter newChatter();

    public void clear() {
        count = 0;
        Arrays.fill(chatters, null);
        displayNameCache.clear();
        previousNameCache.clear();
    }

    public final void remove(int index) {
        --count;
        if (index < count) {
            System.arraycopy(chatters, index + 1, chatters, index, count - index);
        }

    }

    public final void remove(Chatter chatter) {
        int index = indexOf(chatter);
        if (index != -1) {
            remove(index);
            uncache(chatter);
        }
    }

    public final Chatter getChatter(int index) {
        if (index >= 0 && index < count) {
            return chatters[index];
        }
        throw new ArrayIndexOutOfBoundsException(index);
    }

    public final void cache(Chatter chatter) {
        displayNameCache.put(chatter.displayName, chatter);
        if (chatter.previousName != null) {
            Chatter previouslyMapped = (Chatter) previousNameCache.put(chatter.previousName, chatter);
            if (previouslyMapped != null && previouslyMapped != chatter) {
                previouslyMapped.previousName = null;
            }
        }

    }

    abstract Chatter[] newArray(int size);

    public final boolean remove(NamePair name) {
        Chatter chatter = getChatterByDisplayName(name);
        if (chatter == null) {
            return false;
        }
        remove(chatter);
        return true;
    }

    public final void add(Chatter chatter) {
        chatters[++count - 1] = chatter;
    }

    public Chatter addAndCache(NamePair name) {
        return addAndCache(name, null);
    }

    public final void update(Chatter chatter, NamePair displayName, NamePair previousName) {
        uncache(chatter);
        chatter.setName(displayName, previousName);
        cache(chatter);
    }

    public final void unsetComparator() {
        comparator = null;
    }

    public final void setComparator(Comparator comparator) {
        if (this.comparator == null) {
            this.comparator = comparator;
        } else if (this.comparator instanceof AssociateComparator) {
            ((AssociateComparator) this.comparator).set(comparator);
        }

    }
}
