import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class aoh extends aow {

    private final Minecraft a;
    private final List b = new ArrayList();
    private final List c = new ArrayList();
    public int d = 0; // ImprovedChat private -> public
    private boolean e = false;


    public aoh(Minecraft var1) {
        this.a = var1;
    }

    public void a(int var1) {
        /*
        if (this.a.y.n != 2) {
            byte var2 = 10;
            boolean var3 = false;
            int var4 = 0;
            int var5 = this.c.size();
            float var6 = this.a.y.r * 0.9F + 0.1F;
            if (var5 > 0) {
                if (this.d()) {
                    var2 = 20;
                    var3 = true;
                }

                int var7;
                int var9;
                int var12;
                for (var7 = 0; var7 + this.d < this.c.size() && var7 < var2; ++var7) {
                    and var8 = (and) this.c.get(var7 + this.d);
                    if (var8 != null) {
                        var9 = var1 - var8.b();
                        if (var9 < 200 || var3) {
                            double var10 = (double) var9 / 200.0D;
                            var10 = 1.0D - var10;
                            var10 *= 10.0D;
                            if (var10 < 0.0D) {
                                var10 = 0.0D;
                            }

                            if (var10 > 1.0D) {
                                var10 = 1.0D;
                            }

                            var10 *= var10;
                            var12 = (int) (255.0D * var10);
                            if (var3) {
                                var12 = 255;
                            }

                            var12 = (int) ((float) var12 * var6);
                            ++var4;
                            if (var12 > 3) {
                                byte var13 = 3;
                                int var14 = -var7 * 9;
                                a(var13, var14 - 1, var13 + 320 + 4, var14 + 8, var12 / 2 << 24);
                                GL11.glEnable(3042);
                                String var15 = var8.a();
                                if (!this.a.y.o) {
                                    var15 = io.a(var15);
                                }

                                this.a.p.a(var15, var13, var14, 16777215 + (var12 << 24));
                            }
                        }
                    }
                }

                if (var3) {
                    var7 = this.a.p.b;
                    GL11.glTranslatef(0.0F, (float) var7, 0.0F);
                    int var16 = var5 * var7 + var5;
                    var9 = var4 * var7 + var4;
                    int var17 = this.d * var9 / var5;
                    int var11 = var9 * var9 / var16;
                    if (var16 != var9) {
                        var12 = var17 > 0 ? 170 : 96;
                        int var18 = this.e ? 13382451 : 3355562;
                        a(0, -var17, 2, -var17 - var11, var18 + (var12 << 24));
                        a(2, -var17, 1, -var17 - var11, 13421772 + (var12 << 24));
                    }
                }

            }
        } */
        if (this.a.y.n != 2) {
            byte var2 = ImprovedChat.ChatLinesSmall;
            boolean var3 = false;
            int var4 = 0;
            int var5 = getImprovedLines().size();
            float var6 = this.a.y.r * 0.9F + 0.1F;


            int var7, var9, var12;

            if (this.d()) {
                var2 = ImprovedChat.ChatLinesBig; /* ChatLinesBig */
                var3 = true;
            }

            var4 = ImprovedChat.handle_draw(this, a.p, var3, var2, var1);

            if (var3) {
                var7 = this.a.p.b;
                GL11.glTranslatef(0.0F, (float) var7, 0.0F);
                int var16 = var5 * var7 + var5;
                var9 = var4 * var7 + var4;
                int var17 = this.d * var9 / var5;
                int var11 = var9 * var9 / var16;
                if (var16 != var9) {
                    var12 = var17 > 0 ? 170 : 96;
                    int var18 = this.e ? 13382451 : 3355562;
                    a(0, -var17, 2, -var17 - var11, var18 + (var12 << 24));
                    a(2, -var17, 1, -var17 - var11, 13421772 + (var12 << 24));
                }
            }
        }
    }

    public void a() {
        this.c.clear();
        this.b.clear();
    }

    public void a(String var1) {
        this.a(var1, 0);
    }

    public void a(String var1, int var2) {
        /*
        boolean var3 = this.d();
        boolean var4 = true;
        if (var2 != 0) {
            this.c(var2);
        }

        Iterator var5 = this.a.p.c(var1, 320).iterator();

        while (var5.hasNext()) {
            String var6 = (String) var5.next();
            if (var3 && this.d > 0) {
                this.e = true;
                this.b(1);
            }

            if (!var4) {
                var6 = " " + var6;
            }

            var4 = false;
            this.c.add(0, new and(this.a.v.c(), var6, var2));
        }

        while (this.c.size() > 100) {
            this.c.remove(this.c.size() - 1);
        }
        */
        // System.out.println("var1 : "+var1+" var2 : "+var2);
        if(var2 != 0)
            this.c(var2);


        ImprovedChat.receiveLine(var1, this.a.v.c(), var2);
    }

    public List b() {
        return this.b;
    }

    public void b(String var1) {
        if (this.b.isEmpty() || !((String) this.b.get(this.b.size() - 1)).equals(var1)) {
            this.b.add(var1);
        }

    }

    public void c() {
        this.d = 0;
        this.e = false;
    }

    public void b(int var1) {
        this.d += var1;
        // int var2 = this.c.size();
        int var2 = getImprovedLines().size();
        if (this.d > var2 - 20) {
            this.d = var2 - 20;
        }

        if (this.d <= 0) {
            this.d = 0;
            this.e = false;
        }

        ImprovedChat.currentTab().chatScroll = this.d;

    }

    public aox a(int var1, int var2) {
        if (!this.d()) {
            return null;
        } else {
            apn var3 = new apn(this.a.y, this.a.c, this.a.d);
            int var4 = var3.e();
            int var5 = var1 / var4 - 3;
            int var6 = var2 / var4 - 40;
            if (var5 >= 0 && var6 >= 0) {
                int var7 = Math.min(ImprovedChat.ChatLinesBig, getImprovedLines().size());
                if (var5 <= 320 && var6 < this.a.p.b * var7 + var7) {
                    int var8 = var6 / (this.a.p.b + 1) + this.d;
                    return new aox(this.a.p, (and) getImprovedLines().get(var8), var5, var6 - (var8 - this.d) * this.a.p.b + var8);
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
    }

    public void a(String var1, Object... var2) {
        this.a(ak.a().a(var1, var2));
    }

    public boolean d() {
        return this.a.r instanceof aoj;
    }

    public void c(int var1) {
        Iterator var2 = this.c.iterator();

        and var3;
        do {
            if (!var2.hasNext()) {
                return;
            }

            var3 = (and) var2.next();
        } while (var3.c() != var1);

        var2.remove();
    }

    private List<and> getImprovedLines() {
        return ImprovedChat.currentTab().e;
    }

}