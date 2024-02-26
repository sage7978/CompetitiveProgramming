// Problem: Namit In Trouble
// Contest: SPOJ - Classical
// URL: https://www.spoj.com/problems/NGIRL/
// Memory Limit: 1536 MB
// Time Limit: 100 ms
// Edited By - Satish Kumar Patra
// 
// Powered by CP Editor (https://cpeditor.org)
// status - accepted, cpp, sieve, prefix sum

#include <bits/stdc++.h>

using namespace std;

template<typename A, typename B> ostream& operator<<(ostream &os, const pair<A, B> &p) { return os << '(' << p.first << ", " << p.second << ')'; }
template<typename T_container, typename T = typename enable_if<!is_same<T_container, string>::value, typename T_container::value_type>::type> ostream& operator<<(ostream &os, const T_container &v) { os << '{'; string sep; for (const T &x : v) os << sep << x, sep = ", "; return os << '}'; }
void dbg_out() { cerr << endl; }
template<typename Head, typename... Tail> void dbg_out(Head H, Tail... T) { cerr << ' ' << H; dbg_out(T...); }
#ifdef LOCAL
#define dbg(...) cerr << "(" << #__VA_ARGS__ << "):", dbg_out(__VA_ARGS__)
#else
#define dbg(...)
#endif

#define ar array
#define ll long long
#define ld long double
#define sza(x) ((int)x.size())
#define all(a) (a).begin(), (a).end()

const int MAX_N = 1e5 + 5;
const ll MOD = 1e9 + 7;
const ll INF = 1e9;
const ld EPS = 1e-9;

static int N = 100000+1;

void solve() {
    int t;
    cin >> t;
    vector<long long> nn(t), kk(t);
    
    for (int i = 0; i < t; i++) {
        cin >> nn[i] >> kk[i];
    }
    
    vector<int> prime(N, 1);
    prime[0] = prime[1] = 0;
    
    for (int i = 2; i * i < N; i++) {
        if (prime[i] == 0) {
            continue;
        }
        for (int j = i * i; j < N; j += i) {
            prime[j] = 0;
        }
    }
    
    vector<int> prefix(N);
    for (int i = 1; i < N; i++) {
        prefix[i] = prefix[i - 1] + prime[i];
    }
    
    for (int i = 0; i < t; i++) {
        nn[i] = (long long)sqrt(nn[i]);
        kk[i] = (long long)sqrt(kk[i]);
        cout << prefix[nn[i]] << " " << max(prefix[nn[i]] - prefix[kk[i]], 0) << endl;
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    int tc = 1;
    // cin >> tc;
    for (int t = 1; t <= tc; t++) {
        // cout << "Case #" << t << ": ";
        solve();
    }
}