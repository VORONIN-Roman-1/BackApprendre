<#macro login path isRegisterForm>
    <form action="${path}" method="post">
        <div class="mb-3">
            <label for="inputUsername" class="form-label"> User Name : </label>
            <input type="text" class="form-control ${(usernameError??)?string('is-invalid', '')}" id="inputUsername"
                   name="username" placeholder="User name" value="<#if user??>${user.username}</#if>"/>
            <#if usernameError??>
                <div class="invalid-feedback">
                    ${usernameError}
                </div>
            </#if>
        </div>
        <div class="mb-3">
            <label for="inputPassword" class="form-label"> Password:</label>
            <input type="password" class="form-control  ${(passwordError??)?string('is-invalid', '')}"
                   id="inputPassword" name="password" placeholder="Password"/>
            <#if passwordError??>
                <div class="invalid-feedback">
                    ${passwordError}
                </div>
            </#if>
        </div>
        <#if isRegisterForm>
            <div class="mb-3">
                <label for="inputPassword" class="form-label"> Password:</label>
                <input type="password" class="form-control  ${(password2Error??)?string('is-invalid', '')}"
                       id="inputPassword" name="password2" placeholder="Retype password"/>
                <#if password2Error??>
                    <div class="invalid-feedback">
                        ${password2Error}
                    </div>
                </#if>
            </div>
            <div class="mb-3">
                <label for="inputEmail" class="form-label"> Email:</label>
                <input type="email" class="form-control  ${(emailError??)?string('is-invalid', '')}" id="inputEmail"
                       name="email" placeholder="Email" value="<#if user??>${user.email}</#if>"/>
                <#if emailError??>
                    <div class="invalid-feedback">
                        ${emailError}
                    </div>
                </#if>
            </div>
        </#if>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <#if !isRegisterForm><a href="/registration">Add new user</a></#if>
        <button type="submit" class="btn btn-primary"><#if isRegisterForm>Create<#else >Sing In</#if></button>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" class="btn btn-primary">Sign Out</button>
    </form>
</#macro>
