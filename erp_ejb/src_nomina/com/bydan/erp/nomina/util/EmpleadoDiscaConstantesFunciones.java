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


import com.bydan.erp.nomina.util.EmpleadoDiscaConstantesFunciones;
import com.bydan.erp.nomina.util.EmpleadoDiscaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EmpleadoDiscaParameterGeneral;

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
final public class EmpleadoDiscaConstantesFunciones extends EmpleadoDiscaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EmpleadoDisca";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EmpleadoDisca"+EmpleadoDiscaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EmpleadoDiscaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EmpleadoDiscaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EmpleadoDiscaConstantesFunciones.SCHEMA+"_"+EmpleadoDiscaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EmpleadoDiscaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EmpleadoDiscaConstantesFunciones.SCHEMA+"_"+EmpleadoDiscaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EmpleadoDiscaConstantesFunciones.SCHEMA+"_"+EmpleadoDiscaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EmpleadoDiscaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EmpleadoDiscaConstantesFunciones.SCHEMA+"_"+EmpleadoDiscaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoDiscaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpleadoDiscaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoDiscaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoDiscaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpleadoDiscaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoDiscaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EmpleadoDiscaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EmpleadoDiscaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EmpleadoDiscaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EmpleadoDiscaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Empleado Discas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Empleado Disca";
	public static final String SCLASSWEBTITULO_LOWER="Empleado Disca";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EmpleadoDisca";
	public static final String OBJECTNAME="empleadodisca";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="empleado_disca";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select empleadodisca from "+EmpleadoDiscaConstantesFunciones.SPERSISTENCENAME+" empleadodisca";
	public static String QUERYSELECTNATIVE="select "+EmpleadoDiscaConstantesFunciones.SCHEMA+"."+EmpleadoDiscaConstantesFunciones.TABLENAME+".id,"+EmpleadoDiscaConstantesFunciones.SCHEMA+"."+EmpleadoDiscaConstantesFunciones.TABLENAME+".version_row,"+EmpleadoDiscaConstantesFunciones.SCHEMA+"."+EmpleadoDiscaConstantesFunciones.TABLENAME+".id_empresa,"+EmpleadoDiscaConstantesFunciones.SCHEMA+"."+EmpleadoDiscaConstantesFunciones.TABLENAME+".id_empleado,"+EmpleadoDiscaConstantesFunciones.SCHEMA+"."+EmpleadoDiscaConstantesFunciones.TABLENAME+".id_tipo_discapacidad,"+EmpleadoDiscaConstantesFunciones.SCHEMA+"."+EmpleadoDiscaConstantesFunciones.TABLENAME+".porcentaje_inicial,"+EmpleadoDiscaConstantesFunciones.SCHEMA+"."+EmpleadoDiscaConstantesFunciones.TABLENAME+".porcentaje_final,"+EmpleadoDiscaConstantesFunciones.SCHEMA+"."+EmpleadoDiscaConstantesFunciones.TABLENAME+".descripcion from "+EmpleadoDiscaConstantesFunciones.SCHEMA+"."+EmpleadoDiscaConstantesFunciones.TABLENAME;//+" as "+EmpleadoDiscaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EmpleadoDiscaConstantesFuncionesAdditional empleadodiscaConstantesFuncionesAdditional=null;
	
	public EmpleadoDiscaConstantesFuncionesAdditional getEmpleadoDiscaConstantesFuncionesAdditional() {
		return this.empleadodiscaConstantesFuncionesAdditional;
	}
	
	public void setEmpleadoDiscaConstantesFuncionesAdditional(EmpleadoDiscaConstantesFuncionesAdditional empleadodiscaConstantesFuncionesAdditional) {
		try {
			this.empleadodiscaConstantesFuncionesAdditional=empleadodiscaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDTIPODISCAPACIDAD= "id_tipo_discapacidad";
    public static final String PORCENTAJEINICIAL= "porcentaje_inicial";
    public static final String PORCENTAJEFINAL= "porcentaje_final";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDTIPODISCAPACIDAD= "Tipo Discapacad";
		public static final String LABEL_IDTIPODISCAPACIDAD_LOWER= "Tipo Discapacidad";
    	public static final String LABEL_PORCENTAJEINICIAL= "Porcentaje Inicial";
		public static final String LABEL_PORCENTAJEINICIAL_LOWER= "Porcentaje Inicial";
    	public static final String LABEL_PORCENTAJEFINAL= "Porcentaje Final";
		public static final String LABEL_PORCENTAJEFINAL_LOWER= "Porcentaje Final";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getEmpleadoDiscaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EmpleadoDiscaConstantesFunciones.IDEMPRESA)) {sLabelColumna=EmpleadoDiscaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EmpleadoDiscaConstantesFunciones.IDEMPLEADO)) {sLabelColumna=EmpleadoDiscaConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(EmpleadoDiscaConstantesFunciones.IDTIPODISCAPACIDAD)) {sLabelColumna=EmpleadoDiscaConstantesFunciones.LABEL_IDTIPODISCAPACIDAD;}
		if(sNombreColumna.equals(EmpleadoDiscaConstantesFunciones.PORCENTAJEINICIAL)) {sLabelColumna=EmpleadoDiscaConstantesFunciones.LABEL_PORCENTAJEINICIAL;}
		if(sNombreColumna.equals(EmpleadoDiscaConstantesFunciones.PORCENTAJEFINAL)) {sLabelColumna=EmpleadoDiscaConstantesFunciones.LABEL_PORCENTAJEFINAL;}
		if(sNombreColumna.equals(EmpleadoDiscaConstantesFunciones.DESCRIPCION)) {sLabelColumna=EmpleadoDiscaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
	
	public static String getEmpleadoDiscaDescripcion(EmpleadoDisca empleadodisca) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(empleadodisca !=null/* && empleadodisca.getId()!=0*/) {
			if(empleadodisca.getId()!=null) {
				sDescripcion=empleadodisca.getId().toString();
			}//empleadodiscaempleadodisca.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getEmpleadoDiscaDescripcionDetallado(EmpleadoDisca empleadodisca) {
		String sDescripcion="";
			
		sDescripcion+=EmpleadoDiscaConstantesFunciones.ID+"=";
		sDescripcion+=empleadodisca.getId().toString()+",";
		sDescripcion+=EmpleadoDiscaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=empleadodisca.getVersionRow().toString()+",";
		sDescripcion+=EmpleadoDiscaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=empleadodisca.getid_empresa().toString()+",";
		sDescripcion+=EmpleadoDiscaConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=empleadodisca.getid_empleado().toString()+",";
		sDescripcion+=EmpleadoDiscaConstantesFunciones.IDTIPODISCAPACIDAD+"=";
		sDescripcion+=empleadodisca.getid_tipo_discapacidad().toString()+",";
		sDescripcion+=EmpleadoDiscaConstantesFunciones.PORCENTAJEINICIAL+"=";
		sDescripcion+=empleadodisca.getporcentaje_inicial().toString()+",";
		sDescripcion+=EmpleadoDiscaConstantesFunciones.PORCENTAJEFINAL+"=";
		sDescripcion+=empleadodisca.getporcentaje_final().toString()+",";
		sDescripcion+=EmpleadoDiscaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=empleadodisca.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setEmpleadoDiscaDescripcion(EmpleadoDisca empleadodisca,String sValor) throws Exception {			
		if(empleadodisca !=null) {
			//empleadodiscaempleadodisca.getId().toString();
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

	public static String getTipoDiscapacidadDescripcion(TipoDiscapacidad tipodiscapacidad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodiscapacidad!=null/*&&tipodiscapacidad.getId()>0*/) {
			sDescripcion=TipoDiscapacidadConstantesFunciones.getTipoDiscapacidadDescripcion(tipodiscapacidad);
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
		} else if(sNombreIndice.equals("FK_IdTipoDiscapacidad")) {
			sNombreIndice="Tipo=  Por Tipo Discapacad";
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

	public static String getDetalleIndiceFK_IdTipoDiscapacidad(Long id_tipo_discapacidad) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_discapacidad!=null) {sDetalleIndice+=" Codigo Unico De Tipo Discapacad="+id_tipo_discapacidad.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEmpleadoDisca(EmpleadoDisca empleadodisca,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		empleadodisca.setdescripcion(empleadodisca.getdescripcion().trim());
	}
	
	public static void quitarEspaciosEmpleadoDiscas(List<EmpleadoDisca> empleadodiscas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EmpleadoDisca empleadodisca: empleadodiscas) {
			empleadodisca.setdescripcion(empleadodisca.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpleadoDisca(EmpleadoDisca empleadodisca,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && empleadodisca.getConCambioAuxiliar()) {
			empleadodisca.setIsDeleted(empleadodisca.getIsDeletedAuxiliar());	
			empleadodisca.setIsNew(empleadodisca.getIsNewAuxiliar());	
			empleadodisca.setIsChanged(empleadodisca.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			empleadodisca.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			empleadodisca.setIsDeletedAuxiliar(false);	
			empleadodisca.setIsNewAuxiliar(false);	
			empleadodisca.setIsChangedAuxiliar(false);
			
			empleadodisca.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpleadoDiscas(List<EmpleadoDisca> empleadodiscas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EmpleadoDisca empleadodisca : empleadodiscas) {
			if(conAsignarBase && empleadodisca.getConCambioAuxiliar()) {
				empleadodisca.setIsDeleted(empleadodisca.getIsDeletedAuxiliar());	
				empleadodisca.setIsNew(empleadodisca.getIsNewAuxiliar());	
				empleadodisca.setIsChanged(empleadodisca.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				empleadodisca.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				empleadodisca.setIsDeletedAuxiliar(false);	
				empleadodisca.setIsNewAuxiliar(false);	
				empleadodisca.setIsChangedAuxiliar(false);
				
				empleadodisca.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEmpleadoDisca(EmpleadoDisca empleadodisca,Boolean conEnteros) throws Exception  {
		empleadodisca.setporcentaje_inicial(0.0);
		empleadodisca.setporcentaje_final(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEmpleadoDiscas(List<EmpleadoDisca> empleadodiscas,Boolean conEnteros) throws Exception  {
		
		for(EmpleadoDisca empleadodisca: empleadodiscas) {
			empleadodisca.setporcentaje_inicial(0.0);
			empleadodisca.setporcentaje_final(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEmpleadoDisca(List<EmpleadoDisca> empleadodiscas,EmpleadoDisca empleadodiscaAux) throws Exception  {
		EmpleadoDiscaConstantesFunciones.InicializarValoresEmpleadoDisca(empleadodiscaAux,true);
		
		for(EmpleadoDisca empleadodisca: empleadodiscas) {
			if(empleadodisca.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			empleadodiscaAux.setporcentaje_inicial(empleadodiscaAux.getporcentaje_inicial()+empleadodisca.getporcentaje_inicial());			
			empleadodiscaAux.setporcentaje_final(empleadodiscaAux.getporcentaje_final()+empleadodisca.getporcentaje_final());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpleadoDisca(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EmpleadoDiscaConstantesFunciones.getArrayColumnasGlobalesEmpleadoDisca(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpleadoDisca(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EmpleadoDiscaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EmpleadoDiscaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEmpleadoDisca(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EmpleadoDisca> empleadodiscas,EmpleadoDisca empleadodisca,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EmpleadoDisca empleadodiscaAux: empleadodiscas) {
			if(empleadodiscaAux!=null && empleadodisca!=null) {
				if((empleadodiscaAux.getId()==null && empleadodisca.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(empleadodiscaAux.getId()!=null && empleadodisca.getId()!=null){
					if(empleadodiscaAux.getId().equals(empleadodisca.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEmpleadoDisca(List<EmpleadoDisca> empleadodiscas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentaje_inicialTotal=0.0;
		Double porcentaje_finalTotal=0.0;
	
		for(EmpleadoDisca empleadodisca: empleadodiscas) {			
			if(empleadodisca.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentaje_inicialTotal+=empleadodisca.getporcentaje_inicial();
			porcentaje_finalTotal+=empleadodisca.getporcentaje_final();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EmpleadoDiscaConstantesFunciones.PORCENTAJEINICIAL);
		datoGeneral.setsDescripcion(EmpleadoDiscaConstantesFunciones.LABEL_PORCENTAJEINICIAL);
		datoGeneral.setdValorDouble(porcentaje_inicialTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EmpleadoDiscaConstantesFunciones.PORCENTAJEFINAL);
		datoGeneral.setsDescripcion(EmpleadoDiscaConstantesFunciones.LABEL_PORCENTAJEFINAL);
		datoGeneral.setdValorDouble(porcentaje_finalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEmpleadoDisca() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EmpleadoDiscaConstantesFunciones.LABEL_ID, EmpleadoDiscaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoDiscaConstantesFunciones.LABEL_VERSIONROW, EmpleadoDiscaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoDiscaConstantesFunciones.LABEL_IDEMPRESA, EmpleadoDiscaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoDiscaConstantesFunciones.LABEL_IDEMPLEADO, EmpleadoDiscaConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoDiscaConstantesFunciones.LABEL_IDTIPODISCAPACIDAD, EmpleadoDiscaConstantesFunciones.IDTIPODISCAPACIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoDiscaConstantesFunciones.LABEL_PORCENTAJEINICIAL, EmpleadoDiscaConstantesFunciones.PORCENTAJEINICIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoDiscaConstantesFunciones.LABEL_PORCENTAJEFINAL, EmpleadoDiscaConstantesFunciones.PORCENTAJEFINAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoDiscaConstantesFunciones.LABEL_DESCRIPCION, EmpleadoDiscaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEmpleadoDisca() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EmpleadoDiscaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoDiscaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoDiscaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoDiscaConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoDiscaConstantesFunciones.IDTIPODISCAPACIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoDiscaConstantesFunciones.PORCENTAJEINICIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoDiscaConstantesFunciones.PORCENTAJEFINAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoDiscaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoDisca() throws Exception  {
		return EmpleadoDiscaConstantesFunciones.getTiposSeleccionarEmpleadoDisca(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoDisca(Boolean conFk) throws Exception  {
		return EmpleadoDiscaConstantesFunciones.getTiposSeleccionarEmpleadoDisca(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoDisca(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoDiscaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EmpleadoDiscaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoDiscaConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(EmpleadoDiscaConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoDiscaConstantesFunciones.LABEL_IDTIPODISCAPACIDAD);
			reporte.setsDescripcion(EmpleadoDiscaConstantesFunciones.LABEL_IDTIPODISCAPACIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoDiscaConstantesFunciones.LABEL_PORCENTAJEINICIAL);
			reporte.setsDescripcion(EmpleadoDiscaConstantesFunciones.LABEL_PORCENTAJEINICIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoDiscaConstantesFunciones.LABEL_PORCENTAJEFINAL);
			reporte.setsDescripcion(EmpleadoDiscaConstantesFunciones.LABEL_PORCENTAJEFINAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoDiscaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(EmpleadoDiscaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEmpleadoDisca(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEmpleadoDisca(EmpleadoDisca empleadodiscaAux) throws Exception {
		
			empleadodiscaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(empleadodiscaAux.getEmpresa()));
			empleadodiscaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleadodiscaAux.getEmpleado()));
			empleadodiscaAux.settipodiscapacidad_descripcion(TipoDiscapacidadConstantesFunciones.getTipoDiscapacidadDescripcion(empleadodiscaAux.getTipoDiscapacidad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEmpleadoDisca(List<EmpleadoDisca> empleadodiscasTemp) throws Exception {
		for(EmpleadoDisca empleadodiscaAux:empleadodiscasTemp) {
			
			empleadodiscaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(empleadodiscaAux.getEmpresa()));
			empleadodiscaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleadodiscaAux.getEmpleado()));
			empleadodiscaAux.settipodiscapacidad_descripcion(TipoDiscapacidadConstantesFunciones.getTipoDiscapacidadDescripcion(empleadodiscaAux.getTipoDiscapacidad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEmpleadoDisca(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(TipoDiscapacidad.class));
				
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
					if(clas.clas.equals(TipoDiscapacidad.class)) {
						classes.add(new Classe(TipoDiscapacidad.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEmpleadoDisca(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(TipoDiscapacidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDiscapacidad.class)); continue;
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

					if(TipoDiscapacidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDiscapacidad.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoDisca(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpleadoDiscaConstantesFunciones.getClassesRelationshipsOfEmpleadoDisca(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoDisca(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpleadoDisca(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpleadoDiscaConstantesFunciones.getClassesRelationshipsFromStringsOfEmpleadoDisca(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpleadoDisca(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(EmpleadoDisca empleadodisca,List<EmpleadoDisca> empleadodiscas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EmpleadoDisca empleadodiscaEncontrado=null;
			
			for(EmpleadoDisca empleadodiscaLocal:empleadodiscas) {
				if(empleadodiscaLocal.getId().equals(empleadodisca.getId())) {
					empleadodiscaEncontrado=empleadodiscaLocal;
					
					empleadodiscaLocal.setIsChanged(empleadodisca.getIsChanged());
					empleadodiscaLocal.setIsNew(empleadodisca.getIsNew());
					empleadodiscaLocal.setIsDeleted(empleadodisca.getIsDeleted());
					
					empleadodiscaLocal.setGeneralEntityOriginal(empleadodisca.getGeneralEntityOriginal());
					
					empleadodiscaLocal.setId(empleadodisca.getId());	
					empleadodiscaLocal.setVersionRow(empleadodisca.getVersionRow());	
					empleadodiscaLocal.setid_empresa(empleadodisca.getid_empresa());	
					empleadodiscaLocal.setid_empleado(empleadodisca.getid_empleado());	
					empleadodiscaLocal.setid_tipo_discapacidad(empleadodisca.getid_tipo_discapacidad());	
					empleadodiscaLocal.setporcentaje_inicial(empleadodisca.getporcentaje_inicial());	
					empleadodiscaLocal.setporcentaje_final(empleadodisca.getporcentaje_final());	
					empleadodiscaLocal.setdescripcion(empleadodisca.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!empleadodisca.getIsDeleted()) {
				if(!existe) {
					empleadodiscas.add(empleadodisca);
				}
			} else {
				if(empleadodiscaEncontrado!=null && permiteQuitar)  {
					empleadodiscas.remove(empleadodiscaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EmpleadoDisca empleadodisca,List<EmpleadoDisca> empleadodiscas) throws Exception {
		try	{			
			for(EmpleadoDisca empleadodiscaLocal:empleadodiscas) {
				if(empleadodiscaLocal.getId().equals(empleadodisca.getId())) {
					empleadodiscaLocal.setIsSelected(empleadodisca.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEmpleadoDisca(List<EmpleadoDisca> empleadodiscasAux) throws Exception {
		//this.empleadodiscasAux=empleadodiscasAux;
		
		for(EmpleadoDisca empleadodiscaAux:empleadodiscasAux) {
			if(empleadodiscaAux.getIsChanged()) {
				empleadodiscaAux.setIsChanged(false);
			}		
			
			if(empleadodiscaAux.getIsNew()) {
				empleadodiscaAux.setIsNew(false);
			}	
			
			if(empleadodiscaAux.getIsDeleted()) {
				empleadodiscaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEmpleadoDisca(EmpleadoDisca empleadodiscaAux) throws Exception {
		//this.empleadodiscaAux=empleadodiscaAux;
		
			if(empleadodiscaAux.getIsChanged()) {
				empleadodiscaAux.setIsChanged(false);
			}		
			
			if(empleadodiscaAux.getIsNew()) {
				empleadodiscaAux.setIsNew(false);
			}	
			
			if(empleadodiscaAux.getIsDeleted()) {
				empleadodiscaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EmpleadoDisca empleadodiscaAsignar,EmpleadoDisca empleadodisca) throws Exception {
		empleadodiscaAsignar.setId(empleadodisca.getId());	
		empleadodiscaAsignar.setVersionRow(empleadodisca.getVersionRow());	
		empleadodiscaAsignar.setid_empresa(empleadodisca.getid_empresa());
		empleadodiscaAsignar.setempresa_descripcion(empleadodisca.getempresa_descripcion());	
		empleadodiscaAsignar.setid_empleado(empleadodisca.getid_empleado());
		empleadodiscaAsignar.setempleado_descripcion(empleadodisca.getempleado_descripcion());	
		empleadodiscaAsignar.setid_tipo_discapacidad(empleadodisca.getid_tipo_discapacidad());
		empleadodiscaAsignar.settipodiscapacidad_descripcion(empleadodisca.gettipodiscapacidad_descripcion());	
		empleadodiscaAsignar.setporcentaje_inicial(empleadodisca.getporcentaje_inicial());	
		empleadodiscaAsignar.setporcentaje_final(empleadodisca.getporcentaje_final());	
		empleadodiscaAsignar.setdescripcion(empleadodisca.getdescripcion());	
	}
	
	public static void inicializarEmpleadoDisca(EmpleadoDisca empleadodisca) throws Exception {
		try {
				empleadodisca.setId(0L);	
					
				empleadodisca.setid_empresa(-1L);	
				empleadodisca.setid_empleado(-1L);	
				empleadodisca.setid_tipo_discapacidad(-1L);	
				empleadodisca.setporcentaje_inicial(0.0);	
				empleadodisca.setporcentaje_final(0.0);	
				empleadodisca.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEmpleadoDisca(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoDiscaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoDiscaConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoDiscaConstantesFunciones.LABEL_IDTIPODISCAPACIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoDiscaConstantesFunciones.LABEL_PORCENTAJEINICIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoDiscaConstantesFunciones.LABEL_PORCENTAJEFINAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoDiscaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEmpleadoDisca(String sTipo,Row row,Workbook workbook,EmpleadoDisca empleadodisca,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadodisca.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadodisca.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadodisca.gettipodiscapacidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadodisca.getporcentaje_inicial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadodisca.getporcentaje_final());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadodisca.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEmpleadoDisca=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEmpleadoDisca() {
		return this.sFinalQueryEmpleadoDisca;
	}
	
	public void setsFinalQueryEmpleadoDisca(String sFinalQueryEmpleadoDisca) {
		this.sFinalQueryEmpleadoDisca= sFinalQueryEmpleadoDisca;
	}
	
	public Border resaltarSeleccionarEmpleadoDisca=null;
	
	public Border setResaltarSeleccionarEmpleadoDisca(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoDiscaBeanSwingJInternalFrame empleadodiscaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//empleadodiscaBeanSwingJInternalFrame.jTtoolBarEmpleadoDisca.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEmpleadoDisca= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEmpleadoDisca() {
		return this.resaltarSeleccionarEmpleadoDisca;
	}
	
	public void setResaltarSeleccionarEmpleadoDisca(Border borderResaltarSeleccionarEmpleadoDisca) {
		this.resaltarSeleccionarEmpleadoDisca= borderResaltarSeleccionarEmpleadoDisca;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEmpleadoDisca=null;
	public Boolean mostraridEmpleadoDisca=true;
	public Boolean activaridEmpleadoDisca=true;

	public Border resaltarid_empresaEmpleadoDisca=null;
	public Boolean mostrarid_empresaEmpleadoDisca=true;
	public Boolean activarid_empresaEmpleadoDisca=true;
	public Boolean cargarid_empresaEmpleadoDisca=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEmpleadoDisca=false;//ConEventDepend=true

	public Border resaltarid_empleadoEmpleadoDisca=null;
	public Boolean mostrarid_empleadoEmpleadoDisca=true;
	public Boolean activarid_empleadoEmpleadoDisca=true;
	public Boolean cargarid_empleadoEmpleadoDisca=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoEmpleadoDisca=false;//ConEventDepend=true

	public Border resaltarid_tipo_discapacidadEmpleadoDisca=null;
	public Boolean mostrarid_tipo_discapacidadEmpleadoDisca=true;
	public Boolean activarid_tipo_discapacidadEmpleadoDisca=true;
	public Boolean cargarid_tipo_discapacidadEmpleadoDisca=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_discapacidadEmpleadoDisca=false;//ConEventDepend=true

	public Border resaltarporcentaje_inicialEmpleadoDisca=null;
	public Boolean mostrarporcentaje_inicialEmpleadoDisca=true;
	public Boolean activarporcentaje_inicialEmpleadoDisca=true;

	public Border resaltarporcentaje_finalEmpleadoDisca=null;
	public Boolean mostrarporcentaje_finalEmpleadoDisca=true;
	public Boolean activarporcentaje_finalEmpleadoDisca=true;

	public Border resaltardescripcionEmpleadoDisca=null;
	public Boolean mostrardescripcionEmpleadoDisca=true;
	public Boolean activardescripcionEmpleadoDisca=true;

	
	

	public Border setResaltaridEmpleadoDisca(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoDiscaBeanSwingJInternalFrame empleadodiscaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadodiscaBeanSwingJInternalFrame.jTtoolBarEmpleadoDisca.setBorder(borderResaltar);
		
		this.resaltaridEmpleadoDisca= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEmpleadoDisca() {
		return this.resaltaridEmpleadoDisca;
	}

	public void setResaltaridEmpleadoDisca(Border borderResaltar) {
		this.resaltaridEmpleadoDisca= borderResaltar;
	}

	public Boolean getMostraridEmpleadoDisca() {
		return this.mostraridEmpleadoDisca;
	}

	public void setMostraridEmpleadoDisca(Boolean mostraridEmpleadoDisca) {
		this.mostraridEmpleadoDisca= mostraridEmpleadoDisca;
	}

	public Boolean getActivaridEmpleadoDisca() {
		return this.activaridEmpleadoDisca;
	}

	public void setActivaridEmpleadoDisca(Boolean activaridEmpleadoDisca) {
		this.activaridEmpleadoDisca= activaridEmpleadoDisca;
	}

	public Border setResaltarid_empresaEmpleadoDisca(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoDiscaBeanSwingJInternalFrame empleadodiscaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadodiscaBeanSwingJInternalFrame.jTtoolBarEmpleadoDisca.setBorder(borderResaltar);
		
		this.resaltarid_empresaEmpleadoDisca= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEmpleadoDisca() {
		return this.resaltarid_empresaEmpleadoDisca;
	}

	public void setResaltarid_empresaEmpleadoDisca(Border borderResaltar) {
		this.resaltarid_empresaEmpleadoDisca= borderResaltar;
	}

	public Boolean getMostrarid_empresaEmpleadoDisca() {
		return this.mostrarid_empresaEmpleadoDisca;
	}

	public void setMostrarid_empresaEmpleadoDisca(Boolean mostrarid_empresaEmpleadoDisca) {
		this.mostrarid_empresaEmpleadoDisca= mostrarid_empresaEmpleadoDisca;
	}

	public Boolean getActivarid_empresaEmpleadoDisca() {
		return this.activarid_empresaEmpleadoDisca;
	}

	public void setActivarid_empresaEmpleadoDisca(Boolean activarid_empresaEmpleadoDisca) {
		this.activarid_empresaEmpleadoDisca= activarid_empresaEmpleadoDisca;
	}

	public Boolean getCargarid_empresaEmpleadoDisca() {
		return this.cargarid_empresaEmpleadoDisca;
	}

	public void setCargarid_empresaEmpleadoDisca(Boolean cargarid_empresaEmpleadoDisca) {
		this.cargarid_empresaEmpleadoDisca= cargarid_empresaEmpleadoDisca;
	}

	public Border setResaltarid_empleadoEmpleadoDisca(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoDiscaBeanSwingJInternalFrame empleadodiscaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadodiscaBeanSwingJInternalFrame.jTtoolBarEmpleadoDisca.setBorder(borderResaltar);
		
		this.resaltarid_empleadoEmpleadoDisca= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoEmpleadoDisca() {
		return this.resaltarid_empleadoEmpleadoDisca;
	}

	public void setResaltarid_empleadoEmpleadoDisca(Border borderResaltar) {
		this.resaltarid_empleadoEmpleadoDisca= borderResaltar;
	}

	public Boolean getMostrarid_empleadoEmpleadoDisca() {
		return this.mostrarid_empleadoEmpleadoDisca;
	}

	public void setMostrarid_empleadoEmpleadoDisca(Boolean mostrarid_empleadoEmpleadoDisca) {
		this.mostrarid_empleadoEmpleadoDisca= mostrarid_empleadoEmpleadoDisca;
	}

	public Boolean getActivarid_empleadoEmpleadoDisca() {
		return this.activarid_empleadoEmpleadoDisca;
	}

	public void setActivarid_empleadoEmpleadoDisca(Boolean activarid_empleadoEmpleadoDisca) {
		this.activarid_empleadoEmpleadoDisca= activarid_empleadoEmpleadoDisca;
	}

	public Boolean getCargarid_empleadoEmpleadoDisca() {
		return this.cargarid_empleadoEmpleadoDisca;
	}

	public void setCargarid_empleadoEmpleadoDisca(Boolean cargarid_empleadoEmpleadoDisca) {
		this.cargarid_empleadoEmpleadoDisca= cargarid_empleadoEmpleadoDisca;
	}

	public Border setResaltarid_tipo_discapacidadEmpleadoDisca(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoDiscaBeanSwingJInternalFrame empleadodiscaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadodiscaBeanSwingJInternalFrame.jTtoolBarEmpleadoDisca.setBorder(borderResaltar);
		
		this.resaltarid_tipo_discapacidadEmpleadoDisca= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_discapacidadEmpleadoDisca() {
		return this.resaltarid_tipo_discapacidadEmpleadoDisca;
	}

	public void setResaltarid_tipo_discapacidadEmpleadoDisca(Border borderResaltar) {
		this.resaltarid_tipo_discapacidadEmpleadoDisca= borderResaltar;
	}

	public Boolean getMostrarid_tipo_discapacidadEmpleadoDisca() {
		return this.mostrarid_tipo_discapacidadEmpleadoDisca;
	}

	public void setMostrarid_tipo_discapacidadEmpleadoDisca(Boolean mostrarid_tipo_discapacidadEmpleadoDisca) {
		this.mostrarid_tipo_discapacidadEmpleadoDisca= mostrarid_tipo_discapacidadEmpleadoDisca;
	}

	public Boolean getActivarid_tipo_discapacidadEmpleadoDisca() {
		return this.activarid_tipo_discapacidadEmpleadoDisca;
	}

	public void setActivarid_tipo_discapacidadEmpleadoDisca(Boolean activarid_tipo_discapacidadEmpleadoDisca) {
		this.activarid_tipo_discapacidadEmpleadoDisca= activarid_tipo_discapacidadEmpleadoDisca;
	}

	public Boolean getCargarid_tipo_discapacidadEmpleadoDisca() {
		return this.cargarid_tipo_discapacidadEmpleadoDisca;
	}

	public void setCargarid_tipo_discapacidadEmpleadoDisca(Boolean cargarid_tipo_discapacidadEmpleadoDisca) {
		this.cargarid_tipo_discapacidadEmpleadoDisca= cargarid_tipo_discapacidadEmpleadoDisca;
	}

	public Border setResaltarporcentaje_inicialEmpleadoDisca(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoDiscaBeanSwingJInternalFrame empleadodiscaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadodiscaBeanSwingJInternalFrame.jTtoolBarEmpleadoDisca.setBorder(borderResaltar);
		
		this.resaltarporcentaje_inicialEmpleadoDisca= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_inicialEmpleadoDisca() {
		return this.resaltarporcentaje_inicialEmpleadoDisca;
	}

	public void setResaltarporcentaje_inicialEmpleadoDisca(Border borderResaltar) {
		this.resaltarporcentaje_inicialEmpleadoDisca= borderResaltar;
	}

	public Boolean getMostrarporcentaje_inicialEmpleadoDisca() {
		return this.mostrarporcentaje_inicialEmpleadoDisca;
	}

	public void setMostrarporcentaje_inicialEmpleadoDisca(Boolean mostrarporcentaje_inicialEmpleadoDisca) {
		this.mostrarporcentaje_inicialEmpleadoDisca= mostrarporcentaje_inicialEmpleadoDisca;
	}

	public Boolean getActivarporcentaje_inicialEmpleadoDisca() {
		return this.activarporcentaje_inicialEmpleadoDisca;
	}

	public void setActivarporcentaje_inicialEmpleadoDisca(Boolean activarporcentaje_inicialEmpleadoDisca) {
		this.activarporcentaje_inicialEmpleadoDisca= activarporcentaje_inicialEmpleadoDisca;
	}

	public Border setResaltarporcentaje_finalEmpleadoDisca(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoDiscaBeanSwingJInternalFrame empleadodiscaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadodiscaBeanSwingJInternalFrame.jTtoolBarEmpleadoDisca.setBorder(borderResaltar);
		
		this.resaltarporcentaje_finalEmpleadoDisca= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_finalEmpleadoDisca() {
		return this.resaltarporcentaje_finalEmpleadoDisca;
	}

	public void setResaltarporcentaje_finalEmpleadoDisca(Border borderResaltar) {
		this.resaltarporcentaje_finalEmpleadoDisca= borderResaltar;
	}

	public Boolean getMostrarporcentaje_finalEmpleadoDisca() {
		return this.mostrarporcentaje_finalEmpleadoDisca;
	}

	public void setMostrarporcentaje_finalEmpleadoDisca(Boolean mostrarporcentaje_finalEmpleadoDisca) {
		this.mostrarporcentaje_finalEmpleadoDisca= mostrarporcentaje_finalEmpleadoDisca;
	}

	public Boolean getActivarporcentaje_finalEmpleadoDisca() {
		return this.activarporcentaje_finalEmpleadoDisca;
	}

	public void setActivarporcentaje_finalEmpleadoDisca(Boolean activarporcentaje_finalEmpleadoDisca) {
		this.activarporcentaje_finalEmpleadoDisca= activarporcentaje_finalEmpleadoDisca;
	}

	public Border setResaltardescripcionEmpleadoDisca(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoDiscaBeanSwingJInternalFrame empleadodiscaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadodiscaBeanSwingJInternalFrame.jTtoolBarEmpleadoDisca.setBorder(borderResaltar);
		
		this.resaltardescripcionEmpleadoDisca= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionEmpleadoDisca() {
		return this.resaltardescripcionEmpleadoDisca;
	}

	public void setResaltardescripcionEmpleadoDisca(Border borderResaltar) {
		this.resaltardescripcionEmpleadoDisca= borderResaltar;
	}

	public Boolean getMostrardescripcionEmpleadoDisca() {
		return this.mostrardescripcionEmpleadoDisca;
	}

	public void setMostrardescripcionEmpleadoDisca(Boolean mostrardescripcionEmpleadoDisca) {
		this.mostrardescripcionEmpleadoDisca= mostrardescripcionEmpleadoDisca;
	}

	public Boolean getActivardescripcionEmpleadoDisca() {
		return this.activardescripcionEmpleadoDisca;
	}

	public void setActivardescripcionEmpleadoDisca(Boolean activardescripcionEmpleadoDisca) {
		this.activardescripcionEmpleadoDisca= activardescripcionEmpleadoDisca;
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
		
		
		this.setMostraridEmpleadoDisca(esInicial);
		this.setMostrarid_empresaEmpleadoDisca(esInicial);
		this.setMostrarid_empleadoEmpleadoDisca(esInicial);
		this.setMostrarid_tipo_discapacidadEmpleadoDisca(esInicial);
		this.setMostrarporcentaje_inicialEmpleadoDisca(esInicial);
		this.setMostrarporcentaje_finalEmpleadoDisca(esInicial);
		this.setMostrardescripcionEmpleadoDisca(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoDiscaConstantesFunciones.ID)) {
				this.setMostraridEmpleadoDisca(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoDiscaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEmpleadoDisca(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoDiscaConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoEmpleadoDisca(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoDiscaConstantesFunciones.IDTIPODISCAPACIDAD)) {
				this.setMostrarid_tipo_discapacidadEmpleadoDisca(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoDiscaConstantesFunciones.PORCENTAJEINICIAL)) {
				this.setMostrarporcentaje_inicialEmpleadoDisca(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoDiscaConstantesFunciones.PORCENTAJEFINAL)) {
				this.setMostrarporcentaje_finalEmpleadoDisca(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoDiscaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionEmpleadoDisca(esAsigna);
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
		
		
		this.setActivaridEmpleadoDisca(esInicial);
		this.setActivarid_empresaEmpleadoDisca(esInicial);
		this.setActivarid_empleadoEmpleadoDisca(esInicial);
		this.setActivarid_tipo_discapacidadEmpleadoDisca(esInicial);
		this.setActivarporcentaje_inicialEmpleadoDisca(esInicial);
		this.setActivarporcentaje_finalEmpleadoDisca(esInicial);
		this.setActivardescripcionEmpleadoDisca(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoDiscaConstantesFunciones.ID)) {
				this.setActivaridEmpleadoDisca(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoDiscaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEmpleadoDisca(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoDiscaConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoEmpleadoDisca(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoDiscaConstantesFunciones.IDTIPODISCAPACIDAD)) {
				this.setActivarid_tipo_discapacidadEmpleadoDisca(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoDiscaConstantesFunciones.PORCENTAJEINICIAL)) {
				this.setActivarporcentaje_inicialEmpleadoDisca(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoDiscaConstantesFunciones.PORCENTAJEFINAL)) {
				this.setActivarporcentaje_finalEmpleadoDisca(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoDiscaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionEmpleadoDisca(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpleadoDiscaBeanSwingJInternalFrame empleadodiscaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEmpleadoDisca(esInicial);
		this.setResaltarid_empresaEmpleadoDisca(esInicial);
		this.setResaltarid_empleadoEmpleadoDisca(esInicial);
		this.setResaltarid_tipo_discapacidadEmpleadoDisca(esInicial);
		this.setResaltarporcentaje_inicialEmpleadoDisca(esInicial);
		this.setResaltarporcentaje_finalEmpleadoDisca(esInicial);
		this.setResaltardescripcionEmpleadoDisca(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoDiscaConstantesFunciones.ID)) {
				this.setResaltaridEmpleadoDisca(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoDiscaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEmpleadoDisca(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoDiscaConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoEmpleadoDisca(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoDiscaConstantesFunciones.IDTIPODISCAPACIDAD)) {
				this.setResaltarid_tipo_discapacidadEmpleadoDisca(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoDiscaConstantesFunciones.PORCENTAJEINICIAL)) {
				this.setResaltarporcentaje_inicialEmpleadoDisca(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoDiscaConstantesFunciones.PORCENTAJEFINAL)) {
				this.setResaltarporcentaje_finalEmpleadoDisca(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoDiscaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionEmpleadoDisca(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpleadoDiscaBeanSwingJInternalFrame empleadodiscaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpleadoEmpleadoDisca=true;

	public Boolean getMostrarFK_IdEmpleadoEmpleadoDisca() {
		return this.mostrarFK_IdEmpleadoEmpleadoDisca;
	}

	public void setMostrarFK_IdEmpleadoEmpleadoDisca(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoEmpleadoDisca= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaEmpleadoDisca=true;

	public Boolean getMostrarFK_IdEmpresaEmpleadoDisca() {
		return this.mostrarFK_IdEmpresaEmpleadoDisca;
	}

	public void setMostrarFK_IdEmpresaEmpleadoDisca(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaEmpleadoDisca= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoDiscapacidadEmpleadoDisca=true;

	public Boolean getMostrarFK_IdTipoDiscapacidadEmpleadoDisca() {
		return this.mostrarFK_IdTipoDiscapacidadEmpleadoDisca;
	}

	public void setMostrarFK_IdTipoDiscapacidadEmpleadoDisca(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoDiscapacidadEmpleadoDisca= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoEmpleadoDisca=true;

	public Boolean getActivarFK_IdEmpleadoEmpleadoDisca() {
		return this.activarFK_IdEmpleadoEmpleadoDisca;
	}

	public void setActivarFK_IdEmpleadoEmpleadoDisca(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoEmpleadoDisca= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaEmpleadoDisca=true;

	public Boolean getActivarFK_IdEmpresaEmpleadoDisca() {
		return this.activarFK_IdEmpresaEmpleadoDisca;
	}

	public void setActivarFK_IdEmpresaEmpleadoDisca(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaEmpleadoDisca= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoDiscapacidadEmpleadoDisca=true;

	public Boolean getActivarFK_IdTipoDiscapacidadEmpleadoDisca() {
		return this.activarFK_IdTipoDiscapacidadEmpleadoDisca;
	}

	public void setActivarFK_IdTipoDiscapacidadEmpleadoDisca(Boolean habilitarResaltar) {
		this.activarFK_IdTipoDiscapacidadEmpleadoDisca= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoEmpleadoDisca=null;

	public Border getResaltarFK_IdEmpleadoEmpleadoDisca() {
		return this.resaltarFK_IdEmpleadoEmpleadoDisca;
	}

	public void setResaltarFK_IdEmpleadoEmpleadoDisca(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoEmpleadoDisca= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoEmpleadoDisca(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoDiscaBeanSwingJInternalFrame empleadodiscaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoEmpleadoDisca= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaEmpleadoDisca=null;

	public Border getResaltarFK_IdEmpresaEmpleadoDisca() {
		return this.resaltarFK_IdEmpresaEmpleadoDisca;
	}

	public void setResaltarFK_IdEmpresaEmpleadoDisca(Border borderResaltar) {
		this.resaltarFK_IdEmpresaEmpleadoDisca= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaEmpleadoDisca(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoDiscaBeanSwingJInternalFrame empleadodiscaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaEmpleadoDisca= borderResaltar;
	}

	public Border resaltarFK_IdTipoDiscapacidadEmpleadoDisca=null;

	public Border getResaltarFK_IdTipoDiscapacidadEmpleadoDisca() {
		return this.resaltarFK_IdTipoDiscapacidadEmpleadoDisca;
	}

	public void setResaltarFK_IdTipoDiscapacidadEmpleadoDisca(Border borderResaltar) {
		this.resaltarFK_IdTipoDiscapacidadEmpleadoDisca= borderResaltar;
	}

	public void setResaltarFK_IdTipoDiscapacidadEmpleadoDisca(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoDiscaBeanSwingJInternalFrame empleadodiscaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoDiscapacidadEmpleadoDisca= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}