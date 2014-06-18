package instrucoes;
import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;
		
public class INCF extends Instrucao{
	/***
	 *  Inicia a instru��o 
	 * comando 0010 10df ffff
	 */
	@Override
	public void setup(String comando){
		setD(Integer.parseInt(comando.substring(6,7),2));
		setF(Integer.parseInt(comando.substring(7),2)); 
	}

	/***
	 *  Os conte�dos do registro 'f' s�o incrementados
	 *  Se o bit 'd' � '0', o resultado � colocado no registro 'W'
	 *  Se o bit 'd' � '1', o resultado � colocado de volta no registro 'f'
	 */
	public void run(Memoria mem, CPU cpu){
		 
		byte novoF = mem.get(f);
		novoF ++;
		mem.set(f,novoF);
		
		if (this.d == 0){			
			cpu.setW(novoF);			
		}
		
		else {			
			mem.set(f,novoF);			
		}
			
		mem.setPCL((byte) (mem.getPCL() + 1));
	}
}