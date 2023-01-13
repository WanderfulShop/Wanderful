<%@page import="com.codeup.adlister.models.User"%>


<nav class="navbar navbar-expand-lg navbar-light text-white bg-dark">

        <a class="navbar-brand ms-1 m-auto text-light" href="/">Wanderful</a>
<%--       Redirect this Link below to wands page       --%>
        <a class="nav-link m-auto" href="/ads">Wands</a>
<%--       Allow the user to Login/redirect to user page       --%>
        <a class="nav-link m-auto" href="/login">Login</a>
<%-- Find Uers on Home page --%>
        <div>
            <form class="form-inline my-2 my-lg-0 ms-auto" role="search" method="post" action="search/usersearch">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon1">@</span>
                    </div>
                    <input type="text" name="username" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                </div>
            </form>
        </div>

</nav>