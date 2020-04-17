import http from "./http-common";

class FaturaDataService {
  
  getAll(idEmpresa) {
    return http.get(`/api/rest/empresa/${idEmpresa}/fatura/listar`);
  }

  get(idEmpresa, id) {
    return http.get(`/api/rest/empresa/${idEmpresa}/fatura/detalhar/${id}/`);
  }

  clonar(idEmpresa, id) {
    return http.put(`/api/rest/empresa/${idEmpresa}/fatura/clonar/${id}/`);
  }

}

export default new FaturaDataService();