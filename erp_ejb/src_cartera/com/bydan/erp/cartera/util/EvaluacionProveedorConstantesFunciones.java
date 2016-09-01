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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.EvaluacionProveedorConstantesFunciones;
import com.bydan.erp.cartera.util.EvaluacionProveedorParameterReturnGeneral;
//import com.bydan.erp.cartera.util.EvaluacionProveedorParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EvaluacionProveedorConstantesFunciones extends EvaluacionProveedorConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EvaluacionProveedor";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EvaluacionProveedor"+EvaluacionProveedorConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EvaluacionProveedorHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EvaluacionProveedorHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EvaluacionProveedorConstantesFunciones.SCHEMA+"_"+EvaluacionProveedorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EvaluacionProveedorHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EvaluacionProveedorConstantesFunciones.SCHEMA+"_"+EvaluacionProveedorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EvaluacionProveedorConstantesFunciones.SCHEMA+"_"+EvaluacionProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EvaluacionProveedorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EvaluacionProveedorConstantesFunciones.SCHEMA+"_"+EvaluacionProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EvaluacionProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EvaluacionProveedorHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EvaluacionProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EvaluacionProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EvaluacionProveedorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EvaluacionProveedorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EvaluacionProveedorConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EvaluacionProveedorConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EvaluacionProveedorConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EvaluacionProveedorConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Evaluacion Proveedores";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Evaluacion Proveedor";
	public static final String SCLASSWEBTITULO_LOWER="Evaluacion Proveedor";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EvaluacionProveedor";
	public static final String OBJECTNAME="evaluacionproveedor";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="evaluacion_proveedor";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select evaluacionproveedor from "+EvaluacionProveedorConstantesFunciones.SPERSISTENCENAME+" evaluacionproveedor";
	public static String QUERYSELECTNATIVE="select "+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".id,"+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".version_row,"+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".id_empresa,"+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".id_sucursal,"+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".id_ejercicio,"+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".id_periodo,"+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".id_cliente,"+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".fecha,"+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".contacto,"+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".evaluado,"+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".resultado,"+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".responsable,"+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".fecha_desde,"+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".fecha_hasta,"+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME+".observacion from "+EvaluacionProveedorConstantesFunciones.SCHEMA+"."+EvaluacionProveedorConstantesFunciones.TABLENAME;//+" as "+EvaluacionProveedorConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EvaluacionProveedorConstantesFuncionesAdditional evaluacionproveedorConstantesFuncionesAdditional=null;
	
	public EvaluacionProveedorConstantesFuncionesAdditional getEvaluacionProveedorConstantesFuncionesAdditional() {
		return this.evaluacionproveedorConstantesFuncionesAdditional;
	}
	
	public void setEvaluacionProveedorConstantesFuncionesAdditional(EvaluacionProveedorConstantesFuncionesAdditional evaluacionproveedorConstantesFuncionesAdditional) {
		try {
			this.evaluacionproveedorConstantesFuncionesAdditional=evaluacionproveedorConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDCLIENTE= "id_cliente";
    public static final String FECHA= "fecha";
    public static final String CONTACTO= "contacto";
    public static final String EVALUADO= "evaluado";
    public static final String RESULTADO= "resultado";
    public static final String RESPONSABLE= "responsable";
    public static final String FECHADESDE= "fecha_desde";
    public static final String FECHAHASTA= "fecha_hasta";
    public static final String OBSERVACION= "observacion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_CONTACTO= "Contacto";
		public static final String LABEL_CONTACTO_LOWER= "Contacto";
    	public static final String LABEL_EVALUADO= "Evaluado";
		public static final String LABEL_EVALUADO_LOWER= "Evaluado";
    	public static final String LABEL_RESULTADO= "Resultado";
		public static final String LABEL_RESULTADO_LOWER= "Resultado";
    	public static final String LABEL_RESPONSABLE= "Responsable";
		public static final String LABEL_RESPONSABLE_LOWER= "Responsable";
    	public static final String LABEL_FECHADESDE= "Fecha Desde";
		public static final String LABEL_FECHADESDE_LOWER= "Fecha Desde";
    	public static final String LABEL_FECHAHASTA= "Fecha Hasta";
		public static final String LABEL_FECHAHASTA_LOWER= "Fecha Hasta";
    	public static final String LABEL_OBSERVACION= "Observacion";
		public static final String LABEL_OBSERVACION_LOWER= "Observacion";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXCONTACTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCONTACTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXEVALUADO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXEVALUADO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRESULTADO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRESULTADO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRESPONSABLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRESPONSABLE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXOBSERVACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXOBSERVACION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getEvaluacionProveedorLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EvaluacionProveedorConstantesFunciones.IDEMPRESA)) {sLabelColumna=EvaluacionProveedorConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EvaluacionProveedorConstantesFunciones.IDSUCURSAL)) {sLabelColumna=EvaluacionProveedorConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(EvaluacionProveedorConstantesFunciones.IDEJERCICIO)) {sLabelColumna=EvaluacionProveedorConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(EvaluacionProveedorConstantesFunciones.IDPERIODO)) {sLabelColumna=EvaluacionProveedorConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(EvaluacionProveedorConstantesFunciones.IDCLIENTE)) {sLabelColumna=EvaluacionProveedorConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(EvaluacionProveedorConstantesFunciones.FECHA)) {sLabelColumna=EvaluacionProveedorConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(EvaluacionProveedorConstantesFunciones.CONTACTO)) {sLabelColumna=EvaluacionProveedorConstantesFunciones.LABEL_CONTACTO;}
		if(sNombreColumna.equals(EvaluacionProveedorConstantesFunciones.EVALUADO)) {sLabelColumna=EvaluacionProveedorConstantesFunciones.LABEL_EVALUADO;}
		if(sNombreColumna.equals(EvaluacionProveedorConstantesFunciones.RESULTADO)) {sLabelColumna=EvaluacionProveedorConstantesFunciones.LABEL_RESULTADO;}
		if(sNombreColumna.equals(EvaluacionProveedorConstantesFunciones.RESPONSABLE)) {sLabelColumna=EvaluacionProveedorConstantesFunciones.LABEL_RESPONSABLE;}
		if(sNombreColumna.equals(EvaluacionProveedorConstantesFunciones.FECHADESDE)) {sLabelColumna=EvaluacionProveedorConstantesFunciones.LABEL_FECHADESDE;}
		if(sNombreColumna.equals(EvaluacionProveedorConstantesFunciones.FECHAHASTA)) {sLabelColumna=EvaluacionProveedorConstantesFunciones.LABEL_FECHAHASTA;}
		if(sNombreColumna.equals(EvaluacionProveedorConstantesFunciones.OBSERVACION)) {sLabelColumna=EvaluacionProveedorConstantesFunciones.LABEL_OBSERVACION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getEvaluacionProveedorDescripcion(EvaluacionProveedor evaluacionproveedor) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(evaluacionproveedor !=null/* && evaluacionproveedor.getId()!=0*/) {
			if(evaluacionproveedor.getId()!=null) {
				sDescripcion=evaluacionproveedor.getId().toString();
			}//evaluacionproveedorevaluacionproveedor.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getEvaluacionProveedorDescripcionDetallado(EvaluacionProveedor evaluacionproveedor) {
		String sDescripcion="";
			
		sDescripcion+=EvaluacionProveedorConstantesFunciones.ID+"=";
		sDescripcion+=evaluacionproveedor.getId().toString()+",";
		sDescripcion+=EvaluacionProveedorConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=evaluacionproveedor.getVersionRow().toString()+",";
		sDescripcion+=EvaluacionProveedorConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=evaluacionproveedor.getid_empresa().toString()+",";
		sDescripcion+=EvaluacionProveedorConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=evaluacionproveedor.getid_sucursal().toString()+",";
		sDescripcion+=EvaluacionProveedorConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=evaluacionproveedor.getid_ejercicio().toString()+",";
		sDescripcion+=EvaluacionProveedorConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=evaluacionproveedor.getid_periodo().toString()+",";
		sDescripcion+=EvaluacionProveedorConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=evaluacionproveedor.getid_cliente().toString()+",";
		sDescripcion+=EvaluacionProveedorConstantesFunciones.FECHA+"=";
		sDescripcion+=evaluacionproveedor.getfecha().toString()+",";
		sDescripcion+=EvaluacionProveedorConstantesFunciones.CONTACTO+"=";
		sDescripcion+=evaluacionproveedor.getcontacto()+",";
		sDescripcion+=EvaluacionProveedorConstantesFunciones.EVALUADO+"=";
		sDescripcion+=evaluacionproveedor.getevaluado()+",";
		sDescripcion+=EvaluacionProveedorConstantesFunciones.RESULTADO+"=";
		sDescripcion+=evaluacionproveedor.getresultado()+",";
		sDescripcion+=EvaluacionProveedorConstantesFunciones.RESPONSABLE+"=";
		sDescripcion+=evaluacionproveedor.getresponsable()+",";
		sDescripcion+=EvaluacionProveedorConstantesFunciones.FECHADESDE+"=";
		sDescripcion+=evaluacionproveedor.getfecha_desde().toString()+",";
		sDescripcion+=EvaluacionProveedorConstantesFunciones.FECHAHASTA+"=";
		sDescripcion+=evaluacionproveedor.getfecha_hasta().toString()+",";
		sDescripcion+=EvaluacionProveedorConstantesFunciones.OBSERVACION+"=";
		sDescripcion+=evaluacionproveedor.getobservacion()+",";
			
		return sDescripcion;
	}
	
	public static void setEvaluacionProveedorDescripcion(EvaluacionProveedor evaluacionproveedor,String sValor) throws Exception {			
		if(evaluacionproveedor !=null) {
			//evaluacionproveedorevaluacionproveedor.getId().toString();
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

	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodo!=null/*&&periodo.getId()>0*/) {
			sDescripcion=PeriodoConstantesFunciones.getPeriodoDescripcion(periodo);
		}

		return sDescripcion;
	}

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEvaluacionProveedor(EvaluacionProveedor evaluacionproveedor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		evaluacionproveedor.setcontacto(evaluacionproveedor.getcontacto().trim());
		evaluacionproveedor.setevaluado(evaluacionproveedor.getevaluado().trim());
		evaluacionproveedor.setresultado(evaluacionproveedor.getresultado().trim());
		evaluacionproveedor.setresponsable(evaluacionproveedor.getresponsable().trim());
		evaluacionproveedor.setobservacion(evaluacionproveedor.getobservacion().trim());
	}
	
	public static void quitarEspaciosEvaluacionProveedors(List<EvaluacionProveedor> evaluacionproveedors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EvaluacionProveedor evaluacionproveedor: evaluacionproveedors) {
			evaluacionproveedor.setcontacto(evaluacionproveedor.getcontacto().trim());
			evaluacionproveedor.setevaluado(evaluacionproveedor.getevaluado().trim());
			evaluacionproveedor.setresultado(evaluacionproveedor.getresultado().trim());
			evaluacionproveedor.setresponsable(evaluacionproveedor.getresponsable().trim());
			evaluacionproveedor.setobservacion(evaluacionproveedor.getobservacion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEvaluacionProveedor(EvaluacionProveedor evaluacionproveedor,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && evaluacionproveedor.getConCambioAuxiliar()) {
			evaluacionproveedor.setIsDeleted(evaluacionproveedor.getIsDeletedAuxiliar());	
			evaluacionproveedor.setIsNew(evaluacionproveedor.getIsNewAuxiliar());	
			evaluacionproveedor.setIsChanged(evaluacionproveedor.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			evaluacionproveedor.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			evaluacionproveedor.setIsDeletedAuxiliar(false);	
			evaluacionproveedor.setIsNewAuxiliar(false);	
			evaluacionproveedor.setIsChangedAuxiliar(false);
			
			evaluacionproveedor.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEvaluacionProveedors(List<EvaluacionProveedor> evaluacionproveedors,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EvaluacionProveedor evaluacionproveedor : evaluacionproveedors) {
			if(conAsignarBase && evaluacionproveedor.getConCambioAuxiliar()) {
				evaluacionproveedor.setIsDeleted(evaluacionproveedor.getIsDeletedAuxiliar());	
				evaluacionproveedor.setIsNew(evaluacionproveedor.getIsNewAuxiliar());	
				evaluacionproveedor.setIsChanged(evaluacionproveedor.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				evaluacionproveedor.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				evaluacionproveedor.setIsDeletedAuxiliar(false);	
				evaluacionproveedor.setIsNewAuxiliar(false);	
				evaluacionproveedor.setIsChangedAuxiliar(false);
				
				evaluacionproveedor.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEvaluacionProveedor(EvaluacionProveedor evaluacionproveedor,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEvaluacionProveedors(List<EvaluacionProveedor> evaluacionproveedors,Boolean conEnteros) throws Exception  {
		
		for(EvaluacionProveedor evaluacionproveedor: evaluacionproveedors) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEvaluacionProveedor(List<EvaluacionProveedor> evaluacionproveedors,EvaluacionProveedor evaluacionproveedorAux) throws Exception  {
		EvaluacionProveedorConstantesFunciones.InicializarValoresEvaluacionProveedor(evaluacionproveedorAux,true);
		
		for(EvaluacionProveedor evaluacionproveedor: evaluacionproveedors) {
			if(evaluacionproveedor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEvaluacionProveedor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EvaluacionProveedorConstantesFunciones.getArrayColumnasGlobalesEvaluacionProveedor(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEvaluacionProveedor(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EvaluacionProveedorConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EvaluacionProveedorConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EvaluacionProveedorConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EvaluacionProveedorConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EvaluacionProveedorConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EvaluacionProveedorConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EvaluacionProveedorConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EvaluacionProveedorConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEvaluacionProveedor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EvaluacionProveedor> evaluacionproveedors,EvaluacionProveedor evaluacionproveedor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EvaluacionProveedor evaluacionproveedorAux: evaluacionproveedors) {
			if(evaluacionproveedorAux!=null && evaluacionproveedor!=null) {
				if((evaluacionproveedorAux.getId()==null && evaluacionproveedor.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(evaluacionproveedorAux.getId()!=null && evaluacionproveedor.getId()!=null){
					if(evaluacionproveedorAux.getId().equals(evaluacionproveedor.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEvaluacionProveedor(List<EvaluacionProveedor> evaluacionproveedors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EvaluacionProveedor evaluacionproveedor: evaluacionproveedors) {			
			if(evaluacionproveedor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEvaluacionProveedor() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EvaluacionProveedorConstantesFunciones.LABEL_ID, EvaluacionProveedorConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionProveedorConstantesFunciones.LABEL_VERSIONROW, EvaluacionProveedorConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionProveedorConstantesFunciones.LABEL_IDEMPRESA, EvaluacionProveedorConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionProveedorConstantesFunciones.LABEL_IDSUCURSAL, EvaluacionProveedorConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionProveedorConstantesFunciones.LABEL_IDEJERCICIO, EvaluacionProveedorConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionProveedorConstantesFunciones.LABEL_IDPERIODO, EvaluacionProveedorConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionProveedorConstantesFunciones.LABEL_IDCLIENTE, EvaluacionProveedorConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionProveedorConstantesFunciones.LABEL_FECHA, EvaluacionProveedorConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionProveedorConstantesFunciones.LABEL_CONTACTO, EvaluacionProveedorConstantesFunciones.CONTACTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionProveedorConstantesFunciones.LABEL_EVALUADO, EvaluacionProveedorConstantesFunciones.EVALUADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionProveedorConstantesFunciones.LABEL_RESULTADO, EvaluacionProveedorConstantesFunciones.RESULTADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionProveedorConstantesFunciones.LABEL_RESPONSABLE, EvaluacionProveedorConstantesFunciones.RESPONSABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionProveedorConstantesFunciones.LABEL_FECHADESDE, EvaluacionProveedorConstantesFunciones.FECHADESDE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionProveedorConstantesFunciones.LABEL_FECHAHASTA, EvaluacionProveedorConstantesFunciones.FECHAHASTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EvaluacionProveedorConstantesFunciones.LABEL_OBSERVACION, EvaluacionProveedorConstantesFunciones.OBSERVACION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEvaluacionProveedor() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EvaluacionProveedorConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionProveedorConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionProveedorConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionProveedorConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionProveedorConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionProveedorConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionProveedorConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionProveedorConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionProveedorConstantesFunciones.CONTACTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionProveedorConstantesFunciones.EVALUADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionProveedorConstantesFunciones.RESULTADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionProveedorConstantesFunciones.RESPONSABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionProveedorConstantesFunciones.FECHADESDE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionProveedorConstantesFunciones.FECHAHASTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EvaluacionProveedorConstantesFunciones.OBSERVACION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEvaluacionProveedor() throws Exception  {
		return EvaluacionProveedorConstantesFunciones.getTiposSeleccionarEvaluacionProveedor(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEvaluacionProveedor(Boolean conFk) throws Exception  {
		return EvaluacionProveedorConstantesFunciones.getTiposSeleccionarEvaluacionProveedor(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEvaluacionProveedor(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionProveedorConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EvaluacionProveedorConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionProveedorConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(EvaluacionProveedorConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionProveedorConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(EvaluacionProveedorConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionProveedorConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(EvaluacionProveedorConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionProveedorConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(EvaluacionProveedorConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionProveedorConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(EvaluacionProveedorConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionProveedorConstantesFunciones.LABEL_CONTACTO);
			reporte.setsDescripcion(EvaluacionProveedorConstantesFunciones.LABEL_CONTACTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionProveedorConstantesFunciones.LABEL_EVALUADO);
			reporte.setsDescripcion(EvaluacionProveedorConstantesFunciones.LABEL_EVALUADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionProveedorConstantesFunciones.LABEL_RESULTADO);
			reporte.setsDescripcion(EvaluacionProveedorConstantesFunciones.LABEL_RESULTADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionProveedorConstantesFunciones.LABEL_RESPONSABLE);
			reporte.setsDescripcion(EvaluacionProveedorConstantesFunciones.LABEL_RESPONSABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionProveedorConstantesFunciones.LABEL_FECHADESDE);
			reporte.setsDescripcion(EvaluacionProveedorConstantesFunciones.LABEL_FECHADESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionProveedorConstantesFunciones.LABEL_FECHAHASTA);
			reporte.setsDescripcion(EvaluacionProveedorConstantesFunciones.LABEL_FECHAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EvaluacionProveedorConstantesFunciones.LABEL_OBSERVACION);
			reporte.setsDescripcion(EvaluacionProveedorConstantesFunciones.LABEL_OBSERVACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEvaluacionProveedor(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEvaluacionProveedor(EvaluacionProveedor evaluacionproveedorAux) throws Exception {
		
			evaluacionproveedorAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(evaluacionproveedorAux.getEmpresa()));
			evaluacionproveedorAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(evaluacionproveedorAux.getSucursal()));
			evaluacionproveedorAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(evaluacionproveedorAux.getEjercicio()));
			evaluacionproveedorAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(evaluacionproveedorAux.getPeriodo()));
			evaluacionproveedorAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(evaluacionproveedorAux.getCliente()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEvaluacionProveedor(List<EvaluacionProveedor> evaluacionproveedorsTemp) throws Exception {
		for(EvaluacionProveedor evaluacionproveedorAux:evaluacionproveedorsTemp) {
			
			evaluacionproveedorAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(evaluacionproveedorAux.getEmpresa()));
			evaluacionproveedorAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(evaluacionproveedorAux.getSucursal()));
			evaluacionproveedorAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(evaluacionproveedorAux.getEjercicio()));
			evaluacionproveedorAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(evaluacionproveedorAux.getPeriodo()));
			evaluacionproveedorAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(evaluacionproveedorAux.getCliente()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEvaluacionProveedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Cliente.class));
				
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
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEvaluacionProveedor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEvaluacionProveedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EvaluacionProveedorConstantesFunciones.getClassesRelationshipsOfEvaluacionProveedor(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEvaluacionProveedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleEvaluacionProveedor.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleEvaluacionProveedor.class)) {
						classes.add(new Classe(DetalleEvaluacionProveedor.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEvaluacionProveedor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EvaluacionProveedorConstantesFunciones.getClassesRelationshipsFromStringsOfEvaluacionProveedor(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEvaluacionProveedor(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleEvaluacionProveedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleEvaluacionProveedor.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleEvaluacionProveedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleEvaluacionProveedor.class)); continue;
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
	public static void actualizarLista(EvaluacionProveedor evaluacionproveedor,List<EvaluacionProveedor> evaluacionproveedors,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EvaluacionProveedor evaluacionproveedorEncontrado=null;
			
			for(EvaluacionProveedor evaluacionproveedorLocal:evaluacionproveedors) {
				if(evaluacionproveedorLocal.getId().equals(evaluacionproveedor.getId())) {
					evaluacionproveedorEncontrado=evaluacionproveedorLocal;
					
					evaluacionproveedorLocal.setIsChanged(evaluacionproveedor.getIsChanged());
					evaluacionproveedorLocal.setIsNew(evaluacionproveedor.getIsNew());
					evaluacionproveedorLocal.setIsDeleted(evaluacionproveedor.getIsDeleted());
					
					evaluacionproveedorLocal.setGeneralEntityOriginal(evaluacionproveedor.getGeneralEntityOriginal());
					
					evaluacionproveedorLocal.setId(evaluacionproveedor.getId());	
					evaluacionproveedorLocal.setVersionRow(evaluacionproveedor.getVersionRow());	
					evaluacionproveedorLocal.setid_empresa(evaluacionproveedor.getid_empresa());	
					evaluacionproveedorLocal.setid_sucursal(evaluacionproveedor.getid_sucursal());	
					evaluacionproveedorLocal.setid_ejercicio(evaluacionproveedor.getid_ejercicio());	
					evaluacionproveedorLocal.setid_periodo(evaluacionproveedor.getid_periodo());	
					evaluacionproveedorLocal.setid_cliente(evaluacionproveedor.getid_cliente());	
					evaluacionproveedorLocal.setfecha(evaluacionproveedor.getfecha());	
					evaluacionproveedorLocal.setcontacto(evaluacionproveedor.getcontacto());	
					evaluacionproveedorLocal.setevaluado(evaluacionproveedor.getevaluado());	
					evaluacionproveedorLocal.setresultado(evaluacionproveedor.getresultado());	
					evaluacionproveedorLocal.setresponsable(evaluacionproveedor.getresponsable());	
					evaluacionproveedorLocal.setfecha_desde(evaluacionproveedor.getfecha_desde());	
					evaluacionproveedorLocal.setfecha_hasta(evaluacionproveedor.getfecha_hasta());	
					evaluacionproveedorLocal.setobservacion(evaluacionproveedor.getobservacion());	
					
					
					evaluacionproveedorLocal.setDetalleEvaluacionProveedors(evaluacionproveedor.getDetalleEvaluacionProveedors());
					
					existe=true;
					break;
				}
			}
			
			if(!evaluacionproveedor.getIsDeleted()) {
				if(!existe) {
					evaluacionproveedors.add(evaluacionproveedor);
				}
			} else {
				if(evaluacionproveedorEncontrado!=null && permiteQuitar)  {
					evaluacionproveedors.remove(evaluacionproveedorEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EvaluacionProveedor evaluacionproveedor,List<EvaluacionProveedor> evaluacionproveedors) throws Exception {
		try	{			
			for(EvaluacionProveedor evaluacionproveedorLocal:evaluacionproveedors) {
				if(evaluacionproveedorLocal.getId().equals(evaluacionproveedor.getId())) {
					evaluacionproveedorLocal.setIsSelected(evaluacionproveedor.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEvaluacionProveedor(List<EvaluacionProveedor> evaluacionproveedorsAux) throws Exception {
		//this.evaluacionproveedorsAux=evaluacionproveedorsAux;
		
		for(EvaluacionProveedor evaluacionproveedorAux:evaluacionproveedorsAux) {
			if(evaluacionproveedorAux.getIsChanged()) {
				evaluacionproveedorAux.setIsChanged(false);
			}		
			
			if(evaluacionproveedorAux.getIsNew()) {
				evaluacionproveedorAux.setIsNew(false);
			}	
			
			if(evaluacionproveedorAux.getIsDeleted()) {
				evaluacionproveedorAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEvaluacionProveedor(EvaluacionProveedor evaluacionproveedorAux) throws Exception {
		//this.evaluacionproveedorAux=evaluacionproveedorAux;
		
			if(evaluacionproveedorAux.getIsChanged()) {
				evaluacionproveedorAux.setIsChanged(false);
			}		
			
			if(evaluacionproveedorAux.getIsNew()) {
				evaluacionproveedorAux.setIsNew(false);
			}	
			
			if(evaluacionproveedorAux.getIsDeleted()) {
				evaluacionproveedorAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EvaluacionProveedor evaluacionproveedorAsignar,EvaluacionProveedor evaluacionproveedor) throws Exception {
		evaluacionproveedorAsignar.setId(evaluacionproveedor.getId());	
		evaluacionproveedorAsignar.setVersionRow(evaluacionproveedor.getVersionRow());	
		evaluacionproveedorAsignar.setid_empresa(evaluacionproveedor.getid_empresa());
		evaluacionproveedorAsignar.setempresa_descripcion(evaluacionproveedor.getempresa_descripcion());	
		evaluacionproveedorAsignar.setid_sucursal(evaluacionproveedor.getid_sucursal());
		evaluacionproveedorAsignar.setsucursal_descripcion(evaluacionproveedor.getsucursal_descripcion());	
		evaluacionproveedorAsignar.setid_ejercicio(evaluacionproveedor.getid_ejercicio());
		evaluacionproveedorAsignar.setejercicio_descripcion(evaluacionproveedor.getejercicio_descripcion());	
		evaluacionproveedorAsignar.setid_periodo(evaluacionproveedor.getid_periodo());
		evaluacionproveedorAsignar.setperiodo_descripcion(evaluacionproveedor.getperiodo_descripcion());	
		evaluacionproveedorAsignar.setid_cliente(evaluacionproveedor.getid_cliente());
		evaluacionproveedorAsignar.setcliente_descripcion(evaluacionproveedor.getcliente_descripcion());	
		evaluacionproveedorAsignar.setfecha(evaluacionproveedor.getfecha());	
		evaluacionproveedorAsignar.setcontacto(evaluacionproveedor.getcontacto());	
		evaluacionproveedorAsignar.setevaluado(evaluacionproveedor.getevaluado());	
		evaluacionproveedorAsignar.setresultado(evaluacionproveedor.getresultado());	
		evaluacionproveedorAsignar.setresponsable(evaluacionproveedor.getresponsable());	
		evaluacionproveedorAsignar.setfecha_desde(evaluacionproveedor.getfecha_desde());	
		evaluacionproveedorAsignar.setfecha_hasta(evaluacionproveedor.getfecha_hasta());	
		evaluacionproveedorAsignar.setobservacion(evaluacionproveedor.getobservacion());	
	}
	
	public static void inicializarEvaluacionProveedor(EvaluacionProveedor evaluacionproveedor) throws Exception {
		try {
				evaluacionproveedor.setId(0L);	
					
				evaluacionproveedor.setid_empresa(-1L);	
				evaluacionproveedor.setid_sucursal(-1L);	
				evaluacionproveedor.setid_ejercicio(-1L);	
				evaluacionproveedor.setid_periodo(-1L);	
				evaluacionproveedor.setid_cliente(-1L);	
				evaluacionproveedor.setfecha(new Date());	
				evaluacionproveedor.setcontacto("");	
				evaluacionproveedor.setevaluado("");	
				evaluacionproveedor.setresultado("");	
				evaluacionproveedor.setresponsable("");	
				evaluacionproveedor.setfecha_desde(new Date());	
				evaluacionproveedor.setfecha_hasta(new Date());	
				evaluacionproveedor.setobservacion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEvaluacionProveedor(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionProveedorConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionProveedorConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionProveedorConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionProveedorConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionProveedorConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionProveedorConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionProveedorConstantesFunciones.LABEL_CONTACTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionProveedorConstantesFunciones.LABEL_EVALUADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionProveedorConstantesFunciones.LABEL_RESULTADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionProveedorConstantesFunciones.LABEL_RESPONSABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionProveedorConstantesFunciones.LABEL_FECHADESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionProveedorConstantesFunciones.LABEL_FECHAHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EvaluacionProveedorConstantesFunciones.LABEL_OBSERVACION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEvaluacionProveedor(String sTipo,Row row,Workbook workbook,EvaluacionProveedor evaluacionproveedor,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionproveedor.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionproveedor.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionproveedor.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionproveedor.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionproveedor.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionproveedor.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionproveedor.getcontacto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionproveedor.getevaluado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionproveedor.getresultado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionproveedor.getresponsable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionproveedor.getfecha_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionproveedor.getfecha_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(evaluacionproveedor.getobservacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEvaluacionProveedor=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEvaluacionProveedor() {
		return this.sFinalQueryEvaluacionProveedor;
	}
	
	public void setsFinalQueryEvaluacionProveedor(String sFinalQueryEvaluacionProveedor) {
		this.sFinalQueryEvaluacionProveedor= sFinalQueryEvaluacionProveedor;
	}
	
	public Border resaltarSeleccionarEvaluacionProveedor=null;
	
	public Border setResaltarSeleccionarEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionProveedorBeanSwingJInternalFrame evaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//evaluacionproveedorBeanSwingJInternalFrame.jTtoolBarEvaluacionProveedor.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEvaluacionProveedor= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEvaluacionProveedor() {
		return this.resaltarSeleccionarEvaluacionProveedor;
	}
	
	public void setResaltarSeleccionarEvaluacionProveedor(Border borderResaltarSeleccionarEvaluacionProveedor) {
		this.resaltarSeleccionarEvaluacionProveedor= borderResaltarSeleccionarEvaluacionProveedor;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEvaluacionProveedor=null;
	public Boolean mostraridEvaluacionProveedor=true;
	public Boolean activaridEvaluacionProveedor=true;

	public Border resaltarid_empresaEvaluacionProveedor=null;
	public Boolean mostrarid_empresaEvaluacionProveedor=true;
	public Boolean activarid_empresaEvaluacionProveedor=true;
	public Boolean cargarid_empresaEvaluacionProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEvaluacionProveedor=false;//ConEventDepend=true

	public Border resaltarid_sucursalEvaluacionProveedor=null;
	public Boolean mostrarid_sucursalEvaluacionProveedor=true;
	public Boolean activarid_sucursalEvaluacionProveedor=true;
	public Boolean cargarid_sucursalEvaluacionProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalEvaluacionProveedor=false;//ConEventDepend=true

	public Border resaltarid_ejercicioEvaluacionProveedor=null;
	public Boolean mostrarid_ejercicioEvaluacionProveedor=true;
	public Boolean activarid_ejercicioEvaluacionProveedor=true;
	public Boolean cargarid_ejercicioEvaluacionProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioEvaluacionProveedor=false;//ConEventDepend=true

	public Border resaltarid_periodoEvaluacionProveedor=null;
	public Boolean mostrarid_periodoEvaluacionProveedor=true;
	public Boolean activarid_periodoEvaluacionProveedor=true;
	public Boolean cargarid_periodoEvaluacionProveedor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoEvaluacionProveedor=false;//ConEventDepend=true

	public Border resaltarid_clienteEvaluacionProveedor=null;
	public Boolean mostrarid_clienteEvaluacionProveedor=true;
	public Boolean activarid_clienteEvaluacionProveedor=true;
	public Boolean cargarid_clienteEvaluacionProveedor=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteEvaluacionProveedor=false;//ConEventDepend=true

	public Border resaltarfechaEvaluacionProveedor=null;
	public Boolean mostrarfechaEvaluacionProveedor=true;
	public Boolean activarfechaEvaluacionProveedor=false;

	public Border resaltarcontactoEvaluacionProveedor=null;
	public Boolean mostrarcontactoEvaluacionProveedor=true;
	public Boolean activarcontactoEvaluacionProveedor=true;

	public Border resaltarevaluadoEvaluacionProveedor=null;
	public Boolean mostrarevaluadoEvaluacionProveedor=true;
	public Boolean activarevaluadoEvaluacionProveedor=true;

	public Border resaltarresultadoEvaluacionProveedor=null;
	public Boolean mostrarresultadoEvaluacionProveedor=true;
	public Boolean activarresultadoEvaluacionProveedor=true;

	public Border resaltarresponsableEvaluacionProveedor=null;
	public Boolean mostrarresponsableEvaluacionProveedor=true;
	public Boolean activarresponsableEvaluacionProveedor=true;

	public Border resaltarfecha_desdeEvaluacionProveedor=null;
	public Boolean mostrarfecha_desdeEvaluacionProveedor=true;
	public Boolean activarfecha_desdeEvaluacionProveedor=false;

	public Border resaltarfecha_hastaEvaluacionProveedor=null;
	public Boolean mostrarfecha_hastaEvaluacionProveedor=true;
	public Boolean activarfecha_hastaEvaluacionProveedor=false;

	public Border resaltarobservacionEvaluacionProveedor=null;
	public Boolean mostrarobservacionEvaluacionProveedor=true;
	public Boolean activarobservacionEvaluacionProveedor=true;

	
	

	public Border setResaltaridEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionProveedorBeanSwingJInternalFrame evaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionproveedorBeanSwingJInternalFrame.jTtoolBarEvaluacionProveedor.setBorder(borderResaltar);
		
		this.resaltaridEvaluacionProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEvaluacionProveedor() {
		return this.resaltaridEvaluacionProveedor;
	}

	public void setResaltaridEvaluacionProveedor(Border borderResaltar) {
		this.resaltaridEvaluacionProveedor= borderResaltar;
	}

	public Boolean getMostraridEvaluacionProveedor() {
		return this.mostraridEvaluacionProveedor;
	}

	public void setMostraridEvaluacionProveedor(Boolean mostraridEvaluacionProveedor) {
		this.mostraridEvaluacionProveedor= mostraridEvaluacionProveedor;
	}

	public Boolean getActivaridEvaluacionProveedor() {
		return this.activaridEvaluacionProveedor;
	}

	public void setActivaridEvaluacionProveedor(Boolean activaridEvaluacionProveedor) {
		this.activaridEvaluacionProveedor= activaridEvaluacionProveedor;
	}

	public Border setResaltarid_empresaEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionProveedorBeanSwingJInternalFrame evaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionproveedorBeanSwingJInternalFrame.jTtoolBarEvaluacionProveedor.setBorder(borderResaltar);
		
		this.resaltarid_empresaEvaluacionProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEvaluacionProveedor() {
		return this.resaltarid_empresaEvaluacionProveedor;
	}

	public void setResaltarid_empresaEvaluacionProveedor(Border borderResaltar) {
		this.resaltarid_empresaEvaluacionProveedor= borderResaltar;
	}

	public Boolean getMostrarid_empresaEvaluacionProveedor() {
		return this.mostrarid_empresaEvaluacionProveedor;
	}

	public void setMostrarid_empresaEvaluacionProveedor(Boolean mostrarid_empresaEvaluacionProveedor) {
		this.mostrarid_empresaEvaluacionProveedor= mostrarid_empresaEvaluacionProveedor;
	}

	public Boolean getActivarid_empresaEvaluacionProveedor() {
		return this.activarid_empresaEvaluacionProveedor;
	}

	public void setActivarid_empresaEvaluacionProveedor(Boolean activarid_empresaEvaluacionProveedor) {
		this.activarid_empresaEvaluacionProveedor= activarid_empresaEvaluacionProveedor;
	}

	public Boolean getCargarid_empresaEvaluacionProveedor() {
		return this.cargarid_empresaEvaluacionProveedor;
	}

	public void setCargarid_empresaEvaluacionProveedor(Boolean cargarid_empresaEvaluacionProveedor) {
		this.cargarid_empresaEvaluacionProveedor= cargarid_empresaEvaluacionProveedor;
	}

	public Border setResaltarid_sucursalEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionProveedorBeanSwingJInternalFrame evaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionproveedorBeanSwingJInternalFrame.jTtoolBarEvaluacionProveedor.setBorder(borderResaltar);
		
		this.resaltarid_sucursalEvaluacionProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalEvaluacionProveedor() {
		return this.resaltarid_sucursalEvaluacionProveedor;
	}

	public void setResaltarid_sucursalEvaluacionProveedor(Border borderResaltar) {
		this.resaltarid_sucursalEvaluacionProveedor= borderResaltar;
	}

	public Boolean getMostrarid_sucursalEvaluacionProveedor() {
		return this.mostrarid_sucursalEvaluacionProveedor;
	}

	public void setMostrarid_sucursalEvaluacionProveedor(Boolean mostrarid_sucursalEvaluacionProveedor) {
		this.mostrarid_sucursalEvaluacionProveedor= mostrarid_sucursalEvaluacionProveedor;
	}

	public Boolean getActivarid_sucursalEvaluacionProveedor() {
		return this.activarid_sucursalEvaluacionProveedor;
	}

	public void setActivarid_sucursalEvaluacionProveedor(Boolean activarid_sucursalEvaluacionProveedor) {
		this.activarid_sucursalEvaluacionProveedor= activarid_sucursalEvaluacionProveedor;
	}

	public Boolean getCargarid_sucursalEvaluacionProveedor() {
		return this.cargarid_sucursalEvaluacionProveedor;
	}

	public void setCargarid_sucursalEvaluacionProveedor(Boolean cargarid_sucursalEvaluacionProveedor) {
		this.cargarid_sucursalEvaluacionProveedor= cargarid_sucursalEvaluacionProveedor;
	}

	public Border setResaltarid_ejercicioEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionProveedorBeanSwingJInternalFrame evaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionproveedorBeanSwingJInternalFrame.jTtoolBarEvaluacionProveedor.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioEvaluacionProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioEvaluacionProveedor() {
		return this.resaltarid_ejercicioEvaluacionProveedor;
	}

	public void setResaltarid_ejercicioEvaluacionProveedor(Border borderResaltar) {
		this.resaltarid_ejercicioEvaluacionProveedor= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioEvaluacionProveedor() {
		return this.mostrarid_ejercicioEvaluacionProveedor;
	}

	public void setMostrarid_ejercicioEvaluacionProveedor(Boolean mostrarid_ejercicioEvaluacionProveedor) {
		this.mostrarid_ejercicioEvaluacionProveedor= mostrarid_ejercicioEvaluacionProveedor;
	}

	public Boolean getActivarid_ejercicioEvaluacionProveedor() {
		return this.activarid_ejercicioEvaluacionProveedor;
	}

	public void setActivarid_ejercicioEvaluacionProveedor(Boolean activarid_ejercicioEvaluacionProveedor) {
		this.activarid_ejercicioEvaluacionProveedor= activarid_ejercicioEvaluacionProveedor;
	}

	public Boolean getCargarid_ejercicioEvaluacionProveedor() {
		return this.cargarid_ejercicioEvaluacionProveedor;
	}

	public void setCargarid_ejercicioEvaluacionProveedor(Boolean cargarid_ejercicioEvaluacionProveedor) {
		this.cargarid_ejercicioEvaluacionProveedor= cargarid_ejercicioEvaluacionProveedor;
	}

	public Border setResaltarid_periodoEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionProveedorBeanSwingJInternalFrame evaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionproveedorBeanSwingJInternalFrame.jTtoolBarEvaluacionProveedor.setBorder(borderResaltar);
		
		this.resaltarid_periodoEvaluacionProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoEvaluacionProveedor() {
		return this.resaltarid_periodoEvaluacionProveedor;
	}

	public void setResaltarid_periodoEvaluacionProveedor(Border borderResaltar) {
		this.resaltarid_periodoEvaluacionProveedor= borderResaltar;
	}

	public Boolean getMostrarid_periodoEvaluacionProveedor() {
		return this.mostrarid_periodoEvaluacionProveedor;
	}

	public void setMostrarid_periodoEvaluacionProveedor(Boolean mostrarid_periodoEvaluacionProveedor) {
		this.mostrarid_periodoEvaluacionProveedor= mostrarid_periodoEvaluacionProveedor;
	}

	public Boolean getActivarid_periodoEvaluacionProveedor() {
		return this.activarid_periodoEvaluacionProveedor;
	}

	public void setActivarid_periodoEvaluacionProveedor(Boolean activarid_periodoEvaluacionProveedor) {
		this.activarid_periodoEvaluacionProveedor= activarid_periodoEvaluacionProveedor;
	}

	public Boolean getCargarid_periodoEvaluacionProveedor() {
		return this.cargarid_periodoEvaluacionProveedor;
	}

	public void setCargarid_periodoEvaluacionProveedor(Boolean cargarid_periodoEvaluacionProveedor) {
		this.cargarid_periodoEvaluacionProveedor= cargarid_periodoEvaluacionProveedor;
	}

	public Border setResaltarid_clienteEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionProveedorBeanSwingJInternalFrame evaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionproveedorBeanSwingJInternalFrame.jTtoolBarEvaluacionProveedor.setBorder(borderResaltar);
		
		this.resaltarid_clienteEvaluacionProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteEvaluacionProveedor() {
		return this.resaltarid_clienteEvaluacionProveedor;
	}

	public void setResaltarid_clienteEvaluacionProveedor(Border borderResaltar) {
		this.resaltarid_clienteEvaluacionProveedor= borderResaltar;
	}

	public Boolean getMostrarid_clienteEvaluacionProveedor() {
		return this.mostrarid_clienteEvaluacionProveedor;
	}

	public void setMostrarid_clienteEvaluacionProveedor(Boolean mostrarid_clienteEvaluacionProveedor) {
		this.mostrarid_clienteEvaluacionProveedor= mostrarid_clienteEvaluacionProveedor;
	}

	public Boolean getActivarid_clienteEvaluacionProveedor() {
		return this.activarid_clienteEvaluacionProveedor;
	}

	public void setActivarid_clienteEvaluacionProveedor(Boolean activarid_clienteEvaluacionProveedor) {
		this.activarid_clienteEvaluacionProveedor= activarid_clienteEvaluacionProveedor;
	}

	public Boolean getCargarid_clienteEvaluacionProveedor() {
		return this.cargarid_clienteEvaluacionProveedor;
	}

	public void setCargarid_clienteEvaluacionProveedor(Boolean cargarid_clienteEvaluacionProveedor) {
		this.cargarid_clienteEvaluacionProveedor= cargarid_clienteEvaluacionProveedor;
	}

	public Border setResaltarfechaEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionProveedorBeanSwingJInternalFrame evaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionproveedorBeanSwingJInternalFrame.jTtoolBarEvaluacionProveedor.setBorder(borderResaltar);
		
		this.resaltarfechaEvaluacionProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaEvaluacionProveedor() {
		return this.resaltarfechaEvaluacionProveedor;
	}

	public void setResaltarfechaEvaluacionProveedor(Border borderResaltar) {
		this.resaltarfechaEvaluacionProveedor= borderResaltar;
	}

	public Boolean getMostrarfechaEvaluacionProveedor() {
		return this.mostrarfechaEvaluacionProveedor;
	}

	public void setMostrarfechaEvaluacionProveedor(Boolean mostrarfechaEvaluacionProveedor) {
		this.mostrarfechaEvaluacionProveedor= mostrarfechaEvaluacionProveedor;
	}

	public Boolean getActivarfechaEvaluacionProveedor() {
		return this.activarfechaEvaluacionProveedor;
	}

	public void setActivarfechaEvaluacionProveedor(Boolean activarfechaEvaluacionProveedor) {
		this.activarfechaEvaluacionProveedor= activarfechaEvaluacionProveedor;
	}

	public Border setResaltarcontactoEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionProveedorBeanSwingJInternalFrame evaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionproveedorBeanSwingJInternalFrame.jTtoolBarEvaluacionProveedor.setBorder(borderResaltar);
		
		this.resaltarcontactoEvaluacionProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcontactoEvaluacionProveedor() {
		return this.resaltarcontactoEvaluacionProveedor;
	}

	public void setResaltarcontactoEvaluacionProveedor(Border borderResaltar) {
		this.resaltarcontactoEvaluacionProveedor= borderResaltar;
	}

	public Boolean getMostrarcontactoEvaluacionProveedor() {
		return this.mostrarcontactoEvaluacionProveedor;
	}

	public void setMostrarcontactoEvaluacionProveedor(Boolean mostrarcontactoEvaluacionProveedor) {
		this.mostrarcontactoEvaluacionProveedor= mostrarcontactoEvaluacionProveedor;
	}

	public Boolean getActivarcontactoEvaluacionProveedor() {
		return this.activarcontactoEvaluacionProveedor;
	}

	public void setActivarcontactoEvaluacionProveedor(Boolean activarcontactoEvaluacionProveedor) {
		this.activarcontactoEvaluacionProveedor= activarcontactoEvaluacionProveedor;
	}

	public Border setResaltarevaluadoEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionProveedorBeanSwingJInternalFrame evaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionproveedorBeanSwingJInternalFrame.jTtoolBarEvaluacionProveedor.setBorder(borderResaltar);
		
		this.resaltarevaluadoEvaluacionProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarevaluadoEvaluacionProveedor() {
		return this.resaltarevaluadoEvaluacionProveedor;
	}

	public void setResaltarevaluadoEvaluacionProveedor(Border borderResaltar) {
		this.resaltarevaluadoEvaluacionProveedor= borderResaltar;
	}

	public Boolean getMostrarevaluadoEvaluacionProveedor() {
		return this.mostrarevaluadoEvaluacionProveedor;
	}

	public void setMostrarevaluadoEvaluacionProveedor(Boolean mostrarevaluadoEvaluacionProveedor) {
		this.mostrarevaluadoEvaluacionProveedor= mostrarevaluadoEvaluacionProveedor;
	}

	public Boolean getActivarevaluadoEvaluacionProveedor() {
		return this.activarevaluadoEvaluacionProveedor;
	}

	public void setActivarevaluadoEvaluacionProveedor(Boolean activarevaluadoEvaluacionProveedor) {
		this.activarevaluadoEvaluacionProveedor= activarevaluadoEvaluacionProveedor;
	}

	public Border setResaltarresultadoEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionProveedorBeanSwingJInternalFrame evaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionproveedorBeanSwingJInternalFrame.jTtoolBarEvaluacionProveedor.setBorder(borderResaltar);
		
		this.resaltarresultadoEvaluacionProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarresultadoEvaluacionProveedor() {
		return this.resaltarresultadoEvaluacionProveedor;
	}

	public void setResaltarresultadoEvaluacionProveedor(Border borderResaltar) {
		this.resaltarresultadoEvaluacionProveedor= borderResaltar;
	}

	public Boolean getMostrarresultadoEvaluacionProveedor() {
		return this.mostrarresultadoEvaluacionProveedor;
	}

	public void setMostrarresultadoEvaluacionProveedor(Boolean mostrarresultadoEvaluacionProveedor) {
		this.mostrarresultadoEvaluacionProveedor= mostrarresultadoEvaluacionProveedor;
	}

	public Boolean getActivarresultadoEvaluacionProveedor() {
		return this.activarresultadoEvaluacionProveedor;
	}

	public void setActivarresultadoEvaluacionProveedor(Boolean activarresultadoEvaluacionProveedor) {
		this.activarresultadoEvaluacionProveedor= activarresultadoEvaluacionProveedor;
	}

	public Border setResaltarresponsableEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionProveedorBeanSwingJInternalFrame evaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionproveedorBeanSwingJInternalFrame.jTtoolBarEvaluacionProveedor.setBorder(borderResaltar);
		
		this.resaltarresponsableEvaluacionProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarresponsableEvaluacionProveedor() {
		return this.resaltarresponsableEvaluacionProveedor;
	}

	public void setResaltarresponsableEvaluacionProveedor(Border borderResaltar) {
		this.resaltarresponsableEvaluacionProveedor= borderResaltar;
	}

	public Boolean getMostrarresponsableEvaluacionProveedor() {
		return this.mostrarresponsableEvaluacionProveedor;
	}

	public void setMostrarresponsableEvaluacionProveedor(Boolean mostrarresponsableEvaluacionProveedor) {
		this.mostrarresponsableEvaluacionProveedor= mostrarresponsableEvaluacionProveedor;
	}

	public Boolean getActivarresponsableEvaluacionProveedor() {
		return this.activarresponsableEvaluacionProveedor;
	}

	public void setActivarresponsableEvaluacionProveedor(Boolean activarresponsableEvaluacionProveedor) {
		this.activarresponsableEvaluacionProveedor= activarresponsableEvaluacionProveedor;
	}

	public Border setResaltarfecha_desdeEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionProveedorBeanSwingJInternalFrame evaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionproveedorBeanSwingJInternalFrame.jTtoolBarEvaluacionProveedor.setBorder(borderResaltar);
		
		this.resaltarfecha_desdeEvaluacionProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_desdeEvaluacionProveedor() {
		return this.resaltarfecha_desdeEvaluacionProveedor;
	}

	public void setResaltarfecha_desdeEvaluacionProveedor(Border borderResaltar) {
		this.resaltarfecha_desdeEvaluacionProveedor= borderResaltar;
	}

	public Boolean getMostrarfecha_desdeEvaluacionProveedor() {
		return this.mostrarfecha_desdeEvaluacionProveedor;
	}

	public void setMostrarfecha_desdeEvaluacionProveedor(Boolean mostrarfecha_desdeEvaluacionProveedor) {
		this.mostrarfecha_desdeEvaluacionProveedor= mostrarfecha_desdeEvaluacionProveedor;
	}

	public Boolean getActivarfecha_desdeEvaluacionProveedor() {
		return this.activarfecha_desdeEvaluacionProveedor;
	}

	public void setActivarfecha_desdeEvaluacionProveedor(Boolean activarfecha_desdeEvaluacionProveedor) {
		this.activarfecha_desdeEvaluacionProveedor= activarfecha_desdeEvaluacionProveedor;
	}

	public Border setResaltarfecha_hastaEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionProveedorBeanSwingJInternalFrame evaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionproveedorBeanSwingJInternalFrame.jTtoolBarEvaluacionProveedor.setBorder(borderResaltar);
		
		this.resaltarfecha_hastaEvaluacionProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_hastaEvaluacionProveedor() {
		return this.resaltarfecha_hastaEvaluacionProveedor;
	}

	public void setResaltarfecha_hastaEvaluacionProveedor(Border borderResaltar) {
		this.resaltarfecha_hastaEvaluacionProveedor= borderResaltar;
	}

	public Boolean getMostrarfecha_hastaEvaluacionProveedor() {
		return this.mostrarfecha_hastaEvaluacionProveedor;
	}

	public void setMostrarfecha_hastaEvaluacionProveedor(Boolean mostrarfecha_hastaEvaluacionProveedor) {
		this.mostrarfecha_hastaEvaluacionProveedor= mostrarfecha_hastaEvaluacionProveedor;
	}

	public Boolean getActivarfecha_hastaEvaluacionProveedor() {
		return this.activarfecha_hastaEvaluacionProveedor;
	}

	public void setActivarfecha_hastaEvaluacionProveedor(Boolean activarfecha_hastaEvaluacionProveedor) {
		this.activarfecha_hastaEvaluacionProveedor= activarfecha_hastaEvaluacionProveedor;
	}

	public Border setResaltarobservacionEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionProveedorBeanSwingJInternalFrame evaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//evaluacionproveedorBeanSwingJInternalFrame.jTtoolBarEvaluacionProveedor.setBorder(borderResaltar);
		
		this.resaltarobservacionEvaluacionProveedor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarobservacionEvaluacionProveedor() {
		return this.resaltarobservacionEvaluacionProveedor;
	}

	public void setResaltarobservacionEvaluacionProveedor(Border borderResaltar) {
		this.resaltarobservacionEvaluacionProveedor= borderResaltar;
	}

	public Boolean getMostrarobservacionEvaluacionProveedor() {
		return this.mostrarobservacionEvaluacionProveedor;
	}

	public void setMostrarobservacionEvaluacionProveedor(Boolean mostrarobservacionEvaluacionProveedor) {
		this.mostrarobservacionEvaluacionProveedor= mostrarobservacionEvaluacionProveedor;
	}

	public Boolean getActivarobservacionEvaluacionProveedor() {
		return this.activarobservacionEvaluacionProveedor;
	}

	public void setActivarobservacionEvaluacionProveedor(Boolean activarobservacionEvaluacionProveedor) {
		this.activarobservacionEvaluacionProveedor= activarobservacionEvaluacionProveedor;
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
		
		
		this.setMostraridEvaluacionProveedor(esInicial);
		this.setMostrarid_empresaEvaluacionProveedor(esInicial);
		this.setMostrarid_sucursalEvaluacionProveedor(esInicial);
		this.setMostrarid_ejercicioEvaluacionProveedor(esInicial);
		this.setMostrarid_periodoEvaluacionProveedor(esInicial);
		this.setMostrarid_clienteEvaluacionProveedor(esInicial);
		this.setMostrarfechaEvaluacionProveedor(esInicial);
		this.setMostrarcontactoEvaluacionProveedor(esInicial);
		this.setMostrarevaluadoEvaluacionProveedor(esInicial);
		this.setMostrarresultadoEvaluacionProveedor(esInicial);
		this.setMostrarresponsableEvaluacionProveedor(esInicial);
		this.setMostrarfecha_desdeEvaluacionProveedor(esInicial);
		this.setMostrarfecha_hastaEvaluacionProveedor(esInicial);
		this.setMostrarobservacionEvaluacionProveedor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.ID)) {
				this.setMostraridEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.FECHA)) {
				this.setMostrarfechaEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.CONTACTO)) {
				this.setMostrarcontactoEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.EVALUADO)) {
				this.setMostrarevaluadoEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.RESULTADO)) {
				this.setMostrarresultadoEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.RESPONSABLE)) {
				this.setMostrarresponsableEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.FECHADESDE)) {
				this.setMostrarfecha_desdeEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.FECHAHASTA)) {
				this.setMostrarfecha_hastaEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.OBSERVACION)) {
				this.setMostrarobservacionEvaluacionProveedor(esAsigna);
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
		
		
		this.setActivaridEvaluacionProveedor(esInicial);
		this.setActivarid_empresaEvaluacionProveedor(esInicial);
		this.setActivarid_sucursalEvaluacionProveedor(esInicial);
		this.setActivarid_ejercicioEvaluacionProveedor(esInicial);
		this.setActivarid_periodoEvaluacionProveedor(esInicial);
		this.setActivarid_clienteEvaluacionProveedor(esInicial);
		this.setActivarfechaEvaluacionProveedor(esInicial);
		this.setActivarcontactoEvaluacionProveedor(esInicial);
		this.setActivarevaluadoEvaluacionProveedor(esInicial);
		this.setActivarresultadoEvaluacionProveedor(esInicial);
		this.setActivarresponsableEvaluacionProveedor(esInicial);
		this.setActivarfecha_desdeEvaluacionProveedor(esInicial);
		this.setActivarfecha_hastaEvaluacionProveedor(esInicial);
		this.setActivarobservacionEvaluacionProveedor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.ID)) {
				this.setActivaridEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.FECHA)) {
				this.setActivarfechaEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.CONTACTO)) {
				this.setActivarcontactoEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.EVALUADO)) {
				this.setActivarevaluadoEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.RESULTADO)) {
				this.setActivarresultadoEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.RESPONSABLE)) {
				this.setActivarresponsableEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.FECHADESDE)) {
				this.setActivarfecha_desdeEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.FECHAHASTA)) {
				this.setActivarfecha_hastaEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.OBSERVACION)) {
				this.setActivarobservacionEvaluacionProveedor(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EvaluacionProveedorBeanSwingJInternalFrame evaluacionproveedorBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEvaluacionProveedor(esInicial);
		this.setResaltarid_empresaEvaluacionProveedor(esInicial);
		this.setResaltarid_sucursalEvaluacionProveedor(esInicial);
		this.setResaltarid_ejercicioEvaluacionProveedor(esInicial);
		this.setResaltarid_periodoEvaluacionProveedor(esInicial);
		this.setResaltarid_clienteEvaluacionProveedor(esInicial);
		this.setResaltarfechaEvaluacionProveedor(esInicial);
		this.setResaltarcontactoEvaluacionProveedor(esInicial);
		this.setResaltarevaluadoEvaluacionProveedor(esInicial);
		this.setResaltarresultadoEvaluacionProveedor(esInicial);
		this.setResaltarresponsableEvaluacionProveedor(esInicial);
		this.setResaltarfecha_desdeEvaluacionProveedor(esInicial);
		this.setResaltarfecha_hastaEvaluacionProveedor(esInicial);
		this.setResaltarobservacionEvaluacionProveedor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.ID)) {
				this.setResaltaridEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.FECHA)) {
				this.setResaltarfechaEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.CONTACTO)) {
				this.setResaltarcontactoEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.EVALUADO)) {
				this.setResaltarevaluadoEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.RESULTADO)) {
				this.setResaltarresultadoEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.RESPONSABLE)) {
				this.setResaltarresponsableEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.FECHADESDE)) {
				this.setResaltarfecha_desdeEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.FECHAHASTA)) {
				this.setResaltarfecha_hastaEvaluacionProveedor(esAsigna);
				continue;
			}

			if(campo.clase.equals(EvaluacionProveedorConstantesFunciones.OBSERVACION)) {
				this.setResaltarobservacionEvaluacionProveedor(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleEvaluacionProveedorEvaluacionProveedor=null;

	public Border getResaltarDetalleEvaluacionProveedorEvaluacionProveedor() {
		return this.resaltarDetalleEvaluacionProveedorEvaluacionProveedor;
	}

	public void setResaltarDetalleEvaluacionProveedorEvaluacionProveedor(Border borderResaltarDetalleEvaluacionProveedor) {
		if(borderResaltarDetalleEvaluacionProveedor!=null) {
			this.resaltarDetalleEvaluacionProveedorEvaluacionProveedor= borderResaltarDetalleEvaluacionProveedor;
		}
	}

	public Border setResaltarDetalleEvaluacionProveedorEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionProveedorBeanSwingJInternalFrame evaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleEvaluacionProveedor=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//evaluacionproveedorBeanSwingJInternalFrame.jTtoolBarEvaluacionProveedor.setBorder(borderResaltarDetalleEvaluacionProveedor);
			
		this.resaltarDetalleEvaluacionProveedorEvaluacionProveedor= borderResaltarDetalleEvaluacionProveedor;

		 return borderResaltarDetalleEvaluacionProveedor;
	}



	public Boolean mostrarDetalleEvaluacionProveedorEvaluacionProveedor=true;

	public Boolean getMostrarDetalleEvaluacionProveedorEvaluacionProveedor() {
		return this.mostrarDetalleEvaluacionProveedorEvaluacionProveedor;
	}

	public void setMostrarDetalleEvaluacionProveedorEvaluacionProveedor(Boolean visibilidadResaltarDetalleEvaluacionProveedor) {
		this.mostrarDetalleEvaluacionProveedorEvaluacionProveedor= visibilidadResaltarDetalleEvaluacionProveedor;
	}



	public Boolean activarDetalleEvaluacionProveedorEvaluacionProveedor=true;

	public Boolean gethabilitarResaltarDetalleEvaluacionProveedorEvaluacionProveedor() {
		return this.activarDetalleEvaluacionProveedorEvaluacionProveedor;
	}

	public void setActivarDetalleEvaluacionProveedorEvaluacionProveedor(Boolean habilitarResaltarDetalleEvaluacionProveedor) {
		this.activarDetalleEvaluacionProveedorEvaluacionProveedor= habilitarResaltarDetalleEvaluacionProveedor;
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

		this.setMostrarDetalleEvaluacionProveedorEvaluacionProveedor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleEvaluacionProveedor.class)) {
				this.setMostrarDetalleEvaluacionProveedorEvaluacionProveedor(esAsigna);
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

		this.setActivarDetalleEvaluacionProveedorEvaluacionProveedor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleEvaluacionProveedor.class)) {
				this.setActivarDetalleEvaluacionProveedorEvaluacionProveedor(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EvaluacionProveedorBeanSwingJInternalFrame evaluacionproveedorBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleEvaluacionProveedorEvaluacionProveedor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleEvaluacionProveedor.class)) {
				this.setResaltarDetalleEvaluacionProveedorEvaluacionProveedor(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdClienteEvaluacionProveedor=true;

	public Boolean getMostrarFK_IdClienteEvaluacionProveedor() {
		return this.mostrarFK_IdClienteEvaluacionProveedor;
	}

	public void setMostrarFK_IdClienteEvaluacionProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteEvaluacionProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioEvaluacionProveedor=true;

	public Boolean getMostrarFK_IdEjercicioEvaluacionProveedor() {
		return this.mostrarFK_IdEjercicioEvaluacionProveedor;
	}

	public void setMostrarFK_IdEjercicioEvaluacionProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioEvaluacionProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaEvaluacionProveedor=true;

	public Boolean getMostrarFK_IdEmpresaEvaluacionProveedor() {
		return this.mostrarFK_IdEmpresaEvaluacionProveedor;
	}

	public void setMostrarFK_IdEmpresaEvaluacionProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaEvaluacionProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoEvaluacionProveedor=true;

	public Boolean getMostrarFK_IdPeriodoEvaluacionProveedor() {
		return this.mostrarFK_IdPeriodoEvaluacionProveedor;
	}

	public void setMostrarFK_IdPeriodoEvaluacionProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoEvaluacionProveedor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalEvaluacionProveedor=true;

	public Boolean getMostrarFK_IdSucursalEvaluacionProveedor() {
		return this.mostrarFK_IdSucursalEvaluacionProveedor;
	}

	public void setMostrarFK_IdSucursalEvaluacionProveedor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalEvaluacionProveedor= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteEvaluacionProveedor=true;

	public Boolean getActivarFK_IdClienteEvaluacionProveedor() {
		return this.activarFK_IdClienteEvaluacionProveedor;
	}

	public void setActivarFK_IdClienteEvaluacionProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdClienteEvaluacionProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioEvaluacionProveedor=true;

	public Boolean getActivarFK_IdEjercicioEvaluacionProveedor() {
		return this.activarFK_IdEjercicioEvaluacionProveedor;
	}

	public void setActivarFK_IdEjercicioEvaluacionProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioEvaluacionProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaEvaluacionProveedor=true;

	public Boolean getActivarFK_IdEmpresaEvaluacionProveedor() {
		return this.activarFK_IdEmpresaEvaluacionProveedor;
	}

	public void setActivarFK_IdEmpresaEvaluacionProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaEvaluacionProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoEvaluacionProveedor=true;

	public Boolean getActivarFK_IdPeriodoEvaluacionProveedor() {
		return this.activarFK_IdPeriodoEvaluacionProveedor;
	}

	public void setActivarFK_IdPeriodoEvaluacionProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoEvaluacionProveedor= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalEvaluacionProveedor=true;

	public Boolean getActivarFK_IdSucursalEvaluacionProveedor() {
		return this.activarFK_IdSucursalEvaluacionProveedor;
	}

	public void setActivarFK_IdSucursalEvaluacionProveedor(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalEvaluacionProveedor= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteEvaluacionProveedor=null;

	public Border getResaltarFK_IdClienteEvaluacionProveedor() {
		return this.resaltarFK_IdClienteEvaluacionProveedor;
	}

	public void setResaltarFK_IdClienteEvaluacionProveedor(Border borderResaltar) {
		this.resaltarFK_IdClienteEvaluacionProveedor= borderResaltar;
	}

	public void setResaltarFK_IdClienteEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionProveedorBeanSwingJInternalFrame evaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteEvaluacionProveedor= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioEvaluacionProveedor=null;

	public Border getResaltarFK_IdEjercicioEvaluacionProveedor() {
		return this.resaltarFK_IdEjercicioEvaluacionProveedor;
	}

	public void setResaltarFK_IdEjercicioEvaluacionProveedor(Border borderResaltar) {
		this.resaltarFK_IdEjercicioEvaluacionProveedor= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionProveedorBeanSwingJInternalFrame evaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioEvaluacionProveedor= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaEvaluacionProveedor=null;

	public Border getResaltarFK_IdEmpresaEvaluacionProveedor() {
		return this.resaltarFK_IdEmpresaEvaluacionProveedor;
	}

	public void setResaltarFK_IdEmpresaEvaluacionProveedor(Border borderResaltar) {
		this.resaltarFK_IdEmpresaEvaluacionProveedor= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionProveedorBeanSwingJInternalFrame evaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaEvaluacionProveedor= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoEvaluacionProveedor=null;

	public Border getResaltarFK_IdPeriodoEvaluacionProveedor() {
		return this.resaltarFK_IdPeriodoEvaluacionProveedor;
	}

	public void setResaltarFK_IdPeriodoEvaluacionProveedor(Border borderResaltar) {
		this.resaltarFK_IdPeriodoEvaluacionProveedor= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionProveedorBeanSwingJInternalFrame evaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoEvaluacionProveedor= borderResaltar;
	}

	public Border resaltarFK_IdSucursalEvaluacionProveedor=null;

	public Border getResaltarFK_IdSucursalEvaluacionProveedor() {
		return this.resaltarFK_IdSucursalEvaluacionProveedor;
	}

	public void setResaltarFK_IdSucursalEvaluacionProveedor(Border borderResaltar) {
		this.resaltarFK_IdSucursalEvaluacionProveedor= borderResaltar;
	}

	public void setResaltarFK_IdSucursalEvaluacionProveedor(ParametroGeneralUsuario parametroGeneralUsuario/*EvaluacionProveedorBeanSwingJInternalFrame evaluacionproveedorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalEvaluacionProveedor= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}