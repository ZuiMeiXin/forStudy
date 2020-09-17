<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>供应商管理页面 >> 供应商添加页面</span>
        </div>
        <div class="providerAdd">
           <fm:form modelAttribute="provider" enctype="multipart/form-data" id="providerForm" name="providerForm" method="post" action="${pageContext.request.contextPath }/provider/addproviderSave.html">
			<input type="hidden" name="method" value="add">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="proCode">供应商编码：</label>
                    <fm:input type="text" name="proCode" id="proCode" value="" path="proCode"/>
					<!-- 放置提示信息 -->
					<font color="red"></font><fm:errors path="proCode"/>
                </div>
                <div>
                    <label for="proName">供应商名称：</label>
                   <fm:input path="proName" type="text" name="proName" id="proName" value=""/>
					<font color="red"></font><fm:errors path="proName"/>
                </div>
                <div>
                    <label for="proContact">联系人：</label>
                    <fm:input path="proContact" type="text" name="proContact" id="proContact" value=""/>
					<font color="red"></font><fm:errors path="proContact"/>

                </div>
                <div>
                    <label for="proPhone">联系电话：</label>
                    <fm:input path="proPhone" type="text" name="proPhone" id="proPhone" value=""/>
					<font color="red"></font><fm:errors path="proPhone"/>
                </div>
                <div>
                    <label for="proAddress">联系地址：</label>
                    <fm:input path="proAddress" type="text" name="proAddress" id="proAddress" value=""/>
                </div>
                <div>
                    <label for="proFax">传真：</label>
                    <fm:input path="proFax" type="text" name="proFax" id="proFax" value=""/>
                </div>
                <div>
                    <label for="proDesc">描述：</label>
                    <fm:input path="proDesc" type="text" name="proDesc" id="proDesc" value=""/>
                </div>
               <div>
                   <label for="p_idPicPath">营业执照：</label>
                   <input type="file" name="p_idPicPath" id="p_idPicPath" value=""/>
                   <font color="red">${upLoadFileError}</font>
               </div>
               <div>
                   <label for="p_idPicPath">组织机构证件照：</label>
                   <input type="file" name="p_orgPicPath" id="p_orgPicPath" value=""/>
                   <font color="red">${upLoadOrgFileError}</font>
               </div>
                <div class="providerAddBtn">
                    <input type="button" name="add" id="add" value="保存">
					<input type="button" id="back" name="back" value="返回" >
                </div>
            </fm:form>
     </div>
</div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/provideradd.js"></script>
