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


import com.bydan.erp.nomina.util.CierreRolMensualConstantesFunciones;
import com.bydan.erp.nomina.util.CierreRolMensualParameterReturnGeneral;
//import com.bydan.erp.nomina.util.CierreRolMensualParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CierreRolMensualConstantesFunciones extends CierreRolMensualConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CierreRolMensual";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CierreRolMensual"+CierreRolMensualConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CierreRolMensualHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CierreRolMensualHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CierreRolMensualConstantesFunciones.SCHEMA+"_"+CierreRolMensualConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CierreRolMensualHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CierreRolMensualConstantesFunciones.SCHEMA+"_"+CierreRolMensualConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CierreRolMensualConstantesFunciones.SCHEMA+"_"+CierreRolMensualConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CierreRolMensualHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CierreRolMensualConstantesFunciones.SCHEMA+"_"+CierreRolMensualConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CierreRolMensualConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CierreRolMensualHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CierreRolMensualConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CierreRolMensualConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CierreRolMensualHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CierreRolMensualConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CierreRolMensualConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CierreRolMensualConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CierreRolMensualConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CierreRolMensualConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cierre Rol Mensuales";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Cierre Rol Mensual";
	public static final String SCLASSWEBTITULO_LOWER="Cierre Rol Mensual";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CierreRolMensual";
	public static final String OBJECTNAME="cierrerolmensual";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="cierre_rol_mensual";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cierrerolmensual from "+CierreRolMensualConstantesFunciones.SPERSISTENCENAME+" cierrerolmensual";
	public static String QUERYSELECTNATIVE="select "+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME+".id,"+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME+".version_row,"+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME+".id_empresa,"+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME+".id_sucursal,"+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME+".id_ejercicio,"+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME+".id_empleado,"+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME+".id_estructura,"+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME+".id_estado_empleado,"+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME+".id_asiento_contable,"+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME+".porcentaje,"+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME+".fecha from "+CierreRolMensualConstantesFunciones.SCHEMA+"."+CierreRolMensualConstantesFunciones.TABLENAME;//+" as "+CierreRolMensualConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CierreRolMensualConstantesFuncionesAdditional cierrerolmensualConstantesFuncionesAdditional=null;
	
	public CierreRolMensualConstantesFuncionesAdditional getCierreRolMensualConstantesFuncionesAdditional() {
		return this.cierrerolmensualConstantesFuncionesAdditional;
	}
	
	public void setCierreRolMensualConstantesFuncionesAdditional(CierreRolMensualConstantesFuncionesAdditional cierrerolmensualConstantesFuncionesAdditional) {
		try {
			this.cierrerolmensualConstantesFuncionesAdditional=cierrerolmensualConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDESTRUCTURA= "id_estructura";
    public static final String IDESTADOEMPLEADO= "id_estado_empleado";
    public static final String IDASIENTOCONTABLE= "id_asiento_contable";
    public static final String PORCENTAJE= "porcentaje";
    public static final String FECHA= "fecha";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDESTRUCTURA= "Estructura";
		public static final String LABEL_IDESTRUCTURA_LOWER= "Estructura";
    	public static final String LABEL_IDESTADOEMPLEADO= "Estado Empleado";
		public static final String LABEL_IDESTADOEMPLEADO_LOWER= "Estado Empleado";
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento Contable";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
	
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getCierreRolMensualLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CierreRolMensualConstantesFunciones.IDEMPRESA)) {sLabelColumna=CierreRolMensualConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CierreRolMensualConstantesFunciones.IDSUCURSAL)) {sLabelColumna=CierreRolMensualConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(CierreRolMensualConstantesFunciones.IDEJERCICIO)) {sLabelColumna=CierreRolMensualConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(CierreRolMensualConstantesFunciones.IDEMPLEADO)) {sLabelColumna=CierreRolMensualConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(CierreRolMensualConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=CierreRolMensualConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(CierreRolMensualConstantesFunciones.IDESTADOEMPLEADO)) {sLabelColumna=CierreRolMensualConstantesFunciones.LABEL_IDESTADOEMPLEADO;}
		if(sNombreColumna.equals(CierreRolMensualConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=CierreRolMensualConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(CierreRolMensualConstantesFunciones.PORCENTAJE)) {sLabelColumna=CierreRolMensualConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(CierreRolMensualConstantesFunciones.FECHA)) {sLabelColumna=CierreRolMensualConstantesFunciones.LABEL_FECHA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCierreRolMensualDescripcion(CierreRolMensual cierrerolmensual) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cierrerolmensual !=null/* && cierrerolmensual.getId()!=0*/) {
			if(cierrerolmensual.getId()!=null) {
				sDescripcion=cierrerolmensual.getId().toString();
			}//cierrerolmensualcierrerolmensual.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getCierreRolMensualDescripcionDetallado(CierreRolMensual cierrerolmensual) {
		String sDescripcion="";
			
		sDescripcion+=CierreRolMensualConstantesFunciones.ID+"=";
		sDescripcion+=cierrerolmensual.getId().toString()+",";
		sDescripcion+=CierreRolMensualConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cierrerolmensual.getVersionRow().toString()+",";
		sDescripcion+=CierreRolMensualConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cierrerolmensual.getid_empresa().toString()+",";
		sDescripcion+=CierreRolMensualConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=cierrerolmensual.getid_sucursal().toString()+",";
		sDescripcion+=CierreRolMensualConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=cierrerolmensual.getid_ejercicio().toString()+",";
		sDescripcion+=CierreRolMensualConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=cierrerolmensual.getid_empleado().toString()+",";
		sDescripcion+=CierreRolMensualConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=cierrerolmensual.getid_estructura().toString()+",";
		sDescripcion+=CierreRolMensualConstantesFunciones.IDESTADOEMPLEADO+"=";
		sDescripcion+=cierrerolmensual.getid_estado_empleado().toString()+",";
		sDescripcion+=CierreRolMensualConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=cierrerolmensual.getid_asiento_contable().toString()+",";
		sDescripcion+=CierreRolMensualConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=cierrerolmensual.getporcentaje().toString()+",";
		sDescripcion+=CierreRolMensualConstantesFunciones.FECHA+"=";
		sDescripcion+=cierrerolmensual.getfecha().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCierreRolMensualDescripcion(CierreRolMensual cierrerolmensual,String sValor) throws Exception {			
		if(cierrerolmensual !=null) {
			//cierrerolmensualcierrerolmensual.getId().toString();
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

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
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

	public static String getEstadoEmpleadoDescripcion(EstadoEmpleado estadoempleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadoempleado!=null/*&&estadoempleado.getId()>0*/) {
			sDescripcion=EstadoEmpleadoConstantesFunciones.getEstadoEmpleadoDescripcion(estadoempleado);
		}

		return sDescripcion;
	}

	public static String getAsientoContableDescripcion(AsientoContable asientocontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(asientocontable!=null/*&&asientocontable.getId()>0*/) {
			sDescripcion=AsientoContableConstantesFunciones.getAsientoContableDescripcion(asientocontable);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAsientoContable")) {
			sNombreIndice="Tipo=  Por Asiento Contable";
		} else if(sNombreIndice.equals("FK_IdCierreRolMensual")) {
			sNombreIndice="Tipo=  Por Estructura";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoEmpleado")) {
			sNombreIndice="Tipo=  Por Estado Empleado";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAsientoContable(Long id_asiento_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_asiento_contable!=null) {sDetalleIndice+=" Codigo Unico De Asiento Contable="+id_asiento_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCierreRolMensual(Long id_estructura) {
		String sDetalleIndice=" Parametros->";
		if(id_estructura!=null) {sDetalleIndice+=" Codigo Unico De Estructura="+id_estructura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

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

	public static String getDetalleIndiceFK_IdEstadoEmpleado(Long id_estado_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_empleado!=null) {sDetalleIndice+=" Codigo Unico De Estado Empleado="+id_estado_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCierreRolMensual(CierreRolMensual cierrerolmensual,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosCierreRolMensuals(List<CierreRolMensual> cierrerolmensuals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CierreRolMensual cierrerolmensual: cierrerolmensuals) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCierreRolMensual(CierreRolMensual cierrerolmensual,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cierrerolmensual.getConCambioAuxiliar()) {
			cierrerolmensual.setIsDeleted(cierrerolmensual.getIsDeletedAuxiliar());	
			cierrerolmensual.setIsNew(cierrerolmensual.getIsNewAuxiliar());	
			cierrerolmensual.setIsChanged(cierrerolmensual.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cierrerolmensual.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cierrerolmensual.setIsDeletedAuxiliar(false);	
			cierrerolmensual.setIsNewAuxiliar(false);	
			cierrerolmensual.setIsChangedAuxiliar(false);
			
			cierrerolmensual.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCierreRolMensuals(List<CierreRolMensual> cierrerolmensuals,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CierreRolMensual cierrerolmensual : cierrerolmensuals) {
			if(conAsignarBase && cierrerolmensual.getConCambioAuxiliar()) {
				cierrerolmensual.setIsDeleted(cierrerolmensual.getIsDeletedAuxiliar());	
				cierrerolmensual.setIsNew(cierrerolmensual.getIsNewAuxiliar());	
				cierrerolmensual.setIsChanged(cierrerolmensual.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cierrerolmensual.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cierrerolmensual.setIsDeletedAuxiliar(false);	
				cierrerolmensual.setIsNewAuxiliar(false);	
				cierrerolmensual.setIsChangedAuxiliar(false);
				
				cierrerolmensual.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCierreRolMensual(CierreRolMensual cierrerolmensual,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			cierrerolmensual.setporcentaje(0);
		}
	}		
	
	public static void InicializarValoresCierreRolMensuals(List<CierreRolMensual> cierrerolmensuals,Boolean conEnteros) throws Exception  {
		
		for(CierreRolMensual cierrerolmensual: cierrerolmensuals) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				cierrerolmensual.setporcentaje(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaCierreRolMensual(List<CierreRolMensual> cierrerolmensuals,CierreRolMensual cierrerolmensualAux) throws Exception  {
		CierreRolMensualConstantesFunciones.InicializarValoresCierreRolMensual(cierrerolmensualAux,true);
		
		for(CierreRolMensual cierrerolmensual: cierrerolmensuals) {
			if(cierrerolmensual.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cierrerolmensualAux.setporcentaje(cierrerolmensualAux.getporcentaje()+cierrerolmensual.getporcentaje());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCierreRolMensual(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CierreRolMensualConstantesFunciones.getArrayColumnasGlobalesCierreRolMensual(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCierreRolMensual(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CierreRolMensualConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CierreRolMensualConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CierreRolMensualConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CierreRolMensualConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CierreRolMensualConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CierreRolMensualConstantesFunciones.IDEJERCICIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCierreRolMensual(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CierreRolMensual> cierrerolmensuals,CierreRolMensual cierrerolmensual,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CierreRolMensual cierrerolmensualAux: cierrerolmensuals) {
			if(cierrerolmensualAux!=null && cierrerolmensual!=null) {
				if((cierrerolmensualAux.getId()==null && cierrerolmensual.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cierrerolmensualAux.getId()!=null && cierrerolmensual.getId()!=null){
					if(cierrerolmensualAux.getId().equals(cierrerolmensual.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCierreRolMensual(List<CierreRolMensual> cierrerolmensuals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CierreRolMensual cierrerolmensual: cierrerolmensuals) {			
			if(cierrerolmensual.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCierreRolMensual() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CierreRolMensualConstantesFunciones.LABEL_ID, CierreRolMensualConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CierreRolMensualConstantesFunciones.LABEL_VERSIONROW, CierreRolMensualConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CierreRolMensualConstantesFunciones.LABEL_IDEMPRESA, CierreRolMensualConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CierreRolMensualConstantesFunciones.LABEL_IDSUCURSAL, CierreRolMensualConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CierreRolMensualConstantesFunciones.LABEL_IDEJERCICIO, CierreRolMensualConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CierreRolMensualConstantesFunciones.LABEL_IDEMPLEADO, CierreRolMensualConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CierreRolMensualConstantesFunciones.LABEL_IDESTRUCTURA, CierreRolMensualConstantesFunciones.IDESTRUCTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CierreRolMensualConstantesFunciones.LABEL_IDESTADOEMPLEADO, CierreRolMensualConstantesFunciones.IDESTADOEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CierreRolMensualConstantesFunciones.LABEL_IDASIENTOCONTABLE, CierreRolMensualConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CierreRolMensualConstantesFunciones.LABEL_PORCENTAJE, CierreRolMensualConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CierreRolMensualConstantesFunciones.LABEL_FECHA, CierreRolMensualConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCierreRolMensual() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CierreRolMensualConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CierreRolMensualConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CierreRolMensualConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CierreRolMensualConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CierreRolMensualConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CierreRolMensualConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CierreRolMensualConstantesFunciones.IDESTRUCTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CierreRolMensualConstantesFunciones.IDESTADOEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CierreRolMensualConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CierreRolMensualConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CierreRolMensualConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCierreRolMensual() throws Exception  {
		return CierreRolMensualConstantesFunciones.getTiposSeleccionarCierreRolMensual(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCierreRolMensual(Boolean conFk) throws Exception  {
		return CierreRolMensualConstantesFunciones.getTiposSeleccionarCierreRolMensual(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCierreRolMensual(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CierreRolMensualConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CierreRolMensualConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CierreRolMensualConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(CierreRolMensualConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CierreRolMensualConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(CierreRolMensualConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CierreRolMensualConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(CierreRolMensualConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CierreRolMensualConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(CierreRolMensualConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CierreRolMensualConstantesFunciones.LABEL_IDESTADOEMPLEADO);
			reporte.setsDescripcion(CierreRolMensualConstantesFunciones.LABEL_IDESTADOEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CierreRolMensualConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(CierreRolMensualConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CierreRolMensualConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(CierreRolMensualConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CierreRolMensualConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(CierreRolMensualConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCierreRolMensual(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCierreRolMensual(CierreRolMensual cierrerolmensualAux) throws Exception {
		
			cierrerolmensualAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cierrerolmensualAux.getEmpresa()));
			cierrerolmensualAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cierrerolmensualAux.getSucursal()));
			cierrerolmensualAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(cierrerolmensualAux.getEjercicio()));
			cierrerolmensualAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(cierrerolmensualAux.getEmpleado()));
			cierrerolmensualAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(cierrerolmensualAux.getEstructura()));
			cierrerolmensualAux.setestadoempleado_descripcion(EstadoEmpleadoConstantesFunciones.getEstadoEmpleadoDescripcion(cierrerolmensualAux.getEstadoEmpleado()));
			cierrerolmensualAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(cierrerolmensualAux.getAsientoContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCierreRolMensual(List<CierreRolMensual> cierrerolmensualsTemp) throws Exception {
		for(CierreRolMensual cierrerolmensualAux:cierrerolmensualsTemp) {
			
			cierrerolmensualAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cierrerolmensualAux.getEmpresa()));
			cierrerolmensualAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cierrerolmensualAux.getSucursal()));
			cierrerolmensualAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(cierrerolmensualAux.getEjercicio()));
			cierrerolmensualAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(cierrerolmensualAux.getEmpleado()));
			cierrerolmensualAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(cierrerolmensualAux.getEstructura()));
			cierrerolmensualAux.setestadoempleado_descripcion(EstadoEmpleadoConstantesFunciones.getEstadoEmpleadoDescripcion(cierrerolmensualAux.getEstadoEmpleado()));
			cierrerolmensualAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(cierrerolmensualAux.getAsientoContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCierreRolMensual(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(EstadoEmpleado.class));
				classes.add(new Classe(AsientoContable.class));
				
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
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
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
					if(clas.clas.equals(EstadoEmpleado.class)) {
						classes.add(new Classe(EstadoEmpleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AsientoContable.class)) {
						classes.add(new Classe(AsientoContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCierreRolMensual(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(EstadoEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoEmpleado.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(EstadoEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoEmpleado.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCierreRolMensual(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CierreRolMensualConstantesFunciones.getClassesRelationshipsOfCierreRolMensual(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCierreRolMensual(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCierreRolMensual(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CierreRolMensualConstantesFunciones.getClassesRelationshipsFromStringsOfCierreRolMensual(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCierreRolMensual(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CierreRolMensual cierrerolmensual,List<CierreRolMensual> cierrerolmensuals,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CierreRolMensual cierrerolmensualEncontrado=null;
			
			for(CierreRolMensual cierrerolmensualLocal:cierrerolmensuals) {
				if(cierrerolmensualLocal.getId().equals(cierrerolmensual.getId())) {
					cierrerolmensualEncontrado=cierrerolmensualLocal;
					
					cierrerolmensualLocal.setIsChanged(cierrerolmensual.getIsChanged());
					cierrerolmensualLocal.setIsNew(cierrerolmensual.getIsNew());
					cierrerolmensualLocal.setIsDeleted(cierrerolmensual.getIsDeleted());
					
					cierrerolmensualLocal.setGeneralEntityOriginal(cierrerolmensual.getGeneralEntityOriginal());
					
					cierrerolmensualLocal.setId(cierrerolmensual.getId());	
					cierrerolmensualLocal.setVersionRow(cierrerolmensual.getVersionRow());	
					cierrerolmensualLocal.setid_empresa(cierrerolmensual.getid_empresa());	
					cierrerolmensualLocal.setid_sucursal(cierrerolmensual.getid_sucursal());	
					cierrerolmensualLocal.setid_ejercicio(cierrerolmensual.getid_ejercicio());	
					cierrerolmensualLocal.setid_empleado(cierrerolmensual.getid_empleado());	
					cierrerolmensualLocal.setid_estructura(cierrerolmensual.getid_estructura());	
					cierrerolmensualLocal.setid_estado_empleado(cierrerolmensual.getid_estado_empleado());	
					cierrerolmensualLocal.setid_asiento_contable(cierrerolmensual.getid_asiento_contable());	
					cierrerolmensualLocal.setporcentaje(cierrerolmensual.getporcentaje());	
					cierrerolmensualLocal.setfecha(cierrerolmensual.getfecha());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!cierrerolmensual.getIsDeleted()) {
				if(!existe) {
					cierrerolmensuals.add(cierrerolmensual);
				}
			} else {
				if(cierrerolmensualEncontrado!=null && permiteQuitar)  {
					cierrerolmensuals.remove(cierrerolmensualEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CierreRolMensual cierrerolmensual,List<CierreRolMensual> cierrerolmensuals) throws Exception {
		try	{			
			for(CierreRolMensual cierrerolmensualLocal:cierrerolmensuals) {
				if(cierrerolmensualLocal.getId().equals(cierrerolmensual.getId())) {
					cierrerolmensualLocal.setIsSelected(cierrerolmensual.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCierreRolMensual(List<CierreRolMensual> cierrerolmensualsAux) throws Exception {
		//this.cierrerolmensualsAux=cierrerolmensualsAux;
		
		for(CierreRolMensual cierrerolmensualAux:cierrerolmensualsAux) {
			if(cierrerolmensualAux.getIsChanged()) {
				cierrerolmensualAux.setIsChanged(false);
			}		
			
			if(cierrerolmensualAux.getIsNew()) {
				cierrerolmensualAux.setIsNew(false);
			}	
			
			if(cierrerolmensualAux.getIsDeleted()) {
				cierrerolmensualAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCierreRolMensual(CierreRolMensual cierrerolmensualAux) throws Exception {
		//this.cierrerolmensualAux=cierrerolmensualAux;
		
			if(cierrerolmensualAux.getIsChanged()) {
				cierrerolmensualAux.setIsChanged(false);
			}		
			
			if(cierrerolmensualAux.getIsNew()) {
				cierrerolmensualAux.setIsNew(false);
			}	
			
			if(cierrerolmensualAux.getIsDeleted()) {
				cierrerolmensualAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CierreRolMensual cierrerolmensualAsignar,CierreRolMensual cierrerolmensual) throws Exception {
		cierrerolmensualAsignar.setId(cierrerolmensual.getId());	
		cierrerolmensualAsignar.setVersionRow(cierrerolmensual.getVersionRow());	
		cierrerolmensualAsignar.setid_empresa(cierrerolmensual.getid_empresa());
		cierrerolmensualAsignar.setempresa_descripcion(cierrerolmensual.getempresa_descripcion());	
		cierrerolmensualAsignar.setid_sucursal(cierrerolmensual.getid_sucursal());
		cierrerolmensualAsignar.setsucursal_descripcion(cierrerolmensual.getsucursal_descripcion());	
		cierrerolmensualAsignar.setid_ejercicio(cierrerolmensual.getid_ejercicio());
		cierrerolmensualAsignar.setejercicio_descripcion(cierrerolmensual.getejercicio_descripcion());	
		cierrerolmensualAsignar.setid_empleado(cierrerolmensual.getid_empleado());
		cierrerolmensualAsignar.setempleado_descripcion(cierrerolmensual.getempleado_descripcion());	
		cierrerolmensualAsignar.setid_estructura(cierrerolmensual.getid_estructura());
		cierrerolmensualAsignar.setestructura_descripcion(cierrerolmensual.getestructura_descripcion());	
		cierrerolmensualAsignar.setid_estado_empleado(cierrerolmensual.getid_estado_empleado());
		cierrerolmensualAsignar.setestadoempleado_descripcion(cierrerolmensual.getestadoempleado_descripcion());	
		cierrerolmensualAsignar.setid_asiento_contable(cierrerolmensual.getid_asiento_contable());
		cierrerolmensualAsignar.setasientocontable_descripcion(cierrerolmensual.getasientocontable_descripcion());	
		cierrerolmensualAsignar.setporcentaje(cierrerolmensual.getporcentaje());	
		cierrerolmensualAsignar.setfecha(cierrerolmensual.getfecha());	
	}
	
	public static void inicializarCierreRolMensual(CierreRolMensual cierrerolmensual) throws Exception {
		try {
				cierrerolmensual.setId(0L);	
					
				cierrerolmensual.setid_empresa(-1L);	
				cierrerolmensual.setid_sucursal(-1L);	
				cierrerolmensual.setid_ejercicio(-1L);	
				cierrerolmensual.setid_empleado(-1L);	
				cierrerolmensual.setid_estructura(-1L);	
				cierrerolmensual.setid_estado_empleado(-1L);	
				cierrerolmensual.setid_asiento_contable(-1L);	
				cierrerolmensual.setporcentaje(0);	
				cierrerolmensual.setfecha(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCierreRolMensual(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CierreRolMensualConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CierreRolMensualConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CierreRolMensualConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CierreRolMensualConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CierreRolMensualConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CierreRolMensualConstantesFunciones.LABEL_IDESTADOEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CierreRolMensualConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CierreRolMensualConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CierreRolMensualConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCierreRolMensual(String sTipo,Row row,Workbook workbook,CierreRolMensual cierrerolmensual,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cierrerolmensual.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cierrerolmensual.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cierrerolmensual.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cierrerolmensual.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cierrerolmensual.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cierrerolmensual.getestadoempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cierrerolmensual.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cierrerolmensual.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cierrerolmensual.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCierreRolMensual=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCierreRolMensual() {
		return this.sFinalQueryCierreRolMensual;
	}
	
	public void setsFinalQueryCierreRolMensual(String sFinalQueryCierreRolMensual) {
		this.sFinalQueryCierreRolMensual= sFinalQueryCierreRolMensual;
	}
	
	public Border resaltarSeleccionarCierreRolMensual=null;
	
	public Border setResaltarSeleccionarCierreRolMensual(ParametroGeneralUsuario parametroGeneralUsuario/*CierreRolMensualBeanSwingJInternalFrame cierrerolmensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cierrerolmensualBeanSwingJInternalFrame.jTtoolBarCierreRolMensual.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCierreRolMensual= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCierreRolMensual() {
		return this.resaltarSeleccionarCierreRolMensual;
	}
	
	public void setResaltarSeleccionarCierreRolMensual(Border borderResaltarSeleccionarCierreRolMensual) {
		this.resaltarSeleccionarCierreRolMensual= borderResaltarSeleccionarCierreRolMensual;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCierreRolMensual=null;
	public Boolean mostraridCierreRolMensual=true;
	public Boolean activaridCierreRolMensual=true;

	public Border resaltarid_empresaCierreRolMensual=null;
	public Boolean mostrarid_empresaCierreRolMensual=true;
	public Boolean activarid_empresaCierreRolMensual=true;
	public Boolean cargarid_empresaCierreRolMensual=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCierreRolMensual=false;//ConEventDepend=true

	public Border resaltarid_sucursalCierreRolMensual=null;
	public Boolean mostrarid_sucursalCierreRolMensual=true;
	public Boolean activarid_sucursalCierreRolMensual=true;
	public Boolean cargarid_sucursalCierreRolMensual=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalCierreRolMensual=false;//ConEventDepend=true

	public Border resaltarid_ejercicioCierreRolMensual=null;
	public Boolean mostrarid_ejercicioCierreRolMensual=true;
	public Boolean activarid_ejercicioCierreRolMensual=true;
	public Boolean cargarid_ejercicioCierreRolMensual=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioCierreRolMensual=false;//ConEventDepend=true

	public Border resaltarid_empleadoCierreRolMensual=null;
	public Boolean mostrarid_empleadoCierreRolMensual=true;
	public Boolean activarid_empleadoCierreRolMensual=true;
	public Boolean cargarid_empleadoCierreRolMensual=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoCierreRolMensual=false;//ConEventDepend=true

	public Border resaltarid_estructuraCierreRolMensual=null;
	public Boolean mostrarid_estructuraCierreRolMensual=true;
	public Boolean activarid_estructuraCierreRolMensual=true;
	public Boolean cargarid_estructuraCierreRolMensual=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraCierreRolMensual=false;//ConEventDepend=true

	public Border resaltarid_estado_empleadoCierreRolMensual=null;
	public Boolean mostrarid_estado_empleadoCierreRolMensual=true;
	public Boolean activarid_estado_empleadoCierreRolMensual=true;
	public Boolean cargarid_estado_empleadoCierreRolMensual=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_empleadoCierreRolMensual=false;//ConEventDepend=true

	public Border resaltarid_asiento_contableCierreRolMensual=null;
	public Boolean mostrarid_asiento_contableCierreRolMensual=true;
	public Boolean activarid_asiento_contableCierreRolMensual=true;
	public Boolean cargarid_asiento_contableCierreRolMensual=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contableCierreRolMensual=false;//ConEventDepend=true

	public Border resaltarporcentajeCierreRolMensual=null;
	public Boolean mostrarporcentajeCierreRolMensual=true;
	public Boolean activarporcentajeCierreRolMensual=true;

	public Border resaltarfechaCierreRolMensual=null;
	public Boolean mostrarfechaCierreRolMensual=true;
	public Boolean activarfechaCierreRolMensual=false;

	
	

	public Border setResaltaridCierreRolMensual(ParametroGeneralUsuario parametroGeneralUsuario/*CierreRolMensualBeanSwingJInternalFrame cierrerolmensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cierrerolmensualBeanSwingJInternalFrame.jTtoolBarCierreRolMensual.setBorder(borderResaltar);
		
		this.resaltaridCierreRolMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCierreRolMensual() {
		return this.resaltaridCierreRolMensual;
	}

	public void setResaltaridCierreRolMensual(Border borderResaltar) {
		this.resaltaridCierreRolMensual= borderResaltar;
	}

	public Boolean getMostraridCierreRolMensual() {
		return this.mostraridCierreRolMensual;
	}

	public void setMostraridCierreRolMensual(Boolean mostraridCierreRolMensual) {
		this.mostraridCierreRolMensual= mostraridCierreRolMensual;
	}

	public Boolean getActivaridCierreRolMensual() {
		return this.activaridCierreRolMensual;
	}

	public void setActivaridCierreRolMensual(Boolean activaridCierreRolMensual) {
		this.activaridCierreRolMensual= activaridCierreRolMensual;
	}

	public Border setResaltarid_empresaCierreRolMensual(ParametroGeneralUsuario parametroGeneralUsuario/*CierreRolMensualBeanSwingJInternalFrame cierrerolmensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cierrerolmensualBeanSwingJInternalFrame.jTtoolBarCierreRolMensual.setBorder(borderResaltar);
		
		this.resaltarid_empresaCierreRolMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCierreRolMensual() {
		return this.resaltarid_empresaCierreRolMensual;
	}

	public void setResaltarid_empresaCierreRolMensual(Border borderResaltar) {
		this.resaltarid_empresaCierreRolMensual= borderResaltar;
	}

	public Boolean getMostrarid_empresaCierreRolMensual() {
		return this.mostrarid_empresaCierreRolMensual;
	}

	public void setMostrarid_empresaCierreRolMensual(Boolean mostrarid_empresaCierreRolMensual) {
		this.mostrarid_empresaCierreRolMensual= mostrarid_empresaCierreRolMensual;
	}

	public Boolean getActivarid_empresaCierreRolMensual() {
		return this.activarid_empresaCierreRolMensual;
	}

	public void setActivarid_empresaCierreRolMensual(Boolean activarid_empresaCierreRolMensual) {
		this.activarid_empresaCierreRolMensual= activarid_empresaCierreRolMensual;
	}

	public Boolean getCargarid_empresaCierreRolMensual() {
		return this.cargarid_empresaCierreRolMensual;
	}

	public void setCargarid_empresaCierreRolMensual(Boolean cargarid_empresaCierreRolMensual) {
		this.cargarid_empresaCierreRolMensual= cargarid_empresaCierreRolMensual;
	}

	public Border setResaltarid_sucursalCierreRolMensual(ParametroGeneralUsuario parametroGeneralUsuario/*CierreRolMensualBeanSwingJInternalFrame cierrerolmensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cierrerolmensualBeanSwingJInternalFrame.jTtoolBarCierreRolMensual.setBorder(borderResaltar);
		
		this.resaltarid_sucursalCierreRolMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalCierreRolMensual() {
		return this.resaltarid_sucursalCierreRolMensual;
	}

	public void setResaltarid_sucursalCierreRolMensual(Border borderResaltar) {
		this.resaltarid_sucursalCierreRolMensual= borderResaltar;
	}

	public Boolean getMostrarid_sucursalCierreRolMensual() {
		return this.mostrarid_sucursalCierreRolMensual;
	}

	public void setMostrarid_sucursalCierreRolMensual(Boolean mostrarid_sucursalCierreRolMensual) {
		this.mostrarid_sucursalCierreRolMensual= mostrarid_sucursalCierreRolMensual;
	}

	public Boolean getActivarid_sucursalCierreRolMensual() {
		return this.activarid_sucursalCierreRolMensual;
	}

	public void setActivarid_sucursalCierreRolMensual(Boolean activarid_sucursalCierreRolMensual) {
		this.activarid_sucursalCierreRolMensual= activarid_sucursalCierreRolMensual;
	}

	public Boolean getCargarid_sucursalCierreRolMensual() {
		return this.cargarid_sucursalCierreRolMensual;
	}

	public void setCargarid_sucursalCierreRolMensual(Boolean cargarid_sucursalCierreRolMensual) {
		this.cargarid_sucursalCierreRolMensual= cargarid_sucursalCierreRolMensual;
	}

	public Border setResaltarid_ejercicioCierreRolMensual(ParametroGeneralUsuario parametroGeneralUsuario/*CierreRolMensualBeanSwingJInternalFrame cierrerolmensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cierrerolmensualBeanSwingJInternalFrame.jTtoolBarCierreRolMensual.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioCierreRolMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioCierreRolMensual() {
		return this.resaltarid_ejercicioCierreRolMensual;
	}

	public void setResaltarid_ejercicioCierreRolMensual(Border borderResaltar) {
		this.resaltarid_ejercicioCierreRolMensual= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioCierreRolMensual() {
		return this.mostrarid_ejercicioCierreRolMensual;
	}

	public void setMostrarid_ejercicioCierreRolMensual(Boolean mostrarid_ejercicioCierreRolMensual) {
		this.mostrarid_ejercicioCierreRolMensual= mostrarid_ejercicioCierreRolMensual;
	}

	public Boolean getActivarid_ejercicioCierreRolMensual() {
		return this.activarid_ejercicioCierreRolMensual;
	}

	public void setActivarid_ejercicioCierreRolMensual(Boolean activarid_ejercicioCierreRolMensual) {
		this.activarid_ejercicioCierreRolMensual= activarid_ejercicioCierreRolMensual;
	}

	public Boolean getCargarid_ejercicioCierreRolMensual() {
		return this.cargarid_ejercicioCierreRolMensual;
	}

	public void setCargarid_ejercicioCierreRolMensual(Boolean cargarid_ejercicioCierreRolMensual) {
		this.cargarid_ejercicioCierreRolMensual= cargarid_ejercicioCierreRolMensual;
	}

	public Border setResaltarid_empleadoCierreRolMensual(ParametroGeneralUsuario parametroGeneralUsuario/*CierreRolMensualBeanSwingJInternalFrame cierrerolmensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cierrerolmensualBeanSwingJInternalFrame.jTtoolBarCierreRolMensual.setBorder(borderResaltar);
		
		this.resaltarid_empleadoCierreRolMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoCierreRolMensual() {
		return this.resaltarid_empleadoCierreRolMensual;
	}

	public void setResaltarid_empleadoCierreRolMensual(Border borderResaltar) {
		this.resaltarid_empleadoCierreRolMensual= borderResaltar;
	}

	public Boolean getMostrarid_empleadoCierreRolMensual() {
		return this.mostrarid_empleadoCierreRolMensual;
	}

	public void setMostrarid_empleadoCierreRolMensual(Boolean mostrarid_empleadoCierreRolMensual) {
		this.mostrarid_empleadoCierreRolMensual= mostrarid_empleadoCierreRolMensual;
	}

	public Boolean getActivarid_empleadoCierreRolMensual() {
		return this.activarid_empleadoCierreRolMensual;
	}

	public void setActivarid_empleadoCierreRolMensual(Boolean activarid_empleadoCierreRolMensual) {
		this.activarid_empleadoCierreRolMensual= activarid_empleadoCierreRolMensual;
	}

	public Boolean getCargarid_empleadoCierreRolMensual() {
		return this.cargarid_empleadoCierreRolMensual;
	}

	public void setCargarid_empleadoCierreRolMensual(Boolean cargarid_empleadoCierreRolMensual) {
		this.cargarid_empleadoCierreRolMensual= cargarid_empleadoCierreRolMensual;
	}

	public Border setResaltarid_estructuraCierreRolMensual(ParametroGeneralUsuario parametroGeneralUsuario/*CierreRolMensualBeanSwingJInternalFrame cierrerolmensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cierrerolmensualBeanSwingJInternalFrame.jTtoolBarCierreRolMensual.setBorder(borderResaltar);
		
		this.resaltarid_estructuraCierreRolMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraCierreRolMensual() {
		return this.resaltarid_estructuraCierreRolMensual;
	}

	public void setResaltarid_estructuraCierreRolMensual(Border borderResaltar) {
		this.resaltarid_estructuraCierreRolMensual= borderResaltar;
	}

	public Boolean getMostrarid_estructuraCierreRolMensual() {
		return this.mostrarid_estructuraCierreRolMensual;
	}

	public void setMostrarid_estructuraCierreRolMensual(Boolean mostrarid_estructuraCierreRolMensual) {
		this.mostrarid_estructuraCierreRolMensual= mostrarid_estructuraCierreRolMensual;
	}

	public Boolean getActivarid_estructuraCierreRolMensual() {
		return this.activarid_estructuraCierreRolMensual;
	}

	public void setActivarid_estructuraCierreRolMensual(Boolean activarid_estructuraCierreRolMensual) {
		this.activarid_estructuraCierreRolMensual= activarid_estructuraCierreRolMensual;
	}

	public Boolean getCargarid_estructuraCierreRolMensual() {
		return this.cargarid_estructuraCierreRolMensual;
	}

	public void setCargarid_estructuraCierreRolMensual(Boolean cargarid_estructuraCierreRolMensual) {
		this.cargarid_estructuraCierreRolMensual= cargarid_estructuraCierreRolMensual;
	}

	public Border setResaltarid_estado_empleadoCierreRolMensual(ParametroGeneralUsuario parametroGeneralUsuario/*CierreRolMensualBeanSwingJInternalFrame cierrerolmensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cierrerolmensualBeanSwingJInternalFrame.jTtoolBarCierreRolMensual.setBorder(borderResaltar);
		
		this.resaltarid_estado_empleadoCierreRolMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_empleadoCierreRolMensual() {
		return this.resaltarid_estado_empleadoCierreRolMensual;
	}

	public void setResaltarid_estado_empleadoCierreRolMensual(Border borderResaltar) {
		this.resaltarid_estado_empleadoCierreRolMensual= borderResaltar;
	}

	public Boolean getMostrarid_estado_empleadoCierreRolMensual() {
		return this.mostrarid_estado_empleadoCierreRolMensual;
	}

	public void setMostrarid_estado_empleadoCierreRolMensual(Boolean mostrarid_estado_empleadoCierreRolMensual) {
		this.mostrarid_estado_empleadoCierreRolMensual= mostrarid_estado_empleadoCierreRolMensual;
	}

	public Boolean getActivarid_estado_empleadoCierreRolMensual() {
		return this.activarid_estado_empleadoCierreRolMensual;
	}

	public void setActivarid_estado_empleadoCierreRolMensual(Boolean activarid_estado_empleadoCierreRolMensual) {
		this.activarid_estado_empleadoCierreRolMensual= activarid_estado_empleadoCierreRolMensual;
	}

	public Boolean getCargarid_estado_empleadoCierreRolMensual() {
		return this.cargarid_estado_empleadoCierreRolMensual;
	}

	public void setCargarid_estado_empleadoCierreRolMensual(Boolean cargarid_estado_empleadoCierreRolMensual) {
		this.cargarid_estado_empleadoCierreRolMensual= cargarid_estado_empleadoCierreRolMensual;
	}

	public Border setResaltarid_asiento_contableCierreRolMensual(ParametroGeneralUsuario parametroGeneralUsuario/*CierreRolMensualBeanSwingJInternalFrame cierrerolmensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cierrerolmensualBeanSwingJInternalFrame.jTtoolBarCierreRolMensual.setBorder(borderResaltar);
		
		this.resaltarid_asiento_contableCierreRolMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contableCierreRolMensual() {
		return this.resaltarid_asiento_contableCierreRolMensual;
	}

	public void setResaltarid_asiento_contableCierreRolMensual(Border borderResaltar) {
		this.resaltarid_asiento_contableCierreRolMensual= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contableCierreRolMensual() {
		return this.mostrarid_asiento_contableCierreRolMensual;
	}

	public void setMostrarid_asiento_contableCierreRolMensual(Boolean mostrarid_asiento_contableCierreRolMensual) {
		this.mostrarid_asiento_contableCierreRolMensual= mostrarid_asiento_contableCierreRolMensual;
	}

	public Boolean getActivarid_asiento_contableCierreRolMensual() {
		return this.activarid_asiento_contableCierreRolMensual;
	}

	public void setActivarid_asiento_contableCierreRolMensual(Boolean activarid_asiento_contableCierreRolMensual) {
		this.activarid_asiento_contableCierreRolMensual= activarid_asiento_contableCierreRolMensual;
	}

	public Boolean getCargarid_asiento_contableCierreRolMensual() {
		return this.cargarid_asiento_contableCierreRolMensual;
	}

	public void setCargarid_asiento_contableCierreRolMensual(Boolean cargarid_asiento_contableCierreRolMensual) {
		this.cargarid_asiento_contableCierreRolMensual= cargarid_asiento_contableCierreRolMensual;
	}

	public Border setResaltarporcentajeCierreRolMensual(ParametroGeneralUsuario parametroGeneralUsuario/*CierreRolMensualBeanSwingJInternalFrame cierrerolmensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cierrerolmensualBeanSwingJInternalFrame.jTtoolBarCierreRolMensual.setBorder(borderResaltar);
		
		this.resaltarporcentajeCierreRolMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeCierreRolMensual() {
		return this.resaltarporcentajeCierreRolMensual;
	}

	public void setResaltarporcentajeCierreRolMensual(Border borderResaltar) {
		this.resaltarporcentajeCierreRolMensual= borderResaltar;
	}

	public Boolean getMostrarporcentajeCierreRolMensual() {
		return this.mostrarporcentajeCierreRolMensual;
	}

	public void setMostrarporcentajeCierreRolMensual(Boolean mostrarporcentajeCierreRolMensual) {
		this.mostrarporcentajeCierreRolMensual= mostrarporcentajeCierreRolMensual;
	}

	public Boolean getActivarporcentajeCierreRolMensual() {
		return this.activarporcentajeCierreRolMensual;
	}

	public void setActivarporcentajeCierreRolMensual(Boolean activarporcentajeCierreRolMensual) {
		this.activarporcentajeCierreRolMensual= activarporcentajeCierreRolMensual;
	}

	public Border setResaltarfechaCierreRolMensual(ParametroGeneralUsuario parametroGeneralUsuario/*CierreRolMensualBeanSwingJInternalFrame cierrerolmensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cierrerolmensualBeanSwingJInternalFrame.jTtoolBarCierreRolMensual.setBorder(borderResaltar);
		
		this.resaltarfechaCierreRolMensual= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaCierreRolMensual() {
		return this.resaltarfechaCierreRolMensual;
	}

	public void setResaltarfechaCierreRolMensual(Border borderResaltar) {
		this.resaltarfechaCierreRolMensual= borderResaltar;
	}

	public Boolean getMostrarfechaCierreRolMensual() {
		return this.mostrarfechaCierreRolMensual;
	}

	public void setMostrarfechaCierreRolMensual(Boolean mostrarfechaCierreRolMensual) {
		this.mostrarfechaCierreRolMensual= mostrarfechaCierreRolMensual;
	}

	public Boolean getActivarfechaCierreRolMensual() {
		return this.activarfechaCierreRolMensual;
	}

	public void setActivarfechaCierreRolMensual(Boolean activarfechaCierreRolMensual) {
		this.activarfechaCierreRolMensual= activarfechaCierreRolMensual;
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
		
		
		this.setMostraridCierreRolMensual(esInicial);
		this.setMostrarid_empresaCierreRolMensual(esInicial);
		this.setMostrarid_sucursalCierreRolMensual(esInicial);
		this.setMostrarid_ejercicioCierreRolMensual(esInicial);
		this.setMostrarid_empleadoCierreRolMensual(esInicial);
		this.setMostrarid_estructuraCierreRolMensual(esInicial);
		this.setMostrarid_estado_empleadoCierreRolMensual(esInicial);
		this.setMostrarid_asiento_contableCierreRolMensual(esInicial);
		this.setMostrarporcentajeCierreRolMensual(esInicial);
		this.setMostrarfechaCierreRolMensual(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.ID)) {
				this.setMostraridCierreRolMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCierreRolMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalCierreRolMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioCierreRolMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoCierreRolMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraCierreRolMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.IDESTADOEMPLEADO)) {
				this.setMostrarid_estado_empleadoCierreRolMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contableCierreRolMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeCierreRolMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.FECHA)) {
				this.setMostrarfechaCierreRolMensual(esAsigna);
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
		
		
		this.setActivaridCierreRolMensual(esInicial);
		this.setActivarid_empresaCierreRolMensual(esInicial);
		this.setActivarid_sucursalCierreRolMensual(esInicial);
		this.setActivarid_ejercicioCierreRolMensual(esInicial);
		this.setActivarid_empleadoCierreRolMensual(esInicial);
		this.setActivarid_estructuraCierreRolMensual(esInicial);
		this.setActivarid_estado_empleadoCierreRolMensual(esInicial);
		this.setActivarid_asiento_contableCierreRolMensual(esInicial);
		this.setActivarporcentajeCierreRolMensual(esInicial);
		this.setActivarfechaCierreRolMensual(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.ID)) {
				this.setActivaridCierreRolMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCierreRolMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalCierreRolMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioCierreRolMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoCierreRolMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraCierreRolMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.IDESTADOEMPLEADO)) {
				this.setActivarid_estado_empleadoCierreRolMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contableCierreRolMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeCierreRolMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.FECHA)) {
				this.setActivarfechaCierreRolMensual(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CierreRolMensualBeanSwingJInternalFrame cierrerolmensualBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCierreRolMensual(esInicial);
		this.setResaltarid_empresaCierreRolMensual(esInicial);
		this.setResaltarid_sucursalCierreRolMensual(esInicial);
		this.setResaltarid_ejercicioCierreRolMensual(esInicial);
		this.setResaltarid_empleadoCierreRolMensual(esInicial);
		this.setResaltarid_estructuraCierreRolMensual(esInicial);
		this.setResaltarid_estado_empleadoCierreRolMensual(esInicial);
		this.setResaltarid_asiento_contableCierreRolMensual(esInicial);
		this.setResaltarporcentajeCierreRolMensual(esInicial);
		this.setResaltarfechaCierreRolMensual(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.ID)) {
				this.setResaltaridCierreRolMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCierreRolMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalCierreRolMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioCierreRolMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoCierreRolMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraCierreRolMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.IDESTADOEMPLEADO)) {
				this.setResaltarid_estado_empleadoCierreRolMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contableCierreRolMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeCierreRolMensual(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreRolMensualConstantesFunciones.FECHA)) {
				this.setResaltarfechaCierreRolMensual(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CierreRolMensualBeanSwingJInternalFrame cierrerolmensualBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAsientoContableCierreRolMensual=true;

	public Boolean getMostrarFK_IdAsientoContableCierreRolMensual() {
		return this.mostrarFK_IdAsientoContableCierreRolMensual;
	}

	public void setMostrarFK_IdAsientoContableCierreRolMensual(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContableCierreRolMensual= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCierreRolMensualCierreRolMensual=true;

	public Boolean getMostrarFK_IdCierreRolMensualCierreRolMensual() {
		return this.mostrarFK_IdCierreRolMensualCierreRolMensual;
	}

	public void setMostrarFK_IdCierreRolMensualCierreRolMensual(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCierreRolMensualCierreRolMensual= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioCierreRolMensual=true;

	public Boolean getMostrarFK_IdEjercicioCierreRolMensual() {
		return this.mostrarFK_IdEjercicioCierreRolMensual;
	}

	public void setMostrarFK_IdEjercicioCierreRolMensual(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioCierreRolMensual= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoCierreRolMensual=true;

	public Boolean getMostrarFK_IdEmpleadoCierreRolMensual() {
		return this.mostrarFK_IdEmpleadoCierreRolMensual;
	}

	public void setMostrarFK_IdEmpleadoCierreRolMensual(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoCierreRolMensual= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCierreRolMensual=true;

	public Boolean getMostrarFK_IdEmpresaCierreRolMensual() {
		return this.mostrarFK_IdEmpresaCierreRolMensual;
	}

	public void setMostrarFK_IdEmpresaCierreRolMensual(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCierreRolMensual= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoEmpleadoCierreRolMensual=true;

	public Boolean getMostrarFK_IdEstadoEmpleadoCierreRolMensual() {
		return this.mostrarFK_IdEstadoEmpleadoCierreRolMensual;
	}

	public void setMostrarFK_IdEstadoEmpleadoCierreRolMensual(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoEmpleadoCierreRolMensual= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalCierreRolMensual=true;

	public Boolean getMostrarFK_IdSucursalCierreRolMensual() {
		return this.mostrarFK_IdSucursalCierreRolMensual;
	}

	public void setMostrarFK_IdSucursalCierreRolMensual(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalCierreRolMensual= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAsientoContableCierreRolMensual=true;

	public Boolean getActivarFK_IdAsientoContableCierreRolMensual() {
		return this.activarFK_IdAsientoContableCierreRolMensual;
	}

	public void setActivarFK_IdAsientoContableCierreRolMensual(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContableCierreRolMensual= habilitarResaltar;
	}

	public Boolean activarFK_IdCierreRolMensualCierreRolMensual=true;

	public Boolean getActivarFK_IdCierreRolMensualCierreRolMensual() {
		return this.activarFK_IdCierreRolMensualCierreRolMensual;
	}

	public void setActivarFK_IdCierreRolMensualCierreRolMensual(Boolean habilitarResaltar) {
		this.activarFK_IdCierreRolMensualCierreRolMensual= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioCierreRolMensual=true;

	public Boolean getActivarFK_IdEjercicioCierreRolMensual() {
		return this.activarFK_IdEjercicioCierreRolMensual;
	}

	public void setActivarFK_IdEjercicioCierreRolMensual(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioCierreRolMensual= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoCierreRolMensual=true;

	public Boolean getActivarFK_IdEmpleadoCierreRolMensual() {
		return this.activarFK_IdEmpleadoCierreRolMensual;
	}

	public void setActivarFK_IdEmpleadoCierreRolMensual(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoCierreRolMensual= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCierreRolMensual=true;

	public Boolean getActivarFK_IdEmpresaCierreRolMensual() {
		return this.activarFK_IdEmpresaCierreRolMensual;
	}

	public void setActivarFK_IdEmpresaCierreRolMensual(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCierreRolMensual= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoEmpleadoCierreRolMensual=true;

	public Boolean getActivarFK_IdEstadoEmpleadoCierreRolMensual() {
		return this.activarFK_IdEstadoEmpleadoCierreRolMensual;
	}

	public void setActivarFK_IdEstadoEmpleadoCierreRolMensual(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoEmpleadoCierreRolMensual= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalCierreRolMensual=true;

	public Boolean getActivarFK_IdSucursalCierreRolMensual() {
		return this.activarFK_IdSucursalCierreRolMensual;
	}

	public void setActivarFK_IdSucursalCierreRolMensual(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalCierreRolMensual= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAsientoContableCierreRolMensual=null;

	public Border getResaltarFK_IdAsientoContableCierreRolMensual() {
		return this.resaltarFK_IdAsientoContableCierreRolMensual;
	}

	public void setResaltarFK_IdAsientoContableCierreRolMensual(Border borderResaltar) {
		this.resaltarFK_IdAsientoContableCierreRolMensual= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContableCierreRolMensual(ParametroGeneralUsuario parametroGeneralUsuario/*CierreRolMensualBeanSwingJInternalFrame cierrerolmensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContableCierreRolMensual= borderResaltar;
	}

	public Border resaltarFK_IdCierreRolMensualCierreRolMensual=null;

	public Border getResaltarFK_IdCierreRolMensualCierreRolMensual() {
		return this.resaltarFK_IdCierreRolMensualCierreRolMensual;
	}

	public void setResaltarFK_IdCierreRolMensualCierreRolMensual(Border borderResaltar) {
		this.resaltarFK_IdCierreRolMensualCierreRolMensual= borderResaltar;
	}

	public void setResaltarFK_IdCierreRolMensualCierreRolMensual(ParametroGeneralUsuario parametroGeneralUsuario/*CierreRolMensualBeanSwingJInternalFrame cierrerolmensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCierreRolMensualCierreRolMensual= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioCierreRolMensual=null;

	public Border getResaltarFK_IdEjercicioCierreRolMensual() {
		return this.resaltarFK_IdEjercicioCierreRolMensual;
	}

	public void setResaltarFK_IdEjercicioCierreRolMensual(Border borderResaltar) {
		this.resaltarFK_IdEjercicioCierreRolMensual= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioCierreRolMensual(ParametroGeneralUsuario parametroGeneralUsuario/*CierreRolMensualBeanSwingJInternalFrame cierrerolmensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioCierreRolMensual= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoCierreRolMensual=null;

	public Border getResaltarFK_IdEmpleadoCierreRolMensual() {
		return this.resaltarFK_IdEmpleadoCierreRolMensual;
	}

	public void setResaltarFK_IdEmpleadoCierreRolMensual(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoCierreRolMensual= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoCierreRolMensual(ParametroGeneralUsuario parametroGeneralUsuario/*CierreRolMensualBeanSwingJInternalFrame cierrerolmensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoCierreRolMensual= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCierreRolMensual=null;

	public Border getResaltarFK_IdEmpresaCierreRolMensual() {
		return this.resaltarFK_IdEmpresaCierreRolMensual;
	}

	public void setResaltarFK_IdEmpresaCierreRolMensual(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCierreRolMensual= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCierreRolMensual(ParametroGeneralUsuario parametroGeneralUsuario/*CierreRolMensualBeanSwingJInternalFrame cierrerolmensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCierreRolMensual= borderResaltar;
	}

	public Border resaltarFK_IdEstadoEmpleadoCierreRolMensual=null;

	public Border getResaltarFK_IdEstadoEmpleadoCierreRolMensual() {
		return this.resaltarFK_IdEstadoEmpleadoCierreRolMensual;
	}

	public void setResaltarFK_IdEstadoEmpleadoCierreRolMensual(Border borderResaltar) {
		this.resaltarFK_IdEstadoEmpleadoCierreRolMensual= borderResaltar;
	}

	public void setResaltarFK_IdEstadoEmpleadoCierreRolMensual(ParametroGeneralUsuario parametroGeneralUsuario/*CierreRolMensualBeanSwingJInternalFrame cierrerolmensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoEmpleadoCierreRolMensual= borderResaltar;
	}

	public Border resaltarFK_IdSucursalCierreRolMensual=null;

	public Border getResaltarFK_IdSucursalCierreRolMensual() {
		return this.resaltarFK_IdSucursalCierreRolMensual;
	}

	public void setResaltarFK_IdSucursalCierreRolMensual(Border borderResaltar) {
		this.resaltarFK_IdSucursalCierreRolMensual= borderResaltar;
	}

	public void setResaltarFK_IdSucursalCierreRolMensual(ParametroGeneralUsuario parametroGeneralUsuario/*CierreRolMensualBeanSwingJInternalFrame cierrerolmensualBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalCierreRolMensual= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}