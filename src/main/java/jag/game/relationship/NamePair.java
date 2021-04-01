package jag.game.relationship;

import jag.ClientParameter;
import jag.LoginScreenEffect;
import jag.script.ScriptEvent;

public class NamePair implements Comparable {

    public final String raw;
    public final String formatted;

    public NamePair(String var1, ClientParameter nameLengthParameter) {
        this.raw = var1;
        this.formatted = ScriptEvent.format(var1, nameLengthParameter);
    }

    public int compare0(NamePair var1) {
        if (this.formatted == null) {
            return var1.formatted == null ? 0 : 1;
        }
        return var1.formatted == null ? -1 : this.formatted.compareTo(var1.formatted);
    }

    public boolean isFormattedPresent() {
        return this.formatted != null;
    }

    public String getRaw() {
        return this.raw;
    }

    public boolean equals(Object var1) {
        if (var1 instanceof NamePair) {
            NamePair var2 = (NamePair) var1;
            if (this.formatted == null) {
                return var2.formatted == null;
            }
            if (var2.formatted == null) {
                return false;
            }
            return this.hashCode() == var2.hashCode() && this.formatted.equals(var2.formatted);
        }
        return false;
    }

    public int hashCode() {
        return this.formatted == null ? 0 : this.formatted.hashCode();
    }

    public String toString() {
        return this.getRaw();
    }

    public int compareTo(Object var1) {
        return this.compare0((NamePair) var1);
    }
}
