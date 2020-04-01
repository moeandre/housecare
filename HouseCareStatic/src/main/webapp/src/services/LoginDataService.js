import http from "./http-common";

class LoginDataService {
  
  login(data) {
    return http.post("/api/rest/login", data);
  }

}

export default new LoginDataService
();