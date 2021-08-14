import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from "@/views/Index";
import Login from "@/views/Login";
import * as R from './router-type'

Vue.use(VueRouter)

const routes = [
  {
    path: R.rIndex,
    name: 'Index',
    component: Index
  },
  {
    path: R.rLogin,
    name: 'Login',
    component: Login
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
