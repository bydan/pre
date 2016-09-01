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


import com.bydan.erp.contabilidad.util.PresupuestoFlujoCajaConstantesFunciones;
import com.bydan.erp.contabilidad.util.PresupuestoFlujoCajaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.PresupuestoFlujoCajaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PresupuestoFlujoCajaConstantesFunciones extends PresupuestoFlujoCajaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PresupuestoFlujoCaja";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PresupuestoFlujoCaja"+PresupuestoFlujoCajaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PresupuestoFlujoCajaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PresupuestoFlujoCajaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"_"+PresupuestoFlujoCajaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PresupuestoFlujoCajaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"_"+PresupuestoFlujoCajaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"_"+PresupuestoFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PresupuestoFlujoCajaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"_"+PresupuestoFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestoFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresupuestoFlujoCajaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestoFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestoFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresupuestoFlujoCajaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestoFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PresupuestoFlujoCajaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PresupuestoFlujoCajaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PresupuestoFlujoCajaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PresupuestoFlujoCajaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Presupuesto Flujo Cajas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Presupuesto Flujo Caja";
	public static final String SCLASSWEBTITULO_LOWER="Presupuesto Flujo Caja";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PresupuestoFlujoCaja";
	public static final String OBJECTNAME="presupuestoflujocaja";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="presupuesto_flujo_caja";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select presupuestoflujocaja from "+PresupuestoFlujoCajaConstantesFunciones.SPERSISTENCENAME+" presupuestoflujocaja";
	public static String QUERYSELECTNATIVE="select "+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".id,"+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".version_row,"+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".id_empresa,"+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".id_cuenta_contable,"+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".id_ejercicio,"+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".id_periodo,"+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".id_centro_costo,"+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".valor,"+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".valor_efectivo,"+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".porcentaje,"+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".fecha_presupuesto,"+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".fecha_proceso,"+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".observacion,"+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".id_anio,"+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME+".id_mes from "+PresupuestoFlujoCajaConstantesFunciones.SCHEMA+"."+PresupuestoFlujoCajaConstantesFunciones.TABLENAME;//+" as "+PresupuestoFlujoCajaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PresupuestoFlujoCajaConstantesFuncionesAdditional presupuestoflujocajaConstantesFuncionesAdditional=null;
	
	public PresupuestoFlujoCajaConstantesFuncionesAdditional getPresupuestoFlujoCajaConstantesFuncionesAdditional() {
		return this.presupuestoflujocajaConstantesFuncionesAdditional;
	}
	
	public void setPresupuestoFlujoCajaConstantesFuncionesAdditional(PresupuestoFlujoCajaConstantesFuncionesAdditional presupuestoflujocajaConstantesFuncionesAdditional) {
		try {
			this.presupuestoflujocajaConstantesFuncionesAdditional=presupuestoflujocajaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String VALOR= "valor";
    public static final String VALOREFECTIVO= "valor_efectivo";
    public static final String PORCENTAJE= "porcentaje";
    public static final String FECHAPRESUPUESTO= "fecha_presupuesto";
    public static final String FECHAPROCESO= "fecha_proceso";
    public static final String OBSERVACION= "observacion";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_VALOREFECTIVO= "Valor Efectivo";
		public static final String LABEL_VALOREFECTIVO_LOWER= "Valor Efectivo";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_FECHAPRESUPUESTO= "Fecha Presupuesto";
		public static final String LABEL_FECHAPRESUPUESTO_LOWER= "Fecha Presupuesto";
    	public static final String LABEL_FECHAPROCESO= "Fecha Proceso";
		public static final String LABEL_FECHAPROCESO_LOWER= "Fecha Proceso";
    	public static final String LABEL_OBSERVACION= "Observacion";
		public static final String LABEL_OBSERVACION_LOWER= "Observacion";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
	
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXOBSERVACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXOBSERVACION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getPresupuestoFlujoCajaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PresupuestoFlujoCajaConstantesFunciones.IDEMPRESA)) {sLabelColumna=PresupuestoFlujoCajaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PresupuestoFlujoCajaConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=PresupuestoFlujoCajaConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(PresupuestoFlujoCajaConstantesFunciones.IDEJERCICIO)) {sLabelColumna=PresupuestoFlujoCajaConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(PresupuestoFlujoCajaConstantesFunciones.IDPERIODO)) {sLabelColumna=PresupuestoFlujoCajaConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(PresupuestoFlujoCajaConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=PresupuestoFlujoCajaConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(PresupuestoFlujoCajaConstantesFunciones.VALOR)) {sLabelColumna=PresupuestoFlujoCajaConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(PresupuestoFlujoCajaConstantesFunciones.VALOREFECTIVO)) {sLabelColumna=PresupuestoFlujoCajaConstantesFunciones.LABEL_VALOREFECTIVO;}
		if(sNombreColumna.equals(PresupuestoFlujoCajaConstantesFunciones.PORCENTAJE)) {sLabelColumna=PresupuestoFlujoCajaConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(PresupuestoFlujoCajaConstantesFunciones.FECHAPRESUPUESTO)) {sLabelColumna=PresupuestoFlujoCajaConstantesFunciones.LABEL_FECHAPRESUPUESTO;}
		if(sNombreColumna.equals(PresupuestoFlujoCajaConstantesFunciones.FECHAPROCESO)) {sLabelColumna=PresupuestoFlujoCajaConstantesFunciones.LABEL_FECHAPROCESO;}
		if(sNombreColumna.equals(PresupuestoFlujoCajaConstantesFunciones.OBSERVACION)) {sLabelColumna=PresupuestoFlujoCajaConstantesFunciones.LABEL_OBSERVACION;}
		if(sNombreColumna.equals(PresupuestoFlujoCajaConstantesFunciones.IDANIO)) {sLabelColumna=PresupuestoFlujoCajaConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(PresupuestoFlujoCajaConstantesFunciones.IDMES)) {sLabelColumna=PresupuestoFlujoCajaConstantesFunciones.LABEL_IDMES;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getPresupuestoFlujoCajaDescripcion(PresupuestoFlujoCaja presupuestoflujocaja) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(presupuestoflujocaja !=null/* && presupuestoflujocaja.getId()!=0*/) {
			if(presupuestoflujocaja.getId()!=null) {
				sDescripcion=presupuestoflujocaja.getId().toString();
			}//presupuestoflujocajapresupuestoflujocaja.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPresupuestoFlujoCajaDescripcionDetallado(PresupuestoFlujoCaja presupuestoflujocaja) {
		String sDescripcion="";
			
		sDescripcion+=PresupuestoFlujoCajaConstantesFunciones.ID+"=";
		sDescripcion+=presupuestoflujocaja.getId().toString()+",";
		sDescripcion+=PresupuestoFlujoCajaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=presupuestoflujocaja.getVersionRow().toString()+",";
		sDescripcion+=PresupuestoFlujoCajaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=presupuestoflujocaja.getid_empresa().toString()+",";
		sDescripcion+=PresupuestoFlujoCajaConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=presupuestoflujocaja.getid_cuenta_contable().toString()+",";
		sDescripcion+=PresupuestoFlujoCajaConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=presupuestoflujocaja.getid_ejercicio().toString()+",";
		sDescripcion+=PresupuestoFlujoCajaConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=presupuestoflujocaja.getid_periodo().toString()+",";
		sDescripcion+=PresupuestoFlujoCajaConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=presupuestoflujocaja.getid_centro_costo().toString()+",";
		sDescripcion+=PresupuestoFlujoCajaConstantesFunciones.VALOR+"=";
		sDescripcion+=presupuestoflujocaja.getvalor().toString()+",";
		sDescripcion+=PresupuestoFlujoCajaConstantesFunciones.VALOREFECTIVO+"=";
		sDescripcion+=presupuestoflujocaja.getvalor_efectivo().toString()+",";
		sDescripcion+=PresupuestoFlujoCajaConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=presupuestoflujocaja.getporcentaje().toString()+",";
		sDescripcion+=PresupuestoFlujoCajaConstantesFunciones.FECHAPRESUPUESTO+"=";
		sDescripcion+=presupuestoflujocaja.getfecha_presupuesto().toString()+",";
		sDescripcion+=PresupuestoFlujoCajaConstantesFunciones.FECHAPROCESO+"=";
		sDescripcion+=presupuestoflujocaja.getfecha_proceso().toString()+",";
		sDescripcion+=PresupuestoFlujoCajaConstantesFunciones.OBSERVACION+"=";
		sDescripcion+=presupuestoflujocaja.getobservacion()+",";
		sDescripcion+=PresupuestoFlujoCajaConstantesFunciones.IDANIO+"=";
		sDescripcion+=presupuestoflujocaja.getid_anio().toString()+",";
		sDescripcion+=PresupuestoFlujoCajaConstantesFunciones.IDMES+"=";
		sDescripcion+=presupuestoflujocaja.getid_mes().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPresupuestoFlujoCajaDescripcion(PresupuestoFlujoCaja presupuestoflujocaja,String sValor) throws Exception {			
		if(presupuestoflujocaja !=null) {
			//presupuestoflujocajapresupuestoflujocaja.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getCentroCostoDescripcion(CentroCosto centrocosto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centrocosto!=null/*&&centrocosto.getId()>0*/) {
			sDescripcion=CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocosto);
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
		} else if(sNombreIndice.equals("FK_IdCentroCosto")) {
			sNombreIndice="Tipo=  Por Centro Costo";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
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

	public static String getDetalleIndiceFK_IdCentroCosto(Long id_centro_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_costo!=null) {sDetalleIndice+=" Codigo Unico De Centro Costo="+id_centro_costo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

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

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPresupuestoFlujoCaja(PresupuestoFlujoCaja presupuestoflujocaja,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		presupuestoflujocaja.setobservacion(presupuestoflujocaja.getobservacion().trim());
	}
	
	public static void quitarEspaciosPresupuestoFlujoCajas(List<PresupuestoFlujoCaja> presupuestoflujocajas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PresupuestoFlujoCaja presupuestoflujocaja: presupuestoflujocajas) {
			presupuestoflujocaja.setobservacion(presupuestoflujocaja.getobservacion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresupuestoFlujoCaja(PresupuestoFlujoCaja presupuestoflujocaja,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && presupuestoflujocaja.getConCambioAuxiliar()) {
			presupuestoflujocaja.setIsDeleted(presupuestoflujocaja.getIsDeletedAuxiliar());	
			presupuestoflujocaja.setIsNew(presupuestoflujocaja.getIsNewAuxiliar());	
			presupuestoflujocaja.setIsChanged(presupuestoflujocaja.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			presupuestoflujocaja.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			presupuestoflujocaja.setIsDeletedAuxiliar(false);	
			presupuestoflujocaja.setIsNewAuxiliar(false);	
			presupuestoflujocaja.setIsChangedAuxiliar(false);
			
			presupuestoflujocaja.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresupuestoFlujoCajas(List<PresupuestoFlujoCaja> presupuestoflujocajas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PresupuestoFlujoCaja presupuestoflujocaja : presupuestoflujocajas) {
			if(conAsignarBase && presupuestoflujocaja.getConCambioAuxiliar()) {
				presupuestoflujocaja.setIsDeleted(presupuestoflujocaja.getIsDeletedAuxiliar());	
				presupuestoflujocaja.setIsNew(presupuestoflujocaja.getIsNewAuxiliar());	
				presupuestoflujocaja.setIsChanged(presupuestoflujocaja.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				presupuestoflujocaja.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				presupuestoflujocaja.setIsDeletedAuxiliar(false);	
				presupuestoflujocaja.setIsNewAuxiliar(false);	
				presupuestoflujocaja.setIsChangedAuxiliar(false);
				
				presupuestoflujocaja.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPresupuestoFlujoCaja(PresupuestoFlujoCaja presupuestoflujocaja,Boolean conEnteros) throws Exception  {
		presupuestoflujocaja.setvalor(0.0);
		presupuestoflujocaja.setvalor_efectivo(0.0);
		presupuestoflujocaja.setporcentaje(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPresupuestoFlujoCajas(List<PresupuestoFlujoCaja> presupuestoflujocajas,Boolean conEnteros) throws Exception  {
		
		for(PresupuestoFlujoCaja presupuestoflujocaja: presupuestoflujocajas) {
			presupuestoflujocaja.setvalor(0.0);
			presupuestoflujocaja.setvalor_efectivo(0.0);
			presupuestoflujocaja.setporcentaje(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPresupuestoFlujoCaja(List<PresupuestoFlujoCaja> presupuestoflujocajas,PresupuestoFlujoCaja presupuestoflujocajaAux) throws Exception  {
		PresupuestoFlujoCajaConstantesFunciones.InicializarValoresPresupuestoFlujoCaja(presupuestoflujocajaAux,true);
		
		for(PresupuestoFlujoCaja presupuestoflujocaja: presupuestoflujocajas) {
			if(presupuestoflujocaja.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			presupuestoflujocajaAux.setvalor(presupuestoflujocajaAux.getvalor()+presupuestoflujocaja.getvalor());			
			presupuestoflujocajaAux.setvalor_efectivo(presupuestoflujocajaAux.getvalor_efectivo()+presupuestoflujocaja.getvalor_efectivo());			
			presupuestoflujocajaAux.setporcentaje(presupuestoflujocajaAux.getporcentaje()+presupuestoflujocaja.getporcentaje());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPresupuestoFlujoCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PresupuestoFlujoCajaConstantesFunciones.getArrayColumnasGlobalesPresupuestoFlujoCaja(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPresupuestoFlujoCaja(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresupuestoFlujoCajaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresupuestoFlujoCajaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresupuestoFlujoCajaConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresupuestoFlujoCajaConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresupuestoFlujoCajaConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresupuestoFlujoCajaConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPresupuestoFlujoCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PresupuestoFlujoCaja> presupuestoflujocajas,PresupuestoFlujoCaja presupuestoflujocaja,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PresupuestoFlujoCaja presupuestoflujocajaAux: presupuestoflujocajas) {
			if(presupuestoflujocajaAux!=null && presupuestoflujocaja!=null) {
				if((presupuestoflujocajaAux.getId()==null && presupuestoflujocaja.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(presupuestoflujocajaAux.getId()!=null && presupuestoflujocaja.getId()!=null){
					if(presupuestoflujocajaAux.getId().equals(presupuestoflujocaja.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPresupuestoFlujoCaja(List<PresupuestoFlujoCaja> presupuestoflujocajas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
		Double valor_efectivoTotal=0.0;
		Double porcentajeTotal=0.0;
	
		for(PresupuestoFlujoCaja presupuestoflujocaja: presupuestoflujocajas) {			
			if(presupuestoflujocaja.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=presupuestoflujocaja.getvalor();
			valor_efectivoTotal+=presupuestoflujocaja.getvalor_efectivo();
			porcentajeTotal+=presupuestoflujocaja.getporcentaje();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestoFlujoCajaConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(PresupuestoFlujoCajaConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestoFlujoCajaConstantesFunciones.VALOREFECTIVO);
		datoGeneral.setsDescripcion(PresupuestoFlujoCajaConstantesFunciones.LABEL_VALOREFECTIVO);
		datoGeneral.setdValorDouble(valor_efectivoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestoFlujoCajaConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(PresupuestoFlujoCajaConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPresupuestoFlujoCaja() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PresupuestoFlujoCajaConstantesFunciones.LABEL_ID, PresupuestoFlujoCajaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaConstantesFunciones.LABEL_VERSIONROW, PresupuestoFlujoCajaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaConstantesFunciones.LABEL_IDEMPRESA, PresupuestoFlujoCajaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaConstantesFunciones.LABEL_IDCUENTACONTABLE, PresupuestoFlujoCajaConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaConstantesFunciones.LABEL_IDEJERCICIO, PresupuestoFlujoCajaConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaConstantesFunciones.LABEL_IDPERIODO, PresupuestoFlujoCajaConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaConstantesFunciones.LABEL_IDCENTROCOSTO, PresupuestoFlujoCajaConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaConstantesFunciones.LABEL_VALOR, PresupuestoFlujoCajaConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaConstantesFunciones.LABEL_VALOREFECTIVO, PresupuestoFlujoCajaConstantesFunciones.VALOREFECTIVO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaConstantesFunciones.LABEL_PORCENTAJE, PresupuestoFlujoCajaConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaConstantesFunciones.LABEL_FECHAPRESUPUESTO, PresupuestoFlujoCajaConstantesFunciones.FECHAPRESUPUESTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaConstantesFunciones.LABEL_FECHAPROCESO, PresupuestoFlujoCajaConstantesFunciones.FECHAPROCESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaConstantesFunciones.LABEL_OBSERVACION, PresupuestoFlujoCajaConstantesFunciones.OBSERVACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaConstantesFunciones.LABEL_IDANIO, PresupuestoFlujoCajaConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoFlujoCajaConstantesFunciones.LABEL_IDMES, PresupuestoFlujoCajaConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPresupuestoFlujoCaja() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaConstantesFunciones.VALOREFECTIVO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaConstantesFunciones.FECHAPRESUPUESTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaConstantesFunciones.FECHAPROCESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaConstantesFunciones.OBSERVACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoFlujoCajaConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresupuestoFlujoCaja() throws Exception  {
		return PresupuestoFlujoCajaConstantesFunciones.getTiposSeleccionarPresupuestoFlujoCaja(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresupuestoFlujoCaja(Boolean conFk) throws Exception  {
		return PresupuestoFlujoCajaConstantesFunciones.getTiposSeleccionarPresupuestoFlujoCaja(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresupuestoFlujoCaja(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PresupuestoFlujoCajaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(PresupuestoFlujoCajaConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(PresupuestoFlujoCajaConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(PresupuestoFlujoCajaConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(PresupuestoFlujoCajaConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(PresupuestoFlujoCajaConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaConstantesFunciones.LABEL_VALOREFECTIVO);
			reporte.setsDescripcion(PresupuestoFlujoCajaConstantesFunciones.LABEL_VALOREFECTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(PresupuestoFlujoCajaConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaConstantesFunciones.LABEL_FECHAPRESUPUESTO);
			reporte.setsDescripcion(PresupuestoFlujoCajaConstantesFunciones.LABEL_FECHAPRESUPUESTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaConstantesFunciones.LABEL_FECHAPROCESO);
			reporte.setsDescripcion(PresupuestoFlujoCajaConstantesFunciones.LABEL_FECHAPROCESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaConstantesFunciones.LABEL_OBSERVACION);
			reporte.setsDescripcion(PresupuestoFlujoCajaConstantesFunciones.LABEL_OBSERVACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(PresupuestoFlujoCajaConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoFlujoCajaConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(PresupuestoFlujoCajaConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPresupuestoFlujoCaja(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(PresupuestoFlujoCaja presupuestoflujocajaAux) throws Exception {
		
			presupuestoflujocajaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(presupuestoflujocajaAux.getEmpresa()));
			presupuestoflujocajaAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(presupuestoflujocajaAux.getCuentaContable()));
			presupuestoflujocajaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(presupuestoflujocajaAux.getEjercicio()));
			presupuestoflujocajaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(presupuestoflujocajaAux.getPeriodo()));
			presupuestoflujocajaAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(presupuestoflujocajaAux.getCentroCosto()));
			presupuestoflujocajaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(presupuestoflujocajaAux.getAnio()));
			presupuestoflujocajaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(presupuestoflujocajaAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPresupuestoFlujoCaja(List<PresupuestoFlujoCaja> presupuestoflujocajasTemp) throws Exception {
		for(PresupuestoFlujoCaja presupuestoflujocajaAux:presupuestoflujocajasTemp) {
			
			presupuestoflujocajaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(presupuestoflujocajaAux.getEmpresa()));
			presupuestoflujocajaAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(presupuestoflujocajaAux.getCuentaContable()));
			presupuestoflujocajaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(presupuestoflujocajaAux.getEjercicio()));
			presupuestoflujocajaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(presupuestoflujocajaAux.getPeriodo()));
			presupuestoflujocajaAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(presupuestoflujocajaAux.getCentroCosto()));
			presupuestoflujocajaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(presupuestoflujocajaAux.getAnio()));
			presupuestoflujocajaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(presupuestoflujocajaAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPresupuestoFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
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
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPresupuestoFlujoCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
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

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresupuestoFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresupuestoFlujoCajaConstantesFunciones.getClassesRelationshipsOfPresupuestoFlujoCaja(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresupuestoFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresupuestoFlujoCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresupuestoFlujoCajaConstantesFunciones.getClassesRelationshipsFromStringsOfPresupuestoFlujoCaja(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresupuestoFlujoCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PresupuestoFlujoCaja presupuestoflujocaja,List<PresupuestoFlujoCaja> presupuestoflujocajas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PresupuestoFlujoCaja presupuestoflujocajaEncontrado=null;
			
			for(PresupuestoFlujoCaja presupuestoflujocajaLocal:presupuestoflujocajas) {
				if(presupuestoflujocajaLocal.getId().equals(presupuestoflujocaja.getId())) {
					presupuestoflujocajaEncontrado=presupuestoflujocajaLocal;
					
					presupuestoflujocajaLocal.setIsChanged(presupuestoflujocaja.getIsChanged());
					presupuestoflujocajaLocal.setIsNew(presupuestoflujocaja.getIsNew());
					presupuestoflujocajaLocal.setIsDeleted(presupuestoflujocaja.getIsDeleted());
					
					presupuestoflujocajaLocal.setGeneralEntityOriginal(presupuestoflujocaja.getGeneralEntityOriginal());
					
					presupuestoflujocajaLocal.setId(presupuestoflujocaja.getId());	
					presupuestoflujocajaLocal.setVersionRow(presupuestoflujocaja.getVersionRow());	
					presupuestoflujocajaLocal.setid_empresa(presupuestoflujocaja.getid_empresa());	
					presupuestoflujocajaLocal.setid_cuenta_contable(presupuestoflujocaja.getid_cuenta_contable());	
					presupuestoflujocajaLocal.setid_ejercicio(presupuestoflujocaja.getid_ejercicio());	
					presupuestoflujocajaLocal.setid_periodo(presupuestoflujocaja.getid_periodo());	
					presupuestoflujocajaLocal.setid_centro_costo(presupuestoflujocaja.getid_centro_costo());	
					presupuestoflujocajaLocal.setvalor(presupuestoflujocaja.getvalor());	
					presupuestoflujocajaLocal.setvalor_efectivo(presupuestoflujocaja.getvalor_efectivo());	
					presupuestoflujocajaLocal.setporcentaje(presupuestoflujocaja.getporcentaje());	
					presupuestoflujocajaLocal.setfecha_presupuesto(presupuestoflujocaja.getfecha_presupuesto());	
					presupuestoflujocajaLocal.setfecha_proceso(presupuestoflujocaja.getfecha_proceso());	
					presupuestoflujocajaLocal.setobservacion(presupuestoflujocaja.getobservacion());	
					presupuestoflujocajaLocal.setid_anio(presupuestoflujocaja.getid_anio());	
					presupuestoflujocajaLocal.setid_mes(presupuestoflujocaja.getid_mes());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!presupuestoflujocaja.getIsDeleted()) {
				if(!existe) {
					presupuestoflujocajas.add(presupuestoflujocaja);
				}
			} else {
				if(presupuestoflujocajaEncontrado!=null && permiteQuitar)  {
					presupuestoflujocajas.remove(presupuestoflujocajaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PresupuestoFlujoCaja presupuestoflujocaja,List<PresupuestoFlujoCaja> presupuestoflujocajas) throws Exception {
		try	{			
			for(PresupuestoFlujoCaja presupuestoflujocajaLocal:presupuestoflujocajas) {
				if(presupuestoflujocajaLocal.getId().equals(presupuestoflujocaja.getId())) {
					presupuestoflujocajaLocal.setIsSelected(presupuestoflujocaja.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPresupuestoFlujoCaja(List<PresupuestoFlujoCaja> presupuestoflujocajasAux) throws Exception {
		//this.presupuestoflujocajasAux=presupuestoflujocajasAux;
		
		for(PresupuestoFlujoCaja presupuestoflujocajaAux:presupuestoflujocajasAux) {
			if(presupuestoflujocajaAux.getIsChanged()) {
				presupuestoflujocajaAux.setIsChanged(false);
			}		
			
			if(presupuestoflujocajaAux.getIsNew()) {
				presupuestoflujocajaAux.setIsNew(false);
			}	
			
			if(presupuestoflujocajaAux.getIsDeleted()) {
				presupuestoflujocajaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPresupuestoFlujoCaja(PresupuestoFlujoCaja presupuestoflujocajaAux) throws Exception {
		//this.presupuestoflujocajaAux=presupuestoflujocajaAux;
		
			if(presupuestoflujocajaAux.getIsChanged()) {
				presupuestoflujocajaAux.setIsChanged(false);
			}		
			
			if(presupuestoflujocajaAux.getIsNew()) {
				presupuestoflujocajaAux.setIsNew(false);
			}	
			
			if(presupuestoflujocajaAux.getIsDeleted()) {
				presupuestoflujocajaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PresupuestoFlujoCaja presupuestoflujocajaAsignar,PresupuestoFlujoCaja presupuestoflujocaja) throws Exception {
		presupuestoflujocajaAsignar.setId(presupuestoflujocaja.getId());	
		presupuestoflujocajaAsignar.setVersionRow(presupuestoflujocaja.getVersionRow());	
		presupuestoflujocajaAsignar.setid_empresa(presupuestoflujocaja.getid_empresa());
		presupuestoflujocajaAsignar.setempresa_descripcion(presupuestoflujocaja.getempresa_descripcion());	
		presupuestoflujocajaAsignar.setid_cuenta_contable(presupuestoflujocaja.getid_cuenta_contable());
		presupuestoflujocajaAsignar.setcuentacontable_descripcion(presupuestoflujocaja.getcuentacontable_descripcion());	
		presupuestoflujocajaAsignar.setid_ejercicio(presupuestoflujocaja.getid_ejercicio());
		presupuestoflujocajaAsignar.setejercicio_descripcion(presupuestoflujocaja.getejercicio_descripcion());	
		presupuestoflujocajaAsignar.setid_periodo(presupuestoflujocaja.getid_periodo());
		presupuestoflujocajaAsignar.setperiodo_descripcion(presupuestoflujocaja.getperiodo_descripcion());	
		presupuestoflujocajaAsignar.setid_centro_costo(presupuestoflujocaja.getid_centro_costo());
		presupuestoflujocajaAsignar.setcentrocosto_descripcion(presupuestoflujocaja.getcentrocosto_descripcion());	
		presupuestoflujocajaAsignar.setvalor(presupuestoflujocaja.getvalor());	
		presupuestoflujocajaAsignar.setvalor_efectivo(presupuestoflujocaja.getvalor_efectivo());	
		presupuestoflujocajaAsignar.setporcentaje(presupuestoflujocaja.getporcentaje());	
		presupuestoflujocajaAsignar.setfecha_presupuesto(presupuestoflujocaja.getfecha_presupuesto());	
		presupuestoflujocajaAsignar.setfecha_proceso(presupuestoflujocaja.getfecha_proceso());	
		presupuestoflujocajaAsignar.setobservacion(presupuestoflujocaja.getobservacion());	
		presupuestoflujocajaAsignar.setid_anio(presupuestoflujocaja.getid_anio());
		presupuestoflujocajaAsignar.setanio_descripcion(presupuestoflujocaja.getanio_descripcion());	
		presupuestoflujocajaAsignar.setid_mes(presupuestoflujocaja.getid_mes());
		presupuestoflujocajaAsignar.setmes_descripcion(presupuestoflujocaja.getmes_descripcion());	
	}
	
	public static void inicializarPresupuestoFlujoCaja(PresupuestoFlujoCaja presupuestoflujocaja) throws Exception {
		try {
				presupuestoflujocaja.setId(0L);	
					
				presupuestoflujocaja.setid_empresa(-1L);	
				presupuestoflujocaja.setid_cuenta_contable(-1L);	
				presupuestoflujocaja.setid_ejercicio(-1L);	
				presupuestoflujocaja.setid_periodo(-1L);	
				presupuestoflujocaja.setid_centro_costo(null);	
				presupuestoflujocaja.setvalor(0.0);	
				presupuestoflujocaja.setvalor_efectivo(0.0);	
				presupuestoflujocaja.setporcentaje(0.0);	
				presupuestoflujocaja.setfecha_presupuesto(new Date());	
				presupuestoflujocaja.setfecha_proceso(new Date());	
				presupuestoflujocaja.setobservacion("");	
				presupuestoflujocaja.setid_anio(null);	
				presupuestoflujocaja.setid_mes(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPresupuestoFlujoCaja(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaConstantesFunciones.LABEL_VALOREFECTIVO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaConstantesFunciones.LABEL_FECHAPRESUPUESTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaConstantesFunciones.LABEL_FECHAPROCESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaConstantesFunciones.LABEL_OBSERVACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoFlujoCajaConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPresupuestoFlujoCaja(String sTipo,Row row,Workbook workbook,PresupuestoFlujoCaja presupuestoflujocaja,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocaja.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocaja.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocaja.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocaja.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocaja.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocaja.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocaja.getvalor_efectivo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocaja.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocaja.getfecha_presupuesto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocaja.getfecha_proceso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocaja.getobservacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocaja.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoflujocaja.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPresupuestoFlujoCaja=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPresupuestoFlujoCaja() {
		return this.sFinalQueryPresupuestoFlujoCaja;
	}
	
	public void setsFinalQueryPresupuestoFlujoCaja(String sFinalQueryPresupuestoFlujoCaja) {
		this.sFinalQueryPresupuestoFlujoCaja= sFinalQueryPresupuestoFlujoCaja;
	}
	
	public Border resaltarSeleccionarPresupuestoFlujoCaja=null;
	
	public Border setResaltarSeleccionarPresupuestoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaBeanSwingJInternalFrame presupuestoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//presupuestoflujocajaBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPresupuestoFlujoCaja= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPresupuestoFlujoCaja() {
		return this.resaltarSeleccionarPresupuestoFlujoCaja;
	}
	
	public void setResaltarSeleccionarPresupuestoFlujoCaja(Border borderResaltarSeleccionarPresupuestoFlujoCaja) {
		this.resaltarSeleccionarPresupuestoFlujoCaja= borderResaltarSeleccionarPresupuestoFlujoCaja;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPresupuestoFlujoCaja=null;
	public Boolean mostraridPresupuestoFlujoCaja=true;
	public Boolean activaridPresupuestoFlujoCaja=true;

	public Border resaltarid_empresaPresupuestoFlujoCaja=null;
	public Boolean mostrarid_empresaPresupuestoFlujoCaja=true;
	public Boolean activarid_empresaPresupuestoFlujoCaja=true;
	public Boolean cargarid_empresaPresupuestoFlujoCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPresupuestoFlujoCaja=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contablePresupuestoFlujoCaja=null;
	public Boolean mostrarid_cuenta_contablePresupuestoFlujoCaja=true;
	public Boolean activarid_cuenta_contablePresupuestoFlujoCaja=true;
	public Boolean cargarid_cuenta_contablePresupuestoFlujoCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contablePresupuestoFlujoCaja=false;//ConEventDepend=true

	public Border resaltarid_ejercicioPresupuestoFlujoCaja=null;
	public Boolean mostrarid_ejercicioPresupuestoFlujoCaja=true;
	public Boolean activarid_ejercicioPresupuestoFlujoCaja=true;
	public Boolean cargarid_ejercicioPresupuestoFlujoCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioPresupuestoFlujoCaja=false;//ConEventDepend=true

	public Border resaltarid_periodoPresupuestoFlujoCaja=null;
	public Boolean mostrarid_periodoPresupuestoFlujoCaja=true;
	public Boolean activarid_periodoPresupuestoFlujoCaja=true;
	public Boolean cargarid_periodoPresupuestoFlujoCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoPresupuestoFlujoCaja=false;//ConEventDepend=true

	public Border resaltarid_centro_costoPresupuestoFlujoCaja=null;
	public Boolean mostrarid_centro_costoPresupuestoFlujoCaja=true;
	public Boolean activarid_centro_costoPresupuestoFlujoCaja=true;
	public Boolean cargarid_centro_costoPresupuestoFlujoCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoPresupuestoFlujoCaja=false;//ConEventDepend=true

	public Border resaltarvalorPresupuestoFlujoCaja=null;
	public Boolean mostrarvalorPresupuestoFlujoCaja=true;
	public Boolean activarvalorPresupuestoFlujoCaja=true;

	public Border resaltarvalor_efectivoPresupuestoFlujoCaja=null;
	public Boolean mostrarvalor_efectivoPresupuestoFlujoCaja=true;
	public Boolean activarvalor_efectivoPresupuestoFlujoCaja=true;

	public Border resaltarporcentajePresupuestoFlujoCaja=null;
	public Boolean mostrarporcentajePresupuestoFlujoCaja=true;
	public Boolean activarporcentajePresupuestoFlujoCaja=true;

	public Border resaltarfecha_presupuestoPresupuestoFlujoCaja=null;
	public Boolean mostrarfecha_presupuestoPresupuestoFlujoCaja=true;
	public Boolean activarfecha_presupuestoPresupuestoFlujoCaja=false;

	public Border resaltarfecha_procesoPresupuestoFlujoCaja=null;
	public Boolean mostrarfecha_procesoPresupuestoFlujoCaja=true;
	public Boolean activarfecha_procesoPresupuestoFlujoCaja=false;

	public Border resaltarobservacionPresupuestoFlujoCaja=null;
	public Boolean mostrarobservacionPresupuestoFlujoCaja=true;
	public Boolean activarobservacionPresupuestoFlujoCaja=true;

	public Border resaltarid_anioPresupuestoFlujoCaja=null;
	public Boolean mostrarid_anioPresupuestoFlujoCaja=true;
	public Boolean activarid_anioPresupuestoFlujoCaja=false;
	public Boolean cargarid_anioPresupuestoFlujoCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioPresupuestoFlujoCaja=false;//ConEventDepend=true

	public Border resaltarid_mesPresupuestoFlujoCaja=null;
	public Boolean mostrarid_mesPresupuestoFlujoCaja=true;
	public Boolean activarid_mesPresupuestoFlujoCaja=false;
	public Boolean cargarid_mesPresupuestoFlujoCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesPresupuestoFlujoCaja=false;//ConEventDepend=true

	
	

	public Border setResaltaridPresupuestoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaBeanSwingJInternalFrame presupuestoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajaBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCaja.setBorder(borderResaltar);
		
		this.resaltaridPresupuestoFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPresupuestoFlujoCaja() {
		return this.resaltaridPresupuestoFlujoCaja;
	}

	public void setResaltaridPresupuestoFlujoCaja(Border borderResaltar) {
		this.resaltaridPresupuestoFlujoCaja= borderResaltar;
	}

	public Boolean getMostraridPresupuestoFlujoCaja() {
		return this.mostraridPresupuestoFlujoCaja;
	}

	public void setMostraridPresupuestoFlujoCaja(Boolean mostraridPresupuestoFlujoCaja) {
		this.mostraridPresupuestoFlujoCaja= mostraridPresupuestoFlujoCaja;
	}

	public Boolean getActivaridPresupuestoFlujoCaja() {
		return this.activaridPresupuestoFlujoCaja;
	}

	public void setActivaridPresupuestoFlujoCaja(Boolean activaridPresupuestoFlujoCaja) {
		this.activaridPresupuestoFlujoCaja= activaridPresupuestoFlujoCaja;
	}

	public Border setResaltarid_empresaPresupuestoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaBeanSwingJInternalFrame presupuestoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajaBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarid_empresaPresupuestoFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPresupuestoFlujoCaja() {
		return this.resaltarid_empresaPresupuestoFlujoCaja;
	}

	public void setResaltarid_empresaPresupuestoFlujoCaja(Border borderResaltar) {
		this.resaltarid_empresaPresupuestoFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarid_empresaPresupuestoFlujoCaja() {
		return this.mostrarid_empresaPresupuestoFlujoCaja;
	}

	public void setMostrarid_empresaPresupuestoFlujoCaja(Boolean mostrarid_empresaPresupuestoFlujoCaja) {
		this.mostrarid_empresaPresupuestoFlujoCaja= mostrarid_empresaPresupuestoFlujoCaja;
	}

	public Boolean getActivarid_empresaPresupuestoFlujoCaja() {
		return this.activarid_empresaPresupuestoFlujoCaja;
	}

	public void setActivarid_empresaPresupuestoFlujoCaja(Boolean activarid_empresaPresupuestoFlujoCaja) {
		this.activarid_empresaPresupuestoFlujoCaja= activarid_empresaPresupuestoFlujoCaja;
	}

	public Boolean getCargarid_empresaPresupuestoFlujoCaja() {
		return this.cargarid_empresaPresupuestoFlujoCaja;
	}

	public void setCargarid_empresaPresupuestoFlujoCaja(Boolean cargarid_empresaPresupuestoFlujoCaja) {
		this.cargarid_empresaPresupuestoFlujoCaja= cargarid_empresaPresupuestoFlujoCaja;
	}

	public Border setResaltarid_cuenta_contablePresupuestoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaBeanSwingJInternalFrame presupuestoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajaBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contablePresupuestoFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contablePresupuestoFlujoCaja() {
		return this.resaltarid_cuenta_contablePresupuestoFlujoCaja;
	}

	public void setResaltarid_cuenta_contablePresupuestoFlujoCaja(Border borderResaltar) {
		this.resaltarid_cuenta_contablePresupuestoFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contablePresupuestoFlujoCaja() {
		return this.mostrarid_cuenta_contablePresupuestoFlujoCaja;
	}

	public void setMostrarid_cuenta_contablePresupuestoFlujoCaja(Boolean mostrarid_cuenta_contablePresupuestoFlujoCaja) {
		this.mostrarid_cuenta_contablePresupuestoFlujoCaja= mostrarid_cuenta_contablePresupuestoFlujoCaja;
	}

	public Boolean getActivarid_cuenta_contablePresupuestoFlujoCaja() {
		return this.activarid_cuenta_contablePresupuestoFlujoCaja;
	}

	public void setActivarid_cuenta_contablePresupuestoFlujoCaja(Boolean activarid_cuenta_contablePresupuestoFlujoCaja) {
		this.activarid_cuenta_contablePresupuestoFlujoCaja= activarid_cuenta_contablePresupuestoFlujoCaja;
	}

	public Boolean getCargarid_cuenta_contablePresupuestoFlujoCaja() {
		return this.cargarid_cuenta_contablePresupuestoFlujoCaja;
	}

	public void setCargarid_cuenta_contablePresupuestoFlujoCaja(Boolean cargarid_cuenta_contablePresupuestoFlujoCaja) {
		this.cargarid_cuenta_contablePresupuestoFlujoCaja= cargarid_cuenta_contablePresupuestoFlujoCaja;
	}

	public Border setResaltarid_ejercicioPresupuestoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaBeanSwingJInternalFrame presupuestoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajaBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioPresupuestoFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioPresupuestoFlujoCaja() {
		return this.resaltarid_ejercicioPresupuestoFlujoCaja;
	}

	public void setResaltarid_ejercicioPresupuestoFlujoCaja(Border borderResaltar) {
		this.resaltarid_ejercicioPresupuestoFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioPresupuestoFlujoCaja() {
		return this.mostrarid_ejercicioPresupuestoFlujoCaja;
	}

	public void setMostrarid_ejercicioPresupuestoFlujoCaja(Boolean mostrarid_ejercicioPresupuestoFlujoCaja) {
		this.mostrarid_ejercicioPresupuestoFlujoCaja= mostrarid_ejercicioPresupuestoFlujoCaja;
	}

	public Boolean getActivarid_ejercicioPresupuestoFlujoCaja() {
		return this.activarid_ejercicioPresupuestoFlujoCaja;
	}

	public void setActivarid_ejercicioPresupuestoFlujoCaja(Boolean activarid_ejercicioPresupuestoFlujoCaja) {
		this.activarid_ejercicioPresupuestoFlujoCaja= activarid_ejercicioPresupuestoFlujoCaja;
	}

	public Boolean getCargarid_ejercicioPresupuestoFlujoCaja() {
		return this.cargarid_ejercicioPresupuestoFlujoCaja;
	}

	public void setCargarid_ejercicioPresupuestoFlujoCaja(Boolean cargarid_ejercicioPresupuestoFlujoCaja) {
		this.cargarid_ejercicioPresupuestoFlujoCaja= cargarid_ejercicioPresupuestoFlujoCaja;
	}

	public Border setResaltarid_periodoPresupuestoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaBeanSwingJInternalFrame presupuestoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajaBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarid_periodoPresupuestoFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoPresupuestoFlujoCaja() {
		return this.resaltarid_periodoPresupuestoFlujoCaja;
	}

	public void setResaltarid_periodoPresupuestoFlujoCaja(Border borderResaltar) {
		this.resaltarid_periodoPresupuestoFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarid_periodoPresupuestoFlujoCaja() {
		return this.mostrarid_periodoPresupuestoFlujoCaja;
	}

	public void setMostrarid_periodoPresupuestoFlujoCaja(Boolean mostrarid_periodoPresupuestoFlujoCaja) {
		this.mostrarid_periodoPresupuestoFlujoCaja= mostrarid_periodoPresupuestoFlujoCaja;
	}

	public Boolean getActivarid_periodoPresupuestoFlujoCaja() {
		return this.activarid_periodoPresupuestoFlujoCaja;
	}

	public void setActivarid_periodoPresupuestoFlujoCaja(Boolean activarid_periodoPresupuestoFlujoCaja) {
		this.activarid_periodoPresupuestoFlujoCaja= activarid_periodoPresupuestoFlujoCaja;
	}

	public Boolean getCargarid_periodoPresupuestoFlujoCaja() {
		return this.cargarid_periodoPresupuestoFlujoCaja;
	}

	public void setCargarid_periodoPresupuestoFlujoCaja(Boolean cargarid_periodoPresupuestoFlujoCaja) {
		this.cargarid_periodoPresupuestoFlujoCaja= cargarid_periodoPresupuestoFlujoCaja;
	}

	public Border setResaltarid_centro_costoPresupuestoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaBeanSwingJInternalFrame presupuestoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajaBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoPresupuestoFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoPresupuestoFlujoCaja() {
		return this.resaltarid_centro_costoPresupuestoFlujoCaja;
	}

	public void setResaltarid_centro_costoPresupuestoFlujoCaja(Border borderResaltar) {
		this.resaltarid_centro_costoPresupuestoFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoPresupuestoFlujoCaja() {
		return this.mostrarid_centro_costoPresupuestoFlujoCaja;
	}

	public void setMostrarid_centro_costoPresupuestoFlujoCaja(Boolean mostrarid_centro_costoPresupuestoFlujoCaja) {
		this.mostrarid_centro_costoPresupuestoFlujoCaja= mostrarid_centro_costoPresupuestoFlujoCaja;
	}

	public Boolean getActivarid_centro_costoPresupuestoFlujoCaja() {
		return this.activarid_centro_costoPresupuestoFlujoCaja;
	}

	public void setActivarid_centro_costoPresupuestoFlujoCaja(Boolean activarid_centro_costoPresupuestoFlujoCaja) {
		this.activarid_centro_costoPresupuestoFlujoCaja= activarid_centro_costoPresupuestoFlujoCaja;
	}

	public Boolean getCargarid_centro_costoPresupuestoFlujoCaja() {
		return this.cargarid_centro_costoPresupuestoFlujoCaja;
	}

	public void setCargarid_centro_costoPresupuestoFlujoCaja(Boolean cargarid_centro_costoPresupuestoFlujoCaja) {
		this.cargarid_centro_costoPresupuestoFlujoCaja= cargarid_centro_costoPresupuestoFlujoCaja;
	}

	public Border setResaltarvalorPresupuestoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaBeanSwingJInternalFrame presupuestoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajaBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarvalorPresupuestoFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorPresupuestoFlujoCaja() {
		return this.resaltarvalorPresupuestoFlujoCaja;
	}

	public void setResaltarvalorPresupuestoFlujoCaja(Border borderResaltar) {
		this.resaltarvalorPresupuestoFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarvalorPresupuestoFlujoCaja() {
		return this.mostrarvalorPresupuestoFlujoCaja;
	}

	public void setMostrarvalorPresupuestoFlujoCaja(Boolean mostrarvalorPresupuestoFlujoCaja) {
		this.mostrarvalorPresupuestoFlujoCaja= mostrarvalorPresupuestoFlujoCaja;
	}

	public Boolean getActivarvalorPresupuestoFlujoCaja() {
		return this.activarvalorPresupuestoFlujoCaja;
	}

	public void setActivarvalorPresupuestoFlujoCaja(Boolean activarvalorPresupuestoFlujoCaja) {
		this.activarvalorPresupuestoFlujoCaja= activarvalorPresupuestoFlujoCaja;
	}

	public Border setResaltarvalor_efectivoPresupuestoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaBeanSwingJInternalFrame presupuestoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajaBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarvalor_efectivoPresupuestoFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_efectivoPresupuestoFlujoCaja() {
		return this.resaltarvalor_efectivoPresupuestoFlujoCaja;
	}

	public void setResaltarvalor_efectivoPresupuestoFlujoCaja(Border borderResaltar) {
		this.resaltarvalor_efectivoPresupuestoFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarvalor_efectivoPresupuestoFlujoCaja() {
		return this.mostrarvalor_efectivoPresupuestoFlujoCaja;
	}

	public void setMostrarvalor_efectivoPresupuestoFlujoCaja(Boolean mostrarvalor_efectivoPresupuestoFlujoCaja) {
		this.mostrarvalor_efectivoPresupuestoFlujoCaja= mostrarvalor_efectivoPresupuestoFlujoCaja;
	}

	public Boolean getActivarvalor_efectivoPresupuestoFlujoCaja() {
		return this.activarvalor_efectivoPresupuestoFlujoCaja;
	}

	public void setActivarvalor_efectivoPresupuestoFlujoCaja(Boolean activarvalor_efectivoPresupuestoFlujoCaja) {
		this.activarvalor_efectivoPresupuestoFlujoCaja= activarvalor_efectivoPresupuestoFlujoCaja;
	}

	public Border setResaltarporcentajePresupuestoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaBeanSwingJInternalFrame presupuestoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajaBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarporcentajePresupuestoFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajePresupuestoFlujoCaja() {
		return this.resaltarporcentajePresupuestoFlujoCaja;
	}

	public void setResaltarporcentajePresupuestoFlujoCaja(Border borderResaltar) {
		this.resaltarporcentajePresupuestoFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarporcentajePresupuestoFlujoCaja() {
		return this.mostrarporcentajePresupuestoFlujoCaja;
	}

	public void setMostrarporcentajePresupuestoFlujoCaja(Boolean mostrarporcentajePresupuestoFlujoCaja) {
		this.mostrarporcentajePresupuestoFlujoCaja= mostrarporcentajePresupuestoFlujoCaja;
	}

	public Boolean getActivarporcentajePresupuestoFlujoCaja() {
		return this.activarporcentajePresupuestoFlujoCaja;
	}

	public void setActivarporcentajePresupuestoFlujoCaja(Boolean activarporcentajePresupuestoFlujoCaja) {
		this.activarporcentajePresupuestoFlujoCaja= activarporcentajePresupuestoFlujoCaja;
	}

	public Border setResaltarfecha_presupuestoPresupuestoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaBeanSwingJInternalFrame presupuestoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajaBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarfecha_presupuestoPresupuestoFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_presupuestoPresupuestoFlujoCaja() {
		return this.resaltarfecha_presupuestoPresupuestoFlujoCaja;
	}

	public void setResaltarfecha_presupuestoPresupuestoFlujoCaja(Border borderResaltar) {
		this.resaltarfecha_presupuestoPresupuestoFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarfecha_presupuestoPresupuestoFlujoCaja() {
		return this.mostrarfecha_presupuestoPresupuestoFlujoCaja;
	}

	public void setMostrarfecha_presupuestoPresupuestoFlujoCaja(Boolean mostrarfecha_presupuestoPresupuestoFlujoCaja) {
		this.mostrarfecha_presupuestoPresupuestoFlujoCaja= mostrarfecha_presupuestoPresupuestoFlujoCaja;
	}

	public Boolean getActivarfecha_presupuestoPresupuestoFlujoCaja() {
		return this.activarfecha_presupuestoPresupuestoFlujoCaja;
	}

	public void setActivarfecha_presupuestoPresupuestoFlujoCaja(Boolean activarfecha_presupuestoPresupuestoFlujoCaja) {
		this.activarfecha_presupuestoPresupuestoFlujoCaja= activarfecha_presupuestoPresupuestoFlujoCaja;
	}

	public Border setResaltarfecha_procesoPresupuestoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaBeanSwingJInternalFrame presupuestoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajaBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarfecha_procesoPresupuestoFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_procesoPresupuestoFlujoCaja() {
		return this.resaltarfecha_procesoPresupuestoFlujoCaja;
	}

	public void setResaltarfecha_procesoPresupuestoFlujoCaja(Border borderResaltar) {
		this.resaltarfecha_procesoPresupuestoFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarfecha_procesoPresupuestoFlujoCaja() {
		return this.mostrarfecha_procesoPresupuestoFlujoCaja;
	}

	public void setMostrarfecha_procesoPresupuestoFlujoCaja(Boolean mostrarfecha_procesoPresupuestoFlujoCaja) {
		this.mostrarfecha_procesoPresupuestoFlujoCaja= mostrarfecha_procesoPresupuestoFlujoCaja;
	}

	public Boolean getActivarfecha_procesoPresupuestoFlujoCaja() {
		return this.activarfecha_procesoPresupuestoFlujoCaja;
	}

	public void setActivarfecha_procesoPresupuestoFlujoCaja(Boolean activarfecha_procesoPresupuestoFlujoCaja) {
		this.activarfecha_procesoPresupuestoFlujoCaja= activarfecha_procesoPresupuestoFlujoCaja;
	}

	public Border setResaltarobservacionPresupuestoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaBeanSwingJInternalFrame presupuestoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajaBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarobservacionPresupuestoFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarobservacionPresupuestoFlujoCaja() {
		return this.resaltarobservacionPresupuestoFlujoCaja;
	}

	public void setResaltarobservacionPresupuestoFlujoCaja(Border borderResaltar) {
		this.resaltarobservacionPresupuestoFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarobservacionPresupuestoFlujoCaja() {
		return this.mostrarobservacionPresupuestoFlujoCaja;
	}

	public void setMostrarobservacionPresupuestoFlujoCaja(Boolean mostrarobservacionPresupuestoFlujoCaja) {
		this.mostrarobservacionPresupuestoFlujoCaja= mostrarobservacionPresupuestoFlujoCaja;
	}

	public Boolean getActivarobservacionPresupuestoFlujoCaja() {
		return this.activarobservacionPresupuestoFlujoCaja;
	}

	public void setActivarobservacionPresupuestoFlujoCaja(Boolean activarobservacionPresupuestoFlujoCaja) {
		this.activarobservacionPresupuestoFlujoCaja= activarobservacionPresupuestoFlujoCaja;
	}

	public Border setResaltarid_anioPresupuestoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaBeanSwingJInternalFrame presupuestoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajaBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarid_anioPresupuestoFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioPresupuestoFlujoCaja() {
		return this.resaltarid_anioPresupuestoFlujoCaja;
	}

	public void setResaltarid_anioPresupuestoFlujoCaja(Border borderResaltar) {
		this.resaltarid_anioPresupuestoFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarid_anioPresupuestoFlujoCaja() {
		return this.mostrarid_anioPresupuestoFlujoCaja;
	}

	public void setMostrarid_anioPresupuestoFlujoCaja(Boolean mostrarid_anioPresupuestoFlujoCaja) {
		this.mostrarid_anioPresupuestoFlujoCaja= mostrarid_anioPresupuestoFlujoCaja;
	}

	public Boolean getActivarid_anioPresupuestoFlujoCaja() {
		return this.activarid_anioPresupuestoFlujoCaja;
	}

	public void setActivarid_anioPresupuestoFlujoCaja(Boolean activarid_anioPresupuestoFlujoCaja) {
		this.activarid_anioPresupuestoFlujoCaja= activarid_anioPresupuestoFlujoCaja;
	}

	public Boolean getCargarid_anioPresupuestoFlujoCaja() {
		return this.cargarid_anioPresupuestoFlujoCaja;
	}

	public void setCargarid_anioPresupuestoFlujoCaja(Boolean cargarid_anioPresupuestoFlujoCaja) {
		this.cargarid_anioPresupuestoFlujoCaja= cargarid_anioPresupuestoFlujoCaja;
	}

	public Border setResaltarid_mesPresupuestoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaBeanSwingJInternalFrame presupuestoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoflujocajaBeanSwingJInternalFrame.jTtoolBarPresupuestoFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarid_mesPresupuestoFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesPresupuestoFlujoCaja() {
		return this.resaltarid_mesPresupuestoFlujoCaja;
	}

	public void setResaltarid_mesPresupuestoFlujoCaja(Border borderResaltar) {
		this.resaltarid_mesPresupuestoFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarid_mesPresupuestoFlujoCaja() {
		return this.mostrarid_mesPresupuestoFlujoCaja;
	}

	public void setMostrarid_mesPresupuestoFlujoCaja(Boolean mostrarid_mesPresupuestoFlujoCaja) {
		this.mostrarid_mesPresupuestoFlujoCaja= mostrarid_mesPresupuestoFlujoCaja;
	}

	public Boolean getActivarid_mesPresupuestoFlujoCaja() {
		return this.activarid_mesPresupuestoFlujoCaja;
	}

	public void setActivarid_mesPresupuestoFlujoCaja(Boolean activarid_mesPresupuestoFlujoCaja) {
		this.activarid_mesPresupuestoFlujoCaja= activarid_mesPresupuestoFlujoCaja;
	}

	public Boolean getCargarid_mesPresupuestoFlujoCaja() {
		return this.cargarid_mesPresupuestoFlujoCaja;
	}

	public void setCargarid_mesPresupuestoFlujoCaja(Boolean cargarid_mesPresupuestoFlujoCaja) {
		this.cargarid_mesPresupuestoFlujoCaja= cargarid_mesPresupuestoFlujoCaja;
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
		
		
		this.setMostraridPresupuestoFlujoCaja(esInicial);
		this.setMostrarid_empresaPresupuestoFlujoCaja(esInicial);
		this.setMostrarid_cuenta_contablePresupuestoFlujoCaja(esInicial);
		this.setMostrarid_ejercicioPresupuestoFlujoCaja(esInicial);
		this.setMostrarid_periodoPresupuestoFlujoCaja(esInicial);
		this.setMostrarid_centro_costoPresupuestoFlujoCaja(esInicial);
		this.setMostrarvalorPresupuestoFlujoCaja(esInicial);
		this.setMostrarvalor_efectivoPresupuestoFlujoCaja(esInicial);
		this.setMostrarporcentajePresupuestoFlujoCaja(esInicial);
		this.setMostrarfecha_presupuestoPresupuestoFlujoCaja(esInicial);
		this.setMostrarfecha_procesoPresupuestoFlujoCaja(esInicial);
		this.setMostrarobservacionPresupuestoFlujoCaja(esInicial);
		this.setMostrarid_anioPresupuestoFlujoCaja(esInicial);
		this.setMostrarid_mesPresupuestoFlujoCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.ID)) {
				this.setMostraridPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contablePresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.VALOR)) {
				this.setMostrarvalorPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.VALOREFECTIVO)) {
				this.setMostrarvalor_efectivoPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajePresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.FECHAPRESUPUESTO)) {
				this.setMostrarfecha_presupuestoPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.FECHAPROCESO)) {
				this.setMostrarfecha_procesoPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.OBSERVACION)) {
				this.setMostrarobservacionPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.IDMES)) {
				this.setMostrarid_mesPresupuestoFlujoCaja(esAsigna);
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
		
		
		this.setActivaridPresupuestoFlujoCaja(esInicial);
		this.setActivarid_empresaPresupuestoFlujoCaja(esInicial);
		this.setActivarid_cuenta_contablePresupuestoFlujoCaja(esInicial);
		this.setActivarid_ejercicioPresupuestoFlujoCaja(esInicial);
		this.setActivarid_periodoPresupuestoFlujoCaja(esInicial);
		this.setActivarid_centro_costoPresupuestoFlujoCaja(esInicial);
		this.setActivarvalorPresupuestoFlujoCaja(esInicial);
		this.setActivarvalor_efectivoPresupuestoFlujoCaja(esInicial);
		this.setActivarporcentajePresupuestoFlujoCaja(esInicial);
		this.setActivarfecha_presupuestoPresupuestoFlujoCaja(esInicial);
		this.setActivarfecha_procesoPresupuestoFlujoCaja(esInicial);
		this.setActivarobservacionPresupuestoFlujoCaja(esInicial);
		this.setActivarid_anioPresupuestoFlujoCaja(esInicial);
		this.setActivarid_mesPresupuestoFlujoCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.ID)) {
				this.setActivaridPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contablePresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.VALOR)) {
				this.setActivarvalorPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.VALOREFECTIVO)) {
				this.setActivarvalor_efectivoPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajePresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.FECHAPRESUPUESTO)) {
				this.setActivarfecha_presupuestoPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.FECHAPROCESO)) {
				this.setActivarfecha_procesoPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.OBSERVACION)) {
				this.setActivarobservacionPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.IDANIO)) {
				this.setActivarid_anioPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.IDMES)) {
				this.setActivarid_mesPresupuestoFlujoCaja(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PresupuestoFlujoCajaBeanSwingJInternalFrame presupuestoflujocajaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPresupuestoFlujoCaja(esInicial);
		this.setResaltarid_empresaPresupuestoFlujoCaja(esInicial);
		this.setResaltarid_cuenta_contablePresupuestoFlujoCaja(esInicial);
		this.setResaltarid_ejercicioPresupuestoFlujoCaja(esInicial);
		this.setResaltarid_periodoPresupuestoFlujoCaja(esInicial);
		this.setResaltarid_centro_costoPresupuestoFlujoCaja(esInicial);
		this.setResaltarvalorPresupuestoFlujoCaja(esInicial);
		this.setResaltarvalor_efectivoPresupuestoFlujoCaja(esInicial);
		this.setResaltarporcentajePresupuestoFlujoCaja(esInicial);
		this.setResaltarfecha_presupuestoPresupuestoFlujoCaja(esInicial);
		this.setResaltarfecha_procesoPresupuestoFlujoCaja(esInicial);
		this.setResaltarobservacionPresupuestoFlujoCaja(esInicial);
		this.setResaltarid_anioPresupuestoFlujoCaja(esInicial);
		this.setResaltarid_mesPresupuestoFlujoCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.ID)) {
				this.setResaltaridPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contablePresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.VALOR)) {
				this.setResaltarvalorPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.VALOREFECTIVO)) {
				this.setResaltarvalor_efectivoPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajePresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.FECHAPRESUPUESTO)) {
				this.setResaltarfecha_presupuestoPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.FECHAPROCESO)) {
				this.setResaltarfecha_procesoPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.OBSERVACION)) {
				this.setResaltarobservacionPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioPresupuestoFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoFlujoCajaConstantesFunciones.IDMES)) {
				this.setResaltarid_mesPresupuestoFlujoCaja(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PresupuestoFlujoCajaBeanSwingJInternalFrame presupuestoflujocajaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCentroCostoPresupuestoFlujoCaja=true;

	public Boolean getMostrarFK_IdCentroCostoPresupuestoFlujoCaja() {
		return this.mostrarFK_IdCentroCostoPresupuestoFlujoCaja;
	}

	public void setMostrarFK_IdCentroCostoPresupuestoFlujoCaja(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoPresupuestoFlujoCaja= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContablePresupuestoFlujoCaja=true;

	public Boolean getMostrarFK_IdCuentaContablePresupuestoFlujoCaja() {
		return this.mostrarFK_IdCuentaContablePresupuestoFlujoCaja;
	}

	public void setMostrarFK_IdCuentaContablePresupuestoFlujoCaja(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContablePresupuestoFlujoCaja= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioPresupuestoFlujoCaja=true;

	public Boolean getMostrarFK_IdEjercicioPresupuestoFlujoCaja() {
		return this.mostrarFK_IdEjercicioPresupuestoFlujoCaja;
	}

	public void setMostrarFK_IdEjercicioPresupuestoFlujoCaja(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioPresupuestoFlujoCaja= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPresupuestoFlujoCaja=true;

	public Boolean getMostrarFK_IdEmpresaPresupuestoFlujoCaja() {
		return this.mostrarFK_IdEmpresaPresupuestoFlujoCaja;
	}

	public void setMostrarFK_IdEmpresaPresupuestoFlujoCaja(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPresupuestoFlujoCaja= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoPresupuestoFlujoCaja=true;

	public Boolean getMostrarFK_IdPeriodoPresupuestoFlujoCaja() {
		return this.mostrarFK_IdPeriodoPresupuestoFlujoCaja;
	}

	public void setMostrarFK_IdPeriodoPresupuestoFlujoCaja(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoPresupuestoFlujoCaja= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCentroCostoPresupuestoFlujoCaja=true;

	public Boolean getActivarFK_IdCentroCostoPresupuestoFlujoCaja() {
		return this.activarFK_IdCentroCostoPresupuestoFlujoCaja;
	}

	public void setActivarFK_IdCentroCostoPresupuestoFlujoCaja(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoPresupuestoFlujoCaja= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContablePresupuestoFlujoCaja=true;

	public Boolean getActivarFK_IdCuentaContablePresupuestoFlujoCaja() {
		return this.activarFK_IdCuentaContablePresupuestoFlujoCaja;
	}

	public void setActivarFK_IdCuentaContablePresupuestoFlujoCaja(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContablePresupuestoFlujoCaja= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioPresupuestoFlujoCaja=true;

	public Boolean getActivarFK_IdEjercicioPresupuestoFlujoCaja() {
		return this.activarFK_IdEjercicioPresupuestoFlujoCaja;
	}

	public void setActivarFK_IdEjercicioPresupuestoFlujoCaja(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioPresupuestoFlujoCaja= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPresupuestoFlujoCaja=true;

	public Boolean getActivarFK_IdEmpresaPresupuestoFlujoCaja() {
		return this.activarFK_IdEmpresaPresupuestoFlujoCaja;
	}

	public void setActivarFK_IdEmpresaPresupuestoFlujoCaja(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPresupuestoFlujoCaja= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoPresupuestoFlujoCaja=true;

	public Boolean getActivarFK_IdPeriodoPresupuestoFlujoCaja() {
		return this.activarFK_IdPeriodoPresupuestoFlujoCaja;
	}

	public void setActivarFK_IdPeriodoPresupuestoFlujoCaja(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoPresupuestoFlujoCaja= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCentroCostoPresupuestoFlujoCaja=null;

	public Border getResaltarFK_IdCentroCostoPresupuestoFlujoCaja() {
		return this.resaltarFK_IdCentroCostoPresupuestoFlujoCaja;
	}

	public void setResaltarFK_IdCentroCostoPresupuestoFlujoCaja(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoPresupuestoFlujoCaja= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoPresupuestoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaBeanSwingJInternalFrame presupuestoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoPresupuestoFlujoCaja= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContablePresupuestoFlujoCaja=null;

	public Border getResaltarFK_IdCuentaContablePresupuestoFlujoCaja() {
		return this.resaltarFK_IdCuentaContablePresupuestoFlujoCaja;
	}

	public void setResaltarFK_IdCuentaContablePresupuestoFlujoCaja(Border borderResaltar) {
		this.resaltarFK_IdCuentaContablePresupuestoFlujoCaja= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContablePresupuestoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaBeanSwingJInternalFrame presupuestoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContablePresupuestoFlujoCaja= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioPresupuestoFlujoCaja=null;

	public Border getResaltarFK_IdEjercicioPresupuestoFlujoCaja() {
		return this.resaltarFK_IdEjercicioPresupuestoFlujoCaja;
	}

	public void setResaltarFK_IdEjercicioPresupuestoFlujoCaja(Border borderResaltar) {
		this.resaltarFK_IdEjercicioPresupuestoFlujoCaja= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioPresupuestoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaBeanSwingJInternalFrame presupuestoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioPresupuestoFlujoCaja= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPresupuestoFlujoCaja=null;

	public Border getResaltarFK_IdEmpresaPresupuestoFlujoCaja() {
		return this.resaltarFK_IdEmpresaPresupuestoFlujoCaja;
	}

	public void setResaltarFK_IdEmpresaPresupuestoFlujoCaja(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPresupuestoFlujoCaja= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPresupuestoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaBeanSwingJInternalFrame presupuestoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPresupuestoFlujoCaja= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoPresupuestoFlujoCaja=null;

	public Border getResaltarFK_IdPeriodoPresupuestoFlujoCaja() {
		return this.resaltarFK_IdPeriodoPresupuestoFlujoCaja;
	}

	public void setResaltarFK_IdPeriodoPresupuestoFlujoCaja(Border borderResaltar) {
		this.resaltarFK_IdPeriodoPresupuestoFlujoCaja= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoPresupuestoFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoFlujoCajaBeanSwingJInternalFrame presupuestoflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoPresupuestoFlujoCaja= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}