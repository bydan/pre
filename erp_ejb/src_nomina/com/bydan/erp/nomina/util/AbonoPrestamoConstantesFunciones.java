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
package com.bydan.erp.nomina.util;

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


import com.bydan.erp.nomina.util.AbonoPrestamoConstantesFunciones;
import com.bydan.erp.nomina.util.AbonoPrestamoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.AbonoPrestamoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class AbonoPrestamoConstantesFunciones extends AbonoPrestamoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="AbonoPrestamo";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="AbonoPrestamo"+AbonoPrestamoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="AbonoPrestamoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="AbonoPrestamoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=AbonoPrestamoConstantesFunciones.SCHEMA+"_"+AbonoPrestamoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/AbonoPrestamoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=AbonoPrestamoConstantesFunciones.SCHEMA+"_"+AbonoPrestamoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=AbonoPrestamoConstantesFunciones.SCHEMA+"_"+AbonoPrestamoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/AbonoPrestamoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=AbonoPrestamoConstantesFunciones.SCHEMA+"_"+AbonoPrestamoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AbonoPrestamoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AbonoPrestamoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AbonoPrestamoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AbonoPrestamoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AbonoPrestamoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AbonoPrestamoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=AbonoPrestamoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+AbonoPrestamoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=AbonoPrestamoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+AbonoPrestamoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Abono Prestamos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Abono Prestamo";
	public static final String SCLASSWEBTITULO_LOWER="Abono Prestamo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="AbonoPrestamo";
	public static final String OBJECTNAME="abonoprestamo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="abono_prestamo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select abonoprestamo from "+AbonoPrestamoConstantesFunciones.SPERSISTENCENAME+" abonoprestamo";
	public static String QUERYSELECTNATIVE="select "+AbonoPrestamoConstantesFunciones.SCHEMA+"."+AbonoPrestamoConstantesFunciones.TABLENAME+".id,"+AbonoPrestamoConstantesFunciones.SCHEMA+"."+AbonoPrestamoConstantesFunciones.TABLENAME+".version_row,"+AbonoPrestamoConstantesFunciones.SCHEMA+"."+AbonoPrestamoConstantesFunciones.TABLENAME+".id_prestamo,"+AbonoPrestamoConstantesFunciones.SCHEMA+"."+AbonoPrestamoConstantesFunciones.TABLENAME+".numero,"+AbonoPrestamoConstantesFunciones.SCHEMA+"."+AbonoPrestamoConstantesFunciones.TABLENAME+".monto_capital,"+AbonoPrestamoConstantesFunciones.SCHEMA+"."+AbonoPrestamoConstantesFunciones.TABLENAME+".monto_interes,"+AbonoPrestamoConstantesFunciones.SCHEMA+"."+AbonoPrestamoConstantesFunciones.TABLENAME+".valor,"+AbonoPrestamoConstantesFunciones.SCHEMA+"."+AbonoPrestamoConstantesFunciones.TABLENAME+".fecha_vencimiento,"+AbonoPrestamoConstantesFunciones.SCHEMA+"."+AbonoPrestamoConstantesFunciones.TABLENAME+".codigo_quincena from "+AbonoPrestamoConstantesFunciones.SCHEMA+"."+AbonoPrestamoConstantesFunciones.TABLENAME;//+" as "+AbonoPrestamoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected AbonoPrestamoConstantesFuncionesAdditional abonoprestamoConstantesFuncionesAdditional=null;
	
	public AbonoPrestamoConstantesFuncionesAdditional getAbonoPrestamoConstantesFuncionesAdditional() {
		return this.abonoprestamoConstantesFuncionesAdditional;
	}
	
	public void setAbonoPrestamoConstantesFuncionesAdditional(AbonoPrestamoConstantesFuncionesAdditional abonoprestamoConstantesFuncionesAdditional) {
		try {
			this.abonoprestamoConstantesFuncionesAdditional=abonoprestamoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPRESTAMO= "id_prestamo";
    public static final String NUMERO= "numero";
    public static final String MONTOCAPITAL= "monto_capital";
    public static final String MONTOINTERES= "monto_interes";
    public static final String VALOR= "valor";
    public static final String FECHAVENCIMIENTO= "fecha_vencimiento";
    public static final String CODIGOQUINCENA= "codigo_quincena";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPRESTAMO= "Idprestamo";
		public static final String LABEL_IDPRESTAMO_LOWER= "Prestamo";
    	public static final String LABEL_NUMERO= "Numero";
		public static final String LABEL_NUMERO_LOWER= "Numero";
    	public static final String LABEL_MONTOCAPITAL= "Monto Capital";
		public static final String LABEL_MONTOCAPITAL_LOWER= "Monto Capital";
    	public static final String LABEL_MONTOINTERES= "Monto Interes";
		public static final String LABEL_MONTOINTERES_LOWER= "Monto Interes";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_FECHAVENCIMIENTO= "Fecha Vencimiento";
		public static final String LABEL_FECHAVENCIMIENTO_LOWER= "Fecha Vencimiento";
    	public static final String LABEL_CODIGOQUINCENA= "Codigo Quincena";
		public static final String LABEL_CODIGOQUINCENA_LOWER= "Codigo Quincena";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO_QUINCENA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_QUINCENA=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getAbonoPrestamoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(AbonoPrestamoConstantesFunciones.IDPRESTAMO)) {sLabelColumna=AbonoPrestamoConstantesFunciones.LABEL_IDPRESTAMO;}
		if(sNombreColumna.equals(AbonoPrestamoConstantesFunciones.NUMERO)) {sLabelColumna=AbonoPrestamoConstantesFunciones.LABEL_NUMERO;}
		if(sNombreColumna.equals(AbonoPrestamoConstantesFunciones.MONTOCAPITAL)) {sLabelColumna=AbonoPrestamoConstantesFunciones.LABEL_MONTOCAPITAL;}
		if(sNombreColumna.equals(AbonoPrestamoConstantesFunciones.MONTOINTERES)) {sLabelColumna=AbonoPrestamoConstantesFunciones.LABEL_MONTOINTERES;}
		if(sNombreColumna.equals(AbonoPrestamoConstantesFunciones.VALOR)) {sLabelColumna=AbonoPrestamoConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(AbonoPrestamoConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=AbonoPrestamoConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		if(sNombreColumna.equals(AbonoPrestamoConstantesFunciones.CODIGOQUINCENA)) {sLabelColumna=AbonoPrestamoConstantesFunciones.LABEL_CODIGOQUINCENA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
	
	public static String getAbonoPrestamoDescripcion(AbonoPrestamo abonoprestamo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(abonoprestamo !=null/* && abonoprestamo.getId()!=0*/) {
			if(abonoprestamo.getId()!=null) {
				sDescripcion=abonoprestamo.getId().toString();
			}//abonoprestamoabonoprestamo.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getAbonoPrestamoDescripcionDetallado(AbonoPrestamo abonoprestamo) {
		String sDescripcion="";
			
		sDescripcion+=AbonoPrestamoConstantesFunciones.ID+"=";
		sDescripcion+=abonoprestamo.getId().toString()+",";
		sDescripcion+=AbonoPrestamoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=abonoprestamo.getVersionRow().toString()+",";
		sDescripcion+=AbonoPrestamoConstantesFunciones.IDPRESTAMO+"=";
		sDescripcion+=abonoprestamo.getid_prestamo().toString()+",";
		sDescripcion+=AbonoPrestamoConstantesFunciones.NUMERO+"=";
		sDescripcion+=abonoprestamo.getnumero().toString()+",";
		sDescripcion+=AbonoPrestamoConstantesFunciones.MONTOCAPITAL+"=";
		sDescripcion+=abonoprestamo.getmonto_capital().toString()+",";
		sDescripcion+=AbonoPrestamoConstantesFunciones.MONTOINTERES+"=";
		sDescripcion+=abonoprestamo.getmonto_interes().toString()+",";
		sDescripcion+=AbonoPrestamoConstantesFunciones.VALOR+"=";
		sDescripcion+=abonoprestamo.getvalor().toString()+",";
		sDescripcion+=AbonoPrestamoConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=abonoprestamo.getfecha_vencimiento().toString()+",";
		sDescripcion+=AbonoPrestamoConstantesFunciones.CODIGOQUINCENA+"=";
		sDescripcion+=abonoprestamo.getcodigo_quincena()+",";
			
		return sDescripcion;
	}
	
	public static void setAbonoPrestamoDescripcion(AbonoPrestamo abonoprestamo,String sValor) throws Exception {			
		if(abonoprestamo !=null) {
			//abonoprestamoabonoprestamo.getId().toString();
		}		
	}
	
		

	public static String getPrestamoDescripcion(Prestamo prestamo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(prestamo!=null/*&&prestamo.getId()>0*/) {
			sDescripcion=PrestamoConstantesFunciones.getPrestamoDescripcion(prestamo);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdPrestamo")) {
			sNombreIndice="Tipo=  Por Idprestamo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdPrestamo(Long id_prestamo) {
		String sDetalleIndice=" Parametros->";
		if(id_prestamo!=null) {sDetalleIndice+=" Codigo Unico De Idprestamo="+id_prestamo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosAbonoPrestamo(AbonoPrestamo abonoprestamo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		abonoprestamo.setcodigo_quincena(abonoprestamo.getcodigo_quincena().trim());
	}
	
	public static void quitarEspaciosAbonoPrestamos(List<AbonoPrestamo> abonoprestamos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(AbonoPrestamo abonoprestamo: abonoprestamos) {
			abonoprestamo.setcodigo_quincena(abonoprestamo.getcodigo_quincena().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAbonoPrestamo(AbonoPrestamo abonoprestamo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && abonoprestamo.getConCambioAuxiliar()) {
			abonoprestamo.setIsDeleted(abonoprestamo.getIsDeletedAuxiliar());	
			abonoprestamo.setIsNew(abonoprestamo.getIsNewAuxiliar());	
			abonoprestamo.setIsChanged(abonoprestamo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			abonoprestamo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			abonoprestamo.setIsDeletedAuxiliar(false);	
			abonoprestamo.setIsNewAuxiliar(false);	
			abonoprestamo.setIsChangedAuxiliar(false);
			
			abonoprestamo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAbonoPrestamos(List<AbonoPrestamo> abonoprestamos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(AbonoPrestamo abonoprestamo : abonoprestamos) {
			if(conAsignarBase && abonoprestamo.getConCambioAuxiliar()) {
				abonoprestamo.setIsDeleted(abonoprestamo.getIsDeletedAuxiliar());	
				abonoprestamo.setIsNew(abonoprestamo.getIsNewAuxiliar());	
				abonoprestamo.setIsChanged(abonoprestamo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				abonoprestamo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				abonoprestamo.setIsDeletedAuxiliar(false);	
				abonoprestamo.setIsNewAuxiliar(false);	
				abonoprestamo.setIsChangedAuxiliar(false);
				
				abonoprestamo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresAbonoPrestamo(AbonoPrestamo abonoprestamo,Boolean conEnteros) throws Exception  {
		abonoprestamo.setmonto_capital(0.0);
		abonoprestamo.setmonto_interes(0.0);
		abonoprestamo.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			abonoprestamo.setnumero(0);
		}
	}		
	
	public static void InicializarValoresAbonoPrestamos(List<AbonoPrestamo> abonoprestamos,Boolean conEnteros) throws Exception  {
		
		for(AbonoPrestamo abonoprestamo: abonoprestamos) {
			abonoprestamo.setmonto_capital(0.0);
			abonoprestamo.setmonto_interes(0.0);
			abonoprestamo.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				abonoprestamo.setnumero(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaAbonoPrestamo(List<AbonoPrestamo> abonoprestamos,AbonoPrestamo abonoprestamoAux) throws Exception  {
		AbonoPrestamoConstantesFunciones.InicializarValoresAbonoPrestamo(abonoprestamoAux,true);
		
		for(AbonoPrestamo abonoprestamo: abonoprestamos) {
			if(abonoprestamo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			abonoprestamoAux.setnumero(abonoprestamoAux.getnumero()+abonoprestamo.getnumero());			
			abonoprestamoAux.setmonto_capital(abonoprestamoAux.getmonto_capital()+abonoprestamo.getmonto_capital());			
			abonoprestamoAux.setmonto_interes(abonoprestamoAux.getmonto_interes()+abonoprestamo.getmonto_interes());			
			abonoprestamoAux.setvalor(abonoprestamoAux.getvalor()+abonoprestamo.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesAbonoPrestamo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=AbonoPrestamoConstantesFunciones.getArrayColumnasGlobalesAbonoPrestamo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesAbonoPrestamo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoAbonoPrestamo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<AbonoPrestamo> abonoprestamos,AbonoPrestamo abonoprestamo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(AbonoPrestamo abonoprestamoAux: abonoprestamos) {
			if(abonoprestamoAux!=null && abonoprestamo!=null) {
				if((abonoprestamoAux.getId()==null && abonoprestamo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(abonoprestamoAux.getId()!=null && abonoprestamo.getId()!=null){
					if(abonoprestamoAux.getId().equals(abonoprestamo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaAbonoPrestamo(List<AbonoPrestamo> abonoprestamos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double monto_capitalTotal=0.0;
		Double monto_interesTotal=0.0;
		Double valorTotal=0.0;
	
		for(AbonoPrestamo abonoprestamo: abonoprestamos) {			
			if(abonoprestamo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			monto_capitalTotal+=abonoprestamo.getmonto_capital();
			monto_interesTotal+=abonoprestamo.getmonto_interes();
			valorTotal+=abonoprestamo.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AbonoPrestamoConstantesFunciones.MONTOCAPITAL);
		datoGeneral.setsDescripcion(AbonoPrestamoConstantesFunciones.LABEL_MONTOCAPITAL);
		datoGeneral.setdValorDouble(monto_capitalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AbonoPrestamoConstantesFunciones.MONTOINTERES);
		datoGeneral.setsDescripcion(AbonoPrestamoConstantesFunciones.LABEL_MONTOINTERES);
		datoGeneral.setdValorDouble(monto_interesTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AbonoPrestamoConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(AbonoPrestamoConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaAbonoPrestamo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,AbonoPrestamoConstantesFunciones.LABEL_ID, AbonoPrestamoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AbonoPrestamoConstantesFunciones.LABEL_VERSIONROW, AbonoPrestamoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AbonoPrestamoConstantesFunciones.LABEL_IDPRESTAMO, AbonoPrestamoConstantesFunciones.IDPRESTAMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AbonoPrestamoConstantesFunciones.LABEL_NUMERO, AbonoPrestamoConstantesFunciones.NUMERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AbonoPrestamoConstantesFunciones.LABEL_MONTOCAPITAL, AbonoPrestamoConstantesFunciones.MONTOCAPITAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AbonoPrestamoConstantesFunciones.LABEL_MONTOINTERES, AbonoPrestamoConstantesFunciones.MONTOINTERES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AbonoPrestamoConstantesFunciones.LABEL_VALOR, AbonoPrestamoConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AbonoPrestamoConstantesFunciones.LABEL_FECHAVENCIMIENTO, AbonoPrestamoConstantesFunciones.FECHAVENCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AbonoPrestamoConstantesFunciones.LABEL_CODIGOQUINCENA, AbonoPrestamoConstantesFunciones.CODIGOQUINCENA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasAbonoPrestamo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=AbonoPrestamoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AbonoPrestamoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AbonoPrestamoConstantesFunciones.IDPRESTAMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AbonoPrestamoConstantesFunciones.NUMERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AbonoPrestamoConstantesFunciones.MONTOCAPITAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AbonoPrestamoConstantesFunciones.MONTOINTERES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AbonoPrestamoConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AbonoPrestamoConstantesFunciones.FECHAVENCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AbonoPrestamoConstantesFunciones.CODIGOQUINCENA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAbonoPrestamo() throws Exception  {
		return AbonoPrestamoConstantesFunciones.getTiposSeleccionarAbonoPrestamo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAbonoPrestamo(Boolean conFk) throws Exception  {
		return AbonoPrestamoConstantesFunciones.getTiposSeleccionarAbonoPrestamo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAbonoPrestamo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AbonoPrestamoConstantesFunciones.LABEL_IDPRESTAMO);
			reporte.setsDescripcion(AbonoPrestamoConstantesFunciones.LABEL_IDPRESTAMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AbonoPrestamoConstantesFunciones.LABEL_NUMERO);
			reporte.setsDescripcion(AbonoPrestamoConstantesFunciones.LABEL_NUMERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AbonoPrestamoConstantesFunciones.LABEL_MONTOCAPITAL);
			reporte.setsDescripcion(AbonoPrestamoConstantesFunciones.LABEL_MONTOCAPITAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AbonoPrestamoConstantesFunciones.LABEL_MONTOINTERES);
			reporte.setsDescripcion(AbonoPrestamoConstantesFunciones.LABEL_MONTOINTERES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AbonoPrestamoConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(AbonoPrestamoConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AbonoPrestamoConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(AbonoPrestamoConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AbonoPrestamoConstantesFunciones.LABEL_CODIGOQUINCENA);
			reporte.setsDescripcion(AbonoPrestamoConstantesFunciones.LABEL_CODIGOQUINCENA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesAbonoPrestamo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesAbonoPrestamo(AbonoPrestamo abonoprestamoAux) throws Exception {
		
			abonoprestamoAux.setprestamo_descripcion(PrestamoConstantesFunciones.getPrestamoDescripcion(abonoprestamoAux.getPrestamo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesAbonoPrestamo(List<AbonoPrestamo> abonoprestamosTemp) throws Exception {
		for(AbonoPrestamo abonoprestamoAux:abonoprestamosTemp) {
			
			abonoprestamoAux.setprestamo_descripcion(PrestamoConstantesFunciones.getPrestamoDescripcion(abonoprestamoAux.getPrestamo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfAbonoPrestamo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Prestamo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Prestamo.class)) {
						classes.add(new Classe(Prestamo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfAbonoPrestamo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Prestamo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Prestamo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Prestamo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Prestamo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfAbonoPrestamo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return AbonoPrestamoConstantesFunciones.getClassesRelationshipsOfAbonoPrestamo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAbonoPrestamo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAbonoPrestamo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return AbonoPrestamoConstantesFunciones.getClassesRelationshipsFromStringsOfAbonoPrestamo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAbonoPrestamo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(AbonoPrestamo abonoprestamo,List<AbonoPrestamo> abonoprestamos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			AbonoPrestamo abonoprestamoEncontrado=null;
			
			for(AbonoPrestamo abonoprestamoLocal:abonoprestamos) {
				if(abonoprestamoLocal.getId().equals(abonoprestamo.getId())) {
					abonoprestamoEncontrado=abonoprestamoLocal;
					
					abonoprestamoLocal.setIsChanged(abonoprestamo.getIsChanged());
					abonoprestamoLocal.setIsNew(abonoprestamo.getIsNew());
					abonoprestamoLocal.setIsDeleted(abonoprestamo.getIsDeleted());
					
					abonoprestamoLocal.setGeneralEntityOriginal(abonoprestamo.getGeneralEntityOriginal());
					
					abonoprestamoLocal.setId(abonoprestamo.getId());	
					abonoprestamoLocal.setVersionRow(abonoprestamo.getVersionRow());	
					abonoprestamoLocal.setid_prestamo(abonoprestamo.getid_prestamo());	
					abonoprestamoLocal.setnumero(abonoprestamo.getnumero());	
					abonoprestamoLocal.setmonto_capital(abonoprestamo.getmonto_capital());	
					abonoprestamoLocal.setmonto_interes(abonoprestamo.getmonto_interes());	
					abonoprestamoLocal.setvalor(abonoprestamo.getvalor());	
					abonoprestamoLocal.setfecha_vencimiento(abonoprestamo.getfecha_vencimiento());	
					abonoprestamoLocal.setcodigo_quincena(abonoprestamo.getcodigo_quincena());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!abonoprestamo.getIsDeleted()) {
				if(!existe) {
					abonoprestamos.add(abonoprestamo);
				}
			} else {
				if(abonoprestamoEncontrado!=null && permiteQuitar)  {
					abonoprestamos.remove(abonoprestamoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(AbonoPrestamo abonoprestamo,List<AbonoPrestamo> abonoprestamos) throws Exception {
		try	{			
			for(AbonoPrestamo abonoprestamoLocal:abonoprestamos) {
				if(abonoprestamoLocal.getId().equals(abonoprestamo.getId())) {
					abonoprestamoLocal.setIsSelected(abonoprestamo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesAbonoPrestamo(List<AbonoPrestamo> abonoprestamosAux) throws Exception {
		//this.abonoprestamosAux=abonoprestamosAux;
		
		for(AbonoPrestamo abonoprestamoAux:abonoprestamosAux) {
			if(abonoprestamoAux.getIsChanged()) {
				abonoprestamoAux.setIsChanged(false);
			}		
			
			if(abonoprestamoAux.getIsNew()) {
				abonoprestamoAux.setIsNew(false);
			}	
			
			if(abonoprestamoAux.getIsDeleted()) {
				abonoprestamoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesAbonoPrestamo(AbonoPrestamo abonoprestamoAux) throws Exception {
		//this.abonoprestamoAux=abonoprestamoAux;
		
			if(abonoprestamoAux.getIsChanged()) {
				abonoprestamoAux.setIsChanged(false);
			}		
			
			if(abonoprestamoAux.getIsNew()) {
				abonoprestamoAux.setIsNew(false);
			}	
			
			if(abonoprestamoAux.getIsDeleted()) {
				abonoprestamoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(AbonoPrestamo abonoprestamoAsignar,AbonoPrestamo abonoprestamo) throws Exception {
		abonoprestamoAsignar.setId(abonoprestamo.getId());	
		abonoprestamoAsignar.setVersionRow(abonoprestamo.getVersionRow());	
		abonoprestamoAsignar.setid_prestamo(abonoprestamo.getid_prestamo());
		abonoprestamoAsignar.setprestamo_descripcion(abonoprestamo.getprestamo_descripcion());	
		abonoprestamoAsignar.setnumero(abonoprestamo.getnumero());	
		abonoprestamoAsignar.setmonto_capital(abonoprestamo.getmonto_capital());	
		abonoprestamoAsignar.setmonto_interes(abonoprestamo.getmonto_interes());	
		abonoprestamoAsignar.setvalor(abonoprestamo.getvalor());	
		abonoprestamoAsignar.setfecha_vencimiento(abonoprestamo.getfecha_vencimiento());	
		abonoprestamoAsignar.setcodigo_quincena(abonoprestamo.getcodigo_quincena());	
	}
	
	public static void inicializarAbonoPrestamo(AbonoPrestamo abonoprestamo) throws Exception {
		try {
				abonoprestamo.setId(0L);	
					
				abonoprestamo.setid_prestamo(-1L);	
				abonoprestamo.setnumero(0);	
				abonoprestamo.setmonto_capital(0.0);	
				abonoprestamo.setmonto_interes(0.0);	
				abonoprestamo.setvalor(0.0);	
				abonoprestamo.setfecha_vencimiento(new Date());	
				abonoprestamo.setcodigo_quincena("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderAbonoPrestamo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(AbonoPrestamoConstantesFunciones.LABEL_IDPRESTAMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AbonoPrestamoConstantesFunciones.LABEL_NUMERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AbonoPrestamoConstantesFunciones.LABEL_MONTOCAPITAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AbonoPrestamoConstantesFunciones.LABEL_MONTOINTERES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AbonoPrestamoConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AbonoPrestamoConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AbonoPrestamoConstantesFunciones.LABEL_CODIGOQUINCENA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataAbonoPrestamo(String sTipo,Row row,Workbook workbook,AbonoPrestamo abonoprestamo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(abonoprestamo.getprestamo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(abonoprestamo.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(abonoprestamo.getmonto_capital());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(abonoprestamo.getmonto_interes());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(abonoprestamo.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(abonoprestamo.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(abonoprestamo.getcodigo_quincena());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryAbonoPrestamo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryAbonoPrestamo() {
		return this.sFinalQueryAbonoPrestamo;
	}
	
	public void setsFinalQueryAbonoPrestamo(String sFinalQueryAbonoPrestamo) {
		this.sFinalQueryAbonoPrestamo= sFinalQueryAbonoPrestamo;
	}
	
	public Border resaltarSeleccionarAbonoPrestamo=null;
	
	public Border setResaltarSeleccionarAbonoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*AbonoPrestamoBeanSwingJInternalFrame abonoprestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//abonoprestamoBeanSwingJInternalFrame.jTtoolBarAbonoPrestamo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarAbonoPrestamo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarAbonoPrestamo() {
		return this.resaltarSeleccionarAbonoPrestamo;
	}
	
	public void setResaltarSeleccionarAbonoPrestamo(Border borderResaltarSeleccionarAbonoPrestamo) {
		this.resaltarSeleccionarAbonoPrestamo= borderResaltarSeleccionarAbonoPrestamo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridAbonoPrestamo=null;
	public Boolean mostraridAbonoPrestamo=true;
	public Boolean activaridAbonoPrestamo=true;

	public Border resaltarid_prestamoAbonoPrestamo=null;
	public Boolean mostrarid_prestamoAbonoPrestamo=true;
	public Boolean activarid_prestamoAbonoPrestamo=true;
	public Boolean cargarid_prestamoAbonoPrestamo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_prestamoAbonoPrestamo=false;//ConEventDepend=true

	public Border resaltarnumeroAbonoPrestamo=null;
	public Boolean mostrarnumeroAbonoPrestamo=true;
	public Boolean activarnumeroAbonoPrestamo=true;

	public Border resaltarmonto_capitalAbonoPrestamo=null;
	public Boolean mostrarmonto_capitalAbonoPrestamo=true;
	public Boolean activarmonto_capitalAbonoPrestamo=true;

	public Border resaltarmonto_interesAbonoPrestamo=null;
	public Boolean mostrarmonto_interesAbonoPrestamo=true;
	public Boolean activarmonto_interesAbonoPrestamo=true;

	public Border resaltarvalorAbonoPrestamo=null;
	public Boolean mostrarvalorAbonoPrestamo=true;
	public Boolean activarvalorAbonoPrestamo=true;

	public Border resaltarfecha_vencimientoAbonoPrestamo=null;
	public Boolean mostrarfecha_vencimientoAbonoPrestamo=true;
	public Boolean activarfecha_vencimientoAbonoPrestamo=false;

	public Border resaltarcodigo_quincenaAbonoPrestamo=null;
	public Boolean mostrarcodigo_quincenaAbonoPrestamo=true;
	public Boolean activarcodigo_quincenaAbonoPrestamo=true;

	
	

	public Border setResaltaridAbonoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*AbonoPrestamoBeanSwingJInternalFrame abonoprestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//abonoprestamoBeanSwingJInternalFrame.jTtoolBarAbonoPrestamo.setBorder(borderResaltar);
		
		this.resaltaridAbonoPrestamo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridAbonoPrestamo() {
		return this.resaltaridAbonoPrestamo;
	}

	public void setResaltaridAbonoPrestamo(Border borderResaltar) {
		this.resaltaridAbonoPrestamo= borderResaltar;
	}

	public Boolean getMostraridAbonoPrestamo() {
		return this.mostraridAbonoPrestamo;
	}

	public void setMostraridAbonoPrestamo(Boolean mostraridAbonoPrestamo) {
		this.mostraridAbonoPrestamo= mostraridAbonoPrestamo;
	}

	public Boolean getActivaridAbonoPrestamo() {
		return this.activaridAbonoPrestamo;
	}

	public void setActivaridAbonoPrestamo(Boolean activaridAbonoPrestamo) {
		this.activaridAbonoPrestamo= activaridAbonoPrestamo;
	}

	public Border setResaltarid_prestamoAbonoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*AbonoPrestamoBeanSwingJInternalFrame abonoprestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//abonoprestamoBeanSwingJInternalFrame.jTtoolBarAbonoPrestamo.setBorder(borderResaltar);
		
		this.resaltarid_prestamoAbonoPrestamo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_prestamoAbonoPrestamo() {
		return this.resaltarid_prestamoAbonoPrestamo;
	}

	public void setResaltarid_prestamoAbonoPrestamo(Border borderResaltar) {
		this.resaltarid_prestamoAbonoPrestamo= borderResaltar;
	}

	public Boolean getMostrarid_prestamoAbonoPrestamo() {
		return this.mostrarid_prestamoAbonoPrestamo;
	}

	public void setMostrarid_prestamoAbonoPrestamo(Boolean mostrarid_prestamoAbonoPrestamo) {
		this.mostrarid_prestamoAbonoPrestamo= mostrarid_prestamoAbonoPrestamo;
	}

	public Boolean getActivarid_prestamoAbonoPrestamo() {
		return this.activarid_prestamoAbonoPrestamo;
	}

	public void setActivarid_prestamoAbonoPrestamo(Boolean activarid_prestamoAbonoPrestamo) {
		this.activarid_prestamoAbonoPrestamo= activarid_prestamoAbonoPrestamo;
	}

	public Boolean getCargarid_prestamoAbonoPrestamo() {
		return this.cargarid_prestamoAbonoPrestamo;
	}

	public void setCargarid_prestamoAbonoPrestamo(Boolean cargarid_prestamoAbonoPrestamo) {
		this.cargarid_prestamoAbonoPrestamo= cargarid_prestamoAbonoPrestamo;
	}

	public Border setResaltarnumeroAbonoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*AbonoPrestamoBeanSwingJInternalFrame abonoprestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//abonoprestamoBeanSwingJInternalFrame.jTtoolBarAbonoPrestamo.setBorder(borderResaltar);
		
		this.resaltarnumeroAbonoPrestamo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroAbonoPrestamo() {
		return this.resaltarnumeroAbonoPrestamo;
	}

	public void setResaltarnumeroAbonoPrestamo(Border borderResaltar) {
		this.resaltarnumeroAbonoPrestamo= borderResaltar;
	}

	public Boolean getMostrarnumeroAbonoPrestamo() {
		return this.mostrarnumeroAbonoPrestamo;
	}

	public void setMostrarnumeroAbonoPrestamo(Boolean mostrarnumeroAbonoPrestamo) {
		this.mostrarnumeroAbonoPrestamo= mostrarnumeroAbonoPrestamo;
	}

	public Boolean getActivarnumeroAbonoPrestamo() {
		return this.activarnumeroAbonoPrestamo;
	}

	public void setActivarnumeroAbonoPrestamo(Boolean activarnumeroAbonoPrestamo) {
		this.activarnumeroAbonoPrestamo= activarnumeroAbonoPrestamo;
	}

	public Border setResaltarmonto_capitalAbonoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*AbonoPrestamoBeanSwingJInternalFrame abonoprestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//abonoprestamoBeanSwingJInternalFrame.jTtoolBarAbonoPrestamo.setBorder(borderResaltar);
		
		this.resaltarmonto_capitalAbonoPrestamo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_capitalAbonoPrestamo() {
		return this.resaltarmonto_capitalAbonoPrestamo;
	}

	public void setResaltarmonto_capitalAbonoPrestamo(Border borderResaltar) {
		this.resaltarmonto_capitalAbonoPrestamo= borderResaltar;
	}

	public Boolean getMostrarmonto_capitalAbonoPrestamo() {
		return this.mostrarmonto_capitalAbonoPrestamo;
	}

	public void setMostrarmonto_capitalAbonoPrestamo(Boolean mostrarmonto_capitalAbonoPrestamo) {
		this.mostrarmonto_capitalAbonoPrestamo= mostrarmonto_capitalAbonoPrestamo;
	}

	public Boolean getActivarmonto_capitalAbonoPrestamo() {
		return this.activarmonto_capitalAbonoPrestamo;
	}

	public void setActivarmonto_capitalAbonoPrestamo(Boolean activarmonto_capitalAbonoPrestamo) {
		this.activarmonto_capitalAbonoPrestamo= activarmonto_capitalAbonoPrestamo;
	}

	public Border setResaltarmonto_interesAbonoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*AbonoPrestamoBeanSwingJInternalFrame abonoprestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//abonoprestamoBeanSwingJInternalFrame.jTtoolBarAbonoPrestamo.setBorder(borderResaltar);
		
		this.resaltarmonto_interesAbonoPrestamo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_interesAbonoPrestamo() {
		return this.resaltarmonto_interesAbonoPrestamo;
	}

	public void setResaltarmonto_interesAbonoPrestamo(Border borderResaltar) {
		this.resaltarmonto_interesAbonoPrestamo= borderResaltar;
	}

	public Boolean getMostrarmonto_interesAbonoPrestamo() {
		return this.mostrarmonto_interesAbonoPrestamo;
	}

	public void setMostrarmonto_interesAbonoPrestamo(Boolean mostrarmonto_interesAbonoPrestamo) {
		this.mostrarmonto_interesAbonoPrestamo= mostrarmonto_interesAbonoPrestamo;
	}

	public Boolean getActivarmonto_interesAbonoPrestamo() {
		return this.activarmonto_interesAbonoPrestamo;
	}

	public void setActivarmonto_interesAbonoPrestamo(Boolean activarmonto_interesAbonoPrestamo) {
		this.activarmonto_interesAbonoPrestamo= activarmonto_interesAbonoPrestamo;
	}

	public Border setResaltarvalorAbonoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*AbonoPrestamoBeanSwingJInternalFrame abonoprestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//abonoprestamoBeanSwingJInternalFrame.jTtoolBarAbonoPrestamo.setBorder(borderResaltar);
		
		this.resaltarvalorAbonoPrestamo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorAbonoPrestamo() {
		return this.resaltarvalorAbonoPrestamo;
	}

	public void setResaltarvalorAbonoPrestamo(Border borderResaltar) {
		this.resaltarvalorAbonoPrestamo= borderResaltar;
	}

	public Boolean getMostrarvalorAbonoPrestamo() {
		return this.mostrarvalorAbonoPrestamo;
	}

	public void setMostrarvalorAbonoPrestamo(Boolean mostrarvalorAbonoPrestamo) {
		this.mostrarvalorAbonoPrestamo= mostrarvalorAbonoPrestamo;
	}

	public Boolean getActivarvalorAbonoPrestamo() {
		return this.activarvalorAbonoPrestamo;
	}

	public void setActivarvalorAbonoPrestamo(Boolean activarvalorAbonoPrestamo) {
		this.activarvalorAbonoPrestamo= activarvalorAbonoPrestamo;
	}

	public Border setResaltarfecha_vencimientoAbonoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*AbonoPrestamoBeanSwingJInternalFrame abonoprestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//abonoprestamoBeanSwingJInternalFrame.jTtoolBarAbonoPrestamo.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoAbonoPrestamo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoAbonoPrestamo() {
		return this.resaltarfecha_vencimientoAbonoPrestamo;
	}

	public void setResaltarfecha_vencimientoAbonoPrestamo(Border borderResaltar) {
		this.resaltarfecha_vencimientoAbonoPrestamo= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoAbonoPrestamo() {
		return this.mostrarfecha_vencimientoAbonoPrestamo;
	}

	public void setMostrarfecha_vencimientoAbonoPrestamo(Boolean mostrarfecha_vencimientoAbonoPrestamo) {
		this.mostrarfecha_vencimientoAbonoPrestamo= mostrarfecha_vencimientoAbonoPrestamo;
	}

	public Boolean getActivarfecha_vencimientoAbonoPrestamo() {
		return this.activarfecha_vencimientoAbonoPrestamo;
	}

	public void setActivarfecha_vencimientoAbonoPrestamo(Boolean activarfecha_vencimientoAbonoPrestamo) {
		this.activarfecha_vencimientoAbonoPrestamo= activarfecha_vencimientoAbonoPrestamo;
	}

	public Border setResaltarcodigo_quincenaAbonoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*AbonoPrestamoBeanSwingJInternalFrame abonoprestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//abonoprestamoBeanSwingJInternalFrame.jTtoolBarAbonoPrestamo.setBorder(borderResaltar);
		
		this.resaltarcodigo_quincenaAbonoPrestamo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_quincenaAbonoPrestamo() {
		return this.resaltarcodigo_quincenaAbonoPrestamo;
	}

	public void setResaltarcodigo_quincenaAbonoPrestamo(Border borderResaltar) {
		this.resaltarcodigo_quincenaAbonoPrestamo= borderResaltar;
	}

	public Boolean getMostrarcodigo_quincenaAbonoPrestamo() {
		return this.mostrarcodigo_quincenaAbonoPrestamo;
	}

	public void setMostrarcodigo_quincenaAbonoPrestamo(Boolean mostrarcodigo_quincenaAbonoPrestamo) {
		this.mostrarcodigo_quincenaAbonoPrestamo= mostrarcodigo_quincenaAbonoPrestamo;
	}

	public Boolean getActivarcodigo_quincenaAbonoPrestamo() {
		return this.activarcodigo_quincenaAbonoPrestamo;
	}

	public void setActivarcodigo_quincenaAbonoPrestamo(Boolean activarcodigo_quincenaAbonoPrestamo) {
		this.activarcodigo_quincenaAbonoPrestamo= activarcodigo_quincenaAbonoPrestamo;
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
		
		
		this.setMostraridAbonoPrestamo(esInicial);
		this.setMostrarid_prestamoAbonoPrestamo(esInicial);
		this.setMostrarnumeroAbonoPrestamo(esInicial);
		this.setMostrarmonto_capitalAbonoPrestamo(esInicial);
		this.setMostrarmonto_interesAbonoPrestamo(esInicial);
		this.setMostrarvalorAbonoPrestamo(esInicial);
		this.setMostrarfecha_vencimientoAbonoPrestamo(esInicial);
		this.setMostrarcodigo_quincenaAbonoPrestamo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AbonoPrestamoConstantesFunciones.ID)) {
				this.setMostraridAbonoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(AbonoPrestamoConstantesFunciones.IDPRESTAMO)) {
				this.setMostrarid_prestamoAbonoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(AbonoPrestamoConstantesFunciones.NUMERO)) {
				this.setMostrarnumeroAbonoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(AbonoPrestamoConstantesFunciones.MONTOCAPITAL)) {
				this.setMostrarmonto_capitalAbonoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(AbonoPrestamoConstantesFunciones.MONTOINTERES)) {
				this.setMostrarmonto_interesAbonoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(AbonoPrestamoConstantesFunciones.VALOR)) {
				this.setMostrarvalorAbonoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(AbonoPrestamoConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoAbonoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(AbonoPrestamoConstantesFunciones.CODIGOQUINCENA)) {
				this.setMostrarcodigo_quincenaAbonoPrestamo(esAsigna);
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
		
		
		this.setActivaridAbonoPrestamo(esInicial);
		this.setActivarid_prestamoAbonoPrestamo(esInicial);
		this.setActivarnumeroAbonoPrestamo(esInicial);
		this.setActivarmonto_capitalAbonoPrestamo(esInicial);
		this.setActivarmonto_interesAbonoPrestamo(esInicial);
		this.setActivarvalorAbonoPrestamo(esInicial);
		this.setActivarfecha_vencimientoAbonoPrestamo(esInicial);
		this.setActivarcodigo_quincenaAbonoPrestamo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AbonoPrestamoConstantesFunciones.ID)) {
				this.setActivaridAbonoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(AbonoPrestamoConstantesFunciones.IDPRESTAMO)) {
				this.setActivarid_prestamoAbonoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(AbonoPrestamoConstantesFunciones.NUMERO)) {
				this.setActivarnumeroAbonoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(AbonoPrestamoConstantesFunciones.MONTOCAPITAL)) {
				this.setActivarmonto_capitalAbonoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(AbonoPrestamoConstantesFunciones.MONTOINTERES)) {
				this.setActivarmonto_interesAbonoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(AbonoPrestamoConstantesFunciones.VALOR)) {
				this.setActivarvalorAbonoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(AbonoPrestamoConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoAbonoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(AbonoPrestamoConstantesFunciones.CODIGOQUINCENA)) {
				this.setActivarcodigo_quincenaAbonoPrestamo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,AbonoPrestamoBeanSwingJInternalFrame abonoprestamoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridAbonoPrestamo(esInicial);
		this.setResaltarid_prestamoAbonoPrestamo(esInicial);
		this.setResaltarnumeroAbonoPrestamo(esInicial);
		this.setResaltarmonto_capitalAbonoPrestamo(esInicial);
		this.setResaltarmonto_interesAbonoPrestamo(esInicial);
		this.setResaltarvalorAbonoPrestamo(esInicial);
		this.setResaltarfecha_vencimientoAbonoPrestamo(esInicial);
		this.setResaltarcodigo_quincenaAbonoPrestamo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AbonoPrestamoConstantesFunciones.ID)) {
				this.setResaltaridAbonoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(AbonoPrestamoConstantesFunciones.IDPRESTAMO)) {
				this.setResaltarid_prestamoAbonoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(AbonoPrestamoConstantesFunciones.NUMERO)) {
				this.setResaltarnumeroAbonoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(AbonoPrestamoConstantesFunciones.MONTOCAPITAL)) {
				this.setResaltarmonto_capitalAbonoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(AbonoPrestamoConstantesFunciones.MONTOINTERES)) {
				this.setResaltarmonto_interesAbonoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(AbonoPrestamoConstantesFunciones.VALOR)) {
				this.setResaltarvalorAbonoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(AbonoPrestamoConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoAbonoPrestamo(esAsigna);
				continue;
			}

			if(campo.clase.equals(AbonoPrestamoConstantesFunciones.CODIGOQUINCENA)) {
				this.setResaltarcodigo_quincenaAbonoPrestamo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,AbonoPrestamoBeanSwingJInternalFrame abonoprestamoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdPrestamoAbonoPrestamo=true;

	public Boolean getMostrarFK_IdPrestamoAbonoPrestamo() {
		return this.mostrarFK_IdPrestamoAbonoPrestamo;
	}

	public void setMostrarFK_IdPrestamoAbonoPrestamo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPrestamoAbonoPrestamo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdPrestamoAbonoPrestamo=true;

	public Boolean getActivarFK_IdPrestamoAbonoPrestamo() {
		return this.activarFK_IdPrestamoAbonoPrestamo;
	}

	public void setActivarFK_IdPrestamoAbonoPrestamo(Boolean habilitarResaltar) {
		this.activarFK_IdPrestamoAbonoPrestamo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdPrestamoAbonoPrestamo=null;

	public Border getResaltarFK_IdPrestamoAbonoPrestamo() {
		return this.resaltarFK_IdPrestamoAbonoPrestamo;
	}

	public void setResaltarFK_IdPrestamoAbonoPrestamo(Border borderResaltar) {
		this.resaltarFK_IdPrestamoAbonoPrestamo= borderResaltar;
	}

	public void setResaltarFK_IdPrestamoAbonoPrestamo(ParametroGeneralUsuario parametroGeneralUsuario/*AbonoPrestamoBeanSwingJInternalFrame abonoprestamoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPrestamoAbonoPrestamo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}