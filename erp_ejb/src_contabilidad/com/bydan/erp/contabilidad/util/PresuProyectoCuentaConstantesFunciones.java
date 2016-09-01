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
package com.bydan.erp.contabilidad.util;

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


import com.bydan.erp.contabilidad.util.PresuProyectoCuentaConstantesFunciones;
import com.bydan.erp.contabilidad.util.PresuProyectoCuentaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.PresuProyectoCuentaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PresuProyectoCuentaConstantesFunciones extends PresuProyectoCuentaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PresuProyectoCuenta";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PresuProyectoCuenta"+PresuProyectoCuentaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PresuProyectoCuentaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PresuProyectoCuentaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PresuProyectoCuentaConstantesFunciones.SCHEMA+"_"+PresuProyectoCuentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PresuProyectoCuentaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PresuProyectoCuentaConstantesFunciones.SCHEMA+"_"+PresuProyectoCuentaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PresuProyectoCuentaConstantesFunciones.SCHEMA+"_"+PresuProyectoCuentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PresuProyectoCuentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PresuProyectoCuentaConstantesFunciones.SCHEMA+"_"+PresuProyectoCuentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresuProyectoCuentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresuProyectoCuentaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresuProyectoCuentaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresuProyectoCuentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresuProyectoCuentaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresuProyectoCuentaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PresuProyectoCuentaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PresuProyectoCuentaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PresuProyectoCuentaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PresuProyectoCuentaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cuenta Contable Proyectoes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Cuenta Contable Proyecto";
	public static final String SCLASSWEBTITULO_LOWER="Presu Proyecto Cuenta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PresuProyectoCuenta";
	public static final String OBJECTNAME="presuproyectocuenta";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="presu_proyecto_cuenta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select presuproyectocuenta from "+PresuProyectoCuentaConstantesFunciones.SPERSISTENCENAME+" presuproyectocuenta";
	public static String QUERYSELECTNATIVE="select "+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+".id,"+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+".version_row,"+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+".id_presu_proyecto,"+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+".id_presu_tipo_cuenta_proyecto,"+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+".codigo,"+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+".nombre,"+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+".id_cuenta_contable,"+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+".id_empleado,"+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+".fecha,"+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+".valor,"+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+".orden,"+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+".id_presu_estado,"+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME+".descripcion from "+PresuProyectoCuentaConstantesFunciones.SCHEMA+"."+PresuProyectoCuentaConstantesFunciones.TABLENAME;//+" as "+PresuProyectoCuentaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PresuProyectoCuentaConstantesFuncionesAdditional presuproyectocuentaConstantesFuncionesAdditional=null;
	
	public PresuProyectoCuentaConstantesFuncionesAdditional getPresuProyectoCuentaConstantesFuncionesAdditional() {
		return this.presuproyectocuentaConstantesFuncionesAdditional;
	}
	
	public void setPresuProyectoCuentaConstantesFuncionesAdditional(PresuProyectoCuentaConstantesFuncionesAdditional presuproyectocuentaConstantesFuncionesAdditional) {
		try {
			this.presuproyectocuentaConstantesFuncionesAdditional=presuproyectocuentaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPRESUPROYECTO= "id_presu_proyecto";
    public static final String IDPRESUTIPOCUENTAPROYECTO= "id_presu_tipo_cuenta_proyecto";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String FECHA= "fecha";
    public static final String VALOR= "valor";
    public static final String ORDEN= "orden";
    public static final String IDPRESUESTADO= "id_presu_estado";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPRESUPROYECTO= "Proyecto";
		public static final String LABEL_IDPRESUPROYECTO_LOWER= "Presu Proyecto";
    	public static final String LABEL_IDPRESUTIPOCUENTAPROYECTO= "Tipo Cuenta Proyecto";
		public static final String LABEL_IDPRESUTIPOCUENTAPROYECTO_LOWER= "Presu Tipo Cuenta Proyecto";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_ORDEN= "Orden";
		public static final String LABEL_ORDEN_LOWER= "Orden";
    	public static final String LABEL_IDPRESUESTADO= "Estado";
		public static final String LABEL_IDPRESUESTADO_LOWER= "Presu Estado";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getPresuProyectoCuentaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PresuProyectoCuentaConstantesFunciones.IDPRESUPROYECTO)) {sLabelColumna=PresuProyectoCuentaConstantesFunciones.LABEL_IDPRESUPROYECTO;}
		if(sNombreColumna.equals(PresuProyectoCuentaConstantesFunciones.IDPRESUTIPOCUENTAPROYECTO)) {sLabelColumna=PresuProyectoCuentaConstantesFunciones.LABEL_IDPRESUTIPOCUENTAPROYECTO;}
		if(sNombreColumna.equals(PresuProyectoCuentaConstantesFunciones.CODIGO)) {sLabelColumna=PresuProyectoCuentaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(PresuProyectoCuentaConstantesFunciones.NOMBRE)) {sLabelColumna=PresuProyectoCuentaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(PresuProyectoCuentaConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=PresuProyectoCuentaConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(PresuProyectoCuentaConstantesFunciones.IDEMPLEADO)) {sLabelColumna=PresuProyectoCuentaConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(PresuProyectoCuentaConstantesFunciones.FECHA)) {sLabelColumna=PresuProyectoCuentaConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(PresuProyectoCuentaConstantesFunciones.VALOR)) {sLabelColumna=PresuProyectoCuentaConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(PresuProyectoCuentaConstantesFunciones.ORDEN)) {sLabelColumna=PresuProyectoCuentaConstantesFunciones.LABEL_ORDEN;}
		if(sNombreColumna.equals(PresuProyectoCuentaConstantesFunciones.IDPRESUESTADO)) {sLabelColumna=PresuProyectoCuentaConstantesFunciones.LABEL_IDPRESUESTADO;}
		if(sNombreColumna.equals(PresuProyectoCuentaConstantesFunciones.DESCRIPCION)) {sLabelColumna=PresuProyectoCuentaConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getPresuProyectoCuentaDescripcion(PresuProyectoCuenta presuproyectocuenta) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(presuproyectocuenta !=null/* && presuproyectocuenta.getId()!=0*/) {
			sDescripcion=presuproyectocuenta.getcodigo();//presuproyectocuentapresuproyectocuenta.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getPresuProyectoCuentaDescripcionDetallado(PresuProyectoCuenta presuproyectocuenta) {
		String sDescripcion="";
			
		sDescripcion+=PresuProyectoCuentaConstantesFunciones.ID+"=";
		sDescripcion+=presuproyectocuenta.getId().toString()+",";
		sDescripcion+=PresuProyectoCuentaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=presuproyectocuenta.getVersionRow().toString()+",";
		sDescripcion+=PresuProyectoCuentaConstantesFunciones.IDPRESUPROYECTO+"=";
		sDescripcion+=presuproyectocuenta.getid_presu_proyecto().toString()+",";
		sDescripcion+=PresuProyectoCuentaConstantesFunciones.IDPRESUTIPOCUENTAPROYECTO+"=";
		sDescripcion+=presuproyectocuenta.getid_presu_tipo_cuenta_proyecto().toString()+",";
		sDescripcion+=PresuProyectoCuentaConstantesFunciones.CODIGO+"=";
		sDescripcion+=presuproyectocuenta.getcodigo()+",";
		sDescripcion+=PresuProyectoCuentaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=presuproyectocuenta.getnombre()+",";
		sDescripcion+=PresuProyectoCuentaConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=presuproyectocuenta.getid_cuenta_contable().toString()+",";
		sDescripcion+=PresuProyectoCuentaConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=presuproyectocuenta.getid_empleado().toString()+",";
		sDescripcion+=PresuProyectoCuentaConstantesFunciones.FECHA+"=";
		sDescripcion+=presuproyectocuenta.getfecha().toString()+",";
		sDescripcion+=PresuProyectoCuentaConstantesFunciones.VALOR+"=";
		sDescripcion+=presuproyectocuenta.getvalor().toString()+",";
		sDescripcion+=PresuProyectoCuentaConstantesFunciones.ORDEN+"=";
		sDescripcion+=presuproyectocuenta.getorden().toString()+",";
		sDescripcion+=PresuProyectoCuentaConstantesFunciones.IDPRESUESTADO+"=";
		sDescripcion+=presuproyectocuenta.getid_presu_estado().toString()+",";
		sDescripcion+=PresuProyectoCuentaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=presuproyectocuenta.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setPresuProyectoCuentaDescripcion(PresuProyectoCuenta presuproyectocuenta,String sValor) throws Exception {			
		if(presuproyectocuenta !=null) {
			presuproyectocuenta.setcodigo(sValor);;//presuproyectocuentapresuproyectocuenta.getcodigo().trim();
		}		
	}
	
		

	public static String getPresuProyectoDescripcion(PresuProyecto presuproyecto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(presuproyecto!=null/*&&presuproyecto.getId()>0*/) {
			sDescripcion=PresuProyectoConstantesFunciones.getPresuProyectoDescripcion(presuproyecto);
		}

		return sDescripcion;
	}

	public static String getPresuTipoCuentaProyectoDescripcion(PresuTipoCuentaProyecto presutipocuentaproyecto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(presutipocuentaproyecto!=null/*&&presutipocuentaproyecto.getId()>0*/) {
			sDescripcion=PresuTipoCuentaProyectoConstantesFunciones.getPresuTipoCuentaProyectoDescripcion(presutipocuentaproyecto);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
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

	public static String getPresuEstadoDescripcion(PresuEstado presuestado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(presuestado!=null/*&&presuestado.getId()>0*/) {
			sDescripcion=PresuEstadoConstantesFunciones.getPresuEstadoDescripcion(presuestado);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorProyectoPorCodigo")) {
			sNombreIndice="Tipo=  Por Proyecto Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorProyectoPorNombre")) {
			sNombreIndice="Tipo=  Por Proyecto Por Nombre";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdPresuEstado")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdPresuProyecto")) {
			sNombreIndice="Tipo=  Por Proyecto";
		} else if(sNombreIndice.equals("FK_IdPresuTipoCuentaProyecto")) {
			sNombreIndice="Tipo=  Por Tipo Cuenta Proyecto";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorProyectoPorCodigo(Long id_presu_proyecto,String codigo) {
		String sDetalleIndice=" Parametros->";
		if(id_presu_proyecto!=null) {sDetalleIndice+=" Codigo Unico De Proyecto="+id_presu_proyecto.toString();}
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorProyectoPorNombre(Long id_presu_proyecto,String nombre) {
		String sDetalleIndice=" Parametros->";
		if(id_presu_proyecto!=null) {sDetalleIndice+=" Codigo Unico De Proyecto="+id_presu_proyecto.toString();}
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPresuEstado(Long id_presu_estado) {
		String sDetalleIndice=" Parametros->";
		if(id_presu_estado!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_presu_estado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPresuProyecto(Long id_presu_proyecto) {
		String sDetalleIndice=" Parametros->";
		if(id_presu_proyecto!=null) {sDetalleIndice+=" Codigo Unico De Proyecto="+id_presu_proyecto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPresuTipoCuentaProyecto(Long id_presu_tipo_cuenta_proyecto) {
		String sDetalleIndice=" Parametros->";
		if(id_presu_tipo_cuenta_proyecto!=null) {sDetalleIndice+=" Codigo Unico De Tipo Cuenta Proyecto="+id_presu_tipo_cuenta_proyecto.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPresuProyectoCuenta(PresuProyectoCuenta presuproyectocuenta,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		presuproyectocuenta.setcodigo(presuproyectocuenta.getcodigo().trim());
		presuproyectocuenta.setnombre(presuproyectocuenta.getnombre().trim());
		presuproyectocuenta.setdescripcion(presuproyectocuenta.getdescripcion().trim());
	}
	
	public static void quitarEspaciosPresuProyectoCuentas(List<PresuProyectoCuenta> presuproyectocuentas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PresuProyectoCuenta presuproyectocuenta: presuproyectocuentas) {
			presuproyectocuenta.setcodigo(presuproyectocuenta.getcodigo().trim());
			presuproyectocuenta.setnombre(presuproyectocuenta.getnombre().trim());
			presuproyectocuenta.setdescripcion(presuproyectocuenta.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresuProyectoCuenta(PresuProyectoCuenta presuproyectocuenta,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && presuproyectocuenta.getConCambioAuxiliar()) {
			presuproyectocuenta.setIsDeleted(presuproyectocuenta.getIsDeletedAuxiliar());	
			presuproyectocuenta.setIsNew(presuproyectocuenta.getIsNewAuxiliar());	
			presuproyectocuenta.setIsChanged(presuproyectocuenta.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			presuproyectocuenta.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			presuproyectocuenta.setIsDeletedAuxiliar(false);	
			presuproyectocuenta.setIsNewAuxiliar(false);	
			presuproyectocuenta.setIsChangedAuxiliar(false);
			
			presuproyectocuenta.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresuProyectoCuentas(List<PresuProyectoCuenta> presuproyectocuentas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PresuProyectoCuenta presuproyectocuenta : presuproyectocuentas) {
			if(conAsignarBase && presuproyectocuenta.getConCambioAuxiliar()) {
				presuproyectocuenta.setIsDeleted(presuproyectocuenta.getIsDeletedAuxiliar());	
				presuproyectocuenta.setIsNew(presuproyectocuenta.getIsNewAuxiliar());	
				presuproyectocuenta.setIsChanged(presuproyectocuenta.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				presuproyectocuenta.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				presuproyectocuenta.setIsDeletedAuxiliar(false);	
				presuproyectocuenta.setIsNewAuxiliar(false);	
				presuproyectocuenta.setIsChangedAuxiliar(false);
				
				presuproyectocuenta.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPresuProyectoCuenta(PresuProyectoCuenta presuproyectocuenta,Boolean conEnteros) throws Exception  {
		presuproyectocuenta.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			presuproyectocuenta.setorden(0);
		}
	}		
	
	public static void InicializarValoresPresuProyectoCuentas(List<PresuProyectoCuenta> presuproyectocuentas,Boolean conEnteros) throws Exception  {
		
		for(PresuProyectoCuenta presuproyectocuenta: presuproyectocuentas) {
			presuproyectocuenta.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				presuproyectocuenta.setorden(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaPresuProyectoCuenta(List<PresuProyectoCuenta> presuproyectocuentas,PresuProyectoCuenta presuproyectocuentaAux) throws Exception  {
		PresuProyectoCuentaConstantesFunciones.InicializarValoresPresuProyectoCuenta(presuproyectocuentaAux,true);
		
		for(PresuProyectoCuenta presuproyectocuenta: presuproyectocuentas) {
			if(presuproyectocuenta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			presuproyectocuentaAux.setvalor(presuproyectocuentaAux.getvalor()+presuproyectocuenta.getvalor());			
			presuproyectocuentaAux.setorden(presuproyectocuentaAux.getorden()+presuproyectocuenta.getorden());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPresuProyectoCuenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PresuProyectoCuentaConstantesFunciones.getArrayColumnasGlobalesPresuProyectoCuenta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPresuProyectoCuenta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPresuProyectoCuenta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PresuProyectoCuenta> presuproyectocuentas,PresuProyectoCuenta presuproyectocuenta,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PresuProyectoCuenta presuproyectocuentaAux: presuproyectocuentas) {
			if(presuproyectocuentaAux!=null && presuproyectocuenta!=null) {
				if((presuproyectocuentaAux.getId()==null && presuproyectocuenta.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(presuproyectocuentaAux.getId()!=null && presuproyectocuenta.getId()!=null){
					if(presuproyectocuentaAux.getId().equals(presuproyectocuenta.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPresuProyectoCuenta(List<PresuProyectoCuenta> presuproyectocuentas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(PresuProyectoCuenta presuproyectocuenta: presuproyectocuentas) {			
			if(presuproyectocuenta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=presuproyectocuenta.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresuProyectoCuentaConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(PresuProyectoCuentaConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPresuProyectoCuenta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PresuProyectoCuentaConstantesFunciones.LABEL_ID, PresuProyectoCuentaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuProyectoCuentaConstantesFunciones.LABEL_VERSIONROW, PresuProyectoCuentaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuProyectoCuentaConstantesFunciones.LABEL_IDPRESUPROYECTO, PresuProyectoCuentaConstantesFunciones.IDPRESUPROYECTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuProyectoCuentaConstantesFunciones.LABEL_IDPRESUTIPOCUENTAPROYECTO, PresuProyectoCuentaConstantesFunciones.IDPRESUTIPOCUENTAPROYECTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuProyectoCuentaConstantesFunciones.LABEL_CODIGO, PresuProyectoCuentaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuProyectoCuentaConstantesFunciones.LABEL_NOMBRE, PresuProyectoCuentaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuProyectoCuentaConstantesFunciones.LABEL_IDCUENTACONTABLE, PresuProyectoCuentaConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuProyectoCuentaConstantesFunciones.LABEL_IDEMPLEADO, PresuProyectoCuentaConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuProyectoCuentaConstantesFunciones.LABEL_FECHA, PresuProyectoCuentaConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuProyectoCuentaConstantesFunciones.LABEL_VALOR, PresuProyectoCuentaConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuProyectoCuentaConstantesFunciones.LABEL_ORDEN, PresuProyectoCuentaConstantesFunciones.ORDEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuProyectoCuentaConstantesFunciones.LABEL_IDPRESUESTADO, PresuProyectoCuentaConstantesFunciones.IDPRESUESTADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuProyectoCuentaConstantesFunciones.LABEL_DESCRIPCION, PresuProyectoCuentaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPresuProyectoCuenta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PresuProyectoCuentaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuProyectoCuentaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuProyectoCuentaConstantesFunciones.IDPRESUPROYECTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuProyectoCuentaConstantesFunciones.IDPRESUTIPOCUENTAPROYECTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuProyectoCuentaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuProyectoCuentaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuProyectoCuentaConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuProyectoCuentaConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuProyectoCuentaConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuProyectoCuentaConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuProyectoCuentaConstantesFunciones.ORDEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuProyectoCuentaConstantesFunciones.IDPRESUESTADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuProyectoCuentaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresuProyectoCuenta() throws Exception  {
		return PresuProyectoCuentaConstantesFunciones.getTiposSeleccionarPresuProyectoCuenta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresuProyectoCuenta(Boolean conFk) throws Exception  {
		return PresuProyectoCuentaConstantesFunciones.getTiposSeleccionarPresuProyectoCuenta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresuProyectoCuenta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuProyectoCuentaConstantesFunciones.LABEL_IDPRESUPROYECTO);
			reporte.setsDescripcion(PresuProyectoCuentaConstantesFunciones.LABEL_IDPRESUPROYECTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuProyectoCuentaConstantesFunciones.LABEL_IDPRESUTIPOCUENTAPROYECTO);
			reporte.setsDescripcion(PresuProyectoCuentaConstantesFunciones.LABEL_IDPRESUTIPOCUENTAPROYECTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuProyectoCuentaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(PresuProyectoCuentaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuProyectoCuentaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(PresuProyectoCuentaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuProyectoCuentaConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(PresuProyectoCuentaConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuProyectoCuentaConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(PresuProyectoCuentaConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuProyectoCuentaConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(PresuProyectoCuentaConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuProyectoCuentaConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(PresuProyectoCuentaConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuProyectoCuentaConstantesFunciones.LABEL_ORDEN);
			reporte.setsDescripcion(PresuProyectoCuentaConstantesFunciones.LABEL_ORDEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuProyectoCuentaConstantesFunciones.LABEL_IDPRESUESTADO);
			reporte.setsDescripcion(PresuProyectoCuentaConstantesFunciones.LABEL_IDPRESUESTADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuProyectoCuentaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(PresuProyectoCuentaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPresuProyectoCuenta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPresuProyectoCuenta(PresuProyectoCuenta presuproyectocuentaAux) throws Exception {
		
			presuproyectocuentaAux.setpresuproyecto_descripcion(PresuProyectoConstantesFunciones.getPresuProyectoDescripcion(presuproyectocuentaAux.getPresuProyecto()));
			presuproyectocuentaAux.setpresutipocuentaproyecto_descripcion(PresuTipoCuentaProyectoConstantesFunciones.getPresuTipoCuentaProyectoDescripcion(presuproyectocuentaAux.getPresuTipoCuentaProyecto()));
			presuproyectocuentaAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(presuproyectocuentaAux.getCuentaContable()));
			presuproyectocuentaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(presuproyectocuentaAux.getEmpleado()));
			presuproyectocuentaAux.setpresuestado_descripcion(PresuEstadoConstantesFunciones.getPresuEstadoDescripcion(presuproyectocuentaAux.getPresuEstado()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPresuProyectoCuenta(List<PresuProyectoCuenta> presuproyectocuentasTemp) throws Exception {
		for(PresuProyectoCuenta presuproyectocuentaAux:presuproyectocuentasTemp) {
			
			presuproyectocuentaAux.setpresuproyecto_descripcion(PresuProyectoConstantesFunciones.getPresuProyectoDescripcion(presuproyectocuentaAux.getPresuProyecto()));
			presuproyectocuentaAux.setpresutipocuentaproyecto_descripcion(PresuTipoCuentaProyectoConstantesFunciones.getPresuTipoCuentaProyectoDescripcion(presuproyectocuentaAux.getPresuTipoCuentaProyecto()));
			presuproyectocuentaAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(presuproyectocuentaAux.getCuentaContable()));
			presuproyectocuentaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(presuproyectocuentaAux.getEmpleado()));
			presuproyectocuentaAux.setpresuestado_descripcion(PresuEstadoConstantesFunciones.getPresuEstadoDescripcion(presuproyectocuentaAux.getPresuEstado()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPresuProyectoCuenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(PresuProyecto.class));
				classes.add(new Classe(PresuTipoCuentaProyecto.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(PresuEstado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(PresuProyecto.class)) {
						classes.add(new Classe(PresuProyecto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PresuTipoCuentaProyecto.class)) {
						classes.add(new Classe(PresuTipoCuentaProyecto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PresuEstado.class)) {
						classes.add(new Classe(PresuEstado.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPresuProyectoCuenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(PresuProyecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresuProyecto.class)); continue;
					}

					if(PresuTipoCuentaProyecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresuTipoCuentaProyecto.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(PresuEstado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresuEstado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(PresuProyecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresuProyecto.class)); continue;
					}

					if(PresuTipoCuentaProyecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresuTipoCuentaProyecto.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(PresuEstado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresuEstado.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresuProyectoCuenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresuProyectoCuentaConstantesFunciones.getClassesRelationshipsOfPresuProyectoCuenta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresuProyectoCuenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(PresuAsignacion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(PresuAsignacion.class)) {
						classes.add(new Classe(PresuAsignacion.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresuProyectoCuenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresuProyectoCuentaConstantesFunciones.getClassesRelationshipsFromStringsOfPresuProyectoCuenta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresuProyectoCuenta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(PresuAsignacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresuAsignacion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(PresuAsignacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresuAsignacion.class)); continue;
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(PresuProyectoCuenta presuproyectocuenta,List<PresuProyectoCuenta> presuproyectocuentas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PresuProyectoCuenta presuproyectocuentaEncontrado=null;
			
			for(PresuProyectoCuenta presuproyectocuentaLocal:presuproyectocuentas) {
				if(presuproyectocuentaLocal.getId().equals(presuproyectocuenta.getId())) {
					presuproyectocuentaEncontrado=presuproyectocuentaLocal;
					
					presuproyectocuentaLocal.setIsChanged(presuproyectocuenta.getIsChanged());
					presuproyectocuentaLocal.setIsNew(presuproyectocuenta.getIsNew());
					presuproyectocuentaLocal.setIsDeleted(presuproyectocuenta.getIsDeleted());
					
					presuproyectocuentaLocal.setGeneralEntityOriginal(presuproyectocuenta.getGeneralEntityOriginal());
					
					presuproyectocuentaLocal.setId(presuproyectocuenta.getId());	
					presuproyectocuentaLocal.setVersionRow(presuproyectocuenta.getVersionRow());	
					presuproyectocuentaLocal.setid_presu_proyecto(presuproyectocuenta.getid_presu_proyecto());	
					presuproyectocuentaLocal.setid_presu_tipo_cuenta_proyecto(presuproyectocuenta.getid_presu_tipo_cuenta_proyecto());	
					presuproyectocuentaLocal.setcodigo(presuproyectocuenta.getcodigo());	
					presuproyectocuentaLocal.setnombre(presuproyectocuenta.getnombre());	
					presuproyectocuentaLocal.setid_cuenta_contable(presuproyectocuenta.getid_cuenta_contable());	
					presuproyectocuentaLocal.setid_empleado(presuproyectocuenta.getid_empleado());	
					presuproyectocuentaLocal.setfecha(presuproyectocuenta.getfecha());	
					presuproyectocuentaLocal.setvalor(presuproyectocuenta.getvalor());	
					presuproyectocuentaLocal.setorden(presuproyectocuenta.getorden());	
					presuproyectocuentaLocal.setid_presu_estado(presuproyectocuenta.getid_presu_estado());	
					presuproyectocuentaLocal.setdescripcion(presuproyectocuenta.getdescripcion());	
					
					
					presuproyectocuentaLocal.setPresuAsignacions(presuproyectocuenta.getPresuAsignacions());
					
					existe=true;
					break;
				}
			}
			
			if(!presuproyectocuenta.getIsDeleted()) {
				if(!existe) {
					presuproyectocuentas.add(presuproyectocuenta);
				}
			} else {
				if(presuproyectocuentaEncontrado!=null && permiteQuitar)  {
					presuproyectocuentas.remove(presuproyectocuentaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PresuProyectoCuenta presuproyectocuenta,List<PresuProyectoCuenta> presuproyectocuentas) throws Exception {
		try	{			
			for(PresuProyectoCuenta presuproyectocuentaLocal:presuproyectocuentas) {
				if(presuproyectocuentaLocal.getId().equals(presuproyectocuenta.getId())) {
					presuproyectocuentaLocal.setIsSelected(presuproyectocuenta.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPresuProyectoCuenta(List<PresuProyectoCuenta> presuproyectocuentasAux) throws Exception {
		//this.presuproyectocuentasAux=presuproyectocuentasAux;
		
		for(PresuProyectoCuenta presuproyectocuentaAux:presuproyectocuentasAux) {
			if(presuproyectocuentaAux.getIsChanged()) {
				presuproyectocuentaAux.setIsChanged(false);
			}		
			
			if(presuproyectocuentaAux.getIsNew()) {
				presuproyectocuentaAux.setIsNew(false);
			}	
			
			if(presuproyectocuentaAux.getIsDeleted()) {
				presuproyectocuentaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPresuProyectoCuenta(PresuProyectoCuenta presuproyectocuentaAux) throws Exception {
		//this.presuproyectocuentaAux=presuproyectocuentaAux;
		
			if(presuproyectocuentaAux.getIsChanged()) {
				presuproyectocuentaAux.setIsChanged(false);
			}		
			
			if(presuproyectocuentaAux.getIsNew()) {
				presuproyectocuentaAux.setIsNew(false);
			}	
			
			if(presuproyectocuentaAux.getIsDeleted()) {
				presuproyectocuentaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PresuProyectoCuenta presuproyectocuentaAsignar,PresuProyectoCuenta presuproyectocuenta) throws Exception {
		presuproyectocuentaAsignar.setId(presuproyectocuenta.getId());	
		presuproyectocuentaAsignar.setVersionRow(presuproyectocuenta.getVersionRow());	
		presuproyectocuentaAsignar.setid_presu_proyecto(presuproyectocuenta.getid_presu_proyecto());
		presuproyectocuentaAsignar.setpresuproyecto_descripcion(presuproyectocuenta.getpresuproyecto_descripcion());	
		presuproyectocuentaAsignar.setid_presu_tipo_cuenta_proyecto(presuproyectocuenta.getid_presu_tipo_cuenta_proyecto());
		presuproyectocuentaAsignar.setpresutipocuentaproyecto_descripcion(presuproyectocuenta.getpresutipocuentaproyecto_descripcion());	
		presuproyectocuentaAsignar.setcodigo(presuproyectocuenta.getcodigo());	
		presuproyectocuentaAsignar.setnombre(presuproyectocuenta.getnombre());	
		presuproyectocuentaAsignar.setid_cuenta_contable(presuproyectocuenta.getid_cuenta_contable());
		presuproyectocuentaAsignar.setcuentacontable_descripcion(presuproyectocuenta.getcuentacontable_descripcion());	
		presuproyectocuentaAsignar.setid_empleado(presuproyectocuenta.getid_empleado());
		presuproyectocuentaAsignar.setempleado_descripcion(presuproyectocuenta.getempleado_descripcion());	
		presuproyectocuentaAsignar.setfecha(presuproyectocuenta.getfecha());	
		presuproyectocuentaAsignar.setvalor(presuproyectocuenta.getvalor());	
		presuproyectocuentaAsignar.setorden(presuproyectocuenta.getorden());	
		presuproyectocuentaAsignar.setid_presu_estado(presuproyectocuenta.getid_presu_estado());
		presuproyectocuentaAsignar.setpresuestado_descripcion(presuproyectocuenta.getpresuestado_descripcion());	
		presuproyectocuentaAsignar.setdescripcion(presuproyectocuenta.getdescripcion());	
	}
	
	public static void inicializarPresuProyectoCuenta(PresuProyectoCuenta presuproyectocuenta) throws Exception {
		try {
				presuproyectocuenta.setId(0L);	
					
				presuproyectocuenta.setid_presu_proyecto(-1L);	
				presuproyectocuenta.setid_presu_tipo_cuenta_proyecto(-1L);	
				presuproyectocuenta.setcodigo("");	
				presuproyectocuenta.setnombre("");	
				presuproyectocuenta.setid_cuenta_contable(-1L);	
				presuproyectocuenta.setid_empleado(-1L);	
				presuproyectocuenta.setfecha(new Date());	
				presuproyectocuenta.setvalor(0.0);	
				presuproyectocuenta.setorden(0);	
				presuproyectocuenta.setid_presu_estado(-1L);	
				presuproyectocuenta.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPresuProyectoCuenta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuProyectoCuentaConstantesFunciones.LABEL_IDPRESUPROYECTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuProyectoCuentaConstantesFunciones.LABEL_IDPRESUTIPOCUENTAPROYECTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuProyectoCuentaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuProyectoCuentaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuProyectoCuentaConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuProyectoCuentaConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuProyectoCuentaConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuProyectoCuentaConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuProyectoCuentaConstantesFunciones.LABEL_ORDEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuProyectoCuentaConstantesFunciones.LABEL_IDPRESUESTADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuProyectoCuentaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPresuProyectoCuenta(String sTipo,Row row,Workbook workbook,PresuProyectoCuenta presuproyectocuenta,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(presuproyectocuenta.getpresuproyecto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presuproyectocuenta.getpresutipocuentaproyecto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presuproyectocuenta.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presuproyectocuenta.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presuproyectocuenta.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presuproyectocuenta.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presuproyectocuenta.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presuproyectocuenta.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presuproyectocuenta.getorden());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presuproyectocuenta.getpresuestado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presuproyectocuenta.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPresuProyectoCuenta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPresuProyectoCuenta() {
		return this.sFinalQueryPresuProyectoCuenta;
	}
	
	public void setsFinalQueryPresuProyectoCuenta(String sFinalQueryPresuProyectoCuenta) {
		this.sFinalQueryPresuProyectoCuenta= sFinalQueryPresuProyectoCuenta;
	}
	
	public Border resaltarSeleccionarPresuProyectoCuenta=null;
	
	public Border setResaltarSeleccionarPresuProyectoCuenta(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoCuentaBeanSwingJInternalFrame presuproyectocuentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//presuproyectocuentaBeanSwingJInternalFrame.jTtoolBarPresuProyectoCuenta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPresuProyectoCuenta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPresuProyectoCuenta() {
		return this.resaltarSeleccionarPresuProyectoCuenta;
	}
	
	public void setResaltarSeleccionarPresuProyectoCuenta(Border borderResaltarSeleccionarPresuProyectoCuenta) {
		this.resaltarSeleccionarPresuProyectoCuenta= borderResaltarSeleccionarPresuProyectoCuenta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPresuProyectoCuenta=null;
	public Boolean mostraridPresuProyectoCuenta=true;
	public Boolean activaridPresuProyectoCuenta=true;

	public Border resaltarid_presu_proyectoPresuProyectoCuenta=null;
	public Boolean mostrarid_presu_proyectoPresuProyectoCuenta=true;
	public Boolean activarid_presu_proyectoPresuProyectoCuenta=true;
	public Boolean cargarid_presu_proyectoPresuProyectoCuenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_presu_proyectoPresuProyectoCuenta=false;//ConEventDepend=true

	public Border resaltarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta=null;
	public Boolean mostrarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta=true;
	public Boolean activarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta=true;
	public Boolean cargarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_presu_tipo_cuenta_proyectoPresuProyectoCuenta=false;//ConEventDepend=true

	public Border resaltarcodigoPresuProyectoCuenta=null;
	public Boolean mostrarcodigoPresuProyectoCuenta=true;
	public Boolean activarcodigoPresuProyectoCuenta=true;

	public Border resaltarnombrePresuProyectoCuenta=null;
	public Boolean mostrarnombrePresuProyectoCuenta=true;
	public Boolean activarnombrePresuProyectoCuenta=true;

	public Border resaltarid_cuenta_contablePresuProyectoCuenta=null;
	public Boolean mostrarid_cuenta_contablePresuProyectoCuenta=true;
	public Boolean activarid_cuenta_contablePresuProyectoCuenta=true;
	public Boolean cargarid_cuenta_contablePresuProyectoCuenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contablePresuProyectoCuenta=false;//ConEventDepend=true

	public Border resaltarid_empleadoPresuProyectoCuenta=null;
	public Boolean mostrarid_empleadoPresuProyectoCuenta=true;
	public Boolean activarid_empleadoPresuProyectoCuenta=true;
	public Boolean cargarid_empleadoPresuProyectoCuenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoPresuProyectoCuenta=false;//ConEventDepend=true

	public Border resaltarfechaPresuProyectoCuenta=null;
	public Boolean mostrarfechaPresuProyectoCuenta=true;
	public Boolean activarfechaPresuProyectoCuenta=false;

	public Border resaltarvalorPresuProyectoCuenta=null;
	public Boolean mostrarvalorPresuProyectoCuenta=true;
	public Boolean activarvalorPresuProyectoCuenta=true;

	public Border resaltarordenPresuProyectoCuenta=null;
	public Boolean mostrarordenPresuProyectoCuenta=true;
	public Boolean activarordenPresuProyectoCuenta=true;

	public Border resaltarid_presu_estadoPresuProyectoCuenta=null;
	public Boolean mostrarid_presu_estadoPresuProyectoCuenta=true;
	public Boolean activarid_presu_estadoPresuProyectoCuenta=true;
	public Boolean cargarid_presu_estadoPresuProyectoCuenta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_presu_estadoPresuProyectoCuenta=false;//ConEventDepend=true

	public Border resaltardescripcionPresuProyectoCuenta=null;
	public Boolean mostrardescripcionPresuProyectoCuenta=true;
	public Boolean activardescripcionPresuProyectoCuenta=true;

	
	

	public Border setResaltaridPresuProyectoCuenta(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoCuentaBeanSwingJInternalFrame presuproyectocuentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuproyectocuentaBeanSwingJInternalFrame.jTtoolBarPresuProyectoCuenta.setBorder(borderResaltar);
		
		this.resaltaridPresuProyectoCuenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPresuProyectoCuenta() {
		return this.resaltaridPresuProyectoCuenta;
	}

	public void setResaltaridPresuProyectoCuenta(Border borderResaltar) {
		this.resaltaridPresuProyectoCuenta= borderResaltar;
	}

	public Boolean getMostraridPresuProyectoCuenta() {
		return this.mostraridPresuProyectoCuenta;
	}

	public void setMostraridPresuProyectoCuenta(Boolean mostraridPresuProyectoCuenta) {
		this.mostraridPresuProyectoCuenta= mostraridPresuProyectoCuenta;
	}

	public Boolean getActivaridPresuProyectoCuenta() {
		return this.activaridPresuProyectoCuenta;
	}

	public void setActivaridPresuProyectoCuenta(Boolean activaridPresuProyectoCuenta) {
		this.activaridPresuProyectoCuenta= activaridPresuProyectoCuenta;
	}

	public Border setResaltarid_presu_proyectoPresuProyectoCuenta(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoCuentaBeanSwingJInternalFrame presuproyectocuentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuproyectocuentaBeanSwingJInternalFrame.jTtoolBarPresuProyectoCuenta.setBorder(borderResaltar);
		
		this.resaltarid_presu_proyectoPresuProyectoCuenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_presu_proyectoPresuProyectoCuenta() {
		return this.resaltarid_presu_proyectoPresuProyectoCuenta;
	}

	public void setResaltarid_presu_proyectoPresuProyectoCuenta(Border borderResaltar) {
		this.resaltarid_presu_proyectoPresuProyectoCuenta= borderResaltar;
	}

	public Boolean getMostrarid_presu_proyectoPresuProyectoCuenta() {
		return this.mostrarid_presu_proyectoPresuProyectoCuenta;
	}

	public void setMostrarid_presu_proyectoPresuProyectoCuenta(Boolean mostrarid_presu_proyectoPresuProyectoCuenta) {
		this.mostrarid_presu_proyectoPresuProyectoCuenta= mostrarid_presu_proyectoPresuProyectoCuenta;
	}

	public Boolean getActivarid_presu_proyectoPresuProyectoCuenta() {
		return this.activarid_presu_proyectoPresuProyectoCuenta;
	}

	public void setActivarid_presu_proyectoPresuProyectoCuenta(Boolean activarid_presu_proyectoPresuProyectoCuenta) {
		this.activarid_presu_proyectoPresuProyectoCuenta= activarid_presu_proyectoPresuProyectoCuenta;
	}

	public Boolean getCargarid_presu_proyectoPresuProyectoCuenta() {
		return this.cargarid_presu_proyectoPresuProyectoCuenta;
	}

	public void setCargarid_presu_proyectoPresuProyectoCuenta(Boolean cargarid_presu_proyectoPresuProyectoCuenta) {
		this.cargarid_presu_proyectoPresuProyectoCuenta= cargarid_presu_proyectoPresuProyectoCuenta;
	}

	public Border setResaltarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoCuentaBeanSwingJInternalFrame presuproyectocuentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuproyectocuentaBeanSwingJInternalFrame.jTtoolBarPresuProyectoCuenta.setBorder(borderResaltar);
		
		this.resaltarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta() {
		return this.resaltarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta;
	}

	public void setResaltarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta(Border borderResaltar) {
		this.resaltarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta= borderResaltar;
	}

	public Boolean getMostrarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta() {
		return this.mostrarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta;
	}

	public void setMostrarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta(Boolean mostrarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta) {
		this.mostrarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta= mostrarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta;
	}

	public Boolean getActivarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta() {
		return this.activarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta;
	}

	public void setActivarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta(Boolean activarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta) {
		this.activarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta= activarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta;
	}

	public Boolean getCargarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta() {
		return this.cargarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta;
	}

	public void setCargarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta(Boolean cargarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta) {
		this.cargarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta= cargarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta;
	}

	public Border setResaltarcodigoPresuProyectoCuenta(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoCuentaBeanSwingJInternalFrame presuproyectocuentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuproyectocuentaBeanSwingJInternalFrame.jTtoolBarPresuProyectoCuenta.setBorder(borderResaltar);
		
		this.resaltarcodigoPresuProyectoCuenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoPresuProyectoCuenta() {
		return this.resaltarcodigoPresuProyectoCuenta;
	}

	public void setResaltarcodigoPresuProyectoCuenta(Border borderResaltar) {
		this.resaltarcodigoPresuProyectoCuenta= borderResaltar;
	}

	public Boolean getMostrarcodigoPresuProyectoCuenta() {
		return this.mostrarcodigoPresuProyectoCuenta;
	}

	public void setMostrarcodigoPresuProyectoCuenta(Boolean mostrarcodigoPresuProyectoCuenta) {
		this.mostrarcodigoPresuProyectoCuenta= mostrarcodigoPresuProyectoCuenta;
	}

	public Boolean getActivarcodigoPresuProyectoCuenta() {
		return this.activarcodigoPresuProyectoCuenta;
	}

	public void setActivarcodigoPresuProyectoCuenta(Boolean activarcodigoPresuProyectoCuenta) {
		this.activarcodigoPresuProyectoCuenta= activarcodigoPresuProyectoCuenta;
	}

	public Border setResaltarnombrePresuProyectoCuenta(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoCuentaBeanSwingJInternalFrame presuproyectocuentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuproyectocuentaBeanSwingJInternalFrame.jTtoolBarPresuProyectoCuenta.setBorder(borderResaltar);
		
		this.resaltarnombrePresuProyectoCuenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombrePresuProyectoCuenta() {
		return this.resaltarnombrePresuProyectoCuenta;
	}

	public void setResaltarnombrePresuProyectoCuenta(Border borderResaltar) {
		this.resaltarnombrePresuProyectoCuenta= borderResaltar;
	}

	public Boolean getMostrarnombrePresuProyectoCuenta() {
		return this.mostrarnombrePresuProyectoCuenta;
	}

	public void setMostrarnombrePresuProyectoCuenta(Boolean mostrarnombrePresuProyectoCuenta) {
		this.mostrarnombrePresuProyectoCuenta= mostrarnombrePresuProyectoCuenta;
	}

	public Boolean getActivarnombrePresuProyectoCuenta() {
		return this.activarnombrePresuProyectoCuenta;
	}

	public void setActivarnombrePresuProyectoCuenta(Boolean activarnombrePresuProyectoCuenta) {
		this.activarnombrePresuProyectoCuenta= activarnombrePresuProyectoCuenta;
	}

	public Border setResaltarid_cuenta_contablePresuProyectoCuenta(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoCuentaBeanSwingJInternalFrame presuproyectocuentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuproyectocuentaBeanSwingJInternalFrame.jTtoolBarPresuProyectoCuenta.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contablePresuProyectoCuenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contablePresuProyectoCuenta() {
		return this.resaltarid_cuenta_contablePresuProyectoCuenta;
	}

	public void setResaltarid_cuenta_contablePresuProyectoCuenta(Border borderResaltar) {
		this.resaltarid_cuenta_contablePresuProyectoCuenta= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contablePresuProyectoCuenta() {
		return this.mostrarid_cuenta_contablePresuProyectoCuenta;
	}

	public void setMostrarid_cuenta_contablePresuProyectoCuenta(Boolean mostrarid_cuenta_contablePresuProyectoCuenta) {
		this.mostrarid_cuenta_contablePresuProyectoCuenta= mostrarid_cuenta_contablePresuProyectoCuenta;
	}

	public Boolean getActivarid_cuenta_contablePresuProyectoCuenta() {
		return this.activarid_cuenta_contablePresuProyectoCuenta;
	}

	public void setActivarid_cuenta_contablePresuProyectoCuenta(Boolean activarid_cuenta_contablePresuProyectoCuenta) {
		this.activarid_cuenta_contablePresuProyectoCuenta= activarid_cuenta_contablePresuProyectoCuenta;
	}

	public Boolean getCargarid_cuenta_contablePresuProyectoCuenta() {
		return this.cargarid_cuenta_contablePresuProyectoCuenta;
	}

	public void setCargarid_cuenta_contablePresuProyectoCuenta(Boolean cargarid_cuenta_contablePresuProyectoCuenta) {
		this.cargarid_cuenta_contablePresuProyectoCuenta= cargarid_cuenta_contablePresuProyectoCuenta;
	}

	public Border setResaltarid_empleadoPresuProyectoCuenta(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoCuentaBeanSwingJInternalFrame presuproyectocuentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuproyectocuentaBeanSwingJInternalFrame.jTtoolBarPresuProyectoCuenta.setBorder(borderResaltar);
		
		this.resaltarid_empleadoPresuProyectoCuenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoPresuProyectoCuenta() {
		return this.resaltarid_empleadoPresuProyectoCuenta;
	}

	public void setResaltarid_empleadoPresuProyectoCuenta(Border borderResaltar) {
		this.resaltarid_empleadoPresuProyectoCuenta= borderResaltar;
	}

	public Boolean getMostrarid_empleadoPresuProyectoCuenta() {
		return this.mostrarid_empleadoPresuProyectoCuenta;
	}

	public void setMostrarid_empleadoPresuProyectoCuenta(Boolean mostrarid_empleadoPresuProyectoCuenta) {
		this.mostrarid_empleadoPresuProyectoCuenta= mostrarid_empleadoPresuProyectoCuenta;
	}

	public Boolean getActivarid_empleadoPresuProyectoCuenta() {
		return this.activarid_empleadoPresuProyectoCuenta;
	}

	public void setActivarid_empleadoPresuProyectoCuenta(Boolean activarid_empleadoPresuProyectoCuenta) {
		this.activarid_empleadoPresuProyectoCuenta= activarid_empleadoPresuProyectoCuenta;
	}

	public Boolean getCargarid_empleadoPresuProyectoCuenta() {
		return this.cargarid_empleadoPresuProyectoCuenta;
	}

	public void setCargarid_empleadoPresuProyectoCuenta(Boolean cargarid_empleadoPresuProyectoCuenta) {
		this.cargarid_empleadoPresuProyectoCuenta= cargarid_empleadoPresuProyectoCuenta;
	}

	public Border setResaltarfechaPresuProyectoCuenta(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoCuentaBeanSwingJInternalFrame presuproyectocuentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuproyectocuentaBeanSwingJInternalFrame.jTtoolBarPresuProyectoCuenta.setBorder(borderResaltar);
		
		this.resaltarfechaPresuProyectoCuenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaPresuProyectoCuenta() {
		return this.resaltarfechaPresuProyectoCuenta;
	}

	public void setResaltarfechaPresuProyectoCuenta(Border borderResaltar) {
		this.resaltarfechaPresuProyectoCuenta= borderResaltar;
	}

	public Boolean getMostrarfechaPresuProyectoCuenta() {
		return this.mostrarfechaPresuProyectoCuenta;
	}

	public void setMostrarfechaPresuProyectoCuenta(Boolean mostrarfechaPresuProyectoCuenta) {
		this.mostrarfechaPresuProyectoCuenta= mostrarfechaPresuProyectoCuenta;
	}

	public Boolean getActivarfechaPresuProyectoCuenta() {
		return this.activarfechaPresuProyectoCuenta;
	}

	public void setActivarfechaPresuProyectoCuenta(Boolean activarfechaPresuProyectoCuenta) {
		this.activarfechaPresuProyectoCuenta= activarfechaPresuProyectoCuenta;
	}

	public Border setResaltarvalorPresuProyectoCuenta(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoCuentaBeanSwingJInternalFrame presuproyectocuentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuproyectocuentaBeanSwingJInternalFrame.jTtoolBarPresuProyectoCuenta.setBorder(borderResaltar);
		
		this.resaltarvalorPresuProyectoCuenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorPresuProyectoCuenta() {
		return this.resaltarvalorPresuProyectoCuenta;
	}

	public void setResaltarvalorPresuProyectoCuenta(Border borderResaltar) {
		this.resaltarvalorPresuProyectoCuenta= borderResaltar;
	}

	public Boolean getMostrarvalorPresuProyectoCuenta() {
		return this.mostrarvalorPresuProyectoCuenta;
	}

	public void setMostrarvalorPresuProyectoCuenta(Boolean mostrarvalorPresuProyectoCuenta) {
		this.mostrarvalorPresuProyectoCuenta= mostrarvalorPresuProyectoCuenta;
	}

	public Boolean getActivarvalorPresuProyectoCuenta() {
		return this.activarvalorPresuProyectoCuenta;
	}

	public void setActivarvalorPresuProyectoCuenta(Boolean activarvalorPresuProyectoCuenta) {
		this.activarvalorPresuProyectoCuenta= activarvalorPresuProyectoCuenta;
	}

	public Border setResaltarordenPresuProyectoCuenta(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoCuentaBeanSwingJInternalFrame presuproyectocuentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuproyectocuentaBeanSwingJInternalFrame.jTtoolBarPresuProyectoCuenta.setBorder(borderResaltar);
		
		this.resaltarordenPresuProyectoCuenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarordenPresuProyectoCuenta() {
		return this.resaltarordenPresuProyectoCuenta;
	}

	public void setResaltarordenPresuProyectoCuenta(Border borderResaltar) {
		this.resaltarordenPresuProyectoCuenta= borderResaltar;
	}

	public Boolean getMostrarordenPresuProyectoCuenta() {
		return this.mostrarordenPresuProyectoCuenta;
	}

	public void setMostrarordenPresuProyectoCuenta(Boolean mostrarordenPresuProyectoCuenta) {
		this.mostrarordenPresuProyectoCuenta= mostrarordenPresuProyectoCuenta;
	}

	public Boolean getActivarordenPresuProyectoCuenta() {
		return this.activarordenPresuProyectoCuenta;
	}

	public void setActivarordenPresuProyectoCuenta(Boolean activarordenPresuProyectoCuenta) {
		this.activarordenPresuProyectoCuenta= activarordenPresuProyectoCuenta;
	}

	public Border setResaltarid_presu_estadoPresuProyectoCuenta(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoCuentaBeanSwingJInternalFrame presuproyectocuentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuproyectocuentaBeanSwingJInternalFrame.jTtoolBarPresuProyectoCuenta.setBorder(borderResaltar);
		
		this.resaltarid_presu_estadoPresuProyectoCuenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_presu_estadoPresuProyectoCuenta() {
		return this.resaltarid_presu_estadoPresuProyectoCuenta;
	}

	public void setResaltarid_presu_estadoPresuProyectoCuenta(Border borderResaltar) {
		this.resaltarid_presu_estadoPresuProyectoCuenta= borderResaltar;
	}

	public Boolean getMostrarid_presu_estadoPresuProyectoCuenta() {
		return this.mostrarid_presu_estadoPresuProyectoCuenta;
	}

	public void setMostrarid_presu_estadoPresuProyectoCuenta(Boolean mostrarid_presu_estadoPresuProyectoCuenta) {
		this.mostrarid_presu_estadoPresuProyectoCuenta= mostrarid_presu_estadoPresuProyectoCuenta;
	}

	public Boolean getActivarid_presu_estadoPresuProyectoCuenta() {
		return this.activarid_presu_estadoPresuProyectoCuenta;
	}

	public void setActivarid_presu_estadoPresuProyectoCuenta(Boolean activarid_presu_estadoPresuProyectoCuenta) {
		this.activarid_presu_estadoPresuProyectoCuenta= activarid_presu_estadoPresuProyectoCuenta;
	}

	public Boolean getCargarid_presu_estadoPresuProyectoCuenta() {
		return this.cargarid_presu_estadoPresuProyectoCuenta;
	}

	public void setCargarid_presu_estadoPresuProyectoCuenta(Boolean cargarid_presu_estadoPresuProyectoCuenta) {
		this.cargarid_presu_estadoPresuProyectoCuenta= cargarid_presu_estadoPresuProyectoCuenta;
	}

	public Border setResaltardescripcionPresuProyectoCuenta(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoCuentaBeanSwingJInternalFrame presuproyectocuentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presuproyectocuentaBeanSwingJInternalFrame.jTtoolBarPresuProyectoCuenta.setBorder(borderResaltar);
		
		this.resaltardescripcionPresuProyectoCuenta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionPresuProyectoCuenta() {
		return this.resaltardescripcionPresuProyectoCuenta;
	}

	public void setResaltardescripcionPresuProyectoCuenta(Border borderResaltar) {
		this.resaltardescripcionPresuProyectoCuenta= borderResaltar;
	}

	public Boolean getMostrardescripcionPresuProyectoCuenta() {
		return this.mostrardescripcionPresuProyectoCuenta;
	}

	public void setMostrardescripcionPresuProyectoCuenta(Boolean mostrardescripcionPresuProyectoCuenta) {
		this.mostrardescripcionPresuProyectoCuenta= mostrardescripcionPresuProyectoCuenta;
	}

	public Boolean getActivardescripcionPresuProyectoCuenta() {
		return this.activardescripcionPresuProyectoCuenta;
	}

	public void setActivardescripcionPresuProyectoCuenta(Boolean activardescripcionPresuProyectoCuenta) {
		this.activardescripcionPresuProyectoCuenta= activardescripcionPresuProyectoCuenta;
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
		
		
		this.setMostraridPresuProyectoCuenta(esInicial);
		this.setMostrarid_presu_proyectoPresuProyectoCuenta(esInicial);
		this.setMostrarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta(esInicial);
		this.setMostrarcodigoPresuProyectoCuenta(esInicial);
		this.setMostrarnombrePresuProyectoCuenta(esInicial);
		this.setMostrarid_cuenta_contablePresuProyectoCuenta(esInicial);
		this.setMostrarid_empleadoPresuProyectoCuenta(esInicial);
		this.setMostrarfechaPresuProyectoCuenta(esInicial);
		this.setMostrarvalorPresuProyectoCuenta(esInicial);
		this.setMostrarordenPresuProyectoCuenta(esInicial);
		this.setMostrarid_presu_estadoPresuProyectoCuenta(esInicial);
		this.setMostrardescripcionPresuProyectoCuenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.ID)) {
				this.setMostraridPresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.IDPRESUPROYECTO)) {
				this.setMostrarid_presu_proyectoPresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.IDPRESUTIPOCUENTAPROYECTO)) {
				this.setMostrarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoPresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombrePresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contablePresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoPresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.FECHA)) {
				this.setMostrarfechaPresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.VALOR)) {
				this.setMostrarvalorPresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.ORDEN)) {
				this.setMostrarordenPresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.IDPRESUESTADO)) {
				this.setMostrarid_presu_estadoPresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionPresuProyectoCuenta(esAsigna);
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
		
		
		this.setActivaridPresuProyectoCuenta(esInicial);
		this.setActivarid_presu_proyectoPresuProyectoCuenta(esInicial);
		this.setActivarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta(esInicial);
		this.setActivarcodigoPresuProyectoCuenta(esInicial);
		this.setActivarnombrePresuProyectoCuenta(esInicial);
		this.setActivarid_cuenta_contablePresuProyectoCuenta(esInicial);
		this.setActivarid_empleadoPresuProyectoCuenta(esInicial);
		this.setActivarfechaPresuProyectoCuenta(esInicial);
		this.setActivarvalorPresuProyectoCuenta(esInicial);
		this.setActivarordenPresuProyectoCuenta(esInicial);
		this.setActivarid_presu_estadoPresuProyectoCuenta(esInicial);
		this.setActivardescripcionPresuProyectoCuenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.ID)) {
				this.setActivaridPresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.IDPRESUPROYECTO)) {
				this.setActivarid_presu_proyectoPresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.IDPRESUTIPOCUENTAPROYECTO)) {
				this.setActivarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoPresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.NOMBRE)) {
				this.setActivarnombrePresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contablePresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoPresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.FECHA)) {
				this.setActivarfechaPresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.VALOR)) {
				this.setActivarvalorPresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.ORDEN)) {
				this.setActivarordenPresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.IDPRESUESTADO)) {
				this.setActivarid_presu_estadoPresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionPresuProyectoCuenta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PresuProyectoCuentaBeanSwingJInternalFrame presuproyectocuentaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPresuProyectoCuenta(esInicial);
		this.setResaltarid_presu_proyectoPresuProyectoCuenta(esInicial);
		this.setResaltarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta(esInicial);
		this.setResaltarcodigoPresuProyectoCuenta(esInicial);
		this.setResaltarnombrePresuProyectoCuenta(esInicial);
		this.setResaltarid_cuenta_contablePresuProyectoCuenta(esInicial);
		this.setResaltarid_empleadoPresuProyectoCuenta(esInicial);
		this.setResaltarfechaPresuProyectoCuenta(esInicial);
		this.setResaltarvalorPresuProyectoCuenta(esInicial);
		this.setResaltarordenPresuProyectoCuenta(esInicial);
		this.setResaltarid_presu_estadoPresuProyectoCuenta(esInicial);
		this.setResaltardescripcionPresuProyectoCuenta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.ID)) {
				this.setResaltaridPresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.IDPRESUPROYECTO)) {
				this.setResaltarid_presu_proyectoPresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.IDPRESUTIPOCUENTAPROYECTO)) {
				this.setResaltarid_presu_tipo_cuenta_proyectoPresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoPresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombrePresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contablePresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoPresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.FECHA)) {
				this.setResaltarfechaPresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.VALOR)) {
				this.setResaltarvalorPresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.ORDEN)) {
				this.setResaltarordenPresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.IDPRESUESTADO)) {
				this.setResaltarid_presu_estadoPresuProyectoCuenta(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuProyectoCuentaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionPresuProyectoCuenta(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarPresuAsignacionPresuProyectoCuenta=null;

	public Border getResaltarPresuAsignacionPresuProyectoCuenta() {
		return this.resaltarPresuAsignacionPresuProyectoCuenta;
	}

	public void setResaltarPresuAsignacionPresuProyectoCuenta(Border borderResaltarPresuAsignacion) {
		if(borderResaltarPresuAsignacion!=null) {
			this.resaltarPresuAsignacionPresuProyectoCuenta= borderResaltarPresuAsignacion;
		}
	}

	public Border setResaltarPresuAsignacionPresuProyectoCuenta(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoCuentaBeanSwingJInternalFrame presuproyectocuentaBeanSwingJInternalFrame*/) {
		Border borderResaltarPresuAsignacion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//presuproyectocuentaBeanSwingJInternalFrame.jTtoolBarPresuProyectoCuenta.setBorder(borderResaltarPresuAsignacion);
			
		this.resaltarPresuAsignacionPresuProyectoCuenta= borderResaltarPresuAsignacion;

		 return borderResaltarPresuAsignacion;
	}



	public Boolean mostrarPresuAsignacionPresuProyectoCuenta=true;

	public Boolean getMostrarPresuAsignacionPresuProyectoCuenta() {
		return this.mostrarPresuAsignacionPresuProyectoCuenta;
	}

	public void setMostrarPresuAsignacionPresuProyectoCuenta(Boolean visibilidadResaltarPresuAsignacion) {
		this.mostrarPresuAsignacionPresuProyectoCuenta= visibilidadResaltarPresuAsignacion;
	}



	public Boolean activarPresuAsignacionPresuProyectoCuenta=true;

	public Boolean gethabilitarResaltarPresuAsignacionPresuProyectoCuenta() {
		return this.activarPresuAsignacionPresuProyectoCuenta;
	}

	public void setActivarPresuAsignacionPresuProyectoCuenta(Boolean habilitarResaltarPresuAsignacion) {
		this.activarPresuAsignacionPresuProyectoCuenta= habilitarResaltarPresuAsignacion;
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

		this.setMostrarPresuAsignacionPresuProyectoCuenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PresuAsignacion.class)) {
				this.setMostrarPresuAsignacionPresuProyectoCuenta(esAsigna);
				continue;
			}
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

		this.setActivarPresuAsignacionPresuProyectoCuenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PresuAsignacion.class)) {
				this.setActivarPresuAsignacionPresuProyectoCuenta(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PresuProyectoCuentaBeanSwingJInternalFrame presuproyectocuentaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarPresuAsignacionPresuProyectoCuenta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PresuAsignacion.class)) {
				this.setResaltarPresuAsignacionPresuProyectoCuenta(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorProyectoPorCodigoPresuProyectoCuenta=true;

	public Boolean getMostrarBusquedaPorProyectoPorCodigoPresuProyectoCuenta() {
		return this.mostrarBusquedaPorProyectoPorCodigoPresuProyectoCuenta;
	}

	public void setMostrarBusquedaPorProyectoPorCodigoPresuProyectoCuenta(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorProyectoPorCodigoPresuProyectoCuenta= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorProyectoPorNombrePresuProyectoCuenta=true;

	public Boolean getMostrarBusquedaPorProyectoPorNombrePresuProyectoCuenta() {
		return this.mostrarBusquedaPorProyectoPorNombrePresuProyectoCuenta;
	}

	public void setMostrarBusquedaPorProyectoPorNombrePresuProyectoCuenta(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorProyectoPorNombrePresuProyectoCuenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContablePresuProyectoCuenta=true;

	public Boolean getMostrarFK_IdCuentaContablePresuProyectoCuenta() {
		return this.mostrarFK_IdCuentaContablePresuProyectoCuenta;
	}

	public void setMostrarFK_IdCuentaContablePresuProyectoCuenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContablePresuProyectoCuenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoPresuProyectoCuenta=true;

	public Boolean getMostrarFK_IdEmpleadoPresuProyectoCuenta() {
		return this.mostrarFK_IdEmpleadoPresuProyectoCuenta;
	}

	public void setMostrarFK_IdEmpleadoPresuProyectoCuenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoPresuProyectoCuenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPresuEstadoPresuProyectoCuenta=true;

	public Boolean getMostrarFK_IdPresuEstadoPresuProyectoCuenta() {
		return this.mostrarFK_IdPresuEstadoPresuProyectoCuenta;
	}

	public void setMostrarFK_IdPresuEstadoPresuProyectoCuenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPresuEstadoPresuProyectoCuenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPresuProyectoPresuProyectoCuenta=true;

	public Boolean getMostrarFK_IdPresuProyectoPresuProyectoCuenta() {
		return this.mostrarFK_IdPresuProyectoPresuProyectoCuenta;
	}

	public void setMostrarFK_IdPresuProyectoPresuProyectoCuenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPresuProyectoPresuProyectoCuenta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPresuTipoCuentaProyectoPresuProyectoCuenta=true;

	public Boolean getMostrarFK_IdPresuTipoCuentaProyectoPresuProyectoCuenta() {
		return this.mostrarFK_IdPresuTipoCuentaProyectoPresuProyectoCuenta;
	}

	public void setMostrarFK_IdPresuTipoCuentaProyectoPresuProyectoCuenta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPresuTipoCuentaProyectoPresuProyectoCuenta= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorProyectoPorCodigoPresuProyectoCuenta=true;

	public Boolean getActivarBusquedaPorProyectoPorCodigoPresuProyectoCuenta() {
		return this.activarBusquedaPorProyectoPorCodigoPresuProyectoCuenta;
	}

	public void setActivarBusquedaPorProyectoPorCodigoPresuProyectoCuenta(Boolean habilitarResaltar) {
		this.activarBusquedaPorProyectoPorCodigoPresuProyectoCuenta= habilitarResaltar;
	}

	public Boolean activarBusquedaPorProyectoPorNombrePresuProyectoCuenta=true;

	public Boolean getActivarBusquedaPorProyectoPorNombrePresuProyectoCuenta() {
		return this.activarBusquedaPorProyectoPorNombrePresuProyectoCuenta;
	}

	public void setActivarBusquedaPorProyectoPorNombrePresuProyectoCuenta(Boolean habilitarResaltar) {
		this.activarBusquedaPorProyectoPorNombrePresuProyectoCuenta= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContablePresuProyectoCuenta=true;

	public Boolean getActivarFK_IdCuentaContablePresuProyectoCuenta() {
		return this.activarFK_IdCuentaContablePresuProyectoCuenta;
	}

	public void setActivarFK_IdCuentaContablePresuProyectoCuenta(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContablePresuProyectoCuenta= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoPresuProyectoCuenta=true;

	public Boolean getActivarFK_IdEmpleadoPresuProyectoCuenta() {
		return this.activarFK_IdEmpleadoPresuProyectoCuenta;
	}

	public void setActivarFK_IdEmpleadoPresuProyectoCuenta(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoPresuProyectoCuenta= habilitarResaltar;
	}

	public Boolean activarFK_IdPresuEstadoPresuProyectoCuenta=true;

	public Boolean getActivarFK_IdPresuEstadoPresuProyectoCuenta() {
		return this.activarFK_IdPresuEstadoPresuProyectoCuenta;
	}

	public void setActivarFK_IdPresuEstadoPresuProyectoCuenta(Boolean habilitarResaltar) {
		this.activarFK_IdPresuEstadoPresuProyectoCuenta= habilitarResaltar;
	}

	public Boolean activarFK_IdPresuProyectoPresuProyectoCuenta=true;

	public Boolean getActivarFK_IdPresuProyectoPresuProyectoCuenta() {
		return this.activarFK_IdPresuProyectoPresuProyectoCuenta;
	}

	public void setActivarFK_IdPresuProyectoPresuProyectoCuenta(Boolean habilitarResaltar) {
		this.activarFK_IdPresuProyectoPresuProyectoCuenta= habilitarResaltar;
	}

	public Boolean activarFK_IdPresuTipoCuentaProyectoPresuProyectoCuenta=true;

	public Boolean getActivarFK_IdPresuTipoCuentaProyectoPresuProyectoCuenta() {
		return this.activarFK_IdPresuTipoCuentaProyectoPresuProyectoCuenta;
	}

	public void setActivarFK_IdPresuTipoCuentaProyectoPresuProyectoCuenta(Boolean habilitarResaltar) {
		this.activarFK_IdPresuTipoCuentaProyectoPresuProyectoCuenta= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorProyectoPorCodigoPresuProyectoCuenta=null;

	public Border getResaltarBusquedaPorProyectoPorCodigoPresuProyectoCuenta() {
		return this.resaltarBusquedaPorProyectoPorCodigoPresuProyectoCuenta;
	}

	public void setResaltarBusquedaPorProyectoPorCodigoPresuProyectoCuenta(Border borderResaltar) {
		this.resaltarBusquedaPorProyectoPorCodigoPresuProyectoCuenta= borderResaltar;
	}

	public void setResaltarBusquedaPorProyectoPorCodigoPresuProyectoCuenta(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoCuentaBeanSwingJInternalFrame presuproyectocuentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorProyectoPorCodigoPresuProyectoCuenta= borderResaltar;
	}

	public Border resaltarBusquedaPorProyectoPorNombrePresuProyectoCuenta=null;

	public Border getResaltarBusquedaPorProyectoPorNombrePresuProyectoCuenta() {
		return this.resaltarBusquedaPorProyectoPorNombrePresuProyectoCuenta;
	}

	public void setResaltarBusquedaPorProyectoPorNombrePresuProyectoCuenta(Border borderResaltar) {
		this.resaltarBusquedaPorProyectoPorNombrePresuProyectoCuenta= borderResaltar;
	}

	public void setResaltarBusquedaPorProyectoPorNombrePresuProyectoCuenta(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoCuentaBeanSwingJInternalFrame presuproyectocuentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorProyectoPorNombrePresuProyectoCuenta= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContablePresuProyectoCuenta=null;

	public Border getResaltarFK_IdCuentaContablePresuProyectoCuenta() {
		return this.resaltarFK_IdCuentaContablePresuProyectoCuenta;
	}

	public void setResaltarFK_IdCuentaContablePresuProyectoCuenta(Border borderResaltar) {
		this.resaltarFK_IdCuentaContablePresuProyectoCuenta= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContablePresuProyectoCuenta(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoCuentaBeanSwingJInternalFrame presuproyectocuentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContablePresuProyectoCuenta= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoPresuProyectoCuenta=null;

	public Border getResaltarFK_IdEmpleadoPresuProyectoCuenta() {
		return this.resaltarFK_IdEmpleadoPresuProyectoCuenta;
	}

	public void setResaltarFK_IdEmpleadoPresuProyectoCuenta(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoPresuProyectoCuenta= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoPresuProyectoCuenta(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoCuentaBeanSwingJInternalFrame presuproyectocuentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoPresuProyectoCuenta= borderResaltar;
	}

	public Border resaltarFK_IdPresuEstadoPresuProyectoCuenta=null;

	public Border getResaltarFK_IdPresuEstadoPresuProyectoCuenta() {
		return this.resaltarFK_IdPresuEstadoPresuProyectoCuenta;
	}

	public void setResaltarFK_IdPresuEstadoPresuProyectoCuenta(Border borderResaltar) {
		this.resaltarFK_IdPresuEstadoPresuProyectoCuenta= borderResaltar;
	}

	public void setResaltarFK_IdPresuEstadoPresuProyectoCuenta(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoCuentaBeanSwingJInternalFrame presuproyectocuentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPresuEstadoPresuProyectoCuenta= borderResaltar;
	}

	public Border resaltarFK_IdPresuProyectoPresuProyectoCuenta=null;

	public Border getResaltarFK_IdPresuProyectoPresuProyectoCuenta() {
		return this.resaltarFK_IdPresuProyectoPresuProyectoCuenta;
	}

	public void setResaltarFK_IdPresuProyectoPresuProyectoCuenta(Border borderResaltar) {
		this.resaltarFK_IdPresuProyectoPresuProyectoCuenta= borderResaltar;
	}

	public void setResaltarFK_IdPresuProyectoPresuProyectoCuenta(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoCuentaBeanSwingJInternalFrame presuproyectocuentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPresuProyectoPresuProyectoCuenta= borderResaltar;
	}

	public Border resaltarFK_IdPresuTipoCuentaProyectoPresuProyectoCuenta=null;

	public Border getResaltarFK_IdPresuTipoCuentaProyectoPresuProyectoCuenta() {
		return this.resaltarFK_IdPresuTipoCuentaProyectoPresuProyectoCuenta;
	}

	public void setResaltarFK_IdPresuTipoCuentaProyectoPresuProyectoCuenta(Border borderResaltar) {
		this.resaltarFK_IdPresuTipoCuentaProyectoPresuProyectoCuenta= borderResaltar;
	}

	public void setResaltarFK_IdPresuTipoCuentaProyectoPresuProyectoCuenta(ParametroGeneralUsuario parametroGeneralUsuario/*PresuProyectoCuentaBeanSwingJInternalFrame presuproyectocuentaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPresuTipoCuentaProyectoPresuProyectoCuenta= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}