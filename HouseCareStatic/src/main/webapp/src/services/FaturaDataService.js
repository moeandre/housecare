import http from "./http-common";

class FaturaDataService {
  
  getAll(idEmpresa) {
    return http.get(`/api/rest/empresa/${idEmpresa}/fatura/listar`);
  }

  getByMesAno(idEmpresa,mesano) {
    return http.get(`/api/rest/empresa/${idEmpresa}/fatura/listar/${mesano}/`);
  }

  get(idEmpresa, id) {
    return http.get(`/api/rest/empresa/${idEmpresa}/fatura/detalhar/${id}/`);
  }

  clonar(idEmpresa, id) {
    return http.put(`/api/rest/empresa/${idEmpresa}/fatura/clonar/${id}/`);
  }

  dash(idEmpresa, mesano) {
    return http.get(`/api/rest/empresa/${idEmpresa}/fatura/dash/${mesano}/`);
  }

}

export default new FaturaDataService();