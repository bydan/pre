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


import com.bydan.erp.nomina.util.RasgoPersonalConstantesFunciones;
import com.bydan.erp.nomina.util.RasgoPersonalParameterReturnGeneral;
//import com.bydan.erp.nomina.util.RasgoPersonalParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class RasgoPersonalConstantesFunciones extends RasgoPersonalConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="RasgoPersonal";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="RasgoPersonal"+RasgoPersonalConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="RasgoPersonalHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="RasgoPersonalHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=RasgoPersonalConstantesFunciones.SCHEMA+"_"+RasgoPersonalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/RasgoPersonalHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=RasgoPersonalConstantesFunciones.SCHEMA+"_"+RasgoPersonalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=RasgoPersonalConstantesFunciones.SCHEMA+"_"+RasgoPersonalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/RasgoPersonalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=RasgoPersonalConstantesFunciones.SCHEMA+"_"+RasgoPersonalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RasgoPersonalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RasgoPersonalHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RasgoPersonalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RasgoPersonalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RasgoPersonalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RasgoPersonalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=RasgoPersonalConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+RasgoPersonalConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=RasgoPersonalConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+RasgoPersonalConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Rasgo Personales";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Rasgo Personal";
	public static final String SCLASSWEBTITULO_LOWER="Rasgo Personal";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="RasgoPersonal";
	public static final String OBJECTNAME="rasgopersonal";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="rasgo_personal";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select rasgopersonal from "+RasgoPersonalConstantesFunciones.SPERSISTENCENAME+" rasgopersonal";
	public static String QUERYSELECTNATIVE="select "+RasgoPersonalConstantesFunciones.SCHEMA+"."+RasgoPersonalConstantesFunciones.TABLENAME+".id,"+RasgoPersonalConstantesFunciones.SCHEMA+"."+RasgoPersonalConstantesFunciones.TABLENAME+".version_row,"+RasgoPersonalConstantesFunciones.SCHEMA+"."+RasgoPersonalConstantesFunciones.TABLENAME+".id_empresa,"+RasgoPersonalConstantesFunciones.SCHEMA+"."+RasgoPersonalConstantesFunciones.TABLENAME+".id_empleado,"+RasgoPersonalConstantesFunciones.SCHEMA+"."+RasgoPersonalConstantesFunciones.TABLENAME+".id_tipo_rasgo_personal,"+RasgoPersonalConstantesFunciones.SCHEMA+"."+RasgoPersonalConstantesFunciones.TABLENAME+".descripcion from "+RasgoPersonalConstantesFunciones.SCHEMA+"."+RasgoPersonalConstantesFunciones.TABLENAME;//+" as "+RasgoPersonalConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected RasgoPersonalConstantesFuncionesAdditional rasgopersonalConstantesFuncionesAdditional=null;
	
	public RasgoPersonalConstantesFuncionesAdditional getRasgoPersonalConstantesFuncionesAdditional() {
		return this.rasgopersonalConstantesFuncionesAdditional;
	}
	
	public void setRasgoPersonalConstantesFuncionesAdditional(RasgoPersonalConstantesFuncionesAdditional rasgopersonalConstantesFuncionesAdditional) {
		try {
			this.rasgopersonalConstantesFuncionesAdditional=rasgopersonalConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDTIPORASGOPERSONAL= "id_tipo_rasgo_personal";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDTIPORASGOPERSONAL= "Tipo Rasgo Personal";
		public static final String LABEL_IDTIPORASGOPERSONAL_LOWER= "Tipo Rasgo Personal";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getRasgoPersonalLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(RasgoPersonalConstantesFunciones.IDEMPRESA)) {sLabelColumna=RasgoPersonalConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(RasgoPersonalConstantesFunciones.IDEMPLEADO)) {sLabelColumna=RasgoPersonalConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(RasgoPersonalConstantesFunciones.IDTIPORASGOPERSONAL)) {sLabelColumna=RasgoPersonalConstantesFunciones.LABEL_IDTIPORASGOPERSONAL;}
		if(sNombreColumna.equals(RasgoPersonalConstantesFunciones.DESCRIPCION)) {sLabelColumna=RasgoPersonalConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getRasgoPersonalDescripcion(RasgoPersonal rasgopersonal) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(rasgopersonal !=null/* && rasgopersonal.getId()!=0*/) {
			if(rasgopersonal.getId()!=null) {
				sDescripcion=rasgopersonal.getId().toString();
			}//rasgopersonalrasgopersonal.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getRasgoPersonalDescripcionDetallado(RasgoPersonal rasgopersonal) {
		String sDescripcion="";
			
		sDescripcion+=RasgoPersonalConstantesFunciones.ID+"=";
		sDescripcion+=rasgopersonal.getId().toString()+",";
		sDescripcion+=RasgoPersonalConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=rasgopersonal.getVersionRow().toString()+",";
		sDescripcion+=RasgoPersonalConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=rasgopersonal.getid_empresa().toString()+",";
		sDescripcion+=RasgoPersonalConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=rasgopersonal.getid_empleado().toString()+",";
		sDescripcion+=RasgoPersonalConstantesFunciones.IDTIPORASGOPERSONAL+"=";
		sDescripcion+=rasgopersonal.getid_tipo_rasgo_personal().toString()+",";
		sDescripcion+=RasgoPersonalConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=rasgopersonal.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setRasgoPersonalDescripcion(RasgoPersonal rasgopersonal,String sValor) throws Exception {			
		if(rasgopersonal !=null) {
			//rasgopersonalrasgopersonal.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}

	public static String getTipoRasgoPersonalDescripcion(TipoRasgoPersonal tiporasgopersonal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporasgopersonal!=null/*&&tiporasgopersonal.getId()>0*/) {
			sDescripcion=TipoRasgoPersonalConstantesFunciones.getTipoRasgoPersonalDescripcion(tiporasgopersonal);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoRasgoPersonal")) {
			sNombreIndice="Tipo=  Por Tipo Rasgo Personal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRasgoPersonal(Long id_tipo_rasgo_personal) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_rasgo_personal!=null) {sDetalleIndice+=" Codigo Unico De Tipo Rasgo Personal="+id_tipo_rasgo_personal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosRasgoPersonal(RasgoPersonal rasgopersonal,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		rasgopersonal.setdescripcion(rasgopersonal.getdescripcion().trim());
	}
	
	public static void quitarEspaciosRasgoPersonals(List<RasgoPersonal> rasgopersonals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(RasgoPersonal rasgopersonal: rasgopersonals) {
			rasgopersonal.setdescripcion(rasgopersonal.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRasgoPersonal(RasgoPersonal rasgopersonal,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && rasgopersonal.getConCambioAuxiliar()) {
			rasgopersonal.setIsDeleted(rasgopersonal.getIsDeletedAuxiliar());	
			rasgopersonal.setIsNew(rasgopersonal.getIsNewAuxiliar());	
			rasgopersonal.setIsChanged(rasgopersonal.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			rasgopersonal.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			rasgopersonal.setIsDeletedAuxiliar(false);	
			rasgopersonal.setIsNewAuxiliar(false);	
			rasgopersonal.setIsChangedAuxiliar(false);
			
			rasgopersonal.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRasgoPersonals(List<RasgoPersonal> rasgopersonals,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(RasgoPersonal rasgopersonal : rasgopersonals) {
			if(conAsignarBase && rasgopersonal.getConCambioAuxiliar()) {
				rasgopersonal.setIsDeleted(rasgopersonal.getIsDeletedAuxiliar());	
				rasgopersonal.setIsNew(rasgopersonal.getIsNewAuxiliar());	
				rasgopersonal.setIsChanged(rasgopersonal.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				rasgopersonal.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				rasgopersonal.setIsDeletedAuxiliar(false);	
				rasgopersonal.setIsNewAuxiliar(false);	
				rasgopersonal.setIsChangedAuxiliar(false);
				
				rasgopersonal.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresRasgoPersonal(RasgoPersonal rasgopersonal,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresRasgoPersonals(List<RasgoPersonal> rasgopersonals,Boolean conEnteros) throws Exception  {
		
		for(RasgoPersonal rasgopersonal: rasgopersonals) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaRasgoPersonal(List<RasgoPersonal> rasgopersonals,RasgoPersonal rasgopersonalAux) throws Exception  {
		RasgoPersonalConstantesFunciones.InicializarValoresRasgoPersonal(rasgopersonalAux,true);
		
		for(RasgoPersonal rasgopersonal: rasgopersonals) {
			if(rasgopersonal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRasgoPersonal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=RasgoPersonalConstantesFunciones.getArrayColumnasGlobalesRasgoPersonal(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesRasgoPersonal(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RasgoPersonalConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RasgoPersonalConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoRasgoPersonal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<RasgoPersonal> rasgopersonals,RasgoPersonal rasgopersonal,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(RasgoPersonal rasgopersonalAux: rasgopersonals) {
			if(rasgopersonalAux!=null && rasgopersonal!=null) {
				if((rasgopersonalAux.getId()==null && rasgopersonal.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(rasgopersonalAux.getId()!=null && rasgopersonal.getId()!=null){
					if(rasgopersonalAux.getId().equals(rasgopersonal.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRasgoPersonal(List<RasgoPersonal> rasgopersonals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(RasgoPersonal rasgopersonal: rasgopersonals) {			
			if(rasgopersonal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaRasgoPersonal() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,RasgoPersonalConstantesFunciones.LABEL_ID, RasgoPersonalConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RasgoPersonalConstantesFunciones.LABEL_VERSIONROW, RasgoPersonalConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RasgoPersonalConstantesFunciones.LABEL_IDEMPRESA, RasgoPersonalConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RasgoPersonalConstantesFunciones.LABEL_IDEMPLEADO, RasgoPersonalConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RasgoPersonalConstantesFunciones.LABEL_IDTIPORASGOPERSONAL, RasgoPersonalConstantesFunciones.IDTIPORASGOPERSONAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RasgoPersonalConstantesFunciones.LABEL_DESCRIPCION, RasgoPersonalConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasRasgoPersonal() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=RasgoPersonalConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RasgoPersonalConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RasgoPersonalConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RasgoPersonalConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RasgoPersonalConstantesFunciones.IDTIPORASGOPERSONAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RasgoPersonalConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRasgoPersonal() throws Exception  {
		return RasgoPersonalConstantesFunciones.getTiposSeleccionarRasgoPersonal(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRasgoPersonal(Boolean conFk) throws Exception  {
		return RasgoPersonalConstantesFunciones.getTiposSeleccionarRasgoPersonal(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRasgoPersonal(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RasgoPersonalConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(RasgoPersonalConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RasgoPersonalConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(RasgoPersonalConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RasgoPersonalConstantesFunciones.LABEL_IDTIPORASGOPERSONAL);
			reporte.setsDescripcion(RasgoPersonalConstantesFunciones.LABEL_IDTIPORASGOPERSONAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RasgoPersonalConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(RasgoPersonalConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesRasgoPersonal(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesRasgoPersonal(RasgoPersonal rasgopersonalAux) throws Exception {
		
			rasgopersonalAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(rasgopersonalAux.getEmpresa()));
			rasgopersonalAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(rasgopersonalAux.getEmpleado()));
			rasgopersonalAux.settiporasgopersonal_descripcion(TipoRasgoPersonalConstantesFunciones.getTipoRasgoPersonalDescripcion(rasgopersonalAux.getTipoRasgoPersonal()));		
	}
	
	public static void refrescarForeignKeysDescripcionesRasgoPersonal(List<RasgoPersonal> rasgopersonalsTemp) throws Exception {
		for(RasgoPersonal rasgopersonalAux:rasgopersonalsTemp) {
			
			rasgopersonalAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(rasgopersonalAux.getEmpresa()));
			rasgopersonalAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(rasgopersonalAux.getEmpleado()));
			rasgopersonalAux.settiporasgopersonal_descripcion(TipoRasgoPersonalConstantesFunciones.getTipoRasgoPersonalDescripcion(rasgopersonalAux.getTipoRasgoPersonal()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfRasgoPersonal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(TipoRasgoPersonal.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRasgoPersonal.class)) {
						classes.add(new Classe(TipoRasgoPersonal.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfRasgoPersonal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(TipoRasgoPersonal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRasgoPersonal.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(TipoRasgoPersonal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRasgoPersonal.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfRasgoPersonal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return RasgoPersonalConstantesFunciones.getClassesRelationshipsOfRasgoPersonal(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRasgoPersonal(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRasgoPersonal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return RasgoPersonalConstantesFunciones.getClassesRelationshipsFromStringsOfRasgoPersonal(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRasgoPersonal(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(RasgoPersonal rasgopersonal,List<RasgoPersonal> rasgopersonals,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			RasgoPersonal rasgopersonalEncontrado=null;
			
			for(RasgoPersonal rasgopersonalLocal:rasgopersonals) {
				if(rasgopersonalLocal.getId().equals(rasgopersonal.getId())) {
					rasgopersonalEncontrado=rasgopersonalLocal;
					
					rasgopersonalLocal.setIsChanged(rasgopersonal.getIsChanged());
					rasgopersonalLocal.setIsNew(rasgopersonal.getIsNew());
					rasgopersonalLocal.setIsDeleted(rasgopersonal.getIsDeleted());
					
					rasgopersonalLocal.setGeneralEntityOriginal(rasgopersonal.getGeneralEntityOriginal());
					
					rasgopersonalLocal.setId(rasgopersonal.getId());	
					rasgopersonalLocal.setVersionRow(rasgopersonal.getVersionRow());	
					rasgopersonalLocal.setid_empresa(rasgopersonal.getid_empresa());	
					rasgopersonalLocal.setid_empleado(rasgopersonal.getid_empleado());	
					rasgopersonalLocal.setid_tipo_rasgo_personal(rasgopersonal.getid_tipo_rasgo_personal());	
					rasgopersonalLocal.setdescripcion(rasgopersonal.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!rasgopersonal.getIsDeleted()) {
				if(!existe) {
					rasgopersonals.add(rasgopersonal);
				}
			} else {
				if(rasgopersonalEncontrado!=null && permiteQuitar)  {
					rasgopersonals.remove(rasgopersonalEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(RasgoPersonal rasgopersonal,List<RasgoPersonal> rasgopersonals) throws Exception {
		try	{			
			for(RasgoPersonal rasgopersonalLocal:rasgopersonals) {
				if(rasgopersonalLocal.getId().equals(rasgopersonal.getId())) {
					rasgopersonalLocal.setIsSelected(rasgopersonal.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesRasgoPersonal(List<RasgoPersonal> rasgopersonalsAux) throws Exception {
		//this.rasgopersonalsAux=rasgopersonalsAux;
		
		for(RasgoPersonal rasgopersonalAux:rasgopersonalsAux) {
			if(rasgopersonalAux.getIsChanged()) {
				rasgopersonalAux.setIsChanged(false);
			}		
			
			if(rasgopersonalAux.getIsNew()) {
				rasgopersonalAux.setIsNew(false);
			}	
			
			if(rasgopersonalAux.getIsDeleted()) {
				rasgopersonalAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesRasgoPersonal(RasgoPersonal rasgopersonalAux) throws Exception {
		//this.rasgopersonalAux=rasgopersonalAux;
		
			if(rasgopersonalAux.getIsChanged()) {
				rasgopersonalAux.setIsChanged(false);
			}		
			
			if(rasgopersonalAux.getIsNew()) {
				rasgopersonalAux.setIsNew(false);
			}	
			
			if(rasgopersonalAux.getIsDeleted()) {
				rasgopersonalAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(RasgoPersonal rasgopersonalAsignar,RasgoPersonal rasgopersonal) throws Exception {
		rasgopersonalAsignar.setId(rasgopersonal.getId());	
		rasgopersonalAsignar.setVersionRow(rasgopersonal.getVersionRow());	
		rasgopersonalAsignar.setid_empresa(rasgopersonal.getid_empresa());
		rasgopersonalAsignar.setempresa_descripcion(rasgopersonal.getempresa_descripcion());	
		rasgopersonalAsignar.setid_empleado(rasgopersonal.getid_empleado());
		rasgopersonalAsignar.setempleado_descripcion(rasgopersonal.getempleado_descripcion());	
		rasgopersonalAsignar.setid_tipo_rasgo_personal(rasgopersonal.getid_tipo_rasgo_personal());
		rasgopersonalAsignar.settiporasgopersonal_descripcion(rasgopersonal.gettiporasgopersonal_descripcion());	
		rasgopersonalAsignar.setdescripcion(rasgopersonal.getdescripcion());	
	}
	
	public static void inicializarRasgoPersonal(RasgoPersonal rasgopersonal) throws Exception {
		try {
				rasgopersonal.setId(0L);	
					
				rasgopersonal.setid_empresa(-1L);	
				rasgopersonal.setid_empleado(-1L);	
				rasgopersonal.setid_tipo_rasgo_personal(-1L);	
				rasgopersonal.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderRasgoPersonal(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(RasgoPersonalConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RasgoPersonalConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RasgoPersonalConstantesFunciones.LABEL_IDTIPORASGOPERSONAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RasgoPersonalConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataRasgoPersonal(String sTipo,Row row,Workbook workbook,RasgoPersonal rasgopersonal,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(rasgopersonal.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rasgopersonal.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rasgopersonal.gettiporasgopersonal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(rasgopersonal.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryRasgoPersonal=Constantes.SFINALQUERY;
	
	public String getsFinalQueryRasgoPersonal() {
		return this.sFinalQueryRasgoPersonal;
	}
	
	public void setsFinalQueryRasgoPersonal(String sFinalQueryRasgoPersonal) {
		this.sFinalQueryRasgoPersonal= sFinalQueryRasgoPersonal;
	}
	
	public Border resaltarSeleccionarRasgoPersonal=null;
	
	public Border setResaltarSeleccionarRasgoPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*RasgoPersonalBeanSwingJInternalFrame rasgopersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//rasgopersonalBeanSwingJInternalFrame.jTtoolBarRasgoPersonal.setBorder(borderResaltar);
		
		this.resaltarSeleccionarRasgoPersonal= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarRasgoPersonal() {
		return this.resaltarSeleccionarRasgoPersonal;
	}
	
	public void setResaltarSeleccionarRasgoPersonal(Border borderResaltarSeleccionarRasgoPersonal) {
		this.resaltarSeleccionarRasgoPersonal= borderResaltarSeleccionarRasgoPersonal;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridRasgoPersonal=null;
	public Boolean mostraridRasgoPersonal=true;
	public Boolean activaridRasgoPersonal=true;

	public Border resaltarid_empresaRasgoPersonal=null;
	public Boolean mostrarid_empresaRasgoPersonal=true;
	public Boolean activarid_empresaRasgoPersonal=true;
	public Boolean cargarid_empresaRasgoPersonal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaRasgoPersonal=false;//ConEventDepend=true

	public Border resaltarid_empleadoRasgoPersonal=null;
	public Boolean mostrarid_empleadoRasgoPersonal=true;
	public Boolean activarid_empleadoRasgoPersonal=true;
	public Boolean cargarid_empleadoRasgoPersonal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoRasgoPersonal=false;//ConEventDepend=true

	public Border resaltarid_tipo_rasgo_personalRasgoPersonal=null;
	public Boolean mostrarid_tipo_rasgo_personalRasgoPersonal=true;
	public Boolean activarid_tipo_rasgo_personalRasgoPersonal=true;
	public Boolean cargarid_tipo_rasgo_personalRasgoPersonal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_rasgo_personalRasgoPersonal=false;//ConEventDepend=true

	public Border resaltardescripcionRasgoPersonal=null;
	public Boolean mostrardescripcionRasgoPersonal=true;
	public Boolean activardescripcionRasgoPersonal=true;

	
	

	public Border setResaltaridRasgoPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*RasgoPersonalBeanSwingJInternalFrame rasgopersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rasgopersonalBeanSwingJInternalFrame.jTtoolBarRasgoPersonal.setBorder(borderResaltar);
		
		this.resaltaridRasgoPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridRasgoPersonal() {
		return this.resaltaridRasgoPersonal;
	}

	public void setResaltaridRasgoPersonal(Border borderResaltar) {
		this.resaltaridRasgoPersonal= borderResaltar;
	}

	public Boolean getMostraridRasgoPersonal() {
		return this.mostraridRasgoPersonal;
	}

	public void setMostraridRasgoPersonal(Boolean mostraridRasgoPersonal) {
		this.mostraridRasgoPersonal= mostraridRasgoPersonal;
	}

	public Boolean getActivaridRasgoPersonal() {
		return this.activaridRasgoPersonal;
	}

	public void setActivaridRasgoPersonal(Boolean activaridRasgoPersonal) {
		this.activaridRasgoPersonal= activaridRasgoPersonal;
	}

	public Border setResaltarid_empresaRasgoPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*RasgoPersonalBeanSwingJInternalFrame rasgopersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rasgopersonalBeanSwingJInternalFrame.jTtoolBarRasgoPersonal.setBorder(borderResaltar);
		
		this.resaltarid_empresaRasgoPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaRasgoPersonal() {
		return this.resaltarid_empresaRasgoPersonal;
	}

	public void setResaltarid_empresaRasgoPersonal(Border borderResaltar) {
		this.resaltarid_empresaRasgoPersonal= borderResaltar;
	}

	public Boolean getMostrarid_empresaRasgoPersonal() {
		return this.mostrarid_empresaRasgoPersonal;
	}

	public void setMostrarid_empresaRasgoPersonal(Boolean mostrarid_empresaRasgoPersonal) {
		this.mostrarid_empresaRasgoPersonal= mostrarid_empresaRasgoPersonal;
	}

	public Boolean getActivarid_empresaRasgoPersonal() {
		return this.activarid_empresaRasgoPersonal;
	}

	public void setActivarid_empresaRasgoPersonal(Boolean activarid_empresaRasgoPersonal) {
		this.activarid_empresaRasgoPersonal= activarid_empresaRasgoPersonal;
	}

	public Boolean getCargarid_empresaRasgoPersonal() {
		return this.cargarid_empresaRasgoPersonal;
	}

	public void setCargarid_empresaRasgoPersonal(Boolean cargarid_empresaRasgoPersonal) {
		this.cargarid_empresaRasgoPersonal= cargarid_empresaRasgoPersonal;
	}

	public Border setResaltarid_empleadoRasgoPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*RasgoPersonalBeanSwingJInternalFrame rasgopersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rasgopersonalBeanSwingJInternalFrame.jTtoolBarRasgoPersonal.setBorder(borderResaltar);
		
		this.resaltarid_empleadoRasgoPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoRasgoPersonal() {
		return this.resaltarid_empleadoRasgoPersonal;
	}

	public void setResaltarid_empleadoRasgoPersonal(Border borderResaltar) {
		this.resaltarid_empleadoRasgoPersonal= borderResaltar;
	}

	public Boolean getMostrarid_empleadoRasgoPersonal() {
		return this.mostrarid_empleadoRasgoPersonal;
	}

	public void setMostrarid_empleadoRasgoPersonal(Boolean mostrarid_empleadoRasgoPersonal) {
		this.mostrarid_empleadoRasgoPersonal= mostrarid_empleadoRasgoPersonal;
	}

	public Boolean getActivarid_empleadoRasgoPersonal() {
		return this.activarid_empleadoRasgoPersonal;
	}

	public void setActivarid_empleadoRasgoPersonal(Boolean activarid_empleadoRasgoPersonal) {
		this.activarid_empleadoRasgoPersonal= activarid_empleadoRasgoPersonal;
	}

	public Boolean getCargarid_empleadoRasgoPersonal() {
		return this.cargarid_empleadoRasgoPersonal;
	}

	public void setCargarid_empleadoRasgoPersonal(Boolean cargarid_empleadoRasgoPersonal) {
		this.cargarid_empleadoRasgoPersonal= cargarid_empleadoRasgoPersonal;
	}

	public Border setResaltarid_tipo_rasgo_personalRasgoPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*RasgoPersonalBeanSwingJInternalFrame rasgopersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rasgopersonalBeanSwingJInternalFrame.jTtoolBarRasgoPersonal.setBorder(borderResaltar);
		
		this.resaltarid_tipo_rasgo_personalRasgoPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_rasgo_personalRasgoPersonal() {
		return this.resaltarid_tipo_rasgo_personalRasgoPersonal;
	}

	public void setResaltarid_tipo_rasgo_personalRasgoPersonal(Border borderResaltar) {
		this.resaltarid_tipo_rasgo_personalRasgoPersonal= borderResaltar;
	}

	public Boolean getMostrarid_tipo_rasgo_personalRasgoPersonal() {
		return this.mostrarid_tipo_rasgo_personalRasgoPersonal;
	}

	public void setMostrarid_tipo_rasgo_personalRasgoPersonal(Boolean mostrarid_tipo_rasgo_personalRasgoPersonal) {
		this.mostrarid_tipo_rasgo_personalRasgoPersonal= mostrarid_tipo_rasgo_personalRasgoPersonal;
	}

	public Boolean getActivarid_tipo_rasgo_personalRasgoPersonal() {
		return this.activarid_tipo_rasgo_personalRasgoPersonal;
	}

	public void setActivarid_tipo_rasgo_personalRasgoPersonal(Boolean activarid_tipo_rasgo_personalRasgoPersonal) {
		this.activarid_tipo_rasgo_personalRasgoPersonal= activarid_tipo_rasgo_personalRasgoPersonal;
	}

	public Boolean getCargarid_tipo_rasgo_personalRasgoPersonal() {
		return this.cargarid_tipo_rasgo_personalRasgoPersonal;
	}

	public void setCargarid_tipo_rasgo_personalRasgoPersonal(Boolean cargarid_tipo_rasgo_personalRasgoPersonal) {
		this.cargarid_tipo_rasgo_personalRasgoPersonal= cargarid_tipo_rasgo_personalRasgoPersonal;
	}

	public Border setResaltardescripcionRasgoPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*RasgoPersonalBeanSwingJInternalFrame rasgopersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//rasgopersonalBeanSwingJInternalFrame.jTtoolBarRasgoPersonal.setBorder(borderResaltar);
		
		this.resaltardescripcionRasgoPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionRasgoPersonal() {
		return this.resaltardescripcionRasgoPersonal;
	}

	public void setResaltardescripcionRasgoPersonal(Border borderResaltar) {
		this.resaltardescripcionRasgoPersonal= borderResaltar;
	}

	public Boolean getMostrardescripcionRasgoPersonal() {
		return this.mostrardescripcionRasgoPersonal;
	}

	public void setMostrardescripcionRasgoPersonal(Boolean mostrardescripcionRasgoPersonal) {
		this.mostrardescripcionRasgoPersonal= mostrardescripcionRasgoPersonal;
	}

	public Boolean getActivardescripcionRasgoPersonal() {
		return this.activardescripcionRasgoPersonal;
	}

	public void setActivardescripcionRasgoPersonal(Boolean activardescripcionRasgoPersonal) {
		this.activardescripcionRasgoPersonal= activardescripcionRasgoPersonal;
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
		
		
		this.setMostraridRasgoPersonal(esInicial);
		this.setMostrarid_empresaRasgoPersonal(esInicial);
		this.setMostrarid_empleadoRasgoPersonal(esInicial);
		this.setMostrarid_tipo_rasgo_personalRasgoPersonal(esInicial);
		this.setMostrardescripcionRasgoPersonal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RasgoPersonalConstantesFunciones.ID)) {
				this.setMostraridRasgoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RasgoPersonalConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaRasgoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RasgoPersonalConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoRasgoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RasgoPersonalConstantesFunciones.IDTIPORASGOPERSONAL)) {
				this.setMostrarid_tipo_rasgo_personalRasgoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RasgoPersonalConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionRasgoPersonal(esAsigna);
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
		
		
		this.setActivaridRasgoPersonal(esInicial);
		this.setActivarid_empresaRasgoPersonal(esInicial);
		this.setActivarid_empleadoRasgoPersonal(esInicial);
		this.setActivarid_tipo_rasgo_personalRasgoPersonal(esInicial);
		this.setActivardescripcionRasgoPersonal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RasgoPersonalConstantesFunciones.ID)) {
				this.setActivaridRasgoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RasgoPersonalConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaRasgoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RasgoPersonalConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoRasgoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RasgoPersonalConstantesFunciones.IDTIPORASGOPERSONAL)) {
				this.setActivarid_tipo_rasgo_personalRasgoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RasgoPersonalConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionRasgoPersonal(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,RasgoPersonalBeanSwingJInternalFrame rasgopersonalBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridRasgoPersonal(esInicial);
		this.setResaltarid_empresaRasgoPersonal(esInicial);
		this.setResaltarid_empleadoRasgoPersonal(esInicial);
		this.setResaltarid_tipo_rasgo_personalRasgoPersonal(esInicial);
		this.setResaltardescripcionRasgoPersonal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RasgoPersonalConstantesFunciones.ID)) {
				this.setResaltaridRasgoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RasgoPersonalConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaRasgoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RasgoPersonalConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoRasgoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RasgoPersonalConstantesFunciones.IDTIPORASGOPERSONAL)) {
				this.setResaltarid_tipo_rasgo_personalRasgoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(RasgoPersonalConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionRasgoPersonal(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,RasgoPersonalBeanSwingJInternalFrame rasgopersonalBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpleadoRasgoPersonal=true;

	public Boolean getMostrarFK_IdEmpleadoRasgoPersonal() {
		return this.mostrarFK_IdEmpleadoRasgoPersonal;
	}

	public void setMostrarFK_IdEmpleadoRasgoPersonal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoRasgoPersonal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaRasgoPersonal=true;

	public Boolean getMostrarFK_IdEmpresaRasgoPersonal() {
		return this.mostrarFK_IdEmpresaRasgoPersonal;
	}

	public void setMostrarFK_IdEmpresaRasgoPersonal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaRasgoPersonal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRasgoPersonalRasgoPersonal=true;

	public Boolean getMostrarFK_IdTipoRasgoPersonalRasgoPersonal() {
		return this.mostrarFK_IdTipoRasgoPersonalRasgoPersonal;
	}

	public void setMostrarFK_IdTipoRasgoPersonalRasgoPersonal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRasgoPersonalRasgoPersonal= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoRasgoPersonal=true;

	public Boolean getActivarFK_IdEmpleadoRasgoPersonal() {
		return this.activarFK_IdEmpleadoRasgoPersonal;
	}

	public void setActivarFK_IdEmpleadoRasgoPersonal(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoRasgoPersonal= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaRasgoPersonal=true;

	public Boolean getActivarFK_IdEmpresaRasgoPersonal() {
		return this.activarFK_IdEmpresaRasgoPersonal;
	}

	public void setActivarFK_IdEmpresaRasgoPersonal(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaRasgoPersonal= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRasgoPersonalRasgoPersonal=true;

	public Boolean getActivarFK_IdTipoRasgoPersonalRasgoPersonal() {
		return this.activarFK_IdTipoRasgoPersonalRasgoPersonal;
	}

	public void setActivarFK_IdTipoRasgoPersonalRasgoPersonal(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRasgoPersonalRasgoPersonal= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoRasgoPersonal=null;

	public Border getResaltarFK_IdEmpleadoRasgoPersonal() {
		return this.resaltarFK_IdEmpleadoRasgoPersonal;
	}

	public void setResaltarFK_IdEmpleadoRasgoPersonal(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoRasgoPersonal= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoRasgoPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*RasgoPersonalBeanSwingJInternalFrame rasgopersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoRasgoPersonal= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaRasgoPersonal=null;

	public Border getResaltarFK_IdEmpresaRasgoPersonal() {
		return this.resaltarFK_IdEmpresaRasgoPersonal;
	}

	public void setResaltarFK_IdEmpresaRasgoPersonal(Border borderResaltar) {
		this.resaltarFK_IdEmpresaRasgoPersonal= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaRasgoPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*RasgoPersonalBeanSwingJInternalFrame rasgopersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaRasgoPersonal= borderResaltar;
	}

	public Border resaltarFK_IdTipoRasgoPersonalRasgoPersonal=null;

	public Border getResaltarFK_IdTipoRasgoPersonalRasgoPersonal() {
		return this.resaltarFK_IdTipoRasgoPersonalRasgoPersonal;
	}

	public void setResaltarFK_IdTipoRasgoPersonalRasgoPersonal(Border borderResaltar) {
		this.resaltarFK_IdTipoRasgoPersonalRasgoPersonal= borderResaltar;
	}

	public void setResaltarFK_IdTipoRasgoPersonalRasgoPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*RasgoPersonalBeanSwingJInternalFrame rasgopersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRasgoPersonalRasgoPersonal= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}