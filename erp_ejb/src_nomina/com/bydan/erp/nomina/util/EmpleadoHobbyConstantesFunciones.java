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


import com.bydan.erp.nomina.util.EmpleadoHobbyConstantesFunciones;
import com.bydan.erp.nomina.util.EmpleadoHobbyParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EmpleadoHobbyParameterGeneral;

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
final public class EmpleadoHobbyConstantesFunciones extends EmpleadoHobbyConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EmpleadoHobby";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EmpleadoHobby"+EmpleadoHobbyConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EmpleadoHobbyHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EmpleadoHobbyHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EmpleadoHobbyConstantesFunciones.SCHEMA+"_"+EmpleadoHobbyConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EmpleadoHobbyHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EmpleadoHobbyConstantesFunciones.SCHEMA+"_"+EmpleadoHobbyConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EmpleadoHobbyConstantesFunciones.SCHEMA+"_"+EmpleadoHobbyConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EmpleadoHobbyHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EmpleadoHobbyConstantesFunciones.SCHEMA+"_"+EmpleadoHobbyConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoHobbyConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpleadoHobbyHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoHobbyConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoHobbyConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpleadoHobbyHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoHobbyConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EmpleadoHobbyConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EmpleadoHobbyConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EmpleadoHobbyConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EmpleadoHobbyConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Empleado Hobbyes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Empleado Hobby";
	public static final String SCLASSWEBTITULO_LOWER="Empleado Hobby";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EmpleadoHobby";
	public static final String OBJECTNAME="empleadohobby";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="empleado_hobby";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select empleadohobby from "+EmpleadoHobbyConstantesFunciones.SPERSISTENCENAME+" empleadohobby";
	public static String QUERYSELECTNATIVE="select "+EmpleadoHobbyConstantesFunciones.SCHEMA+"."+EmpleadoHobbyConstantesFunciones.TABLENAME+".id,"+EmpleadoHobbyConstantesFunciones.SCHEMA+"."+EmpleadoHobbyConstantesFunciones.TABLENAME+".version_row,"+EmpleadoHobbyConstantesFunciones.SCHEMA+"."+EmpleadoHobbyConstantesFunciones.TABLENAME+".id_empresa,"+EmpleadoHobbyConstantesFunciones.SCHEMA+"."+EmpleadoHobbyConstantesFunciones.TABLENAME+".id_empleado,"+EmpleadoHobbyConstantesFunciones.SCHEMA+"."+EmpleadoHobbyConstantesFunciones.TABLENAME+".id_hobby from "+EmpleadoHobbyConstantesFunciones.SCHEMA+"."+EmpleadoHobbyConstantesFunciones.TABLENAME;//+" as "+EmpleadoHobbyConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EmpleadoHobbyConstantesFuncionesAdditional empleadohobbyConstantesFuncionesAdditional=null;
	
	public EmpleadoHobbyConstantesFuncionesAdditional getEmpleadoHobbyConstantesFuncionesAdditional() {
		return this.empleadohobbyConstantesFuncionesAdditional;
	}
	
	public void setEmpleadoHobbyConstantesFuncionesAdditional(EmpleadoHobbyConstantesFuncionesAdditional empleadohobbyConstantesFuncionesAdditional) {
		try {
			this.empleadohobbyConstantesFuncionesAdditional=empleadohobbyConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDHOBBY= "id_hobby";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDHOBBY= "Hobby";
		public static final String LABEL_IDHOBBY_LOWER= "Hobby";
	
		
		
		
		
		
	
	public static String getEmpleadoHobbyLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EmpleadoHobbyConstantesFunciones.IDEMPRESA)) {sLabelColumna=EmpleadoHobbyConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EmpleadoHobbyConstantesFunciones.IDEMPLEADO)) {sLabelColumna=EmpleadoHobbyConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(EmpleadoHobbyConstantesFunciones.IDHOBBY)) {sLabelColumna=EmpleadoHobbyConstantesFunciones.LABEL_IDHOBBY;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getEmpleadoHobbyDescripcion(EmpleadoHobby empleadohobby) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(empleadohobby !=null/* && empleadohobby.getId()!=0*/) {
			if(empleadohobby.getId()!=null) {
				sDescripcion=empleadohobby.getId().toString();
			}//empleadohobbyempleadohobby.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getEmpleadoHobbyDescripcionDetallado(EmpleadoHobby empleadohobby) {
		String sDescripcion="";
			
		sDescripcion+=EmpleadoHobbyConstantesFunciones.ID+"=";
		sDescripcion+=empleadohobby.getId().toString()+",";
		sDescripcion+=EmpleadoHobbyConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=empleadohobby.getVersionRow().toString()+",";
		sDescripcion+=EmpleadoHobbyConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=empleadohobby.getid_empresa().toString()+",";
		sDescripcion+=EmpleadoHobbyConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=empleadohobby.getid_empleado().toString()+",";
		sDescripcion+=EmpleadoHobbyConstantesFunciones.IDHOBBY+"=";
		sDescripcion+=empleadohobby.getid_hobby().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setEmpleadoHobbyDescripcion(EmpleadoHobby empleadohobby,String sValor) throws Exception {			
		if(empleadohobby !=null) {
			//empleadohobbyempleadohobby.getId().toString();
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

	public static String getHobbyDescripcion(Hobby hobby) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(hobby!=null/*&&hobby.getId()>0*/) {
			sDescripcion=HobbyConstantesFunciones.getHobbyDescripcion(hobby);
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
		} else if(sNombreIndice.equals("FK_IdHobby")) {
			sNombreIndice="Tipo=  Por Hobby";
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

	public static String getDetalleIndiceFK_IdHobby(Long id_hobby) {
		String sDetalleIndice=" Parametros->";
		if(id_hobby!=null) {sDetalleIndice+=" Codigo Unico De Hobby="+id_hobby.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEmpleadoHobby(EmpleadoHobby empleadohobby,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosEmpleadoHobbys(List<EmpleadoHobby> empleadohobbys,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EmpleadoHobby empleadohobby: empleadohobbys) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpleadoHobby(EmpleadoHobby empleadohobby,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && empleadohobby.getConCambioAuxiliar()) {
			empleadohobby.setIsDeleted(empleadohobby.getIsDeletedAuxiliar());	
			empleadohobby.setIsNew(empleadohobby.getIsNewAuxiliar());	
			empleadohobby.setIsChanged(empleadohobby.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			empleadohobby.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			empleadohobby.setIsDeletedAuxiliar(false);	
			empleadohobby.setIsNewAuxiliar(false);	
			empleadohobby.setIsChangedAuxiliar(false);
			
			empleadohobby.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpleadoHobbys(List<EmpleadoHobby> empleadohobbys,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EmpleadoHobby empleadohobby : empleadohobbys) {
			if(conAsignarBase && empleadohobby.getConCambioAuxiliar()) {
				empleadohobby.setIsDeleted(empleadohobby.getIsDeletedAuxiliar());	
				empleadohobby.setIsNew(empleadohobby.getIsNewAuxiliar());	
				empleadohobby.setIsChanged(empleadohobby.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				empleadohobby.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				empleadohobby.setIsDeletedAuxiliar(false);	
				empleadohobby.setIsNewAuxiliar(false);	
				empleadohobby.setIsChangedAuxiliar(false);
				
				empleadohobby.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEmpleadoHobby(EmpleadoHobby empleadohobby,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEmpleadoHobbys(List<EmpleadoHobby> empleadohobbys,Boolean conEnteros) throws Exception  {
		
		for(EmpleadoHobby empleadohobby: empleadohobbys) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEmpleadoHobby(List<EmpleadoHobby> empleadohobbys,EmpleadoHobby empleadohobbyAux) throws Exception  {
		EmpleadoHobbyConstantesFunciones.InicializarValoresEmpleadoHobby(empleadohobbyAux,true);
		
		for(EmpleadoHobby empleadohobby: empleadohobbys) {
			if(empleadohobby.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpleadoHobby(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EmpleadoHobbyConstantesFunciones.getArrayColumnasGlobalesEmpleadoHobby(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpleadoHobby(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EmpleadoHobbyConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EmpleadoHobbyConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEmpleadoHobby(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EmpleadoHobby> empleadohobbys,EmpleadoHobby empleadohobby,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EmpleadoHobby empleadohobbyAux: empleadohobbys) {
			if(empleadohobbyAux!=null && empleadohobby!=null) {
				if((empleadohobbyAux.getId()==null && empleadohobby.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(empleadohobbyAux.getId()!=null && empleadohobby.getId()!=null){
					if(empleadohobbyAux.getId().equals(empleadohobby.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEmpleadoHobby(List<EmpleadoHobby> empleadohobbys) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EmpleadoHobby empleadohobby: empleadohobbys) {			
			if(empleadohobby.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEmpleadoHobby() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EmpleadoHobbyConstantesFunciones.LABEL_ID, EmpleadoHobbyConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoHobbyConstantesFunciones.LABEL_VERSIONROW, EmpleadoHobbyConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoHobbyConstantesFunciones.LABEL_IDEMPRESA, EmpleadoHobbyConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoHobbyConstantesFunciones.LABEL_IDEMPLEADO, EmpleadoHobbyConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoHobbyConstantesFunciones.LABEL_IDHOBBY, EmpleadoHobbyConstantesFunciones.IDHOBBY,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEmpleadoHobby() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EmpleadoHobbyConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoHobbyConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoHobbyConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoHobbyConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoHobbyConstantesFunciones.IDHOBBY;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoHobby() throws Exception  {
		return EmpleadoHobbyConstantesFunciones.getTiposSeleccionarEmpleadoHobby(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoHobby(Boolean conFk) throws Exception  {
		return EmpleadoHobbyConstantesFunciones.getTiposSeleccionarEmpleadoHobby(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoHobby(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoHobbyConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EmpleadoHobbyConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoHobbyConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(EmpleadoHobbyConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoHobbyConstantesFunciones.LABEL_IDHOBBY);
			reporte.setsDescripcion(EmpleadoHobbyConstantesFunciones.LABEL_IDHOBBY);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEmpleadoHobby(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEmpleadoHobby(EmpleadoHobby empleadohobbyAux) throws Exception {
		
			empleadohobbyAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(empleadohobbyAux.getEmpresa()));
			empleadohobbyAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleadohobbyAux.getEmpleado()));
			empleadohobbyAux.sethobby_descripcion(HobbyConstantesFunciones.getHobbyDescripcion(empleadohobbyAux.getHobby()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEmpleadoHobby(List<EmpleadoHobby> empleadohobbysTemp) throws Exception {
		for(EmpleadoHobby empleadohobbyAux:empleadohobbysTemp) {
			
			empleadohobbyAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(empleadohobbyAux.getEmpresa()));
			empleadohobbyAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleadohobbyAux.getEmpleado()));
			empleadohobbyAux.sethobby_descripcion(HobbyConstantesFunciones.getHobbyDescripcion(empleadohobbyAux.getHobby()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEmpleadoHobby(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Hobby.class));
				
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
					if(clas.clas.equals(Hobby.class)) {
						classes.add(new Classe(Hobby.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEmpleadoHobby(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Hobby.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Hobby.class)); continue;
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

					if(Hobby.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Hobby.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoHobby(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpleadoHobbyConstantesFunciones.getClassesRelationshipsOfEmpleadoHobby(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoHobby(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpleadoHobby(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpleadoHobbyConstantesFunciones.getClassesRelationshipsFromStringsOfEmpleadoHobby(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpleadoHobby(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(EmpleadoHobby empleadohobby,List<EmpleadoHobby> empleadohobbys,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EmpleadoHobby empleadohobbyEncontrado=null;
			
			for(EmpleadoHobby empleadohobbyLocal:empleadohobbys) {
				if(empleadohobbyLocal.getId().equals(empleadohobby.getId())) {
					empleadohobbyEncontrado=empleadohobbyLocal;
					
					empleadohobbyLocal.setIsChanged(empleadohobby.getIsChanged());
					empleadohobbyLocal.setIsNew(empleadohobby.getIsNew());
					empleadohobbyLocal.setIsDeleted(empleadohobby.getIsDeleted());
					
					empleadohobbyLocal.setGeneralEntityOriginal(empleadohobby.getGeneralEntityOriginal());
					
					empleadohobbyLocal.setId(empleadohobby.getId());	
					empleadohobbyLocal.setVersionRow(empleadohobby.getVersionRow());	
					empleadohobbyLocal.setid_empresa(empleadohobby.getid_empresa());	
					empleadohobbyLocal.setid_empleado(empleadohobby.getid_empleado());	
					empleadohobbyLocal.setid_hobby(empleadohobby.getid_hobby());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!empleadohobby.getIsDeleted()) {
				if(!existe) {
					empleadohobbys.add(empleadohobby);
				}
			} else {
				if(empleadohobbyEncontrado!=null && permiteQuitar)  {
					empleadohobbys.remove(empleadohobbyEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EmpleadoHobby empleadohobby,List<EmpleadoHobby> empleadohobbys) throws Exception {
		try	{			
			for(EmpleadoHobby empleadohobbyLocal:empleadohobbys) {
				if(empleadohobbyLocal.getId().equals(empleadohobby.getId())) {
					empleadohobbyLocal.setIsSelected(empleadohobby.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEmpleadoHobby(List<EmpleadoHobby> empleadohobbysAux) throws Exception {
		//this.empleadohobbysAux=empleadohobbysAux;
		
		for(EmpleadoHobby empleadohobbyAux:empleadohobbysAux) {
			if(empleadohobbyAux.getIsChanged()) {
				empleadohobbyAux.setIsChanged(false);
			}		
			
			if(empleadohobbyAux.getIsNew()) {
				empleadohobbyAux.setIsNew(false);
			}	
			
			if(empleadohobbyAux.getIsDeleted()) {
				empleadohobbyAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEmpleadoHobby(EmpleadoHobby empleadohobbyAux) throws Exception {
		//this.empleadohobbyAux=empleadohobbyAux;
		
			if(empleadohobbyAux.getIsChanged()) {
				empleadohobbyAux.setIsChanged(false);
			}		
			
			if(empleadohobbyAux.getIsNew()) {
				empleadohobbyAux.setIsNew(false);
			}	
			
			if(empleadohobbyAux.getIsDeleted()) {
				empleadohobbyAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EmpleadoHobby empleadohobbyAsignar,EmpleadoHobby empleadohobby) throws Exception {
		empleadohobbyAsignar.setId(empleadohobby.getId());	
		empleadohobbyAsignar.setVersionRow(empleadohobby.getVersionRow());	
		empleadohobbyAsignar.setid_empresa(empleadohobby.getid_empresa());
		empleadohobbyAsignar.setempresa_descripcion(empleadohobby.getempresa_descripcion());	
		empleadohobbyAsignar.setid_empleado(empleadohobby.getid_empleado());
		empleadohobbyAsignar.setempleado_descripcion(empleadohobby.getempleado_descripcion());	
		empleadohobbyAsignar.setid_hobby(empleadohobby.getid_hobby());
		empleadohobbyAsignar.sethobby_descripcion(empleadohobby.gethobby_descripcion());	
	}
	
	public static void inicializarEmpleadoHobby(EmpleadoHobby empleadohobby) throws Exception {
		try {
				empleadohobby.setId(0L);	
					
				empleadohobby.setid_empresa(-1L);	
				empleadohobby.setid_empleado(-1L);	
				empleadohobby.setid_hobby(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEmpleadoHobby(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoHobbyConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoHobbyConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoHobbyConstantesFunciones.LABEL_IDHOBBY);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEmpleadoHobby(String sTipo,Row row,Workbook workbook,EmpleadoHobby empleadohobby,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadohobby.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadohobby.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadohobby.gethobby_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEmpleadoHobby=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEmpleadoHobby() {
		return this.sFinalQueryEmpleadoHobby;
	}
	
	public void setsFinalQueryEmpleadoHobby(String sFinalQueryEmpleadoHobby) {
		this.sFinalQueryEmpleadoHobby= sFinalQueryEmpleadoHobby;
	}
	
	public Border resaltarSeleccionarEmpleadoHobby=null;
	
	public Border setResaltarSeleccionarEmpleadoHobby(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoHobbyBeanSwingJInternalFrame empleadohobbyBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//empleadohobbyBeanSwingJInternalFrame.jTtoolBarEmpleadoHobby.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEmpleadoHobby= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEmpleadoHobby() {
		return this.resaltarSeleccionarEmpleadoHobby;
	}
	
	public void setResaltarSeleccionarEmpleadoHobby(Border borderResaltarSeleccionarEmpleadoHobby) {
		this.resaltarSeleccionarEmpleadoHobby= borderResaltarSeleccionarEmpleadoHobby;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEmpleadoHobby=null;
	public Boolean mostraridEmpleadoHobby=true;
	public Boolean activaridEmpleadoHobby=true;

	public Border resaltarid_empresaEmpleadoHobby=null;
	public Boolean mostrarid_empresaEmpleadoHobby=true;
	public Boolean activarid_empresaEmpleadoHobby=true;
	public Boolean cargarid_empresaEmpleadoHobby=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEmpleadoHobby=false;//ConEventDepend=true

	public Border resaltarid_empleadoEmpleadoHobby=null;
	public Boolean mostrarid_empleadoEmpleadoHobby=true;
	public Boolean activarid_empleadoEmpleadoHobby=true;
	public Boolean cargarid_empleadoEmpleadoHobby=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoEmpleadoHobby=false;//ConEventDepend=true

	public Border resaltarid_hobbyEmpleadoHobby=null;
	public Boolean mostrarid_hobbyEmpleadoHobby=true;
	public Boolean activarid_hobbyEmpleadoHobby=true;
	public Boolean cargarid_hobbyEmpleadoHobby=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_hobbyEmpleadoHobby=false;//ConEventDepend=true

	
	

	public Border setResaltaridEmpleadoHobby(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoHobbyBeanSwingJInternalFrame empleadohobbyBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadohobbyBeanSwingJInternalFrame.jTtoolBarEmpleadoHobby.setBorder(borderResaltar);
		
		this.resaltaridEmpleadoHobby= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEmpleadoHobby() {
		return this.resaltaridEmpleadoHobby;
	}

	public void setResaltaridEmpleadoHobby(Border borderResaltar) {
		this.resaltaridEmpleadoHobby= borderResaltar;
	}

	public Boolean getMostraridEmpleadoHobby() {
		return this.mostraridEmpleadoHobby;
	}

	public void setMostraridEmpleadoHobby(Boolean mostraridEmpleadoHobby) {
		this.mostraridEmpleadoHobby= mostraridEmpleadoHobby;
	}

	public Boolean getActivaridEmpleadoHobby() {
		return this.activaridEmpleadoHobby;
	}

	public void setActivaridEmpleadoHobby(Boolean activaridEmpleadoHobby) {
		this.activaridEmpleadoHobby= activaridEmpleadoHobby;
	}

	public Border setResaltarid_empresaEmpleadoHobby(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoHobbyBeanSwingJInternalFrame empleadohobbyBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadohobbyBeanSwingJInternalFrame.jTtoolBarEmpleadoHobby.setBorder(borderResaltar);
		
		this.resaltarid_empresaEmpleadoHobby= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEmpleadoHobby() {
		return this.resaltarid_empresaEmpleadoHobby;
	}

	public void setResaltarid_empresaEmpleadoHobby(Border borderResaltar) {
		this.resaltarid_empresaEmpleadoHobby= borderResaltar;
	}

	public Boolean getMostrarid_empresaEmpleadoHobby() {
		return this.mostrarid_empresaEmpleadoHobby;
	}

	public void setMostrarid_empresaEmpleadoHobby(Boolean mostrarid_empresaEmpleadoHobby) {
		this.mostrarid_empresaEmpleadoHobby= mostrarid_empresaEmpleadoHobby;
	}

	public Boolean getActivarid_empresaEmpleadoHobby() {
		return this.activarid_empresaEmpleadoHobby;
	}

	public void setActivarid_empresaEmpleadoHobby(Boolean activarid_empresaEmpleadoHobby) {
		this.activarid_empresaEmpleadoHobby= activarid_empresaEmpleadoHobby;
	}

	public Boolean getCargarid_empresaEmpleadoHobby() {
		return this.cargarid_empresaEmpleadoHobby;
	}

	public void setCargarid_empresaEmpleadoHobby(Boolean cargarid_empresaEmpleadoHobby) {
		this.cargarid_empresaEmpleadoHobby= cargarid_empresaEmpleadoHobby;
	}

	public Border setResaltarid_empleadoEmpleadoHobby(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoHobbyBeanSwingJInternalFrame empleadohobbyBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadohobbyBeanSwingJInternalFrame.jTtoolBarEmpleadoHobby.setBorder(borderResaltar);
		
		this.resaltarid_empleadoEmpleadoHobby= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoEmpleadoHobby() {
		return this.resaltarid_empleadoEmpleadoHobby;
	}

	public void setResaltarid_empleadoEmpleadoHobby(Border borderResaltar) {
		this.resaltarid_empleadoEmpleadoHobby= borderResaltar;
	}

	public Boolean getMostrarid_empleadoEmpleadoHobby() {
		return this.mostrarid_empleadoEmpleadoHobby;
	}

	public void setMostrarid_empleadoEmpleadoHobby(Boolean mostrarid_empleadoEmpleadoHobby) {
		this.mostrarid_empleadoEmpleadoHobby= mostrarid_empleadoEmpleadoHobby;
	}

	public Boolean getActivarid_empleadoEmpleadoHobby() {
		return this.activarid_empleadoEmpleadoHobby;
	}

	public void setActivarid_empleadoEmpleadoHobby(Boolean activarid_empleadoEmpleadoHobby) {
		this.activarid_empleadoEmpleadoHobby= activarid_empleadoEmpleadoHobby;
	}

	public Boolean getCargarid_empleadoEmpleadoHobby() {
		return this.cargarid_empleadoEmpleadoHobby;
	}

	public void setCargarid_empleadoEmpleadoHobby(Boolean cargarid_empleadoEmpleadoHobby) {
		this.cargarid_empleadoEmpleadoHobby= cargarid_empleadoEmpleadoHobby;
	}

	public Border setResaltarid_hobbyEmpleadoHobby(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoHobbyBeanSwingJInternalFrame empleadohobbyBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadohobbyBeanSwingJInternalFrame.jTtoolBarEmpleadoHobby.setBorder(borderResaltar);
		
		this.resaltarid_hobbyEmpleadoHobby= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_hobbyEmpleadoHobby() {
		return this.resaltarid_hobbyEmpleadoHobby;
	}

	public void setResaltarid_hobbyEmpleadoHobby(Border borderResaltar) {
		this.resaltarid_hobbyEmpleadoHobby= borderResaltar;
	}

	public Boolean getMostrarid_hobbyEmpleadoHobby() {
		return this.mostrarid_hobbyEmpleadoHobby;
	}

	public void setMostrarid_hobbyEmpleadoHobby(Boolean mostrarid_hobbyEmpleadoHobby) {
		this.mostrarid_hobbyEmpleadoHobby= mostrarid_hobbyEmpleadoHobby;
	}

	public Boolean getActivarid_hobbyEmpleadoHobby() {
		return this.activarid_hobbyEmpleadoHobby;
	}

	public void setActivarid_hobbyEmpleadoHobby(Boolean activarid_hobbyEmpleadoHobby) {
		this.activarid_hobbyEmpleadoHobby= activarid_hobbyEmpleadoHobby;
	}

	public Boolean getCargarid_hobbyEmpleadoHobby() {
		return this.cargarid_hobbyEmpleadoHobby;
	}

	public void setCargarid_hobbyEmpleadoHobby(Boolean cargarid_hobbyEmpleadoHobby) {
		this.cargarid_hobbyEmpleadoHobby= cargarid_hobbyEmpleadoHobby;
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
		
		
		this.setMostraridEmpleadoHobby(esInicial);
		this.setMostrarid_empresaEmpleadoHobby(esInicial);
		this.setMostrarid_empleadoEmpleadoHobby(esInicial);
		this.setMostrarid_hobbyEmpleadoHobby(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoHobbyConstantesFunciones.ID)) {
				this.setMostraridEmpleadoHobby(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoHobbyConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEmpleadoHobby(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoHobbyConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoEmpleadoHobby(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoHobbyConstantesFunciones.IDHOBBY)) {
				this.setMostrarid_hobbyEmpleadoHobby(esAsigna);
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
		
		
		this.setActivaridEmpleadoHobby(esInicial);
		this.setActivarid_empresaEmpleadoHobby(esInicial);
		this.setActivarid_empleadoEmpleadoHobby(esInicial);
		this.setActivarid_hobbyEmpleadoHobby(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoHobbyConstantesFunciones.ID)) {
				this.setActivaridEmpleadoHobby(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoHobbyConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEmpleadoHobby(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoHobbyConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoEmpleadoHobby(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoHobbyConstantesFunciones.IDHOBBY)) {
				this.setActivarid_hobbyEmpleadoHobby(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpleadoHobbyBeanSwingJInternalFrame empleadohobbyBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEmpleadoHobby(esInicial);
		this.setResaltarid_empresaEmpleadoHobby(esInicial);
		this.setResaltarid_empleadoEmpleadoHobby(esInicial);
		this.setResaltarid_hobbyEmpleadoHobby(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoHobbyConstantesFunciones.ID)) {
				this.setResaltaridEmpleadoHobby(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoHobbyConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEmpleadoHobby(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoHobbyConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoEmpleadoHobby(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoHobbyConstantesFunciones.IDHOBBY)) {
				this.setResaltarid_hobbyEmpleadoHobby(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpleadoHobbyBeanSwingJInternalFrame empleadohobbyBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpleadoEmpleadoHobby=true;

	public Boolean getMostrarFK_IdEmpleadoEmpleadoHobby() {
		return this.mostrarFK_IdEmpleadoEmpleadoHobby;
	}

	public void setMostrarFK_IdEmpleadoEmpleadoHobby(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoEmpleadoHobby= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaEmpleadoHobby=true;

	public Boolean getMostrarFK_IdEmpresaEmpleadoHobby() {
		return this.mostrarFK_IdEmpresaEmpleadoHobby;
	}

	public void setMostrarFK_IdEmpresaEmpleadoHobby(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaEmpleadoHobby= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdHobbyEmpleadoHobby=true;

	public Boolean getMostrarFK_IdHobbyEmpleadoHobby() {
		return this.mostrarFK_IdHobbyEmpleadoHobby;
	}

	public void setMostrarFK_IdHobbyEmpleadoHobby(Boolean visibilidadResaltar) {
		this.mostrarFK_IdHobbyEmpleadoHobby= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoEmpleadoHobby=true;

	public Boolean getActivarFK_IdEmpleadoEmpleadoHobby() {
		return this.activarFK_IdEmpleadoEmpleadoHobby;
	}

	public void setActivarFK_IdEmpleadoEmpleadoHobby(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoEmpleadoHobby= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaEmpleadoHobby=true;

	public Boolean getActivarFK_IdEmpresaEmpleadoHobby() {
		return this.activarFK_IdEmpresaEmpleadoHobby;
	}

	public void setActivarFK_IdEmpresaEmpleadoHobby(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaEmpleadoHobby= habilitarResaltar;
	}

	public Boolean activarFK_IdHobbyEmpleadoHobby=true;

	public Boolean getActivarFK_IdHobbyEmpleadoHobby() {
		return this.activarFK_IdHobbyEmpleadoHobby;
	}

	public void setActivarFK_IdHobbyEmpleadoHobby(Boolean habilitarResaltar) {
		this.activarFK_IdHobbyEmpleadoHobby= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoEmpleadoHobby=null;

	public Border getResaltarFK_IdEmpleadoEmpleadoHobby() {
		return this.resaltarFK_IdEmpleadoEmpleadoHobby;
	}

	public void setResaltarFK_IdEmpleadoEmpleadoHobby(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoEmpleadoHobby= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoEmpleadoHobby(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoHobbyBeanSwingJInternalFrame empleadohobbyBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoEmpleadoHobby= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaEmpleadoHobby=null;

	public Border getResaltarFK_IdEmpresaEmpleadoHobby() {
		return this.resaltarFK_IdEmpresaEmpleadoHobby;
	}

	public void setResaltarFK_IdEmpresaEmpleadoHobby(Border borderResaltar) {
		this.resaltarFK_IdEmpresaEmpleadoHobby= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaEmpleadoHobby(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoHobbyBeanSwingJInternalFrame empleadohobbyBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaEmpleadoHobby= borderResaltar;
	}

	public Border resaltarFK_IdHobbyEmpleadoHobby=null;

	public Border getResaltarFK_IdHobbyEmpleadoHobby() {
		return this.resaltarFK_IdHobbyEmpleadoHobby;
	}

	public void setResaltarFK_IdHobbyEmpleadoHobby(Border borderResaltar) {
		this.resaltarFK_IdHobbyEmpleadoHobby= borderResaltar;
	}

	public void setResaltarFK_IdHobbyEmpleadoHobby(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoHobbyBeanSwingJInternalFrame empleadohobbyBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdHobbyEmpleadoHobby= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}