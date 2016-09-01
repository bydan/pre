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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.TransaccionIngresoEgresoConstantesFunciones;
import com.bydan.erp.inventario.util.TransaccionIngresoEgresoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TransaccionIngresoEgresoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TransaccionIngresoEgresoConstantesFunciones extends TransaccionIngresoEgresoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TransaccionIngresoEgreso";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TransaccionIngresoEgreso"+TransaccionIngresoEgresoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TransaccionIngresoEgresoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TransaccionIngresoEgresoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TransaccionIngresoEgresoConstantesFunciones.SCHEMA+"_"+TransaccionIngresoEgresoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TransaccionIngresoEgresoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TransaccionIngresoEgresoConstantesFunciones.SCHEMA+"_"+TransaccionIngresoEgresoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TransaccionIngresoEgresoConstantesFunciones.SCHEMA+"_"+TransaccionIngresoEgresoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TransaccionIngresoEgresoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TransaccionIngresoEgresoConstantesFunciones.SCHEMA+"_"+TransaccionIngresoEgresoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransaccionIngresoEgresoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TransaccionIngresoEgresoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransaccionIngresoEgresoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransaccionIngresoEgresoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TransaccionIngresoEgresoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransaccionIngresoEgresoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TransaccionIngresoEgresoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TransaccionIngresoEgresoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TransaccionIngresoEgresoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TransaccionIngresoEgresoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Transaccion Ingreso Egresoes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Transaccion Ingreso Egreso";
	public static final String SCLASSWEBTITULO_LOWER="Transaccion Ingreso Egreso";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TransaccionIngresoEgreso";
	public static final String OBJECTNAME="transaccioningresoegreso";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="transaccion_ingreso_egreso";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select transaccioningresoegreso from "+TransaccionIngresoEgresoConstantesFunciones.SPERSISTENCENAME+" transaccioningresoegreso";
	public static String QUERYSELECTNATIVE="select "+TransaccionIngresoEgresoConstantesFunciones.SCHEMA+"."+TransaccionIngresoEgresoConstantesFunciones.TABLENAME+".id,"+TransaccionIngresoEgresoConstantesFunciones.SCHEMA+"."+TransaccionIngresoEgresoConstantesFunciones.TABLENAME+".version_row,"+TransaccionIngresoEgresoConstantesFunciones.SCHEMA+"."+TransaccionIngresoEgresoConstantesFunciones.TABLENAME+".id_empresa,"+TransaccionIngresoEgresoConstantesFunciones.SCHEMA+"."+TransaccionIngresoEgresoConstantesFunciones.TABLENAME+".id_modulo,"+TransaccionIngresoEgresoConstantesFunciones.SCHEMA+"."+TransaccionIngresoEgresoConstantesFunciones.TABLENAME+".id_transaccion,"+TransaccionIngresoEgresoConstantesFunciones.SCHEMA+"."+TransaccionIngresoEgresoConstantesFunciones.TABLENAME+".es_ingreso from "+TransaccionIngresoEgresoConstantesFunciones.SCHEMA+"."+TransaccionIngresoEgresoConstantesFunciones.TABLENAME;//+" as "+TransaccionIngresoEgresoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TransaccionIngresoEgresoConstantesFuncionesAdditional transaccioningresoegresoConstantesFuncionesAdditional=null;
	
	public TransaccionIngresoEgresoConstantesFuncionesAdditional getTransaccionIngresoEgresoConstantesFuncionesAdditional() {
		return this.transaccioningresoegresoConstantesFuncionesAdditional;
	}
	
	public void setTransaccionIngresoEgresoConstantesFuncionesAdditional(TransaccionIngresoEgresoConstantesFuncionesAdditional transaccioningresoegresoConstantesFuncionesAdditional) {
		try {
			this.transaccioningresoegresoConstantesFuncionesAdditional=transaccioningresoegresoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDMODULO= "id_modulo";
    public static final String IDTRANSACCION= "id_transaccion";
    public static final String ESINGRESO= "es_ingreso";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDTRANSACCION= "Transaccion";
		public static final String LABEL_IDTRANSACCION_LOWER= "Transaccion";
    	public static final String LABEL_ESINGRESO= "Es Ingreso";
		public static final String LABEL_ESINGRESO_LOWER= "Es Ingreso";
	
		
		
		
		
		
		
	
	public static String getTransaccionIngresoEgresoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TransaccionIngresoEgresoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TransaccionIngresoEgresoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TransaccionIngresoEgresoConstantesFunciones.IDMODULO)) {sLabelColumna=TransaccionIngresoEgresoConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(TransaccionIngresoEgresoConstantesFunciones.IDTRANSACCION)) {sLabelColumna=TransaccionIngresoEgresoConstantesFunciones.LABEL_IDTRANSACCION;}
		if(sNombreColumna.equals(TransaccionIngresoEgresoConstantesFunciones.ESINGRESO)) {sLabelColumna=TransaccionIngresoEgresoConstantesFunciones.LABEL_ESINGRESO;}
		
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
	
	
	
			
			
			
			
			
		
	public static String getes_ingresoDescripcion(TransaccionIngresoEgreso transaccioningresoegreso) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!transaccioningresoegreso.getes_ingreso()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_ingresoHtmlDescripcion(TransaccionIngresoEgreso transaccioningresoegreso) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(transaccioningresoegreso.getId(),transaccioningresoegreso.getes_ingreso());

		return sDescripcion;
	}	
	
	public static String getTransaccionIngresoEgresoDescripcion(TransaccionIngresoEgreso transaccioningresoegreso) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(transaccioningresoegreso !=null/* && transaccioningresoegreso.getId()!=0*/) {
			if(transaccioningresoegreso.getId()!=null) {
				sDescripcion=transaccioningresoegreso.getId().toString();
			}//transaccioningresoegresotransaccioningresoegreso.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTransaccionIngresoEgresoDescripcionDetallado(TransaccionIngresoEgreso transaccioningresoegreso) {
		String sDescripcion="";
			
		sDescripcion+=TransaccionIngresoEgresoConstantesFunciones.ID+"=";
		sDescripcion+=transaccioningresoegreso.getId().toString()+",";
		sDescripcion+=TransaccionIngresoEgresoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=transaccioningresoegreso.getVersionRow().toString()+",";
		sDescripcion+=TransaccionIngresoEgresoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=transaccioningresoegreso.getid_empresa().toString()+",";
		sDescripcion+=TransaccionIngresoEgresoConstantesFunciones.IDMODULO+"=";
		sDescripcion+=transaccioningresoegreso.getid_modulo().toString()+",";
		sDescripcion+=TransaccionIngresoEgresoConstantesFunciones.IDTRANSACCION+"=";
		sDescripcion+=transaccioningresoegreso.getid_transaccion().toString()+",";
		sDescripcion+=TransaccionIngresoEgresoConstantesFunciones.ESINGRESO+"=";
		sDescripcion+=transaccioningresoegreso.getes_ingreso().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTransaccionIngresoEgresoDescripcion(TransaccionIngresoEgreso transaccioningresoegreso,String sValor) throws Exception {			
		if(transaccioningresoegreso !=null) {
			//transaccioningresoegresotransaccioningresoegreso.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
		}

		return sDescripcion;
	}

	public static String getTransaccionDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdTransaccion")) {
			sNombreIndice="Tipo=  Por Transaccion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion(Long id_transaccion) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Transaccion="+id_transaccion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTransaccionIngresoEgreso(TransaccionIngresoEgreso transaccioningresoegreso,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosTransaccionIngresoEgresos(List<TransaccionIngresoEgreso> transaccioningresoegresos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TransaccionIngresoEgreso transaccioningresoegreso: transaccioningresoegresos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTransaccionIngresoEgreso(TransaccionIngresoEgreso transaccioningresoegreso,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && transaccioningresoegreso.getConCambioAuxiliar()) {
			transaccioningresoegreso.setIsDeleted(transaccioningresoegreso.getIsDeletedAuxiliar());	
			transaccioningresoegreso.setIsNew(transaccioningresoegreso.getIsNewAuxiliar());	
			transaccioningresoegreso.setIsChanged(transaccioningresoegreso.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			transaccioningresoegreso.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			transaccioningresoegreso.setIsDeletedAuxiliar(false);	
			transaccioningresoegreso.setIsNewAuxiliar(false);	
			transaccioningresoegreso.setIsChangedAuxiliar(false);
			
			transaccioningresoegreso.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTransaccionIngresoEgresos(List<TransaccionIngresoEgreso> transaccioningresoegresos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TransaccionIngresoEgreso transaccioningresoegreso : transaccioningresoegresos) {
			if(conAsignarBase && transaccioningresoegreso.getConCambioAuxiliar()) {
				transaccioningresoegreso.setIsDeleted(transaccioningresoegreso.getIsDeletedAuxiliar());	
				transaccioningresoegreso.setIsNew(transaccioningresoegreso.getIsNewAuxiliar());	
				transaccioningresoegreso.setIsChanged(transaccioningresoegreso.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				transaccioningresoegreso.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				transaccioningresoegreso.setIsDeletedAuxiliar(false);	
				transaccioningresoegreso.setIsNewAuxiliar(false);	
				transaccioningresoegreso.setIsChangedAuxiliar(false);
				
				transaccioningresoegreso.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTransaccionIngresoEgreso(TransaccionIngresoEgreso transaccioningresoegreso,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTransaccionIngresoEgresos(List<TransaccionIngresoEgreso> transaccioningresoegresos,Boolean conEnteros) throws Exception  {
		
		for(TransaccionIngresoEgreso transaccioningresoegreso: transaccioningresoegresos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTransaccionIngresoEgreso(List<TransaccionIngresoEgreso> transaccioningresoegresos,TransaccionIngresoEgreso transaccioningresoegresoAux) throws Exception  {
		TransaccionIngresoEgresoConstantesFunciones.InicializarValoresTransaccionIngresoEgreso(transaccioningresoegresoAux,true);
		
		for(TransaccionIngresoEgreso transaccioningresoegreso: transaccioningresoegresos) {
			if(transaccioningresoegreso.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTransaccionIngresoEgreso(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TransaccionIngresoEgresoConstantesFunciones.getArrayColumnasGlobalesTransaccionIngresoEgreso(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTransaccionIngresoEgreso(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TransaccionIngresoEgresoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TransaccionIngresoEgresoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TransaccionIngresoEgresoConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TransaccionIngresoEgresoConstantesFunciones.IDMODULO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTransaccionIngresoEgreso(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TransaccionIngresoEgreso> transaccioningresoegresos,TransaccionIngresoEgreso transaccioningresoegreso,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TransaccionIngresoEgreso transaccioningresoegresoAux: transaccioningresoegresos) {
			if(transaccioningresoegresoAux!=null && transaccioningresoegreso!=null) {
				if((transaccioningresoegresoAux.getId()==null && transaccioningresoegreso.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(transaccioningresoegresoAux.getId()!=null && transaccioningresoegreso.getId()!=null){
					if(transaccioningresoegresoAux.getId().equals(transaccioningresoegreso.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTransaccionIngresoEgreso(List<TransaccionIngresoEgreso> transaccioningresoegresos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TransaccionIngresoEgreso transaccioningresoegreso: transaccioningresoegresos) {			
			if(transaccioningresoegreso.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTransaccionIngresoEgreso() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TransaccionIngresoEgresoConstantesFunciones.LABEL_ID, TransaccionIngresoEgresoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionIngresoEgresoConstantesFunciones.LABEL_VERSIONROW, TransaccionIngresoEgresoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionIngresoEgresoConstantesFunciones.LABEL_IDEMPRESA, TransaccionIngresoEgresoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionIngresoEgresoConstantesFunciones.LABEL_IDMODULO, TransaccionIngresoEgresoConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionIngresoEgresoConstantesFunciones.LABEL_IDTRANSACCION, TransaccionIngresoEgresoConstantesFunciones.IDTRANSACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionIngresoEgresoConstantesFunciones.LABEL_ESINGRESO, TransaccionIngresoEgresoConstantesFunciones.ESINGRESO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTransaccionIngresoEgreso() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TransaccionIngresoEgresoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionIngresoEgresoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionIngresoEgresoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionIngresoEgresoConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionIngresoEgresoConstantesFunciones.IDTRANSACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionIngresoEgresoConstantesFunciones.ESINGRESO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransaccionIngresoEgreso() throws Exception  {
		return TransaccionIngresoEgresoConstantesFunciones.getTiposSeleccionarTransaccionIngresoEgreso(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransaccionIngresoEgreso(Boolean conFk) throws Exception  {
		return TransaccionIngresoEgresoConstantesFunciones.getTiposSeleccionarTransaccionIngresoEgreso(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransaccionIngresoEgreso(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionIngresoEgresoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TransaccionIngresoEgresoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionIngresoEgresoConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(TransaccionIngresoEgresoConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionIngresoEgresoConstantesFunciones.LABEL_IDTRANSACCION);
			reporte.setsDescripcion(TransaccionIngresoEgresoConstantesFunciones.LABEL_IDTRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionIngresoEgresoConstantesFunciones.LABEL_ESINGRESO);
			reporte.setsDescripcion(TransaccionIngresoEgresoConstantesFunciones.LABEL_ESINGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTransaccionIngresoEgreso(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTransaccionIngresoEgreso(TransaccionIngresoEgreso transaccioningresoegresoAux) throws Exception {
		
			transaccioningresoegresoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(transaccioningresoegresoAux.getEmpresa()));
			transaccioningresoegresoAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(transaccioningresoegresoAux.getModulo()));
			transaccioningresoegresoAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(transaccioningresoegresoAux.getTransaccion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTransaccionIngresoEgreso(List<TransaccionIngresoEgreso> transaccioningresoegresosTemp) throws Exception {
		for(TransaccionIngresoEgreso transaccioningresoegresoAux:transaccioningresoegresosTemp) {
			
			transaccioningresoegresoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(transaccioningresoegresoAux.getEmpresa()));
			transaccioningresoegresoAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(transaccioningresoegresoAux.getModulo()));
			transaccioningresoegresoAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(transaccioningresoegresoAux.getTransaccion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTransaccionIngresoEgreso(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(Transaccion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTransaccionIngresoEgreso(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransaccionIngresoEgreso(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TransaccionIngresoEgresoConstantesFunciones.getClassesRelationshipsOfTransaccionIngresoEgreso(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransaccionIngresoEgreso(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTransaccionIngresoEgreso(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TransaccionIngresoEgresoConstantesFunciones.getClassesRelationshipsFromStringsOfTransaccionIngresoEgreso(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTransaccionIngresoEgreso(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TransaccionIngresoEgreso transaccioningresoegreso,List<TransaccionIngresoEgreso> transaccioningresoegresos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TransaccionIngresoEgreso transaccioningresoegresoEncontrado=null;
			
			for(TransaccionIngresoEgreso transaccioningresoegresoLocal:transaccioningresoegresos) {
				if(transaccioningresoegresoLocal.getId().equals(transaccioningresoegreso.getId())) {
					transaccioningresoegresoEncontrado=transaccioningresoegresoLocal;
					
					transaccioningresoegresoLocal.setIsChanged(transaccioningresoegreso.getIsChanged());
					transaccioningresoegresoLocal.setIsNew(transaccioningresoegreso.getIsNew());
					transaccioningresoegresoLocal.setIsDeleted(transaccioningresoegreso.getIsDeleted());
					
					transaccioningresoegresoLocal.setGeneralEntityOriginal(transaccioningresoegreso.getGeneralEntityOriginal());
					
					transaccioningresoegresoLocal.setId(transaccioningresoegreso.getId());	
					transaccioningresoegresoLocal.setVersionRow(transaccioningresoegreso.getVersionRow());	
					transaccioningresoegresoLocal.setid_empresa(transaccioningresoegreso.getid_empresa());	
					transaccioningresoegresoLocal.setid_modulo(transaccioningresoegreso.getid_modulo());	
					transaccioningresoegresoLocal.setid_transaccion(transaccioningresoegreso.getid_transaccion());	
					transaccioningresoegresoLocal.setes_ingreso(transaccioningresoegreso.getes_ingreso());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!transaccioningresoegreso.getIsDeleted()) {
				if(!existe) {
					transaccioningresoegresos.add(transaccioningresoegreso);
				}
			} else {
				if(transaccioningresoegresoEncontrado!=null && permiteQuitar)  {
					transaccioningresoegresos.remove(transaccioningresoegresoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TransaccionIngresoEgreso transaccioningresoegreso,List<TransaccionIngresoEgreso> transaccioningresoegresos) throws Exception {
		try	{			
			for(TransaccionIngresoEgreso transaccioningresoegresoLocal:transaccioningresoegresos) {
				if(transaccioningresoegresoLocal.getId().equals(transaccioningresoegreso.getId())) {
					transaccioningresoegresoLocal.setIsSelected(transaccioningresoegreso.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTransaccionIngresoEgreso(List<TransaccionIngresoEgreso> transaccioningresoegresosAux) throws Exception {
		//this.transaccioningresoegresosAux=transaccioningresoegresosAux;
		
		for(TransaccionIngresoEgreso transaccioningresoegresoAux:transaccioningresoegresosAux) {
			if(transaccioningresoegresoAux.getIsChanged()) {
				transaccioningresoegresoAux.setIsChanged(false);
			}		
			
			if(transaccioningresoegresoAux.getIsNew()) {
				transaccioningresoegresoAux.setIsNew(false);
			}	
			
			if(transaccioningresoegresoAux.getIsDeleted()) {
				transaccioningresoegresoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTransaccionIngresoEgreso(TransaccionIngresoEgreso transaccioningresoegresoAux) throws Exception {
		//this.transaccioningresoegresoAux=transaccioningresoegresoAux;
		
			if(transaccioningresoegresoAux.getIsChanged()) {
				transaccioningresoegresoAux.setIsChanged(false);
			}		
			
			if(transaccioningresoegresoAux.getIsNew()) {
				transaccioningresoegresoAux.setIsNew(false);
			}	
			
			if(transaccioningresoegresoAux.getIsDeleted()) {
				transaccioningresoegresoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TransaccionIngresoEgreso transaccioningresoegresoAsignar,TransaccionIngresoEgreso transaccioningresoegreso) throws Exception {
		transaccioningresoegresoAsignar.setId(transaccioningresoegreso.getId());	
		transaccioningresoegresoAsignar.setVersionRow(transaccioningresoegreso.getVersionRow());	
		transaccioningresoegresoAsignar.setid_empresa(transaccioningresoegreso.getid_empresa());
		transaccioningresoegresoAsignar.setempresa_descripcion(transaccioningresoegreso.getempresa_descripcion());	
		transaccioningresoegresoAsignar.setid_modulo(transaccioningresoegreso.getid_modulo());
		transaccioningresoegresoAsignar.setmodulo_descripcion(transaccioningresoegreso.getmodulo_descripcion());	
		transaccioningresoegresoAsignar.setid_transaccion(transaccioningresoegreso.getid_transaccion());
		transaccioningresoegresoAsignar.settransaccion_descripcion(transaccioningresoegreso.gettransaccion_descripcion());	
		transaccioningresoegresoAsignar.setes_ingreso(transaccioningresoegreso.getes_ingreso());	
	}
	
	public static void inicializarTransaccionIngresoEgreso(TransaccionIngresoEgreso transaccioningresoegreso) throws Exception {
		try {
				transaccioningresoegreso.setId(0L);	
					
				transaccioningresoegreso.setid_empresa(-1L);	
				transaccioningresoegreso.setid_modulo(-1L);	
				transaccioningresoegreso.setid_transaccion(-1L);	
				transaccioningresoegreso.setes_ingreso(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTransaccionIngresoEgreso(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionIngresoEgresoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionIngresoEgresoConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionIngresoEgresoConstantesFunciones.LABEL_IDTRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionIngresoEgresoConstantesFunciones.LABEL_ESINGRESO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTransaccionIngresoEgreso(String sTipo,Row row,Workbook workbook,TransaccionIngresoEgreso transaccioningresoegreso,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioningresoegreso.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioningresoegreso.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioningresoegreso.gettransaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(transaccioningresoegreso.getes_ingreso()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTransaccionIngresoEgreso=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTransaccionIngresoEgreso() {
		return this.sFinalQueryTransaccionIngresoEgreso;
	}
	
	public void setsFinalQueryTransaccionIngresoEgreso(String sFinalQueryTransaccionIngresoEgreso) {
		this.sFinalQueryTransaccionIngresoEgreso= sFinalQueryTransaccionIngresoEgreso;
	}
	
	public Border resaltarSeleccionarTransaccionIngresoEgreso=null;
	
	public Border setResaltarSeleccionarTransaccionIngresoEgreso(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionIngresoEgresoBeanSwingJInternalFrame transaccioningresoegresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//transaccioningresoegresoBeanSwingJInternalFrame.jTtoolBarTransaccionIngresoEgreso.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTransaccionIngresoEgreso= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTransaccionIngresoEgreso() {
		return this.resaltarSeleccionarTransaccionIngresoEgreso;
	}
	
	public void setResaltarSeleccionarTransaccionIngresoEgreso(Border borderResaltarSeleccionarTransaccionIngresoEgreso) {
		this.resaltarSeleccionarTransaccionIngresoEgreso= borderResaltarSeleccionarTransaccionIngresoEgreso;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTransaccionIngresoEgreso=null;
	public Boolean mostraridTransaccionIngresoEgreso=true;
	public Boolean activaridTransaccionIngresoEgreso=true;

	public Border resaltarid_empresaTransaccionIngresoEgreso=null;
	public Boolean mostrarid_empresaTransaccionIngresoEgreso=true;
	public Boolean activarid_empresaTransaccionIngresoEgreso=true;
	public Boolean cargarid_empresaTransaccionIngresoEgreso=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTransaccionIngresoEgreso=false;//ConEventDepend=true

	public Border resaltarid_moduloTransaccionIngresoEgreso=null;
	public Boolean mostrarid_moduloTransaccionIngresoEgreso=true;
	public Boolean activarid_moduloTransaccionIngresoEgreso=true;
	public Boolean cargarid_moduloTransaccionIngresoEgreso=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloTransaccionIngresoEgreso=false;//ConEventDepend=true

	public Border resaltarid_transaccionTransaccionIngresoEgreso=null;
	public Boolean mostrarid_transaccionTransaccionIngresoEgreso=true;
	public Boolean activarid_transaccionTransaccionIngresoEgreso=true;
	public Boolean cargarid_transaccionTransaccionIngresoEgreso=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccionTransaccionIngresoEgreso=false;//ConEventDepend=true

	public Border resaltares_ingresoTransaccionIngresoEgreso=null;
	public Boolean mostrares_ingresoTransaccionIngresoEgreso=true;
	public Boolean activares_ingresoTransaccionIngresoEgreso=true;

	
	

	public Border setResaltaridTransaccionIngresoEgreso(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionIngresoEgresoBeanSwingJInternalFrame transaccioningresoegresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioningresoegresoBeanSwingJInternalFrame.jTtoolBarTransaccionIngresoEgreso.setBorder(borderResaltar);
		
		this.resaltaridTransaccionIngresoEgreso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTransaccionIngresoEgreso() {
		return this.resaltaridTransaccionIngresoEgreso;
	}

	public void setResaltaridTransaccionIngresoEgreso(Border borderResaltar) {
		this.resaltaridTransaccionIngresoEgreso= borderResaltar;
	}

	public Boolean getMostraridTransaccionIngresoEgreso() {
		return this.mostraridTransaccionIngresoEgreso;
	}

	public void setMostraridTransaccionIngresoEgreso(Boolean mostraridTransaccionIngresoEgreso) {
		this.mostraridTransaccionIngresoEgreso= mostraridTransaccionIngresoEgreso;
	}

	public Boolean getActivaridTransaccionIngresoEgreso() {
		return this.activaridTransaccionIngresoEgreso;
	}

	public void setActivaridTransaccionIngresoEgreso(Boolean activaridTransaccionIngresoEgreso) {
		this.activaridTransaccionIngresoEgreso= activaridTransaccionIngresoEgreso;
	}

	public Border setResaltarid_empresaTransaccionIngresoEgreso(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionIngresoEgresoBeanSwingJInternalFrame transaccioningresoegresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioningresoegresoBeanSwingJInternalFrame.jTtoolBarTransaccionIngresoEgreso.setBorder(borderResaltar);
		
		this.resaltarid_empresaTransaccionIngresoEgreso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTransaccionIngresoEgreso() {
		return this.resaltarid_empresaTransaccionIngresoEgreso;
	}

	public void setResaltarid_empresaTransaccionIngresoEgreso(Border borderResaltar) {
		this.resaltarid_empresaTransaccionIngresoEgreso= borderResaltar;
	}

	public Boolean getMostrarid_empresaTransaccionIngresoEgreso() {
		return this.mostrarid_empresaTransaccionIngresoEgreso;
	}

	public void setMostrarid_empresaTransaccionIngresoEgreso(Boolean mostrarid_empresaTransaccionIngresoEgreso) {
		this.mostrarid_empresaTransaccionIngresoEgreso= mostrarid_empresaTransaccionIngresoEgreso;
	}

	public Boolean getActivarid_empresaTransaccionIngresoEgreso() {
		return this.activarid_empresaTransaccionIngresoEgreso;
	}

	public void setActivarid_empresaTransaccionIngresoEgreso(Boolean activarid_empresaTransaccionIngresoEgreso) {
		this.activarid_empresaTransaccionIngresoEgreso= activarid_empresaTransaccionIngresoEgreso;
	}

	public Boolean getCargarid_empresaTransaccionIngresoEgreso() {
		return this.cargarid_empresaTransaccionIngresoEgreso;
	}

	public void setCargarid_empresaTransaccionIngresoEgreso(Boolean cargarid_empresaTransaccionIngresoEgreso) {
		this.cargarid_empresaTransaccionIngresoEgreso= cargarid_empresaTransaccionIngresoEgreso;
	}

	public Border setResaltarid_moduloTransaccionIngresoEgreso(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionIngresoEgresoBeanSwingJInternalFrame transaccioningresoegresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioningresoegresoBeanSwingJInternalFrame.jTtoolBarTransaccionIngresoEgreso.setBorder(borderResaltar);
		
		this.resaltarid_moduloTransaccionIngresoEgreso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloTransaccionIngresoEgreso() {
		return this.resaltarid_moduloTransaccionIngresoEgreso;
	}

	public void setResaltarid_moduloTransaccionIngresoEgreso(Border borderResaltar) {
		this.resaltarid_moduloTransaccionIngresoEgreso= borderResaltar;
	}

	public Boolean getMostrarid_moduloTransaccionIngresoEgreso() {
		return this.mostrarid_moduloTransaccionIngresoEgreso;
	}

	public void setMostrarid_moduloTransaccionIngresoEgreso(Boolean mostrarid_moduloTransaccionIngresoEgreso) {
		this.mostrarid_moduloTransaccionIngresoEgreso= mostrarid_moduloTransaccionIngresoEgreso;
	}

	public Boolean getActivarid_moduloTransaccionIngresoEgreso() {
		return this.activarid_moduloTransaccionIngresoEgreso;
	}

	public void setActivarid_moduloTransaccionIngresoEgreso(Boolean activarid_moduloTransaccionIngresoEgreso) {
		this.activarid_moduloTransaccionIngresoEgreso= activarid_moduloTransaccionIngresoEgreso;
	}

	public Boolean getCargarid_moduloTransaccionIngresoEgreso() {
		return this.cargarid_moduloTransaccionIngresoEgreso;
	}

	public void setCargarid_moduloTransaccionIngresoEgreso(Boolean cargarid_moduloTransaccionIngresoEgreso) {
		this.cargarid_moduloTransaccionIngresoEgreso= cargarid_moduloTransaccionIngresoEgreso;
	}

	public Border setResaltarid_transaccionTransaccionIngresoEgreso(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionIngresoEgresoBeanSwingJInternalFrame transaccioningresoegresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioningresoegresoBeanSwingJInternalFrame.jTtoolBarTransaccionIngresoEgreso.setBorder(borderResaltar);
		
		this.resaltarid_transaccionTransaccionIngresoEgreso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccionTransaccionIngresoEgreso() {
		return this.resaltarid_transaccionTransaccionIngresoEgreso;
	}

	public void setResaltarid_transaccionTransaccionIngresoEgreso(Border borderResaltar) {
		this.resaltarid_transaccionTransaccionIngresoEgreso= borderResaltar;
	}

	public Boolean getMostrarid_transaccionTransaccionIngresoEgreso() {
		return this.mostrarid_transaccionTransaccionIngresoEgreso;
	}

	public void setMostrarid_transaccionTransaccionIngresoEgreso(Boolean mostrarid_transaccionTransaccionIngresoEgreso) {
		this.mostrarid_transaccionTransaccionIngresoEgreso= mostrarid_transaccionTransaccionIngresoEgreso;
	}

	public Boolean getActivarid_transaccionTransaccionIngresoEgreso() {
		return this.activarid_transaccionTransaccionIngresoEgreso;
	}

	public void setActivarid_transaccionTransaccionIngresoEgreso(Boolean activarid_transaccionTransaccionIngresoEgreso) {
		this.activarid_transaccionTransaccionIngresoEgreso= activarid_transaccionTransaccionIngresoEgreso;
	}

	public Boolean getCargarid_transaccionTransaccionIngresoEgreso() {
		return this.cargarid_transaccionTransaccionIngresoEgreso;
	}

	public void setCargarid_transaccionTransaccionIngresoEgreso(Boolean cargarid_transaccionTransaccionIngresoEgreso) {
		this.cargarid_transaccionTransaccionIngresoEgreso= cargarid_transaccionTransaccionIngresoEgreso;
	}

	public Border setResaltares_ingresoTransaccionIngresoEgreso(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionIngresoEgresoBeanSwingJInternalFrame transaccioningresoegresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioningresoegresoBeanSwingJInternalFrame.jTtoolBarTransaccionIngresoEgreso.setBorder(borderResaltar);
		
		this.resaltares_ingresoTransaccionIngresoEgreso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_ingresoTransaccionIngresoEgreso() {
		return this.resaltares_ingresoTransaccionIngresoEgreso;
	}

	public void setResaltares_ingresoTransaccionIngresoEgreso(Border borderResaltar) {
		this.resaltares_ingresoTransaccionIngresoEgreso= borderResaltar;
	}

	public Boolean getMostrares_ingresoTransaccionIngresoEgreso() {
		return this.mostrares_ingresoTransaccionIngresoEgreso;
	}

	public void setMostrares_ingresoTransaccionIngresoEgreso(Boolean mostrares_ingresoTransaccionIngresoEgreso) {
		this.mostrares_ingresoTransaccionIngresoEgreso= mostrares_ingresoTransaccionIngresoEgreso;
	}

	public Boolean getActivares_ingresoTransaccionIngresoEgreso() {
		return this.activares_ingresoTransaccionIngresoEgreso;
	}

	public void setActivares_ingresoTransaccionIngresoEgreso(Boolean activares_ingresoTransaccionIngresoEgreso) {
		this.activares_ingresoTransaccionIngresoEgreso= activares_ingresoTransaccionIngresoEgreso;
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
		
		
		this.setMostraridTransaccionIngresoEgreso(esInicial);
		this.setMostrarid_empresaTransaccionIngresoEgreso(esInicial);
		this.setMostrarid_moduloTransaccionIngresoEgreso(esInicial);
		this.setMostrarid_transaccionTransaccionIngresoEgreso(esInicial);
		this.setMostrares_ingresoTransaccionIngresoEgreso(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransaccionIngresoEgresoConstantesFunciones.ID)) {
				this.setMostraridTransaccionIngresoEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionIngresoEgresoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTransaccionIngresoEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionIngresoEgresoConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloTransaccionIngresoEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionIngresoEgresoConstantesFunciones.IDTRANSACCION)) {
				this.setMostrarid_transaccionTransaccionIngresoEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionIngresoEgresoConstantesFunciones.ESINGRESO)) {
				this.setMostrares_ingresoTransaccionIngresoEgreso(esAsigna);
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
		
		
		this.setActivaridTransaccionIngresoEgreso(esInicial);
		this.setActivarid_empresaTransaccionIngresoEgreso(esInicial);
		this.setActivarid_moduloTransaccionIngresoEgreso(esInicial);
		this.setActivarid_transaccionTransaccionIngresoEgreso(esInicial);
		this.setActivares_ingresoTransaccionIngresoEgreso(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransaccionIngresoEgresoConstantesFunciones.ID)) {
				this.setActivaridTransaccionIngresoEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionIngresoEgresoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTransaccionIngresoEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionIngresoEgresoConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloTransaccionIngresoEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionIngresoEgresoConstantesFunciones.IDTRANSACCION)) {
				this.setActivarid_transaccionTransaccionIngresoEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionIngresoEgresoConstantesFunciones.ESINGRESO)) {
				this.setActivares_ingresoTransaccionIngresoEgreso(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TransaccionIngresoEgresoBeanSwingJInternalFrame transaccioningresoegresoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTransaccionIngresoEgreso(esInicial);
		this.setResaltarid_empresaTransaccionIngresoEgreso(esInicial);
		this.setResaltarid_moduloTransaccionIngresoEgreso(esInicial);
		this.setResaltarid_transaccionTransaccionIngresoEgreso(esInicial);
		this.setResaltares_ingresoTransaccionIngresoEgreso(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransaccionIngresoEgresoConstantesFunciones.ID)) {
				this.setResaltaridTransaccionIngresoEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionIngresoEgresoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTransaccionIngresoEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionIngresoEgresoConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloTransaccionIngresoEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionIngresoEgresoConstantesFunciones.IDTRANSACCION)) {
				this.setResaltarid_transaccionTransaccionIngresoEgreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionIngresoEgresoConstantesFunciones.ESINGRESO)) {
				this.setResaltares_ingresoTransaccionIngresoEgreso(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TransaccionIngresoEgresoBeanSwingJInternalFrame transaccioningresoegresoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaTransaccionIngresoEgreso=true;

	public Boolean getMostrarFK_IdEmpresaTransaccionIngresoEgreso() {
		return this.mostrarFK_IdEmpresaTransaccionIngresoEgreso;
	}

	public void setMostrarFK_IdEmpresaTransaccionIngresoEgreso(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTransaccionIngresoEgreso= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloTransaccionIngresoEgreso=true;

	public Boolean getMostrarFK_IdModuloTransaccionIngresoEgreso() {
		return this.mostrarFK_IdModuloTransaccionIngresoEgreso;
	}

	public void setMostrarFK_IdModuloTransaccionIngresoEgreso(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloTransaccionIngresoEgreso= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionTransaccionIngresoEgreso=true;

	public Boolean getMostrarFK_IdTransaccionTransaccionIngresoEgreso() {
		return this.mostrarFK_IdTransaccionTransaccionIngresoEgreso;
	}

	public void setMostrarFK_IdTransaccionTransaccionIngresoEgreso(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionTransaccionIngresoEgreso= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTransaccionIngresoEgreso=true;

	public Boolean getActivarFK_IdEmpresaTransaccionIngresoEgreso() {
		return this.activarFK_IdEmpresaTransaccionIngresoEgreso;
	}

	public void setActivarFK_IdEmpresaTransaccionIngresoEgreso(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTransaccionIngresoEgreso= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloTransaccionIngresoEgreso=true;

	public Boolean getActivarFK_IdModuloTransaccionIngresoEgreso() {
		return this.activarFK_IdModuloTransaccionIngresoEgreso;
	}

	public void setActivarFK_IdModuloTransaccionIngresoEgreso(Boolean habilitarResaltar) {
		this.activarFK_IdModuloTransaccionIngresoEgreso= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionTransaccionIngresoEgreso=true;

	public Boolean getActivarFK_IdTransaccionTransaccionIngresoEgreso() {
		return this.activarFK_IdTransaccionTransaccionIngresoEgreso;
	}

	public void setActivarFK_IdTransaccionTransaccionIngresoEgreso(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionTransaccionIngresoEgreso= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTransaccionIngresoEgreso=null;

	public Border getResaltarFK_IdEmpresaTransaccionIngresoEgreso() {
		return this.resaltarFK_IdEmpresaTransaccionIngresoEgreso;
	}

	public void setResaltarFK_IdEmpresaTransaccionIngresoEgreso(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTransaccionIngresoEgreso= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTransaccionIngresoEgreso(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionIngresoEgresoBeanSwingJInternalFrame transaccioningresoegresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTransaccionIngresoEgreso= borderResaltar;
	}

	public Border resaltarFK_IdModuloTransaccionIngresoEgreso=null;

	public Border getResaltarFK_IdModuloTransaccionIngresoEgreso() {
		return this.resaltarFK_IdModuloTransaccionIngresoEgreso;
	}

	public void setResaltarFK_IdModuloTransaccionIngresoEgreso(Border borderResaltar) {
		this.resaltarFK_IdModuloTransaccionIngresoEgreso= borderResaltar;
	}

	public void setResaltarFK_IdModuloTransaccionIngresoEgreso(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionIngresoEgresoBeanSwingJInternalFrame transaccioningresoegresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloTransaccionIngresoEgreso= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionTransaccionIngresoEgreso=null;

	public Border getResaltarFK_IdTransaccionTransaccionIngresoEgreso() {
		return this.resaltarFK_IdTransaccionTransaccionIngresoEgreso;
	}

	public void setResaltarFK_IdTransaccionTransaccionIngresoEgreso(Border borderResaltar) {
		this.resaltarFK_IdTransaccionTransaccionIngresoEgreso= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionTransaccionIngresoEgreso(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionIngresoEgresoBeanSwingJInternalFrame transaccioningresoegresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionTransaccionIngresoEgreso= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}