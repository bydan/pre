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


import com.bydan.erp.nomina.util.EmpleadoPagoRubroConstantesFunciones;
import com.bydan.erp.nomina.util.EmpleadoPagoRubroParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EmpleadoPagoRubroParameterGeneral;

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
final public class EmpleadoPagoRubroConstantesFunciones extends EmpleadoPagoRubroConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EmpleadoPagoRubro";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EmpleadoPagoRubro"+EmpleadoPagoRubroConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EmpleadoPagoRubroHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EmpleadoPagoRubroHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EmpleadoPagoRubroConstantesFunciones.SCHEMA+"_"+EmpleadoPagoRubroConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EmpleadoPagoRubroHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EmpleadoPagoRubroConstantesFunciones.SCHEMA+"_"+EmpleadoPagoRubroConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EmpleadoPagoRubroConstantesFunciones.SCHEMA+"_"+EmpleadoPagoRubroConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EmpleadoPagoRubroHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EmpleadoPagoRubroConstantesFunciones.SCHEMA+"_"+EmpleadoPagoRubroConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoPagoRubroConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpleadoPagoRubroHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoPagoRubroConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoPagoRubroConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpleadoPagoRubroHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpleadoPagoRubroConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EmpleadoPagoRubroConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EmpleadoPagoRubroConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EmpleadoPagoRubroConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EmpleadoPagoRubroConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Empleado Pago Rubros";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Empleado Pago Rubro";
	public static final String SCLASSWEBTITULO_LOWER="Empleado Pago Rubro";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EmpleadoPagoRubro";
	public static final String OBJECTNAME="empleadopagorubro";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="empleado_pago_rubro";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select empleadopagorubro from "+EmpleadoPagoRubroConstantesFunciones.SPERSISTENCENAME+" empleadopagorubro";
	public static String QUERYSELECTNATIVE="select "+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME+".id,"+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME+".version_row,"+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME+".id_empresa,"+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME+".id_empleado,"+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME+".id_estructura,"+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME+".id_rubro_emplea,"+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME+".id_anio,"+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME+".id_mes,"+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME+".valor_pago,"+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME+".fecha,"+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME+".fecha_liquidacion from "+EmpleadoPagoRubroConstantesFunciones.SCHEMA+"."+EmpleadoPagoRubroConstantesFunciones.TABLENAME;//+" as "+EmpleadoPagoRubroConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EmpleadoPagoRubroConstantesFuncionesAdditional empleadopagorubroConstantesFuncionesAdditional=null;
	
	public EmpleadoPagoRubroConstantesFuncionesAdditional getEmpleadoPagoRubroConstantesFuncionesAdditional() {
		return this.empleadopagorubroConstantesFuncionesAdditional;
	}
	
	public void setEmpleadoPagoRubroConstantesFuncionesAdditional(EmpleadoPagoRubroConstantesFuncionesAdditional empleadopagorubroConstantesFuncionesAdditional) {
		try {
			this.empleadopagorubroConstantesFuncionesAdditional=empleadopagorubroConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDESTRUCTURA= "id_estructura";
    public static final String IDRUBROEMPLEA= "id_rubro_emplea";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String VALORPAGO= "valor_pago";
    public static final String FECHA= "fecha";
    public static final String FECHALIQUIDACION= "fecha_liquidacion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDESTRUCTURA= "Estructura";
		public static final String LABEL_IDESTRUCTURA_LOWER= "Estructura";
    	public static final String LABEL_IDRUBROEMPLEA= "Rubro Emplea";
		public static final String LABEL_IDRUBROEMPLEA_LOWER= "Rubro Emplea";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_VALORPAGO= "Valor Pago";
		public static final String LABEL_VALORPAGO_LOWER= "Valor Pago";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_FECHALIQUIDACION= "Fecha Liquacion";
		public static final String LABEL_FECHALIQUIDACION_LOWER= "Fecha Liquidacion";
	
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getEmpleadoPagoRubroLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EmpleadoPagoRubroConstantesFunciones.IDEMPRESA)) {sLabelColumna=EmpleadoPagoRubroConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EmpleadoPagoRubroConstantesFunciones.IDEMPLEADO)) {sLabelColumna=EmpleadoPagoRubroConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(EmpleadoPagoRubroConstantesFunciones.IDESTRUCTURA)) {sLabelColumna=EmpleadoPagoRubroConstantesFunciones.LABEL_IDESTRUCTURA;}
		if(sNombreColumna.equals(EmpleadoPagoRubroConstantesFunciones.IDRUBROEMPLEA)) {sLabelColumna=EmpleadoPagoRubroConstantesFunciones.LABEL_IDRUBROEMPLEA;}
		if(sNombreColumna.equals(EmpleadoPagoRubroConstantesFunciones.IDANIO)) {sLabelColumna=EmpleadoPagoRubroConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(EmpleadoPagoRubroConstantesFunciones.IDMES)) {sLabelColumna=EmpleadoPagoRubroConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(EmpleadoPagoRubroConstantesFunciones.VALORPAGO)) {sLabelColumna=EmpleadoPagoRubroConstantesFunciones.LABEL_VALORPAGO;}
		if(sNombreColumna.equals(EmpleadoPagoRubroConstantesFunciones.FECHA)) {sLabelColumna=EmpleadoPagoRubroConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(EmpleadoPagoRubroConstantesFunciones.FECHALIQUIDACION)) {sLabelColumna=EmpleadoPagoRubroConstantesFunciones.LABEL_FECHALIQUIDACION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getEmpleadoPagoRubroDescripcion(EmpleadoPagoRubro empleadopagorubro) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(empleadopagorubro !=null/* && empleadopagorubro.getId()!=0*/) {
			if(empleadopagorubro.getId()!=null) {
				sDescripcion=empleadopagorubro.getId().toString();
			}//empleadopagorubroempleadopagorubro.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getEmpleadoPagoRubroDescripcionDetallado(EmpleadoPagoRubro empleadopagorubro) {
		String sDescripcion="";
			
		sDescripcion+=EmpleadoPagoRubroConstantesFunciones.ID+"=";
		sDescripcion+=empleadopagorubro.getId().toString()+",";
		sDescripcion+=EmpleadoPagoRubroConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=empleadopagorubro.getVersionRow().toString()+",";
		sDescripcion+=EmpleadoPagoRubroConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=empleadopagorubro.getid_empresa().toString()+",";
		sDescripcion+=EmpleadoPagoRubroConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=empleadopagorubro.getid_empleado().toString()+",";
		sDescripcion+=EmpleadoPagoRubroConstantesFunciones.IDESTRUCTURA+"=";
		sDescripcion+=empleadopagorubro.getid_estructura().toString()+",";
		sDescripcion+=EmpleadoPagoRubroConstantesFunciones.IDRUBROEMPLEA+"=";
		sDescripcion+=empleadopagorubro.getid_rubro_emplea().toString()+",";
		sDescripcion+=EmpleadoPagoRubroConstantesFunciones.IDANIO+"=";
		sDescripcion+=empleadopagorubro.getid_anio().toString()+",";
		sDescripcion+=EmpleadoPagoRubroConstantesFunciones.IDMES+"=";
		sDescripcion+=empleadopagorubro.getid_mes().toString()+",";
		sDescripcion+=EmpleadoPagoRubroConstantesFunciones.VALORPAGO+"=";
		sDescripcion+=empleadopagorubro.getvalor_pago().toString()+",";
		sDescripcion+=EmpleadoPagoRubroConstantesFunciones.FECHA+"=";
		sDescripcion+=empleadopagorubro.getfecha().toString()+",";
		sDescripcion+=EmpleadoPagoRubroConstantesFunciones.FECHALIQUIDACION+"=";
		sDescripcion+=empleadopagorubro.getfecha_liquidacion().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setEmpleadoPagoRubroDescripcion(EmpleadoPagoRubro empleadopagorubro,String sValor) throws Exception {			
		if(empleadopagorubro !=null) {
			//empleadopagorubroempleadopagorubro.getId().toString();
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

	public static String getEstructuraDescripcion(Estructura estructura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estructura!=null/*&&estructura.getId()>0*/) {
			sDescripcion=EstructuraConstantesFunciones.getEstructuraDescripcion(estructura);
		}

		return sDescripcion;
	}

	public static String getRubroEmpleaDescripcion(RubroEmplea rubroemplea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(rubroemplea!=null/*&&rubroemplea.getId()>0*/) {
			sDescripcion=RubroEmpleaConstantesFunciones.getRubroEmpleaDescripcion(rubroemplea);
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
		} else if(sNombreIndice.equals("FK_IdRubroEmplea")) {
			sNombreIndice="Tipo=  Por Rubro Emplea";
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

	public static String getDetalleIndiceFK_IdRubroEmplea(Long id_rubro_emplea) {
		String sDetalleIndice=" Parametros->";
		if(id_rubro_emplea!=null) {sDetalleIndice+=" Codigo Unico De Rubro Emplea="+id_rubro_emplea.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEmpleadoPagoRubro(EmpleadoPagoRubro empleadopagorubro,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosEmpleadoPagoRubros(List<EmpleadoPagoRubro> empleadopagorubros,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EmpleadoPagoRubro empleadopagorubro: empleadopagorubros) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpleadoPagoRubro(EmpleadoPagoRubro empleadopagorubro,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && empleadopagorubro.getConCambioAuxiliar()) {
			empleadopagorubro.setIsDeleted(empleadopagorubro.getIsDeletedAuxiliar());	
			empleadopagorubro.setIsNew(empleadopagorubro.getIsNewAuxiliar());	
			empleadopagorubro.setIsChanged(empleadopagorubro.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			empleadopagorubro.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			empleadopagorubro.setIsDeletedAuxiliar(false);	
			empleadopagorubro.setIsNewAuxiliar(false);	
			empleadopagorubro.setIsChangedAuxiliar(false);
			
			empleadopagorubro.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpleadoPagoRubros(List<EmpleadoPagoRubro> empleadopagorubros,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EmpleadoPagoRubro empleadopagorubro : empleadopagorubros) {
			if(conAsignarBase && empleadopagorubro.getConCambioAuxiliar()) {
				empleadopagorubro.setIsDeleted(empleadopagorubro.getIsDeletedAuxiliar());	
				empleadopagorubro.setIsNew(empleadopagorubro.getIsNewAuxiliar());	
				empleadopagorubro.setIsChanged(empleadopagorubro.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				empleadopagorubro.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				empleadopagorubro.setIsDeletedAuxiliar(false);	
				empleadopagorubro.setIsNewAuxiliar(false);	
				empleadopagorubro.setIsChangedAuxiliar(false);
				
				empleadopagorubro.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEmpleadoPagoRubro(EmpleadoPagoRubro empleadopagorubro,Boolean conEnteros) throws Exception  {
		empleadopagorubro.setvalor_pago(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEmpleadoPagoRubros(List<EmpleadoPagoRubro> empleadopagorubros,Boolean conEnteros) throws Exception  {
		
		for(EmpleadoPagoRubro empleadopagorubro: empleadopagorubros) {
			empleadopagorubro.setvalor_pago(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEmpleadoPagoRubro(List<EmpleadoPagoRubro> empleadopagorubros,EmpleadoPagoRubro empleadopagorubroAux) throws Exception  {
		EmpleadoPagoRubroConstantesFunciones.InicializarValoresEmpleadoPagoRubro(empleadopagorubroAux,true);
		
		for(EmpleadoPagoRubro empleadopagorubro: empleadopagorubros) {
			if(empleadopagorubro.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			empleadopagorubroAux.setvalor_pago(empleadopagorubroAux.getvalor_pago()+empleadopagorubro.getvalor_pago());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpleadoPagoRubro(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EmpleadoPagoRubroConstantesFunciones.getArrayColumnasGlobalesEmpleadoPagoRubro(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpleadoPagoRubro(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EmpleadoPagoRubroConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EmpleadoPagoRubroConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEmpleadoPagoRubro(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EmpleadoPagoRubro> empleadopagorubros,EmpleadoPagoRubro empleadopagorubro,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EmpleadoPagoRubro empleadopagorubroAux: empleadopagorubros) {
			if(empleadopagorubroAux!=null && empleadopagorubro!=null) {
				if((empleadopagorubroAux.getId()==null && empleadopagorubro.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(empleadopagorubroAux.getId()!=null && empleadopagorubro.getId()!=null){
					if(empleadopagorubroAux.getId().equals(empleadopagorubro.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEmpleadoPagoRubro(List<EmpleadoPagoRubro> empleadopagorubros) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_pagoTotal=0.0;
	
		for(EmpleadoPagoRubro empleadopagorubro: empleadopagorubros) {			
			if(empleadopagorubro.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_pagoTotal+=empleadopagorubro.getvalor_pago();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EmpleadoPagoRubroConstantesFunciones.VALORPAGO);
		datoGeneral.setsDescripcion(EmpleadoPagoRubroConstantesFunciones.LABEL_VALORPAGO);
		datoGeneral.setdValorDouble(valor_pagoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEmpleadoPagoRubro() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EmpleadoPagoRubroConstantesFunciones.LABEL_ID, EmpleadoPagoRubroConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoPagoRubroConstantesFunciones.LABEL_VERSIONROW, EmpleadoPagoRubroConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoPagoRubroConstantesFunciones.LABEL_IDEMPRESA, EmpleadoPagoRubroConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoPagoRubroConstantesFunciones.LABEL_IDEMPLEADO, EmpleadoPagoRubroConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoPagoRubroConstantesFunciones.LABEL_IDESTRUCTURA, EmpleadoPagoRubroConstantesFunciones.IDESTRUCTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoPagoRubroConstantesFunciones.LABEL_IDRUBROEMPLEA, EmpleadoPagoRubroConstantesFunciones.IDRUBROEMPLEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoPagoRubroConstantesFunciones.LABEL_IDANIO, EmpleadoPagoRubroConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoPagoRubroConstantesFunciones.LABEL_IDMES, EmpleadoPagoRubroConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoPagoRubroConstantesFunciones.LABEL_VALORPAGO, EmpleadoPagoRubroConstantesFunciones.VALORPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoPagoRubroConstantesFunciones.LABEL_FECHA, EmpleadoPagoRubroConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpleadoPagoRubroConstantesFunciones.LABEL_FECHALIQUIDACION, EmpleadoPagoRubroConstantesFunciones.FECHALIQUIDACION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEmpleadoPagoRubro() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EmpleadoPagoRubroConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoPagoRubroConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoPagoRubroConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoPagoRubroConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoPagoRubroConstantesFunciones.IDESTRUCTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoPagoRubroConstantesFunciones.IDRUBROEMPLEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoPagoRubroConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoPagoRubroConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoPagoRubroConstantesFunciones.VALORPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoPagoRubroConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpleadoPagoRubroConstantesFunciones.FECHALIQUIDACION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoPagoRubro() throws Exception  {
		return EmpleadoPagoRubroConstantesFunciones.getTiposSeleccionarEmpleadoPagoRubro(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoPagoRubro(Boolean conFk) throws Exception  {
		return EmpleadoPagoRubroConstantesFunciones.getTiposSeleccionarEmpleadoPagoRubro(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpleadoPagoRubro(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoPagoRubroConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EmpleadoPagoRubroConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoPagoRubroConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(EmpleadoPagoRubroConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoPagoRubroConstantesFunciones.LABEL_IDESTRUCTURA);
			reporte.setsDescripcion(EmpleadoPagoRubroConstantesFunciones.LABEL_IDESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoPagoRubroConstantesFunciones.LABEL_IDRUBROEMPLEA);
			reporte.setsDescripcion(EmpleadoPagoRubroConstantesFunciones.LABEL_IDRUBROEMPLEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoPagoRubroConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(EmpleadoPagoRubroConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoPagoRubroConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(EmpleadoPagoRubroConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoPagoRubroConstantesFunciones.LABEL_VALORPAGO);
			reporte.setsDescripcion(EmpleadoPagoRubroConstantesFunciones.LABEL_VALORPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoPagoRubroConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(EmpleadoPagoRubroConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpleadoPagoRubroConstantesFunciones.LABEL_FECHALIQUIDACION);
			reporte.setsDescripcion(EmpleadoPagoRubroConstantesFunciones.LABEL_FECHALIQUIDACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEmpleadoPagoRubro(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEmpleadoPagoRubro(EmpleadoPagoRubro empleadopagorubroAux) throws Exception {
		
			empleadopagorubroAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(empleadopagorubroAux.getEmpresa()));
			empleadopagorubroAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleadopagorubroAux.getEmpleado()));
			empleadopagorubroAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(empleadopagorubroAux.getEstructura()));
			empleadopagorubroAux.setrubroemplea_descripcion(RubroEmpleaConstantesFunciones.getRubroEmpleaDescripcion(empleadopagorubroAux.getRubroEmplea()));
			empleadopagorubroAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(empleadopagorubroAux.getAnio()));
			empleadopagorubroAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(empleadopagorubroAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEmpleadoPagoRubro(List<EmpleadoPagoRubro> empleadopagorubrosTemp) throws Exception {
		for(EmpleadoPagoRubro empleadopagorubroAux:empleadopagorubrosTemp) {
			
			empleadopagorubroAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(empleadopagorubroAux.getEmpresa()));
			empleadopagorubroAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleadopagorubroAux.getEmpleado()));
			empleadopagorubroAux.setestructura_descripcion(EstructuraConstantesFunciones.getEstructuraDescripcion(empleadopagorubroAux.getEstructura()));
			empleadopagorubroAux.setrubroemplea_descripcion(RubroEmpleaConstantesFunciones.getRubroEmpleaDescripcion(empleadopagorubroAux.getRubroEmplea()));
			empleadopagorubroAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(empleadopagorubroAux.getAnio()));
			empleadopagorubroAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(empleadopagorubroAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEmpleadoPagoRubro(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(RubroEmplea.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				
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
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(RubroEmplea.class)) {
						classes.add(new Classe(RubroEmplea.class));
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEmpleadoPagoRubro(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(RubroEmplea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEmplea.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(RubroEmplea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RubroEmplea.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoPagoRubro(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpleadoPagoRubroConstantesFunciones.getClassesRelationshipsOfEmpleadoPagoRubro(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpleadoPagoRubro(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpleadoPagoRubro(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpleadoPagoRubroConstantesFunciones.getClassesRelationshipsFromStringsOfEmpleadoPagoRubro(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpleadoPagoRubro(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(EmpleadoPagoRubro empleadopagorubro,List<EmpleadoPagoRubro> empleadopagorubros,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EmpleadoPagoRubro empleadopagorubroEncontrado=null;
			
			for(EmpleadoPagoRubro empleadopagorubroLocal:empleadopagorubros) {
				if(empleadopagorubroLocal.getId().equals(empleadopagorubro.getId())) {
					empleadopagorubroEncontrado=empleadopagorubroLocal;
					
					empleadopagorubroLocal.setIsChanged(empleadopagorubro.getIsChanged());
					empleadopagorubroLocal.setIsNew(empleadopagorubro.getIsNew());
					empleadopagorubroLocal.setIsDeleted(empleadopagorubro.getIsDeleted());
					
					empleadopagorubroLocal.setGeneralEntityOriginal(empleadopagorubro.getGeneralEntityOriginal());
					
					empleadopagorubroLocal.setId(empleadopagorubro.getId());	
					empleadopagorubroLocal.setVersionRow(empleadopagorubro.getVersionRow());	
					empleadopagorubroLocal.setid_empresa(empleadopagorubro.getid_empresa());	
					empleadopagorubroLocal.setid_empleado(empleadopagorubro.getid_empleado());	
					empleadopagorubroLocal.setid_estructura(empleadopagorubro.getid_estructura());	
					empleadopagorubroLocal.setid_rubro_emplea(empleadopagorubro.getid_rubro_emplea());	
					empleadopagorubroLocal.setid_anio(empleadopagorubro.getid_anio());	
					empleadopagorubroLocal.setid_mes(empleadopagorubro.getid_mes());	
					empleadopagorubroLocal.setvalor_pago(empleadopagorubro.getvalor_pago());	
					empleadopagorubroLocal.setfecha(empleadopagorubro.getfecha());	
					empleadopagorubroLocal.setfecha_liquidacion(empleadopagorubro.getfecha_liquidacion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!empleadopagorubro.getIsDeleted()) {
				if(!existe) {
					empleadopagorubros.add(empleadopagorubro);
				}
			} else {
				if(empleadopagorubroEncontrado!=null && permiteQuitar)  {
					empleadopagorubros.remove(empleadopagorubroEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EmpleadoPagoRubro empleadopagorubro,List<EmpleadoPagoRubro> empleadopagorubros) throws Exception {
		try	{			
			for(EmpleadoPagoRubro empleadopagorubroLocal:empleadopagorubros) {
				if(empleadopagorubroLocal.getId().equals(empleadopagorubro.getId())) {
					empleadopagorubroLocal.setIsSelected(empleadopagorubro.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEmpleadoPagoRubro(List<EmpleadoPagoRubro> empleadopagorubrosAux) throws Exception {
		//this.empleadopagorubrosAux=empleadopagorubrosAux;
		
		for(EmpleadoPagoRubro empleadopagorubroAux:empleadopagorubrosAux) {
			if(empleadopagorubroAux.getIsChanged()) {
				empleadopagorubroAux.setIsChanged(false);
			}		
			
			if(empleadopagorubroAux.getIsNew()) {
				empleadopagorubroAux.setIsNew(false);
			}	
			
			if(empleadopagorubroAux.getIsDeleted()) {
				empleadopagorubroAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEmpleadoPagoRubro(EmpleadoPagoRubro empleadopagorubroAux) throws Exception {
		//this.empleadopagorubroAux=empleadopagorubroAux;
		
			if(empleadopagorubroAux.getIsChanged()) {
				empleadopagorubroAux.setIsChanged(false);
			}		
			
			if(empleadopagorubroAux.getIsNew()) {
				empleadopagorubroAux.setIsNew(false);
			}	
			
			if(empleadopagorubroAux.getIsDeleted()) {
				empleadopagorubroAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EmpleadoPagoRubro empleadopagorubroAsignar,EmpleadoPagoRubro empleadopagorubro) throws Exception {
		empleadopagorubroAsignar.setId(empleadopagorubro.getId());	
		empleadopagorubroAsignar.setVersionRow(empleadopagorubro.getVersionRow());	
		empleadopagorubroAsignar.setid_empresa(empleadopagorubro.getid_empresa());
		empleadopagorubroAsignar.setempresa_descripcion(empleadopagorubro.getempresa_descripcion());	
		empleadopagorubroAsignar.setid_empleado(empleadopagorubro.getid_empleado());
		empleadopagorubroAsignar.setempleado_descripcion(empleadopagorubro.getempleado_descripcion());	
		empleadopagorubroAsignar.setid_estructura(empleadopagorubro.getid_estructura());
		empleadopagorubroAsignar.setestructura_descripcion(empleadopagorubro.getestructura_descripcion());	
		empleadopagorubroAsignar.setid_rubro_emplea(empleadopagorubro.getid_rubro_emplea());
		empleadopagorubroAsignar.setrubroemplea_descripcion(empleadopagorubro.getrubroemplea_descripcion());	
		empleadopagorubroAsignar.setid_anio(empleadopagorubro.getid_anio());
		empleadopagorubroAsignar.setanio_descripcion(empleadopagorubro.getanio_descripcion());	
		empleadopagorubroAsignar.setid_mes(empleadopagorubro.getid_mes());
		empleadopagorubroAsignar.setmes_descripcion(empleadopagorubro.getmes_descripcion());	
		empleadopagorubroAsignar.setvalor_pago(empleadopagorubro.getvalor_pago());	
		empleadopagorubroAsignar.setfecha(empleadopagorubro.getfecha());	
		empleadopagorubroAsignar.setfecha_liquidacion(empleadopagorubro.getfecha_liquidacion());	
	}
	
	public static void inicializarEmpleadoPagoRubro(EmpleadoPagoRubro empleadopagorubro) throws Exception {
		try {
				empleadopagorubro.setId(0L);	
					
				empleadopagorubro.setid_empresa(-1L);	
				empleadopagorubro.setid_empleado(-1L);	
				empleadopagorubro.setid_estructura(-1L);	
				empleadopagorubro.setid_rubro_emplea(-1L);	
				empleadopagorubro.setid_anio(null);	
				empleadopagorubro.setid_mes(null);	
				empleadopagorubro.setvalor_pago(0.0);	
				empleadopagorubro.setfecha(new Date());	
				empleadopagorubro.setfecha_liquidacion(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEmpleadoPagoRubro(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoPagoRubroConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoPagoRubroConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoPagoRubroConstantesFunciones.LABEL_IDESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoPagoRubroConstantesFunciones.LABEL_IDRUBROEMPLEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoPagoRubroConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoPagoRubroConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoPagoRubroConstantesFunciones.LABEL_VALORPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoPagoRubroConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpleadoPagoRubroConstantesFunciones.LABEL_FECHALIQUIDACION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEmpleadoPagoRubro(String sTipo,Row row,Workbook workbook,EmpleadoPagoRubro empleadopagorubro,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadopagorubro.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadopagorubro.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadopagorubro.getestructura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadopagorubro.getrubroemplea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadopagorubro.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadopagorubro.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadopagorubro.getvalor_pago());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadopagorubro.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empleadopagorubro.getfecha_liquidacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEmpleadoPagoRubro=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEmpleadoPagoRubro() {
		return this.sFinalQueryEmpleadoPagoRubro;
	}
	
	public void setsFinalQueryEmpleadoPagoRubro(String sFinalQueryEmpleadoPagoRubro) {
		this.sFinalQueryEmpleadoPagoRubro= sFinalQueryEmpleadoPagoRubro;
	}
	
	public Border resaltarSeleccionarEmpleadoPagoRubro=null;
	
	public Border setResaltarSeleccionarEmpleadoPagoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoPagoRubroBeanSwingJInternalFrame empleadopagorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//empleadopagorubroBeanSwingJInternalFrame.jTtoolBarEmpleadoPagoRubro.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEmpleadoPagoRubro= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEmpleadoPagoRubro() {
		return this.resaltarSeleccionarEmpleadoPagoRubro;
	}
	
	public void setResaltarSeleccionarEmpleadoPagoRubro(Border borderResaltarSeleccionarEmpleadoPagoRubro) {
		this.resaltarSeleccionarEmpleadoPagoRubro= borderResaltarSeleccionarEmpleadoPagoRubro;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEmpleadoPagoRubro=null;
	public Boolean mostraridEmpleadoPagoRubro=true;
	public Boolean activaridEmpleadoPagoRubro=true;

	public Border resaltarid_empresaEmpleadoPagoRubro=null;
	public Boolean mostrarid_empresaEmpleadoPagoRubro=true;
	public Boolean activarid_empresaEmpleadoPagoRubro=true;
	public Boolean cargarid_empresaEmpleadoPagoRubro=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEmpleadoPagoRubro=false;//ConEventDepend=true

	public Border resaltarid_empleadoEmpleadoPagoRubro=null;
	public Boolean mostrarid_empleadoEmpleadoPagoRubro=true;
	public Boolean activarid_empleadoEmpleadoPagoRubro=true;
	public Boolean cargarid_empleadoEmpleadoPagoRubro=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoEmpleadoPagoRubro=false;//ConEventDepend=true

	public Border resaltarid_estructuraEmpleadoPagoRubro=null;
	public Boolean mostrarid_estructuraEmpleadoPagoRubro=true;
	public Boolean activarid_estructuraEmpleadoPagoRubro=true;
	public Boolean cargarid_estructuraEmpleadoPagoRubro=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estructuraEmpleadoPagoRubro=false;//ConEventDepend=true

	public Border resaltarid_rubro_empleaEmpleadoPagoRubro=null;
	public Boolean mostrarid_rubro_empleaEmpleadoPagoRubro=true;
	public Boolean activarid_rubro_empleaEmpleadoPagoRubro=true;
	public Boolean cargarid_rubro_empleaEmpleadoPagoRubro=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_rubro_empleaEmpleadoPagoRubro=false;//ConEventDepend=true

	public Border resaltarid_anioEmpleadoPagoRubro=null;
	public Boolean mostrarid_anioEmpleadoPagoRubro=true;
	public Boolean activarid_anioEmpleadoPagoRubro=true;
	public Boolean cargarid_anioEmpleadoPagoRubro=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioEmpleadoPagoRubro=false;//ConEventDepend=true

	public Border resaltarid_mesEmpleadoPagoRubro=null;
	public Boolean mostrarid_mesEmpleadoPagoRubro=true;
	public Boolean activarid_mesEmpleadoPagoRubro=true;
	public Boolean cargarid_mesEmpleadoPagoRubro=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesEmpleadoPagoRubro=false;//ConEventDepend=true

	public Border resaltarvalor_pagoEmpleadoPagoRubro=null;
	public Boolean mostrarvalor_pagoEmpleadoPagoRubro=true;
	public Boolean activarvalor_pagoEmpleadoPagoRubro=true;

	public Border resaltarfechaEmpleadoPagoRubro=null;
	public Boolean mostrarfechaEmpleadoPagoRubro=true;
	public Boolean activarfechaEmpleadoPagoRubro=false;

	public Border resaltarfecha_liquidacionEmpleadoPagoRubro=null;
	public Boolean mostrarfecha_liquidacionEmpleadoPagoRubro=true;
	public Boolean activarfecha_liquidacionEmpleadoPagoRubro=false;

	
	

	public Border setResaltaridEmpleadoPagoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoPagoRubroBeanSwingJInternalFrame empleadopagorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadopagorubroBeanSwingJInternalFrame.jTtoolBarEmpleadoPagoRubro.setBorder(borderResaltar);
		
		this.resaltaridEmpleadoPagoRubro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEmpleadoPagoRubro() {
		return this.resaltaridEmpleadoPagoRubro;
	}

	public void setResaltaridEmpleadoPagoRubro(Border borderResaltar) {
		this.resaltaridEmpleadoPagoRubro= borderResaltar;
	}

	public Boolean getMostraridEmpleadoPagoRubro() {
		return this.mostraridEmpleadoPagoRubro;
	}

	public void setMostraridEmpleadoPagoRubro(Boolean mostraridEmpleadoPagoRubro) {
		this.mostraridEmpleadoPagoRubro= mostraridEmpleadoPagoRubro;
	}

	public Boolean getActivaridEmpleadoPagoRubro() {
		return this.activaridEmpleadoPagoRubro;
	}

	public void setActivaridEmpleadoPagoRubro(Boolean activaridEmpleadoPagoRubro) {
		this.activaridEmpleadoPagoRubro= activaridEmpleadoPagoRubro;
	}

	public Border setResaltarid_empresaEmpleadoPagoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoPagoRubroBeanSwingJInternalFrame empleadopagorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadopagorubroBeanSwingJInternalFrame.jTtoolBarEmpleadoPagoRubro.setBorder(borderResaltar);
		
		this.resaltarid_empresaEmpleadoPagoRubro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEmpleadoPagoRubro() {
		return this.resaltarid_empresaEmpleadoPagoRubro;
	}

	public void setResaltarid_empresaEmpleadoPagoRubro(Border borderResaltar) {
		this.resaltarid_empresaEmpleadoPagoRubro= borderResaltar;
	}

	public Boolean getMostrarid_empresaEmpleadoPagoRubro() {
		return this.mostrarid_empresaEmpleadoPagoRubro;
	}

	public void setMostrarid_empresaEmpleadoPagoRubro(Boolean mostrarid_empresaEmpleadoPagoRubro) {
		this.mostrarid_empresaEmpleadoPagoRubro= mostrarid_empresaEmpleadoPagoRubro;
	}

	public Boolean getActivarid_empresaEmpleadoPagoRubro() {
		return this.activarid_empresaEmpleadoPagoRubro;
	}

	public void setActivarid_empresaEmpleadoPagoRubro(Boolean activarid_empresaEmpleadoPagoRubro) {
		this.activarid_empresaEmpleadoPagoRubro= activarid_empresaEmpleadoPagoRubro;
	}

	public Boolean getCargarid_empresaEmpleadoPagoRubro() {
		return this.cargarid_empresaEmpleadoPagoRubro;
	}

	public void setCargarid_empresaEmpleadoPagoRubro(Boolean cargarid_empresaEmpleadoPagoRubro) {
		this.cargarid_empresaEmpleadoPagoRubro= cargarid_empresaEmpleadoPagoRubro;
	}

	public Border setResaltarid_empleadoEmpleadoPagoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoPagoRubroBeanSwingJInternalFrame empleadopagorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadopagorubroBeanSwingJInternalFrame.jTtoolBarEmpleadoPagoRubro.setBorder(borderResaltar);
		
		this.resaltarid_empleadoEmpleadoPagoRubro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoEmpleadoPagoRubro() {
		return this.resaltarid_empleadoEmpleadoPagoRubro;
	}

	public void setResaltarid_empleadoEmpleadoPagoRubro(Border borderResaltar) {
		this.resaltarid_empleadoEmpleadoPagoRubro= borderResaltar;
	}

	public Boolean getMostrarid_empleadoEmpleadoPagoRubro() {
		return this.mostrarid_empleadoEmpleadoPagoRubro;
	}

	public void setMostrarid_empleadoEmpleadoPagoRubro(Boolean mostrarid_empleadoEmpleadoPagoRubro) {
		this.mostrarid_empleadoEmpleadoPagoRubro= mostrarid_empleadoEmpleadoPagoRubro;
	}

	public Boolean getActivarid_empleadoEmpleadoPagoRubro() {
		return this.activarid_empleadoEmpleadoPagoRubro;
	}

	public void setActivarid_empleadoEmpleadoPagoRubro(Boolean activarid_empleadoEmpleadoPagoRubro) {
		this.activarid_empleadoEmpleadoPagoRubro= activarid_empleadoEmpleadoPagoRubro;
	}

	public Boolean getCargarid_empleadoEmpleadoPagoRubro() {
		return this.cargarid_empleadoEmpleadoPagoRubro;
	}

	public void setCargarid_empleadoEmpleadoPagoRubro(Boolean cargarid_empleadoEmpleadoPagoRubro) {
		this.cargarid_empleadoEmpleadoPagoRubro= cargarid_empleadoEmpleadoPagoRubro;
	}

	public Border setResaltarid_estructuraEmpleadoPagoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoPagoRubroBeanSwingJInternalFrame empleadopagorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadopagorubroBeanSwingJInternalFrame.jTtoolBarEmpleadoPagoRubro.setBorder(borderResaltar);
		
		this.resaltarid_estructuraEmpleadoPagoRubro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estructuraEmpleadoPagoRubro() {
		return this.resaltarid_estructuraEmpleadoPagoRubro;
	}

	public void setResaltarid_estructuraEmpleadoPagoRubro(Border borderResaltar) {
		this.resaltarid_estructuraEmpleadoPagoRubro= borderResaltar;
	}

	public Boolean getMostrarid_estructuraEmpleadoPagoRubro() {
		return this.mostrarid_estructuraEmpleadoPagoRubro;
	}

	public void setMostrarid_estructuraEmpleadoPagoRubro(Boolean mostrarid_estructuraEmpleadoPagoRubro) {
		this.mostrarid_estructuraEmpleadoPagoRubro= mostrarid_estructuraEmpleadoPagoRubro;
	}

	public Boolean getActivarid_estructuraEmpleadoPagoRubro() {
		return this.activarid_estructuraEmpleadoPagoRubro;
	}

	public void setActivarid_estructuraEmpleadoPagoRubro(Boolean activarid_estructuraEmpleadoPagoRubro) {
		this.activarid_estructuraEmpleadoPagoRubro= activarid_estructuraEmpleadoPagoRubro;
	}

	public Boolean getCargarid_estructuraEmpleadoPagoRubro() {
		return this.cargarid_estructuraEmpleadoPagoRubro;
	}

	public void setCargarid_estructuraEmpleadoPagoRubro(Boolean cargarid_estructuraEmpleadoPagoRubro) {
		this.cargarid_estructuraEmpleadoPagoRubro= cargarid_estructuraEmpleadoPagoRubro;
	}

	public Border setResaltarid_rubro_empleaEmpleadoPagoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoPagoRubroBeanSwingJInternalFrame empleadopagorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadopagorubroBeanSwingJInternalFrame.jTtoolBarEmpleadoPagoRubro.setBorder(borderResaltar);
		
		this.resaltarid_rubro_empleaEmpleadoPagoRubro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_rubro_empleaEmpleadoPagoRubro() {
		return this.resaltarid_rubro_empleaEmpleadoPagoRubro;
	}

	public void setResaltarid_rubro_empleaEmpleadoPagoRubro(Border borderResaltar) {
		this.resaltarid_rubro_empleaEmpleadoPagoRubro= borderResaltar;
	}

	public Boolean getMostrarid_rubro_empleaEmpleadoPagoRubro() {
		return this.mostrarid_rubro_empleaEmpleadoPagoRubro;
	}

	public void setMostrarid_rubro_empleaEmpleadoPagoRubro(Boolean mostrarid_rubro_empleaEmpleadoPagoRubro) {
		this.mostrarid_rubro_empleaEmpleadoPagoRubro= mostrarid_rubro_empleaEmpleadoPagoRubro;
	}

	public Boolean getActivarid_rubro_empleaEmpleadoPagoRubro() {
		return this.activarid_rubro_empleaEmpleadoPagoRubro;
	}

	public void setActivarid_rubro_empleaEmpleadoPagoRubro(Boolean activarid_rubro_empleaEmpleadoPagoRubro) {
		this.activarid_rubro_empleaEmpleadoPagoRubro= activarid_rubro_empleaEmpleadoPagoRubro;
	}

	public Boolean getCargarid_rubro_empleaEmpleadoPagoRubro() {
		return this.cargarid_rubro_empleaEmpleadoPagoRubro;
	}

	public void setCargarid_rubro_empleaEmpleadoPagoRubro(Boolean cargarid_rubro_empleaEmpleadoPagoRubro) {
		this.cargarid_rubro_empleaEmpleadoPagoRubro= cargarid_rubro_empleaEmpleadoPagoRubro;
	}

	public Border setResaltarid_anioEmpleadoPagoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoPagoRubroBeanSwingJInternalFrame empleadopagorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadopagorubroBeanSwingJInternalFrame.jTtoolBarEmpleadoPagoRubro.setBorder(borderResaltar);
		
		this.resaltarid_anioEmpleadoPagoRubro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioEmpleadoPagoRubro() {
		return this.resaltarid_anioEmpleadoPagoRubro;
	}

	public void setResaltarid_anioEmpleadoPagoRubro(Border borderResaltar) {
		this.resaltarid_anioEmpleadoPagoRubro= borderResaltar;
	}

	public Boolean getMostrarid_anioEmpleadoPagoRubro() {
		return this.mostrarid_anioEmpleadoPagoRubro;
	}

	public void setMostrarid_anioEmpleadoPagoRubro(Boolean mostrarid_anioEmpleadoPagoRubro) {
		this.mostrarid_anioEmpleadoPagoRubro= mostrarid_anioEmpleadoPagoRubro;
	}

	public Boolean getActivarid_anioEmpleadoPagoRubro() {
		return this.activarid_anioEmpleadoPagoRubro;
	}

	public void setActivarid_anioEmpleadoPagoRubro(Boolean activarid_anioEmpleadoPagoRubro) {
		this.activarid_anioEmpleadoPagoRubro= activarid_anioEmpleadoPagoRubro;
	}

	public Boolean getCargarid_anioEmpleadoPagoRubro() {
		return this.cargarid_anioEmpleadoPagoRubro;
	}

	public void setCargarid_anioEmpleadoPagoRubro(Boolean cargarid_anioEmpleadoPagoRubro) {
		this.cargarid_anioEmpleadoPagoRubro= cargarid_anioEmpleadoPagoRubro;
	}

	public Border setResaltarid_mesEmpleadoPagoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoPagoRubroBeanSwingJInternalFrame empleadopagorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadopagorubroBeanSwingJInternalFrame.jTtoolBarEmpleadoPagoRubro.setBorder(borderResaltar);
		
		this.resaltarid_mesEmpleadoPagoRubro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesEmpleadoPagoRubro() {
		return this.resaltarid_mesEmpleadoPagoRubro;
	}

	public void setResaltarid_mesEmpleadoPagoRubro(Border borderResaltar) {
		this.resaltarid_mesEmpleadoPagoRubro= borderResaltar;
	}

	public Boolean getMostrarid_mesEmpleadoPagoRubro() {
		return this.mostrarid_mesEmpleadoPagoRubro;
	}

	public void setMostrarid_mesEmpleadoPagoRubro(Boolean mostrarid_mesEmpleadoPagoRubro) {
		this.mostrarid_mesEmpleadoPagoRubro= mostrarid_mesEmpleadoPagoRubro;
	}

	public Boolean getActivarid_mesEmpleadoPagoRubro() {
		return this.activarid_mesEmpleadoPagoRubro;
	}

	public void setActivarid_mesEmpleadoPagoRubro(Boolean activarid_mesEmpleadoPagoRubro) {
		this.activarid_mesEmpleadoPagoRubro= activarid_mesEmpleadoPagoRubro;
	}

	public Boolean getCargarid_mesEmpleadoPagoRubro() {
		return this.cargarid_mesEmpleadoPagoRubro;
	}

	public void setCargarid_mesEmpleadoPagoRubro(Boolean cargarid_mesEmpleadoPagoRubro) {
		this.cargarid_mesEmpleadoPagoRubro= cargarid_mesEmpleadoPagoRubro;
	}

	public Border setResaltarvalor_pagoEmpleadoPagoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoPagoRubroBeanSwingJInternalFrame empleadopagorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadopagorubroBeanSwingJInternalFrame.jTtoolBarEmpleadoPagoRubro.setBorder(borderResaltar);
		
		this.resaltarvalor_pagoEmpleadoPagoRubro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_pagoEmpleadoPagoRubro() {
		return this.resaltarvalor_pagoEmpleadoPagoRubro;
	}

	public void setResaltarvalor_pagoEmpleadoPagoRubro(Border borderResaltar) {
		this.resaltarvalor_pagoEmpleadoPagoRubro= borderResaltar;
	}

	public Boolean getMostrarvalor_pagoEmpleadoPagoRubro() {
		return this.mostrarvalor_pagoEmpleadoPagoRubro;
	}

	public void setMostrarvalor_pagoEmpleadoPagoRubro(Boolean mostrarvalor_pagoEmpleadoPagoRubro) {
		this.mostrarvalor_pagoEmpleadoPagoRubro= mostrarvalor_pagoEmpleadoPagoRubro;
	}

	public Boolean getActivarvalor_pagoEmpleadoPagoRubro() {
		return this.activarvalor_pagoEmpleadoPagoRubro;
	}

	public void setActivarvalor_pagoEmpleadoPagoRubro(Boolean activarvalor_pagoEmpleadoPagoRubro) {
		this.activarvalor_pagoEmpleadoPagoRubro= activarvalor_pagoEmpleadoPagoRubro;
	}

	public Border setResaltarfechaEmpleadoPagoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoPagoRubroBeanSwingJInternalFrame empleadopagorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadopagorubroBeanSwingJInternalFrame.jTtoolBarEmpleadoPagoRubro.setBorder(borderResaltar);
		
		this.resaltarfechaEmpleadoPagoRubro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaEmpleadoPagoRubro() {
		return this.resaltarfechaEmpleadoPagoRubro;
	}

	public void setResaltarfechaEmpleadoPagoRubro(Border borderResaltar) {
		this.resaltarfechaEmpleadoPagoRubro= borderResaltar;
	}

	public Boolean getMostrarfechaEmpleadoPagoRubro() {
		return this.mostrarfechaEmpleadoPagoRubro;
	}

	public void setMostrarfechaEmpleadoPagoRubro(Boolean mostrarfechaEmpleadoPagoRubro) {
		this.mostrarfechaEmpleadoPagoRubro= mostrarfechaEmpleadoPagoRubro;
	}

	public Boolean getActivarfechaEmpleadoPagoRubro() {
		return this.activarfechaEmpleadoPagoRubro;
	}

	public void setActivarfechaEmpleadoPagoRubro(Boolean activarfechaEmpleadoPagoRubro) {
		this.activarfechaEmpleadoPagoRubro= activarfechaEmpleadoPagoRubro;
	}

	public Border setResaltarfecha_liquidacionEmpleadoPagoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoPagoRubroBeanSwingJInternalFrame empleadopagorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empleadopagorubroBeanSwingJInternalFrame.jTtoolBarEmpleadoPagoRubro.setBorder(borderResaltar);
		
		this.resaltarfecha_liquidacionEmpleadoPagoRubro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_liquidacionEmpleadoPagoRubro() {
		return this.resaltarfecha_liquidacionEmpleadoPagoRubro;
	}

	public void setResaltarfecha_liquidacionEmpleadoPagoRubro(Border borderResaltar) {
		this.resaltarfecha_liquidacionEmpleadoPagoRubro= borderResaltar;
	}

	public Boolean getMostrarfecha_liquidacionEmpleadoPagoRubro() {
		return this.mostrarfecha_liquidacionEmpleadoPagoRubro;
	}

	public void setMostrarfecha_liquidacionEmpleadoPagoRubro(Boolean mostrarfecha_liquidacionEmpleadoPagoRubro) {
		this.mostrarfecha_liquidacionEmpleadoPagoRubro= mostrarfecha_liquidacionEmpleadoPagoRubro;
	}

	public Boolean getActivarfecha_liquidacionEmpleadoPagoRubro() {
		return this.activarfecha_liquidacionEmpleadoPagoRubro;
	}

	public void setActivarfecha_liquidacionEmpleadoPagoRubro(Boolean activarfecha_liquidacionEmpleadoPagoRubro) {
		this.activarfecha_liquidacionEmpleadoPagoRubro= activarfecha_liquidacionEmpleadoPagoRubro;
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
		
		
		this.setMostraridEmpleadoPagoRubro(esInicial);
		this.setMostrarid_empresaEmpleadoPagoRubro(esInicial);
		this.setMostrarid_empleadoEmpleadoPagoRubro(esInicial);
		this.setMostrarid_estructuraEmpleadoPagoRubro(esInicial);
		this.setMostrarid_rubro_empleaEmpleadoPagoRubro(esInicial);
		this.setMostrarid_anioEmpleadoPagoRubro(esInicial);
		this.setMostrarid_mesEmpleadoPagoRubro(esInicial);
		this.setMostrarvalor_pagoEmpleadoPagoRubro(esInicial);
		this.setMostrarfechaEmpleadoPagoRubro(esInicial);
		this.setMostrarfecha_liquidacionEmpleadoPagoRubro(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.ID)) {
				this.setMostraridEmpleadoPagoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEmpleadoPagoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoEmpleadoPagoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.IDESTRUCTURA)) {
				this.setMostrarid_estructuraEmpleadoPagoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.IDRUBROEMPLEA)) {
				this.setMostrarid_rubro_empleaEmpleadoPagoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioEmpleadoPagoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.IDMES)) {
				this.setMostrarid_mesEmpleadoPagoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.VALORPAGO)) {
				this.setMostrarvalor_pagoEmpleadoPagoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.FECHA)) {
				this.setMostrarfechaEmpleadoPagoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.FECHALIQUIDACION)) {
				this.setMostrarfecha_liquidacionEmpleadoPagoRubro(esAsigna);
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
		
		
		this.setActivaridEmpleadoPagoRubro(esInicial);
		this.setActivarid_empresaEmpleadoPagoRubro(esInicial);
		this.setActivarid_empleadoEmpleadoPagoRubro(esInicial);
		this.setActivarid_estructuraEmpleadoPagoRubro(esInicial);
		this.setActivarid_rubro_empleaEmpleadoPagoRubro(esInicial);
		this.setActivarid_anioEmpleadoPagoRubro(esInicial);
		this.setActivarid_mesEmpleadoPagoRubro(esInicial);
		this.setActivarvalor_pagoEmpleadoPagoRubro(esInicial);
		this.setActivarfechaEmpleadoPagoRubro(esInicial);
		this.setActivarfecha_liquidacionEmpleadoPagoRubro(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.ID)) {
				this.setActivaridEmpleadoPagoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEmpleadoPagoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoEmpleadoPagoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.IDESTRUCTURA)) {
				this.setActivarid_estructuraEmpleadoPagoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.IDRUBROEMPLEA)) {
				this.setActivarid_rubro_empleaEmpleadoPagoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.IDANIO)) {
				this.setActivarid_anioEmpleadoPagoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.IDMES)) {
				this.setActivarid_mesEmpleadoPagoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.VALORPAGO)) {
				this.setActivarvalor_pagoEmpleadoPagoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.FECHA)) {
				this.setActivarfechaEmpleadoPagoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.FECHALIQUIDACION)) {
				this.setActivarfecha_liquidacionEmpleadoPagoRubro(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpleadoPagoRubroBeanSwingJInternalFrame empleadopagorubroBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEmpleadoPagoRubro(esInicial);
		this.setResaltarid_empresaEmpleadoPagoRubro(esInicial);
		this.setResaltarid_empleadoEmpleadoPagoRubro(esInicial);
		this.setResaltarid_estructuraEmpleadoPagoRubro(esInicial);
		this.setResaltarid_rubro_empleaEmpleadoPagoRubro(esInicial);
		this.setResaltarid_anioEmpleadoPagoRubro(esInicial);
		this.setResaltarid_mesEmpleadoPagoRubro(esInicial);
		this.setResaltarvalor_pagoEmpleadoPagoRubro(esInicial);
		this.setResaltarfechaEmpleadoPagoRubro(esInicial);
		this.setResaltarfecha_liquidacionEmpleadoPagoRubro(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.ID)) {
				this.setResaltaridEmpleadoPagoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEmpleadoPagoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoEmpleadoPagoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.IDESTRUCTURA)) {
				this.setResaltarid_estructuraEmpleadoPagoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.IDRUBROEMPLEA)) {
				this.setResaltarid_rubro_empleaEmpleadoPagoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioEmpleadoPagoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.IDMES)) {
				this.setResaltarid_mesEmpleadoPagoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.VALORPAGO)) {
				this.setResaltarvalor_pagoEmpleadoPagoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.FECHA)) {
				this.setResaltarfechaEmpleadoPagoRubro(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpleadoPagoRubroConstantesFunciones.FECHALIQUIDACION)) {
				this.setResaltarfecha_liquidacionEmpleadoPagoRubro(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpleadoPagoRubroBeanSwingJInternalFrame empleadopagorubroBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAnioEmpleadoPagoRubro=true;

	public Boolean getMostrarFK_IdAnioEmpleadoPagoRubro() {
		return this.mostrarFK_IdAnioEmpleadoPagoRubro;
	}

	public void setMostrarFK_IdAnioEmpleadoPagoRubro(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAnioEmpleadoPagoRubro= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoEmpleadoPagoRubro=true;

	public Boolean getMostrarFK_IdEmpleadoEmpleadoPagoRubro() {
		return this.mostrarFK_IdEmpleadoEmpleadoPagoRubro;
	}

	public void setMostrarFK_IdEmpleadoEmpleadoPagoRubro(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoEmpleadoPagoRubro= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaEmpleadoPagoRubro=true;

	public Boolean getMostrarFK_IdEmpresaEmpleadoPagoRubro() {
		return this.mostrarFK_IdEmpresaEmpleadoPagoRubro;
	}

	public void setMostrarFK_IdEmpresaEmpleadoPagoRubro(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaEmpleadoPagoRubro= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstructuraEmpleadoPagoRubro=true;

	public Boolean getMostrarFK_IdEstructuraEmpleadoPagoRubro() {
		return this.mostrarFK_IdEstructuraEmpleadoPagoRubro;
	}

	public void setMostrarFK_IdEstructuraEmpleadoPagoRubro(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstructuraEmpleadoPagoRubro= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMesEmpleadoPagoRubro=true;

	public Boolean getMostrarFK_IdMesEmpleadoPagoRubro() {
		return this.mostrarFK_IdMesEmpleadoPagoRubro;
	}

	public void setMostrarFK_IdMesEmpleadoPagoRubro(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMesEmpleadoPagoRubro= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdRubroEmpleaEmpleadoPagoRubro=true;

	public Boolean getMostrarFK_IdRubroEmpleaEmpleadoPagoRubro() {
		return this.mostrarFK_IdRubroEmpleaEmpleadoPagoRubro;
	}

	public void setMostrarFK_IdRubroEmpleaEmpleadoPagoRubro(Boolean visibilidadResaltar) {
		this.mostrarFK_IdRubroEmpleaEmpleadoPagoRubro= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAnioEmpleadoPagoRubro=true;

	public Boolean getActivarFK_IdAnioEmpleadoPagoRubro() {
		return this.activarFK_IdAnioEmpleadoPagoRubro;
	}

	public void setActivarFK_IdAnioEmpleadoPagoRubro(Boolean habilitarResaltar) {
		this.activarFK_IdAnioEmpleadoPagoRubro= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoEmpleadoPagoRubro=true;

	public Boolean getActivarFK_IdEmpleadoEmpleadoPagoRubro() {
		return this.activarFK_IdEmpleadoEmpleadoPagoRubro;
	}

	public void setActivarFK_IdEmpleadoEmpleadoPagoRubro(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoEmpleadoPagoRubro= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaEmpleadoPagoRubro=true;

	public Boolean getActivarFK_IdEmpresaEmpleadoPagoRubro() {
		return this.activarFK_IdEmpresaEmpleadoPagoRubro;
	}

	public void setActivarFK_IdEmpresaEmpleadoPagoRubro(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaEmpleadoPagoRubro= habilitarResaltar;
	}

	public Boolean activarFK_IdEstructuraEmpleadoPagoRubro=true;

	public Boolean getActivarFK_IdEstructuraEmpleadoPagoRubro() {
		return this.activarFK_IdEstructuraEmpleadoPagoRubro;
	}

	public void setActivarFK_IdEstructuraEmpleadoPagoRubro(Boolean habilitarResaltar) {
		this.activarFK_IdEstructuraEmpleadoPagoRubro= habilitarResaltar;
	}

	public Boolean activarFK_IdMesEmpleadoPagoRubro=true;

	public Boolean getActivarFK_IdMesEmpleadoPagoRubro() {
		return this.activarFK_IdMesEmpleadoPagoRubro;
	}

	public void setActivarFK_IdMesEmpleadoPagoRubro(Boolean habilitarResaltar) {
		this.activarFK_IdMesEmpleadoPagoRubro= habilitarResaltar;
	}

	public Boolean activarFK_IdRubroEmpleaEmpleadoPagoRubro=true;

	public Boolean getActivarFK_IdRubroEmpleaEmpleadoPagoRubro() {
		return this.activarFK_IdRubroEmpleaEmpleadoPagoRubro;
	}

	public void setActivarFK_IdRubroEmpleaEmpleadoPagoRubro(Boolean habilitarResaltar) {
		this.activarFK_IdRubroEmpleaEmpleadoPagoRubro= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAnioEmpleadoPagoRubro=null;

	public Border getResaltarFK_IdAnioEmpleadoPagoRubro() {
		return this.resaltarFK_IdAnioEmpleadoPagoRubro;
	}

	public void setResaltarFK_IdAnioEmpleadoPagoRubro(Border borderResaltar) {
		this.resaltarFK_IdAnioEmpleadoPagoRubro= borderResaltar;
	}

	public void setResaltarFK_IdAnioEmpleadoPagoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoPagoRubroBeanSwingJInternalFrame empleadopagorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAnioEmpleadoPagoRubro= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoEmpleadoPagoRubro=null;

	public Border getResaltarFK_IdEmpleadoEmpleadoPagoRubro() {
		return this.resaltarFK_IdEmpleadoEmpleadoPagoRubro;
	}

	public void setResaltarFK_IdEmpleadoEmpleadoPagoRubro(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoEmpleadoPagoRubro= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoEmpleadoPagoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoPagoRubroBeanSwingJInternalFrame empleadopagorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoEmpleadoPagoRubro= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaEmpleadoPagoRubro=null;

	public Border getResaltarFK_IdEmpresaEmpleadoPagoRubro() {
		return this.resaltarFK_IdEmpresaEmpleadoPagoRubro;
	}

	public void setResaltarFK_IdEmpresaEmpleadoPagoRubro(Border borderResaltar) {
		this.resaltarFK_IdEmpresaEmpleadoPagoRubro= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaEmpleadoPagoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoPagoRubroBeanSwingJInternalFrame empleadopagorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaEmpleadoPagoRubro= borderResaltar;
	}

	public Border resaltarFK_IdEstructuraEmpleadoPagoRubro=null;

	public Border getResaltarFK_IdEstructuraEmpleadoPagoRubro() {
		return this.resaltarFK_IdEstructuraEmpleadoPagoRubro;
	}

	public void setResaltarFK_IdEstructuraEmpleadoPagoRubro(Border borderResaltar) {
		this.resaltarFK_IdEstructuraEmpleadoPagoRubro= borderResaltar;
	}

	public void setResaltarFK_IdEstructuraEmpleadoPagoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoPagoRubroBeanSwingJInternalFrame empleadopagorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstructuraEmpleadoPagoRubro= borderResaltar;
	}

	public Border resaltarFK_IdMesEmpleadoPagoRubro=null;

	public Border getResaltarFK_IdMesEmpleadoPagoRubro() {
		return this.resaltarFK_IdMesEmpleadoPagoRubro;
	}

	public void setResaltarFK_IdMesEmpleadoPagoRubro(Border borderResaltar) {
		this.resaltarFK_IdMesEmpleadoPagoRubro= borderResaltar;
	}

	public void setResaltarFK_IdMesEmpleadoPagoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoPagoRubroBeanSwingJInternalFrame empleadopagorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMesEmpleadoPagoRubro= borderResaltar;
	}

	public Border resaltarFK_IdRubroEmpleaEmpleadoPagoRubro=null;

	public Border getResaltarFK_IdRubroEmpleaEmpleadoPagoRubro() {
		return this.resaltarFK_IdRubroEmpleaEmpleadoPagoRubro;
	}

	public void setResaltarFK_IdRubroEmpleaEmpleadoPagoRubro(Border borderResaltar) {
		this.resaltarFK_IdRubroEmpleaEmpleadoPagoRubro= borderResaltar;
	}

	public void setResaltarFK_IdRubroEmpleaEmpleadoPagoRubro(ParametroGeneralUsuario parametroGeneralUsuario/*EmpleadoPagoRubroBeanSwingJInternalFrame empleadopagorubroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdRubroEmpleaEmpleadoPagoRubro= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}