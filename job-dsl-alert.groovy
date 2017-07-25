def REMOTE_URL = 'https://github.com/Shiva243/search'
job("search") {
    displayName('Search')
    wrappers {
        credentialsBinding {
            usernamePassword('ARTIFACTORY_USERNAME', 'ARTIFACTORY_PASSWORD', 'artifactory_credential')
        }
    }
    scm {
        git {
            remote {
                url("${REMOTE_URL}.git")
            }
            branch("master")
        }
    }
    triggers {
        scm('* * * * *') {
            ignorePostCommitHooks()
        }
    }
    steps {
        gradle {
            tasks('clean build')
        }
    }
}
