package com.java.object;

/**
 * @version 1.0
 * @ProjectName: learning
 * @Package: com.java.object
 * @ClassName: Cells
 * @Description: default
 * @Author: Administrator
 * @CreateDate: 2019/12/7 13:04
 */
public class Cells implements Cloneable{
    private String nuclei;
    private String cytoplasm;

    /*@Override
    public Cells clone(){
        return new Cells();
    }*/

    public String getNuclei() {
        return nuclei;
    }

    public void setNuclei(String nuclei) {
        this.nuclei = nuclei;
    }

    public String getCytoplasm() {
        return cytoplasm;
    }

    public void setCytoplasm(String cytoplasm) {
        this.cytoplasm = cytoplasm;
    }
}
