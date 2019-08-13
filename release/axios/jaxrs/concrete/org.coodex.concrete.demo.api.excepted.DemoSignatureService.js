/* eslint-disable */
import {argumentsError, execute, overload} from '../concrete'

const module = 'concrete'

const DemoSignatureService = {
    'doSomeThing': function (a, kkk, pojo) {
        return execute(module, `/OrgCoodexConcreteDemoApiExceptedDemoSignatureService/doSomeThing`, 'json', 'POST', { a, kkk, pojo });
    }
}

export default DemoSignatureService


