package cn.standard.controller;

import cn.standard.dao.SendbillMapper;
import cn.standard.pojo.Sendbill;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;
import java.util.List;
@Controller
public class Export {
    @Autowired
    private SendbillMapper sendbillMapper;
    @SuppressWarnings("resource")
    @RequestMapping("/export")
    public void exportExcel(HttpServletResponse response, HttpSession session, String name) throws Exception {
        List<Sendbill> list = sendbillMapper.selectBySendnum();
       String[] tableHeaders = {"序号", "发货日期", "起站","到站", "发货单号", "发货人","收货人", "发货人电话", "收货人电话","货物名字", "运费", "付款方式","送货方式", "货物状态"};

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sheet1");
        HSSFCellStyle cellStyle = workbook.createCellStyle();

        Font font = workbook.createFont();
        font.setColor(HSSFColor.RED.index);
        cellStyle.setFont(font);

        // 将第一行的三个单元格给合并
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 2));
        HSSFRow row = sheet.createRow(0);
        HSSFCell beginCell = row.createCell(0);
        beginCell.setCellValue("货单信息表");
        beginCell.setCellStyle(cellStyle);

        row = sheet.createRow(1);
        // 创建表头
        for (int i = 0; i < tableHeaders.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(tableHeaders[i]);
            cell.setCellStyle(cellStyle);
        }


        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow(i + 2);

            Sendbill sendbill = list.get(i);
            row.createCell(0).setCellValue((i+1));
            row.createCell(1).setCellValue(sendbill.getSenddate());
            row.createCell(2).setCellValue(sendbill.getStart());
            row.createCell(3).setCellValue(sendbill.getEnd());
            row.createCell(4).setCellValue(sendbill.getSendnum());
            row.createCell(5).setCellValue(sendbill.getSender());
            row.createCell(6).setCellValue(sendbill.getTaker());
            row.createCell(7).setCellValue(sendbill.getSerderphone());
            row.createCell(8).setCellValue(sendbill.getTakerphone());
            row.createCell(9).setCellValue(sendbill.getGoods());
            row.createCell(11).setCellValue(sendbill.getPaytype());
            row.createCell(12).setCellValue(sendbill.getSendtype());
            row.createCell(13).setCellValue(sendbill.getGoodsname());
        }

        OutputStream outputStream = response.getOutputStream();
        response.reset();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=template.xls");

        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
