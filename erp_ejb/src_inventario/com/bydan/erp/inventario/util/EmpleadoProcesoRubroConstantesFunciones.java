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


import com.bydan.erp.inventario.util.EmpleadoProcesoRubroConstantesFunciones;
import com.bydan.erp.inventario.util.EmpleadoProcesoRubroParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EmpleadoProcesoRubroParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EmpleadoProcesoRubroConstantesFunciones extends EmpleadoProcesoRubroConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EmpleadoProcesoRubro";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EmpleadoProcesoRubro"+EmpleadoProcesoRubroConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EmpleadoProcesoRubroHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EmpleadoProcesoRubroHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"_"+EmpleadoProcesoRubroConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EmpleadoProcesoRubroHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"_"+EmpleadoProcesoRubroConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"_"+EmpleadoProcesoRubroConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EmpleadoProcesoRubroHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"_"+EmpleadoProcesoRubroConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoProcesoRubroConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpleadoProcesoRubroHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoProcesoRubroConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoProcesoRubroConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpleadoProcesoRubroHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoProcesoRubroConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EmpleadoProcesoRubroConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EmpleadoProcesoRubroConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EmpleadoProcesoRubroConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EmpleadoProcesoRubroConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Empleado Proceso Rubros";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Empleado Proceso Rubro";
	public static final String SCLASSWEBTITULO_LOWER="Empleado Proceso Rubro";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EmpleadoProcesoRubro";
	public static final String OBJECTNAME="empleadoprocesorubro";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="empleado_proceso_rubro";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select empleadoprocesorubro from "+EmpleadoProcesoRubroConstantesFunciones.SPERSISTENCENAME+" empleadoprocesorubro";
	public static String QUERYSELECTNATIVE="select "+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"."+EmpleadoProcesoRubroConstantesFunciones.TABLENAME+".id,"+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"."+EmpleadoProcesoRubroConstantesFunciones.TABLENAME+".version_row,"+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"."+EmpleadoProcesoRubroConstantesFunciones.TABLENAME+".id_empresa,"+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"."+EmpleadoProcesoRubroConstantesFunciones.TABLENAME+".id_sucursal,"+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"."+EmpleadoProcesoRubroConstantesFunciones.TABLENAME+".id_estructura,"+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"."+EmpleadoProcesoRubroConstantesFunciones.TABLENAME+".id_empleado,"+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"."+EmpleadoProcesoRubroConstantesFunciones.TABLENAME+".fecha_ingreso,"+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"."+EmpleadoProcesoRubroConstantesFunciones.TABLENAME+".fecha_salida,"+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"."+EmpleadoProcesoRubroConstantesFunciones.TABLENAME+".observaciones,"+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"."+EmpleadoProcesoRubroConstantesFunciones.TABLENAME+".numeros_reingreso from "+EmpleadoProcesoRubroConstantesFunciones.SCHEMA+"."+EmpleadoProcesoRubroConstantesFunciones.TABLENAME;//+" as "+EmpleadoProcesoRubroConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EmpleadoProcesoRubroConstantesFuncionesAdditional empleadoprocesorubroConstantesFuncionesAdditional=null;
	
	public EmpleadoProcesoRubroConstantesFuncionesAdditional getEmpleadoProcesoRubroConstantesFuncionesAdditional() {
		return this.empleadoprocesorubroConstantesFuncionesAdditional;
	}
	
	public void setEmpleadoProcesoRubroConstantesFuncionesAdditional(EmpleadoProcesoRubroConstantesFuncionesAdditional empleadoprocesorubroConstantesFuncionesAdditional) {
		try {
			this.empleadoprocesorubroConstantesFuncionesAdditional=empleadoprocesorubroConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDESTRUCTURA= "id_estructura";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String FECHAINGRESO= "fecha_ingreso";
    public static final String FECHASALIDA= "fecha_salida";
    public static final String OBSERVACIONES= "observaciones";
    public static final String NUMEROSREINGRESO= "numeros_reingreso";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDESTRUCTURA= "Estructura";
		public static final String LABEL_IDESTRUCTURA_LOWER= "Estructura";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_FECHAINGRESO= "Fecha Ingreso";
		public static final String LABEL_FECHAINGRESO_LOWER= "Fecha Ingreso";
    	public static final String LABEL_FECHASALIDA= "Fecha Sala";
		public static final String LABEL_FECHASALIDA_LOWER= "Fecha Salida";
    	public static final String LABEL_OBSERVACIONES= "Observaciones";
		public static final String LABEL_OBSERVACIONES_LOWER= "Observaciones";
    	public static final String LABEL_NUMEROSREINGRESO= "Numeros Reingreso";
		public static final String LABEL_NUMEROSREINGRESO_LOWER= "Numeros Reingreso";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXOBSERVACIONES=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXOBSERVACIONES=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getEmpleadoProcesoRubroLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EmpleadoProcesoRubroConstantesFunciones.IDEMPRESA)) {sLabelColumna=EmpleadoProcesoRubroConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EmpleadoProcesoRubroConstantesFunciones.IDSUCURSAL)) {sLabelColumna=EmpleadoProcesoRubroConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(EmpleadoProcesoRubroConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=EmpleadoProcesoRubroConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(EmpleadoProcesoRubroConstantesFunciones.IDEMPLEADO)) {sLabelColumna=EmpleadoProcesoRubroConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(EmpleadoProcesoRubroConstantesFunciones.FECHAINGRESO)) {sLabelColumna=EmpleadoProcesoRubroConstantesFunciones.LABEL_FECHAINGRESO;}
		if(sNombreColumna.equals(EmpleadoProcesoRubroConstantesFunciones.FECHASALIDA)) {sLabelColumna=EmpleadoProcesoRubroConstantesFunciones.LABEL_FECHASALIDA;}
		if(sNombreColumna.equals(EmpleadoProcesoRubroConstantesFunciones.OBSERVACIONES)) {sLabelColumna=EmpleadoProcesoRubroConstantesFunciones.LABEL_OBSERVACIONES;}
		if(sNombreColumna.equals(EmpleadoProcesoRubroConstantesFunciones.NUMEROSREINGRESO)) {sLabelColumna=EmpleadoProcesoRubroConstantesFunciones.LABEL_NUMEROSREINGRESO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
	
	public static String getEmpleadoProcesoRubroDescripcion(EmpleadoProcesoRubro empleadoprocesorubro) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(empleadoprocesorubro !=null/* && empleadoprocesorubro.getId()!=0*/) {
			if(empleadoprocesorubro.getId()!=null) {
				sDescripcion=empleadoprocesorubro.getId().toString();
			}//empleadoprocesorubroempleadoprocesorubro.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getEmpleadoProcesoRubroDescripcionDetallado(EmpleadoProcesoRubro empleadoprocesorubro) {
		String sDescripcion="";
			
		sDescripcion+=EmpleadoProcesoRubroConstantesFunciones.ID+"=";
		sDescripcion+=empleadoprocesorubro.getId().toString()+",";
		sDescripcion+=EmpleadoProcesoRubroConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=empleadoprocesorubro.getVersionRow().toString()+",";
		sDescripcion+=EmpleadoProcesoRubroConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=empleadoprocesorubro.getid_empresa().toString()+",";
		sDescripcion+=EmpleadoProcesoRubroConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=empleadoprocesorubro.getid_sucursal().toString()+",";
		sDescripcion+=EmpleadoProcesoRubroConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=empleadoprocesorubro.getid_estructura().toString()+",";
		sDescripcion+=EmpleadoProcesoRubroConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=empleadoprocesorubro.getid_empleado().toString()+",";
		sDescripcion+=EmpleadoProcesoRubroConstantesFunciones.FECHAINGRESO+"=";
		sDescripcion+=empleadoprocesorubro.getfecha_ingreso().toString()+",";
		sDescripcion+=EmpleadoProcesoRubroConstantesFunciones.FECHASALIDA+"=";
		sDescripcion+=empleadoprocesorubro.getfecha_salida().toString()+",";
		sDescripcion+=EmpleadoProcesoRubroConstantesFunciones.OBSERVACIONES+"=";
		sDescripcion+=empleadoprocesorubro.getobservaciones()+",";
		sDescripcion+=EmpleadoProcesoRubroConstantesFunciones.NUMEROSREINGRESO+"=";
		sDescripcion+=empleadoprocesorubro.getnumeros_reingreso().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setEmpleadoProcesoRubroDescripcion(EmpleadoProcesoRubro empleadoprocesorubro,String sValor) throws Exception {			
		if(empleadoprocesorubro !=null) {
			//empleadoprocesorubroempleadoprocesorubro.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getEstructuraDescripcion(Estructura estructura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estructura!=null/*&&estructura.getId()>0*/) {
			sDescripcion=EstructuraConstantesFunciones.getEstructuraDescripcion(estructura);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstructura")) {
			sNombreIndice="Tipo=  Por Estructura";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
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

	public static String getDetalleIndiceFK_IdEstructura(Long id_estructura) {
		String sDetalleIndice=" Parametros->";
		if(id_estructura!=null) {sDetalleIndice+=" Codigo Unico De Estructura="+id_estructura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEmpleadoProcesoRubro(EmpleadoProcesoRubro empleadoprocesorubro,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		empleadoprocesorubro.setobservaciones(empleadoprocesorubro.getobservaciones().trim());
	}
	
	public static void quitarEspaciosEmpleadoProcesoRubros(List<EmpleadoProcesoRubro> empleadoprocesorubros,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EmpleadoProcesoRubro empleadoprocesorubro: empleadoprocesorubros) {
			empleadoprocesorubro.setobservaciones(empleadoprocesorubro.getobservaciones().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpleadoProcesoRubro(EmpleadoProcesoRubro empleadoprocesorubro,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && empleadoprocesorubro.getConCambioAuxiliar()) {
			empleadoprocesorubro.setIsDeleted(empleadoprocesorubro.getIsDeletedAuxiliar());	
			empleadoprocesorubro.setIsNew(empleadoprocesorubro.getIsNewAuxiliar());	
			empleadoprocesorubro.setIsChanged(empleadoprocesorubro.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			empleadoprocesorubro.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			empleadoprocesorubro.setIsDeletedAuxiliar(false);	
			empleadoprocesorubro.setIsNewAuxiliar(false);	
			empleadoprocesorubro.setIsChangedAuxiliar(false);
			
			empleadoprocesorubro.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpleadoProcesoRubros(List<EmpleadoProcesoRubro> empleadoprocesorubros,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EmpleadoProcesoRubro empleadoprocesorubro : empleadoprocesorubros) {
			if(conAsignarBase && empleadoprocesorubro.getConCambioAuxiliar()) {
				empleadoprocesorubro.setIsDeleted(empleadoprocesorubro.getIsDeletedAuxiliar());	
				empleadoprocesorubro.setIsNew(empleadoprocesorubro.getIsNewAuxiliar());	
				empleadoprocesorubro.setIsChanged(empleadoprocesorubro.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				empleadoprocesorubro.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				empleadoprocesorubro.setIsDeletedAuxiliar(false);	
				empleadoprocesorubro.setIsNewAuxiliar(false);	
				empleadoprocesorubro.setIsChangedAuxiliar(false);
				
				empleadoprocesorubro.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEmpleadoProcesoRubro(EmpleadoProcesoRubro empleadoprocesorubro,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			empleadoprocesorubro.setnumeros_reingreso(0);
		}
	}		
	
	public static void InicializarValoresEmpleadoProcesoRubros(List<EmpleadoProcesoRubro> empleadoprocesorubros,Boolean conEnteros) throws Exception  {
		
		for(EmpleadoProcesoRubro empleadoprocesorubro: empleadoprocesorubros) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				empleadoprocesorubro.setnumeros_reingreso(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaEmpleadoProcesoRubro(List<EmpleadoProcesoRubro> empleadoprocesorubros,EmpleadoProcesoRubro empleadoprocesorubroAux) throws Exception  {
		EmpleadoProcesoRubroConstantesFunciones.InicializarValoresEmpleadoProcesoRubro(empleadoprocesorubroAux,true);
		
		for(EmpleadoProcesoRubro empleadoprocesorubro: empleadoprocesorubros) {
			if(empleadoprocesorubro.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			empleadoprocesorubroAux.setnumeros_reingreso(empleadoprocesorubroAux.getnumeros_reingreso()+empleadoprocesorubro.getnumeros_reingreso());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpleadoProcesoRubro(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EmpleadoProcesoRubroConstantesFunciones.getArrayColumnasGlobalesEmpleadoProcesoRubro(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpleadoProcesoRubro(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EmpleadoProcesoRubroConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EmpleadoProcesoRubroConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EmpleadoProcesoRubroConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EmpleadoProcesoRubroConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEmpleadoProcesoRubro(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EmpleadoProcesoRubro> empleadoprocesorubros,EmpleadoProcesoRubro empleadoprocesorubro,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EmpleadoProcesoRubro empleadoprocesorubroAux: empleadoprocesorubros) {
			if(empleadoprocesorubroAux!=null && empleadoprocesorubro!=null) {
				if((empleadoprocesorubroAux.getId()==null && empleadoprocesorubro.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(empleadoprocesorubroAux.getId()!=null && empleadoprocesorubro.getId()!=null){
					if(empleadoprocesorubroAux.getId().equals(empleadoprocesorubro.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEmpleadoProcesoRubro(List<EmpleadoProcesoRubro> empleadoprocesorubros) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EmpleadoProcesoRubro empleadoprocesorubro: empleadoprocesorubros) {			
			if(empleadoprocesorubro.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEmpleadoProcesoRubro() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EmpleadoProcesoRubroConstantesFunciones.LABEL_ID, EmpleadoProcesoRubroConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoProcesoRubroConstantesFunciones.LABEL_VERSIONROW, EmpleadoProcesoRubroConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoProcesoRubroConstantesFunciones.LABEL_IDEMPRESA, EmpleadoProcesoRubroConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoProcesoRubroConstantesFunciones.LABEL_IDSUCURSAL, EmpleadoProcesoRubroConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoProcesoRubroConstantesFunciones.LABEL_IDESTRUCTURA, EmpleadoProcesoRubroConstantesFunciones.IDESTRUCTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoProcesoRubroConstantesFunciones.LABEL_IDEMPLEADO, EmpleadoProcesoRubroConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoProcesoRubroConstantesFunciones.LABEL_FECHAINGRESO, EmpleadoProcesoRubroConstantesFunciones.FECHAINGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoProcesoRubroConstantesFunciones.LABEL_FECHASALIDA, EmpleadoProcesoRubroConstantesFunciones.FECHASALIDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoProcesoRubroConstantesFunciones.LABEL_OBSERVACIONES, EmpleadoProcesoRubroConstantesFunciones.OBSERVACIONES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoProcesoRubroConstantesFunciones.LABEL_NUMEROSREINGRESO, EmpleadoProcesoRubroConstantesFunciones.NUMEROSREINGRESO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEmpleadoProcesoRubro() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EmpleadoProcesoRubroConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoProcesoRubroConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoProcesoRubroConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoProcesoRubroConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoProcesoRubroConstantesFunciones.IDESTRUCTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoProcesoRubroConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoProcesoRubroConstantesFunciones.FECHAINGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoProcesoRubroConstantesFunciones.FECHASALIDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoProcesoRubroConstantesFunciones.OBSERVACIONES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoProcesoRubroConstantesFunciones.NUMEROSREINGRESO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoProcesoRubro() throws Exception  {
		return EmpleadoProcesoRubroConstantesFunciones.getTiposSeleccionarEmpleadoProcesoRubro(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoProcesoRubro(Boolean conFk) throws Exception  {
		return EmpleadoProcesoRubroConstantesFunciones.getTiposSeleccionarEmpleadoProcesoRubro(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoProcesoRubro(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoProcesoRubroConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EmpleadoProcesoRubroConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoProcesoRubroConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(EmpleadoProcesoRubroConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoProcesoRubroConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(EmpleadoProcesoRubroConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoProcesoRubroConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(EmpleadoProcesoRubroConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoProcesoRubroConstantesFunciones.LABEL_FECHAINGRESO);
			reporte.setsDescripcion(EmpleadoProcesoRubroConstantesFunciones.LABEL_FECHAINGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoProcesoRubroConstantesFunciones.LABEL_FECHASALIDA);
			reporte.setsDescripcion(EmpleadoProcesoRubroConstantesFunciones.LABEL_FECHASALIDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoProcesoRubroConstantesFunciones.LABEL_OBSERVACIONES);
			reporte.setsDescripcion(EmpleadoProcesoRubroConstantesFunciones.LABEL_OBSERVACIONES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoProcesoRubroConstantesFunciones.LABEL_NUMEROSREINGRESO);
			reporte.setsDescripcion(EmpleadoProcesoRubroConstantesFunciones.LABEL_NUMEROSREINGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEmpleadoProcesoRubro(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(EmpleadoProcesoRubro empleadoprocesorubroAux) throws Exception {
		
			empleadoprocesorubroAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(empleadoprocesorubroAux.getEmpresa()));
			empleadoprocesorubroAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(empleadoprocesorubroAux.getSucursal()));
			empleadoprocesorubroAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(empleadoprocesorubroAux.getEstructura()));
			empleadoprocesorubroAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleadoprocesorubroAux.getEmpleado()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEmpleadoProcesoRubro(List<EmpleadoProcesoRubro> empleadoprocesorubrosTemp) throws Exception {
		for(EmpleadoProcesoRubro empleadoprocesorubroAux:empleadoprocesorubrosTemp) {
			
			empleadoprocesorubroAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(empleadoprocesorubroAux.getEmpresa()));
			empleadoprocesorubroAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(empleadoprocesorubroAux.getSucursal()));
			empleadoprocesorubroAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(empleadoprocesorubroAux.getEstructura()));
			empleadoprocesorubroAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleadoprocesorubroAux.getEmpleado()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEmpleadoProcesoRubro(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(Empleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEmpleadoProcesoRubro(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoProcesoRubro(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpleadoProcesoRubroConstantesFunciones.getClassesRelationshipsOfEmpleadoProcesoRubro(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoProcesoRubro(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpleadoProcesoRubro(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpleadoProcesoRubroConstantesFunciones.getClassesRelationshipsFromStringsOfEmpleadoProcesoRubro(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpleadoProcesoRubro(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(EmpleadoProcesoRubro empleadoprocesorubro,List<EmpleadoProcesoRubro> empleadoprocesorubros,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EmpleadoProcesoRubro empleadoprocesorubroEncontrado=null;
			
			for(EmpleadoProcesoRubro empleadoprocesorubroLocal:empleadoprocesorubros) {
				if(empleadoprocesorubroLocal.getId().equals(empleadoprocesorubro.getId())) {
					empleadoprocesorubroEncontrado=empleadoprocesorubroLocal;
					
					empleadoprocesorubroLocal.setIsChanged(empleadoprocesorubro.getIsChanged());
					empleadoprocesorubroLocal.setIsNew(empleadoprocesorubro.getIsNew());
					empleadoprocesorubroLocal.setIsDeleted(empleadoprocesorubro.getIsDeleted());
					
					empleadoprocesorubroLocal.setGeneralEntityOriginal(empleadoprocesorubro.getGeneralEntityOriginal());
					
					empleadoprocesorubroLocal.setId(empleadoprocesorubro.getId());	
					empleadoprocesorubroLocal.setVersionRow(empleadoprocesorubro.getVersionRow());	
					empleadoprocesorubroLocal.setid_empresa(empleadoprocesorubro.getid_empresa());	
					empleadoprocesorubroLocal.setid_sucursal(empleadoprocesorubro.getid_sucursal());	
					empleadoprocesorubroLocal.setid_estructura(empleadoprocesorubro.getid_estructura());	
					empleadoprocesorubroLocal.setid_empleado(empleadoprocesorubro.getid_empleado());	
					empleadoprocesorubroLocal.setfecha_ingreso(empleadoprocesorubro.getfecha_ingreso());	
					empleadoprocesorubroLocal.setfecha_salida(empleadoprocesorubro.getfecha_salida());	
					empleadoprocesorubroLocal.setobservaciones(empleadoprocesorubro.getobservaciones());	
					empleadoprocesorubroLocal.setnumeros_reingreso(empleadoprocesorubro.getnumeros_reingreso());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!empleadoprocesorubro.getIsDeleted()) {
				if(!existe) {
					empleadoprocesorubros.add(empleadoprocesorubro);
				}
			} else {
				if(empleadoprocesorubroEncontrado!=null && permiteQuitar)  {
					empleadoprocesorubros.remove(empleadoprocesorubroEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EmpleadoProcesoRubro empleadoprocesorubro,List<EmpleadoProcesoRubro> empleadoprocesorubros) throws Exception {
		try	{			
			for(EmpleadoProcesoRubro empleadoprocesorubroLocal:empleadoprocesorubros) {
				if(empleadoprocesorubroLocal.getId().equals(empleadoprocesorubro.getId())) {
					empleadoprocesorubroLocal.setIsSelected(empleadoprocesorubro.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEmpleadoProcesoRubro(List<EmpleadoProcesoRubro> empleadoprocesorubrosAux) throws Exception {
		//this.empleadoprocesorubrosAux=empleadoprocesorubrosAux;
		
		for(EmpleadoProcesoRubro empleadoprocesorubroAux:empleadoprocesorubrosAux) {
			if(empleadoprocesorubroAux.getIsChanged()) {
				empleadoprocesorubroAux.setIsChanged(false);
			}		
			
			if(empleadoprocesorubroAux.getIsNew()) {
				empleadoprocesorubroAux.setIsNew(false);
			}	
			
			if(empleadoprocesorubroAux.getIsDeleted()) {
				empleadoprocesorubroAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEmpleadoProcesoRubro(EmpleadoProcesoRubro empleadoprocesorubroAux) throws Exception {
		//this.empleadoprocesorubroAux=empleadoprocesorubroAux;
		
			if(empleadoprocesorubroAux.getIsChanged()) {
				empleadoprocesorubroAux.setIsChanged(false);
			}		
			
			if(empleadoprocesorubroAux.getIsNew()) {
				empleadoprocesorubroAux.setIsNew(false);
			}	
			
			if(empleadoprocesorubroAux.getIsDeleted()) {
				empleadoprocesorubroAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EmpleadoProcesoRubro empleadoprocesorubroAsignar,EmpleadoProcesoRubro empleadoprocesorubro) throws Exception {
		empleadoprocesorubroAsignar.setId(empleadoprocesorubro.getId());	
		empleadoprocesorubroAsignar.setVersionRow(empleadoprocesorubro.getVersionRow());	
		empleadoprocesorubroAsignar.setid_empresa(empleadoprocesorubro.getid_empresa());
		empleadoprocesorubroAsignar.setempresa_descripcion(empleadoprocesorubro.getempresa_descripcion());	
		empleadoprocesorubroAsignar.setid_sucursal(empleadoprocesorubro.getid_sucursal());
		empleadoprocesorubroAsignar.setsucursal_descripcion(empleadoprocesorubro.getsucursal_descripcion());	
		empleadoprocesorubroAsignar.setid_estructura(empleadoprocesorubro.getid_estructura());
		empleadoprocesorubroAsignar.setestructura_descripcion(empleadoprocesorubro.getestructura_descripcion());	
		empleadoprocesorubroAsignar.setid_empleado(empleadoprocesorubro.getid_empleado());
		empleadoprocesorubroAsignar.setempleado_descripcion(empleadoprocesorubro.getempleado_descripcion());	
		empleadoprocesorubroAsignar.setfecha_ingreso(empleadoprocesorubro.getfecha_ingreso());	
		empleadoprocesorubroAsignar.setfecha_salida(empleadoprocesorubro.getfecha_salida());	
		empleadoprocesorubroAsignar.setobservaciones(empleadoprocesorubro.getobservaciones());	
		empleadoprocesorubroAsignar.setnumeros_reingreso(empleadoprocesorubro.getnumeros_reingreso());	
	}
	
	public static void inicializarEmpleadoProcesoRubro(EmpleadoProcesoRubro empleadoprocesorubro) throws Exception {
		try {
				empleadoprocesorubro.setId(0L);	
					
				empleadoprocesorubro.setid_empresa(-1L);	
				empleadoprocesorubro.setid_sucursal(-1L);	
				empleadoprocesorubro.setid_estructura(-1L);	
				empleadoprocesorubro.setid_empleado(-1L);	
				empleadoprocesorubro.setfecha_ingreso(new Date());	
				empleadoprocesorubro.setfecha_salida(new Date());	
				empleadoprocesorubro.setobservaciones("");	
				empleadoprocesorubro.setnumeros_reingreso(0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEmpleadoProcesoRubro(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoProcesoRubroConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoProcesoRubroConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoProcesoRubroConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoProcesoRubroConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoProcesoRubroConstantesFunciones.LABEL_FECHAINGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoProcesoRubroConstantesFunciones.LABEL_FECHASALIDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoProcesoRubroConstantesFunciones.LABEL_OBSERVACIONES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoProcesoRubroConstantesFunciones.LABEL_NUMEROSREINGRESO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEmpleadoProcesoRubro(String sTipo,Row row,Workbook workbook,EmpleadoProcesoRubro empleadoprocesorubro,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoprocesorubro.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoprocesorubro.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoprocesorubro.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoprocesorubro.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoprocesorubro.getfecha_ingreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoprocesorubro.getfecha_salida());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoprocesorubro.getobservaciones());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoprocesorubro.getnumeros_reingreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEmpleadoProcesoRubro=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEmpleadoProcesoRubro() {
		return this.sFinalQueryEmpleadoProcesoRubro;
	}
	
	public void setsFinalQueryEmpleadoProcesoRubro(String sFinalQueryEmpleadoProcesoRubro) {
		this.sFinalQueryEmpleadoProcesoRubro= sFinalQueryEmpleadoProcesoRubro;
	}
	
	public Border resaltarSeleccionarEmpleadoProcesoRubro=null;
	
	public Border setResaltarSeleccionarEmpleadoProcesoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoProcesoRubroBeanSwingJInternalFrame empleadoprocesorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//empleadoprocesorubroBeanSwingJInternalFrame.jTtoolBarEmpleadoProcesoRubro.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEmpleadoProcesoRubro= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEmpleadoProcesoRubro() {
		return this.resaltarSeleccionarEmpleadoProcesoRubro;
	}
	
	public void setResaltarSeleccionarEmpleadoProcesoRubro(Border borderResaltarSeleccionarEmpleadoProcesoRubro) {
		this.resaltarSeleccionarEmpleadoProcesoRubro= borderResaltarSeleccionarEmpleadoProcesoRubro;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEmpleadoProcesoRubro=null;
	public Boolean mostraridEmpleadoProcesoRubro=true;
	public Boolean activaridEmpleadoProcesoRubro=true;

	public Border resaltarid_empresaEmpleadoProcesoRubro=null;
	public Boolean mostrarid_empresaEmpleadoProcesoRubro=true;
	public Boolean activarid_empresaEmpleadoProcesoRubro=true;
	public Boolean cargarid_empresaEmpleadoProcesoRubro=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEmpleadoProcesoRubro=false;//ConEventDepend=true

	public Border resaltarid_sucursalEmpleadoProcesoRubro=null;
	public Boolean mostrarid_sucursalEmpleadoProcesoRubro=true;
	public Boolean activarid_sucursalEmpleadoProcesoRubro=true;
	public Boolean cargarid_sucursalEmpleadoProcesoRubro=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalEmpleadoProcesoRubro=false;//ConEventDepend=true

	public Border resaltarid_estructuraEmpleadoProcesoRubro=null;
	public Boolean mostrarid_estructuraEmpleadoProcesoRubro=true;
	public Boolean activarid_estructuraEmpleadoProcesoRubro=true;
	public Boolean cargarid_estructuraEmpleadoProcesoRubro=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraEmpleadoProcesoRubro=false;//ConEventDepend=true

	public Border resaltarid_empleadoEmpleadoProcesoRubro=null;
	public Boolean mostrarid_empleadoEmpleadoProcesoRubro=true;
	public Boolean activarid_empleadoEmpleadoProcesoRubro=true;
	public Boolean cargarid_empleadoEmpleadoProcesoRubro=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoEmpleadoProcesoRubro=false;//ConEventDepend=true

	public Border resaltarfecha_ingresoEmpleadoProcesoRubro=null;
	public Boolean mostrarfecha_ingresoEmpleadoProcesoRubro=true;
	public Boolean activarfecha_ingresoEmpleadoProcesoRubro=false;

	public Border resaltarfecha_salidaEmpleadoProcesoRubro=null;
	public Boolean mostrarfecha_salidaEmpleadoProcesoRubro=true;
	public Boolean activarfecha_salidaEmpleadoProcesoRubro=false;

	public Border resaltarobservacionesEmpleadoProcesoRubro=null;
	public Boolean mostrarobservacionesEmpleadoProcesoRubro=true;
	public Boolean activarobservacionesEmpleadoProcesoRubro=true;

	public Border resaltarnumeros_reingresoEmpleadoProcesoRubro=null;
	public Boolean mostrarnumeros_reingresoEmpleadoProcesoRubro=true;
	public Boolean activarnumeros_reingresoEmpleadoProcesoRubro=true;

	
	

	public Border setResaltaridEmpleadoProcesoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoProcesoRubroBeanSwingJInternalFrame empleadoprocesorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoprocesorubroBeanSwingJInternalFrame.jTtoolBarEmpleadoProcesoRubro.setBorder(borderResaltar);
		
		this.resaltaridEmpleadoProcesoRubro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEmpleadoProcesoRubro() {
		return this.resaltaridEmpleadoProcesoRubro;
	}

	public void setResaltaridEmpleadoProcesoRubro(Border borderResaltar) {
		this.resaltaridEmpleadoProcesoRubro= borderResaltar;
	}

	public Boolean getMostraridEmpleadoProcesoRubro() {
		return this.mostraridEmpleadoProcesoRubro;
	}

	public void setMostraridEmpleadoProcesoRubro(Boolean mostraridEmpleadoProcesoRubro) {
		this.mostraridEmpleadoProcesoRubro= mostraridEmpleadoProcesoRubro;
	}

	public Boolean getActivaridEmpleadoProcesoRubro() {
		return this.activaridEmpleadoProcesoRubro;
	}

	public void setActivaridEmpleadoProcesoRubro(Boolean activaridEmpleadoProcesoRubro) {
		this.activaridEmpleadoProcesoRubro= activaridEmpleadoProcesoRubro;
	}

	public Border setResaltarid_empresaEmpleadoProcesoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoProcesoRubroBeanSwingJInternalFrame empleadoprocesorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoprocesorubroBeanSwingJInternalFrame.jTtoolBarEmpleadoProcesoRubro.setBorder(borderResaltar);
		
		this.resaltarid_empresaEmpleadoProcesoRubro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEmpleadoProcesoRubro() {
		return this.resaltarid_empresaEmpleadoProcesoRubro;
	}

	public void setResaltarid_empresaEmpleadoProcesoRubro(Border borderResaltar) {
		this.resaltarid_empresaEmpleadoProcesoRubro= borderResaltar;
	}

	public Boolean getMostrarid_empresaEmpleadoProcesoRubro() {
		return this.mostrarid_empresaEmpleadoProcesoRubro;
	}

	public void setMostrarid_empresaEmpleadoProcesoRubro(Boolean mostrarid_empresaEmpleadoProcesoRubro) {
		this.mostrarid_empresaEmpleadoProcesoRubro= mostrarid_empresaEmpleadoProcesoRubro;
	}

	public Boolean getActivarid_empresaEmpleadoProcesoRubro() {
		return this.activarid_empresaEmpleadoProcesoRubro;
	}

	public void setActivarid_empresaEmpleadoProcesoRubro(Boolean activarid_empresaEmpleadoProcesoRubro) {
		this.activarid_empresaEmpleadoProcesoRubro= activarid_empresaEmpleadoProcesoRubro;
	}

	public Boolean getCargarid_empresaEmpleadoProcesoRubro() {
		return this.cargarid_empresaEmpleadoProcesoRubro;
	}

	public void setCargarid_empresaEmpleadoProcesoRubro(Boolean cargarid_empresaEmpleadoProcesoRubro) {
		this.cargarid_empresaEmpleadoProcesoRubro= cargarid_empresaEmpleadoProcesoRubro;
	}

	public Border setResaltarid_sucursalEmpleadoProcesoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoProcesoRubroBeanSwingJInternalFrame empleadoprocesorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoprocesorubroBeanSwingJInternalFrame.jTtoolBarEmpleadoProcesoRubro.setBorder(borderResaltar);
		
		this.resaltarid_sucursalEmpleadoProcesoRubro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalEmpleadoProcesoRubro() {
		return this.resaltarid_sucursalEmpleadoProcesoRubro;
	}

	public void setResaltarid_sucursalEmpleadoProcesoRubro(Border borderResaltar) {
		this.resaltarid_sucursalEmpleadoProcesoRubro= borderResaltar;
	}

	public Boolean getMostrarid_sucursalEmpleadoProcesoRubro() {
		return this.mostrarid_sucursalEmpleadoProcesoRubro;
	}

	public void setMostrarid_sucursalEmpleadoProcesoRubro(Boolean mostrarid_sucursalEmpleadoProcesoRubro) {
		this.mostrarid_sucursalEmpleadoProcesoRubro= mostrarid_sucursalEmpleadoProcesoRubro;
	}

	public Boolean getActivarid_sucursalEmpleadoProcesoRubro() {
		return this.activarid_sucursalEmpleadoProcesoRubro;
	}

	public void setActivarid_sucursalEmpleadoProcesoRubro(Boolean activarid_sucursalEmpleadoProcesoRubro) {
		this.activarid_sucursalEmpleadoProcesoRubro= activarid_sucursalEmpleadoProcesoRubro;
	}

	public Boolean getCargarid_sucursalEmpleadoProcesoRubro() {
		return this.cargarid_sucursalEmpleadoProcesoRubro;
	}

	public void setCargarid_sucursalEmpleadoProcesoRubro(Boolean cargarid_sucursalEmpleadoProcesoRubro) {
		this.cargarid_sucursalEmpleadoProcesoRubro= cargarid_sucursalEmpleadoProcesoRubro;
	}

	public Border setResaltarid_estructuraEmpleadoProcesoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoProcesoRubroBeanSwingJInternalFrame empleadoprocesorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoprocesorubroBeanSwingJInternalFrame.jTtoolBarEmpleadoProcesoRubro.setBorder(borderResaltar);
		
		this.resaltarid_estructuraEmpleadoProcesoRubro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraEmpleadoProcesoRubro() {
		return this.resaltarid_estructuraEmpleadoProcesoRubro;
	}

	public void setResaltarid_estructuraEmpleadoProcesoRubro(Border borderResaltar) {
		this.resaltarid_estructuraEmpleadoProcesoRubro= borderResaltar;
	}

	public Boolean getMostrarid_estructuraEmpleadoProcesoRubro() {
		return this.mostrarid_estructuraEmpleadoProcesoRubro;
	}

	public void setMostrarid_estructuraEmpleadoProcesoRubro(Boolean mostrarid_estructuraEmpleadoProcesoRubro) {
		this.mostrarid_estructuraEmpleadoProcesoRubro= mostrarid_estructuraEmpleadoProcesoRubro;
	}

	public Boolean getActivarid_estructuraEmpleadoProcesoRubro() {
		return this.activarid_estructuraEmpleadoProcesoRubro;
	}

	public void setActivarid_estructuraEmpleadoProcesoRubro(Boolean activarid_estructuraEmpleadoProcesoRubro) {
		this.activarid_estructuraEmpleadoProcesoRubro= activarid_estructuraEmpleadoProcesoRubro;
	}

	public Boolean getCargarid_estructuraEmpleadoProcesoRubro() {
		return this.cargarid_estructuraEmpleadoProcesoRubro;
	}

	public void setCargarid_estructuraEmpleadoProcesoRubro(Boolean cargarid_estructuraEmpleadoProcesoRubro) {
		this.cargarid_estructuraEmpleadoProcesoRubro= cargarid_estructuraEmpleadoProcesoRubro;
	}

	public Border setResaltarid_empleadoEmpleadoProcesoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoProcesoRubroBeanSwingJInternalFrame empleadoprocesorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoprocesorubroBeanSwingJInternalFrame.jTtoolBarEmpleadoProcesoRubro.setBorder(borderResaltar);
		
		this.resaltarid_empleadoEmpleadoProcesoRubro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoEmpleadoProcesoRubro() {
		return this.resaltarid_empleadoEmpleadoProcesoRubro;
	}

	public void setResaltarid_empleadoEmpleadoProcesoRubro(Border borderResaltar) {
		this.resaltarid_empleadoEmpleadoProcesoRubro= borderResaltar;
	}

	public Boolean getMostrarid_empleadoEmpleadoProcesoRubro() {
		return this.mostrarid_empleadoEmpleadoProcesoRubro;
	}

	public void setMostrarid_empleadoEmpleadoProcesoRubro(Boolean mostrarid_empleadoEmpleadoProcesoRubro) {
		this.mostrarid_empleadoEmpleadoProcesoRubro= mostrarid_empleadoEmpleadoProcesoRubro;
	}

	public Boolean getActivarid_empleadoEmpleadoProcesoRubro() {
		return this.activarid_empleadoEmpleadoProcesoRubro;
	}

	public void setActivarid_empleadoEmpleadoProcesoRubro(Boolean activarid_empleadoEmpleadoProcesoRubro) {
		this.activarid_empleadoEmpleadoProcesoRubro= activarid_empleadoEmpleadoProcesoRubro;
	}

	public Boolean getCargarid_empleadoEmpleadoProcesoRubro() {
		return this.cargarid_empleadoEmpleadoProcesoRubro;
	}

	public void setCargarid_empleadoEmpleadoProcesoRubro(Boolean cargarid_empleadoEmpleadoProcesoRubro) {
		this.cargarid_empleadoEmpleadoProcesoRubro= cargarid_empleadoEmpleadoProcesoRubro;
	}

	public Border setResaltarfecha_ingresoEmpleadoProcesoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoProcesoRubroBeanSwingJInternalFrame empleadoprocesorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoprocesorubroBeanSwingJInternalFrame.jTtoolBarEmpleadoProcesoRubro.setBorder(borderResaltar);
		
		this.resaltarfecha_ingresoEmpleadoProcesoRubro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ingresoEmpleadoProcesoRubro() {
		return this.resaltarfecha_ingresoEmpleadoProcesoRubro;
	}

	public void setResaltarfecha_ingresoEmpleadoProcesoRubro(Border borderResaltar) {
		this.resaltarfecha_ingresoEmpleadoProcesoRubro= borderResaltar;
	}

	public Boolean getMostrarfecha_ingresoEmpleadoProcesoRubro() {
		return this.mostrarfecha_ingresoEmpleadoProcesoRubro;
	}

	public void setMostrarfecha_ingresoEmpleadoProcesoRubro(Boolean mostrarfecha_ingresoEmpleadoProcesoRubro) {
		this.mostrarfecha_ingresoEmpleadoProcesoRubro= mostrarfecha_ingresoEmpleadoProcesoRubro;
	}

	public Boolean getActivarfecha_ingresoEmpleadoProcesoRubro() {
		return this.activarfecha_ingresoEmpleadoProcesoRubro;
	}

	public void setActivarfecha_ingresoEmpleadoProcesoRubro(Boolean activarfecha_ingresoEmpleadoProcesoRubro) {
		this.activarfecha_ingresoEmpleadoProcesoRubro= activarfecha_ingresoEmpleadoProcesoRubro;
	}

	public Border setResaltarfecha_salidaEmpleadoProcesoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoProcesoRubroBeanSwingJInternalFrame empleadoprocesorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoprocesorubroBeanSwingJInternalFrame.jTtoolBarEmpleadoProcesoRubro.setBorder(borderResaltar);
		
		this.resaltarfecha_salidaEmpleadoProcesoRubro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_salidaEmpleadoProcesoRubro() {
		return this.resaltarfecha_salidaEmpleadoProcesoRubro;
	}

	public void setResaltarfecha_salidaEmpleadoProcesoRubro(Border borderResaltar) {
		this.resaltarfecha_salidaEmpleadoProcesoRubro= borderResaltar;
	}

	public Boolean getMostrarfecha_salidaEmpleadoProcesoRubro() {
		return this.mostrarfecha_salidaEmpleadoProcesoRubro;
	}

	public void setMostrarfecha_salidaEmpleadoProcesoRubro(Boolean mostrarfecha_salidaEmpleadoProcesoRubro) {
		this.mostrarfecha_salidaEmpleadoProcesoRubro= mostrarfecha_salidaEmpleadoProcesoRubro;
	}

	public Boolean getActivarfecha_salidaEmpleadoProcesoRubro() {
		return this.activarfecha_salidaEmpleadoProcesoRubro;
	}

	public void setActivarfecha_salidaEmpleadoProcesoRubro(Boolean activarfecha_salidaEmpleadoProcesoRubro) {
		this.activarfecha_salidaEmpleadoProcesoRubro= activarfecha_salidaEmpleadoProcesoRubro;
	}

	public Border setResaltarobservacionesEmpleadoProcesoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoProcesoRubroBeanSwingJInternalFrame empleadoprocesorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoprocesorubroBeanSwingJInternalFrame.jTtoolBarEmpleadoProcesoRubro.setBorder(borderResaltar);
		
		this.resaltarobservacionesEmpleadoProcesoRubro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarobservacionesEmpleadoProcesoRubro() {
		return this.resaltarobservacionesEmpleadoProcesoRubro;
	}

	public void setResaltarobservacionesEmpleadoProcesoRubro(Border borderResaltar) {
		this.resaltarobservacionesEmpleadoProcesoRubro= borderResaltar;
	}

	public Boolean getMostrarobservacionesEmpleadoProcesoRubro() {
		return this.mostrarobservacionesEmpleadoProcesoRubro;
	}

	public void setMostrarobservacionesEmpleadoProcesoRubro(Boolean mostrarobservacionesEmpleadoProcesoRubro) {
		this.mostrarobservacionesEmpleadoProcesoRubro= mostrarobservacionesEmpleadoProcesoRubro;
	}

	public Boolean getActivarobservacionesEmpleadoProcesoRubro() {
		return this.activarobservacionesEmpleadoProcesoRubro;
	}

	public void setActivarobservacionesEmpleadoProcesoRubro(Boolean activarobservacionesEmpleadoProcesoRubro) {
		this.activarobservacionesEmpleadoProcesoRubro= activarobservacionesEmpleadoProcesoRubro;
	}

	public Border setResaltarnumeros_reingresoEmpleadoProcesoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoProcesoRubroBeanSwingJInternalFrame empleadoprocesorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoprocesorubroBeanSwingJInternalFrame.jTtoolBarEmpleadoProcesoRubro.setBorder(borderResaltar);
		
		this.resaltarnumeros_reingresoEmpleadoProcesoRubro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeros_reingresoEmpleadoProcesoRubro() {
		return this.resaltarnumeros_reingresoEmpleadoProcesoRubro;
	}

	public void setResaltarnumeros_reingresoEmpleadoProcesoRubro(Border borderResaltar) {
		this.resaltarnumeros_reingresoEmpleadoProcesoRubro= borderResaltar;
	}

	public Boolean getMostrarnumeros_reingresoEmpleadoProcesoRubro() {
		return this.mostrarnumeros_reingresoEmpleadoProcesoRubro;
	}

	public void setMostrarnumeros_reingresoEmpleadoProcesoRubro(Boolean mostrarnumeros_reingresoEmpleadoProcesoRubro) {
		this.mostrarnumeros_reingresoEmpleadoProcesoRubro= mostrarnumeros_reingresoEmpleadoProcesoRubro;
	}

	public Boolean getActivarnumeros_reingresoEmpleadoProcesoRubro() {
		return this.activarnumeros_reingresoEmpleadoProcesoRubro;
	}

	public void setActivarnumeros_reingresoEmpleadoProcesoRubro(Boolean activarnumeros_reingresoEmpleadoProcesoRubro) {
		this.activarnumeros_reingresoEmpleadoProcesoRubro= activarnumeros_reingresoEmpleadoProcesoRubro;
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
		
		
		this.setMostraridEmpleadoProcesoRubro(esInicial);
		this.setMostrarid_empresaEmpleadoProcesoRubro(esInicial);
		this.setMostrarid_sucursalEmpleadoProcesoRubro(esInicial);
		this.setMostrarid_estructuraEmpleadoProcesoRubro(esInicial);
		this.setMostrarid_empleadoEmpleadoProcesoRubro(esInicial);
		this.setMostrarfecha_ingresoEmpleadoProcesoRubro(esInicial);
		this.setMostrarfecha_salidaEmpleadoProcesoRubro(esInicial);
		this.setMostrarobservacionesEmpleadoProcesoRubro(esInicial);
		this.setMostrarnumeros_reingresoEmpleadoProcesoRubro(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoProcesoRubroConstantesFunciones.ID)) {
				this.setMostraridEmpleadoProcesoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoProcesoRubroConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEmpleadoProcesoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoProcesoRubroConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalEmpleadoProcesoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoProcesoRubroConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraEmpleadoProcesoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoProcesoRubroConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoEmpleadoProcesoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoProcesoRubroConstantesFunciones.FECHAINGRESO)) {
				this.setMostrarfecha_ingresoEmpleadoProcesoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoProcesoRubroConstantesFunciones.FECHASALIDA)) {
				this.setMostrarfecha_salidaEmpleadoProcesoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoProcesoRubroConstantesFunciones.OBSERVACIONES)) {
				this.setMostrarobservacionesEmpleadoProcesoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoProcesoRubroConstantesFunciones.NUMEROSREINGRESO)) {
				this.setMostrarnumeros_reingresoEmpleadoProcesoRubro(esAsigna);
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
		
		
		this.setActivaridEmpleadoProcesoRubro(esInicial);
		this.setActivarid_empresaEmpleadoProcesoRubro(esInicial);
		this.setActivarid_sucursalEmpleadoProcesoRubro(esInicial);
		this.setActivarid_estructuraEmpleadoProcesoRubro(esInicial);
		this.setActivarid_empleadoEmpleadoProcesoRubro(esInicial);
		this.setActivarfecha_ingresoEmpleadoProcesoRubro(esInicial);
		this.setActivarfecha_salidaEmpleadoProcesoRubro(esInicial);
		this.setActivarobservacionesEmpleadoProcesoRubro(esInicial);
		this.setActivarnumeros_reingresoEmpleadoProcesoRubro(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoProcesoRubroConstantesFunciones.ID)) {
				this.setActivaridEmpleadoProcesoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoProcesoRubroConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEmpleadoProcesoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoProcesoRubroConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalEmpleadoProcesoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoProcesoRubroConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraEmpleadoProcesoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoProcesoRubroConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoEmpleadoProcesoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoProcesoRubroConstantesFunciones.FECHAINGRESO)) {
				this.setActivarfecha_ingresoEmpleadoProcesoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoProcesoRubroConstantesFunciones.FECHASALIDA)) {
				this.setActivarfecha_salidaEmpleadoProcesoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoProcesoRubroConstantesFunciones.OBSERVACIONES)) {
				this.setActivarobservacionesEmpleadoProcesoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoProcesoRubroConstantesFunciones.NUMEROSREINGRESO)) {
				this.setActivarnumeros_reingresoEmpleadoProcesoRubro(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpleadoProcesoRubroBeanSwingJInternalFrame empleadoprocesorubroBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEmpleadoProcesoRubro(esInicial);
		this.setResaltarid_empresaEmpleadoProcesoRubro(esInicial);
		this.setResaltarid_sucursalEmpleadoProcesoRubro(esInicial);
		this.setResaltarid_estructuraEmpleadoProcesoRubro(esInicial);
		this.setResaltarid_empleadoEmpleadoProcesoRubro(esInicial);
		this.setResaltarfecha_ingresoEmpleadoProcesoRubro(esInicial);
		this.setResaltarfecha_salidaEmpleadoProcesoRubro(esInicial);
		this.setResaltarobservacionesEmpleadoProcesoRubro(esInicial);
		this.setResaltarnumeros_reingresoEmpleadoProcesoRubro(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoProcesoRubroConstantesFunciones.ID)) {
				this.setResaltaridEmpleadoProcesoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoProcesoRubroConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEmpleadoProcesoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoProcesoRubroConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalEmpleadoProcesoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoProcesoRubroConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraEmpleadoProcesoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoProcesoRubroConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoEmpleadoProcesoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoProcesoRubroConstantesFunciones.FECHAINGRESO)) {
				this.setResaltarfecha_ingresoEmpleadoProcesoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoProcesoRubroConstantesFunciones.FECHASALIDA)) {
				this.setResaltarfecha_salidaEmpleadoProcesoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoProcesoRubroConstantesFunciones.OBSERVACIONES)) {
				this.setResaltarobservacionesEmpleadoProcesoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoProcesoRubroConstantesFunciones.NUMEROSREINGRESO)) {
				this.setResaltarnumeros_reingresoEmpleadoProcesoRubro(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpleadoProcesoRubroBeanSwingJInternalFrame empleadoprocesorubroBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpleadoEmpleadoProcesoRubro=true;

	public Boolean getMostrarFK_IdEmpleadoEmpleadoProcesoRubro() {
		return this.mostrarFK_IdEmpleadoEmpleadoProcesoRubro;
	}

	public void setMostrarFK_IdEmpleadoEmpleadoProcesoRubro(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoEmpleadoProcesoRubro= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaEmpleadoProcesoRubro=true;

	public Boolean getMostrarFK_IdEmpresaEmpleadoProcesoRubro() {
		return this.mostrarFK_IdEmpresaEmpleadoProcesoRubro;
	}

	public void setMostrarFK_IdEmpresaEmpleadoProcesoRubro(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaEmpleadoProcesoRubro= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstructuraEmpleadoProcesoRubro=true;

	public Boolean getMostrarFK_IdEstructuraEmpleadoProcesoRubro() {
		return this.mostrarFK_IdEstructuraEmpleadoProcesoRubro;
	}

	public void setMostrarFK_IdEstructuraEmpleadoProcesoRubro(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstructuraEmpleadoProcesoRubro= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalEmpleadoProcesoRubro=true;

	public Boolean getMostrarFK_IdSucursalEmpleadoProcesoRubro() {
		return this.mostrarFK_IdSucursalEmpleadoProcesoRubro;
	}

	public void setMostrarFK_IdSucursalEmpleadoProcesoRubro(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalEmpleadoProcesoRubro= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoEmpleadoProcesoRubro=true;

	public Boolean getActivarFK_IdEmpleadoEmpleadoProcesoRubro() {
		return this.activarFK_IdEmpleadoEmpleadoProcesoRubro;
	}

	public void setActivarFK_IdEmpleadoEmpleadoProcesoRubro(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoEmpleadoProcesoRubro= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaEmpleadoProcesoRubro=true;

	public Boolean getActivarFK_IdEmpresaEmpleadoProcesoRubro() {
		return this.activarFK_IdEmpresaEmpleadoProcesoRubro;
	}

	public void setActivarFK_IdEmpresaEmpleadoProcesoRubro(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaEmpleadoProcesoRubro= habilitarResaltar;
	}

	public Boolean activarFK_IdEstructuraEmpleadoProcesoRubro=true;

	public Boolean getActivarFK_IdEstructuraEmpleadoProcesoRubro() {
		return this.activarFK_IdEstructuraEmpleadoProcesoRubro;
	}

	public void setActivarFK_IdEstructuraEmpleadoProcesoRubro(Boolean habilitarResaltar) {
		this.activarFK_IdEstructuraEmpleadoProcesoRubro= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalEmpleadoProcesoRubro=true;

	public Boolean getActivarFK_IdSucursalEmpleadoProcesoRubro() {
		return this.activarFK_IdSucursalEmpleadoProcesoRubro;
	}

	public void setActivarFK_IdSucursalEmpleadoProcesoRubro(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalEmpleadoProcesoRubro= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoEmpleadoProcesoRubro=null;

	public Border getResaltarFK_IdEmpleadoEmpleadoProcesoRubro() {
		return this.resaltarFK_IdEmpleadoEmpleadoProcesoRubro;
	}

	public void setResaltarFK_IdEmpleadoEmpleadoProcesoRubro(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoEmpleadoProcesoRubro= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoEmpleadoProcesoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoProcesoRubroBeanSwingJInternalFrame empleadoprocesorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoEmpleadoProcesoRubro= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaEmpleadoProcesoRubro=null;

	public Border getResaltarFK_IdEmpresaEmpleadoProcesoRubro() {
		return this.resaltarFK_IdEmpresaEmpleadoProcesoRubro;
	}

	public void setResaltarFK_IdEmpresaEmpleadoProcesoRubro(Border borderResaltar) {
		this.resaltarFK_IdEmpresaEmpleadoProcesoRubro= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaEmpleadoProcesoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoProcesoRubroBeanSwingJInternalFrame empleadoprocesorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaEmpleadoProcesoRubro= borderResaltar;
	}

	public Border resaltarFK_IdEstructuraEmpleadoProcesoRubro=null;

	public Border getResaltarFK_IdEstructuraEmpleadoProcesoRubro() {
		return this.resaltarFK_IdEstructuraEmpleadoProcesoRubro;
	}

	public void setResaltarFK_IdEstructuraEmpleadoProcesoRubro(Border borderResaltar) {
		this.resaltarFK_IdEstructuraEmpleadoProcesoRubro= borderResaltar;
	}

	public void setResaltarFK_IdEstructuraEmpleadoProcesoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoProcesoRubroBeanSwingJInternalFrame empleadoprocesorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstructuraEmpleadoProcesoRubro= borderResaltar;
	}

	public Border resaltarFK_IdSucursalEmpleadoProcesoRubro=null;

	public Border getResaltarFK_IdSucursalEmpleadoProcesoRubro() {
		return this.resaltarFK_IdSucursalEmpleadoProcesoRubro;
	}

	public void setResaltarFK_IdSucursalEmpleadoProcesoRubro(Border borderResaltar) {
		this.resaltarFK_IdSucursalEmpleadoProcesoRubro= borderResaltar;
	}

	public void setResaltarFK_IdSucursalEmpleadoProcesoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoProcesoRubroBeanSwingJInternalFrame empleadoprocesorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalEmpleadoProcesoRubro= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}