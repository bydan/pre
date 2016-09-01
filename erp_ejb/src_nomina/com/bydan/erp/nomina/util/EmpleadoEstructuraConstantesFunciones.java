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


import com.bydan.erp.nomina.util.EmpleadoEstructuraConstantesFunciones;
import com.bydan.erp.nomina.util.EmpleadoEstructuraParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EmpleadoEstructuraParameterGeneral;

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
final public class EmpleadoEstructuraConstantesFunciones extends EmpleadoEstructuraConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EmpleadoEstructura";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EmpleadoEstructura"+EmpleadoEstructuraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EmpleadoEstructuraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EmpleadoEstructuraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EmpleadoEstructuraConstantesFunciones.SCHEMA+"_"+EmpleadoEstructuraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EmpleadoEstructuraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EmpleadoEstructuraConstantesFunciones.SCHEMA+"_"+EmpleadoEstructuraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EmpleadoEstructuraConstantesFunciones.SCHEMA+"_"+EmpleadoEstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EmpleadoEstructuraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EmpleadoEstructuraConstantesFunciones.SCHEMA+"_"+EmpleadoEstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoEstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpleadoEstructuraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoEstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoEstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpleadoEstructuraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoEstructuraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EmpleadoEstructuraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EmpleadoEstructuraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EmpleadoEstructuraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EmpleadoEstructuraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Empleado Estructuras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Empleado Estructura";
	public static final String SCLASSWEBTITULO_LOWER="Empleado Estructura";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EmpleadoEstructura";
	public static final String OBJECTNAME="empleadoestructura";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="empleado_estructura";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select empleadoestructura from "+EmpleadoEstructuraConstantesFunciones.SPERSISTENCENAME+" empleadoestructura";
	public static String QUERYSELECTNATIVE="select "+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME+".id,"+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME+".version_row,"+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME+".id_empresa,"+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME+".id_sucursal,"+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME+".id_empleado,"+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME+".id_estructura,"+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME+".id_cargo,"+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME+".fecha_ingreso,"+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME+".fecha_salida,"+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME+".numero_reingreso,"+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME+".descripcion from "+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME;//+" as "+EmpleadoEstructuraConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EmpleadoEstructuraConstantesFuncionesAdditional empleadoestructuraConstantesFuncionesAdditional=null;
	
	public EmpleadoEstructuraConstantesFuncionesAdditional getEmpleadoEstructuraConstantesFuncionesAdditional() {
		return this.empleadoestructuraConstantesFuncionesAdditional;
	}
	
	public void setEmpleadoEstructuraConstantesFuncionesAdditional(EmpleadoEstructuraConstantesFuncionesAdditional empleadoestructuraConstantesFuncionesAdditional) {
		try {
			this.empleadoestructuraConstantesFuncionesAdditional=empleadoestructuraConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDESTRUCTURA= "id_estructura";
    public static final String IDCARGO= "id_cargo";
    public static final String FECHAINGRESO= "fecha_ingreso";
    public static final String FECHASALIDA= "fecha_salida";
    public static final String NUMEROREINGRESO= "numero_reingreso";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDESTRUCTURA= "Estructura";
		public static final String LABEL_IDESTRUCTURA_LOWER= "Estructura";
    	public static final String LABEL_IDCARGO= "A";
		public static final String LABEL_IDCARGO_LOWER= "Cargo";
    	public static final String LABEL_FECHAINGRESO= "Fecha Ingreso";
		public static final String LABEL_FECHAINGRESO_LOWER= "Fecha Ingreso";
    	public static final String LABEL_FECHASALIDA= "Fecha Salida";
		public static final String LABEL_FECHASALIDA_LOWER= "Fecha Salida";
    	public static final String LABEL_NUMEROREINGRESO= "Numero Reingreso";
		public static final String LABEL_NUMEROREINGRESO_LOWER= "Numero Reingreso";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getEmpleadoEstructuraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EmpleadoEstructuraConstantesFunciones.IDEMPRESA)) {sLabelColumna=EmpleadoEstructuraConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EmpleadoEstructuraConstantesFunciones.IDSUCURSAL)) {sLabelColumna=EmpleadoEstructuraConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(EmpleadoEstructuraConstantesFunciones.IDEMPLEADO)) {sLabelColumna=EmpleadoEstructuraConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(EmpleadoEstructuraConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=EmpleadoEstructuraConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(EmpleadoEstructuraConstantesFunciones.IDCARGO)) {sLabelColumna=EmpleadoEstructuraConstantesFunciones.LABEL_IDCARGO;}
		if(sNombreColumna.equals(EmpleadoEstructuraConstantesFunciones.FECHAINGRESO)) {sLabelColumna=EmpleadoEstructuraConstantesFunciones.LABEL_FECHAINGRESO;}
		if(sNombreColumna.equals(EmpleadoEstructuraConstantesFunciones.FECHASALIDA)) {sLabelColumna=EmpleadoEstructuraConstantesFunciones.LABEL_FECHASALIDA;}
		if(sNombreColumna.equals(EmpleadoEstructuraConstantesFunciones.NUMEROREINGRESO)) {sLabelColumna=EmpleadoEstructuraConstantesFunciones.LABEL_NUMEROREINGRESO;}
		if(sNombreColumna.equals(EmpleadoEstructuraConstantesFunciones.DESCRIPCION)) {sLabelColumna=EmpleadoEstructuraConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getEmpleadoEstructuraDescripcion(EmpleadoEstructura empleadoestructura) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(empleadoestructura !=null/* && empleadoestructura.getId()!=0*/) {
			if(empleadoestructura.getId()!=null) {
				sDescripcion=empleadoestructura.getId().toString();
			}//empleadoestructuraempleadoestructura.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getEmpleadoEstructuraDescripcionDetallado(EmpleadoEstructura empleadoestructura) {
		String sDescripcion="";
			
		sDescripcion+=EmpleadoEstructuraConstantesFunciones.ID+"=";
		sDescripcion+=empleadoestructura.getId().toString()+",";
		sDescripcion+=EmpleadoEstructuraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=empleadoestructura.getVersionRow().toString()+",";
		sDescripcion+=EmpleadoEstructuraConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=empleadoestructura.getid_empresa().toString()+",";
		sDescripcion+=EmpleadoEstructuraConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=empleadoestructura.getid_sucursal().toString()+",";
		sDescripcion+=EmpleadoEstructuraConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=empleadoestructura.getid_empleado().toString()+",";
		sDescripcion+=EmpleadoEstructuraConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=empleadoestructura.getid_estructura().toString()+",";
		sDescripcion+=EmpleadoEstructuraConstantesFunciones.IDCARGO+"=";
		sDescripcion+=empleadoestructura.getid_cargo().toString()+",";
		sDescripcion+=EmpleadoEstructuraConstantesFunciones.FECHAINGRESO+"=";
		sDescripcion+=empleadoestructura.getfecha_ingreso().toString()+",";
		sDescripcion+=EmpleadoEstructuraConstantesFunciones.FECHASALIDA+"=";
		sDescripcion+=empleadoestructura.getfecha_salida().toString()+",";
		sDescripcion+=EmpleadoEstructuraConstantesFunciones.NUMEROREINGRESO+"=";
		sDescripcion+=empleadoestructura.getnumero_reingreso().toString()+",";
		sDescripcion+=EmpleadoEstructuraConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=empleadoestructura.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setEmpleadoEstructuraDescripcion(EmpleadoEstructura empleadoestructura,String sValor) throws Exception {			
		if(empleadoestructura !=null) {
			//empleadoestructuraempleadoestructura.getId().toString();
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

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
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

	public static String getCargoDescripcion(Cargo cargo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cargo!=null/*&&cargo.getId()>0*/) {
			sDescripcion=CargoConstantesFunciones.getCargoDescripcion(cargo);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCargo")) {
			sNombreIndice="Tipo=  Por A";
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

	public static String getDetalleIndiceFK_IdCargo(Long id_cargo) {
		String sDetalleIndice=" Parametros->";
		if(id_cargo!=null) {sDetalleIndice+=" Codigo Unico De A="+id_cargo.toString();} 

		return sDetalleIndice;
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
	
	
	
	
	
	
	public static void quitarEspaciosEmpleadoEstructura(EmpleadoEstructura empleadoestructura,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		empleadoestructura.setdescripcion(empleadoestructura.getdescripcion().trim());
	}
	
	public static void quitarEspaciosEmpleadoEstructuras(List<EmpleadoEstructura> empleadoestructuras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EmpleadoEstructura empleadoestructura: empleadoestructuras) {
			empleadoestructura.setdescripcion(empleadoestructura.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpleadoEstructura(EmpleadoEstructura empleadoestructura,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && empleadoestructura.getConCambioAuxiliar()) {
			empleadoestructura.setIsDeleted(empleadoestructura.getIsDeletedAuxiliar());	
			empleadoestructura.setIsNew(empleadoestructura.getIsNewAuxiliar());	
			empleadoestructura.setIsChanged(empleadoestructura.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			empleadoestructura.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			empleadoestructura.setIsDeletedAuxiliar(false);	
			empleadoestructura.setIsNewAuxiliar(false);	
			empleadoestructura.setIsChangedAuxiliar(false);
			
			empleadoestructura.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpleadoEstructuras(List<EmpleadoEstructura> empleadoestructuras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EmpleadoEstructura empleadoestructura : empleadoestructuras) {
			if(conAsignarBase && empleadoestructura.getConCambioAuxiliar()) {
				empleadoestructura.setIsDeleted(empleadoestructura.getIsDeletedAuxiliar());	
				empleadoestructura.setIsNew(empleadoestructura.getIsNewAuxiliar());	
				empleadoestructura.setIsChanged(empleadoestructura.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				empleadoestructura.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				empleadoestructura.setIsDeletedAuxiliar(false);	
				empleadoestructura.setIsNewAuxiliar(false);	
				empleadoestructura.setIsChangedAuxiliar(false);
				
				empleadoestructura.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEmpleadoEstructura(EmpleadoEstructura empleadoestructura,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			empleadoestructura.setnumero_reingreso(0);
		}
	}		
	
	public static void InicializarValoresEmpleadoEstructuras(List<EmpleadoEstructura> empleadoestructuras,Boolean conEnteros) throws Exception  {
		
		for(EmpleadoEstructura empleadoestructura: empleadoestructuras) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				empleadoestructura.setnumero_reingreso(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaEmpleadoEstructura(List<EmpleadoEstructura> empleadoestructuras,EmpleadoEstructura empleadoestructuraAux) throws Exception  {
		EmpleadoEstructuraConstantesFunciones.InicializarValoresEmpleadoEstructura(empleadoestructuraAux,true);
		
		for(EmpleadoEstructura empleadoestructura: empleadoestructuras) {
			if(empleadoestructura.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			empleadoestructuraAux.setnumero_reingreso(empleadoestructuraAux.getnumero_reingreso()+empleadoestructura.getnumero_reingreso());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpleadoEstructura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EmpleadoEstructuraConstantesFunciones.getArrayColumnasGlobalesEmpleadoEstructura(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpleadoEstructura(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EmpleadoEstructuraConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EmpleadoEstructuraConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EmpleadoEstructuraConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EmpleadoEstructuraConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEmpleadoEstructura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EmpleadoEstructura> empleadoestructuras,EmpleadoEstructura empleadoestructura,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EmpleadoEstructura empleadoestructuraAux: empleadoestructuras) {
			if(empleadoestructuraAux!=null && empleadoestructura!=null) {
				if((empleadoestructuraAux.getId()==null && empleadoestructura.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(empleadoestructuraAux.getId()!=null && empleadoestructura.getId()!=null){
					if(empleadoestructuraAux.getId().equals(empleadoestructura.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEmpleadoEstructura(List<EmpleadoEstructura> empleadoestructuras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EmpleadoEstructura empleadoestructura: empleadoestructuras) {			
			if(empleadoestructura.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEmpleadoEstructura() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EmpleadoEstructuraConstantesFunciones.LABEL_ID, EmpleadoEstructuraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoEstructuraConstantesFunciones.LABEL_VERSIONROW, EmpleadoEstructuraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoEstructuraConstantesFunciones.LABEL_IDEMPRESA, EmpleadoEstructuraConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoEstructuraConstantesFunciones.LABEL_IDSUCURSAL, EmpleadoEstructuraConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoEstructuraConstantesFunciones.LABEL_IDEMPLEADO, EmpleadoEstructuraConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoEstructuraConstantesFunciones.LABEL_IDESTRUCTURA, EmpleadoEstructuraConstantesFunciones.IDESTRUCTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoEstructuraConstantesFunciones.LABEL_IDCARGO, EmpleadoEstructuraConstantesFunciones.IDCARGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoEstructuraConstantesFunciones.LABEL_FECHAINGRESO, EmpleadoEstructuraConstantesFunciones.FECHAINGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoEstructuraConstantesFunciones.LABEL_FECHASALIDA, EmpleadoEstructuraConstantesFunciones.FECHASALIDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoEstructuraConstantesFunciones.LABEL_NUMEROREINGRESO, EmpleadoEstructuraConstantesFunciones.NUMEROREINGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoEstructuraConstantesFunciones.LABEL_DESCRIPCION, EmpleadoEstructuraConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEmpleadoEstructura() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EmpleadoEstructuraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoEstructuraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoEstructuraConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoEstructuraConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoEstructuraConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoEstructuraConstantesFunciones.IDESTRUCTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoEstructuraConstantesFunciones.IDCARGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoEstructuraConstantesFunciones.FECHAINGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoEstructuraConstantesFunciones.FECHASALIDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoEstructuraConstantesFunciones.NUMEROREINGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoEstructuraConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoEstructura() throws Exception  {
		return EmpleadoEstructuraConstantesFunciones.getTiposSeleccionarEmpleadoEstructura(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoEstructura(Boolean conFk) throws Exception  {
		return EmpleadoEstructuraConstantesFunciones.getTiposSeleccionarEmpleadoEstructura(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoEstructura(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoEstructuraConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EmpleadoEstructuraConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoEstructuraConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(EmpleadoEstructuraConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoEstructuraConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(EmpleadoEstructuraConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoEstructuraConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(EmpleadoEstructuraConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoEstructuraConstantesFunciones.LABEL_IDCARGO);
			reporte.setsDescripcion(EmpleadoEstructuraConstantesFunciones.LABEL_IDCARGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoEstructuraConstantesFunciones.LABEL_FECHAINGRESO);
			reporte.setsDescripcion(EmpleadoEstructuraConstantesFunciones.LABEL_FECHAINGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoEstructuraConstantesFunciones.LABEL_FECHASALIDA);
			reporte.setsDescripcion(EmpleadoEstructuraConstantesFunciones.LABEL_FECHASALIDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoEstructuraConstantesFunciones.LABEL_NUMEROREINGRESO);
			reporte.setsDescripcion(EmpleadoEstructuraConstantesFunciones.LABEL_NUMEROREINGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoEstructuraConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(EmpleadoEstructuraConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEmpleadoEstructura(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEmpleadoEstructura(EmpleadoEstructura empleadoestructuraAux) throws Exception {
		
			empleadoestructuraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(empleadoestructuraAux.getEmpresa()));
			empleadoestructuraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(empleadoestructuraAux.getSucursal()));
			empleadoestructuraAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleadoestructuraAux.getEmpleado()));
			empleadoestructuraAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(empleadoestructuraAux.getEstructura()));
			empleadoestructuraAux.setcargo_descripcion(CargoConstantesFunciones.getCargoDescripcion(empleadoestructuraAux.getCargo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEmpleadoEstructura(List<EmpleadoEstructura> empleadoestructurasTemp) throws Exception {
		for(EmpleadoEstructura empleadoestructuraAux:empleadoestructurasTemp) {
			
			empleadoestructuraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(empleadoestructuraAux.getEmpresa()));
			empleadoestructuraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(empleadoestructuraAux.getSucursal()));
			empleadoestructuraAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleadoestructuraAux.getEmpleado()));
			empleadoestructuraAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(empleadoestructuraAux.getEstructura()));
			empleadoestructuraAux.setcargo_descripcion(CargoConstantesFunciones.getCargoDescripcion(empleadoestructuraAux.getCargo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEmpleadoEstructura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(Cargo.class));
				
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
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cargo.class)) {
						classes.add(new Classe(Cargo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEmpleadoEstructura(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Cargo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cargo.class)); continue;
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

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Cargo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cargo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoEstructura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpleadoEstructuraConstantesFunciones.getClassesRelationshipsOfEmpleadoEstructura(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoEstructura(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpleadoEstructura(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpleadoEstructuraConstantesFunciones.getClassesRelationshipsFromStringsOfEmpleadoEstructura(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpleadoEstructura(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(EmpleadoEstructura empleadoestructura,List<EmpleadoEstructura> empleadoestructuras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EmpleadoEstructura empleadoestructuraEncontrado=null;
			
			for(EmpleadoEstructura empleadoestructuraLocal:empleadoestructuras) {
				if(empleadoestructuraLocal.getId().equals(empleadoestructura.getId())) {
					empleadoestructuraEncontrado=empleadoestructuraLocal;
					
					empleadoestructuraLocal.setIsChanged(empleadoestructura.getIsChanged());
					empleadoestructuraLocal.setIsNew(empleadoestructura.getIsNew());
					empleadoestructuraLocal.setIsDeleted(empleadoestructura.getIsDeleted());
					
					empleadoestructuraLocal.setGeneralEntityOriginal(empleadoestructura.getGeneralEntityOriginal());
					
					empleadoestructuraLocal.setId(empleadoestructura.getId());	
					empleadoestructuraLocal.setVersionRow(empleadoestructura.getVersionRow());	
					empleadoestructuraLocal.setid_empresa(empleadoestructura.getid_empresa());	
					empleadoestructuraLocal.setid_sucursal(empleadoestructura.getid_sucursal());	
					empleadoestructuraLocal.setid_empleado(empleadoestructura.getid_empleado());	
					empleadoestructuraLocal.setid_estructura(empleadoestructura.getid_estructura());	
					empleadoestructuraLocal.setid_cargo(empleadoestructura.getid_cargo());	
					empleadoestructuraLocal.setfecha_ingreso(empleadoestructura.getfecha_ingreso());	
					empleadoestructuraLocal.setfecha_salida(empleadoestructura.getfecha_salida());	
					empleadoestructuraLocal.setnumero_reingreso(empleadoestructura.getnumero_reingreso());	
					empleadoestructuraLocal.setdescripcion(empleadoestructura.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!empleadoestructura.getIsDeleted()) {
				if(!existe) {
					empleadoestructuras.add(empleadoestructura);
				}
			} else {
				if(empleadoestructuraEncontrado!=null && permiteQuitar)  {
					empleadoestructuras.remove(empleadoestructuraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EmpleadoEstructura empleadoestructura,List<EmpleadoEstructura> empleadoestructuras) throws Exception {
		try	{			
			for(EmpleadoEstructura empleadoestructuraLocal:empleadoestructuras) {
				if(empleadoestructuraLocal.getId().equals(empleadoestructura.getId())) {
					empleadoestructuraLocal.setIsSelected(empleadoestructura.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEmpleadoEstructura(List<EmpleadoEstructura> empleadoestructurasAux) throws Exception {
		//this.empleadoestructurasAux=empleadoestructurasAux;
		
		for(EmpleadoEstructura empleadoestructuraAux:empleadoestructurasAux) {
			if(empleadoestructuraAux.getIsChanged()) {
				empleadoestructuraAux.setIsChanged(false);
			}		
			
			if(empleadoestructuraAux.getIsNew()) {
				empleadoestructuraAux.setIsNew(false);
			}	
			
			if(empleadoestructuraAux.getIsDeleted()) {
				empleadoestructuraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEmpleadoEstructura(EmpleadoEstructura empleadoestructuraAux) throws Exception {
		//this.empleadoestructuraAux=empleadoestructuraAux;
		
			if(empleadoestructuraAux.getIsChanged()) {
				empleadoestructuraAux.setIsChanged(false);
			}		
			
			if(empleadoestructuraAux.getIsNew()) {
				empleadoestructuraAux.setIsNew(false);
			}	
			
			if(empleadoestructuraAux.getIsDeleted()) {
				empleadoestructuraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EmpleadoEstructura empleadoestructuraAsignar,EmpleadoEstructura empleadoestructura) throws Exception {
		empleadoestructuraAsignar.setId(empleadoestructura.getId());	
		empleadoestructuraAsignar.setVersionRow(empleadoestructura.getVersionRow());	
		empleadoestructuraAsignar.setid_empresa(empleadoestructura.getid_empresa());
		empleadoestructuraAsignar.setempresa_descripcion(empleadoestructura.getempresa_descripcion());	
		empleadoestructuraAsignar.setid_sucursal(empleadoestructura.getid_sucursal());
		empleadoestructuraAsignar.setsucursal_descripcion(empleadoestructura.getsucursal_descripcion());	
		empleadoestructuraAsignar.setid_empleado(empleadoestructura.getid_empleado());
		empleadoestructuraAsignar.setempleado_descripcion(empleadoestructura.getempleado_descripcion());	
		empleadoestructuraAsignar.setid_estructura(empleadoestructura.getid_estructura());
		empleadoestructuraAsignar.setestructura_descripcion(empleadoestructura.getestructura_descripcion());	
		empleadoestructuraAsignar.setid_cargo(empleadoestructura.getid_cargo());
		empleadoestructuraAsignar.setcargo_descripcion(empleadoestructura.getcargo_descripcion());	
		empleadoestructuraAsignar.setfecha_ingreso(empleadoestructura.getfecha_ingreso());	
		empleadoestructuraAsignar.setfecha_salida(empleadoestructura.getfecha_salida());	
		empleadoestructuraAsignar.setnumero_reingreso(empleadoestructura.getnumero_reingreso());	
		empleadoestructuraAsignar.setdescripcion(empleadoestructura.getdescripcion());	
	}
	
	public static void inicializarEmpleadoEstructura(EmpleadoEstructura empleadoestructura) throws Exception {
		try {
				empleadoestructura.setId(0L);	
					
				empleadoestructura.setid_empresa(-1L);	
				empleadoestructura.setid_sucursal(-1L);	
				empleadoestructura.setid_empleado(-1L);	
				empleadoestructura.setid_estructura(-1L);	
				empleadoestructura.setid_cargo(-1L);	
				empleadoestructura.setfecha_ingreso(new Date());	
				empleadoestructura.setfecha_salida(new Date());	
				empleadoestructura.setnumero_reingreso(0);	
				empleadoestructura.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEmpleadoEstructura(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoEstructuraConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoEstructuraConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoEstructuraConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoEstructuraConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoEstructuraConstantesFunciones.LABEL_IDCARGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoEstructuraConstantesFunciones.LABEL_FECHAINGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoEstructuraConstantesFunciones.LABEL_FECHASALIDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoEstructuraConstantesFunciones.LABEL_NUMEROREINGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoEstructuraConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEmpleadoEstructura(String sTipo,Row row,Workbook workbook,EmpleadoEstructura empleadoestructura,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoestructura.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoestructura.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoestructura.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoestructura.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoestructura.getcargo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoestructura.getfecha_ingreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoestructura.getfecha_salida());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoestructura.getnumero_reingreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoestructura.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEmpleadoEstructura=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEmpleadoEstructura() {
		return this.sFinalQueryEmpleadoEstructura;
	}
	
	public void setsFinalQueryEmpleadoEstructura(String sFinalQueryEmpleadoEstructura) {
		this.sFinalQueryEmpleadoEstructura= sFinalQueryEmpleadoEstructura;
	}
	
	public Border resaltarSeleccionarEmpleadoEstructura=null;
	
	public Border setResaltarSeleccionarEmpleadoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEstructuraBeanSwingJInternalFrame empleadoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//empleadoestructuraBeanSwingJInternalFrame.jTtoolBarEmpleadoEstructura.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEmpleadoEstructura= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEmpleadoEstructura() {
		return this.resaltarSeleccionarEmpleadoEstructura;
	}
	
	public void setResaltarSeleccionarEmpleadoEstructura(Border borderResaltarSeleccionarEmpleadoEstructura) {
		this.resaltarSeleccionarEmpleadoEstructura= borderResaltarSeleccionarEmpleadoEstructura;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEmpleadoEstructura=null;
	public Boolean mostraridEmpleadoEstructura=true;
	public Boolean activaridEmpleadoEstructura=true;

	public Border resaltarid_empresaEmpleadoEstructura=null;
	public Boolean mostrarid_empresaEmpleadoEstructura=true;
	public Boolean activarid_empresaEmpleadoEstructura=true;
	public Boolean cargarid_empresaEmpleadoEstructura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEmpleadoEstructura=false;//ConEventDepend=true

	public Border resaltarid_sucursalEmpleadoEstructura=null;
	public Boolean mostrarid_sucursalEmpleadoEstructura=true;
	public Boolean activarid_sucursalEmpleadoEstructura=true;
	public Boolean cargarid_sucursalEmpleadoEstructura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalEmpleadoEstructura=false;//ConEventDepend=true

	public Border resaltarid_empleadoEmpleadoEstructura=null;
	public Boolean mostrarid_empleadoEmpleadoEstructura=true;
	public Boolean activarid_empleadoEmpleadoEstructura=true;
	public Boolean cargarid_empleadoEmpleadoEstructura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoEmpleadoEstructura=false;//ConEventDepend=true

	public Border resaltarid_estructuraEmpleadoEstructura=null;
	public Boolean mostrarid_estructuraEmpleadoEstructura=true;
	public Boolean activarid_estructuraEmpleadoEstructura=true;
	public Boolean cargarid_estructuraEmpleadoEstructura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraEmpleadoEstructura=false;//ConEventDepend=true

	public Border resaltarid_cargoEmpleadoEstructura=null;
	public Boolean mostrarid_cargoEmpleadoEstructura=true;
	public Boolean activarid_cargoEmpleadoEstructura=true;
	public Boolean cargarid_cargoEmpleadoEstructura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cargoEmpleadoEstructura=false;//ConEventDepend=true

	public Border resaltarfecha_ingresoEmpleadoEstructura=null;
	public Boolean mostrarfecha_ingresoEmpleadoEstructura=true;
	public Boolean activarfecha_ingresoEmpleadoEstructura=false;

	public Border resaltarfecha_salidaEmpleadoEstructura=null;
	public Boolean mostrarfecha_salidaEmpleadoEstructura=true;
	public Boolean activarfecha_salidaEmpleadoEstructura=false;

	public Border resaltarnumero_reingresoEmpleadoEstructura=null;
	public Boolean mostrarnumero_reingresoEmpleadoEstructura=true;
	public Boolean activarnumero_reingresoEmpleadoEstructura=true;

	public Border resaltardescripcionEmpleadoEstructura=null;
	public Boolean mostrardescripcionEmpleadoEstructura=true;
	public Boolean activardescripcionEmpleadoEstructura=true;

	
	

	public Border setResaltaridEmpleadoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEstructuraBeanSwingJInternalFrame empleadoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoestructuraBeanSwingJInternalFrame.jTtoolBarEmpleadoEstructura.setBorder(borderResaltar);
		
		this.resaltaridEmpleadoEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEmpleadoEstructura() {
		return this.resaltaridEmpleadoEstructura;
	}

	public void setResaltaridEmpleadoEstructura(Border borderResaltar) {
		this.resaltaridEmpleadoEstructura= borderResaltar;
	}

	public Boolean getMostraridEmpleadoEstructura() {
		return this.mostraridEmpleadoEstructura;
	}

	public void setMostraridEmpleadoEstructura(Boolean mostraridEmpleadoEstructura) {
		this.mostraridEmpleadoEstructura= mostraridEmpleadoEstructura;
	}

	public Boolean getActivaridEmpleadoEstructura() {
		return this.activaridEmpleadoEstructura;
	}

	public void setActivaridEmpleadoEstructura(Boolean activaridEmpleadoEstructura) {
		this.activaridEmpleadoEstructura= activaridEmpleadoEstructura;
	}

	public Border setResaltarid_empresaEmpleadoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEstructuraBeanSwingJInternalFrame empleadoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoestructuraBeanSwingJInternalFrame.jTtoolBarEmpleadoEstructura.setBorder(borderResaltar);
		
		this.resaltarid_empresaEmpleadoEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEmpleadoEstructura() {
		return this.resaltarid_empresaEmpleadoEstructura;
	}

	public void setResaltarid_empresaEmpleadoEstructura(Border borderResaltar) {
		this.resaltarid_empresaEmpleadoEstructura= borderResaltar;
	}

	public Boolean getMostrarid_empresaEmpleadoEstructura() {
		return this.mostrarid_empresaEmpleadoEstructura;
	}

	public void setMostrarid_empresaEmpleadoEstructura(Boolean mostrarid_empresaEmpleadoEstructura) {
		this.mostrarid_empresaEmpleadoEstructura= mostrarid_empresaEmpleadoEstructura;
	}

	public Boolean getActivarid_empresaEmpleadoEstructura() {
		return this.activarid_empresaEmpleadoEstructura;
	}

	public void setActivarid_empresaEmpleadoEstructura(Boolean activarid_empresaEmpleadoEstructura) {
		this.activarid_empresaEmpleadoEstructura= activarid_empresaEmpleadoEstructura;
	}

	public Boolean getCargarid_empresaEmpleadoEstructura() {
		return this.cargarid_empresaEmpleadoEstructura;
	}

	public void setCargarid_empresaEmpleadoEstructura(Boolean cargarid_empresaEmpleadoEstructura) {
		this.cargarid_empresaEmpleadoEstructura= cargarid_empresaEmpleadoEstructura;
	}

	public Border setResaltarid_sucursalEmpleadoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEstructuraBeanSwingJInternalFrame empleadoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoestructuraBeanSwingJInternalFrame.jTtoolBarEmpleadoEstructura.setBorder(borderResaltar);
		
		this.resaltarid_sucursalEmpleadoEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalEmpleadoEstructura() {
		return this.resaltarid_sucursalEmpleadoEstructura;
	}

	public void setResaltarid_sucursalEmpleadoEstructura(Border borderResaltar) {
		this.resaltarid_sucursalEmpleadoEstructura= borderResaltar;
	}

	public Boolean getMostrarid_sucursalEmpleadoEstructura() {
		return this.mostrarid_sucursalEmpleadoEstructura;
	}

	public void setMostrarid_sucursalEmpleadoEstructura(Boolean mostrarid_sucursalEmpleadoEstructura) {
		this.mostrarid_sucursalEmpleadoEstructura= mostrarid_sucursalEmpleadoEstructura;
	}

	public Boolean getActivarid_sucursalEmpleadoEstructura() {
		return this.activarid_sucursalEmpleadoEstructura;
	}

	public void setActivarid_sucursalEmpleadoEstructura(Boolean activarid_sucursalEmpleadoEstructura) {
		this.activarid_sucursalEmpleadoEstructura= activarid_sucursalEmpleadoEstructura;
	}

	public Boolean getCargarid_sucursalEmpleadoEstructura() {
		return this.cargarid_sucursalEmpleadoEstructura;
	}

	public void setCargarid_sucursalEmpleadoEstructura(Boolean cargarid_sucursalEmpleadoEstructura) {
		this.cargarid_sucursalEmpleadoEstructura= cargarid_sucursalEmpleadoEstructura;
	}

	public Border setResaltarid_empleadoEmpleadoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEstructuraBeanSwingJInternalFrame empleadoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoestructuraBeanSwingJInternalFrame.jTtoolBarEmpleadoEstructura.setBorder(borderResaltar);
		
		this.resaltarid_empleadoEmpleadoEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoEmpleadoEstructura() {
		return this.resaltarid_empleadoEmpleadoEstructura;
	}

	public void setResaltarid_empleadoEmpleadoEstructura(Border borderResaltar) {
		this.resaltarid_empleadoEmpleadoEstructura= borderResaltar;
	}

	public Boolean getMostrarid_empleadoEmpleadoEstructura() {
		return this.mostrarid_empleadoEmpleadoEstructura;
	}

	public void setMostrarid_empleadoEmpleadoEstructura(Boolean mostrarid_empleadoEmpleadoEstructura) {
		this.mostrarid_empleadoEmpleadoEstructura= mostrarid_empleadoEmpleadoEstructura;
	}

	public Boolean getActivarid_empleadoEmpleadoEstructura() {
		return this.activarid_empleadoEmpleadoEstructura;
	}

	public void setActivarid_empleadoEmpleadoEstructura(Boolean activarid_empleadoEmpleadoEstructura) {
		this.activarid_empleadoEmpleadoEstructura= activarid_empleadoEmpleadoEstructura;
	}

	public Boolean getCargarid_empleadoEmpleadoEstructura() {
		return this.cargarid_empleadoEmpleadoEstructura;
	}

	public void setCargarid_empleadoEmpleadoEstructura(Boolean cargarid_empleadoEmpleadoEstructura) {
		this.cargarid_empleadoEmpleadoEstructura= cargarid_empleadoEmpleadoEstructura;
	}

	public Border setResaltarid_estructuraEmpleadoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEstructuraBeanSwingJInternalFrame empleadoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoestructuraBeanSwingJInternalFrame.jTtoolBarEmpleadoEstructura.setBorder(borderResaltar);
		
		this.resaltarid_estructuraEmpleadoEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraEmpleadoEstructura() {
		return this.resaltarid_estructuraEmpleadoEstructura;
	}

	public void setResaltarid_estructuraEmpleadoEstructura(Border borderResaltar) {
		this.resaltarid_estructuraEmpleadoEstructura= borderResaltar;
	}

	public Boolean getMostrarid_estructuraEmpleadoEstructura() {
		return this.mostrarid_estructuraEmpleadoEstructura;
	}

	public void setMostrarid_estructuraEmpleadoEstructura(Boolean mostrarid_estructuraEmpleadoEstructura) {
		this.mostrarid_estructuraEmpleadoEstructura= mostrarid_estructuraEmpleadoEstructura;
	}

	public Boolean getActivarid_estructuraEmpleadoEstructura() {
		return this.activarid_estructuraEmpleadoEstructura;
	}

	public void setActivarid_estructuraEmpleadoEstructura(Boolean activarid_estructuraEmpleadoEstructura) {
		this.activarid_estructuraEmpleadoEstructura= activarid_estructuraEmpleadoEstructura;
	}

	public Boolean getCargarid_estructuraEmpleadoEstructura() {
		return this.cargarid_estructuraEmpleadoEstructura;
	}

	public void setCargarid_estructuraEmpleadoEstructura(Boolean cargarid_estructuraEmpleadoEstructura) {
		this.cargarid_estructuraEmpleadoEstructura= cargarid_estructuraEmpleadoEstructura;
	}

	public Border setResaltarid_cargoEmpleadoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEstructuraBeanSwingJInternalFrame empleadoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoestructuraBeanSwingJInternalFrame.jTtoolBarEmpleadoEstructura.setBorder(borderResaltar);
		
		this.resaltarid_cargoEmpleadoEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cargoEmpleadoEstructura() {
		return this.resaltarid_cargoEmpleadoEstructura;
	}

	public void setResaltarid_cargoEmpleadoEstructura(Border borderResaltar) {
		this.resaltarid_cargoEmpleadoEstructura= borderResaltar;
	}

	public Boolean getMostrarid_cargoEmpleadoEstructura() {
		return this.mostrarid_cargoEmpleadoEstructura;
	}

	public void setMostrarid_cargoEmpleadoEstructura(Boolean mostrarid_cargoEmpleadoEstructura) {
		this.mostrarid_cargoEmpleadoEstructura= mostrarid_cargoEmpleadoEstructura;
	}

	public Boolean getActivarid_cargoEmpleadoEstructura() {
		return this.activarid_cargoEmpleadoEstructura;
	}

	public void setActivarid_cargoEmpleadoEstructura(Boolean activarid_cargoEmpleadoEstructura) {
		this.activarid_cargoEmpleadoEstructura= activarid_cargoEmpleadoEstructura;
	}

	public Boolean getCargarid_cargoEmpleadoEstructura() {
		return this.cargarid_cargoEmpleadoEstructura;
	}

	public void setCargarid_cargoEmpleadoEstructura(Boolean cargarid_cargoEmpleadoEstructura) {
		this.cargarid_cargoEmpleadoEstructura= cargarid_cargoEmpleadoEstructura;
	}

	public Border setResaltarfecha_ingresoEmpleadoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEstructuraBeanSwingJInternalFrame empleadoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoestructuraBeanSwingJInternalFrame.jTtoolBarEmpleadoEstructura.setBorder(borderResaltar);
		
		this.resaltarfecha_ingresoEmpleadoEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ingresoEmpleadoEstructura() {
		return this.resaltarfecha_ingresoEmpleadoEstructura;
	}

	public void setResaltarfecha_ingresoEmpleadoEstructura(Border borderResaltar) {
		this.resaltarfecha_ingresoEmpleadoEstructura= borderResaltar;
	}

	public Boolean getMostrarfecha_ingresoEmpleadoEstructura() {
		return this.mostrarfecha_ingresoEmpleadoEstructura;
	}

	public void setMostrarfecha_ingresoEmpleadoEstructura(Boolean mostrarfecha_ingresoEmpleadoEstructura) {
		this.mostrarfecha_ingresoEmpleadoEstructura= mostrarfecha_ingresoEmpleadoEstructura;
	}

	public Boolean getActivarfecha_ingresoEmpleadoEstructura() {
		return this.activarfecha_ingresoEmpleadoEstructura;
	}

	public void setActivarfecha_ingresoEmpleadoEstructura(Boolean activarfecha_ingresoEmpleadoEstructura) {
		this.activarfecha_ingresoEmpleadoEstructura= activarfecha_ingresoEmpleadoEstructura;
	}

	public Border setResaltarfecha_salidaEmpleadoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEstructuraBeanSwingJInternalFrame empleadoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoestructuraBeanSwingJInternalFrame.jTtoolBarEmpleadoEstructura.setBorder(borderResaltar);
		
		this.resaltarfecha_salidaEmpleadoEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_salidaEmpleadoEstructura() {
		return this.resaltarfecha_salidaEmpleadoEstructura;
	}

	public void setResaltarfecha_salidaEmpleadoEstructura(Border borderResaltar) {
		this.resaltarfecha_salidaEmpleadoEstructura= borderResaltar;
	}

	public Boolean getMostrarfecha_salidaEmpleadoEstructura() {
		return this.mostrarfecha_salidaEmpleadoEstructura;
	}

	public void setMostrarfecha_salidaEmpleadoEstructura(Boolean mostrarfecha_salidaEmpleadoEstructura) {
		this.mostrarfecha_salidaEmpleadoEstructura= mostrarfecha_salidaEmpleadoEstructura;
	}

	public Boolean getActivarfecha_salidaEmpleadoEstructura() {
		return this.activarfecha_salidaEmpleadoEstructura;
	}

	public void setActivarfecha_salidaEmpleadoEstructura(Boolean activarfecha_salidaEmpleadoEstructura) {
		this.activarfecha_salidaEmpleadoEstructura= activarfecha_salidaEmpleadoEstructura;
	}

	public Border setResaltarnumero_reingresoEmpleadoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEstructuraBeanSwingJInternalFrame empleadoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoestructuraBeanSwingJInternalFrame.jTtoolBarEmpleadoEstructura.setBorder(borderResaltar);
		
		this.resaltarnumero_reingresoEmpleadoEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_reingresoEmpleadoEstructura() {
		return this.resaltarnumero_reingresoEmpleadoEstructura;
	}

	public void setResaltarnumero_reingresoEmpleadoEstructura(Border borderResaltar) {
		this.resaltarnumero_reingresoEmpleadoEstructura= borderResaltar;
	}

	public Boolean getMostrarnumero_reingresoEmpleadoEstructura() {
		return this.mostrarnumero_reingresoEmpleadoEstructura;
	}

	public void setMostrarnumero_reingresoEmpleadoEstructura(Boolean mostrarnumero_reingresoEmpleadoEstructura) {
		this.mostrarnumero_reingresoEmpleadoEstructura= mostrarnumero_reingresoEmpleadoEstructura;
	}

	public Boolean getActivarnumero_reingresoEmpleadoEstructura() {
		return this.activarnumero_reingresoEmpleadoEstructura;
	}

	public void setActivarnumero_reingresoEmpleadoEstructura(Boolean activarnumero_reingresoEmpleadoEstructura) {
		this.activarnumero_reingresoEmpleadoEstructura= activarnumero_reingresoEmpleadoEstructura;
	}

	public Border setResaltardescripcionEmpleadoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEstructuraBeanSwingJInternalFrame empleadoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoestructuraBeanSwingJInternalFrame.jTtoolBarEmpleadoEstructura.setBorder(borderResaltar);
		
		this.resaltardescripcionEmpleadoEstructura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionEmpleadoEstructura() {
		return this.resaltardescripcionEmpleadoEstructura;
	}

	public void setResaltardescripcionEmpleadoEstructura(Border borderResaltar) {
		this.resaltardescripcionEmpleadoEstructura= borderResaltar;
	}

	public Boolean getMostrardescripcionEmpleadoEstructura() {
		return this.mostrardescripcionEmpleadoEstructura;
	}

	public void setMostrardescripcionEmpleadoEstructura(Boolean mostrardescripcionEmpleadoEstructura) {
		this.mostrardescripcionEmpleadoEstructura= mostrardescripcionEmpleadoEstructura;
	}

	public Boolean getActivardescripcionEmpleadoEstructura() {
		return this.activardescripcionEmpleadoEstructura;
	}

	public void setActivardescripcionEmpleadoEstructura(Boolean activardescripcionEmpleadoEstructura) {
		this.activardescripcionEmpleadoEstructura= activardescripcionEmpleadoEstructura;
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
		
		
		this.setMostraridEmpleadoEstructura(esInicial);
		this.setMostrarid_empresaEmpleadoEstructura(esInicial);
		this.setMostrarid_sucursalEmpleadoEstructura(esInicial);
		this.setMostrarid_empleadoEmpleadoEstructura(esInicial);
		this.setMostrarid_estructuraEmpleadoEstructura(esInicial);
		this.setMostrarid_cargoEmpleadoEstructura(esInicial);
		this.setMostrarfecha_ingresoEmpleadoEstructura(esInicial);
		this.setMostrarfecha_salidaEmpleadoEstructura(esInicial);
		this.setMostrarnumero_reingresoEmpleadoEstructura(esInicial);
		this.setMostrardescripcionEmpleadoEstructura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.ID)) {
				this.setMostraridEmpleadoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEmpleadoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalEmpleadoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoEmpleadoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraEmpleadoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.IDCARGO)) {
				this.setMostrarid_cargoEmpleadoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.FECHAINGRESO)) {
				this.setMostrarfecha_ingresoEmpleadoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.FECHASALIDA)) {
				this.setMostrarfecha_salidaEmpleadoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.NUMEROREINGRESO)) {
				this.setMostrarnumero_reingresoEmpleadoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionEmpleadoEstructura(esAsigna);
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
		
		
		this.setActivaridEmpleadoEstructura(esInicial);
		this.setActivarid_empresaEmpleadoEstructura(esInicial);
		this.setActivarid_sucursalEmpleadoEstructura(esInicial);
		this.setActivarid_empleadoEmpleadoEstructura(esInicial);
		this.setActivarid_estructuraEmpleadoEstructura(esInicial);
		this.setActivarid_cargoEmpleadoEstructura(esInicial);
		this.setActivarfecha_ingresoEmpleadoEstructura(esInicial);
		this.setActivarfecha_salidaEmpleadoEstructura(esInicial);
		this.setActivarnumero_reingresoEmpleadoEstructura(esInicial);
		this.setActivardescripcionEmpleadoEstructura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.ID)) {
				this.setActivaridEmpleadoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEmpleadoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalEmpleadoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoEmpleadoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraEmpleadoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.IDCARGO)) {
				this.setActivarid_cargoEmpleadoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.FECHAINGRESO)) {
				this.setActivarfecha_ingresoEmpleadoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.FECHASALIDA)) {
				this.setActivarfecha_salidaEmpleadoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.NUMEROREINGRESO)) {
				this.setActivarnumero_reingresoEmpleadoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionEmpleadoEstructura(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpleadoEstructuraBeanSwingJInternalFrame empleadoestructuraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEmpleadoEstructura(esInicial);
		this.setResaltarid_empresaEmpleadoEstructura(esInicial);
		this.setResaltarid_sucursalEmpleadoEstructura(esInicial);
		this.setResaltarid_empleadoEmpleadoEstructura(esInicial);
		this.setResaltarid_estructuraEmpleadoEstructura(esInicial);
		this.setResaltarid_cargoEmpleadoEstructura(esInicial);
		this.setResaltarfecha_ingresoEmpleadoEstructura(esInicial);
		this.setResaltarfecha_salidaEmpleadoEstructura(esInicial);
		this.setResaltarnumero_reingresoEmpleadoEstructura(esInicial);
		this.setResaltardescripcionEmpleadoEstructura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.ID)) {
				this.setResaltaridEmpleadoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEmpleadoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalEmpleadoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoEmpleadoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraEmpleadoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.IDCARGO)) {
				this.setResaltarid_cargoEmpleadoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.FECHAINGRESO)) {
				this.setResaltarfecha_ingresoEmpleadoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.FECHASALIDA)) {
				this.setResaltarfecha_salidaEmpleadoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.NUMEROREINGRESO)) {
				this.setResaltarnumero_reingresoEmpleadoEstructura(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoEstructuraConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionEmpleadoEstructura(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpleadoEstructuraBeanSwingJInternalFrame empleadoestructuraBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCargoEmpleadoEstructura=true;

	public Boolean getMostrarFK_IdCargoEmpleadoEstructura() {
		return this.mostrarFK_IdCargoEmpleadoEstructura;
	}

	public void setMostrarFK_IdCargoEmpleadoEstructura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCargoEmpleadoEstructura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoEmpleadoEstructura=true;

	public Boolean getMostrarFK_IdEmpleadoEmpleadoEstructura() {
		return this.mostrarFK_IdEmpleadoEmpleadoEstructura;
	}

	public void setMostrarFK_IdEmpleadoEmpleadoEstructura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoEmpleadoEstructura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaEmpleadoEstructura=true;

	public Boolean getMostrarFK_IdEmpresaEmpleadoEstructura() {
		return this.mostrarFK_IdEmpresaEmpleadoEstructura;
	}

	public void setMostrarFK_IdEmpresaEmpleadoEstructura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaEmpleadoEstructura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstructuraEmpleadoEstructura=true;

	public Boolean getMostrarFK_IdEstructuraEmpleadoEstructura() {
		return this.mostrarFK_IdEstructuraEmpleadoEstructura;
	}

	public void setMostrarFK_IdEstructuraEmpleadoEstructura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstructuraEmpleadoEstructura= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalEmpleadoEstructura=true;

	public Boolean getMostrarFK_IdSucursalEmpleadoEstructura() {
		return this.mostrarFK_IdSucursalEmpleadoEstructura;
	}

	public void setMostrarFK_IdSucursalEmpleadoEstructura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalEmpleadoEstructura= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCargoEmpleadoEstructura=true;

	public Boolean getActivarFK_IdCargoEmpleadoEstructura() {
		return this.activarFK_IdCargoEmpleadoEstructura;
	}

	public void setActivarFK_IdCargoEmpleadoEstructura(Boolean habilitarResaltar) {
		this.activarFK_IdCargoEmpleadoEstructura= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoEmpleadoEstructura=true;

	public Boolean getActivarFK_IdEmpleadoEmpleadoEstructura() {
		return this.activarFK_IdEmpleadoEmpleadoEstructura;
	}

	public void setActivarFK_IdEmpleadoEmpleadoEstructura(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoEmpleadoEstructura= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaEmpleadoEstructura=true;

	public Boolean getActivarFK_IdEmpresaEmpleadoEstructura() {
		return this.activarFK_IdEmpresaEmpleadoEstructura;
	}

	public void setActivarFK_IdEmpresaEmpleadoEstructura(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaEmpleadoEstructura= habilitarResaltar;
	}

	public Boolean activarFK_IdEstructuraEmpleadoEstructura=true;

	public Boolean getActivarFK_IdEstructuraEmpleadoEstructura() {
		return this.activarFK_IdEstructuraEmpleadoEstructura;
	}

	public void setActivarFK_IdEstructuraEmpleadoEstructura(Boolean habilitarResaltar) {
		this.activarFK_IdEstructuraEmpleadoEstructura= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalEmpleadoEstructura=true;

	public Boolean getActivarFK_IdSucursalEmpleadoEstructura() {
		return this.activarFK_IdSucursalEmpleadoEstructura;
	}

	public void setActivarFK_IdSucursalEmpleadoEstructura(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalEmpleadoEstructura= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCargoEmpleadoEstructura=null;

	public Border getResaltarFK_IdCargoEmpleadoEstructura() {
		return this.resaltarFK_IdCargoEmpleadoEstructura;
	}

	public void setResaltarFK_IdCargoEmpleadoEstructura(Border borderResaltar) {
		this.resaltarFK_IdCargoEmpleadoEstructura= borderResaltar;
	}

	public void setResaltarFK_IdCargoEmpleadoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEstructuraBeanSwingJInternalFrame empleadoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCargoEmpleadoEstructura= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoEmpleadoEstructura=null;

	public Border getResaltarFK_IdEmpleadoEmpleadoEstructura() {
		return this.resaltarFK_IdEmpleadoEmpleadoEstructura;
	}

	public void setResaltarFK_IdEmpleadoEmpleadoEstructura(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoEmpleadoEstructura= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoEmpleadoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEstructuraBeanSwingJInternalFrame empleadoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoEmpleadoEstructura= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaEmpleadoEstructura=null;

	public Border getResaltarFK_IdEmpresaEmpleadoEstructura() {
		return this.resaltarFK_IdEmpresaEmpleadoEstructura;
	}

	public void setResaltarFK_IdEmpresaEmpleadoEstructura(Border borderResaltar) {
		this.resaltarFK_IdEmpresaEmpleadoEstructura= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaEmpleadoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEstructuraBeanSwingJInternalFrame empleadoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaEmpleadoEstructura= borderResaltar;
	}

	public Border resaltarFK_IdEstructuraEmpleadoEstructura=null;

	public Border getResaltarFK_IdEstructuraEmpleadoEstructura() {
		return this.resaltarFK_IdEstructuraEmpleadoEstructura;
	}

	public void setResaltarFK_IdEstructuraEmpleadoEstructura(Border borderResaltar) {
		this.resaltarFK_IdEstructuraEmpleadoEstructura= borderResaltar;
	}

	public void setResaltarFK_IdEstructuraEmpleadoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEstructuraBeanSwingJInternalFrame empleadoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstructuraEmpleadoEstructura= borderResaltar;
	}

	public Border resaltarFK_IdSucursalEmpleadoEstructura=null;

	public Border getResaltarFK_IdSucursalEmpleadoEstructura() {
		return this.resaltarFK_IdSucursalEmpleadoEstructura;
	}

	public void setResaltarFK_IdSucursalEmpleadoEstructura(Border borderResaltar) {
		this.resaltarFK_IdSucursalEmpleadoEstructura= borderResaltar;
	}

	public void setResaltarFK_IdSucursalEmpleadoEstructura(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoEstructuraBeanSwingJInternalFrame empleadoestructuraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalEmpleadoEstructura= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}