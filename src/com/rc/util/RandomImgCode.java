package com.rc.util;

/*
 * Title: RandomImgCode.java
 * Description:  
 * Usage: <script>document.write("<img border=0 src=RandomImgCode?rand="+Math.random()*10000+">");</script>
 * Date: 2004-2-2 8:47:48
 * @author: Bright.Wu
 * @version: 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import java.util.*; 
import com.sun.image.codec.jpeg.*;
//import javax.imageio.*;

public class RandomImgCode extends BaseAction {

    private static final long serialVersionUID = 1L;

    /**
     * 生成随机颜色
     *
     * @param ll 产生颜色值下限(lower limit)
     * @param ul 产生颜色值上限(upper limit)
     * @return 生成的随机颜色对象
     */
    private Color getRandColor(int ll, int ul) {
        Random random = new Random();
        if (ll > 255) ll = 255;
        if (ll < 1) ll = 1;
        if (ul > 255) ul = 255;
        if (ul < 1) ul = 1;
        if (ul == ll) ul = ll + 1;
        int r = random.nextInt(ul - ll) + ll;
        int g = random.nextInt(ul - ll) + ll;
        int b = random.nextInt(ul - ll) + ll;
        Color color = new Color(r, g, b);
        return color;
    }


    private Color getRandColors() {
        //String num = String.valueOf(Math.random() * 5);
        Random random = new Random();
        int num=random.nextInt(5);
        Color color = null;
        switch (num) {
            case 0:
                color = new Color(0, 0, 0);
                break;
            case 1:
                color = new Color(220, 20, 60);
                break;
            case 2:
                color = new Color(75, 0, 130);
                break;
            case 3:
                color = new Color(0, 0, 128);
                break;
            default:
                color = new Color(47, 79, 79);
                break;
        }
        return color;
    }


     

    public String execute() throws Exception {
        
        //int width = 42;
        int width = 50;
        int height = 20;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        
        Graphics g = image.getGraphics();

        
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);

        
        //g.setColor(Color.black);
        //g.drawRect(0, 0, width - 1, height - 1);

        
        //String rand = request.getParameter("rand");
        //rand = rand.substring(0, rand.indexOf("."));
        String rand = String.valueOf(Math.random() * 100000);
        rand = rand.substring(0, rand.indexOf("."));
        switch (rand.length()) {
            case 1:
                rand = "0000" + rand;
                break;
            case 2:
                rand = "000" + rand;
                break;
            case 3:
                rand = "00" + rand;
                break;
            case 4:
                rand = "0" + rand;
                break;
            default:
                rand = rand.substring(0, 5);
                break;
        }

        // SESSION
        HttpSession session = request.getSession(true);
        session.setAttribute("rand", rand);
        
        //g.setColor(Color.red);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 20));


        g.drawString(rand, 3, 16);


        //画字符串
        for (int i = 0; i < rand.length(); i++) {
            String temp = rand.substring(i, i + 1);
            g.setColor(getRandColors());
            g.drawString(temp, 9 * i, 16);
        }


        
        Random random = new Random();
        g.setColor(getRandColors());
        for (int i = 0; i < 120; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            g.drawLine(x, y, x, y);
        }


        
        g.dispose();

        // Set the content-type header
        response.setHeader("Cache-Control", "no-store");
        response.setContentType("image/JPEG");

        
        OutputStream out = response.getOutputStream();
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        encoder.encode(image);
        out.close();

        //ImageIO.write(image, "JPEG", response.getOutputStream());
        return null;
    }
 
}
