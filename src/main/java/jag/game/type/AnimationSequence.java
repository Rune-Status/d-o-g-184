package jag.game.type;

import jag.Login;
import jag.PlayerAccountType;
import jag.SerializableProcessor;
import jag.commons.collection.DoublyLinkedNode;
import jag.commons.collection.ReferenceCache;
import jag.game.scene.entity.DynamicObject;
import jag.game.scene.entity.Model;
import jag.js5.ReferenceTable;
import jag.opcode.Buffer;
import jag.statics.Statics13;
import jag.statics.Statics8;

public class AnimationSequence extends DoublyLinkedNode {
    public static final ReferenceCache aReferenceCache700;
    public static final ReferenceCache aReferenceCache1228;
    public static java.awt.Font aFont1227;
    public static ReferenceTable aReferenceTable383;
    public static ReferenceTable aReferenceTable697;

    static {
        aReferenceCache700 = new ReferenceCache(64);
        aReferenceCache1228 = new ReferenceCache(100);
    }

    public int animatingPrecedence;
    public int[] frameIds;
    public int walkingPrecedence;
    public int loopOffset;
    public int[] frameLengths;
    public boolean stretch;
    public int offHand;
    public int priority;
    public int mainHand;
    public int maxLoops;
    public int replayMode;
    public int[] anIntArray691;
    public int[] interleaveOrder;
    public int[] anIntArray687;

    public AnimationSequence() {
        this.loopOffset = -1;
        this.stretch = false;
        this.priority = 5;
        this.offHand = -1;
        this.mainHand = -1;
        this.maxLoops = 99;
        this.animatingPrecedence = -1;
        this.walkingPrecedence = -1;
        this.replayMode = 2;
    }

    public static void method881(int var0) {
        DynamicObject.method1506();
        switch (var0) {
            case 1:
                Login.step = 24;
                PlayerAccountType.setLoginMessages("", "You were disconnected from the server.", "");
                break;
            case 2:
                SerializableProcessor.method450();
        }

    }

    public static void method1202(ReferenceTable var0, ReferenceTable var1, ReferenceTable var2) {
        aReferenceTable383 = var0;
        aReferenceTable697 = var1;
        Statics8.aReferenceTable1123 = var2;
    }

    public static AnimationSequence get(int var0) {
        AnimationSequence var2 = (AnimationSequence) aReferenceCache700.get(var0);
        if (var2 != null) {
            return var2;
        }
        byte[] var3 = aReferenceTable383.unpack(12, var0);
        var2 = new AnimationSequence();
        if (var3 != null) {
            var2.method260(new Buffer(var3));
        }

        var2.method592();
        aReferenceCache700.put(var2, var0);
        return var2;
    }

    public void method259(Buffer var1, int var2) {
        int var3;
        int var4;
        if (var2 == 1) {
            var3 = var1.readUShort();
            this.frameLengths = new int[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.frameLengths[var4] = var1.readUShort();
            }

            this.frameIds = new int[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.frameIds[var4] = var1.readUShort();
            }

            for (var4 = 0; var4 < var3; ++var4) {
                this.frameIds[var4] += var1.readUShort() << 16;
            }
        } else if (var2 == 2) {
            this.loopOffset = var1.readUShort();
        } else if (var2 == 3) {
            var3 = var1.readUByte();
            this.interleaveOrder = new int[var3 + 1];

            for (var4 = 0; var4 < var3; ++var4) {
                this.interleaveOrder[var4] = var1.readUByte();
            }

            this.interleaveOrder[var3] = 9999999;
        } else if (var2 == 4) {
            this.stretch = true;
        } else if (var2 == 5) {
            this.priority = var1.readUByte();
        } else if (var2 == 6) {
            this.offHand = var1.readUShort();
        } else if (var2 == 7) {
            this.mainHand = var1.readUShort();
        } else if (var2 == 8) {
            this.maxLoops = var1.readUByte();
        } else if (var2 == 9) {
            this.animatingPrecedence = var1.readUByte();
        } else if (var2 == 10) {
            this.walkingPrecedence = var1.readUByte();
        } else if (var2 == 11) {
            this.replayMode = var1.readUByte();
        } else if (var2 == 12) {
            var3 = var1.readUByte();
            this.anIntArray687 = new int[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.anIntArray687[var4] = var1.readUShort();
            }

            for (var4 = 0; var4 < var3; ++var4) {
                this.anIntArray687[var4] += var1.readUShort() << 16;
            }
        } else if (var2 == 13) {
            var3 = var1.readUByte();
            this.anIntArray691 = new int[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.anIntArray691[var4] = var1.readMediumInt();
            }
        }

    }

    public Model applySequence(Model var1, int var2) {
        var2 = this.frameIds[var2];
        AnimationFrameGroup var3 = Statics13.method870(var2 >> 16);
        var2 &= 65535;
        if (var3 == null) {
            return var1.method1291(true);
        }
        Model var4 = var1.method1291(!var3.method649(var2));
        var4.method1286(var3, var2);
        return var4;
    }

    public Model applyStanceAndAnimation(Model var1, int frame, AnimationSequence stance, int stanceFrame) {
        frame = this.frameIds[frame];
        AnimationFrameGroup var5 = Statics13.method870(frame >> 16);
        frame &= 65535;
        if (var5 == null) {
            return stance.applySequence(var1, stanceFrame);
        }
        stanceFrame = stance.frameIds[stanceFrame];
        AnimationFrameGroup var6 = Statics13.method870(stanceFrame >> 16);
        stanceFrame &= 65535;
        Model var7;
        if (var6 == null) {
            var7 = var1.method1291(!var5.method649(frame));
            var7.method1286(var5, frame);
            return var7;
        }
        var7 = var1.method1291(!var5.method649(frame) & !var6.method649(stanceFrame));
        var7.method1285(var5, frame, var6, stanceFrame, this.interleaveOrder);
        return var7;
    }

    public Model method877(Model var1, int var2, int var3) {
        var2 = this.frameIds[var2];
        AnimationFrameGroup var4 = Statics13.method870(var2 >> 16);
        var2 &= 65535;
        if (var4 == null) {
            return var1.method1291(true);
        }
        Model var5 = var1.method1291(!var4.method649(var2));
        var3 &= 3;
        if (var3 == 1) {
            var5.method981();
        } else if (var3 == 2) {
            var5.method1288();
        } else if (var3 == 3) {
            var5.method1283();
        }

        var5.method1286(var4, var2);
        if (var3 == 1) {
            var5.method1283();
        } else if (var3 == 2) {
            var5.method1288();
        } else if (var3 == 3) {
            var5.method981();
        }

        return var5;
    }

    public void method592() {
        if (this.animatingPrecedence == -1) {
            if (this.interleaveOrder != null) {
                this.animatingPrecedence = 2;
            } else {
                this.animatingPrecedence = 0;
            }
        }

        if (this.walkingPrecedence == -1) {
            if (this.interleaveOrder != null) {
                this.walkingPrecedence = 2;
            } else {
                this.walkingPrecedence = 0;
            }
        }

    }

    public Model method880(Model var1, int var2) {
        var2 = this.frameIds[var2];
        AnimationFrameGroup var3 = Statics13.method870(var2 >> 16);
        var2 &= 65535;
        if (var3 == null) {
            return var1.method1294(true);
        }
        Model var4 = var1.method1294(!var3.method649(var2));
        var4.method1286(var3, var2);
        return var4;
    }

    public void method260(Buffer var1) {
        while (true) {
            int var2 = var1.readUByte();
            if (var2 == 0) {
                return;
            }

            this.method259(var1, var2);
        }
    }

    public Model method879(Model var1, int var2) {
        int var3 = this.frameIds[var2];
        AnimationFrameGroup var4 = Statics13.method870(var3 >> 16);
        var3 &= 65535;
        if (var4 == null) {
            return var1.method1291(true);
        }
        AnimationFrameGroup var5 = null;
        int var6 = 0;
        if (this.anIntArray687 != null && var2 < this.anIntArray687.length) {
            var6 = this.anIntArray687[var2];
            var5 = Statics13.method870(var6 >> 16);
            var6 &= 65535;
        }

        Model var7;
        if (var5 != null && var6 != 65535) {
            var7 = var1.method1291(!var4.method649(var3) & !var5.method649(var6));
            var7.method1286(var4, var3);
            var7.method1286(var5, var6);
            return var7;
        }
        var7 = var1.method1291(!var4.method649(var3));
        var7.method1286(var4, var3);
        return var7;
    }
}
