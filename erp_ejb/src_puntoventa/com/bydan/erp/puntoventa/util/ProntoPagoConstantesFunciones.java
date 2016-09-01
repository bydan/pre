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


import com.bydan.erp.puntoventa.util.ProntoPagoConstantesFunciones;
import com.bydan.erp.puntoventa.util.ProntoPagoParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.ProntoPagoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProntoPagoConstantesFunciones extends ProntoPagoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ProntoPago";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProntoPago"+ProntoPagoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProntoPagoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProntoPagoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProntoPagoConstantesFunciones.SCHEMA+"_"+ProntoPagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProntoPagoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProntoPagoConstantesFunciones.SCHEMA+"_"+ProntoPagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProntoPagoConstantesFunciones.SCHEMA+"_"+ProntoPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProntoPagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProntoPagoConstantesFunciones.SCHEMA+"_"+ProntoPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProntoPagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProntoPagoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProntoPagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProntoPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProntoPagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProntoPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProntoPagoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProntoPagoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProntoPagoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProntoPagoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Pronto Pagos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Pronto Pago";
	public static final String SCLASSWEBTITULO_LOWER="Pronto Pago";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProntoPago";
	public static final String OBJECTNAME="prontopago";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="pronto_pago";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select prontopago from "+ProntoPagoConstantesFunciones.SPERSISTENCENAME+" prontopago";
	public static String QUERYSELECTNATIVE="select "+ProntoPagoConstantesFunciones.SCHEMA+"."+ProntoPagoConstantesFunciones.TABLENAME+".id,"+ProntoPagoConstantesFunciones.SCHEMA+"."+ProntoPagoConstantesFunciones.TABLENAME+".version_row,"+ProntoPagoConstantesFunciones.SCHEMA+"."+ProntoPagoConstantesFunciones.TABLENAME+".id_empresa,"+ProntoPagoConstantesFunciones.SCHEMA+"."+ProntoPagoConstantesFunciones.TABLENAME+".dia_inicio,"+ProntoPagoConstantesFunciones.SCHEMA+"."+ProntoPagoConstantesFunciones.TABLENAME+".dia_fin,"+ProntoPagoConstantesFunciones.SCHEMA+"."+ProntoPagoConstantesFunciones.TABLENAME+".porcentaje_descuento from "+ProntoPagoConstantesFunciones.SCHEMA+"."+ProntoPagoConstantesFunciones.TABLENAME;//+" as "+ProntoPagoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ProntoPagoConstantesFuncionesAdditional prontopagoConstantesFuncionesAdditional=null;
	
	public ProntoPagoConstantesFuncionesAdditional getProntoPagoConstantesFuncionesAdditional() {
		return this.prontopagoConstantesFuncionesAdditional;
	}
	
	public void setProntoPagoConstantesFuncionesAdditional(ProntoPagoConstantesFuncionesAdditional prontopagoConstantesFuncionesAdditional) {
		try {
			this.prontopagoConstantesFuncionesAdditional=prontopagoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String DIAINICIO= "dia_inicio";
    public static final String DIAFIN= "dia_fin";
    public static final String PORCENTAJEDESCUENTO= "porcentaje_descuento";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_DIAINICIO= "Dia Inicio";
		public static final String LABEL_DIAINICIO_LOWER= "Dia Inicio";
    	public static final String LABEL_DIAFIN= "Dia Fin";
		public static final String LABEL_DIAFIN_LOWER= "Dia Fin";
    	public static final String LABEL_PORCENTAJEDESCUENTO= "Porcentaje Descuento";
		public static final String LABEL_PORCENTAJEDESCUENTO_LOWER= "Porcentaje Descuento";
	
		
		
		
		
		
		
	
	public static String getProntoPagoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProntoPagoConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProntoPagoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProntoPagoConstantesFunciones.DIAINICIO)) {sLabelColumna=ProntoPagoConstantesFunciones.LABEL_DIAINICIO;}
		if(sNombreColumna.equals(ProntoPagoConstantesFunciones.DIAFIN)) {sLabelColumna=ProntoPagoConstantesFunciones.LABEL_DIAFIN;}
		if(sNombreColumna.equals(ProntoPagoConstantesFunciones.PORCENTAJEDESCUENTO)) {sLabelColumna=ProntoPagoConstantesFunciones.LABEL_PORCENTAJEDESCUENTO;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getProntoPagoDescripcion(ProntoPago prontopago) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(prontopago !=null/* && prontopago.getId()!=0*/) {
			if(prontopago.getId()!=null) {
				sDescripcion=prontopago.getId().toString();
			}//prontopagoprontopago.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProntoPagoDescripcionDetallado(ProntoPago prontopago) {
		String sDescripcion="";
			
		sDescripcion+=ProntoPagoConstantesFunciones.ID+"=";
		sDescripcion+=prontopago.getId().toString()+",";
		sDescripcion+=ProntoPagoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=prontopago.getVersionRow().toString()+",";
		sDescripcion+=ProntoPagoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=prontopago.getid_empresa().toString()+",";
		sDescripcion+=ProntoPagoConstantesFunciones.DIAINICIO+"=";
		sDescripcion+=prontopago.getdia_inicio().toString()+",";
		sDescripcion+=ProntoPagoConstantesFunciones.DIAFIN+"=";
		sDescripcion+=prontopago.getdia_fin().toString()+",";
		sDescripcion+=ProntoPagoConstantesFunciones.PORCENTAJEDESCUENTO+"=";
		sDescripcion+=prontopago.getporcentaje_descuento().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProntoPagoDescripcion(ProntoPago prontopago,String sValor) throws Exception {			
		if(prontopago !=null) {
			//prontopagoprontopago.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProntoPago(ProntoPago prontopago,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProntoPagos(List<ProntoPago> prontopagos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProntoPago prontopago: prontopagos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProntoPago(ProntoPago prontopago,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && prontopago.getConCambioAuxiliar()) {
			prontopago.setIsDeleted(prontopago.getIsDeletedAuxiliar());	
			prontopago.setIsNew(prontopago.getIsNewAuxiliar());	
			prontopago.setIsChanged(prontopago.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			prontopago.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			prontopago.setIsDeletedAuxiliar(false);	
			prontopago.setIsNewAuxiliar(false);	
			prontopago.setIsChangedAuxiliar(false);
			
			prontopago.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProntoPagos(List<ProntoPago> prontopagos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProntoPago prontopago : prontopagos) {
			if(conAsignarBase && prontopago.getConCambioAuxiliar()) {
				prontopago.setIsDeleted(prontopago.getIsDeletedAuxiliar());	
				prontopago.setIsNew(prontopago.getIsNewAuxiliar());	
				prontopago.setIsChanged(prontopago.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				prontopago.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				prontopago.setIsDeletedAuxiliar(false);	
				prontopago.setIsNewAuxiliar(false);	
				prontopago.setIsChangedAuxiliar(false);
				
				prontopago.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProntoPago(ProntoPago prontopago,Boolean conEnteros) throws Exception  {
		prontopago.setporcentaje_descuento(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			prontopago.setdia_inicio(0);
			prontopago.setdia_fin(0);
		}
	}		
	
	public static void InicializarValoresProntoPagos(List<ProntoPago> prontopagos,Boolean conEnteros) throws Exception  {
		
		for(ProntoPago prontopago: prontopagos) {
			prontopago.setporcentaje_descuento(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				prontopago.setdia_inicio(0);
				prontopago.setdia_fin(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaProntoPago(List<ProntoPago> prontopagos,ProntoPago prontopagoAux) throws Exception  {
		ProntoPagoConstantesFunciones.InicializarValoresProntoPago(prontopagoAux,true);
		
		for(ProntoPago prontopago: prontopagos) {
			if(prontopago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			prontopagoAux.setdia_inicio(prontopagoAux.getdia_inicio()+prontopago.getdia_inicio());			
			prontopagoAux.setdia_fin(prontopagoAux.getdia_fin()+prontopago.getdia_fin());			
			prontopagoAux.setporcentaje_descuento(prontopagoAux.getporcentaje_descuento()+prontopago.getporcentaje_descuento());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProntoPago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProntoPagoConstantesFunciones.getArrayColumnasGlobalesProntoPago(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProntoPago(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProntoPagoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProntoPagoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProntoPago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProntoPago> prontopagos,ProntoPago prontopago,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProntoPago prontopagoAux: prontopagos) {
			if(prontopagoAux!=null && prontopago!=null) {
				if((prontopagoAux.getId()==null && prontopago.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(prontopagoAux.getId()!=null && prontopago.getId()!=null){
					if(prontopagoAux.getId().equals(prontopago.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProntoPago(List<ProntoPago> prontopagos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentaje_descuentoTotal=0.0;
	
		for(ProntoPago prontopago: prontopagos) {			
			if(prontopago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentaje_descuentoTotal+=prontopago.getporcentaje_descuento();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProntoPagoConstantesFunciones.PORCENTAJEDESCUENTO);
		datoGeneral.setsDescripcion(ProntoPagoConstantesFunciones.LABEL_PORCENTAJEDESCUENTO);
		datoGeneral.setdValorDouble(porcentaje_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProntoPago() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProntoPagoConstantesFunciones.LABEL_ID, ProntoPagoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProntoPagoConstantesFunciones.LABEL_VERSIONROW, ProntoPagoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProntoPagoConstantesFunciones.LABEL_IDEMPRESA, ProntoPagoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProntoPagoConstantesFunciones.LABEL_DIAINICIO, ProntoPagoConstantesFunciones.DIAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProntoPagoConstantesFunciones.LABEL_DIAFIN, ProntoPagoConstantesFunciones.DIAFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProntoPagoConstantesFunciones.LABEL_PORCENTAJEDESCUENTO, ProntoPagoConstantesFunciones.PORCENTAJEDESCUENTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProntoPago() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProntoPagoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProntoPagoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProntoPagoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProntoPagoConstantesFunciones.DIAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProntoPagoConstantesFunciones.DIAFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProntoPagoConstantesFunciones.PORCENTAJEDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProntoPago() throws Exception  {
		return ProntoPagoConstantesFunciones.getTiposSeleccionarProntoPago(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProntoPago(Boolean conFk) throws Exception  {
		return ProntoPagoConstantesFunciones.getTiposSeleccionarProntoPago(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProntoPago(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProntoPagoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProntoPagoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProntoPagoConstantesFunciones.LABEL_DIAINICIO);
			reporte.setsDescripcion(ProntoPagoConstantesFunciones.LABEL_DIAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProntoPagoConstantesFunciones.LABEL_DIAFIN);
			reporte.setsDescripcion(ProntoPagoConstantesFunciones.LABEL_DIAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProntoPagoConstantesFunciones.LABEL_PORCENTAJEDESCUENTO);
			reporte.setsDescripcion(ProntoPagoConstantesFunciones.LABEL_PORCENTAJEDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProntoPago(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProntoPago(ProntoPago prontopagoAux) throws Exception {
		
			prontopagoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(prontopagoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProntoPago(List<ProntoPago> prontopagosTemp) throws Exception {
		for(ProntoPago prontopagoAux:prontopagosTemp) {
			
			prontopagoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(prontopagoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProntoPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProntoPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProntoPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProntoPagoConstantesFunciones.getClassesRelationshipsOfProntoPago(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProntoPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProntoPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProntoPagoConstantesFunciones.getClassesRelationshipsFromStringsOfProntoPago(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProntoPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProntoPago prontopago,List<ProntoPago> prontopagos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ProntoPago prontopagoEncontrado=null;
			
			for(ProntoPago prontopagoLocal:prontopagos) {
				if(prontopagoLocal.getId().equals(prontopago.getId())) {
					prontopagoEncontrado=prontopagoLocal;
					
					prontopagoLocal.setIsChanged(prontopago.getIsChanged());
					prontopagoLocal.setIsNew(prontopago.getIsNew());
					prontopagoLocal.setIsDeleted(prontopago.getIsDeleted());
					
					prontopagoLocal.setGeneralEntityOriginal(prontopago.getGeneralEntityOriginal());
					
					prontopagoLocal.setId(prontopago.getId());	
					prontopagoLocal.setVersionRow(prontopago.getVersionRow());	
					prontopagoLocal.setid_empresa(prontopago.getid_empresa());	
					prontopagoLocal.setdia_inicio(prontopago.getdia_inicio());	
					prontopagoLocal.setdia_fin(prontopago.getdia_fin());	
					prontopagoLocal.setporcentaje_descuento(prontopago.getporcentaje_descuento());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!prontopago.getIsDeleted()) {
				if(!existe) {
					prontopagos.add(prontopago);
				}
			} else {
				if(prontopagoEncontrado!=null && permiteQuitar)  {
					prontopagos.remove(prontopagoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ProntoPago prontopago,List<ProntoPago> prontopagos) throws Exception {
		try	{			
			for(ProntoPago prontopagoLocal:prontopagos) {
				if(prontopagoLocal.getId().equals(prontopago.getId())) {
					prontopagoLocal.setIsSelected(prontopago.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProntoPago(List<ProntoPago> prontopagosAux) throws Exception {
		//this.prontopagosAux=prontopagosAux;
		
		for(ProntoPago prontopagoAux:prontopagosAux) {
			if(prontopagoAux.getIsChanged()) {
				prontopagoAux.setIsChanged(false);
			}		
			
			if(prontopagoAux.getIsNew()) {
				prontopagoAux.setIsNew(false);
			}	
			
			if(prontopagoAux.getIsDeleted()) {
				prontopagoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProntoPago(ProntoPago prontopagoAux) throws Exception {
		//this.prontopagoAux=prontopagoAux;
		
			if(prontopagoAux.getIsChanged()) {
				prontopagoAux.setIsChanged(false);
			}		
			
			if(prontopagoAux.getIsNew()) {
				prontopagoAux.setIsNew(false);
			}	
			
			if(prontopagoAux.getIsDeleted()) {
				prontopagoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProntoPago prontopagoAsignar,ProntoPago prontopago) throws Exception {
		prontopagoAsignar.setId(prontopago.getId());	
		prontopagoAsignar.setVersionRow(prontopago.getVersionRow());	
		prontopagoAsignar.setid_empresa(prontopago.getid_empresa());
		prontopagoAsignar.setempresa_descripcion(prontopago.getempresa_descripcion());	
		prontopagoAsignar.setdia_inicio(prontopago.getdia_inicio());	
		prontopagoAsignar.setdia_fin(prontopago.getdia_fin());	
		prontopagoAsignar.setporcentaje_descuento(prontopago.getporcentaje_descuento());	
	}
	
	public static void inicializarProntoPago(ProntoPago prontopago) throws Exception {
		try {
				prontopago.setId(0L);	
					
				prontopago.setid_empresa(-1L);	
				prontopago.setdia_inicio(0);	
				prontopago.setdia_fin(0);	
				prontopago.setporcentaje_descuento(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProntoPago(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProntoPagoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProntoPagoConstantesFunciones.LABEL_DIAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProntoPagoConstantesFunciones.LABEL_DIAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProntoPagoConstantesFunciones.LABEL_PORCENTAJEDESCUENTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProntoPago(String sTipo,Row row,Workbook workbook,ProntoPago prontopago,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(prontopago.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(prontopago.getdia_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(prontopago.getdia_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(prontopago.getporcentaje_descuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProntoPago=Constantes.SFINALQUERY;
	
	public String getsFinalQueryProntoPago() {
		return this.sFinalQueryProntoPago;
	}
	
	public void setsFinalQueryProntoPago(String sFinalQueryProntoPago) {
		this.sFinalQueryProntoPago= sFinalQueryProntoPago;
	}
	
	public Border resaltarSeleccionarProntoPago=null;
	
	public Border setResaltarSeleccionarProntoPago(ParametroGeneralUsuario parametroGeneralUsuario/*ProntoPagoBeanSwingJInternalFrame prontopagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//prontopagoBeanSwingJInternalFrame.jTtoolBarProntoPago.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProntoPago= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProntoPago() {
		return this.resaltarSeleccionarProntoPago;
	}
	
	public void setResaltarSeleccionarProntoPago(Border borderResaltarSeleccionarProntoPago) {
		this.resaltarSeleccionarProntoPago= borderResaltarSeleccionarProntoPago;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProntoPago=null;
	public Boolean mostraridProntoPago=true;
	public Boolean activaridProntoPago=true;

	public Border resaltarid_empresaProntoPago=null;
	public Boolean mostrarid_empresaProntoPago=true;
	public Boolean activarid_empresaProntoPago=true;
	public Boolean cargarid_empresaProntoPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProntoPago=false;//ConEventDepend=true

	public Border resaltardia_inicioProntoPago=null;
	public Boolean mostrardia_inicioProntoPago=true;
	public Boolean activardia_inicioProntoPago=true;

	public Border resaltardia_finProntoPago=null;
	public Boolean mostrardia_finProntoPago=true;
	public Boolean activardia_finProntoPago=true;

	public Border resaltarporcentaje_descuentoProntoPago=null;
	public Boolean mostrarporcentaje_descuentoProntoPago=true;
	public Boolean activarporcentaje_descuentoProntoPago=true;

	
	

	public Border setResaltaridProntoPago(ParametroGeneralUsuario parametroGeneralUsuario/*ProntoPagoBeanSwingJInternalFrame prontopagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//prontopagoBeanSwingJInternalFrame.jTtoolBarProntoPago.setBorder(borderResaltar);
		
		this.resaltaridProntoPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProntoPago() {
		return this.resaltaridProntoPago;
	}

	public void setResaltaridProntoPago(Border borderResaltar) {
		this.resaltaridProntoPago= borderResaltar;
	}

	public Boolean getMostraridProntoPago() {
		return this.mostraridProntoPago;
	}

	public void setMostraridProntoPago(Boolean mostraridProntoPago) {
		this.mostraridProntoPago= mostraridProntoPago;
	}

	public Boolean getActivaridProntoPago() {
		return this.activaridProntoPago;
	}

	public void setActivaridProntoPago(Boolean activaridProntoPago) {
		this.activaridProntoPago= activaridProntoPago;
	}

	public Border setResaltarid_empresaProntoPago(ParametroGeneralUsuario parametroGeneralUsuario/*ProntoPagoBeanSwingJInternalFrame prontopagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//prontopagoBeanSwingJInternalFrame.jTtoolBarProntoPago.setBorder(borderResaltar);
		
		this.resaltarid_empresaProntoPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProntoPago() {
		return this.resaltarid_empresaProntoPago;
	}

	public void setResaltarid_empresaProntoPago(Border borderResaltar) {
		this.resaltarid_empresaProntoPago= borderResaltar;
	}

	public Boolean getMostrarid_empresaProntoPago() {
		return this.mostrarid_empresaProntoPago;
	}

	public void setMostrarid_empresaProntoPago(Boolean mostrarid_empresaProntoPago) {
		this.mostrarid_empresaProntoPago= mostrarid_empresaProntoPago;
	}

	public Boolean getActivarid_empresaProntoPago() {
		return this.activarid_empresaProntoPago;
	}

	public void setActivarid_empresaProntoPago(Boolean activarid_empresaProntoPago) {
		this.activarid_empresaProntoPago= activarid_empresaProntoPago;
	}

	public Boolean getCargarid_empresaProntoPago() {
		return this.cargarid_empresaProntoPago;
	}

	public void setCargarid_empresaProntoPago(Boolean cargarid_empresaProntoPago) {
		this.cargarid_empresaProntoPago= cargarid_empresaProntoPago;
	}

	public Border setResaltardia_inicioProntoPago(ParametroGeneralUsuario parametroGeneralUsuario/*ProntoPagoBeanSwingJInternalFrame prontopagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//prontopagoBeanSwingJInternalFrame.jTtoolBarProntoPago.setBorder(borderResaltar);
		
		this.resaltardia_inicioProntoPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardia_inicioProntoPago() {
		return this.resaltardia_inicioProntoPago;
	}

	public void setResaltardia_inicioProntoPago(Border borderResaltar) {
		this.resaltardia_inicioProntoPago= borderResaltar;
	}

	public Boolean getMostrardia_inicioProntoPago() {
		return this.mostrardia_inicioProntoPago;
	}

	public void setMostrardia_inicioProntoPago(Boolean mostrardia_inicioProntoPago) {
		this.mostrardia_inicioProntoPago= mostrardia_inicioProntoPago;
	}

	public Boolean getActivardia_inicioProntoPago() {
		return this.activardia_inicioProntoPago;
	}

	public void setActivardia_inicioProntoPago(Boolean activardia_inicioProntoPago) {
		this.activardia_inicioProntoPago= activardia_inicioProntoPago;
	}

	public Border setResaltardia_finProntoPago(ParametroGeneralUsuario parametroGeneralUsuario/*ProntoPagoBeanSwingJInternalFrame prontopagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//prontopagoBeanSwingJInternalFrame.jTtoolBarProntoPago.setBorder(borderResaltar);
		
		this.resaltardia_finProntoPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardia_finProntoPago() {
		return this.resaltardia_finProntoPago;
	}

	public void setResaltardia_finProntoPago(Border borderResaltar) {
		this.resaltardia_finProntoPago= borderResaltar;
	}

	public Boolean getMostrardia_finProntoPago() {
		return this.mostrardia_finProntoPago;
	}

	public void setMostrardia_finProntoPago(Boolean mostrardia_finProntoPago) {
		this.mostrardia_finProntoPago= mostrardia_finProntoPago;
	}

	public Boolean getActivardia_finProntoPago() {
		return this.activardia_finProntoPago;
	}

	public void setActivardia_finProntoPago(Boolean activardia_finProntoPago) {
		this.activardia_finProntoPago= activardia_finProntoPago;
	}

	public Border setResaltarporcentaje_descuentoProntoPago(ParametroGeneralUsuario parametroGeneralUsuario/*ProntoPagoBeanSwingJInternalFrame prontopagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//prontopagoBeanSwingJInternalFrame.jTtoolBarProntoPago.setBorder(borderResaltar);
		
		this.resaltarporcentaje_descuentoProntoPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_descuentoProntoPago() {
		return this.resaltarporcentaje_descuentoProntoPago;
	}

	public void setResaltarporcentaje_descuentoProntoPago(Border borderResaltar) {
		this.resaltarporcentaje_descuentoProntoPago= borderResaltar;
	}

	public Boolean getMostrarporcentaje_descuentoProntoPago() {
		return this.mostrarporcentaje_descuentoProntoPago;
	}

	public void setMostrarporcentaje_descuentoProntoPago(Boolean mostrarporcentaje_descuentoProntoPago) {
		this.mostrarporcentaje_descuentoProntoPago= mostrarporcentaje_descuentoProntoPago;
	}

	public Boolean getActivarporcentaje_descuentoProntoPago() {
		return this.activarporcentaje_descuentoProntoPago;
	}

	public void setActivarporcentaje_descuentoProntoPago(Boolean activarporcentaje_descuentoProntoPago) {
		this.activarporcentaje_descuentoProntoPago= activarporcentaje_descuentoProntoPago;
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
		
		
		this.setMostraridProntoPago(esInicial);
		this.setMostrarid_empresaProntoPago(esInicial);
		this.setMostrardia_inicioProntoPago(esInicial);
		this.setMostrardia_finProntoPago(esInicial);
		this.setMostrarporcentaje_descuentoProntoPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProntoPagoConstantesFunciones.ID)) {
				this.setMostraridProntoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProntoPagoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProntoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProntoPagoConstantesFunciones.DIAINICIO)) {
				this.setMostrardia_inicioProntoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProntoPagoConstantesFunciones.DIAFIN)) {
				this.setMostrardia_finProntoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProntoPagoConstantesFunciones.PORCENTAJEDESCUENTO)) {
				this.setMostrarporcentaje_descuentoProntoPago(esAsigna);
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
		
		
		this.setActivaridProntoPago(esInicial);
		this.setActivarid_empresaProntoPago(esInicial);
		this.setActivardia_inicioProntoPago(esInicial);
		this.setActivardia_finProntoPago(esInicial);
		this.setActivarporcentaje_descuentoProntoPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProntoPagoConstantesFunciones.ID)) {
				this.setActivaridProntoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProntoPagoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProntoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProntoPagoConstantesFunciones.DIAINICIO)) {
				this.setActivardia_inicioProntoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProntoPagoConstantesFunciones.DIAFIN)) {
				this.setActivardia_finProntoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProntoPagoConstantesFunciones.PORCENTAJEDESCUENTO)) {
				this.setActivarporcentaje_descuentoProntoPago(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProntoPagoBeanSwingJInternalFrame prontopagoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProntoPago(esInicial);
		this.setResaltarid_empresaProntoPago(esInicial);
		this.setResaltardia_inicioProntoPago(esInicial);
		this.setResaltardia_finProntoPago(esInicial);
		this.setResaltarporcentaje_descuentoProntoPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProntoPagoConstantesFunciones.ID)) {
				this.setResaltaridProntoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProntoPagoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProntoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProntoPagoConstantesFunciones.DIAINICIO)) {
				this.setResaltardia_inicioProntoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProntoPagoConstantesFunciones.DIAFIN)) {
				this.setResaltardia_finProntoPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProntoPagoConstantesFunciones.PORCENTAJEDESCUENTO)) {
				this.setResaltarporcentaje_descuentoProntoPago(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProntoPagoBeanSwingJInternalFrame prontopagoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaProntoPago=true;

	public Boolean getMostrarFK_IdEmpresaProntoPago() {
		return this.mostrarFK_IdEmpresaProntoPago;
	}

	public void setMostrarFK_IdEmpresaProntoPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaProntoPago= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaProntoPago=true;

	public Boolean getActivarFK_IdEmpresaProntoPago() {
		return this.activarFK_IdEmpresaProntoPago;
	}

	public void setActivarFK_IdEmpresaProntoPago(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaProntoPago= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaProntoPago=null;

	public Border getResaltarFK_IdEmpresaProntoPago() {
		return this.resaltarFK_IdEmpresaProntoPago;
	}

	public void setResaltarFK_IdEmpresaProntoPago(Border borderResaltar) {
		this.resaltarFK_IdEmpresaProntoPago= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaProntoPago(ParametroGeneralUsuario parametroGeneralUsuario/*ProntoPagoBeanSwingJInternalFrame prontopagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaProntoPago= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}