package com.xmg.wms.web.action;

import com.xmg.wms.domain.Product;
import com.xmg.wms.query.ProductQueryObject;
import com.xmg.wms.service.IBrandService;
import com.xmg.wms.service.IProductService;
import com.xmg.wms.util.FileUploadUtil;
import com.xmg.wms.util.RequiredPermission;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.io.File;

import static com.xmg.wms.util.FileUploadUtil.uploadFile;

public class ProductAction extends BaseAction {
    private static final long serialVersionUID = 1L;

    @Setter
    private IProductService productService;

    @Setter
    private IBrandService brandService;

    @Setter
    private File pic;//接收文件上传

    @Setter
    private String picFileName;//上传的文件名称


    @Getter
    private ProductQueryObject qo = new ProductQueryObject();

    @Getter@Setter
    private Product product = new Product();

    @RequiredPermission("商品管理列表")
    public String execute() {
        try {
            putContext("brands", brandService.list());
            putContext("result", productService.pageQuery(qo));
        } catch (Exception e) {
            e.printStackTrace();
            addActionError(e.getMessage());
        }
        return LIST;
    }

    @RequiredPermission("商品管理编辑")
    public String input() {
        try {
            putContext("brands", brandService.list());
            if (product.getId() != null) {
                product = productService.get(product.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            addActionError(e.getMessage());
        }
        return INPUT;
    }

    @RequiredPermission("商品管理保存/更新")
    public String saveOrUpdate() {
        try {
            if (product.getId() == null) {
                if (pic != null) {
                    String filePath = uploadFile(pic, picFileName);
                    product.setImagePath(filePath);

                }
                productService.save(product);
                addActionMessage("增加成功");

            } else {
                if (pic != null) {
                    Product temp = productService.get(this.product.getId());
                    if (StringUtils.isNotEmpty(temp.getImagePath())) {
                        FileUploadUtil.deleteFile(temp.getImagePath());
                    }
                    String filepath = FileUploadUtil.uploadFile(pic, picFileName);
                      addActionMessage("更新成功");
                }

            }

            /*if (product.getId() == null) {
                productService.save(product);
                addActionMessage("增加成功");
            } else {
                productService.update(product);
                addActionMessage("更新成功");
            }*/
        } catch (Exception e) {
            e.printStackTrace();
            addActionError(e.getMessage());
        }
        return SUCCESS;
    }

    @RequiredPermission("商品管理删除")
    public String delete() throws Exception {
        try {
            if (product.getId() != null) {

                //获取图片 那么就需要去服务器里卖你的路径下面器删除
                Product product = productService.get(this.product.getId());
                if (StringUtils.isNotEmpty(product.getImagePath())) {
                    FileUploadUtil.deleteFile(product.getImagePath());
                }

                productService.delete(this.product.getId());
                putMsg("删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            putMsg(e.getMessage());
        }
        return NONE;
    }

}
