/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.puntoventa.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.puntoventa.util.ReciboPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.ReciboPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.ReciboPuntoVentaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;



import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ReciboPuntoVentaConstantesFunciones extends ReciboPuntoVentaConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="ReciboPuntoVenta";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ReciboPuntoVenta"+ReciboPuntoVentaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ReciboPuntoVentaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ReciboPuntoVentaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ReciboPuntoVentaConstantesFunciones.SCHEMA+"_"+ReciboPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ReciboPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ReciboPuntoVentaConstantesFunciones.SCHEMA+"_"+ReciboPuntoVentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ReciboPuntoVentaConstantesFunciones.SCHEMA+"_"+ReciboPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ReciboPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ReciboPuntoVentaConstantesFunciones.SCHEMA+"_"+ReciboPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ReciboPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ReciboPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ReciboPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ReciboPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ReciboPuntoVentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ReciboPuntoVentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ReciboPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ReciboPuntoVentaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ReciboPuntoVentaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ReciboPuntoVentaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Recibo Punto Ventas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Recibo Punto Venta";
	public static final String SCLASSWEBTITULO_LOWER="Recibo Punto Venta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ReciboPuntoVenta";
	public static final String OBJECTNAME="recibopuntoventa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="recibo_punto_venta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select recibopuntoventa from "+ReciboPuntoVentaConstantesFunciones.SPERSISTENCENAME+" recibopuntoventa";
	public static String QUERYSELECTNATIVE="select "+ReciboPuntoVentaConstantesFunciones.SCHEMA+"."+ReciboPuntoVentaConstantesFunciones.TABLENAME+".id,"+ReciboPuntoVentaConstantesFunciones.SCHEMA+"."+ReciboPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+ReciboPuntoVentaConstantesFunciones.SCHEMA+"."+ReciboPuntoVentaConstantesFunciones.TABLENAME+".id_cliente,"+ReciboPuntoVentaConstantesFunciones.SCHEMA+"."+ReciboPuntoVentaConstantesFunciones.TABLENAME+".id_banco,"+ReciboPuntoVentaConstantesFunciones.SCHEMA+"."+ReciboPuntoVentaConstantesFunciones.TABLENAME+".valor_efectivo,"+ReciboPuntoVentaConstantesFunciones.SCHEMA+"."+ReciboPuntoVentaConstantesFunciones.TABLENAME+".valor_cheque,"+ReciboPuntoVentaConstantesFunciones.SCHEMA+"."+ReciboPuntoVentaConstantesFunciones.TABLENAME+".numero_cheque,"+ReciboPuntoVentaConstantesFunciones.SCHEMA+"."+ReciboPuntoVentaConstantesFunciones.TABLENAME+".fecha from "+ReciboPuntoVentaConstantesFunciones.SCHEMA+"."+ReciboPuntoVentaConstantesFunciones.TABLENAME;//+" as "+ReciboPuntoVentaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ReciboPuntoVentaConstantesFuncionesAdditional recibopuntoventaConstantesFuncionesAdditional=null;
	
	public ReciboPuntoVentaConstantesFuncionesAdditional getReciboPuntoVentaConstantesFuncionesAdditional() {
		return this.recibopuntoventaConstantesFuncionesAdditional;
	}
	
	public void setReciboPuntoVentaConstantesFuncionesAdditional(ReciboPuntoVentaConstantesFuncionesAdditional recibopuntoventaConstantesFuncionesAdditional) {
		try {
			this.recibopuntoventaConstantesFuncionesAdditional=recibopuntoventaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDBANCO= "id_banco";
    public static final String VALOREFECTIVO= "valor_efectivo";
    public static final String VALORCHEQUE= "valor_cheque";
    public static final String NUMEROCHEQUE= "numero_cheque";
    public static final String FECHA= "fecha";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDBANCO= "Banco";
		public static final String LABEL_IDBANCO_LOWER= "Banco";
    	public static final String LABEL_VALOREFECTIVO= "Valor Efectivo";
		public static final String LABEL_VALOREFECTIVO_LOWER= "Valor Efectivo";
    	public static final String LABEL_VALORCHEQUE= "Valor Cheque";
		public static final String LABEL_VALORCHEQUE_LOWER= "Valor Cheque";
    	public static final String LABEL_NUMEROCHEQUE= "Numero Cheque";
		public static final String LABEL_NUMEROCHEQUE_LOWER= "Numero Cheque";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
	
		
		
		
		
		
		
	public static final String SREGEXNUMERO_CHEQUE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CHEQUE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getReciboPuntoVentaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ReciboPuntoVentaConstantesFunciones.IDCLIENTE)) {sLabelColumna=ReciboPuntoVentaConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(ReciboPuntoVentaConstantesFunciones.IDBANCO)) {sLabelColumna=ReciboPuntoVentaConstantesFunciones.LABEL_IDBANCO;}
		if(sNombreColumna.equals(ReciboPuntoVentaConstantesFunciones.VALOREFECTIVO)) {sLabelColumna=ReciboPuntoVentaConstantesFunciones.LABEL_VALOREFECTIVO;}
		if(sNombreColumna.equals(ReciboPuntoVentaConstantesFunciones.VALORCHEQUE)) {sLabelColumna=ReciboPuntoVentaConstantesFunciones.LABEL_VALORCHEQUE;}
		if(sNombreColumna.equals(ReciboPuntoVentaConstantesFunciones.NUMEROCHEQUE)) {sLabelColumna=ReciboPuntoVentaConstantesFunciones.LABEL_NUMEROCHEQUE;}
		if(sNombreColumna.equals(ReciboPuntoVentaConstantesFunciones.FECHA)) {sLabelColumna=ReciboPuntoVentaConstantesFunciones.LABEL_FECHA;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
			
			
	
	public static String getReciboPuntoVentaDescripcion(ReciboPuntoVenta recibopuntoventa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(recibopuntoventa !=null/* && recibopuntoventa.getId()!=0*/) {
			if(recibopuntoventa.getId()!=null) {
				sDescripcion=recibopuntoventa.getId().toString();
			}//recibopuntoventarecibopuntoventa.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getReciboPuntoVentaDescripcionDetallado(ReciboPuntoVenta recibopuntoventa) {
		String sDescripcion="";
			
		sDescripcion+=ReciboPuntoVentaConstantesFunciones.ID+"=";
		sDescripcion+=recibopuntoventa.getId().toString()+",";
		sDescripcion+=ReciboPuntoVentaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=recibopuntoventa.getVersionRow().toString()+",";
		sDescripcion+=ReciboPuntoVentaConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=recibopuntoventa.getid_cliente().toString()+",";
		sDescripcion+=ReciboPuntoVentaConstantesFunciones.IDBANCO+"=";
		sDescripcion+=recibopuntoventa.getid_banco().toString()+",";
		sDescripcion+=ReciboPuntoVentaConstantesFunciones.VALOREFECTIVO+"=";
		sDescripcion+=recibopuntoventa.getvalor_efectivo().toString()+",";
		sDescripcion+=ReciboPuntoVentaConstantesFunciones.VALORCHEQUE+"=";
		sDescripcion+=recibopuntoventa.getvalor_cheque().toString()+",";
		sDescripcion+=ReciboPuntoVentaConstantesFunciones.NUMEROCHEQUE+"=";
		sDescripcion+=recibopuntoventa.getnumero_cheque()+",";
		sDescripcion+=ReciboPuntoVentaConstantesFunciones.FECHA+"=";
		sDescripcion+=recibopuntoventa.getfecha().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setReciboPuntoVentaDescripcion(ReciboPuntoVenta recibopuntoventa,String sValor) throws Exception {			
		if(recibopuntoventa !=null) {
			//recibopuntoventarecibopuntoventa.getId().toString();
		}		
	}
	
		

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getBancoDescripcion(Banco banco) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(banco!=null/*&&banco.getId()>0*/) {
			sDescripcion=BancoConstantesFunciones.getBancoDescripcion(banco);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdBanco")) {
			sNombreIndice="Tipo=  Por Banco";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdBanco(Long id_banco) {
		String sDetalleIndice=" Parametros->";
		if(id_banco!=null) {sDetalleIndice+=" Codigo Unico De Banco="+id_banco.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosReciboPuntoVenta(ReciboPuntoVenta recibopuntoventa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		recibopuntoventa.setnumero_cheque(recibopuntoventa.getnumero_cheque().trim());
	}
	
	public static void quitarEspaciosReciboPuntoVentas(List<ReciboPuntoVenta> recibopuntoventas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ReciboPuntoVenta recibopuntoventa: recibopuntoventas) {
			recibopuntoventa.setnumero_cheque(recibopuntoventa.getnumero_cheque().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresReciboPuntoVenta(ReciboPuntoVenta recibopuntoventa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && recibopuntoventa.getConCambioAuxiliar()) {
			recibopuntoventa.setIsDeleted(recibopuntoventa.getIsDeletedAuxiliar());	
			recibopuntoventa.setIsNew(recibopuntoventa.getIsNewAuxiliar());	
			recibopuntoventa.setIsChanged(recibopuntoventa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			recibopuntoventa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			recibopuntoventa.setIsDeletedAuxiliar(false);	
			recibopuntoventa.setIsNewAuxiliar(false);	
			recibopuntoventa.setIsChangedAuxiliar(false);
			
			recibopuntoventa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresReciboPuntoVentas(List<ReciboPuntoVenta> recibopuntoventas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ReciboPuntoVenta recibopuntoventa : recibopuntoventas) {
			if(conAsignarBase && recibopuntoventa.getConCambioAuxiliar()) {
				recibopuntoventa.setIsDeleted(recibopuntoventa.getIsDeletedAuxiliar());	
				recibopuntoventa.setIsNew(recibopuntoventa.getIsNewAuxiliar());	
				recibopuntoventa.setIsChanged(recibopuntoventa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				recibopuntoventa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				recibopuntoventa.setIsDeletedAuxiliar(false);	
				recibopuntoventa.setIsNewAuxiliar(false);	
				recibopuntoventa.setIsChangedAuxiliar(false);
				
				recibopuntoventa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresReciboPuntoVenta(ReciboPuntoVenta recibopuntoventa,Boolean conEnteros) throws Exception  {
		recibopuntoventa.setvalor_efectivo(0.0);
		recibopuntoventa.setvalor_cheque(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresReciboPuntoVentas(List<ReciboPuntoVenta> recibopuntoventas,Boolean conEnteros) throws Exception  {
		
		for(ReciboPuntoVenta recibopuntoventa: recibopuntoventas) {
			recibopuntoventa.setvalor_efectivo(0.0);
			recibopuntoventa.setvalor_cheque(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaReciboPuntoVenta(List<ReciboPuntoVenta> recibopuntoventas,ReciboPuntoVenta recibopuntoventaAux) throws Exception  {
		ReciboPuntoVentaConstantesFunciones.InicializarValoresReciboPuntoVenta(recibopuntoventaAux,true);
		
		for(ReciboPuntoVenta recibopuntoventa: recibopuntoventas) {
			if(recibopuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			recibopuntoventaAux.setvalor_efectivo(recibopuntoventaAux.getvalor_efectivo()+recibopuntoventa.getvalor_efectivo());			
			recibopuntoventaAux.setvalor_cheque(recibopuntoventaAux.getvalor_cheque()+recibopuntoventa.getvalor_cheque());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesReciboPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ReciboPuntoVentaConstantesFunciones.getArrayColumnasGlobalesReciboPuntoVenta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesReciboPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoReciboPuntoVenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ReciboPuntoVenta> recibopuntoventas,ReciboPuntoVenta recibopuntoventa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ReciboPuntoVenta recibopuntoventaAux: recibopuntoventas) {
			if(recibopuntoventaAux!=null && recibopuntoventa!=null) {
				if((recibopuntoventaAux.getId()==null && recibopuntoventa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(recibopuntoventaAux.getId()!=null && recibopuntoventa.getId()!=null){
					if(recibopuntoventaAux.getId().equals(recibopuntoventa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaReciboPuntoVenta(List<ReciboPuntoVenta> recibopuntoventas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_efectivoTotal=0.0;
		Double valor_chequeTotal=0.0;
	
		for(ReciboPuntoVenta recibopuntoventa: recibopuntoventas) {			
			if(recibopuntoventa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_efectivoTotal+=recibopuntoventa.getvalor_efectivo();
			valor_chequeTotal+=recibopuntoventa.getvalor_cheque();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ReciboPuntoVentaConstantesFunciones.VALOREFECTIVO);
		datoGeneral.setsDescripcion(ReciboPuntoVentaConstantesFunciones.LABEL_VALOREFECTIVO);
		datoGeneral.setdValorDouble(valor_efectivoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ReciboPuntoVentaConstantesFunciones.VALORCHEQUE);
		datoGeneral.setsDescripcion(ReciboPuntoVentaConstantesFunciones.LABEL_VALORCHEQUE);
		datoGeneral.setdValorDouble(valor_chequeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaReciboPuntoVenta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ReciboPuntoVentaConstantesFunciones.LABEL_ID, ReciboPuntoVentaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReciboPuntoVentaConstantesFunciones.LABEL_VERSIONROW, ReciboPuntoVentaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReciboPuntoVentaConstantesFunciones.LABEL_IDCLIENTE, ReciboPuntoVentaConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReciboPuntoVentaConstantesFunciones.LABEL_IDBANCO, ReciboPuntoVentaConstantesFunciones.IDBANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReciboPuntoVentaConstantesFunciones.LABEL_VALOREFECTIVO, ReciboPuntoVentaConstantesFunciones.VALOREFECTIVO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReciboPuntoVentaConstantesFunciones.LABEL_VALORCHEQUE, ReciboPuntoVentaConstantesFunciones.VALORCHEQUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReciboPuntoVentaConstantesFunciones.LABEL_NUMEROCHEQUE, ReciboPuntoVentaConstantesFunciones.NUMEROCHEQUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ReciboPuntoVentaConstantesFunciones.LABEL_FECHA, ReciboPuntoVentaConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasReciboPuntoVenta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ReciboPuntoVentaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReciboPuntoVentaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReciboPuntoVentaConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReciboPuntoVentaConstantesFunciones.IDBANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReciboPuntoVentaConstantesFunciones.VALOREFECTIVO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReciboPuntoVentaConstantesFunciones.VALORCHEQUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReciboPuntoVentaConstantesFunciones.NUMEROCHEQUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ReciboPuntoVentaConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarReciboPuntoVenta() throws Exception  {
		return ReciboPuntoVentaConstantesFunciones.getTiposSeleccionarReciboPuntoVenta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarReciboPuntoVenta(Boolean conFk) throws Exception  {
		return ReciboPuntoVentaConstantesFunciones.getTiposSeleccionarReciboPuntoVenta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarReciboPuntoVenta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ReciboPuntoVentaConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(ReciboPuntoVentaConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ReciboPuntoVentaConstantesFunciones.LABEL_IDBANCO);
			reporte.setsDescripcion(ReciboPuntoVentaConstantesFunciones.LABEL_IDBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReciboPuntoVentaConstantesFunciones.LABEL_VALOREFECTIVO);
			reporte.setsDescripcion(ReciboPuntoVentaConstantesFunciones.LABEL_VALOREFECTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReciboPuntoVentaConstantesFunciones.LABEL_VALORCHEQUE);
			reporte.setsDescripcion(ReciboPuntoVentaConstantesFunciones.LABEL_VALORCHEQUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReciboPuntoVentaConstantesFunciones.LABEL_NUMEROCHEQUE);
			reporte.setsDescripcion(ReciboPuntoVentaConstantesFunciones.LABEL_NUMEROCHEQUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ReciboPuntoVentaConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(ReciboPuntoVentaConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesReciboPuntoVenta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesReciboPuntoVenta(ReciboPuntoVenta recibopuntoventaAux) throws Exception {
		
			recibopuntoventaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(recibopuntoventaAux.getCliente()));
			recibopuntoventaAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(recibopuntoventaAux.getBanco()));		
	}
	
	public static void refrescarForeignKeysDescripcionesReciboPuntoVenta(List<ReciboPuntoVenta> recibopuntoventasTemp) throws Exception {
		for(ReciboPuntoVenta recibopuntoventaAux:recibopuntoventasTemp) {
			
			recibopuntoventaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(recibopuntoventaAux.getCliente()));
			recibopuntoventaAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(recibopuntoventaAux.getBanco()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfReciboPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Banco.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Banco.class)) {
						classes.add(new Classe(Banco.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfReciboPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfReciboPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ReciboPuntoVentaConstantesFunciones.getClassesRelationshipsOfReciboPuntoVenta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfReciboPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfReciboPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ReciboPuntoVentaConstantesFunciones.getClassesRelationshipsFromStringsOfReciboPuntoVenta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfReciboPuntoVenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(ReciboPuntoVenta recibopuntoventa,List<ReciboPuntoVenta> recibopuntoventas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ReciboPuntoVenta recibopuntoventaEncontrado=null;
			
			for(ReciboPuntoVenta recibopuntoventaLocal:recibopuntoventas) {
				if(recibopuntoventaLocal.getId().equals(recibopuntoventa.getId())) {
					recibopuntoventaEncontrado=recibopuntoventaLocal;
					
					recibopuntoventaLocal.setIsChanged(recibopuntoventa.getIsChanged());
					recibopuntoventaLocal.setIsNew(recibopuntoventa.getIsNew());
					recibopuntoventaLocal.setIsDeleted(recibopuntoventa.getIsDeleted());
					
					recibopuntoventaLocal.setGeneralEntityOriginal(recibopuntoventa.getGeneralEntityOriginal());
					
					recibopuntoventaLocal.setId(recibopuntoventa.getId());	
					recibopuntoventaLocal.setVersionRow(recibopuntoventa.getVersionRow());	
					recibopuntoventaLocal.setid_cliente(recibopuntoventa.getid_cliente());	
					recibopuntoventaLocal.setid_banco(recibopuntoventa.getid_banco());	
					recibopuntoventaLocal.setvalor_efectivo(recibopuntoventa.getvalor_efectivo());	
					recibopuntoventaLocal.setvalor_cheque(recibopuntoventa.getvalor_cheque());	
					recibopuntoventaLocal.setnumero_cheque(recibopuntoventa.getnumero_cheque());	
					recibopuntoventaLocal.setfecha(recibopuntoventa.getfecha());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!recibopuntoventa.getIsDeleted()) {
				if(!existe) {
					recibopuntoventas.add(recibopuntoventa);
				}
			} else {
				if(recibopuntoventaEncontrado!=null && permiteQuitar)  {
					recibopuntoventas.remove(recibopuntoventaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ReciboPuntoVenta recibopuntoventa,List<ReciboPuntoVenta> recibopuntoventas) throws Exception {
		try	{			
			for(ReciboPuntoVenta recibopuntoventaLocal:recibopuntoventas) {
				if(recibopuntoventaLocal.getId().equals(recibopuntoventa.getId())) {
					recibopuntoventaLocal.setIsSelected(recibopuntoventa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesReciboPuntoVenta(List<ReciboPuntoVenta> recibopuntoventasAux) throws Exception {
		//this.recibopuntoventasAux=recibopuntoventasAux;
		
		for(ReciboPuntoVenta recibopuntoventaAux:recibopuntoventasAux) {
			if(recibopuntoventaAux.getIsChanged()) {
				recibopuntoventaAux.setIsChanged(false);
			}		
			
			if(recibopuntoventaAux.getIsNew()) {
				recibopuntoventaAux.setIsNew(false);
			}	
			
			if(recibopuntoventaAux.getIsDeleted()) {
				recibopuntoventaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesReciboPuntoVenta(ReciboPuntoVenta recibopuntoventaAux) throws Exception {
		//this.recibopuntoventaAux=recibopuntoventaAux;
		
			if(recibopuntoventaAux.getIsChanged()) {
				recibopuntoventaAux.setIsChanged(false);
			}		
			
			if(recibopuntoventaAux.getIsNew()) {
				recibopuntoventaAux.setIsNew(false);
			}	
			
			if(recibopuntoventaAux.getIsDeleted()) {
				recibopuntoventaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ReciboPuntoVenta recibopuntoventaAsignar,ReciboPuntoVenta recibopuntoventa) throws Exception {
		recibopuntoventaAsignar.setId(recibopuntoventa.getId());	
		recibopuntoventaAsignar.setVersionRow(recibopuntoventa.getVersionRow());	
		recibopuntoventaAsignar.setid_cliente(recibopuntoventa.getid_cliente());
		recibopuntoventaAsignar.setcliente_descripcion(recibopuntoventa.getcliente_descripcion());	
		recibopuntoventaAsignar.setid_banco(recibopuntoventa.getid_banco());
		recibopuntoventaAsignar.setbanco_descripcion(recibopuntoventa.getbanco_descripcion());	
		recibopuntoventaAsignar.setvalor_efectivo(recibopuntoventa.getvalor_efectivo());	
		recibopuntoventaAsignar.setvalor_cheque(recibopuntoventa.getvalor_cheque());	
		recibopuntoventaAsignar.setnumero_cheque(recibopuntoventa.getnumero_cheque());	
		recibopuntoventaAsignar.setfecha(recibopuntoventa.getfecha());	
	}
	
	public static void inicializarReciboPuntoVenta(ReciboPuntoVenta recibopuntoventa) throws Exception {
		try {
				recibopuntoventa.setId(0L);	
					
				recibopuntoventa.setid_cliente(-1L);	
				recibopuntoventa.setid_banco(-1L);	
				recibopuntoventa.setvalor_efectivo(0.0);	
				recibopuntoventa.setvalor_cheque(0.0);	
				recibopuntoventa.setnumero_cheque("");	
				recibopuntoventa.setfecha(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderReciboPuntoVenta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ReciboPuntoVentaConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReciboPuntoVentaConstantesFunciones.LABEL_IDBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReciboPuntoVentaConstantesFunciones.LABEL_VALOREFECTIVO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReciboPuntoVentaConstantesFunciones.LABEL_VALORCHEQUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReciboPuntoVentaConstantesFunciones.LABEL_NUMEROCHEQUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ReciboPuntoVentaConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataReciboPuntoVenta(String sTipo,Row row,Workbook workbook,ReciboPuntoVenta recibopuntoventa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(recibopuntoventa.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(recibopuntoventa.getbanco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(recibopuntoventa.getvalor_efectivo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(recibopuntoventa.getvalor_cheque());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(recibopuntoventa.getnumero_cheque());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(recibopuntoventa.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryReciboPuntoVenta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryReciboPuntoVenta() {
		return this.sFinalQueryReciboPuntoVenta;
	}
	
	public void setsFinalQueryReciboPuntoVenta(String sFinalQueryReciboPuntoVenta) {
		this.sFinalQueryReciboPuntoVenta= sFinalQueryReciboPuntoVenta;
	}
	
	public Border resaltarSeleccionarReciboPuntoVenta=null;
	
	public Border setResaltarSeleccionarReciboPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*ReciboPuntoVentaBeanSwingJInternalFrame recibopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//recibopuntoventaBeanSwingJInternalFrame.jTtoolBarReciboPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarReciboPuntoVenta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarReciboPuntoVenta() {
		return this.resaltarSeleccionarReciboPuntoVenta;
	}
	
	public void setResaltarSeleccionarReciboPuntoVenta(Border borderResaltarSeleccionarReciboPuntoVenta) {
		this.resaltarSeleccionarReciboPuntoVenta= borderResaltarSeleccionarReciboPuntoVenta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridReciboPuntoVenta=null;
	public Boolean mostraridReciboPuntoVenta=true;
	public Boolean activaridReciboPuntoVenta=true;

	public Border resaltarid_clienteReciboPuntoVenta=null;
	public Boolean mostrarid_clienteReciboPuntoVenta=true;
	public Boolean activarid_clienteReciboPuntoVenta=true;
	public Boolean cargarid_clienteReciboPuntoVenta=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteReciboPuntoVenta=false;//ConEventDepend=true

	public Border resaltarid_bancoReciboPuntoVenta=null;
	public Boolean mostrarid_bancoReciboPuntoVenta=true;
	public Boolean activarid_bancoReciboPuntoVenta=true;
	public Boolean cargarid_bancoReciboPuntoVenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bancoReciboPuntoVenta=false;//ConEventDepend=true

	public Border resaltarvalor_efectivoReciboPuntoVenta=null;
	public Boolean mostrarvalor_efectivoReciboPuntoVenta=true;
	public Boolean activarvalor_efectivoReciboPuntoVenta=true;

	public Border resaltarvalor_chequeReciboPuntoVenta=null;
	public Boolean mostrarvalor_chequeReciboPuntoVenta=true;
	public Boolean activarvalor_chequeReciboPuntoVenta=true;

	public Border resaltarnumero_chequeReciboPuntoVenta=null;
	public Boolean mostrarnumero_chequeReciboPuntoVenta=true;
	public Boolean activarnumero_chequeReciboPuntoVenta=true;

	public Border resaltarfechaReciboPuntoVenta=null;
	public Boolean mostrarfechaReciboPuntoVenta=true;
	public Boolean activarfechaReciboPuntoVenta=false;

	
	

	public Border setResaltaridReciboPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*ReciboPuntoVentaBeanSwingJInternalFrame recibopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recibopuntoventaBeanSwingJInternalFrame.jTtoolBarReciboPuntoVenta.setBorder(borderResaltar);
		
		this.resaltaridReciboPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridReciboPuntoVenta() {
		return this.resaltaridReciboPuntoVenta;
	}

	public void setResaltaridReciboPuntoVenta(Border borderResaltar) {
		this.resaltaridReciboPuntoVenta= borderResaltar;
	}

	public Boolean getMostraridReciboPuntoVenta() {
		return this.mostraridReciboPuntoVenta;
	}

	public void setMostraridReciboPuntoVenta(Boolean mostraridReciboPuntoVenta) {
		this.mostraridReciboPuntoVenta= mostraridReciboPuntoVenta;
	}

	public Boolean getActivaridReciboPuntoVenta() {
		return this.activaridReciboPuntoVenta;
	}

	public void setActivaridReciboPuntoVenta(Boolean activaridReciboPuntoVenta) {
		this.activaridReciboPuntoVenta= activaridReciboPuntoVenta;
	}

	public Border setResaltarid_clienteReciboPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*ReciboPuntoVentaBeanSwingJInternalFrame recibopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recibopuntoventaBeanSwingJInternalFrame.jTtoolBarReciboPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_clienteReciboPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteReciboPuntoVenta() {
		return this.resaltarid_clienteReciboPuntoVenta;
	}

	public void setResaltarid_clienteReciboPuntoVenta(Border borderResaltar) {
		this.resaltarid_clienteReciboPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_clienteReciboPuntoVenta() {
		return this.mostrarid_clienteReciboPuntoVenta;
	}

	public void setMostrarid_clienteReciboPuntoVenta(Boolean mostrarid_clienteReciboPuntoVenta) {
		this.mostrarid_clienteReciboPuntoVenta= mostrarid_clienteReciboPuntoVenta;
	}

	public Boolean getActivarid_clienteReciboPuntoVenta() {
		return this.activarid_clienteReciboPuntoVenta;
	}

	public void setActivarid_clienteReciboPuntoVenta(Boolean activarid_clienteReciboPuntoVenta) {
		this.activarid_clienteReciboPuntoVenta= activarid_clienteReciboPuntoVenta;
	}

	public Boolean getCargarid_clienteReciboPuntoVenta() {
		return this.cargarid_clienteReciboPuntoVenta;
	}

	public void setCargarid_clienteReciboPuntoVenta(Boolean cargarid_clienteReciboPuntoVenta) {
		this.cargarid_clienteReciboPuntoVenta= cargarid_clienteReciboPuntoVenta;
	}

	public Border setResaltarid_bancoReciboPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*ReciboPuntoVentaBeanSwingJInternalFrame recibopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recibopuntoventaBeanSwingJInternalFrame.jTtoolBarReciboPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarid_bancoReciboPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bancoReciboPuntoVenta() {
		return this.resaltarid_bancoReciboPuntoVenta;
	}

	public void setResaltarid_bancoReciboPuntoVenta(Border borderResaltar) {
		this.resaltarid_bancoReciboPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarid_bancoReciboPuntoVenta() {
		return this.mostrarid_bancoReciboPuntoVenta;
	}

	public void setMostrarid_bancoReciboPuntoVenta(Boolean mostrarid_bancoReciboPuntoVenta) {
		this.mostrarid_bancoReciboPuntoVenta= mostrarid_bancoReciboPuntoVenta;
	}

	public Boolean getActivarid_bancoReciboPuntoVenta() {
		return this.activarid_bancoReciboPuntoVenta;
	}

	public void setActivarid_bancoReciboPuntoVenta(Boolean activarid_bancoReciboPuntoVenta) {
		this.activarid_bancoReciboPuntoVenta= activarid_bancoReciboPuntoVenta;
	}

	public Boolean getCargarid_bancoReciboPuntoVenta() {
		return this.cargarid_bancoReciboPuntoVenta;
	}

	public void setCargarid_bancoReciboPuntoVenta(Boolean cargarid_bancoReciboPuntoVenta) {
		this.cargarid_bancoReciboPuntoVenta= cargarid_bancoReciboPuntoVenta;
	}

	public Border setResaltarvalor_efectivoReciboPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*ReciboPuntoVentaBeanSwingJInternalFrame recibopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recibopuntoventaBeanSwingJInternalFrame.jTtoolBarReciboPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarvalor_efectivoReciboPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_efectivoReciboPuntoVenta() {
		return this.resaltarvalor_efectivoReciboPuntoVenta;
	}

	public void setResaltarvalor_efectivoReciboPuntoVenta(Border borderResaltar) {
		this.resaltarvalor_efectivoReciboPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarvalor_efectivoReciboPuntoVenta() {
		return this.mostrarvalor_efectivoReciboPuntoVenta;
	}

	public void setMostrarvalor_efectivoReciboPuntoVenta(Boolean mostrarvalor_efectivoReciboPuntoVenta) {
		this.mostrarvalor_efectivoReciboPuntoVenta= mostrarvalor_efectivoReciboPuntoVenta;
	}

	public Boolean getActivarvalor_efectivoReciboPuntoVenta() {
		return this.activarvalor_efectivoReciboPuntoVenta;
	}

	public void setActivarvalor_efectivoReciboPuntoVenta(Boolean activarvalor_efectivoReciboPuntoVenta) {
		this.activarvalor_efectivoReciboPuntoVenta= activarvalor_efectivoReciboPuntoVenta;
	}

	public Border setResaltarvalor_chequeReciboPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*ReciboPuntoVentaBeanSwingJInternalFrame recibopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recibopuntoventaBeanSwingJInternalFrame.jTtoolBarReciboPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarvalor_chequeReciboPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_chequeReciboPuntoVenta() {
		return this.resaltarvalor_chequeReciboPuntoVenta;
	}

	public void setResaltarvalor_chequeReciboPuntoVenta(Border borderResaltar) {
		this.resaltarvalor_chequeReciboPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarvalor_chequeReciboPuntoVenta() {
		return this.mostrarvalor_chequeReciboPuntoVenta;
	}

	public void setMostrarvalor_chequeReciboPuntoVenta(Boolean mostrarvalor_chequeReciboPuntoVenta) {
		this.mostrarvalor_chequeReciboPuntoVenta= mostrarvalor_chequeReciboPuntoVenta;
	}

	public Boolean getActivarvalor_chequeReciboPuntoVenta() {
		return this.activarvalor_chequeReciboPuntoVenta;
	}

	public void setActivarvalor_chequeReciboPuntoVenta(Boolean activarvalor_chequeReciboPuntoVenta) {
		this.activarvalor_chequeReciboPuntoVenta= activarvalor_chequeReciboPuntoVenta;
	}

	public Border setResaltarnumero_chequeReciboPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*ReciboPuntoVentaBeanSwingJInternalFrame recibopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recibopuntoventaBeanSwingJInternalFrame.jTtoolBarReciboPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarnumero_chequeReciboPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_chequeReciboPuntoVenta() {
		return this.resaltarnumero_chequeReciboPuntoVenta;
	}

	public void setResaltarnumero_chequeReciboPuntoVenta(Border borderResaltar) {
		this.resaltarnumero_chequeReciboPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarnumero_chequeReciboPuntoVenta() {
		return this.mostrarnumero_chequeReciboPuntoVenta;
	}

	public void setMostrarnumero_chequeReciboPuntoVenta(Boolean mostrarnumero_chequeReciboPuntoVenta) {
		this.mostrarnumero_chequeReciboPuntoVenta= mostrarnumero_chequeReciboPuntoVenta;
	}

	public Boolean getActivarnumero_chequeReciboPuntoVenta() {
		return this.activarnumero_chequeReciboPuntoVenta;
	}

	public void setActivarnumero_chequeReciboPuntoVenta(Boolean activarnumero_chequeReciboPuntoVenta) {
		this.activarnumero_chequeReciboPuntoVenta= activarnumero_chequeReciboPuntoVenta;
	}

	public Border setResaltarfechaReciboPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*ReciboPuntoVentaBeanSwingJInternalFrame recibopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recibopuntoventaBeanSwingJInternalFrame.jTtoolBarReciboPuntoVenta.setBorder(borderResaltar);
		
		this.resaltarfechaReciboPuntoVenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaReciboPuntoVenta() {
		return this.resaltarfechaReciboPuntoVenta;
	}

	public void setResaltarfechaReciboPuntoVenta(Border borderResaltar) {
		this.resaltarfechaReciboPuntoVenta= borderResaltar;
	}

	public Boolean getMostrarfechaReciboPuntoVenta() {
		return this.mostrarfechaReciboPuntoVenta;
	}

	public void setMostrarfechaReciboPuntoVenta(Boolean mostrarfechaReciboPuntoVenta) {
		this.mostrarfechaReciboPuntoVenta= mostrarfechaReciboPuntoVenta;
	}

	public Boolean getActivarfechaReciboPuntoVenta() {
		return this.activarfechaReciboPuntoVenta;
	}

	public void setActivarfechaReciboPuntoVenta(Boolean activarfechaReciboPuntoVenta) {
		this.activarfechaReciboPuntoVenta= activarfechaReciboPuntoVenta;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridReciboPuntoVenta(esInicial);
		this.setMostrarid_clienteReciboPuntoVenta(esInicial);
		this.setMostrarid_bancoReciboPuntoVenta(esInicial);
		this.setMostrarvalor_efectivoReciboPuntoVenta(esInicial);
		this.setMostrarvalor_chequeReciboPuntoVenta(esInicial);
		this.setMostrarnumero_chequeReciboPuntoVenta(esInicial);
		this.setMostrarfechaReciboPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ReciboPuntoVentaConstantesFunciones.ID)) {
				this.setMostraridReciboPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReciboPuntoVentaConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteReciboPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReciboPuntoVentaConstantesFunciones.IDBANCO)) {
				this.setMostrarid_bancoReciboPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReciboPuntoVentaConstantesFunciones.VALOREFECTIVO)) {
				this.setMostrarvalor_efectivoReciboPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReciboPuntoVentaConstantesFunciones.VALORCHEQUE)) {
				this.setMostrarvalor_chequeReciboPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReciboPuntoVentaConstantesFunciones.NUMEROCHEQUE)) {
				this.setMostrarnumero_chequeReciboPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReciboPuntoVentaConstantesFunciones.FECHA)) {
				this.setMostrarfechaReciboPuntoVenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridReciboPuntoVenta(esInicial);
		this.setActivarid_clienteReciboPuntoVenta(esInicial);
		this.setActivarid_bancoReciboPuntoVenta(esInicial);
		this.setActivarvalor_efectivoReciboPuntoVenta(esInicial);
		this.setActivarvalor_chequeReciboPuntoVenta(esInicial);
		this.setActivarnumero_chequeReciboPuntoVenta(esInicial);
		this.setActivarfechaReciboPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ReciboPuntoVentaConstantesFunciones.ID)) {
				this.setActivaridReciboPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReciboPuntoVentaConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteReciboPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReciboPuntoVentaConstantesFunciones.IDBANCO)) {
				this.setActivarid_bancoReciboPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReciboPuntoVentaConstantesFunciones.VALOREFECTIVO)) {
				this.setActivarvalor_efectivoReciboPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReciboPuntoVentaConstantesFunciones.VALORCHEQUE)) {
				this.setActivarvalor_chequeReciboPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReciboPuntoVentaConstantesFunciones.NUMEROCHEQUE)) {
				this.setActivarnumero_chequeReciboPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReciboPuntoVentaConstantesFunciones.FECHA)) {
				this.setActivarfechaReciboPuntoVenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ReciboPuntoVentaBeanSwingJInternalFrame recibopuntoventaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridReciboPuntoVenta(esInicial);
		this.setResaltarid_clienteReciboPuntoVenta(esInicial);
		this.setResaltarid_bancoReciboPuntoVenta(esInicial);
		this.setResaltarvalor_efectivoReciboPuntoVenta(esInicial);
		this.setResaltarvalor_chequeReciboPuntoVenta(esInicial);
		this.setResaltarnumero_chequeReciboPuntoVenta(esInicial);
		this.setResaltarfechaReciboPuntoVenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ReciboPuntoVentaConstantesFunciones.ID)) {
				this.setResaltaridReciboPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReciboPuntoVentaConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteReciboPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReciboPuntoVentaConstantesFunciones.IDBANCO)) {
				this.setResaltarid_bancoReciboPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReciboPuntoVentaConstantesFunciones.VALOREFECTIVO)) {
				this.setResaltarvalor_efectivoReciboPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReciboPuntoVentaConstantesFunciones.VALORCHEQUE)) {
				this.setResaltarvalor_chequeReciboPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReciboPuntoVentaConstantesFunciones.NUMEROCHEQUE)) {
				this.setResaltarnumero_chequeReciboPuntoVenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ReciboPuntoVentaConstantesFunciones.FECHA)) {
				this.setResaltarfechaReciboPuntoVenta(esAsigna);
				continue;
			}
		}
	}
	
			
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ReciboPuntoVentaBeanSwingJInternalFrame recibopuntoventaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarFK_IdBancoReciboPuntoVenta=true;

	public Boolean getMostrarFK_IdBancoReciboPuntoVenta() {
		return this.mostrarFK_IdBancoReciboPuntoVenta;
	}

	public void setMostrarFK_IdBancoReciboPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBancoReciboPuntoVenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteReciboPuntoVenta=true;

	public Boolean getMostrarFK_IdClienteReciboPuntoVenta() {
		return this.mostrarFK_IdClienteReciboPuntoVenta;
	}

	public void setMostrarFK_IdClienteReciboPuntoVenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteReciboPuntoVenta= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBancoReciboPuntoVenta=true;

	public Boolean getActivarFK_IdBancoReciboPuntoVenta() {
		return this.activarFK_IdBancoReciboPuntoVenta;
	}

	public void setActivarFK_IdBancoReciboPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdBancoReciboPuntoVenta= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteReciboPuntoVenta=true;

	public Boolean getActivarFK_IdClienteReciboPuntoVenta() {
		return this.activarFK_IdClienteReciboPuntoVenta;
	}

	public void setActivarFK_IdClienteReciboPuntoVenta(Boolean habilitarResaltar) {
		this.activarFK_IdClienteReciboPuntoVenta= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBancoReciboPuntoVenta=null;

	public Border getResaltarFK_IdBancoReciboPuntoVenta() {
		return this.resaltarFK_IdBancoReciboPuntoVenta;
	}

	public void setResaltarFK_IdBancoReciboPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdBancoReciboPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdBancoReciboPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*ReciboPuntoVentaBeanSwingJInternalFrame recibopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBancoReciboPuntoVenta= borderResaltar;
	}

	public Border resaltarFK_IdClienteReciboPuntoVenta=null;

	public Border getResaltarFK_IdClienteReciboPuntoVenta() {
		return this.resaltarFK_IdClienteReciboPuntoVenta;
	}

	public void setResaltarFK_IdClienteReciboPuntoVenta(Border borderResaltar) {
		this.resaltarFK_IdClienteReciboPuntoVenta= borderResaltar;
	}

	public void setResaltarFK_IdClienteReciboPuntoVenta(ParametroGeneralUsuario parametroGeneralUsuario/*ReciboPuntoVentaBeanSwingJInternalFrame recibopuntoventaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteReciboPuntoVenta= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}