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
package com.bydan.erp.puntoventa.util;

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


import com.bydan.erp.puntoventa.util.PresupuestoVentasPunVenConstantesFunciones;
import com.bydan.erp.puntoventa.util.PresupuestoVentasPunVenParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.PresupuestoVentasPunVenParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PresupuestoVentasPunVenConstantesFunciones extends PresupuestoVentasPunVenConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PresupuestoVentasPunVen";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PresupuestoVentasPunVen"+PresupuestoVentasPunVenConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PresupuestoVentasPunVenHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PresupuestoVentasPunVenHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"_"+PresupuestoVentasPunVenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PresupuestoVentasPunVenHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"_"+PresupuestoVentasPunVenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"_"+PresupuestoVentasPunVenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PresupuestoVentasPunVenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"_"+PresupuestoVentasPunVenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestoVentasPunVenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresupuestoVentasPunVenHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestoVentasPunVenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestoVentasPunVenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresupuestoVentasPunVenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestoVentasPunVenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PresupuestoVentasPunVenConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PresupuestoVentasPunVenConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PresupuestoVentasPunVenConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PresupuestoVentasPunVenConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Presupuesto Ventases";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Presupuesto Ventas";
	public static final String SCLASSWEBTITULO_LOWER="Presupuesto Ventas Pun Ven";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PresupuestoVentasPunVen";
	public static final String OBJECTNAME="presupuestoventaspunven";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="presupuesto_ventas_pun_ven";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select presupuestoventaspunven from "+PresupuestoVentasPunVenConstantesFunciones.SPERSISTENCENAME+" presupuestoventaspunven";
	public static String QUERYSELECTNATIVE="select "+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+".id,"+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+".version_row,"+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+".id_empresa,"+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+".id_sucursal,"+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+".id_ejercicio,"+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+".id_periodo,"+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+".id_caja,"+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+".valor,"+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+".cantidad,"+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+".porcentaje,"+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+".cantidad_total,"+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+".valor_total from "+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME;//+" as "+PresupuestoVentasPunVenConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PresupuestoVentasPunVenConstantesFuncionesAdditional presupuestoventaspunvenConstantesFuncionesAdditional=null;
	
	public PresupuestoVentasPunVenConstantesFuncionesAdditional getPresupuestoVentasPunVenConstantesFuncionesAdditional() {
		return this.presupuestoventaspunvenConstantesFuncionesAdditional;
	}
	
	public void setPresupuestoVentasPunVenConstantesFuncionesAdditional(PresupuestoVentasPunVenConstantesFuncionesAdditional presupuestoventaspunvenConstantesFuncionesAdditional) {
		try {
			this.presupuestoventaspunvenConstantesFuncionesAdditional=presupuestoventaspunvenConstantesFuncionesAdditional;
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
    public static final String IDCAJA= "id_caja";
    public static final String VALOR= "valor";
    public static final String CANTIDAD= "cantidad";
    public static final String PORCENTAJE= "porcentaje";
    public static final String CANTIDADTOTAL= "cantidad_total";
    public static final String VALORTOTAL= "valor_total";
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
    	public static final String LABEL_IDCAJA= "Caja";
		public static final String LABEL_IDCAJA_LOWER= "Caja";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_CANTIDAD= "Cantad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_CANTIDADTOTAL= "Cantad Total";
		public static final String LABEL_CANTIDADTOTAL_LOWER= "Cantidad Total";
    	public static final String LABEL_VALORTOTAL= "Valor Total";
		public static final String LABEL_VALORTOTAL_LOWER= "Valor Total";
	
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getPresupuestoVentasPunVenLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PresupuestoVentasPunVenConstantesFunciones.IDEMPRESA)) {sLabelColumna=PresupuestoVentasPunVenConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PresupuestoVentasPunVenConstantesFunciones.IDSUCURSAL)) {sLabelColumna=PresupuestoVentasPunVenConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(PresupuestoVentasPunVenConstantesFunciones.IDEJERCICIO)) {sLabelColumna=PresupuestoVentasPunVenConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(PresupuestoVentasPunVenConstantesFunciones.IDPERIODO)) {sLabelColumna=PresupuestoVentasPunVenConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(PresupuestoVentasPunVenConstantesFunciones.IDCAJA)) {sLabelColumna=PresupuestoVentasPunVenConstantesFunciones.LABEL_IDCAJA;}
		if(sNombreColumna.equals(PresupuestoVentasPunVenConstantesFunciones.VALOR)) {sLabelColumna=PresupuestoVentasPunVenConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(PresupuestoVentasPunVenConstantesFunciones.CANTIDAD)) {sLabelColumna=PresupuestoVentasPunVenConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(PresupuestoVentasPunVenConstantesFunciones.PORCENTAJE)) {sLabelColumna=PresupuestoVentasPunVenConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(PresupuestoVentasPunVenConstantesFunciones.CANTIDADTOTAL)) {sLabelColumna=PresupuestoVentasPunVenConstantesFunciones.LABEL_CANTIDADTOTAL;}
		if(sNombreColumna.equals(PresupuestoVentasPunVenConstantesFunciones.VALORTOTAL)) {sLabelColumna=PresupuestoVentasPunVenConstantesFunciones.LABEL_VALORTOTAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getPresupuestoVentasPunVenDescripcion(PresupuestoVentasPunVen presupuestoventaspunven) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(presupuestoventaspunven !=null/* && presupuestoventaspunven.getId()!=0*/) {
			if(presupuestoventaspunven.getId()!=null) {
				sDescripcion=presupuestoventaspunven.getId().toString();
			}//presupuestoventaspunvenpresupuestoventaspunven.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPresupuestoVentasPunVenDescripcionDetallado(PresupuestoVentasPunVen presupuestoventaspunven) {
		String sDescripcion="";
			
		sDescripcion+=PresupuestoVentasPunVenConstantesFunciones.ID+"=";
		sDescripcion+=presupuestoventaspunven.getId().toString()+",";
		sDescripcion+=PresupuestoVentasPunVenConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=presupuestoventaspunven.getVersionRow().toString()+",";
		sDescripcion+=PresupuestoVentasPunVenConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=presupuestoventaspunven.getid_empresa().toString()+",";
		sDescripcion+=PresupuestoVentasPunVenConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=presupuestoventaspunven.getid_sucursal().toString()+",";
		sDescripcion+=PresupuestoVentasPunVenConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=presupuestoventaspunven.getid_ejercicio().toString()+",";
		sDescripcion+=PresupuestoVentasPunVenConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=presupuestoventaspunven.getid_periodo().toString()+",";
		sDescripcion+=PresupuestoVentasPunVenConstantesFunciones.IDCAJA+"=";
		sDescripcion+=presupuestoventaspunven.getid_caja().toString()+",";
		sDescripcion+=PresupuestoVentasPunVenConstantesFunciones.VALOR+"=";
		sDescripcion+=presupuestoventaspunven.getvalor().toString()+",";
		sDescripcion+=PresupuestoVentasPunVenConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=presupuestoventaspunven.getcantidad().toString()+",";
		sDescripcion+=PresupuestoVentasPunVenConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=presupuestoventaspunven.getporcentaje().toString()+",";
		sDescripcion+=PresupuestoVentasPunVenConstantesFunciones.CANTIDADTOTAL+"=";
		sDescripcion+=presupuestoventaspunven.getcantidad_total().toString()+",";
		sDescripcion+=PresupuestoVentasPunVenConstantesFunciones.VALORTOTAL+"=";
		sDescripcion+=presupuestoventaspunven.getvalor_total().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPresupuestoVentasPunVenDescripcion(PresupuestoVentasPunVen presupuestoventaspunven,String sValor) throws Exception {			
		if(presupuestoventaspunven !=null) {
			//presupuestoventaspunvenpresupuestoventaspunven.getId().toString();
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

	public static String getCajaDescripcion(Caja caja) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(caja!=null/*&&caja.getId()>0*/) {
			sDescripcion=CajaConstantesFunciones.getCajaDescripcion(caja);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCaja")) {
			sNombreIndice="Tipo=  Por Caja";
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

	public static String getDetalleIndiceFK_IdCaja(Long id_caja) {
		String sDetalleIndice=" Parametros->";
		if(id_caja!=null) {sDetalleIndice+=" Codigo Unico De Caja="+id_caja.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosPresupuestoVentasPunVen(PresupuestoVentasPunVen presupuestoventaspunven,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosPresupuestoVentasPunVens(List<PresupuestoVentasPunVen> presupuestoventaspunvens,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PresupuestoVentasPunVen presupuestoventaspunven: presupuestoventaspunvens) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresupuestoVentasPunVen(PresupuestoVentasPunVen presupuestoventaspunven,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && presupuestoventaspunven.getConCambioAuxiliar()) {
			presupuestoventaspunven.setIsDeleted(presupuestoventaspunven.getIsDeletedAuxiliar());	
			presupuestoventaspunven.setIsNew(presupuestoventaspunven.getIsNewAuxiliar());	
			presupuestoventaspunven.setIsChanged(presupuestoventaspunven.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			presupuestoventaspunven.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			presupuestoventaspunven.setIsDeletedAuxiliar(false);	
			presupuestoventaspunven.setIsNewAuxiliar(false);	
			presupuestoventaspunven.setIsChangedAuxiliar(false);
			
			presupuestoventaspunven.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresupuestoVentasPunVens(List<PresupuestoVentasPunVen> presupuestoventaspunvens,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PresupuestoVentasPunVen presupuestoventaspunven : presupuestoventaspunvens) {
			if(conAsignarBase && presupuestoventaspunven.getConCambioAuxiliar()) {
				presupuestoventaspunven.setIsDeleted(presupuestoventaspunven.getIsDeletedAuxiliar());	
				presupuestoventaspunven.setIsNew(presupuestoventaspunven.getIsNewAuxiliar());	
				presupuestoventaspunven.setIsChanged(presupuestoventaspunven.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				presupuestoventaspunven.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				presupuestoventaspunven.setIsDeletedAuxiliar(false);	
				presupuestoventaspunven.setIsNewAuxiliar(false);	
				presupuestoventaspunven.setIsChangedAuxiliar(false);
				
				presupuestoventaspunven.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPresupuestoVentasPunVen(PresupuestoVentasPunVen presupuestoventaspunven,Boolean conEnteros) throws Exception  {
		presupuestoventaspunven.setvalor(0.0);
		presupuestoventaspunven.setporcentaje(0.0);
		presupuestoventaspunven.setvalor_total(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			presupuestoventaspunven.setcantidad(0);
			presupuestoventaspunven.setcantidad_total(0);
		}
	}		
	
	public static void InicializarValoresPresupuestoVentasPunVens(List<PresupuestoVentasPunVen> presupuestoventaspunvens,Boolean conEnteros) throws Exception  {
		
		for(PresupuestoVentasPunVen presupuestoventaspunven: presupuestoventaspunvens) {
			presupuestoventaspunven.setvalor(0.0);
			presupuestoventaspunven.setporcentaje(0.0);
			presupuestoventaspunven.setvalor_total(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				presupuestoventaspunven.setcantidad(0);
				presupuestoventaspunven.setcantidad_total(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaPresupuestoVentasPunVen(List<PresupuestoVentasPunVen> presupuestoventaspunvens,PresupuestoVentasPunVen presupuestoventaspunvenAux) throws Exception  {
		PresupuestoVentasPunVenConstantesFunciones.InicializarValoresPresupuestoVentasPunVen(presupuestoventaspunvenAux,true);
		
		for(PresupuestoVentasPunVen presupuestoventaspunven: presupuestoventaspunvens) {
			if(presupuestoventaspunven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			presupuestoventaspunvenAux.setvalor(presupuestoventaspunvenAux.getvalor()+presupuestoventaspunven.getvalor());			
			presupuestoventaspunvenAux.setcantidad(presupuestoventaspunvenAux.getcantidad()+presupuestoventaspunven.getcantidad());			
			presupuestoventaspunvenAux.setporcentaje(presupuestoventaspunvenAux.getporcentaje()+presupuestoventaspunven.getporcentaje());			
			presupuestoventaspunvenAux.setcantidad_total(presupuestoventaspunvenAux.getcantidad_total()+presupuestoventaspunven.getcantidad_total());			
			presupuestoventaspunvenAux.setvalor_total(presupuestoventaspunvenAux.getvalor_total()+presupuestoventaspunven.getvalor_total());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPresupuestoVentasPunVen(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PresupuestoVentasPunVenConstantesFunciones.getArrayColumnasGlobalesPresupuestoVentasPunVen(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPresupuestoVentasPunVen(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresupuestoVentasPunVenConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresupuestoVentasPunVenConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresupuestoVentasPunVenConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresupuestoVentasPunVenConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresupuestoVentasPunVenConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresupuestoVentasPunVenConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresupuestoVentasPunVenConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresupuestoVentasPunVenConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPresupuestoVentasPunVen(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PresupuestoVentasPunVen> presupuestoventaspunvens,PresupuestoVentasPunVen presupuestoventaspunven,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PresupuestoVentasPunVen presupuestoventaspunvenAux: presupuestoventaspunvens) {
			if(presupuestoventaspunvenAux!=null && presupuestoventaspunven!=null) {
				if((presupuestoventaspunvenAux.getId()==null && presupuestoventaspunven.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(presupuestoventaspunvenAux.getId()!=null && presupuestoventaspunven.getId()!=null){
					if(presupuestoventaspunvenAux.getId().equals(presupuestoventaspunven.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPresupuestoVentasPunVen(List<PresupuestoVentasPunVen> presupuestoventaspunvens) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
		Double porcentajeTotal=0.0;
		Double valor_totalTotal=0.0;
	
		for(PresupuestoVentasPunVen presupuestoventaspunven: presupuestoventaspunvens) {			
			if(presupuestoventaspunven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=presupuestoventaspunven.getvalor();
			porcentajeTotal+=presupuestoventaspunven.getporcentaje();
			valor_totalTotal+=presupuestoventaspunven.getvalor_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestoVentasPunVenConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(PresupuestoVentasPunVenConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestoVentasPunVenConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(PresupuestoVentasPunVenConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestoVentasPunVenConstantesFunciones.VALORTOTAL);
		datoGeneral.setsDescripcion(PresupuestoVentasPunVenConstantesFunciones.LABEL_VALORTOTAL);
		datoGeneral.setdValorDouble(valor_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPresupuestoVentasPunVen() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PresupuestoVentasPunVenConstantesFunciones.LABEL_ID, PresupuestoVentasPunVenConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasPunVenConstantesFunciones.LABEL_VERSIONROW, PresupuestoVentasPunVenConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasPunVenConstantesFunciones.LABEL_IDEMPRESA, PresupuestoVentasPunVenConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasPunVenConstantesFunciones.LABEL_IDSUCURSAL, PresupuestoVentasPunVenConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasPunVenConstantesFunciones.LABEL_IDEJERCICIO, PresupuestoVentasPunVenConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasPunVenConstantesFunciones.LABEL_IDPERIODO, PresupuestoVentasPunVenConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasPunVenConstantesFunciones.LABEL_IDCAJA, PresupuestoVentasPunVenConstantesFunciones.IDCAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasPunVenConstantesFunciones.LABEL_VALOR, PresupuestoVentasPunVenConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasPunVenConstantesFunciones.LABEL_CANTIDAD, PresupuestoVentasPunVenConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasPunVenConstantesFunciones.LABEL_PORCENTAJE, PresupuestoVentasPunVenConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasPunVenConstantesFunciones.LABEL_CANTIDADTOTAL, PresupuestoVentasPunVenConstantesFunciones.CANTIDADTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoVentasPunVenConstantesFunciones.LABEL_VALORTOTAL, PresupuestoVentasPunVenConstantesFunciones.VALORTOTAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPresupuestoVentasPunVen() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasPunVenConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasPunVenConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasPunVenConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasPunVenConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasPunVenConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasPunVenConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasPunVenConstantesFunciones.IDCAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasPunVenConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasPunVenConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasPunVenConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasPunVenConstantesFunciones.CANTIDADTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoVentasPunVenConstantesFunciones.VALORTOTAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresupuestoVentasPunVen() throws Exception  {
		return PresupuestoVentasPunVenConstantesFunciones.getTiposSeleccionarPresupuestoVentasPunVen(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresupuestoVentasPunVen(Boolean conFk) throws Exception  {
		return PresupuestoVentasPunVenConstantesFunciones.getTiposSeleccionarPresupuestoVentasPunVen(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresupuestoVentasPunVen(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasPunVenConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PresupuestoVentasPunVenConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasPunVenConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(PresupuestoVentasPunVenConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasPunVenConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(PresupuestoVentasPunVenConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasPunVenConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(PresupuestoVentasPunVenConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasPunVenConstantesFunciones.LABEL_IDCAJA);
			reporte.setsDescripcion(PresupuestoVentasPunVenConstantesFunciones.LABEL_IDCAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasPunVenConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(PresupuestoVentasPunVenConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasPunVenConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(PresupuestoVentasPunVenConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasPunVenConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(PresupuestoVentasPunVenConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasPunVenConstantesFunciones.LABEL_CANTIDADTOTAL);
			reporte.setsDescripcion(PresupuestoVentasPunVenConstantesFunciones.LABEL_CANTIDADTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoVentasPunVenConstantesFunciones.LABEL_VALORTOTAL);
			reporte.setsDescripcion(PresupuestoVentasPunVenConstantesFunciones.LABEL_VALORTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPresupuestoVentasPunVen(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(PresupuestoVentasPunVen presupuestoventaspunvenAux) throws Exception {
		
			presupuestoventaspunvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(presupuestoventaspunvenAux.getEmpresa()));
			presupuestoventaspunvenAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(presupuestoventaspunvenAux.getSucursal()));
			presupuestoventaspunvenAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(presupuestoventaspunvenAux.getEjercicio()));
			presupuestoventaspunvenAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(presupuestoventaspunvenAux.getPeriodo()));
			presupuestoventaspunvenAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(presupuestoventaspunvenAux.getCaja()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(List<PresupuestoVentasPunVen> presupuestoventaspunvensTemp) throws Exception {
		for(PresupuestoVentasPunVen presupuestoventaspunvenAux:presupuestoventaspunvensTemp) {
			
			presupuestoventaspunvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(presupuestoventaspunvenAux.getEmpresa()));
			presupuestoventaspunvenAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(presupuestoventaspunvenAux.getSucursal()));
			presupuestoventaspunvenAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(presupuestoventaspunvenAux.getEjercicio()));
			presupuestoventaspunvenAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(presupuestoventaspunvenAux.getPeriodo()));
			presupuestoventaspunvenAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(presupuestoventaspunvenAux.getCaja()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPresupuestoVentasPunVen(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Caja.class));
				
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
					if(clas.clas.equals(Caja.class)) {
						classes.add(new Classe(Caja.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPresupuestoVentasPunVen(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Caja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Caja.class)); continue;
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

					if(Caja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Caja.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresupuestoVentasPunVen(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresupuestoVentasPunVenConstantesFunciones.getClassesRelationshipsOfPresupuestoVentasPunVen(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresupuestoVentasPunVen(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresupuestoVentasPunVen(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresupuestoVentasPunVenConstantesFunciones.getClassesRelationshipsFromStringsOfPresupuestoVentasPunVen(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresupuestoVentasPunVen(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PresupuestoVentasPunVen presupuestoventaspunven,List<PresupuestoVentasPunVen> presupuestoventaspunvens,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PresupuestoVentasPunVen presupuestoventaspunvenEncontrado=null;
			
			for(PresupuestoVentasPunVen presupuestoventaspunvenLocal:presupuestoventaspunvens) {
				if(presupuestoventaspunvenLocal.getId().equals(presupuestoventaspunven.getId())) {
					presupuestoventaspunvenEncontrado=presupuestoventaspunvenLocal;
					
					presupuestoventaspunvenLocal.setIsChanged(presupuestoventaspunven.getIsChanged());
					presupuestoventaspunvenLocal.setIsNew(presupuestoventaspunven.getIsNew());
					presupuestoventaspunvenLocal.setIsDeleted(presupuestoventaspunven.getIsDeleted());
					
					presupuestoventaspunvenLocal.setGeneralEntityOriginal(presupuestoventaspunven.getGeneralEntityOriginal());
					
					presupuestoventaspunvenLocal.setId(presupuestoventaspunven.getId());	
					presupuestoventaspunvenLocal.setVersionRow(presupuestoventaspunven.getVersionRow());	
					presupuestoventaspunvenLocal.setid_empresa(presupuestoventaspunven.getid_empresa());	
					presupuestoventaspunvenLocal.setid_sucursal(presupuestoventaspunven.getid_sucursal());	
					presupuestoventaspunvenLocal.setid_ejercicio(presupuestoventaspunven.getid_ejercicio());	
					presupuestoventaspunvenLocal.setid_periodo(presupuestoventaspunven.getid_periodo());	
					presupuestoventaspunvenLocal.setid_caja(presupuestoventaspunven.getid_caja());	
					presupuestoventaspunvenLocal.setvalor(presupuestoventaspunven.getvalor());	
					presupuestoventaspunvenLocal.setcantidad(presupuestoventaspunven.getcantidad());	
					presupuestoventaspunvenLocal.setporcentaje(presupuestoventaspunven.getporcentaje());	
					presupuestoventaspunvenLocal.setcantidad_total(presupuestoventaspunven.getcantidad_total());	
					presupuestoventaspunvenLocal.setvalor_total(presupuestoventaspunven.getvalor_total());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!presupuestoventaspunven.getIsDeleted()) {
				if(!existe) {
					presupuestoventaspunvens.add(presupuestoventaspunven);
				}
			} else {
				if(presupuestoventaspunvenEncontrado!=null && permiteQuitar)  {
					presupuestoventaspunvens.remove(presupuestoventaspunvenEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PresupuestoVentasPunVen presupuestoventaspunven,List<PresupuestoVentasPunVen> presupuestoventaspunvens) throws Exception {
		try	{			
			for(PresupuestoVentasPunVen presupuestoventaspunvenLocal:presupuestoventaspunvens) {
				if(presupuestoventaspunvenLocal.getId().equals(presupuestoventaspunven.getId())) {
					presupuestoventaspunvenLocal.setIsSelected(presupuestoventaspunven.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPresupuestoVentasPunVen(List<PresupuestoVentasPunVen> presupuestoventaspunvensAux) throws Exception {
		//this.presupuestoventaspunvensAux=presupuestoventaspunvensAux;
		
		for(PresupuestoVentasPunVen presupuestoventaspunvenAux:presupuestoventaspunvensAux) {
			if(presupuestoventaspunvenAux.getIsChanged()) {
				presupuestoventaspunvenAux.setIsChanged(false);
			}		
			
			if(presupuestoventaspunvenAux.getIsNew()) {
				presupuestoventaspunvenAux.setIsNew(false);
			}	
			
			if(presupuestoventaspunvenAux.getIsDeleted()) {
				presupuestoventaspunvenAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPresupuestoVentasPunVen(PresupuestoVentasPunVen presupuestoventaspunvenAux) throws Exception {
		//this.presupuestoventaspunvenAux=presupuestoventaspunvenAux;
		
			if(presupuestoventaspunvenAux.getIsChanged()) {
				presupuestoventaspunvenAux.setIsChanged(false);
			}		
			
			if(presupuestoventaspunvenAux.getIsNew()) {
				presupuestoventaspunvenAux.setIsNew(false);
			}	
			
			if(presupuestoventaspunvenAux.getIsDeleted()) {
				presupuestoventaspunvenAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PresupuestoVentasPunVen presupuestoventaspunvenAsignar,PresupuestoVentasPunVen presupuestoventaspunven) throws Exception {
		presupuestoventaspunvenAsignar.setId(presupuestoventaspunven.getId());	
		presupuestoventaspunvenAsignar.setVersionRow(presupuestoventaspunven.getVersionRow());	
		presupuestoventaspunvenAsignar.setid_empresa(presupuestoventaspunven.getid_empresa());
		presupuestoventaspunvenAsignar.setempresa_descripcion(presupuestoventaspunven.getempresa_descripcion());	
		presupuestoventaspunvenAsignar.setid_sucursal(presupuestoventaspunven.getid_sucursal());
		presupuestoventaspunvenAsignar.setsucursal_descripcion(presupuestoventaspunven.getsucursal_descripcion());	
		presupuestoventaspunvenAsignar.setid_ejercicio(presupuestoventaspunven.getid_ejercicio());
		presupuestoventaspunvenAsignar.setejercicio_descripcion(presupuestoventaspunven.getejercicio_descripcion());	
		presupuestoventaspunvenAsignar.setid_periodo(presupuestoventaspunven.getid_periodo());
		presupuestoventaspunvenAsignar.setperiodo_descripcion(presupuestoventaspunven.getperiodo_descripcion());	
		presupuestoventaspunvenAsignar.setid_caja(presupuestoventaspunven.getid_caja());
		presupuestoventaspunvenAsignar.setcaja_descripcion(presupuestoventaspunven.getcaja_descripcion());	
		presupuestoventaspunvenAsignar.setvalor(presupuestoventaspunven.getvalor());	
		presupuestoventaspunvenAsignar.setcantidad(presupuestoventaspunven.getcantidad());	
		presupuestoventaspunvenAsignar.setporcentaje(presupuestoventaspunven.getporcentaje());	
		presupuestoventaspunvenAsignar.setcantidad_total(presupuestoventaspunven.getcantidad_total());	
		presupuestoventaspunvenAsignar.setvalor_total(presupuestoventaspunven.getvalor_total());	
	}
	
	public static void inicializarPresupuestoVentasPunVen(PresupuestoVentasPunVen presupuestoventaspunven) throws Exception {
		try {
				presupuestoventaspunven.setId(0L);	
					
				presupuestoventaspunven.setid_empresa(-1L);	
				presupuestoventaspunven.setid_sucursal(-1L);	
				presupuestoventaspunven.setid_ejercicio(-1L);	
				presupuestoventaspunven.setid_periodo(-1L);	
				presupuestoventaspunven.setid_caja(-1L);	
				presupuestoventaspunven.setvalor(0.0);	
				presupuestoventaspunven.setcantidad(0);	
				presupuestoventaspunven.setporcentaje(0.0);	
				presupuestoventaspunven.setcantidad_total(0);	
				presupuestoventaspunven.setvalor_total(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPresupuestoVentasPunVen(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasPunVenConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasPunVenConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasPunVenConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasPunVenConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasPunVenConstantesFunciones.LABEL_IDCAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasPunVenConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasPunVenConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasPunVenConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasPunVenConstantesFunciones.LABEL_CANTIDADTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoVentasPunVenConstantesFunciones.LABEL_VALORTOTAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPresupuestoVentasPunVen(String sTipo,Row row,Workbook workbook,PresupuestoVentasPunVen presupuestoventaspunven,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventaspunven.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventaspunven.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventaspunven.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventaspunven.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventaspunven.getcaja_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventaspunven.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventaspunven.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventaspunven.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventaspunven.getcantidad_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestoventaspunven.getvalor_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPresupuestoVentasPunVen=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPresupuestoVentasPunVen() {
		return this.sFinalQueryPresupuestoVentasPunVen;
	}
	
	public void setsFinalQueryPresupuestoVentasPunVen(String sFinalQueryPresupuestoVentasPunVen) {
		this.sFinalQueryPresupuestoVentasPunVen= sFinalQueryPresupuestoVentasPunVen;
	}
	
	public Border resaltarSeleccionarPresupuestoVentasPunVen=null;
	
	public Border setResaltarSeleccionarPresupuestoVentasPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasPunVenBeanSwingJInternalFrame presupuestoventaspunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//presupuestoventaspunvenBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasPunVen.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPresupuestoVentasPunVen= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPresupuestoVentasPunVen() {
		return this.resaltarSeleccionarPresupuestoVentasPunVen;
	}
	
	public void setResaltarSeleccionarPresupuestoVentasPunVen(Border borderResaltarSeleccionarPresupuestoVentasPunVen) {
		this.resaltarSeleccionarPresupuestoVentasPunVen= borderResaltarSeleccionarPresupuestoVentasPunVen;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPresupuestoVentasPunVen=null;
	public Boolean mostraridPresupuestoVentasPunVen=true;
	public Boolean activaridPresupuestoVentasPunVen=true;

	public Border resaltarid_empresaPresupuestoVentasPunVen=null;
	public Boolean mostrarid_empresaPresupuestoVentasPunVen=true;
	public Boolean activarid_empresaPresupuestoVentasPunVen=true;
	public Boolean cargarid_empresaPresupuestoVentasPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPresupuestoVentasPunVen=false;//ConEventDepend=true

	public Border resaltarid_sucursalPresupuestoVentasPunVen=null;
	public Boolean mostrarid_sucursalPresupuestoVentasPunVen=true;
	public Boolean activarid_sucursalPresupuestoVentasPunVen=true;
	public Boolean cargarid_sucursalPresupuestoVentasPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalPresupuestoVentasPunVen=false;//ConEventDepend=true

	public Border resaltarid_ejercicioPresupuestoVentasPunVen=null;
	public Boolean mostrarid_ejercicioPresupuestoVentasPunVen=true;
	public Boolean activarid_ejercicioPresupuestoVentasPunVen=true;
	public Boolean cargarid_ejercicioPresupuestoVentasPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioPresupuestoVentasPunVen=false;//ConEventDepend=true

	public Border resaltarid_periodoPresupuestoVentasPunVen=null;
	public Boolean mostrarid_periodoPresupuestoVentasPunVen=true;
	public Boolean activarid_periodoPresupuestoVentasPunVen=true;
	public Boolean cargarid_periodoPresupuestoVentasPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoPresupuestoVentasPunVen=false;//ConEventDepend=true

	public Border resaltarid_cajaPresupuestoVentasPunVen=null;
	public Boolean mostrarid_cajaPresupuestoVentasPunVen=true;
	public Boolean activarid_cajaPresupuestoVentasPunVen=true;
	public Boolean cargarid_cajaPresupuestoVentasPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cajaPresupuestoVentasPunVen=false;//ConEventDepend=true

	public Border resaltarvalorPresupuestoVentasPunVen=null;
	public Boolean mostrarvalorPresupuestoVentasPunVen=true;
	public Boolean activarvalorPresupuestoVentasPunVen=true;

	public Border resaltarcantidadPresupuestoVentasPunVen=null;
	public Boolean mostrarcantidadPresupuestoVentasPunVen=true;
	public Boolean activarcantidadPresupuestoVentasPunVen=true;

	public Border resaltarporcentajePresupuestoVentasPunVen=null;
	public Boolean mostrarporcentajePresupuestoVentasPunVen=true;
	public Boolean activarporcentajePresupuestoVentasPunVen=true;

	public Border resaltarcantidad_totalPresupuestoVentasPunVen=null;
	public Boolean mostrarcantidad_totalPresupuestoVentasPunVen=true;
	public Boolean activarcantidad_totalPresupuestoVentasPunVen=true;

	public Border resaltarvalor_totalPresupuestoVentasPunVen=null;
	public Boolean mostrarvalor_totalPresupuestoVentasPunVen=true;
	public Boolean activarvalor_totalPresupuestoVentasPunVen=true;

	
	

	public Border setResaltaridPresupuestoVentasPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasPunVenBeanSwingJInternalFrame presupuestoventaspunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaspunvenBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasPunVen.setBorder(borderResaltar);
		
		this.resaltaridPresupuestoVentasPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPresupuestoVentasPunVen() {
		return this.resaltaridPresupuestoVentasPunVen;
	}

	public void setResaltaridPresupuestoVentasPunVen(Border borderResaltar) {
		this.resaltaridPresupuestoVentasPunVen= borderResaltar;
	}

	public Boolean getMostraridPresupuestoVentasPunVen() {
		return this.mostraridPresupuestoVentasPunVen;
	}

	public void setMostraridPresupuestoVentasPunVen(Boolean mostraridPresupuestoVentasPunVen) {
		this.mostraridPresupuestoVentasPunVen= mostraridPresupuestoVentasPunVen;
	}

	public Boolean getActivaridPresupuestoVentasPunVen() {
		return this.activaridPresupuestoVentasPunVen;
	}

	public void setActivaridPresupuestoVentasPunVen(Boolean activaridPresupuestoVentasPunVen) {
		this.activaridPresupuestoVentasPunVen= activaridPresupuestoVentasPunVen;
	}

	public Border setResaltarid_empresaPresupuestoVentasPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasPunVenBeanSwingJInternalFrame presupuestoventaspunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaspunvenBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasPunVen.setBorder(borderResaltar);
		
		this.resaltarid_empresaPresupuestoVentasPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPresupuestoVentasPunVen() {
		return this.resaltarid_empresaPresupuestoVentasPunVen;
	}

	public void setResaltarid_empresaPresupuestoVentasPunVen(Border borderResaltar) {
		this.resaltarid_empresaPresupuestoVentasPunVen= borderResaltar;
	}

	public Boolean getMostrarid_empresaPresupuestoVentasPunVen() {
		return this.mostrarid_empresaPresupuestoVentasPunVen;
	}

	public void setMostrarid_empresaPresupuestoVentasPunVen(Boolean mostrarid_empresaPresupuestoVentasPunVen) {
		this.mostrarid_empresaPresupuestoVentasPunVen= mostrarid_empresaPresupuestoVentasPunVen;
	}

	public Boolean getActivarid_empresaPresupuestoVentasPunVen() {
		return this.activarid_empresaPresupuestoVentasPunVen;
	}

	public void setActivarid_empresaPresupuestoVentasPunVen(Boolean activarid_empresaPresupuestoVentasPunVen) {
		this.activarid_empresaPresupuestoVentasPunVen= activarid_empresaPresupuestoVentasPunVen;
	}

	public Boolean getCargarid_empresaPresupuestoVentasPunVen() {
		return this.cargarid_empresaPresupuestoVentasPunVen;
	}

	public void setCargarid_empresaPresupuestoVentasPunVen(Boolean cargarid_empresaPresupuestoVentasPunVen) {
		this.cargarid_empresaPresupuestoVentasPunVen= cargarid_empresaPresupuestoVentasPunVen;
	}

	public Border setResaltarid_sucursalPresupuestoVentasPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasPunVenBeanSwingJInternalFrame presupuestoventaspunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaspunvenBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasPunVen.setBorder(borderResaltar);
		
		this.resaltarid_sucursalPresupuestoVentasPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalPresupuestoVentasPunVen() {
		return this.resaltarid_sucursalPresupuestoVentasPunVen;
	}

	public void setResaltarid_sucursalPresupuestoVentasPunVen(Border borderResaltar) {
		this.resaltarid_sucursalPresupuestoVentasPunVen= borderResaltar;
	}

	public Boolean getMostrarid_sucursalPresupuestoVentasPunVen() {
		return this.mostrarid_sucursalPresupuestoVentasPunVen;
	}

	public void setMostrarid_sucursalPresupuestoVentasPunVen(Boolean mostrarid_sucursalPresupuestoVentasPunVen) {
		this.mostrarid_sucursalPresupuestoVentasPunVen= mostrarid_sucursalPresupuestoVentasPunVen;
	}

	public Boolean getActivarid_sucursalPresupuestoVentasPunVen() {
		return this.activarid_sucursalPresupuestoVentasPunVen;
	}

	public void setActivarid_sucursalPresupuestoVentasPunVen(Boolean activarid_sucursalPresupuestoVentasPunVen) {
		this.activarid_sucursalPresupuestoVentasPunVen= activarid_sucursalPresupuestoVentasPunVen;
	}

	public Boolean getCargarid_sucursalPresupuestoVentasPunVen() {
		return this.cargarid_sucursalPresupuestoVentasPunVen;
	}

	public void setCargarid_sucursalPresupuestoVentasPunVen(Boolean cargarid_sucursalPresupuestoVentasPunVen) {
		this.cargarid_sucursalPresupuestoVentasPunVen= cargarid_sucursalPresupuestoVentasPunVen;
	}

	public Border setResaltarid_ejercicioPresupuestoVentasPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasPunVenBeanSwingJInternalFrame presupuestoventaspunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaspunvenBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasPunVen.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioPresupuestoVentasPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioPresupuestoVentasPunVen() {
		return this.resaltarid_ejercicioPresupuestoVentasPunVen;
	}

	public void setResaltarid_ejercicioPresupuestoVentasPunVen(Border borderResaltar) {
		this.resaltarid_ejercicioPresupuestoVentasPunVen= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioPresupuestoVentasPunVen() {
		return this.mostrarid_ejercicioPresupuestoVentasPunVen;
	}

	public void setMostrarid_ejercicioPresupuestoVentasPunVen(Boolean mostrarid_ejercicioPresupuestoVentasPunVen) {
		this.mostrarid_ejercicioPresupuestoVentasPunVen= mostrarid_ejercicioPresupuestoVentasPunVen;
	}

	public Boolean getActivarid_ejercicioPresupuestoVentasPunVen() {
		return this.activarid_ejercicioPresupuestoVentasPunVen;
	}

	public void setActivarid_ejercicioPresupuestoVentasPunVen(Boolean activarid_ejercicioPresupuestoVentasPunVen) {
		this.activarid_ejercicioPresupuestoVentasPunVen= activarid_ejercicioPresupuestoVentasPunVen;
	}

	public Boolean getCargarid_ejercicioPresupuestoVentasPunVen() {
		return this.cargarid_ejercicioPresupuestoVentasPunVen;
	}

	public void setCargarid_ejercicioPresupuestoVentasPunVen(Boolean cargarid_ejercicioPresupuestoVentasPunVen) {
		this.cargarid_ejercicioPresupuestoVentasPunVen= cargarid_ejercicioPresupuestoVentasPunVen;
	}

	public Border setResaltarid_periodoPresupuestoVentasPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasPunVenBeanSwingJInternalFrame presupuestoventaspunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaspunvenBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasPunVen.setBorder(borderResaltar);
		
		this.resaltarid_periodoPresupuestoVentasPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoPresupuestoVentasPunVen() {
		return this.resaltarid_periodoPresupuestoVentasPunVen;
	}

	public void setResaltarid_periodoPresupuestoVentasPunVen(Border borderResaltar) {
		this.resaltarid_periodoPresupuestoVentasPunVen= borderResaltar;
	}

	public Boolean getMostrarid_periodoPresupuestoVentasPunVen() {
		return this.mostrarid_periodoPresupuestoVentasPunVen;
	}

	public void setMostrarid_periodoPresupuestoVentasPunVen(Boolean mostrarid_periodoPresupuestoVentasPunVen) {
		this.mostrarid_periodoPresupuestoVentasPunVen= mostrarid_periodoPresupuestoVentasPunVen;
	}

	public Boolean getActivarid_periodoPresupuestoVentasPunVen() {
		return this.activarid_periodoPresupuestoVentasPunVen;
	}

	public void setActivarid_periodoPresupuestoVentasPunVen(Boolean activarid_periodoPresupuestoVentasPunVen) {
		this.activarid_periodoPresupuestoVentasPunVen= activarid_periodoPresupuestoVentasPunVen;
	}

	public Boolean getCargarid_periodoPresupuestoVentasPunVen() {
		return this.cargarid_periodoPresupuestoVentasPunVen;
	}

	public void setCargarid_periodoPresupuestoVentasPunVen(Boolean cargarid_periodoPresupuestoVentasPunVen) {
		this.cargarid_periodoPresupuestoVentasPunVen= cargarid_periodoPresupuestoVentasPunVen;
	}

	public Border setResaltarid_cajaPresupuestoVentasPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasPunVenBeanSwingJInternalFrame presupuestoventaspunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaspunvenBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasPunVen.setBorder(borderResaltar);
		
		this.resaltarid_cajaPresupuestoVentasPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cajaPresupuestoVentasPunVen() {
		return this.resaltarid_cajaPresupuestoVentasPunVen;
	}

	public void setResaltarid_cajaPresupuestoVentasPunVen(Border borderResaltar) {
		this.resaltarid_cajaPresupuestoVentasPunVen= borderResaltar;
	}

	public Boolean getMostrarid_cajaPresupuestoVentasPunVen() {
		return this.mostrarid_cajaPresupuestoVentasPunVen;
	}

	public void setMostrarid_cajaPresupuestoVentasPunVen(Boolean mostrarid_cajaPresupuestoVentasPunVen) {
		this.mostrarid_cajaPresupuestoVentasPunVen= mostrarid_cajaPresupuestoVentasPunVen;
	}

	public Boolean getActivarid_cajaPresupuestoVentasPunVen() {
		return this.activarid_cajaPresupuestoVentasPunVen;
	}

	public void setActivarid_cajaPresupuestoVentasPunVen(Boolean activarid_cajaPresupuestoVentasPunVen) {
		this.activarid_cajaPresupuestoVentasPunVen= activarid_cajaPresupuestoVentasPunVen;
	}

	public Boolean getCargarid_cajaPresupuestoVentasPunVen() {
		return this.cargarid_cajaPresupuestoVentasPunVen;
	}

	public void setCargarid_cajaPresupuestoVentasPunVen(Boolean cargarid_cajaPresupuestoVentasPunVen) {
		this.cargarid_cajaPresupuestoVentasPunVen= cargarid_cajaPresupuestoVentasPunVen;
	}

	public Border setResaltarvalorPresupuestoVentasPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasPunVenBeanSwingJInternalFrame presupuestoventaspunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaspunvenBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasPunVen.setBorder(borderResaltar);
		
		this.resaltarvalorPresupuestoVentasPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorPresupuestoVentasPunVen() {
		return this.resaltarvalorPresupuestoVentasPunVen;
	}

	public void setResaltarvalorPresupuestoVentasPunVen(Border borderResaltar) {
		this.resaltarvalorPresupuestoVentasPunVen= borderResaltar;
	}

	public Boolean getMostrarvalorPresupuestoVentasPunVen() {
		return this.mostrarvalorPresupuestoVentasPunVen;
	}

	public void setMostrarvalorPresupuestoVentasPunVen(Boolean mostrarvalorPresupuestoVentasPunVen) {
		this.mostrarvalorPresupuestoVentasPunVen= mostrarvalorPresupuestoVentasPunVen;
	}

	public Boolean getActivarvalorPresupuestoVentasPunVen() {
		return this.activarvalorPresupuestoVentasPunVen;
	}

	public void setActivarvalorPresupuestoVentasPunVen(Boolean activarvalorPresupuestoVentasPunVen) {
		this.activarvalorPresupuestoVentasPunVen= activarvalorPresupuestoVentasPunVen;
	}

	public Border setResaltarcantidadPresupuestoVentasPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasPunVenBeanSwingJInternalFrame presupuestoventaspunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaspunvenBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasPunVen.setBorder(borderResaltar);
		
		this.resaltarcantidadPresupuestoVentasPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadPresupuestoVentasPunVen() {
		return this.resaltarcantidadPresupuestoVentasPunVen;
	}

	public void setResaltarcantidadPresupuestoVentasPunVen(Border borderResaltar) {
		this.resaltarcantidadPresupuestoVentasPunVen= borderResaltar;
	}

	public Boolean getMostrarcantidadPresupuestoVentasPunVen() {
		return this.mostrarcantidadPresupuestoVentasPunVen;
	}

	public void setMostrarcantidadPresupuestoVentasPunVen(Boolean mostrarcantidadPresupuestoVentasPunVen) {
		this.mostrarcantidadPresupuestoVentasPunVen= mostrarcantidadPresupuestoVentasPunVen;
	}

	public Boolean getActivarcantidadPresupuestoVentasPunVen() {
		return this.activarcantidadPresupuestoVentasPunVen;
	}

	public void setActivarcantidadPresupuestoVentasPunVen(Boolean activarcantidadPresupuestoVentasPunVen) {
		this.activarcantidadPresupuestoVentasPunVen= activarcantidadPresupuestoVentasPunVen;
	}

	public Border setResaltarporcentajePresupuestoVentasPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasPunVenBeanSwingJInternalFrame presupuestoventaspunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaspunvenBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasPunVen.setBorder(borderResaltar);
		
		this.resaltarporcentajePresupuestoVentasPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajePresupuestoVentasPunVen() {
		return this.resaltarporcentajePresupuestoVentasPunVen;
	}

	public void setResaltarporcentajePresupuestoVentasPunVen(Border borderResaltar) {
		this.resaltarporcentajePresupuestoVentasPunVen= borderResaltar;
	}

	public Boolean getMostrarporcentajePresupuestoVentasPunVen() {
		return this.mostrarporcentajePresupuestoVentasPunVen;
	}

	public void setMostrarporcentajePresupuestoVentasPunVen(Boolean mostrarporcentajePresupuestoVentasPunVen) {
		this.mostrarporcentajePresupuestoVentasPunVen= mostrarporcentajePresupuestoVentasPunVen;
	}

	public Boolean getActivarporcentajePresupuestoVentasPunVen() {
		return this.activarporcentajePresupuestoVentasPunVen;
	}

	public void setActivarporcentajePresupuestoVentasPunVen(Boolean activarporcentajePresupuestoVentasPunVen) {
		this.activarporcentajePresupuestoVentasPunVen= activarporcentajePresupuestoVentasPunVen;
	}

	public Border setResaltarcantidad_totalPresupuestoVentasPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasPunVenBeanSwingJInternalFrame presupuestoventaspunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaspunvenBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasPunVen.setBorder(borderResaltar);
		
		this.resaltarcantidad_totalPresupuestoVentasPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_totalPresupuestoVentasPunVen() {
		return this.resaltarcantidad_totalPresupuestoVentasPunVen;
	}

	public void setResaltarcantidad_totalPresupuestoVentasPunVen(Border borderResaltar) {
		this.resaltarcantidad_totalPresupuestoVentasPunVen= borderResaltar;
	}

	public Boolean getMostrarcantidad_totalPresupuestoVentasPunVen() {
		return this.mostrarcantidad_totalPresupuestoVentasPunVen;
	}

	public void setMostrarcantidad_totalPresupuestoVentasPunVen(Boolean mostrarcantidad_totalPresupuestoVentasPunVen) {
		this.mostrarcantidad_totalPresupuestoVentasPunVen= mostrarcantidad_totalPresupuestoVentasPunVen;
	}

	public Boolean getActivarcantidad_totalPresupuestoVentasPunVen() {
		return this.activarcantidad_totalPresupuestoVentasPunVen;
	}

	public void setActivarcantidad_totalPresupuestoVentasPunVen(Boolean activarcantidad_totalPresupuestoVentasPunVen) {
		this.activarcantidad_totalPresupuestoVentasPunVen= activarcantidad_totalPresupuestoVentasPunVen;
	}

	public Border setResaltarvalor_totalPresupuestoVentasPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasPunVenBeanSwingJInternalFrame presupuestoventaspunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestoventaspunvenBeanSwingJInternalFrame.jTtoolBarPresupuestoVentasPunVen.setBorder(borderResaltar);
		
		this.resaltarvalor_totalPresupuestoVentasPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_totalPresupuestoVentasPunVen() {
		return this.resaltarvalor_totalPresupuestoVentasPunVen;
	}

	public void setResaltarvalor_totalPresupuestoVentasPunVen(Border borderResaltar) {
		this.resaltarvalor_totalPresupuestoVentasPunVen= borderResaltar;
	}

	public Boolean getMostrarvalor_totalPresupuestoVentasPunVen() {
		return this.mostrarvalor_totalPresupuestoVentasPunVen;
	}

	public void setMostrarvalor_totalPresupuestoVentasPunVen(Boolean mostrarvalor_totalPresupuestoVentasPunVen) {
		this.mostrarvalor_totalPresupuestoVentasPunVen= mostrarvalor_totalPresupuestoVentasPunVen;
	}

	public Boolean getActivarvalor_totalPresupuestoVentasPunVen() {
		return this.activarvalor_totalPresupuestoVentasPunVen;
	}

	public void setActivarvalor_totalPresupuestoVentasPunVen(Boolean activarvalor_totalPresupuestoVentasPunVen) {
		this.activarvalor_totalPresupuestoVentasPunVen= activarvalor_totalPresupuestoVentasPunVen;
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
		
		
		this.setMostraridPresupuestoVentasPunVen(esInicial);
		this.setMostrarid_empresaPresupuestoVentasPunVen(esInicial);
		this.setMostrarid_sucursalPresupuestoVentasPunVen(esInicial);
		this.setMostrarid_ejercicioPresupuestoVentasPunVen(esInicial);
		this.setMostrarid_periodoPresupuestoVentasPunVen(esInicial);
		this.setMostrarid_cajaPresupuestoVentasPunVen(esInicial);
		this.setMostrarvalorPresupuestoVentasPunVen(esInicial);
		this.setMostrarcantidadPresupuestoVentasPunVen(esInicial);
		this.setMostrarporcentajePresupuestoVentasPunVen(esInicial);
		this.setMostrarcantidad_totalPresupuestoVentasPunVen(esInicial);
		this.setMostrarvalor_totalPresupuestoVentasPunVen(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.ID)) {
				this.setMostraridPresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalPresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioPresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoPresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.IDCAJA)) {
				this.setMostrarid_cajaPresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.VALOR)) {
				this.setMostrarvalorPresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadPresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajePresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.CANTIDADTOTAL)) {
				this.setMostrarcantidad_totalPresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.VALORTOTAL)) {
				this.setMostrarvalor_totalPresupuestoVentasPunVen(esAsigna);
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
		
		
		this.setActivaridPresupuestoVentasPunVen(esInicial);
		this.setActivarid_empresaPresupuestoVentasPunVen(esInicial);
		this.setActivarid_sucursalPresupuestoVentasPunVen(esInicial);
		this.setActivarid_ejercicioPresupuestoVentasPunVen(esInicial);
		this.setActivarid_periodoPresupuestoVentasPunVen(esInicial);
		this.setActivarid_cajaPresupuestoVentasPunVen(esInicial);
		this.setActivarvalorPresupuestoVentasPunVen(esInicial);
		this.setActivarcantidadPresupuestoVentasPunVen(esInicial);
		this.setActivarporcentajePresupuestoVentasPunVen(esInicial);
		this.setActivarcantidad_totalPresupuestoVentasPunVen(esInicial);
		this.setActivarvalor_totalPresupuestoVentasPunVen(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.ID)) {
				this.setActivaridPresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalPresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioPresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoPresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.IDCAJA)) {
				this.setActivarid_cajaPresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.VALOR)) {
				this.setActivarvalorPresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadPresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajePresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.CANTIDADTOTAL)) {
				this.setActivarcantidad_totalPresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.VALORTOTAL)) {
				this.setActivarvalor_totalPresupuestoVentasPunVen(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PresupuestoVentasPunVenBeanSwingJInternalFrame presupuestoventaspunvenBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPresupuestoVentasPunVen(esInicial);
		this.setResaltarid_empresaPresupuestoVentasPunVen(esInicial);
		this.setResaltarid_sucursalPresupuestoVentasPunVen(esInicial);
		this.setResaltarid_ejercicioPresupuestoVentasPunVen(esInicial);
		this.setResaltarid_periodoPresupuestoVentasPunVen(esInicial);
		this.setResaltarid_cajaPresupuestoVentasPunVen(esInicial);
		this.setResaltarvalorPresupuestoVentasPunVen(esInicial);
		this.setResaltarcantidadPresupuestoVentasPunVen(esInicial);
		this.setResaltarporcentajePresupuestoVentasPunVen(esInicial);
		this.setResaltarcantidad_totalPresupuestoVentasPunVen(esInicial);
		this.setResaltarvalor_totalPresupuestoVentasPunVen(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.ID)) {
				this.setResaltaridPresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalPresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioPresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoPresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.IDCAJA)) {
				this.setResaltarid_cajaPresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.VALOR)) {
				this.setResaltarvalorPresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadPresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajePresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.CANTIDADTOTAL)) {
				this.setResaltarcantidad_totalPresupuestoVentasPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoVentasPunVenConstantesFunciones.VALORTOTAL)) {
				this.setResaltarvalor_totalPresupuestoVentasPunVen(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PresupuestoVentasPunVenBeanSwingJInternalFrame presupuestoventaspunvenBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCajaPresupuestoVentasPunVen=true;

	public Boolean getMostrarFK_IdCajaPresupuestoVentasPunVen() {
		return this.mostrarFK_IdCajaPresupuestoVentasPunVen;
	}

	public void setMostrarFK_IdCajaPresupuestoVentasPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCajaPresupuestoVentasPunVen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioPresupuestoVentasPunVen=true;

	public Boolean getMostrarFK_IdEjercicioPresupuestoVentasPunVen() {
		return this.mostrarFK_IdEjercicioPresupuestoVentasPunVen;
	}

	public void setMostrarFK_IdEjercicioPresupuestoVentasPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioPresupuestoVentasPunVen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPresupuestoVentasPunVen=true;

	public Boolean getMostrarFK_IdEmpresaPresupuestoVentasPunVen() {
		return this.mostrarFK_IdEmpresaPresupuestoVentasPunVen;
	}

	public void setMostrarFK_IdEmpresaPresupuestoVentasPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPresupuestoVentasPunVen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoPresupuestoVentasPunVen=true;

	public Boolean getMostrarFK_IdPeriodoPresupuestoVentasPunVen() {
		return this.mostrarFK_IdPeriodoPresupuestoVentasPunVen;
	}

	public void setMostrarFK_IdPeriodoPresupuestoVentasPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoPresupuestoVentasPunVen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalPresupuestoVentasPunVen=true;

	public Boolean getMostrarFK_IdSucursalPresupuestoVentasPunVen() {
		return this.mostrarFK_IdSucursalPresupuestoVentasPunVen;
	}

	public void setMostrarFK_IdSucursalPresupuestoVentasPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalPresupuestoVentasPunVen= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCajaPresupuestoVentasPunVen=true;

	public Boolean getActivarFK_IdCajaPresupuestoVentasPunVen() {
		return this.activarFK_IdCajaPresupuestoVentasPunVen;
	}

	public void setActivarFK_IdCajaPresupuestoVentasPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdCajaPresupuestoVentasPunVen= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioPresupuestoVentasPunVen=true;

	public Boolean getActivarFK_IdEjercicioPresupuestoVentasPunVen() {
		return this.activarFK_IdEjercicioPresupuestoVentasPunVen;
	}

	public void setActivarFK_IdEjercicioPresupuestoVentasPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioPresupuestoVentasPunVen= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPresupuestoVentasPunVen=true;

	public Boolean getActivarFK_IdEmpresaPresupuestoVentasPunVen() {
		return this.activarFK_IdEmpresaPresupuestoVentasPunVen;
	}

	public void setActivarFK_IdEmpresaPresupuestoVentasPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPresupuestoVentasPunVen= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoPresupuestoVentasPunVen=true;

	public Boolean getActivarFK_IdPeriodoPresupuestoVentasPunVen() {
		return this.activarFK_IdPeriodoPresupuestoVentasPunVen;
	}

	public void setActivarFK_IdPeriodoPresupuestoVentasPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoPresupuestoVentasPunVen= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalPresupuestoVentasPunVen=true;

	public Boolean getActivarFK_IdSucursalPresupuestoVentasPunVen() {
		return this.activarFK_IdSucursalPresupuestoVentasPunVen;
	}

	public void setActivarFK_IdSucursalPresupuestoVentasPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalPresupuestoVentasPunVen= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCajaPresupuestoVentasPunVen=null;

	public Border getResaltarFK_IdCajaPresupuestoVentasPunVen() {
		return this.resaltarFK_IdCajaPresupuestoVentasPunVen;
	}

	public void setResaltarFK_IdCajaPresupuestoVentasPunVen(Border borderResaltar) {
		this.resaltarFK_IdCajaPresupuestoVentasPunVen= borderResaltar;
	}

	public void setResaltarFK_IdCajaPresupuestoVentasPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasPunVenBeanSwingJInternalFrame presupuestoventaspunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCajaPresupuestoVentasPunVen= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioPresupuestoVentasPunVen=null;

	public Border getResaltarFK_IdEjercicioPresupuestoVentasPunVen() {
		return this.resaltarFK_IdEjercicioPresupuestoVentasPunVen;
	}

	public void setResaltarFK_IdEjercicioPresupuestoVentasPunVen(Border borderResaltar) {
		this.resaltarFK_IdEjercicioPresupuestoVentasPunVen= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioPresupuestoVentasPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasPunVenBeanSwingJInternalFrame presupuestoventaspunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioPresupuestoVentasPunVen= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPresupuestoVentasPunVen=null;

	public Border getResaltarFK_IdEmpresaPresupuestoVentasPunVen() {
		return this.resaltarFK_IdEmpresaPresupuestoVentasPunVen;
	}

	public void setResaltarFK_IdEmpresaPresupuestoVentasPunVen(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPresupuestoVentasPunVen= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPresupuestoVentasPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasPunVenBeanSwingJInternalFrame presupuestoventaspunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPresupuestoVentasPunVen= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoPresupuestoVentasPunVen=null;

	public Border getResaltarFK_IdPeriodoPresupuestoVentasPunVen() {
		return this.resaltarFK_IdPeriodoPresupuestoVentasPunVen;
	}

	public void setResaltarFK_IdPeriodoPresupuestoVentasPunVen(Border borderResaltar) {
		this.resaltarFK_IdPeriodoPresupuestoVentasPunVen= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoPresupuestoVentasPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasPunVenBeanSwingJInternalFrame presupuestoventaspunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoPresupuestoVentasPunVen= borderResaltar;
	}

	public Border resaltarFK_IdSucursalPresupuestoVentasPunVen=null;

	public Border getResaltarFK_IdSucursalPresupuestoVentasPunVen() {
		return this.resaltarFK_IdSucursalPresupuestoVentasPunVen;
	}

	public void setResaltarFK_IdSucursalPresupuestoVentasPunVen(Border borderResaltar) {
		this.resaltarFK_IdSucursalPresupuestoVentasPunVen= borderResaltar;
	}

	public void setResaltarFK_IdSucursalPresupuestoVentasPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoVentasPunVenBeanSwingJInternalFrame presupuestoventaspunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalPresupuestoVentasPunVen= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}