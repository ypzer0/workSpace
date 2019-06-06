import session from '@/libs/session'

const INACCESSIBLE_LOGIN_ROUTES = ['/y-login']

export const routerInterceptor = (router) => {
  router.beforeEach((to, from, next) => {
    // console.log("to:",to);
    if (to.matched.some(record => record.meta.requiresAuth)) {
      if (!session.isLogin()) {
        next({
          path: '/y-login',
          query: { redirect: to.fullPath }
        })
      } else {
        next()
      }
    } else {
      if (session.isLogin() && INACCESSIBLE_LOGIN_ROUTES.includes(to.path)) {
        next('/y-home')
      }
      next()
    }
  })
}
