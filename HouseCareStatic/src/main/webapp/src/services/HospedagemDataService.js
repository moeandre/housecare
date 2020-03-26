import http from "./http-common";

class HospedagemDataService {
  
  getAll() {
    return http.get("/api/rest/cliente/listar");
  }

  get(id) {
    return http.get(`/api/rest/cliente/${id}`);
  }

  create(data) {
    return http.post("/api/rest/cliente", data);
  }

  update(id, data) {
    return http.put(`/api/rest/cliente/${id}`, data);
  }

  delete(id) {
    return http.delete(`/api/rest/cliente/${id}`);
  }

}

export default new HospedagemDataService();