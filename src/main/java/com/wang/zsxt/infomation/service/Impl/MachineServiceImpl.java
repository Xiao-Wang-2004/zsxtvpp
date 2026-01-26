package com.wang.zsxt.infomation.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.zsxt.infomation.dao.MachineDao;
import com.wang.zsxt.infomation.service.MachineService;
import com.wang.zsxt.pojo.infomation.MachinePojo;
import com.wang.zsxt.tool.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

@Service
public class MachineServiceImpl implements MachineService {

    @Autowired
    private MachineDao machineDao;

    @Override
    public Response<PageInfo<HashMap<String, Object>>> list(MachinePojo param) {

        if(param.getPage() != null && param.getSize() != null){
            PageHelper.startPage(param.getPage(), param.getSize());
        }

        List<HashMap<String, Object>> list = machineDao.list(param);

        return Response.success(PageInfo.of(list));
    }

    @Override
    public Response<String> update(MachinePojo param) {
        try{

            if(machineDao.getInfo(param) > 0){
                machineDao.updateInfo(param);
                return Response.success("修改成功");
            }else {
                machineDao.insertInfo(param);
                return Response.success("添加成功");
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.error("操作失败");
        }
    }

    @Override
    public Response<String> delete(MachinePojo param) {
        try {
            for (String machineid : param.getMachineids()) {
                if(machineDao.getInfo(machineid, param.getUserid()) > 0){
                    machineDao.deleteInfo(machineid, param.getUserid());
                }
            }
            return Response.success("删除成功");
         } catch (Exception e) {
            return Response.error("操作失败");
         }
        }

}
