import LoginDataService from "../../services/LoginDataService";
import router from "../../router";

const user = JSON.parse(localStorage.getItem('user'));
const state = user
    ? { status: { loggedIn: true }, user }
    : { status: {}, user: null };

const actions = {
    loginRequest({ dispatch, commit }, loginForm) {
        
        commit('loginRequest', loginForm.user);
 
        LoginDataService.login(loginForm)
            .then(response => {
                if (!response.data.account) {
                    commit('loginFailure', 'Incorrect credentials.');
                    console.log('Incorrect credentials.');
                } else {
                    localStorage.setItem('user', JSON.stringify(response.data.account));
                    commit('loginSuccess', response.data.account);
                    router.push('/');
                }
            })
            .catch(e => {
                commit('loginFailure', e);
             });
    },
    logoutRequest({ commit }) {
        localStorage.removeItem('user');
        commit('logout');
    }
}

const mutations = {
    loginRequest(state, user) {
        state.status = { loggingIn: true };
        state.user = user;
    },
    loginSuccess(state, user) {
        state.status = { loggedIn: true };
        state.user = user;
    },
    loginFailure(state) {
        state.status = {};
        state.user = null;
    },
    logout(state) {
        state.status = {};
        state.user = null;
    }
}

export const account = {
    namespaced: true,
    state,
    actions,
    mutations
};

export default account;
