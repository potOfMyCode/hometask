package adapter;

public class AdapterApp {
    public static void main(String[] args) {
        VectorGraphics v1 = new VectorAdapterFromRaster();
        v1.drawLine();
        v1.drawSquare();

        VectorGraphics v2 = new VectorAdapterFromRaster2(new RasterGraphics());
        v2.drawLine();
        v2.drawSquare();
    }
}

interface VectorGraphics{
    void drawLine();
    void drawSquare();
}

class RasterGraphics {
    void drawRasterLine(){
        System.out.println("draw line.");
    }
    void drawRasterSquare(){
        System.out.println("draw square.");
    }
}

class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphics{
    public void drawLine() {
        drawRasterLine();
    }
    public void drawSquare() {
        drawRasterSquare();
    }
}

class VectorAdapterFromRaster2 implements VectorGraphics{
    private RasterGraphics raster;
    VectorAdapterFromRaster2(RasterGraphics raster){
        this.raster = raster;
    }
    public void drawLine() {
        raster.drawRasterLine();
    }
    public void drawSquare() {
        raster.drawRasterSquare();
    }
}
