package entreprise;

public aspect AspectMenu {
	pointcut TryParse(IMenu a, String b): args(b) && target(a)
	&& execution(boolean IMenu.choixMenu(String));
	
	boolean around(IMenu a, String b): TryParse(a,b)
	{
		System.out.println(b);
		try 
		{
			Integer.parseInt(b);
			return proceed(a,b);
		}catch (Exception e) 
		{
			System.out.println("Veuiller entrer une valeur valide");
			return false;
		}
		
	}
	
	before(): execution(void IMenu.afficheMenu())
	{
		System.out.println("**********************************************");
	}
	after(): execution(void IMenu.afficheMenu())
	{
		System.out.println("**********************************************");
	}
}