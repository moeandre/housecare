import http from "./http-common";

class FaturaDataService {
  
  getAll(idEmpresa) {
    return http.get(`/api/rest/empresa/${idEmpresa}/fatura/listar`);
  }

  get(idEmpresa, id) {
    return http.get(`/api/rest/empresa/${idEmpresa}/fatura/detalhar/${id}/`);
  }

}

export default new FaturaDataService();