import axios from "axios"
import nprogress from 'nprogress'

const user = JSON.parse(localStorage.getItem('user')) || []; 
const uuid = user.sessao.uuid || '';

const axiosInstance = axios.create({
  baseURL: "http://localhost/",
  headers: {
    "Content-type": "application/json",
    'user-token': uuid
  }
});

// before a request is made start the nprogress
axiosInstance.interceptors.request.use(config => {
  nprogress.start()
  return config
})

// before a response is returned stop nprogress
axiosInstance.interceptors.response.use(response => {
  nprogress.done()
  return response
})


export default axiosInstance;
