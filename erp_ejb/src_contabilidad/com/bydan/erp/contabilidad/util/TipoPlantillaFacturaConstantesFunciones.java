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


import com.bydan.erp.contabilidad.util.TipoPlantillaFacturaConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoPlantillaFacturaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoPlantillaFacturaParameterGeneral;

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
final public class TipoPlantillaFacturaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoPlantillaFactura";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoPlantillaFactura"+TipoPlantillaFacturaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoPlantillaFacturaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoPlantillaFacturaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoPlantillaFacturaConstantesFunciones.SCHEMA+"_"+TipoPlantillaFacturaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoPlantillaFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoPlantillaFacturaConstantesFunciones.SCHEMA+"_"+TipoPlantillaFacturaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoPlantillaFacturaConstantesFunciones.SCHEMA+"_"+TipoPlantillaFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoPlantillaFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoPlantillaFacturaConstantesFunciones.SCHEMA+"_"+TipoPlantillaFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPlantillaFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoPlantillaFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPlantillaFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPlantillaFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoPlantillaFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoPlantillaFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoPlantillaFacturaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoPlantillaFacturaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoPlantillaFacturaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoPlantillaFacturaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Plantilla Facturas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Plantilla Factura";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Plantilla Factura";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoPlantillaFactura";
	public static final String OBJECTNAME="tipoplantillafactura";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="tipo_plantilla_factura";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoplantillafactura from "+TipoPlantillaFacturaConstantesFunciones.SPERSISTENCENAME+" tipoplantillafactura";
	public static String QUERYSELECTNATIVE="select "+TipoPlantillaFacturaConstantesFunciones.SCHEMA+"."+TipoPlantillaFacturaConstantesFunciones.TABLENAME+".id,"+TipoPlantillaFacturaConstantesFunciones.SCHEMA+"."+TipoPlantillaFacturaConstantesFunciones.TABLENAME+".version_row,"+TipoPlantillaFacturaConstantesFunciones.SCHEMA+"."+TipoPlantillaFacturaConstantesFunciones.TABLENAME+".id_empresa,"+TipoPlantillaFacturaConstantesFunciones.SCHEMA+"."+TipoPlantillaFacturaConstantesFunciones.TABLENAME+".codigo,"+TipoPlantillaFacturaConstantesFunciones.SCHEMA+"."+TipoPlantillaFacturaConstantesFunciones.TABLENAME+".nombre from "+TipoPlantillaFacturaConstantesFunciones.SCHEMA+"."+TipoPlantillaFacturaConstantesFunciones.TABLENAME;//+" as "+TipoPlantillaFacturaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoPlantillaFacturaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoPlantillaFacturaConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoPlantillaFacturaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoPlantillaFacturaConstantesFunciones.CODIGO)) {sLabelColumna=TipoPlantillaFacturaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoPlantillaFacturaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoPlantillaFacturaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoPlantillaFacturaDescripcion(TipoPlantillaFactura tipoplantillafactura) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoplantillafactura !=null/* && tipoplantillafactura.getId()!=0*/) {
			sDescripcion=tipoplantillafactura.getcodigo();//tipoplantillafacturatipoplantillafactura.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoPlantillaFacturaDescripcionDetallado(TipoPlantillaFactura tipoplantillafactura) {
		String sDescripcion="";
			
		sDescripcion+=TipoPlantillaFacturaConstantesFunciones.ID+"=";
		sDescripcion+=tipoplantillafactura.getId().toString()+",";
		sDescripcion+=TipoPlantillaFacturaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoplantillafactura.getVersionRow().toString()+",";
		sDescripcion+=TipoPlantillaFacturaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipoplantillafactura.getid_empresa().toString()+",";
		sDescripcion+=TipoPlantillaFacturaConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoplantillafactura.getcodigo()+",";
		sDescripcion+=TipoPlantillaFacturaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoplantillafactura.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoPlantillaFacturaDescripcion(TipoPlantillaFactura tipoplantillafactura,String sValor) throws Exception {			
		if(tipoplantillafactura !=null) {
			tipoplantillafactura.setcodigo(sValor);;//tipoplantillafacturatipoplantillafactura.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoPlantillaFactura(TipoPlantillaFactura tipoplantillafactura,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoplantillafactura.setcodigo(tipoplantillafactura.getcodigo().trim());
		tipoplantillafactura.setnombre(tipoplantillafactura.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoPlantillaFacturas(List<TipoPlantillaFactura> tipoplantillafacturas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoPlantillaFactura tipoplantillafactura: tipoplantillafacturas) {
			tipoplantillafactura.setcodigo(tipoplantillafactura.getcodigo().trim());
			tipoplantillafactura.setnombre(tipoplantillafactura.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoPlantillaFactura(TipoPlantillaFactura tipoplantillafactura,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoplantillafactura.getConCambioAuxiliar()) {
			tipoplantillafactura.setIsDeleted(tipoplantillafactura.getIsDeletedAuxiliar());	
			tipoplantillafactura.setIsNew(tipoplantillafactura.getIsNewAuxiliar());	
			tipoplantillafactura.setIsChanged(tipoplantillafactura.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoplantillafactura.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoplantillafactura.setIsDeletedAuxiliar(false);	
			tipoplantillafactura.setIsNewAuxiliar(false);	
			tipoplantillafactura.setIsChangedAuxiliar(false);
			
			tipoplantillafactura.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoPlantillaFacturas(List<TipoPlantillaFactura> tipoplantillafacturas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoPlantillaFactura tipoplantillafactura : tipoplantillafacturas) {
			if(conAsignarBase && tipoplantillafactura.getConCambioAuxiliar()) {
				tipoplantillafactura.setIsDeleted(tipoplantillafactura.getIsDeletedAuxiliar());	
				tipoplantillafactura.setIsNew(tipoplantillafactura.getIsNewAuxiliar());	
				tipoplantillafactura.setIsChanged(tipoplantillafactura.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoplantillafactura.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoplantillafactura.setIsDeletedAuxiliar(false);	
				tipoplantillafactura.setIsNewAuxiliar(false);	
				tipoplantillafactura.setIsChangedAuxiliar(false);
				
				tipoplantillafactura.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoPlantillaFactura(TipoPlantillaFactura tipoplantillafactura,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoPlantillaFacturas(List<TipoPlantillaFactura> tipoplantillafacturas,Boolean conEnteros) throws Exception  {
		
		for(TipoPlantillaFactura tipoplantillafactura: tipoplantillafacturas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoPlantillaFactura(List<TipoPlantillaFactura> tipoplantillafacturas,TipoPlantillaFactura tipoplantillafacturaAux) throws Exception  {
		TipoPlantillaFacturaConstantesFunciones.InicializarValoresTipoPlantillaFactura(tipoplantillafacturaAux,true);
		
		for(TipoPlantillaFactura tipoplantillafactura: tipoplantillafacturas) {
			if(tipoplantillafactura.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoPlantillaFactura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoPlantillaFacturaConstantesFunciones.getArrayColumnasGlobalesTipoPlantillaFactura(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoPlantillaFactura(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoPlantillaFacturaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoPlantillaFacturaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoPlantillaFactura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoPlantillaFactura> tipoplantillafacturas,TipoPlantillaFactura tipoplantillafactura,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoPlantillaFactura tipoplantillafacturaAux: tipoplantillafacturas) {
			if(tipoplantillafacturaAux!=null && tipoplantillafactura!=null) {
				if((tipoplantillafacturaAux.getId()==null && tipoplantillafactura.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoplantillafacturaAux.getId()!=null && tipoplantillafactura.getId()!=null){
					if(tipoplantillafacturaAux.getId().equals(tipoplantillafactura.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoPlantillaFactura(List<TipoPlantillaFactura> tipoplantillafacturas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoPlantillaFactura tipoplantillafactura: tipoplantillafacturas) {			
			if(tipoplantillafactura.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoPlantillaFactura() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoPlantillaFacturaConstantesFunciones.LABEL_ID, TipoPlantillaFacturaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPlantillaFacturaConstantesFunciones.LABEL_VERSIONROW, TipoPlantillaFacturaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPlantillaFacturaConstantesFunciones.LABEL_IDEMPRESA, TipoPlantillaFacturaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPlantillaFacturaConstantesFunciones.LABEL_CODIGO, TipoPlantillaFacturaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoPlantillaFacturaConstantesFunciones.LABEL_NOMBRE, TipoPlantillaFacturaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoPlantillaFactura() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoPlantillaFacturaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPlantillaFacturaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPlantillaFacturaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPlantillaFacturaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoPlantillaFacturaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPlantillaFactura() throws Exception  {
		return TipoPlantillaFacturaConstantesFunciones.getTiposSeleccionarTipoPlantillaFactura(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPlantillaFactura(Boolean conFk) throws Exception  {
		return TipoPlantillaFacturaConstantesFunciones.getTiposSeleccionarTipoPlantillaFactura(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoPlantillaFactura(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPlantillaFacturaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoPlantillaFacturaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPlantillaFacturaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoPlantillaFacturaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoPlantillaFacturaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoPlantillaFacturaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoPlantillaFactura(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoPlantillaFactura(TipoPlantillaFactura tipoplantillafacturaAux) throws Exception {
		
			tipoplantillafacturaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoplantillafacturaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoPlantillaFactura(List<TipoPlantillaFactura> tipoplantillafacturasTemp) throws Exception {
		for(TipoPlantillaFactura tipoplantillafacturaAux:tipoplantillafacturasTemp) {
			
			tipoplantillafacturaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoplantillafacturaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoPlantillaFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoPlantillaFactura(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPlantillaFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoPlantillaFacturaConstantesFunciones.getClassesRelationshipsOfTipoPlantillaFactura(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPlantillaFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoPlantillaFactura(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoPlantillaFacturaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoPlantillaFactura(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoPlantillaFactura(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoPlantillaFactura tipoplantillafactura,List<TipoPlantillaFactura> tipoplantillafacturas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoPlantillaFactura tipoplantillafacturaEncontrado=null;
			
			for(TipoPlantillaFactura tipoplantillafacturaLocal:tipoplantillafacturas) {
				if(tipoplantillafacturaLocal.getId().equals(tipoplantillafactura.getId())) {
					tipoplantillafacturaEncontrado=tipoplantillafacturaLocal;
					
					tipoplantillafacturaLocal.setIsChanged(tipoplantillafactura.getIsChanged());
					tipoplantillafacturaLocal.setIsNew(tipoplantillafactura.getIsNew());
					tipoplantillafacturaLocal.setIsDeleted(tipoplantillafactura.getIsDeleted());
					
					tipoplantillafacturaLocal.setGeneralEntityOriginal(tipoplantillafactura.getGeneralEntityOriginal());
					
					tipoplantillafacturaLocal.setId(tipoplantillafactura.getId());	
					tipoplantillafacturaLocal.setVersionRow(tipoplantillafactura.getVersionRow());	
					tipoplantillafacturaLocal.setid_empresa(tipoplantillafactura.getid_empresa());	
					tipoplantillafacturaLocal.setcodigo(tipoplantillafactura.getcodigo());	
					tipoplantillafacturaLocal.setnombre(tipoplantillafactura.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoplantillafactura.getIsDeleted()) {
				if(!existe) {
					tipoplantillafacturas.add(tipoplantillafactura);
				}
			} else {
				if(tipoplantillafacturaEncontrado!=null && permiteQuitar)  {
					tipoplantillafacturas.remove(tipoplantillafacturaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoPlantillaFactura tipoplantillafactura,List<TipoPlantillaFactura> tipoplantillafacturas) throws Exception {
		try	{			
			for(TipoPlantillaFactura tipoplantillafacturaLocal:tipoplantillafacturas) {
				if(tipoplantillafacturaLocal.getId().equals(tipoplantillafactura.getId())) {
					tipoplantillafacturaLocal.setIsSelected(tipoplantillafactura.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoPlantillaFactura(List<TipoPlantillaFactura> tipoplantillafacturasAux) throws Exception {
		//this.tipoplantillafacturasAux=tipoplantillafacturasAux;
		
		for(TipoPlantillaFactura tipoplantillafacturaAux:tipoplantillafacturasAux) {
			if(tipoplantillafacturaAux.getIsChanged()) {
				tipoplantillafacturaAux.setIsChanged(false);
			}		
			
			if(tipoplantillafacturaAux.getIsNew()) {
				tipoplantillafacturaAux.setIsNew(false);
			}	
			
			if(tipoplantillafacturaAux.getIsDeleted()) {
				tipoplantillafacturaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoPlantillaFactura(TipoPlantillaFactura tipoplantillafacturaAux) throws Exception {
		//this.tipoplantillafacturaAux=tipoplantillafacturaAux;
		
			if(tipoplantillafacturaAux.getIsChanged()) {
				tipoplantillafacturaAux.setIsChanged(false);
			}		
			
			if(tipoplantillafacturaAux.getIsNew()) {
				tipoplantillafacturaAux.setIsNew(false);
			}	
			
			if(tipoplantillafacturaAux.getIsDeleted()) {
				tipoplantillafacturaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoPlantillaFactura tipoplantillafacturaAsignar,TipoPlantillaFactura tipoplantillafactura) throws Exception {
		tipoplantillafacturaAsignar.setId(tipoplantillafactura.getId());	
		tipoplantillafacturaAsignar.setVersionRow(tipoplantillafactura.getVersionRow());	
		tipoplantillafacturaAsignar.setid_empresa(tipoplantillafactura.getid_empresa());
		tipoplantillafacturaAsignar.setempresa_descripcion(tipoplantillafactura.getempresa_descripcion());	
		tipoplantillafacturaAsignar.setcodigo(tipoplantillafactura.getcodigo());	
		tipoplantillafacturaAsignar.setnombre(tipoplantillafactura.getnombre());	
	}
	
	public static void inicializarTipoPlantillaFactura(TipoPlantillaFactura tipoplantillafactura) throws Exception {
		try {
				tipoplantillafactura.setId(0L);	
					
				tipoplantillafactura.setid_empresa(-1L);	
				tipoplantillafactura.setcodigo("");	
				tipoplantillafactura.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoPlantillaFactura(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPlantillaFacturaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPlantillaFacturaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoPlantillaFacturaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoPlantillaFactura(String sTipo,Row row,Workbook workbook,TipoPlantillaFactura tipoplantillafactura,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoplantillafactura.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoplantillafactura.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoplantillafactura.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoPlantillaFactura=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoPlantillaFactura() {
		return this.sFinalQueryTipoPlantillaFactura;
	}
	
	public void setsFinalQueryTipoPlantillaFactura(String sFinalQueryTipoPlantillaFactura) {
		this.sFinalQueryTipoPlantillaFactura= sFinalQueryTipoPlantillaFactura;
	}
	
	public Border resaltarSeleccionarTipoPlantillaFactura=null;
	
	public Border setResaltarSeleccionarTipoPlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPlantillaFacturaBeanSwingJInternalFrame tipoplantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoplantillafacturaBeanSwingJInternalFrame.jTtoolBarTipoPlantillaFactura.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoPlantillaFactura= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoPlantillaFactura() {
		return this.resaltarSeleccionarTipoPlantillaFactura;
	}
	
	public void setResaltarSeleccionarTipoPlantillaFactura(Border borderResaltarSeleccionarTipoPlantillaFactura) {
		this.resaltarSeleccionarTipoPlantillaFactura= borderResaltarSeleccionarTipoPlantillaFactura;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoPlantillaFactura=null;
	public Boolean mostraridTipoPlantillaFactura=true;
	public Boolean activaridTipoPlantillaFactura=true;

	public Border resaltarid_empresaTipoPlantillaFactura=null;
	public Boolean mostrarid_empresaTipoPlantillaFactura=true;
	public Boolean activarid_empresaTipoPlantillaFactura=true;
	public Boolean cargarid_empresaTipoPlantillaFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoPlantillaFactura=false;//ConEventDepend=true

	public Border resaltarcodigoTipoPlantillaFactura=null;
	public Boolean mostrarcodigoTipoPlantillaFactura=true;
	public Boolean activarcodigoTipoPlantillaFactura=true;

	public Border resaltarnombreTipoPlantillaFactura=null;
	public Boolean mostrarnombreTipoPlantillaFactura=true;
	public Boolean activarnombreTipoPlantillaFactura=true;

	
	

	public Border setResaltaridTipoPlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPlantillaFacturaBeanSwingJInternalFrame tipoplantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoplantillafacturaBeanSwingJInternalFrame.jTtoolBarTipoPlantillaFactura.setBorder(borderResaltar);
		
		this.resaltaridTipoPlantillaFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoPlantillaFactura() {
		return this.resaltaridTipoPlantillaFactura;
	}

	public void setResaltaridTipoPlantillaFactura(Border borderResaltar) {
		this.resaltaridTipoPlantillaFactura= borderResaltar;
	}

	public Boolean getMostraridTipoPlantillaFactura() {
		return this.mostraridTipoPlantillaFactura;
	}

	public void setMostraridTipoPlantillaFactura(Boolean mostraridTipoPlantillaFactura) {
		this.mostraridTipoPlantillaFactura= mostraridTipoPlantillaFactura;
	}

	public Boolean getActivaridTipoPlantillaFactura() {
		return this.activaridTipoPlantillaFactura;
	}

	public void setActivaridTipoPlantillaFactura(Boolean activaridTipoPlantillaFactura) {
		this.activaridTipoPlantillaFactura= activaridTipoPlantillaFactura;
	}

	public Border setResaltarid_empresaTipoPlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPlantillaFacturaBeanSwingJInternalFrame tipoplantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoplantillafacturaBeanSwingJInternalFrame.jTtoolBarTipoPlantillaFactura.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoPlantillaFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoPlantillaFactura() {
		return this.resaltarid_empresaTipoPlantillaFactura;
	}

	public void setResaltarid_empresaTipoPlantillaFactura(Border borderResaltar) {
		this.resaltarid_empresaTipoPlantillaFactura= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoPlantillaFactura() {
		return this.mostrarid_empresaTipoPlantillaFactura;
	}

	public void setMostrarid_empresaTipoPlantillaFactura(Boolean mostrarid_empresaTipoPlantillaFactura) {
		this.mostrarid_empresaTipoPlantillaFactura= mostrarid_empresaTipoPlantillaFactura;
	}

	public Boolean getActivarid_empresaTipoPlantillaFactura() {
		return this.activarid_empresaTipoPlantillaFactura;
	}

	public void setActivarid_empresaTipoPlantillaFactura(Boolean activarid_empresaTipoPlantillaFactura) {
		this.activarid_empresaTipoPlantillaFactura= activarid_empresaTipoPlantillaFactura;
	}

	public Boolean getCargarid_empresaTipoPlantillaFactura() {
		return this.cargarid_empresaTipoPlantillaFactura;
	}

	public void setCargarid_empresaTipoPlantillaFactura(Boolean cargarid_empresaTipoPlantillaFactura) {
		this.cargarid_empresaTipoPlantillaFactura= cargarid_empresaTipoPlantillaFactura;
	}

	public Border setResaltarcodigoTipoPlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPlantillaFacturaBeanSwingJInternalFrame tipoplantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoplantillafacturaBeanSwingJInternalFrame.jTtoolBarTipoPlantillaFactura.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoPlantillaFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoPlantillaFactura() {
		return this.resaltarcodigoTipoPlantillaFactura;
	}

	public void setResaltarcodigoTipoPlantillaFactura(Border borderResaltar) {
		this.resaltarcodigoTipoPlantillaFactura= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoPlantillaFactura() {
		return this.mostrarcodigoTipoPlantillaFactura;
	}

	public void setMostrarcodigoTipoPlantillaFactura(Boolean mostrarcodigoTipoPlantillaFactura) {
		this.mostrarcodigoTipoPlantillaFactura= mostrarcodigoTipoPlantillaFactura;
	}

	public Boolean getActivarcodigoTipoPlantillaFactura() {
		return this.activarcodigoTipoPlantillaFactura;
	}

	public void setActivarcodigoTipoPlantillaFactura(Boolean activarcodigoTipoPlantillaFactura) {
		this.activarcodigoTipoPlantillaFactura= activarcodigoTipoPlantillaFactura;
	}

	public Border setResaltarnombreTipoPlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPlantillaFacturaBeanSwingJInternalFrame tipoplantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoplantillafacturaBeanSwingJInternalFrame.jTtoolBarTipoPlantillaFactura.setBorder(borderResaltar);
		
		this.resaltarnombreTipoPlantillaFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoPlantillaFactura() {
		return this.resaltarnombreTipoPlantillaFactura;
	}

	public void setResaltarnombreTipoPlantillaFactura(Border borderResaltar) {
		this.resaltarnombreTipoPlantillaFactura= borderResaltar;
	}

	public Boolean getMostrarnombreTipoPlantillaFactura() {
		return this.mostrarnombreTipoPlantillaFactura;
	}

	public void setMostrarnombreTipoPlantillaFactura(Boolean mostrarnombreTipoPlantillaFactura) {
		this.mostrarnombreTipoPlantillaFactura= mostrarnombreTipoPlantillaFactura;
	}

	public Boolean getActivarnombreTipoPlantillaFactura() {
		return this.activarnombreTipoPlantillaFactura;
	}

	public void setActivarnombreTipoPlantillaFactura(Boolean activarnombreTipoPlantillaFactura) {
		this.activarnombreTipoPlantillaFactura= activarnombreTipoPlantillaFactura;
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
		
		
		this.setMostraridTipoPlantillaFactura(esInicial);
		this.setMostrarid_empresaTipoPlantillaFactura(esInicial);
		this.setMostrarcodigoTipoPlantillaFactura(esInicial);
		this.setMostrarnombreTipoPlantillaFactura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPlantillaFacturaConstantesFunciones.ID)) {
				this.setMostraridTipoPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPlantillaFacturaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPlantillaFacturaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPlantillaFacturaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoPlantillaFactura(esAsigna);
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
		
		
		this.setActivaridTipoPlantillaFactura(esInicial);
		this.setActivarid_empresaTipoPlantillaFactura(esInicial);
		this.setActivarcodigoTipoPlantillaFactura(esInicial);
		this.setActivarnombreTipoPlantillaFactura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPlantillaFacturaConstantesFunciones.ID)) {
				this.setActivaridTipoPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPlantillaFacturaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPlantillaFacturaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPlantillaFacturaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoPlantillaFactura(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoPlantillaFacturaBeanSwingJInternalFrame tipoplantillafacturaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoPlantillaFactura(esInicial);
		this.setResaltarid_empresaTipoPlantillaFactura(esInicial);
		this.setResaltarcodigoTipoPlantillaFactura(esInicial);
		this.setResaltarnombreTipoPlantillaFactura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoPlantillaFacturaConstantesFunciones.ID)) {
				this.setResaltaridTipoPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPlantillaFacturaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPlantillaFacturaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoPlantillaFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoPlantillaFacturaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoPlantillaFactura(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoPlantillaFacturaBeanSwingJInternalFrame tipoplantillafacturaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaTipoPlantillaFactura=true;

	public Boolean getMostrarFK_IdEmpresaTipoPlantillaFactura() {
		return this.mostrarFK_IdEmpresaTipoPlantillaFactura;
	}

	public void setMostrarFK_IdEmpresaTipoPlantillaFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoPlantillaFactura= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoPlantillaFactura=true;

	public Boolean getActivarFK_IdEmpresaTipoPlantillaFactura() {
		return this.activarFK_IdEmpresaTipoPlantillaFactura;
	}

	public void setActivarFK_IdEmpresaTipoPlantillaFactura(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoPlantillaFactura= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoPlantillaFactura=null;

	public Border getResaltarFK_IdEmpresaTipoPlantillaFactura() {
		return this.resaltarFK_IdEmpresaTipoPlantillaFactura;
	}

	public void setResaltarFK_IdEmpresaTipoPlantillaFactura(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoPlantillaFactura= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoPlantillaFactura(ParametroGeneralUsuario parametroGeneralUsuario/*TipoPlantillaFacturaBeanSwingJInternalFrame tipoplantillafacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoPlantillaFactura= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}