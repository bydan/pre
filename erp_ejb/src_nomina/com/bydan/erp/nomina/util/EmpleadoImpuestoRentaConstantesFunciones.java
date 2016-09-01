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


import com.bydan.erp.nomina.util.EmpleadoImpuestoRentaConstantesFunciones;
import com.bydan.erp.nomina.util.EmpleadoImpuestoRentaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EmpleadoImpuestoRentaParameterGeneral;

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
final public class EmpleadoImpuestoRentaConstantesFunciones extends EmpleadoImpuestoRentaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EmpleadoImpuestoRenta";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EmpleadoImpuestoRenta"+EmpleadoImpuestoRentaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EmpleadoImpuestoRentaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EmpleadoImpuestoRentaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"_"+EmpleadoImpuestoRentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EmpleadoImpuestoRentaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"_"+EmpleadoImpuestoRentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"_"+EmpleadoImpuestoRentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EmpleadoImpuestoRentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"_"+EmpleadoImpuestoRentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoImpuestoRentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpleadoImpuestoRentaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoImpuestoRentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoImpuestoRentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpleadoImpuestoRentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoImpuestoRentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EmpleadoImpuestoRentaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EmpleadoImpuestoRentaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EmpleadoImpuestoRentaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EmpleadoImpuestoRentaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Empleado Impuesto Rentas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Empleado Impuesto Renta";
	public static final String SCLASSWEBTITULO_LOWER="Empleado Impuesto Renta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EmpleadoImpuestoRenta";
	public static final String OBJECTNAME="empleadoimpuestorenta";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="empleado_impuesto_renta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select empleadoimpuestorenta from "+EmpleadoImpuestoRentaConstantesFunciones.SPERSISTENCENAME+" empleadoimpuestorenta";
	public static String QUERYSELECTNATIVE="select "+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME+".id,"+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME+".version_row,"+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME+".id_empresa,"+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME+".id_empleado,"+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME+".id_anio,"+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME+".id_mes,"+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME+".id_estructura,"+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME+".fecha,"+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME+".valor_pago,"+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME+".ingreso_liquido,"+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME+".aporte_iess from "+EmpleadoImpuestoRentaConstantesFunciones.SCHEMA+"."+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME;//+" as "+EmpleadoImpuestoRentaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EmpleadoImpuestoRentaConstantesFuncionesAdditional empleadoimpuestorentaConstantesFuncionesAdditional=null;
	
	public EmpleadoImpuestoRentaConstantesFuncionesAdditional getEmpleadoImpuestoRentaConstantesFuncionesAdditional() {
		return this.empleadoimpuestorentaConstantesFuncionesAdditional;
	}
	
	public void setEmpleadoImpuestoRentaConstantesFuncionesAdditional(EmpleadoImpuestoRentaConstantesFuncionesAdditional empleadoimpuestorentaConstantesFuncionesAdditional) {
		try {
			this.empleadoimpuestorentaConstantesFuncionesAdditional=empleadoimpuestorentaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String IDESTRUCTURA= "id_estructura";
    public static final String FECHA= "fecha";
    public static final String VALORPAGO= "valor_pago";
    public static final String INGRESOLIQUIDO= "ingreso_liquido";
    public static final String APORTEIESS= "aporte_iess";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_IDESTRUCTURA= "Estructura";
		public static final String LABEL_IDESTRUCTURA_LOWER= "Estructura";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_VALORPAGO= "Valor Pago";
		public static final String LABEL_VALORPAGO_LOWER= "Valor Pago";
    	public static final String LABEL_INGRESOLIQUIDO= "Ingreso Liquo";
		public static final String LABEL_INGRESOLIQUIDO_LOWER= "Ingreso Liquido";
    	public static final String LABEL_APORTEIESS= "Aporte Iess";
		public static final String LABEL_APORTEIESS_LOWER= "Aporte Iess";
	
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getEmpleadoImpuestoRentaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EmpleadoImpuestoRentaConstantesFunciones.IDEMPRESA)) {sLabelColumna=EmpleadoImpuestoRentaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EmpleadoImpuestoRentaConstantesFunciones.IDEMPLEADO)) {sLabelColumna=EmpleadoImpuestoRentaConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(EmpleadoImpuestoRentaConstantesFunciones.IDANIO)) {sLabelColumna=EmpleadoImpuestoRentaConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(EmpleadoImpuestoRentaConstantesFunciones.IDMES)) {sLabelColumna=EmpleadoImpuestoRentaConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(EmpleadoImpuestoRentaConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=EmpleadoImpuestoRentaConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(EmpleadoImpuestoRentaConstantesFunciones.FECHA)) {sLabelColumna=EmpleadoImpuestoRentaConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(EmpleadoImpuestoRentaConstantesFunciones.VALORPAGO)) {sLabelColumna=EmpleadoImpuestoRentaConstantesFunciones.LABEL_VALORPAGO;}
		if(sNombreColumna.equals(EmpleadoImpuestoRentaConstantesFunciones.INGRESOLIQUIDO)) {sLabelColumna=EmpleadoImpuestoRentaConstantesFunciones.LABEL_INGRESOLIQUIDO;}
		if(sNombreColumna.equals(EmpleadoImpuestoRentaConstantesFunciones.APORTEIESS)) {sLabelColumna=EmpleadoImpuestoRentaConstantesFunciones.LABEL_APORTEIESS;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getEmpleadoImpuestoRentaDescripcion(EmpleadoImpuestoRenta empleadoimpuestorenta) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(empleadoimpuestorenta !=null/* && empleadoimpuestorenta.getId()!=0*/) {
			if(empleadoimpuestorenta.getId()!=null) {
				sDescripcion=empleadoimpuestorenta.getId().toString();
			}//empleadoimpuestorentaempleadoimpuestorenta.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getEmpleadoImpuestoRentaDescripcionDetallado(EmpleadoImpuestoRenta empleadoimpuestorenta) {
		String sDescripcion="";
			
		sDescripcion+=EmpleadoImpuestoRentaConstantesFunciones.ID+"=";
		sDescripcion+=empleadoimpuestorenta.getId().toString()+",";
		sDescripcion+=EmpleadoImpuestoRentaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=empleadoimpuestorenta.getVersionRow().toString()+",";
		sDescripcion+=EmpleadoImpuestoRentaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=empleadoimpuestorenta.getid_empresa().toString()+",";
		sDescripcion+=EmpleadoImpuestoRentaConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=empleadoimpuestorenta.getid_empleado().toString()+",";
		sDescripcion+=EmpleadoImpuestoRentaConstantesFunciones.IDANIO+"=";
		sDescripcion+=empleadoimpuestorenta.getid_anio().toString()+",";
		sDescripcion+=EmpleadoImpuestoRentaConstantesFunciones.IDMES+"=";
		sDescripcion+=empleadoimpuestorenta.getid_mes().toString()+",";
		sDescripcion+=EmpleadoImpuestoRentaConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=empleadoimpuestorenta.getid_estructura().toString()+",";
		sDescripcion+=EmpleadoImpuestoRentaConstantesFunciones.FECHA+"=";
		sDescripcion+=empleadoimpuestorenta.getfecha().toString()+",";
		sDescripcion+=EmpleadoImpuestoRentaConstantesFunciones.VALORPAGO+"=";
		sDescripcion+=empleadoimpuestorenta.getvalor_pago().toString()+",";
		sDescripcion+=EmpleadoImpuestoRentaConstantesFunciones.INGRESOLIQUIDO+"=";
		sDescripcion+=empleadoimpuestorenta.getingreso_liquido().toString()+",";
		sDescripcion+=EmpleadoImpuestoRentaConstantesFunciones.APORTEIESS+"=";
		sDescripcion+=empleadoimpuestorenta.getaporte_iess().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setEmpleadoImpuestoRentaDescripcion(EmpleadoImpuestoRenta empleadoimpuestorenta,String sValor) throws Exception {			
		if(empleadoimpuestorenta !=null) {
			//empleadoimpuestorentaempleadoimpuestorenta.getId().toString();
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

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstructura")) {
			sNombreIndice="Tipo=  Por Estructura";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

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

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEmpleadoImpuestoRenta(EmpleadoImpuestoRenta empleadoimpuestorenta,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosEmpleadoImpuestoRentas(List<EmpleadoImpuestoRenta> empleadoimpuestorentas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EmpleadoImpuestoRenta empleadoimpuestorenta: empleadoimpuestorentas) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpleadoImpuestoRenta(EmpleadoImpuestoRenta empleadoimpuestorenta,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && empleadoimpuestorenta.getConCambioAuxiliar()) {
			empleadoimpuestorenta.setIsDeleted(empleadoimpuestorenta.getIsDeletedAuxiliar());	
			empleadoimpuestorenta.setIsNew(empleadoimpuestorenta.getIsNewAuxiliar());	
			empleadoimpuestorenta.setIsChanged(empleadoimpuestorenta.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			empleadoimpuestorenta.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			empleadoimpuestorenta.setIsDeletedAuxiliar(false);	
			empleadoimpuestorenta.setIsNewAuxiliar(false);	
			empleadoimpuestorenta.setIsChangedAuxiliar(false);
			
			empleadoimpuestorenta.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpleadoImpuestoRentas(List<EmpleadoImpuestoRenta> empleadoimpuestorentas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EmpleadoImpuestoRenta empleadoimpuestorenta : empleadoimpuestorentas) {
			if(conAsignarBase && empleadoimpuestorenta.getConCambioAuxiliar()) {
				empleadoimpuestorenta.setIsDeleted(empleadoimpuestorenta.getIsDeletedAuxiliar());	
				empleadoimpuestorenta.setIsNew(empleadoimpuestorenta.getIsNewAuxiliar());	
				empleadoimpuestorenta.setIsChanged(empleadoimpuestorenta.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				empleadoimpuestorenta.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				empleadoimpuestorenta.setIsDeletedAuxiliar(false);	
				empleadoimpuestorenta.setIsNewAuxiliar(false);	
				empleadoimpuestorenta.setIsChangedAuxiliar(false);
				
				empleadoimpuestorenta.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEmpleadoImpuestoRenta(EmpleadoImpuestoRenta empleadoimpuestorenta,Boolean conEnteros) throws Exception  {
		empleadoimpuestorenta.setvalor_pago(0.0);
		empleadoimpuestorenta.setingreso_liquido(0.0);
		empleadoimpuestorenta.setaporte_iess(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEmpleadoImpuestoRentas(List<EmpleadoImpuestoRenta> empleadoimpuestorentas,Boolean conEnteros) throws Exception  {
		
		for(EmpleadoImpuestoRenta empleadoimpuestorenta: empleadoimpuestorentas) {
			empleadoimpuestorenta.setvalor_pago(0.0);
			empleadoimpuestorenta.setingreso_liquido(0.0);
			empleadoimpuestorenta.setaporte_iess(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEmpleadoImpuestoRenta(List<EmpleadoImpuestoRenta> empleadoimpuestorentas,EmpleadoImpuestoRenta empleadoimpuestorentaAux) throws Exception  {
		EmpleadoImpuestoRentaConstantesFunciones.InicializarValoresEmpleadoImpuestoRenta(empleadoimpuestorentaAux,true);
		
		for(EmpleadoImpuestoRenta empleadoimpuestorenta: empleadoimpuestorentas) {
			if(empleadoimpuestorenta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			empleadoimpuestorentaAux.setvalor_pago(empleadoimpuestorentaAux.getvalor_pago()+empleadoimpuestorenta.getvalor_pago());			
			empleadoimpuestorentaAux.setingreso_liquido(empleadoimpuestorentaAux.getingreso_liquido()+empleadoimpuestorenta.getingreso_liquido());			
			empleadoimpuestorentaAux.setaporte_iess(empleadoimpuestorentaAux.getaporte_iess()+empleadoimpuestorenta.getaporte_iess());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpleadoImpuestoRenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EmpleadoImpuestoRentaConstantesFunciones.getArrayColumnasGlobalesEmpleadoImpuestoRenta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpleadoImpuestoRenta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EmpleadoImpuestoRentaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EmpleadoImpuestoRentaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEmpleadoImpuestoRenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EmpleadoImpuestoRenta> empleadoimpuestorentas,EmpleadoImpuestoRenta empleadoimpuestorenta,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EmpleadoImpuestoRenta empleadoimpuestorentaAux: empleadoimpuestorentas) {
			if(empleadoimpuestorentaAux!=null && empleadoimpuestorenta!=null) {
				if((empleadoimpuestorentaAux.getId()==null && empleadoimpuestorenta.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(empleadoimpuestorentaAux.getId()!=null && empleadoimpuestorenta.getId()!=null){
					if(empleadoimpuestorentaAux.getId().equals(empleadoimpuestorenta.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEmpleadoImpuestoRenta(List<EmpleadoImpuestoRenta> empleadoimpuestorentas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_pagoTotal=0.0;
		Double ingreso_liquidoTotal=0.0;
		Double aporte_iessTotal=0.0;
	
		for(EmpleadoImpuestoRenta empleadoimpuestorenta: empleadoimpuestorentas) {			
			if(empleadoimpuestorenta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_pagoTotal+=empleadoimpuestorenta.getvalor_pago();
			ingreso_liquidoTotal+=empleadoimpuestorenta.getingreso_liquido();
			aporte_iessTotal+=empleadoimpuestorenta.getaporte_iess();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EmpleadoImpuestoRentaConstantesFunciones.VALORPAGO);
		datoGeneral.setsDescripcion(EmpleadoImpuestoRentaConstantesFunciones.LABEL_VALORPAGO);
		datoGeneral.setdValorDouble(valor_pagoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EmpleadoImpuestoRentaConstantesFunciones.INGRESOLIQUIDO);
		datoGeneral.setsDescripcion(EmpleadoImpuestoRentaConstantesFunciones.LABEL_INGRESOLIQUIDO);
		datoGeneral.setdValorDouble(ingreso_liquidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EmpleadoImpuestoRentaConstantesFunciones.APORTEIESS);
		datoGeneral.setsDescripcion(EmpleadoImpuestoRentaConstantesFunciones.LABEL_APORTEIESS);
		datoGeneral.setdValorDouble(aporte_iessTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEmpleadoImpuestoRenta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EmpleadoImpuestoRentaConstantesFunciones.LABEL_ID, EmpleadoImpuestoRentaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoImpuestoRentaConstantesFunciones.LABEL_VERSIONROW, EmpleadoImpuestoRentaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoImpuestoRentaConstantesFunciones.LABEL_IDEMPRESA, EmpleadoImpuestoRentaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoImpuestoRentaConstantesFunciones.LABEL_IDEMPLEADO, EmpleadoImpuestoRentaConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoImpuestoRentaConstantesFunciones.LABEL_IDANIO, EmpleadoImpuestoRentaConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoImpuestoRentaConstantesFunciones.LABEL_IDMES, EmpleadoImpuestoRentaConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoImpuestoRentaConstantesFunciones.LABEL_IDESTRUCTURA, EmpleadoImpuestoRentaConstantesFunciones.IDESTRUCTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoImpuestoRentaConstantesFunciones.LABEL_FECHA, EmpleadoImpuestoRentaConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoImpuestoRentaConstantesFunciones.LABEL_VALORPAGO, EmpleadoImpuestoRentaConstantesFunciones.VALORPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoImpuestoRentaConstantesFunciones.LABEL_INGRESOLIQUIDO, EmpleadoImpuestoRentaConstantesFunciones.INGRESOLIQUIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoImpuestoRentaConstantesFunciones.LABEL_APORTEIESS, EmpleadoImpuestoRentaConstantesFunciones.APORTEIESS,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEmpleadoImpuestoRenta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EmpleadoImpuestoRentaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoImpuestoRentaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoImpuestoRentaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoImpuestoRentaConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoImpuestoRentaConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoImpuestoRentaConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoImpuestoRentaConstantesFunciones.IDESTRUCTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoImpuestoRentaConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoImpuestoRentaConstantesFunciones.VALORPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoImpuestoRentaConstantesFunciones.INGRESOLIQUIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoImpuestoRentaConstantesFunciones.APORTEIESS;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoImpuestoRenta() throws Exception  {
		return EmpleadoImpuestoRentaConstantesFunciones.getTiposSeleccionarEmpleadoImpuestoRenta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoImpuestoRenta(Boolean conFk) throws Exception  {
		return EmpleadoImpuestoRentaConstantesFunciones.getTiposSeleccionarEmpleadoImpuestoRenta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoImpuestoRenta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoImpuestoRentaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EmpleadoImpuestoRentaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoImpuestoRentaConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(EmpleadoImpuestoRentaConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoImpuestoRentaConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(EmpleadoImpuestoRentaConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoImpuestoRentaConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(EmpleadoImpuestoRentaConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoImpuestoRentaConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(EmpleadoImpuestoRentaConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoImpuestoRentaConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(EmpleadoImpuestoRentaConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoImpuestoRentaConstantesFunciones.LABEL_VALORPAGO);
			reporte.setsDescripcion(EmpleadoImpuestoRentaConstantesFunciones.LABEL_VALORPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoImpuestoRentaConstantesFunciones.LABEL_INGRESOLIQUIDO);
			reporte.setsDescripcion(EmpleadoImpuestoRentaConstantesFunciones.LABEL_INGRESOLIQUIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoImpuestoRentaConstantesFunciones.LABEL_APORTEIESS);
			reporte.setsDescripcion(EmpleadoImpuestoRentaConstantesFunciones.LABEL_APORTEIESS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEmpleadoImpuestoRenta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(EmpleadoImpuestoRenta empleadoimpuestorentaAux) throws Exception {
		
			empleadoimpuestorentaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(empleadoimpuestorentaAux.getEmpresa()));
			empleadoimpuestorentaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleadoimpuestorentaAux.getEmpleado()));
			empleadoimpuestorentaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(empleadoimpuestorentaAux.getAnio()));
			empleadoimpuestorentaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(empleadoimpuestorentaAux.getMes()));
			empleadoimpuestorentaAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(empleadoimpuestorentaAux.getEstructura()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEmpleadoImpuestoRenta(List<EmpleadoImpuestoRenta> empleadoimpuestorentasTemp) throws Exception {
		for(EmpleadoImpuestoRenta empleadoimpuestorentaAux:empleadoimpuestorentasTemp) {
			
			empleadoimpuestorentaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(empleadoimpuestorentaAux.getEmpresa()));
			empleadoimpuestorentaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleadoimpuestorentaAux.getEmpleado()));
			empleadoimpuestorentaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(empleadoimpuestorentaAux.getAnio()));
			empleadoimpuestorentaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(empleadoimpuestorentaAux.getMes()));
			empleadoimpuestorentaAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(empleadoimpuestorentaAux.getEstructura()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEmpleadoImpuestoRenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Estructura.class));
				
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
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEmpleadoImpuestoRenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
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

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoImpuestoRenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpleadoImpuestoRentaConstantesFunciones.getClassesRelationshipsOfEmpleadoImpuestoRenta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoImpuestoRenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpleadoImpuestoRenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpleadoImpuestoRentaConstantesFunciones.getClassesRelationshipsFromStringsOfEmpleadoImpuestoRenta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpleadoImpuestoRenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(EmpleadoImpuestoRenta empleadoimpuestorenta,List<EmpleadoImpuestoRenta> empleadoimpuestorentas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EmpleadoImpuestoRenta empleadoimpuestorentaEncontrado=null;
			
			for(EmpleadoImpuestoRenta empleadoimpuestorentaLocal:empleadoimpuestorentas) {
				if(empleadoimpuestorentaLocal.getId().equals(empleadoimpuestorenta.getId())) {
					empleadoimpuestorentaEncontrado=empleadoimpuestorentaLocal;
					
					empleadoimpuestorentaLocal.setIsChanged(empleadoimpuestorenta.getIsChanged());
					empleadoimpuestorentaLocal.setIsNew(empleadoimpuestorenta.getIsNew());
					empleadoimpuestorentaLocal.setIsDeleted(empleadoimpuestorenta.getIsDeleted());
					
					empleadoimpuestorentaLocal.setGeneralEntityOriginal(empleadoimpuestorenta.getGeneralEntityOriginal());
					
					empleadoimpuestorentaLocal.setId(empleadoimpuestorenta.getId());	
					empleadoimpuestorentaLocal.setVersionRow(empleadoimpuestorenta.getVersionRow());	
					empleadoimpuestorentaLocal.setid_empresa(empleadoimpuestorenta.getid_empresa());	
					empleadoimpuestorentaLocal.setid_empleado(empleadoimpuestorenta.getid_empleado());	
					empleadoimpuestorentaLocal.setid_anio(empleadoimpuestorenta.getid_anio());	
					empleadoimpuestorentaLocal.setid_mes(empleadoimpuestorenta.getid_mes());	
					empleadoimpuestorentaLocal.setid_estructura(empleadoimpuestorenta.getid_estructura());	
					empleadoimpuestorentaLocal.setfecha(empleadoimpuestorenta.getfecha());	
					empleadoimpuestorentaLocal.setvalor_pago(empleadoimpuestorenta.getvalor_pago());	
					empleadoimpuestorentaLocal.setingreso_liquido(empleadoimpuestorenta.getingreso_liquido());	
					empleadoimpuestorentaLocal.setaporte_iess(empleadoimpuestorenta.getaporte_iess());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!empleadoimpuestorenta.getIsDeleted()) {
				if(!existe) {
					empleadoimpuestorentas.add(empleadoimpuestorenta);
				}
			} else {
				if(empleadoimpuestorentaEncontrado!=null && permiteQuitar)  {
					empleadoimpuestorentas.remove(empleadoimpuestorentaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EmpleadoImpuestoRenta empleadoimpuestorenta,List<EmpleadoImpuestoRenta> empleadoimpuestorentas) throws Exception {
		try	{			
			for(EmpleadoImpuestoRenta empleadoimpuestorentaLocal:empleadoimpuestorentas) {
				if(empleadoimpuestorentaLocal.getId().equals(empleadoimpuestorenta.getId())) {
					empleadoimpuestorentaLocal.setIsSelected(empleadoimpuestorenta.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEmpleadoImpuestoRenta(List<EmpleadoImpuestoRenta> empleadoimpuestorentasAux) throws Exception {
		//this.empleadoimpuestorentasAux=empleadoimpuestorentasAux;
		
		for(EmpleadoImpuestoRenta empleadoimpuestorentaAux:empleadoimpuestorentasAux) {
			if(empleadoimpuestorentaAux.getIsChanged()) {
				empleadoimpuestorentaAux.setIsChanged(false);
			}		
			
			if(empleadoimpuestorentaAux.getIsNew()) {
				empleadoimpuestorentaAux.setIsNew(false);
			}	
			
			if(empleadoimpuestorentaAux.getIsDeleted()) {
				empleadoimpuestorentaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEmpleadoImpuestoRenta(EmpleadoImpuestoRenta empleadoimpuestorentaAux) throws Exception {
		//this.empleadoimpuestorentaAux=empleadoimpuestorentaAux;
		
			if(empleadoimpuestorentaAux.getIsChanged()) {
				empleadoimpuestorentaAux.setIsChanged(false);
			}		
			
			if(empleadoimpuestorentaAux.getIsNew()) {
				empleadoimpuestorentaAux.setIsNew(false);
			}	
			
			if(empleadoimpuestorentaAux.getIsDeleted()) {
				empleadoimpuestorentaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EmpleadoImpuestoRenta empleadoimpuestorentaAsignar,EmpleadoImpuestoRenta empleadoimpuestorenta) throws Exception {
		empleadoimpuestorentaAsignar.setId(empleadoimpuestorenta.getId());	
		empleadoimpuestorentaAsignar.setVersionRow(empleadoimpuestorenta.getVersionRow());	
		empleadoimpuestorentaAsignar.setid_empresa(empleadoimpuestorenta.getid_empresa());
		empleadoimpuestorentaAsignar.setempresa_descripcion(empleadoimpuestorenta.getempresa_descripcion());	
		empleadoimpuestorentaAsignar.setid_empleado(empleadoimpuestorenta.getid_empleado());
		empleadoimpuestorentaAsignar.setempleado_descripcion(empleadoimpuestorenta.getempleado_descripcion());	
		empleadoimpuestorentaAsignar.setid_anio(empleadoimpuestorenta.getid_anio());
		empleadoimpuestorentaAsignar.setanio_descripcion(empleadoimpuestorenta.getanio_descripcion());	
		empleadoimpuestorentaAsignar.setid_mes(empleadoimpuestorenta.getid_mes());
		empleadoimpuestorentaAsignar.setmes_descripcion(empleadoimpuestorenta.getmes_descripcion());	
		empleadoimpuestorentaAsignar.setid_estructura(empleadoimpuestorenta.getid_estructura());
		empleadoimpuestorentaAsignar.setestructura_descripcion(empleadoimpuestorenta.getestructura_descripcion());	
		empleadoimpuestorentaAsignar.setfecha(empleadoimpuestorenta.getfecha());	
		empleadoimpuestorentaAsignar.setvalor_pago(empleadoimpuestorenta.getvalor_pago());	
		empleadoimpuestorentaAsignar.setingreso_liquido(empleadoimpuestorenta.getingreso_liquido());	
		empleadoimpuestorentaAsignar.setaporte_iess(empleadoimpuestorenta.getaporte_iess());	
	}
	
	public static void inicializarEmpleadoImpuestoRenta(EmpleadoImpuestoRenta empleadoimpuestorenta) throws Exception {
		try {
				empleadoimpuestorenta.setId(0L);	
					
				empleadoimpuestorenta.setid_empresa(-1L);	
				empleadoimpuestorenta.setid_empleado(-1L);	
				empleadoimpuestorenta.setid_anio(null);	
				empleadoimpuestorenta.setid_mes(null);	
				empleadoimpuestorenta.setid_estructura(-1L);	
				empleadoimpuestorenta.setfecha(new Date());	
				empleadoimpuestorenta.setvalor_pago(0.0);	
				empleadoimpuestorenta.setingreso_liquido(0.0);	
				empleadoimpuestorenta.setaporte_iess(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEmpleadoImpuestoRenta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoImpuestoRentaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoImpuestoRentaConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoImpuestoRentaConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoImpuestoRentaConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoImpuestoRentaConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoImpuestoRentaConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoImpuestoRentaConstantesFunciones.LABEL_VALORPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoImpuestoRentaConstantesFunciones.LABEL_INGRESOLIQUIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoImpuestoRentaConstantesFunciones.LABEL_APORTEIESS);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEmpleadoImpuestoRenta(String sTipo,Row row,Workbook workbook,EmpleadoImpuestoRenta empleadoimpuestorenta,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoimpuestorenta.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoimpuestorenta.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoimpuestorenta.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoimpuestorenta.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoimpuestorenta.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoimpuestorenta.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoimpuestorenta.getvalor_pago());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoimpuestorenta.getingreso_liquido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadoimpuestorenta.getaporte_iess());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEmpleadoImpuestoRenta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEmpleadoImpuestoRenta() {
		return this.sFinalQueryEmpleadoImpuestoRenta;
	}
	
	public void setsFinalQueryEmpleadoImpuestoRenta(String sFinalQueryEmpleadoImpuestoRenta) {
		this.sFinalQueryEmpleadoImpuestoRenta= sFinalQueryEmpleadoImpuestoRenta;
	}
	
	public Border resaltarSeleccionarEmpleadoImpuestoRenta=null;
	
	public Border setResaltarSeleccionarEmpleadoImpuestoRenta(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoImpuestoRentaBeanSwingJInternalFrame empleadoimpuestorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//empleadoimpuestorentaBeanSwingJInternalFrame.jTtoolBarEmpleadoImpuestoRenta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEmpleadoImpuestoRenta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEmpleadoImpuestoRenta() {
		return this.resaltarSeleccionarEmpleadoImpuestoRenta;
	}
	
	public void setResaltarSeleccionarEmpleadoImpuestoRenta(Border borderResaltarSeleccionarEmpleadoImpuestoRenta) {
		this.resaltarSeleccionarEmpleadoImpuestoRenta= borderResaltarSeleccionarEmpleadoImpuestoRenta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEmpleadoImpuestoRenta=null;
	public Boolean mostraridEmpleadoImpuestoRenta=true;
	public Boolean activaridEmpleadoImpuestoRenta=true;

	public Border resaltarid_empresaEmpleadoImpuestoRenta=null;
	public Boolean mostrarid_empresaEmpleadoImpuestoRenta=true;
	public Boolean activarid_empresaEmpleadoImpuestoRenta=true;
	public Boolean cargarid_empresaEmpleadoImpuestoRenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEmpleadoImpuestoRenta=false;//ConEventDepend=true

	public Border resaltarid_empleadoEmpleadoImpuestoRenta=null;
	public Boolean mostrarid_empleadoEmpleadoImpuestoRenta=true;
	public Boolean activarid_empleadoEmpleadoImpuestoRenta=true;
	public Boolean cargarid_empleadoEmpleadoImpuestoRenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoEmpleadoImpuestoRenta=false;//ConEventDepend=true

	public Border resaltarid_anioEmpleadoImpuestoRenta=null;
	public Boolean mostrarid_anioEmpleadoImpuestoRenta=true;
	public Boolean activarid_anioEmpleadoImpuestoRenta=true;
	public Boolean cargarid_anioEmpleadoImpuestoRenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioEmpleadoImpuestoRenta=false;//ConEventDepend=true

	public Border resaltarid_mesEmpleadoImpuestoRenta=null;
	public Boolean mostrarid_mesEmpleadoImpuestoRenta=true;
	public Boolean activarid_mesEmpleadoImpuestoRenta=true;
	public Boolean cargarid_mesEmpleadoImpuestoRenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesEmpleadoImpuestoRenta=false;//ConEventDepend=true

	public Border resaltarid_estructuraEmpleadoImpuestoRenta=null;
	public Boolean mostrarid_estructuraEmpleadoImpuestoRenta=true;
	public Boolean activarid_estructuraEmpleadoImpuestoRenta=true;
	public Boolean cargarid_estructuraEmpleadoImpuestoRenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraEmpleadoImpuestoRenta=false;//ConEventDepend=true

	public Border resaltarfechaEmpleadoImpuestoRenta=null;
	public Boolean mostrarfechaEmpleadoImpuestoRenta=true;
	public Boolean activarfechaEmpleadoImpuestoRenta=false;

	public Border resaltarvalor_pagoEmpleadoImpuestoRenta=null;
	public Boolean mostrarvalor_pagoEmpleadoImpuestoRenta=true;
	public Boolean activarvalor_pagoEmpleadoImpuestoRenta=true;

	public Border resaltaringreso_liquidoEmpleadoImpuestoRenta=null;
	public Boolean mostraringreso_liquidoEmpleadoImpuestoRenta=true;
	public Boolean activaringreso_liquidoEmpleadoImpuestoRenta=true;

	public Border resaltaraporte_iessEmpleadoImpuestoRenta=null;
	public Boolean mostraraporte_iessEmpleadoImpuestoRenta=true;
	public Boolean activaraporte_iessEmpleadoImpuestoRenta=true;

	
	

	public Border setResaltaridEmpleadoImpuestoRenta(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoImpuestoRentaBeanSwingJInternalFrame empleadoimpuestorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoimpuestorentaBeanSwingJInternalFrame.jTtoolBarEmpleadoImpuestoRenta.setBorder(borderResaltar);
		
		this.resaltaridEmpleadoImpuestoRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEmpleadoImpuestoRenta() {
		return this.resaltaridEmpleadoImpuestoRenta;
	}

	public void setResaltaridEmpleadoImpuestoRenta(Border borderResaltar) {
		this.resaltaridEmpleadoImpuestoRenta= borderResaltar;
	}

	public Boolean getMostraridEmpleadoImpuestoRenta() {
		return this.mostraridEmpleadoImpuestoRenta;
	}

	public void setMostraridEmpleadoImpuestoRenta(Boolean mostraridEmpleadoImpuestoRenta) {
		this.mostraridEmpleadoImpuestoRenta= mostraridEmpleadoImpuestoRenta;
	}

	public Boolean getActivaridEmpleadoImpuestoRenta() {
		return this.activaridEmpleadoImpuestoRenta;
	}

	public void setActivaridEmpleadoImpuestoRenta(Boolean activaridEmpleadoImpuestoRenta) {
		this.activaridEmpleadoImpuestoRenta= activaridEmpleadoImpuestoRenta;
	}

	public Border setResaltarid_empresaEmpleadoImpuestoRenta(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoImpuestoRentaBeanSwingJInternalFrame empleadoimpuestorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoimpuestorentaBeanSwingJInternalFrame.jTtoolBarEmpleadoImpuestoRenta.setBorder(borderResaltar);
		
		this.resaltarid_empresaEmpleadoImpuestoRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEmpleadoImpuestoRenta() {
		return this.resaltarid_empresaEmpleadoImpuestoRenta;
	}

	public void setResaltarid_empresaEmpleadoImpuestoRenta(Border borderResaltar) {
		this.resaltarid_empresaEmpleadoImpuestoRenta= borderResaltar;
	}

	public Boolean getMostrarid_empresaEmpleadoImpuestoRenta() {
		return this.mostrarid_empresaEmpleadoImpuestoRenta;
	}

	public void setMostrarid_empresaEmpleadoImpuestoRenta(Boolean mostrarid_empresaEmpleadoImpuestoRenta) {
		this.mostrarid_empresaEmpleadoImpuestoRenta= mostrarid_empresaEmpleadoImpuestoRenta;
	}

	public Boolean getActivarid_empresaEmpleadoImpuestoRenta() {
		return this.activarid_empresaEmpleadoImpuestoRenta;
	}

	public void setActivarid_empresaEmpleadoImpuestoRenta(Boolean activarid_empresaEmpleadoImpuestoRenta) {
		this.activarid_empresaEmpleadoImpuestoRenta= activarid_empresaEmpleadoImpuestoRenta;
	}

	public Boolean getCargarid_empresaEmpleadoImpuestoRenta() {
		return this.cargarid_empresaEmpleadoImpuestoRenta;
	}

	public void setCargarid_empresaEmpleadoImpuestoRenta(Boolean cargarid_empresaEmpleadoImpuestoRenta) {
		this.cargarid_empresaEmpleadoImpuestoRenta= cargarid_empresaEmpleadoImpuestoRenta;
	}

	public Border setResaltarid_empleadoEmpleadoImpuestoRenta(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoImpuestoRentaBeanSwingJInternalFrame empleadoimpuestorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoimpuestorentaBeanSwingJInternalFrame.jTtoolBarEmpleadoImpuestoRenta.setBorder(borderResaltar);
		
		this.resaltarid_empleadoEmpleadoImpuestoRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoEmpleadoImpuestoRenta() {
		return this.resaltarid_empleadoEmpleadoImpuestoRenta;
	}

	public void setResaltarid_empleadoEmpleadoImpuestoRenta(Border borderResaltar) {
		this.resaltarid_empleadoEmpleadoImpuestoRenta= borderResaltar;
	}

	public Boolean getMostrarid_empleadoEmpleadoImpuestoRenta() {
		return this.mostrarid_empleadoEmpleadoImpuestoRenta;
	}

	public void setMostrarid_empleadoEmpleadoImpuestoRenta(Boolean mostrarid_empleadoEmpleadoImpuestoRenta) {
		this.mostrarid_empleadoEmpleadoImpuestoRenta= mostrarid_empleadoEmpleadoImpuestoRenta;
	}

	public Boolean getActivarid_empleadoEmpleadoImpuestoRenta() {
		return this.activarid_empleadoEmpleadoImpuestoRenta;
	}

	public void setActivarid_empleadoEmpleadoImpuestoRenta(Boolean activarid_empleadoEmpleadoImpuestoRenta) {
		this.activarid_empleadoEmpleadoImpuestoRenta= activarid_empleadoEmpleadoImpuestoRenta;
	}

	public Boolean getCargarid_empleadoEmpleadoImpuestoRenta() {
		return this.cargarid_empleadoEmpleadoImpuestoRenta;
	}

	public void setCargarid_empleadoEmpleadoImpuestoRenta(Boolean cargarid_empleadoEmpleadoImpuestoRenta) {
		this.cargarid_empleadoEmpleadoImpuestoRenta= cargarid_empleadoEmpleadoImpuestoRenta;
	}

	public Border setResaltarid_anioEmpleadoImpuestoRenta(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoImpuestoRentaBeanSwingJInternalFrame empleadoimpuestorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoimpuestorentaBeanSwingJInternalFrame.jTtoolBarEmpleadoImpuestoRenta.setBorder(borderResaltar);
		
		this.resaltarid_anioEmpleadoImpuestoRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioEmpleadoImpuestoRenta() {
		return this.resaltarid_anioEmpleadoImpuestoRenta;
	}

	public void setResaltarid_anioEmpleadoImpuestoRenta(Border borderResaltar) {
		this.resaltarid_anioEmpleadoImpuestoRenta= borderResaltar;
	}

	public Boolean getMostrarid_anioEmpleadoImpuestoRenta() {
		return this.mostrarid_anioEmpleadoImpuestoRenta;
	}

	public void setMostrarid_anioEmpleadoImpuestoRenta(Boolean mostrarid_anioEmpleadoImpuestoRenta) {
		this.mostrarid_anioEmpleadoImpuestoRenta= mostrarid_anioEmpleadoImpuestoRenta;
	}

	public Boolean getActivarid_anioEmpleadoImpuestoRenta() {
		return this.activarid_anioEmpleadoImpuestoRenta;
	}

	public void setActivarid_anioEmpleadoImpuestoRenta(Boolean activarid_anioEmpleadoImpuestoRenta) {
		this.activarid_anioEmpleadoImpuestoRenta= activarid_anioEmpleadoImpuestoRenta;
	}

	public Boolean getCargarid_anioEmpleadoImpuestoRenta() {
		return this.cargarid_anioEmpleadoImpuestoRenta;
	}

	public void setCargarid_anioEmpleadoImpuestoRenta(Boolean cargarid_anioEmpleadoImpuestoRenta) {
		this.cargarid_anioEmpleadoImpuestoRenta= cargarid_anioEmpleadoImpuestoRenta;
	}

	public Border setResaltarid_mesEmpleadoImpuestoRenta(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoImpuestoRentaBeanSwingJInternalFrame empleadoimpuestorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoimpuestorentaBeanSwingJInternalFrame.jTtoolBarEmpleadoImpuestoRenta.setBorder(borderResaltar);
		
		this.resaltarid_mesEmpleadoImpuestoRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesEmpleadoImpuestoRenta() {
		return this.resaltarid_mesEmpleadoImpuestoRenta;
	}

	public void setResaltarid_mesEmpleadoImpuestoRenta(Border borderResaltar) {
		this.resaltarid_mesEmpleadoImpuestoRenta= borderResaltar;
	}

	public Boolean getMostrarid_mesEmpleadoImpuestoRenta() {
		return this.mostrarid_mesEmpleadoImpuestoRenta;
	}

	public void setMostrarid_mesEmpleadoImpuestoRenta(Boolean mostrarid_mesEmpleadoImpuestoRenta) {
		this.mostrarid_mesEmpleadoImpuestoRenta= mostrarid_mesEmpleadoImpuestoRenta;
	}

	public Boolean getActivarid_mesEmpleadoImpuestoRenta() {
		return this.activarid_mesEmpleadoImpuestoRenta;
	}

	public void setActivarid_mesEmpleadoImpuestoRenta(Boolean activarid_mesEmpleadoImpuestoRenta) {
		this.activarid_mesEmpleadoImpuestoRenta= activarid_mesEmpleadoImpuestoRenta;
	}

	public Boolean getCargarid_mesEmpleadoImpuestoRenta() {
		return this.cargarid_mesEmpleadoImpuestoRenta;
	}

	public void setCargarid_mesEmpleadoImpuestoRenta(Boolean cargarid_mesEmpleadoImpuestoRenta) {
		this.cargarid_mesEmpleadoImpuestoRenta= cargarid_mesEmpleadoImpuestoRenta;
	}

	public Border setResaltarid_estructuraEmpleadoImpuestoRenta(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoImpuestoRentaBeanSwingJInternalFrame empleadoimpuestorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoimpuestorentaBeanSwingJInternalFrame.jTtoolBarEmpleadoImpuestoRenta.setBorder(borderResaltar);
		
		this.resaltarid_estructuraEmpleadoImpuestoRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraEmpleadoImpuestoRenta() {
		return this.resaltarid_estructuraEmpleadoImpuestoRenta;
	}

	public void setResaltarid_estructuraEmpleadoImpuestoRenta(Border borderResaltar) {
		this.resaltarid_estructuraEmpleadoImpuestoRenta= borderResaltar;
	}

	public Boolean getMostrarid_estructuraEmpleadoImpuestoRenta() {
		return this.mostrarid_estructuraEmpleadoImpuestoRenta;
	}

	public void setMostrarid_estructuraEmpleadoImpuestoRenta(Boolean mostrarid_estructuraEmpleadoImpuestoRenta) {
		this.mostrarid_estructuraEmpleadoImpuestoRenta= mostrarid_estructuraEmpleadoImpuestoRenta;
	}

	public Boolean getActivarid_estructuraEmpleadoImpuestoRenta() {
		return this.activarid_estructuraEmpleadoImpuestoRenta;
	}

	public void setActivarid_estructuraEmpleadoImpuestoRenta(Boolean activarid_estructuraEmpleadoImpuestoRenta) {
		this.activarid_estructuraEmpleadoImpuestoRenta= activarid_estructuraEmpleadoImpuestoRenta;
	}

	public Boolean getCargarid_estructuraEmpleadoImpuestoRenta() {
		return this.cargarid_estructuraEmpleadoImpuestoRenta;
	}

	public void setCargarid_estructuraEmpleadoImpuestoRenta(Boolean cargarid_estructuraEmpleadoImpuestoRenta) {
		this.cargarid_estructuraEmpleadoImpuestoRenta= cargarid_estructuraEmpleadoImpuestoRenta;
	}

	public Border setResaltarfechaEmpleadoImpuestoRenta(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoImpuestoRentaBeanSwingJInternalFrame empleadoimpuestorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoimpuestorentaBeanSwingJInternalFrame.jTtoolBarEmpleadoImpuestoRenta.setBorder(borderResaltar);
		
		this.resaltarfechaEmpleadoImpuestoRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaEmpleadoImpuestoRenta() {
		return this.resaltarfechaEmpleadoImpuestoRenta;
	}

	public void setResaltarfechaEmpleadoImpuestoRenta(Border borderResaltar) {
		this.resaltarfechaEmpleadoImpuestoRenta= borderResaltar;
	}

	public Boolean getMostrarfechaEmpleadoImpuestoRenta() {
		return this.mostrarfechaEmpleadoImpuestoRenta;
	}

	public void setMostrarfechaEmpleadoImpuestoRenta(Boolean mostrarfechaEmpleadoImpuestoRenta) {
		this.mostrarfechaEmpleadoImpuestoRenta= mostrarfechaEmpleadoImpuestoRenta;
	}

	public Boolean getActivarfechaEmpleadoImpuestoRenta() {
		return this.activarfechaEmpleadoImpuestoRenta;
	}

	public void setActivarfechaEmpleadoImpuestoRenta(Boolean activarfechaEmpleadoImpuestoRenta) {
		this.activarfechaEmpleadoImpuestoRenta= activarfechaEmpleadoImpuestoRenta;
	}

	public Border setResaltarvalor_pagoEmpleadoImpuestoRenta(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoImpuestoRentaBeanSwingJInternalFrame empleadoimpuestorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoimpuestorentaBeanSwingJInternalFrame.jTtoolBarEmpleadoImpuestoRenta.setBorder(borderResaltar);
		
		this.resaltarvalor_pagoEmpleadoImpuestoRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_pagoEmpleadoImpuestoRenta() {
		return this.resaltarvalor_pagoEmpleadoImpuestoRenta;
	}

	public void setResaltarvalor_pagoEmpleadoImpuestoRenta(Border borderResaltar) {
		this.resaltarvalor_pagoEmpleadoImpuestoRenta= borderResaltar;
	}

	public Boolean getMostrarvalor_pagoEmpleadoImpuestoRenta() {
		return this.mostrarvalor_pagoEmpleadoImpuestoRenta;
	}

	public void setMostrarvalor_pagoEmpleadoImpuestoRenta(Boolean mostrarvalor_pagoEmpleadoImpuestoRenta) {
		this.mostrarvalor_pagoEmpleadoImpuestoRenta= mostrarvalor_pagoEmpleadoImpuestoRenta;
	}

	public Boolean getActivarvalor_pagoEmpleadoImpuestoRenta() {
		return this.activarvalor_pagoEmpleadoImpuestoRenta;
	}

	public void setActivarvalor_pagoEmpleadoImpuestoRenta(Boolean activarvalor_pagoEmpleadoImpuestoRenta) {
		this.activarvalor_pagoEmpleadoImpuestoRenta= activarvalor_pagoEmpleadoImpuestoRenta;
	}

	public Border setResaltaringreso_liquidoEmpleadoImpuestoRenta(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoImpuestoRentaBeanSwingJInternalFrame empleadoimpuestorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoimpuestorentaBeanSwingJInternalFrame.jTtoolBarEmpleadoImpuestoRenta.setBorder(borderResaltar);
		
		this.resaltaringreso_liquidoEmpleadoImpuestoRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaringreso_liquidoEmpleadoImpuestoRenta() {
		return this.resaltaringreso_liquidoEmpleadoImpuestoRenta;
	}

	public void setResaltaringreso_liquidoEmpleadoImpuestoRenta(Border borderResaltar) {
		this.resaltaringreso_liquidoEmpleadoImpuestoRenta= borderResaltar;
	}

	public Boolean getMostraringreso_liquidoEmpleadoImpuestoRenta() {
		return this.mostraringreso_liquidoEmpleadoImpuestoRenta;
	}

	public void setMostraringreso_liquidoEmpleadoImpuestoRenta(Boolean mostraringreso_liquidoEmpleadoImpuestoRenta) {
		this.mostraringreso_liquidoEmpleadoImpuestoRenta= mostraringreso_liquidoEmpleadoImpuestoRenta;
	}

	public Boolean getActivaringreso_liquidoEmpleadoImpuestoRenta() {
		return this.activaringreso_liquidoEmpleadoImpuestoRenta;
	}

	public void setActivaringreso_liquidoEmpleadoImpuestoRenta(Boolean activaringreso_liquidoEmpleadoImpuestoRenta) {
		this.activaringreso_liquidoEmpleadoImpuestoRenta= activaringreso_liquidoEmpleadoImpuestoRenta;
	}

	public Border setResaltaraporte_iessEmpleadoImpuestoRenta(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoImpuestoRentaBeanSwingJInternalFrame empleadoimpuestorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadoimpuestorentaBeanSwingJInternalFrame.jTtoolBarEmpleadoImpuestoRenta.setBorder(borderResaltar);
		
		this.resaltaraporte_iessEmpleadoImpuestoRenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaraporte_iessEmpleadoImpuestoRenta() {
		return this.resaltaraporte_iessEmpleadoImpuestoRenta;
	}

	public void setResaltaraporte_iessEmpleadoImpuestoRenta(Border borderResaltar) {
		this.resaltaraporte_iessEmpleadoImpuestoRenta= borderResaltar;
	}

	public Boolean getMostraraporte_iessEmpleadoImpuestoRenta() {
		return this.mostraraporte_iessEmpleadoImpuestoRenta;
	}

	public void setMostraraporte_iessEmpleadoImpuestoRenta(Boolean mostraraporte_iessEmpleadoImpuestoRenta) {
		this.mostraraporte_iessEmpleadoImpuestoRenta= mostraraporte_iessEmpleadoImpuestoRenta;
	}

	public Boolean getActivaraporte_iessEmpleadoImpuestoRenta() {
		return this.activaraporte_iessEmpleadoImpuestoRenta;
	}

	public void setActivaraporte_iessEmpleadoImpuestoRenta(Boolean activaraporte_iessEmpleadoImpuestoRenta) {
		this.activaraporte_iessEmpleadoImpuestoRenta= activaraporte_iessEmpleadoImpuestoRenta;
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
		
		
		this.setMostraridEmpleadoImpuestoRenta(esInicial);
		this.setMostrarid_empresaEmpleadoImpuestoRenta(esInicial);
		this.setMostrarid_empleadoEmpleadoImpuestoRenta(esInicial);
		this.setMostrarid_anioEmpleadoImpuestoRenta(esInicial);
		this.setMostrarid_mesEmpleadoImpuestoRenta(esInicial);
		this.setMostrarid_estructuraEmpleadoImpuestoRenta(esInicial);
		this.setMostrarfechaEmpleadoImpuestoRenta(esInicial);
		this.setMostrarvalor_pagoEmpleadoImpuestoRenta(esInicial);
		this.setMostraringreso_liquidoEmpleadoImpuestoRenta(esInicial);
		this.setMostraraporte_iessEmpleadoImpuestoRenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.ID)) {
				this.setMostraridEmpleadoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEmpleadoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoEmpleadoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioEmpleadoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.IDMES)) {
				this.setMostrarid_mesEmpleadoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraEmpleadoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.FECHA)) {
				this.setMostrarfechaEmpleadoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.VALORPAGO)) {
				this.setMostrarvalor_pagoEmpleadoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.INGRESOLIQUIDO)) {
				this.setMostraringreso_liquidoEmpleadoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.APORTEIESS)) {
				this.setMostraraporte_iessEmpleadoImpuestoRenta(esAsigna);
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
		
		
		this.setActivaridEmpleadoImpuestoRenta(esInicial);
		this.setActivarid_empresaEmpleadoImpuestoRenta(esInicial);
		this.setActivarid_empleadoEmpleadoImpuestoRenta(esInicial);
		this.setActivarid_anioEmpleadoImpuestoRenta(esInicial);
		this.setActivarid_mesEmpleadoImpuestoRenta(esInicial);
		this.setActivarid_estructuraEmpleadoImpuestoRenta(esInicial);
		this.setActivarfechaEmpleadoImpuestoRenta(esInicial);
		this.setActivarvalor_pagoEmpleadoImpuestoRenta(esInicial);
		this.setActivaringreso_liquidoEmpleadoImpuestoRenta(esInicial);
		this.setActivaraporte_iessEmpleadoImpuestoRenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.ID)) {
				this.setActivaridEmpleadoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEmpleadoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoEmpleadoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.IDANIO)) {
				this.setActivarid_anioEmpleadoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.IDMES)) {
				this.setActivarid_mesEmpleadoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraEmpleadoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.FECHA)) {
				this.setActivarfechaEmpleadoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.VALORPAGO)) {
				this.setActivarvalor_pagoEmpleadoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.INGRESOLIQUIDO)) {
				this.setActivaringreso_liquidoEmpleadoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.APORTEIESS)) {
				this.setActivaraporte_iessEmpleadoImpuestoRenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpleadoImpuestoRentaBeanSwingJInternalFrame empleadoimpuestorentaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEmpleadoImpuestoRenta(esInicial);
		this.setResaltarid_empresaEmpleadoImpuestoRenta(esInicial);
		this.setResaltarid_empleadoEmpleadoImpuestoRenta(esInicial);
		this.setResaltarid_anioEmpleadoImpuestoRenta(esInicial);
		this.setResaltarid_mesEmpleadoImpuestoRenta(esInicial);
		this.setResaltarid_estructuraEmpleadoImpuestoRenta(esInicial);
		this.setResaltarfechaEmpleadoImpuestoRenta(esInicial);
		this.setResaltarvalor_pagoEmpleadoImpuestoRenta(esInicial);
		this.setResaltaringreso_liquidoEmpleadoImpuestoRenta(esInicial);
		this.setResaltaraporte_iessEmpleadoImpuestoRenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.ID)) {
				this.setResaltaridEmpleadoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEmpleadoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoEmpleadoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioEmpleadoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.IDMES)) {
				this.setResaltarid_mesEmpleadoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraEmpleadoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.FECHA)) {
				this.setResaltarfechaEmpleadoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.VALORPAGO)) {
				this.setResaltarvalor_pagoEmpleadoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.INGRESOLIQUIDO)) {
				this.setResaltaringreso_liquidoEmpleadoImpuestoRenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoImpuestoRentaConstantesFunciones.APORTEIESS)) {
				this.setResaltaraporte_iessEmpleadoImpuestoRenta(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpleadoImpuestoRentaBeanSwingJInternalFrame empleadoimpuestorentaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAnioEmpleadoImpuestoRenta=true;

	public Boolean getMostrarFK_IdAnioEmpleadoImpuestoRenta() {
		return this.mostrarFK_IdAnioEmpleadoImpuestoRenta;
	}

	public void setMostrarFK_IdAnioEmpleadoImpuestoRenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAnioEmpleadoImpuestoRenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoEmpleadoImpuestoRenta=true;

	public Boolean getMostrarFK_IdEmpleadoEmpleadoImpuestoRenta() {
		return this.mostrarFK_IdEmpleadoEmpleadoImpuestoRenta;
	}

	public void setMostrarFK_IdEmpleadoEmpleadoImpuestoRenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoEmpleadoImpuestoRenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaEmpleadoImpuestoRenta=true;

	public Boolean getMostrarFK_IdEmpresaEmpleadoImpuestoRenta() {
		return this.mostrarFK_IdEmpresaEmpleadoImpuestoRenta;
	}

	public void setMostrarFK_IdEmpresaEmpleadoImpuestoRenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaEmpleadoImpuestoRenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstructuraEmpleadoImpuestoRenta=true;

	public Boolean getMostrarFK_IdEstructuraEmpleadoImpuestoRenta() {
		return this.mostrarFK_IdEstructuraEmpleadoImpuestoRenta;
	}

	public void setMostrarFK_IdEstructuraEmpleadoImpuestoRenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstructuraEmpleadoImpuestoRenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMesEmpleadoImpuestoRenta=true;

	public Boolean getMostrarFK_IdMesEmpleadoImpuestoRenta() {
		return this.mostrarFK_IdMesEmpleadoImpuestoRenta;
	}

	public void setMostrarFK_IdMesEmpleadoImpuestoRenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMesEmpleadoImpuestoRenta= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAnioEmpleadoImpuestoRenta=true;

	public Boolean getActivarFK_IdAnioEmpleadoImpuestoRenta() {
		return this.activarFK_IdAnioEmpleadoImpuestoRenta;
	}

	public void setActivarFK_IdAnioEmpleadoImpuestoRenta(Boolean habilitarResaltar) {
		this.activarFK_IdAnioEmpleadoImpuestoRenta= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoEmpleadoImpuestoRenta=true;

	public Boolean getActivarFK_IdEmpleadoEmpleadoImpuestoRenta() {
		return this.activarFK_IdEmpleadoEmpleadoImpuestoRenta;
	}

	public void setActivarFK_IdEmpleadoEmpleadoImpuestoRenta(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoEmpleadoImpuestoRenta= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaEmpleadoImpuestoRenta=true;

	public Boolean getActivarFK_IdEmpresaEmpleadoImpuestoRenta() {
		return this.activarFK_IdEmpresaEmpleadoImpuestoRenta;
	}

	public void setActivarFK_IdEmpresaEmpleadoImpuestoRenta(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaEmpleadoImpuestoRenta= habilitarResaltar;
	}

	public Boolean activarFK_IdEstructuraEmpleadoImpuestoRenta=true;

	public Boolean getActivarFK_IdEstructuraEmpleadoImpuestoRenta() {
		return this.activarFK_IdEstructuraEmpleadoImpuestoRenta;
	}

	public void setActivarFK_IdEstructuraEmpleadoImpuestoRenta(Boolean habilitarResaltar) {
		this.activarFK_IdEstructuraEmpleadoImpuestoRenta= habilitarResaltar;
	}

	public Boolean activarFK_IdMesEmpleadoImpuestoRenta=true;

	public Boolean getActivarFK_IdMesEmpleadoImpuestoRenta() {
		return this.activarFK_IdMesEmpleadoImpuestoRenta;
	}

	public void setActivarFK_IdMesEmpleadoImpuestoRenta(Boolean habilitarResaltar) {
		this.activarFK_IdMesEmpleadoImpuestoRenta= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAnioEmpleadoImpuestoRenta=null;

	public Border getResaltarFK_IdAnioEmpleadoImpuestoRenta() {
		return this.resaltarFK_IdAnioEmpleadoImpuestoRenta;
	}

	public void setResaltarFK_IdAnioEmpleadoImpuestoRenta(Border borderResaltar) {
		this.resaltarFK_IdAnioEmpleadoImpuestoRenta= borderResaltar;
	}

	public void setResaltarFK_IdAnioEmpleadoImpuestoRenta(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoImpuestoRentaBeanSwingJInternalFrame empleadoimpuestorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAnioEmpleadoImpuestoRenta= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoEmpleadoImpuestoRenta=null;

	public Border getResaltarFK_IdEmpleadoEmpleadoImpuestoRenta() {
		return this.resaltarFK_IdEmpleadoEmpleadoImpuestoRenta;
	}

	public void setResaltarFK_IdEmpleadoEmpleadoImpuestoRenta(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoEmpleadoImpuestoRenta= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoEmpleadoImpuestoRenta(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoImpuestoRentaBeanSwingJInternalFrame empleadoimpuestorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoEmpleadoImpuestoRenta= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaEmpleadoImpuestoRenta=null;

	public Border getResaltarFK_IdEmpresaEmpleadoImpuestoRenta() {
		return this.resaltarFK_IdEmpresaEmpleadoImpuestoRenta;
	}

	public void setResaltarFK_IdEmpresaEmpleadoImpuestoRenta(Border borderResaltar) {
		this.resaltarFK_IdEmpresaEmpleadoImpuestoRenta= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaEmpleadoImpuestoRenta(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoImpuestoRentaBeanSwingJInternalFrame empleadoimpuestorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaEmpleadoImpuestoRenta= borderResaltar;
	}

	public Border resaltarFK_IdEstructuraEmpleadoImpuestoRenta=null;

	public Border getResaltarFK_IdEstructuraEmpleadoImpuestoRenta() {
		return this.resaltarFK_IdEstructuraEmpleadoImpuestoRenta;
	}

	public void setResaltarFK_IdEstructuraEmpleadoImpuestoRenta(Border borderResaltar) {
		this.resaltarFK_IdEstructuraEmpleadoImpuestoRenta= borderResaltar;
	}

	public void setResaltarFK_IdEstructuraEmpleadoImpuestoRenta(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoImpuestoRentaBeanSwingJInternalFrame empleadoimpuestorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstructuraEmpleadoImpuestoRenta= borderResaltar;
	}

	public Border resaltarFK_IdMesEmpleadoImpuestoRenta=null;

	public Border getResaltarFK_IdMesEmpleadoImpuestoRenta() {
		return this.resaltarFK_IdMesEmpleadoImpuestoRenta;
	}

	public void setResaltarFK_IdMesEmpleadoImpuestoRenta(Border borderResaltar) {
		this.resaltarFK_IdMesEmpleadoImpuestoRenta= borderResaltar;
	}

	public void setResaltarFK_IdMesEmpleadoImpuestoRenta(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoImpuestoRentaBeanSwingJInternalFrame empleadoimpuestorentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMesEmpleadoImpuestoRenta= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}