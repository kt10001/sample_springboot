package com.shouxin.yy.utils;

import com.shouxin.yy.entity.VO.ChannelListVO;
import com.shouxin.yy.entity.VO.bg.IncomingListVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.util.List;

/**
 * @author wubaochun
 */
@Slf4j
public class ExcelUtil {

    public static String channelListExcel(List<ChannelListVO> channelListVOS, String finalFileName) {
        String fileName = finalFileName+".xlsx";
        try {
            // 创建新的Excel 工作簿
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 在Excel工作簿中建一工作表
            HSSFSheet sheetList = workbook.createSheet(finalFileName);

            // 明细 写抬头和数据
            String[] listNames = {"ID","手机号", "客户经理名称", "微信昵称", "微信头像", "上级ID", "上上级ID", "经理等级(1服务经理2高级经理3高级总监)",
                    "会员等级(1普通会员2超级会员)", "注册时间", "会员有效期至", "团队人数", "客户数量", "进件总额", "累计提现"};
            HSSFRow rowList = sheetList.createRow((short)0);
            for(int i=0; i < listNames.length; i++) {
                HSSFCell cell = rowList.createCell((short) i);
                cell.setCellValue(listNames[i]);
            }
            int i = 0;
            for(ChannelListVO channelListVO: channelListVOS) {
                i++;
                HSSFRow row = sheetList.createRow((short)i);
                HSSFCell listCell00 = row.createCell((short) 0);
                listCell00.setCellValue(channelListVO.getUuid());
                HSSFCell listCell01 = row.createCell((short) 1);
                listCell01.setCellValue(channelListVO.getPhone());
                HSSFCell listCell02 = row.createCell((short) 2);
                listCell02.setCellValue(channelListVO.getName());
                HSSFCell listCell03 = row.createCell((short) 3);
                listCell03.setCellValue(channelListVO.getWxName());
                HSSFCell listCell04 = row.createCell((short) 4);
                listCell04.setCellValue(channelListVO.getHeadUrl());
                HSSFCell listCell05 = row.createCell((short) 5);
                listCell05.setCellValue(channelListVO.getParentUuid());
                HSSFCell listCell06 = row.createCell((short) 6);
                listCell06.setCellValue(channelListVO.getSuperParentUuid());
                HSSFCell listCell07 = row.createCell((short) 7);
                listCell07.setCellValue(channelListVO.getManagerLevel() == null ? "" : channelListVO.getManagerLevel().toString());
                HSSFCell listCell08 = row.createCell((short) 8);
                listCell08.setCellValue(channelListVO.getLevel() == null ? "" : channelListVO.getLevel().toString());
                HSSFCell listCell09 = row.createCell((short) 9);
                listCell09.setCellValue(channelListVO.getCreateTime());
                HSSFCell listCell10 = row.createCell((short) 10);
                listCell10.setCellValue(channelListVO.getExpireTime());
                HSSFCell listCell11 = row.createCell((short) 11);
                listCell11.setCellValue(channelListVO.getTeamCount() == null ? "" : channelListVO.getTeamCount().toString());
                HSSFCell listCell12 = row.createCell((short) 12);
                listCell12.setCellValue(channelListVO.getUnUserCount() == null ? "" : channelListVO.getUnUserCount().toString());
                HSSFCell listCell13 = row.createCell((short) 13);
                listCell13.setCellValue(channelListVO.getSettlementAmount() == null ? "" : channelListVO.getSettlementAmount().toString());
                HSSFCell listCell14 = row.createCell((short) 14);
                listCell14.setCellValue(channelListVO.getAmount() == null ? "" : channelListVO.getAmount().toString());
            }

            // 新建 输出文件流
            FileOutputStream fileOut = new FileOutputStream(fileName);
            // 把相应的Excel 工作簿存盘
            workbook.write(fileOut);
            fileOut.flush();
            // 操作结束，关闭文件
            fileOut.close();
        } catch (Exception e) {
            log.error("create excel error: " + e);
        }
        return fileName;
    }

    public static String incomingListExcel(List<IncomingListVO> incomingListVOS, String finalFileName) {
        String fileName = finalFileName+".xlsx";
        try {
            // 创建新的Excel 工作簿
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 在Excel工作簿中建一工作表
            HSSFSheet sheetList = workbook.createSheet(finalFileName);

            // 明细 写抬头和数据
            String[] listNames = {"进件单号","产品种类(0-税金贷 1-发票贷 2-经营贷 3-个贷类 4-车抵贷 5-信用卡)", "产品名称", "产品机构", "客户", "客户经理ID", "进件时间",
                    "业务进度(0 贷款-已申请 | 1 贷款-授信中 |2 贷款-审批未通过 |3 贷款-授信通过 |4 贷款-已提款| 5信用卡-待审核 |6 信用卡-审核不通过| 7 信用卡-审核已通过)",
                    "授信金额", "放款金额", "结算金额", "结算方式(0-授信结算 1-放款结算 2-首刷自动结算 3-核卡自动结算)", "结算状态(0-未结算 1-已结算)"};
            HSSFRow rowList = sheetList.createRow((short)0);
            for(int i=0; i < listNames.length; i++) {
                HSSFCell cell = rowList.createCell((short) i);
                cell.setCellValue(listNames[i]);
            }
            int i = 0;
            for(IncomingListVO incomingListVO: incomingListVOS) {
                i++;
                HSSFRow row = sheetList.createRow((short)i);
                HSSFCell listCell00 = row.createCell((short) 0);
                listCell00.setCellValue(incomingListVO.getUuid());
                HSSFCell listCell01 = row.createCell((short) 1);
                listCell01.setCellValue(incomingListVO.getProductType() == null ? "" : incomingListVO.getProductType().toString());
                HSSFCell listCell02 = row.createCell((short) 2);
                listCell02.setCellValue(incomingListVO.getProductName());
                HSSFCell listCell03 = row.createCell((short) 3);
                listCell03.setCellValue(incomingListVO.getProductCompany());
                HSSFCell listCell04 = row.createCell((short) 4);
                listCell04.setCellValue(incomingListVO.getUnUserName());
                HSSFCell listCell05 = row.createCell((short) 5);
                listCell05.setCellValue(incomingListVO.getManagerUuid());
                HSSFCell listCell06 = row.createCell((short) 6);
                listCell06.setCellValue(incomingListVO.getCreateAt());
                HSSFCell listCell07 = row.createCell((short) 7);
                listCell07.setCellValue(incomingListVO.getProgress() == null ? "" : incomingListVO.getProgress().toString());
                HSSFCell listCell08 = row.createCell((short) 8);
                listCell08.setCellValue(incomingListVO.getCreditAmount() == null ? "" : incomingListVO.getCreditAmount().toString());
                HSSFCell listCell09 = row.createCell((short) 9);
                listCell09.setCellValue(incomingListVO.getLoanAmount() == null ? "" : incomingListVO.getLoanAmount().toString());
                HSSFCell listCell10 = row.createCell((short) 10);
                listCell10.setCellValue(incomingListVO.getSettlementAmount() == null ? "" : incomingListVO.getSettlementAmount().toString());
                HSSFCell listCell11 = row.createCell((short) 11);
                listCell11.setCellValue(incomingListVO.getSettlementType() == null ? "" : incomingListVO.getSettlementType().toString());
                HSSFCell listCell12 = row.createCell((short) 12);
                listCell12.setCellValue(incomingListVO.getSettlementStatus() == null ? "" : incomingListVO.getSettlementStatus().toString());
            }

            // 新建 输出文件流
            FileOutputStream fileOut = new FileOutputStream(fileName);
            // 把相应的Excel 工作簿存盘
            workbook.write(fileOut);
            fileOut.flush();
            // 操作结束，关闭文件
            fileOut.close();
        } catch (Exception e) {
            log.error("create excel error: " + e);
        }
        return fileName;
    }

}