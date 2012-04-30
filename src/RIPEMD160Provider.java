import java.security.AccessController;
import java.security.Provider;


@SuppressWarnings("serial")
public final class RIPEMD160Provider extends Provider{
	private static final String INFO="RIPEMD (implements RIPEMD 160)";
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected RIPEMD160Provider() {
		super("RIPEMD160", 0.1, INFO);

		AccessController.doPrivileged(new java.security.PrivilegedAction() {
            public Object run() {
            	put("MessageDigest.RIPEMD", "impl.krypt.ripemd.RIPEMD160Digest");
            	
            	//Hook in Aliases
            	put("Alg.Alias.MessageDigest.RIPEMD-160", "RIPEMD");
                put("Alg.Alias.MessageDigest.RIPEMD160", "RIPEMD");
            	return null;
            }
            
		});
		
	}

}
