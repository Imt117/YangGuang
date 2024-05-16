<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="申请人员ID" prop="applicantUserId">
        <el-input
          v-model="queryParams.applicantUserId"
          placeholder="请输入申请人员ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="申请人姓名" prop="applicantName">
        <el-input
          v-model="queryParams.applicantName"
          placeholder="请输入申请人姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="补贴类型" prop="projectId">
        <el-select v-model="queryParams.projectId" placeholder="请选择补贴" clearable :style="{width: '100%'}">
          <el-option v-for="(item, index) in projectIdOptions" :key="index" :label="item.label"
                     :value="item.value" :disabled="item.disabled"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="身份证号码" prop="applicantIdNo">
        <el-input
          v-model="queryParams.applicantIdNo"
          placeholder="请输入身份证号码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="性别" prop="applicantGender">
        <el-select v-model="queryParams.applicantGender" placeholder="请选择性别" clearable>
          <el-option
            v-for="dict in dict.type.sys_user_sex"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="申请日期" prop="applicationDate">
        <el-date-picker clearable
                        v-model="queryParams.applicationDate"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="请选择申请日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['subsidy:application:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['subsidy:application:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['subsidy:application:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['subsidy:application:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="applicationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="申请ID" align="center" prop="applicationId" />
      <el-table-column label="申请人员ID" align="center" prop="applicantUserId" />
      <el-table-column label="项目ID" align="center" prop="projectId" />
      <el-table-column label="申请状态" align="center" prop="applicationStatus" />
      <el-table-column label="申请人姓名" align="center" prop="applicantName" />
      <el-table-column label="身份证号码" align="center" prop="applicantIdNo" />
      <el-table-column label="性别" align="center" prop="applicantGender">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_user_sex" :value="scope.row.applicantGender"/>
        </template>
      </el-table-column>
      <el-table-column label="人员类别" align="center" prop="applicantType" />
      <el-table-column label="上传材料" align="center" prop="uploadedFiles" />
      <el-table-column label="申请日期" align="center" prop="applicationDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.applicationDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['subsidy:application:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['subsidy:application:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改补贴申请对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="申请人员ID" prop="applicantUserId">
          <el-input v-model="form.applicantUserId" placeholder="请输入申请人员ID" />
        </el-form-item>
        <el-form-item label="补贴类型" prop="projectId">
          <el-select v-model="form.projectId" placeholder="请选择补贴" clearable :style="{width: '100%'}">
            <el-option v-for="(item, index) in projectIdOptions" :key="index" :label="item.label"
                       :value="item.value" :disabled="item.disabled"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="申请人姓名" prop="applicantName">
          <el-input v-model="form.applicantName" placeholder="请输入申请人姓名" />
        </el-form-item>
        <el-form-item label="身份证号码" prop="applicantIdNo">
          <el-input v-model="form.applicantIdNo" placeholder="请输入身份证号码" :maxlength="18"/>
        </el-form-item>
        <el-form-item label="性别" prop="applicantGender">
          <el-radio-group v-model="form.applicantGender">
            <el-radio
              v-for="dict in dict.type.sys_user_sex"
              :key="dict.value"
              :label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
          <el-form-item label="人员类别" prop="applicantType">
            <el-cascader v-model="form.applicantType" :options="applicantTypeOptions"
                         :props="applicantTypeProps" :style="{width: '100%'}" placeholder="请选择人员类别" clearable></el-cascader>
          </el-form-item>
        </el-form-item>
        <el-form-item label="上传材料" prop="uploadedFiles">
          <file-upload v-model="form.uploadedFiles"/>
        </el-form-item>
        <el-form-item label="申请日期" prop="applicationDate">
          <el-date-picker clearable
                          v-model="form.applicationDate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择申请日期">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listApplication, getApplication, delApplication, addApplication, updateApplication } from "@/api/subsidy/application";

export default {
  name: "Application",
  dicts: ['sys_user_sex'],
  data() {
    return {
      //补贴ID与补贴名称转换
      formData: {
        projectId: '',
      },
      projectIdOptions: [{
        "label": "耕地地力保护补贴",
        "value": 1
      }, {
        "label": "义务教育补贴",
        "value": 2
      }],
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 补贴申请表格数据
      applicationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        applicantUserId: null,
        projectId: null,
        applicationStatus: null,
        applicantName: null,
        applicantIdNo: null,
        applicantGender: null,
        applicantType: null,
        uploadedFiles: null,
        applicationDate: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        applicantUserId: [
          { required: true, message: "申请人员ID不能为空", trigger: "blur" }
        ],
        projectId: [
          { required: true, message: "补贴项目不能为空", trigger: "change" }
        ],
        applicationStatus: [
          { required: true, message: "申请状态不能为空", trigger: "change" }
        ],
        applicantName: [
          { required: true, message: "申请人姓名不能为空", trigger: "blur" }
        ],
        applicantIdNo: [
          { required: true, message: "身份证号码不能为空", trigger: "blur" },
          {pattern: /^[1-9]\d{5}(18|19|20)\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/,message: '身份证格式错误',trigger: 'blur'}
        ],
        applicantGender: [
          { required: true, message: "性别不能为空", trigger: "change" }
        ],
        applicantType: [
          { required: true, type: 'array',message: "人员类别不能为空", trigger: "change" }
        ],
        applicationDate: [
          { required: true, message: "申请日期不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询补贴申请列表 */
    getList() {
      this.loading = true;
      listApplication(this.queryParams).then(response => {
        this.applicationList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        applicationId: null,
        applicantUserId: null,
        projectId: null,
        applicationStatus: null,
        applicantName: null,
        applicantIdNo: null,
        applicantGender: null,
        applicantType: null,
        uploadedFiles: null,
        applicationDate: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.applicationId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加补贴申请";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const applicationId = row.applicationId || this.ids
      getApplication(applicationId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改补贴申请";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.applicationId != null) {
            updateApplication(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addApplication(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const applicationIds = row.applicationId || this.ids;
      this.$modal.confirm('是否确认删除补贴申请编号为"' + applicationIds + '"的数据项？').then(function() {
        return delApplication(applicationIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('subsidy/application/export', {
        ...this.queryParams
      }, `application_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
