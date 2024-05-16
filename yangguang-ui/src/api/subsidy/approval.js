import request from '@/utils/request'

// 查询补贴审批列表
export function listApproval(query) {
  return request({
    url: '/subsidy/approval/list',
    method: 'get',
    params: query
  })
}

// 查询补贴审批详细
export function getApproval(approvalId) {
  return request({
    url: '/subsidy/approval/' + approvalId,
    method: 'get'
  })
}

// 新增补贴审批
export function addApproval(data) {
  return request({
    url: '/subsidy/approval',
    method: 'post',
    data: data
  })
}

// 修改补贴审批
export function updateApproval(data) {
  return request({
    url: '/subsidy/approval',
    method: 'put',
    data: data
  })
}

// 删除补贴审批
export function delApproval(approvalId) {
  return request({
    url: '/subsidy/approval/' + approvalId,
    method: 'delete'
  })
}
