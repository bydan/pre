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
package com.bydan.erp.produccion.util;

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


import com.bydan.erp.produccion.util.TipoAreaEmpresaProduConstantesFunciones;
import com.bydan.erp.produccion.util.TipoAreaEmpresaProduParameterReturnGeneral;
//import com.bydan.erp.produccion.util.TipoAreaEmpresaProduParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.produccion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.produccion.business.dataaccess.*;
//import com.bydan.erp.produccion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoAreaEmpresaProduConstantesFunciones extends TipoAreaEmpresaProduConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoAreaEmpresaProdu";
	public static final String SPATHOPCION="Produccion";	
	public static final String SPATHMODULO="produccion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoAreaEmpresaProdu"+TipoAreaEmpresaProduConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoAreaEmpresaProduHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoAreaEmpresaProduHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoAreaEmpresaProduConstantesFunciones.SCHEMA+"_"+TipoAreaEmpresaProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoAreaEmpresaProduHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoAreaEmpresaProduConstantesFunciones.SCHEMA+"_"+TipoAreaEmpresaProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoAreaEmpresaProduConstantesFunciones.SCHEMA+"_"+TipoAreaEmpresaProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoAreaEmpresaProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoAreaEmpresaProduConstantesFunciones.SCHEMA+"_"+TipoAreaEmpresaProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoAreaEmpresaProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoAreaEmpresaProduHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoAreaEmpresaProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoAreaEmpresaProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoAreaEmpresaProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoAreaEmpresaProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoAreaEmpresaProduConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoAreaEmpresaProduConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoAreaEmpresaProduConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoAreaEmpresaProduConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Area Empresas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Area Empresa";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Area Empresa Produ";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoAreaEmpresaProdu";
	public static final String OBJECTNAME="tipoareaempresaprodu";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PRODUCCION;	
	public static final String TABLENAME="tipo_area_empresa_produ";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoareaempresaprodu from "+TipoAreaEmpresaProduConstantesFunciones.SPERSISTENCENAME+" tipoareaempresaprodu";
	public static String QUERYSELECTNATIVE="select "+TipoAreaEmpresaProduConstantesFunciones.SCHEMA+"."+TipoAreaEmpresaProduConstantesFunciones.TABLENAME+".id,"+TipoAreaEmpresaProduConstantesFunciones.SCHEMA+"."+TipoAreaEmpresaProduConstantesFunciones.TABLENAME+".version_row,"+TipoAreaEmpresaProduConstantesFunciones.SCHEMA+"."+TipoAreaEmpresaProduConstantesFunciones.TABLENAME+".id_empresa,"+TipoAreaEmpresaProduConstantesFunciones.SCHEMA+"."+TipoAreaEmpresaProduConstantesFunciones.TABLENAME+".nombre,"+TipoAreaEmpresaProduConstantesFunciones.SCHEMA+"."+TipoAreaEmpresaProduConstantesFunciones.TABLENAME+".descripcion from "+TipoAreaEmpresaProduConstantesFunciones.SCHEMA+"."+TipoAreaEmpresaProduConstantesFunciones.TABLENAME;//+" as "+TipoAreaEmpresaProduConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoAreaEmpresaProduConstantesFuncionesAdditional tipoareaempresaproduConstantesFuncionesAdditional=null;
	
	public TipoAreaEmpresaProduConstantesFuncionesAdditional getTipoAreaEmpresaProduConstantesFuncionesAdditional() {
		return this.tipoareaempresaproduConstantesFuncionesAdditional;
	}
	
	public void setTipoAreaEmpresaProduConstantesFuncionesAdditional(TipoAreaEmpresaProduConstantesFuncionesAdditional tipoareaempresaproduConstantesFuncionesAdditional) {
		try {
			this.tipoareaempresaproduConstantesFuncionesAdditional=tipoareaempresaproduConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoAreaEmpresaProduLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoAreaEmpresaProduConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoAreaEmpresaProduConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoAreaEmpresaProduConstantesFunciones.NOMBRE)) {sLabelColumna=TipoAreaEmpresaProduConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoAreaEmpresaProduConstantesFunciones.DESCRIPCION)) {sLabelColumna=TipoAreaEmpresaProduConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoAreaEmpresaProduDescripcion(TipoAreaEmpresaProdu tipoareaempresaprodu) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoareaempresaprodu !=null/* && tipoareaempresaprodu.getId()!=0*/) {
			sDescripcion=tipoareaempresaprodu.getnombre();//tipoareaempresaprodutipoareaempresaprodu.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoAreaEmpresaProduDescripcionDetallado(TipoAreaEmpresaProdu tipoareaempresaprodu) {
		String sDescripcion="";
			
		sDescripcion+=TipoAreaEmpresaProduConstantesFunciones.ID+"=";
		sDescripcion+=tipoareaempresaprodu.getId().toString()+",";
		sDescripcion+=TipoAreaEmpresaProduConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoareaempresaprodu.getVersionRow().toString()+",";
		sDescripcion+=TipoAreaEmpresaProduConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipoareaempresaprodu.getid_empresa().toString()+",";
		sDescripcion+=TipoAreaEmpresaProduConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoareaempresaprodu.getnombre()+",";
		sDescripcion+=TipoAreaEmpresaProduConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=tipoareaempresaprodu.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoAreaEmpresaProduDescripcion(TipoAreaEmpresaProdu tipoareaempresaprodu,String sValor) throws Exception {			
		if(tipoareaempresaprodu !=null) {
			tipoareaempresaprodu.setnombre(sValor);;//tipoareaempresaprodutipoareaempresaprodu.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoAreaEmpresaProdu(TipoAreaEmpresaProdu tipoareaempresaprodu,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoareaempresaprodu.setnombre(tipoareaempresaprodu.getnombre().trim());
		tipoareaempresaprodu.setdescripcion(tipoareaempresaprodu.getdescripcion().trim());
	}
	
	public static void quitarEspaciosTipoAreaEmpresaProdus(List<TipoAreaEmpresaProdu> tipoareaempresaprodus,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoAreaEmpresaProdu tipoareaempresaprodu: tipoareaempresaprodus) {
			tipoareaempresaprodu.setnombre(tipoareaempresaprodu.getnombre().trim());
			tipoareaempresaprodu.setdescripcion(tipoareaempresaprodu.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoAreaEmpresaProdu(TipoAreaEmpresaProdu tipoareaempresaprodu,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoareaempresaprodu.getConCambioAuxiliar()) {
			tipoareaempresaprodu.setIsDeleted(tipoareaempresaprodu.getIsDeletedAuxiliar());	
			tipoareaempresaprodu.setIsNew(tipoareaempresaprodu.getIsNewAuxiliar());	
			tipoareaempresaprodu.setIsChanged(tipoareaempresaprodu.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoareaempresaprodu.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoareaempresaprodu.setIsDeletedAuxiliar(false);	
			tipoareaempresaprodu.setIsNewAuxiliar(false);	
			tipoareaempresaprodu.setIsChangedAuxiliar(false);
			
			tipoareaempresaprodu.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoAreaEmpresaProdus(List<TipoAreaEmpresaProdu> tipoareaempresaprodus,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoAreaEmpresaProdu tipoareaempresaprodu : tipoareaempresaprodus) {
			if(conAsignarBase && tipoareaempresaprodu.getConCambioAuxiliar()) {
				tipoareaempresaprodu.setIsDeleted(tipoareaempresaprodu.getIsDeletedAuxiliar());	
				tipoareaempresaprodu.setIsNew(tipoareaempresaprodu.getIsNewAuxiliar());	
				tipoareaempresaprodu.setIsChanged(tipoareaempresaprodu.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoareaempresaprodu.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoareaempresaprodu.setIsDeletedAuxiliar(false);	
				tipoareaempresaprodu.setIsNewAuxiliar(false);	
				tipoareaempresaprodu.setIsChangedAuxiliar(false);
				
				tipoareaempresaprodu.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoAreaEmpresaProdu(TipoAreaEmpresaProdu tipoareaempresaprodu,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoAreaEmpresaProdus(List<TipoAreaEmpresaProdu> tipoareaempresaprodus,Boolean conEnteros) throws Exception  {
		
		for(TipoAreaEmpresaProdu tipoareaempresaprodu: tipoareaempresaprodus) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoAreaEmpresaProdu(List<TipoAreaEmpresaProdu> tipoareaempresaprodus,TipoAreaEmpresaProdu tipoareaempresaproduAux) throws Exception  {
		TipoAreaEmpresaProduConstantesFunciones.InicializarValoresTipoAreaEmpresaProdu(tipoareaempresaproduAux,true);
		
		for(TipoAreaEmpresaProdu tipoareaempresaprodu: tipoareaempresaprodus) {
			if(tipoareaempresaprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoAreaEmpresaProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoAreaEmpresaProduConstantesFunciones.getArrayColumnasGlobalesTipoAreaEmpresaProdu(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoAreaEmpresaProdu(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoAreaEmpresaProduConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoAreaEmpresaProduConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoAreaEmpresaProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoAreaEmpresaProdu> tipoareaempresaprodus,TipoAreaEmpresaProdu tipoareaempresaprodu,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoAreaEmpresaProdu tipoareaempresaproduAux: tipoareaempresaprodus) {
			if(tipoareaempresaproduAux!=null && tipoareaempresaprodu!=null) {
				if((tipoareaempresaproduAux.getId()==null && tipoareaempresaprodu.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoareaempresaproduAux.getId()!=null && tipoareaempresaprodu.getId()!=null){
					if(tipoareaempresaproduAux.getId().equals(tipoareaempresaprodu.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoAreaEmpresaProdu(List<TipoAreaEmpresaProdu> tipoareaempresaprodus) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoAreaEmpresaProdu tipoareaempresaprodu: tipoareaempresaprodus) {			
			if(tipoareaempresaprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoAreaEmpresaProdu() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoAreaEmpresaProduConstantesFunciones.LABEL_ID, TipoAreaEmpresaProduConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAreaEmpresaProduConstantesFunciones.LABEL_VERSIONROW, TipoAreaEmpresaProduConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAreaEmpresaProduConstantesFunciones.LABEL_IDEMPRESA, TipoAreaEmpresaProduConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAreaEmpresaProduConstantesFunciones.LABEL_NOMBRE, TipoAreaEmpresaProduConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAreaEmpresaProduConstantesFunciones.LABEL_DESCRIPCION, TipoAreaEmpresaProduConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoAreaEmpresaProdu() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoAreaEmpresaProduConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAreaEmpresaProduConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAreaEmpresaProduConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAreaEmpresaProduConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAreaEmpresaProduConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoAreaEmpresaProdu() throws Exception  {
		return TipoAreaEmpresaProduConstantesFunciones.getTiposSeleccionarTipoAreaEmpresaProdu(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoAreaEmpresaProdu(Boolean conFk) throws Exception  {
		return TipoAreaEmpresaProduConstantesFunciones.getTiposSeleccionarTipoAreaEmpresaProdu(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoAreaEmpresaProdu(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoAreaEmpresaProduConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoAreaEmpresaProduConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoAreaEmpresaProduConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoAreaEmpresaProduConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoAreaEmpresaProduConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(TipoAreaEmpresaProduConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoAreaEmpresaProdu(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoAreaEmpresaProdu(TipoAreaEmpresaProdu tipoareaempresaproduAux) throws Exception {
		
			tipoareaempresaproduAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoareaempresaproduAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoAreaEmpresaProdu(List<TipoAreaEmpresaProdu> tipoareaempresaprodusTemp) throws Exception {
		for(TipoAreaEmpresaProdu tipoareaempresaproduAux:tipoareaempresaprodusTemp) {
			
			tipoareaempresaproduAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoareaempresaproduAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoAreaEmpresaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoAreaEmpresaProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoAreaEmpresaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoAreaEmpresaProduConstantesFunciones.getClassesRelationshipsOfTipoAreaEmpresaProdu(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoAreaEmpresaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ProductoOrdenDetaProduMaquina.class));
				classes.add(new Classe(ProductoProduMaquina.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoOrdenDetaProduMaquina.class)) {
						classes.add(new Classe(ProductoOrdenDetaProduMaquina.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoProduMaquina.class)) {
						classes.add(new Classe(ProductoProduMaquina.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoAreaEmpresaProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoAreaEmpresaProduConstantesFunciones.getClassesRelationshipsFromStringsOfTipoAreaEmpresaProdu(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoAreaEmpresaProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ProductoOrdenDetaProduMaquina.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoOrdenDetaProduMaquina.class)); continue;
					}

					if(ProductoProduMaquina.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoProduMaquina.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ProductoOrdenDetaProduMaquina.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoOrdenDetaProduMaquina.class)); continue;
					}

					if(ProductoProduMaquina.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoProduMaquina.class)); continue;
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
	public static void actualizarLista(TipoAreaEmpresaProdu tipoareaempresaprodu,List<TipoAreaEmpresaProdu> tipoareaempresaprodus,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoAreaEmpresaProdu tipoareaempresaproduEncontrado=null;
			
			for(TipoAreaEmpresaProdu tipoareaempresaproduLocal:tipoareaempresaprodus) {
				if(tipoareaempresaproduLocal.getId().equals(tipoareaempresaprodu.getId())) {
					tipoareaempresaproduEncontrado=tipoareaempresaproduLocal;
					
					tipoareaempresaproduLocal.setIsChanged(tipoareaempresaprodu.getIsChanged());
					tipoareaempresaproduLocal.setIsNew(tipoareaempresaprodu.getIsNew());
					tipoareaempresaproduLocal.setIsDeleted(tipoareaempresaprodu.getIsDeleted());
					
					tipoareaempresaproduLocal.setGeneralEntityOriginal(tipoareaempresaprodu.getGeneralEntityOriginal());
					
					tipoareaempresaproduLocal.setId(tipoareaempresaprodu.getId());	
					tipoareaempresaproduLocal.setVersionRow(tipoareaempresaprodu.getVersionRow());	
					tipoareaempresaproduLocal.setid_empresa(tipoareaempresaprodu.getid_empresa());	
					tipoareaempresaproduLocal.setnombre(tipoareaempresaprodu.getnombre());	
					tipoareaempresaproduLocal.setdescripcion(tipoareaempresaprodu.getdescripcion());	
					
					
					tipoareaempresaproduLocal.setProductoOrdenDetaProduMaquinas(tipoareaempresaprodu.getProductoOrdenDetaProduMaquinas());
					tipoareaempresaproduLocal.setProductoProduMaquinas(tipoareaempresaprodu.getProductoProduMaquinas());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoareaempresaprodu.getIsDeleted()) {
				if(!existe) {
					tipoareaempresaprodus.add(tipoareaempresaprodu);
				}
			} else {
				if(tipoareaempresaproduEncontrado!=null && permiteQuitar)  {
					tipoareaempresaprodus.remove(tipoareaempresaproduEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoAreaEmpresaProdu tipoareaempresaprodu,List<TipoAreaEmpresaProdu> tipoareaempresaprodus) throws Exception {
		try	{			
			for(TipoAreaEmpresaProdu tipoareaempresaproduLocal:tipoareaempresaprodus) {
				if(tipoareaempresaproduLocal.getId().equals(tipoareaempresaprodu.getId())) {
					tipoareaempresaproduLocal.setIsSelected(tipoareaempresaprodu.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoAreaEmpresaProdu(List<TipoAreaEmpresaProdu> tipoareaempresaprodusAux) throws Exception {
		//this.tipoareaempresaprodusAux=tipoareaempresaprodusAux;
		
		for(TipoAreaEmpresaProdu tipoareaempresaproduAux:tipoareaempresaprodusAux) {
			if(tipoareaempresaproduAux.getIsChanged()) {
				tipoareaempresaproduAux.setIsChanged(false);
			}		
			
			if(tipoareaempresaproduAux.getIsNew()) {
				tipoareaempresaproduAux.setIsNew(false);
			}	
			
			if(tipoareaempresaproduAux.getIsDeleted()) {
				tipoareaempresaproduAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoAreaEmpresaProdu(TipoAreaEmpresaProdu tipoareaempresaproduAux) throws Exception {
		//this.tipoareaempresaproduAux=tipoareaempresaproduAux;
		
			if(tipoareaempresaproduAux.getIsChanged()) {
				tipoareaempresaproduAux.setIsChanged(false);
			}		
			
			if(tipoareaempresaproduAux.getIsNew()) {
				tipoareaempresaproduAux.setIsNew(false);
			}	
			
			if(tipoareaempresaproduAux.getIsDeleted()) {
				tipoareaempresaproduAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoAreaEmpresaProdu tipoareaempresaproduAsignar,TipoAreaEmpresaProdu tipoareaempresaprodu) throws Exception {
		tipoareaempresaproduAsignar.setId(tipoareaempresaprodu.getId());	
		tipoareaempresaproduAsignar.setVersionRow(tipoareaempresaprodu.getVersionRow());	
		tipoareaempresaproduAsignar.setid_empresa(tipoareaempresaprodu.getid_empresa());
		tipoareaempresaproduAsignar.setempresa_descripcion(tipoareaempresaprodu.getempresa_descripcion());	
		tipoareaempresaproduAsignar.setnombre(tipoareaempresaprodu.getnombre());	
		tipoareaempresaproduAsignar.setdescripcion(tipoareaempresaprodu.getdescripcion());	
	}
	
	public static void inicializarTipoAreaEmpresaProdu(TipoAreaEmpresaProdu tipoareaempresaprodu) throws Exception {
		try {
				tipoareaempresaprodu.setId(0L);	
					
				tipoareaempresaprodu.setid_empresa(-1L);	
				tipoareaempresaprodu.setnombre("");	
				tipoareaempresaprodu.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoAreaEmpresaProdu(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoAreaEmpresaProduConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoAreaEmpresaProduConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoAreaEmpresaProduConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoAreaEmpresaProdu(String sTipo,Row row,Workbook workbook,TipoAreaEmpresaProdu tipoareaempresaprodu,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoareaempresaprodu.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoareaempresaprodu.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoareaempresaprodu.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoAreaEmpresaProdu=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoAreaEmpresaProdu() {
		return this.sFinalQueryTipoAreaEmpresaProdu;
	}
	
	public void setsFinalQueryTipoAreaEmpresaProdu(String sFinalQueryTipoAreaEmpresaProdu) {
		this.sFinalQueryTipoAreaEmpresaProdu= sFinalQueryTipoAreaEmpresaProdu;
	}
	
	public Border resaltarSeleccionarTipoAreaEmpresaProdu=null;
	
	public Border setResaltarSeleccionarTipoAreaEmpresaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAreaEmpresaProduBeanSwingJInternalFrame tipoareaempresaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoareaempresaproduBeanSwingJInternalFrame.jTtoolBarTipoAreaEmpresaProdu.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoAreaEmpresaProdu= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoAreaEmpresaProdu() {
		return this.resaltarSeleccionarTipoAreaEmpresaProdu;
	}
	
	public void setResaltarSeleccionarTipoAreaEmpresaProdu(Border borderResaltarSeleccionarTipoAreaEmpresaProdu) {
		this.resaltarSeleccionarTipoAreaEmpresaProdu= borderResaltarSeleccionarTipoAreaEmpresaProdu;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoAreaEmpresaProdu=null;
	public Boolean mostraridTipoAreaEmpresaProdu=true;
	public Boolean activaridTipoAreaEmpresaProdu=true;

	public Border resaltarid_empresaTipoAreaEmpresaProdu=null;
	public Boolean mostrarid_empresaTipoAreaEmpresaProdu=true;
	public Boolean activarid_empresaTipoAreaEmpresaProdu=true;
	public Boolean cargarid_empresaTipoAreaEmpresaProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoAreaEmpresaProdu=false;//ConEventDepend=true

	public Border resaltarnombreTipoAreaEmpresaProdu=null;
	public Boolean mostrarnombreTipoAreaEmpresaProdu=true;
	public Boolean activarnombreTipoAreaEmpresaProdu=true;

	public Border resaltardescripcionTipoAreaEmpresaProdu=null;
	public Boolean mostrardescripcionTipoAreaEmpresaProdu=true;
	public Boolean activardescripcionTipoAreaEmpresaProdu=true;

	
	

	public Border setResaltaridTipoAreaEmpresaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAreaEmpresaProduBeanSwingJInternalFrame tipoareaempresaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoareaempresaproduBeanSwingJInternalFrame.jTtoolBarTipoAreaEmpresaProdu.setBorder(borderResaltar);
		
		this.resaltaridTipoAreaEmpresaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoAreaEmpresaProdu() {
		return this.resaltaridTipoAreaEmpresaProdu;
	}

	public void setResaltaridTipoAreaEmpresaProdu(Border borderResaltar) {
		this.resaltaridTipoAreaEmpresaProdu= borderResaltar;
	}

	public Boolean getMostraridTipoAreaEmpresaProdu() {
		return this.mostraridTipoAreaEmpresaProdu;
	}

	public void setMostraridTipoAreaEmpresaProdu(Boolean mostraridTipoAreaEmpresaProdu) {
		this.mostraridTipoAreaEmpresaProdu= mostraridTipoAreaEmpresaProdu;
	}

	public Boolean getActivaridTipoAreaEmpresaProdu() {
		return this.activaridTipoAreaEmpresaProdu;
	}

	public void setActivaridTipoAreaEmpresaProdu(Boolean activaridTipoAreaEmpresaProdu) {
		this.activaridTipoAreaEmpresaProdu= activaridTipoAreaEmpresaProdu;
	}

	public Border setResaltarid_empresaTipoAreaEmpresaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAreaEmpresaProduBeanSwingJInternalFrame tipoareaempresaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoareaempresaproduBeanSwingJInternalFrame.jTtoolBarTipoAreaEmpresaProdu.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoAreaEmpresaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoAreaEmpresaProdu() {
		return this.resaltarid_empresaTipoAreaEmpresaProdu;
	}

	public void setResaltarid_empresaTipoAreaEmpresaProdu(Border borderResaltar) {
		this.resaltarid_empresaTipoAreaEmpresaProdu= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoAreaEmpresaProdu() {
		return this.mostrarid_empresaTipoAreaEmpresaProdu;
	}

	public void setMostrarid_empresaTipoAreaEmpresaProdu(Boolean mostrarid_empresaTipoAreaEmpresaProdu) {
		this.mostrarid_empresaTipoAreaEmpresaProdu= mostrarid_empresaTipoAreaEmpresaProdu;
	}

	public Boolean getActivarid_empresaTipoAreaEmpresaProdu() {
		return this.activarid_empresaTipoAreaEmpresaProdu;
	}

	public void setActivarid_empresaTipoAreaEmpresaProdu(Boolean activarid_empresaTipoAreaEmpresaProdu) {
		this.activarid_empresaTipoAreaEmpresaProdu= activarid_empresaTipoAreaEmpresaProdu;
	}

	public Boolean getCargarid_empresaTipoAreaEmpresaProdu() {
		return this.cargarid_empresaTipoAreaEmpresaProdu;
	}

	public void setCargarid_empresaTipoAreaEmpresaProdu(Boolean cargarid_empresaTipoAreaEmpresaProdu) {
		this.cargarid_empresaTipoAreaEmpresaProdu= cargarid_empresaTipoAreaEmpresaProdu;
	}

	public Border setResaltarnombreTipoAreaEmpresaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAreaEmpresaProduBeanSwingJInternalFrame tipoareaempresaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoareaempresaproduBeanSwingJInternalFrame.jTtoolBarTipoAreaEmpresaProdu.setBorder(borderResaltar);
		
		this.resaltarnombreTipoAreaEmpresaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoAreaEmpresaProdu() {
		return this.resaltarnombreTipoAreaEmpresaProdu;
	}

	public void setResaltarnombreTipoAreaEmpresaProdu(Border borderResaltar) {
		this.resaltarnombreTipoAreaEmpresaProdu= borderResaltar;
	}

	public Boolean getMostrarnombreTipoAreaEmpresaProdu() {
		return this.mostrarnombreTipoAreaEmpresaProdu;
	}

	public void setMostrarnombreTipoAreaEmpresaProdu(Boolean mostrarnombreTipoAreaEmpresaProdu) {
		this.mostrarnombreTipoAreaEmpresaProdu= mostrarnombreTipoAreaEmpresaProdu;
	}

	public Boolean getActivarnombreTipoAreaEmpresaProdu() {
		return this.activarnombreTipoAreaEmpresaProdu;
	}

	public void setActivarnombreTipoAreaEmpresaProdu(Boolean activarnombreTipoAreaEmpresaProdu) {
		this.activarnombreTipoAreaEmpresaProdu= activarnombreTipoAreaEmpresaProdu;
	}

	public Border setResaltardescripcionTipoAreaEmpresaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAreaEmpresaProduBeanSwingJInternalFrame tipoareaempresaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoareaempresaproduBeanSwingJInternalFrame.jTtoolBarTipoAreaEmpresaProdu.setBorder(borderResaltar);
		
		this.resaltardescripcionTipoAreaEmpresaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionTipoAreaEmpresaProdu() {
		return this.resaltardescripcionTipoAreaEmpresaProdu;
	}

	public void setResaltardescripcionTipoAreaEmpresaProdu(Border borderResaltar) {
		this.resaltardescripcionTipoAreaEmpresaProdu= borderResaltar;
	}

	public Boolean getMostrardescripcionTipoAreaEmpresaProdu() {
		return this.mostrardescripcionTipoAreaEmpresaProdu;
	}

	public void setMostrardescripcionTipoAreaEmpresaProdu(Boolean mostrardescripcionTipoAreaEmpresaProdu) {
		this.mostrardescripcionTipoAreaEmpresaProdu= mostrardescripcionTipoAreaEmpresaProdu;
	}

	public Boolean getActivardescripcionTipoAreaEmpresaProdu() {
		return this.activardescripcionTipoAreaEmpresaProdu;
	}

	public void setActivardescripcionTipoAreaEmpresaProdu(Boolean activardescripcionTipoAreaEmpresaProdu) {
		this.activardescripcionTipoAreaEmpresaProdu= activardescripcionTipoAreaEmpresaProdu;
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
		
		
		this.setMostraridTipoAreaEmpresaProdu(esInicial);
		this.setMostrarid_empresaTipoAreaEmpresaProdu(esInicial);
		this.setMostrarnombreTipoAreaEmpresaProdu(esInicial);
		this.setMostrardescripcionTipoAreaEmpresaProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoAreaEmpresaProduConstantesFunciones.ID)) {
				this.setMostraridTipoAreaEmpresaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAreaEmpresaProduConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoAreaEmpresaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAreaEmpresaProduConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoAreaEmpresaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAreaEmpresaProduConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionTipoAreaEmpresaProdu(esAsigna);
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
		
		
		this.setActivaridTipoAreaEmpresaProdu(esInicial);
		this.setActivarid_empresaTipoAreaEmpresaProdu(esInicial);
		this.setActivarnombreTipoAreaEmpresaProdu(esInicial);
		this.setActivardescripcionTipoAreaEmpresaProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoAreaEmpresaProduConstantesFunciones.ID)) {
				this.setActivaridTipoAreaEmpresaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAreaEmpresaProduConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoAreaEmpresaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAreaEmpresaProduConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoAreaEmpresaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAreaEmpresaProduConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionTipoAreaEmpresaProdu(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoAreaEmpresaProduBeanSwingJInternalFrame tipoareaempresaproduBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoAreaEmpresaProdu(esInicial);
		this.setResaltarid_empresaTipoAreaEmpresaProdu(esInicial);
		this.setResaltarnombreTipoAreaEmpresaProdu(esInicial);
		this.setResaltardescripcionTipoAreaEmpresaProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoAreaEmpresaProduConstantesFunciones.ID)) {
				this.setResaltaridTipoAreaEmpresaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAreaEmpresaProduConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoAreaEmpresaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAreaEmpresaProduConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoAreaEmpresaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAreaEmpresaProduConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionTipoAreaEmpresaProdu(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarProductoOrdenDetaProduMaquinaTipoAreaEmpresaProdu=null;

	public Border getResaltarProductoOrdenDetaProduMaquinaTipoAreaEmpresaProdu() {
		return this.resaltarProductoOrdenDetaProduMaquinaTipoAreaEmpresaProdu;
	}

	public void setResaltarProductoOrdenDetaProduMaquinaTipoAreaEmpresaProdu(Border borderResaltarProductoOrdenDetaProduMaquina) {
		if(borderResaltarProductoOrdenDetaProduMaquina!=null) {
			this.resaltarProductoOrdenDetaProduMaquinaTipoAreaEmpresaProdu= borderResaltarProductoOrdenDetaProduMaquina;
		}
	}

	public Border setResaltarProductoOrdenDetaProduMaquinaTipoAreaEmpresaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAreaEmpresaProduBeanSwingJInternalFrame tipoareaempresaproduBeanSwingJInternalFrame*/) {
		Border borderResaltarProductoOrdenDetaProduMaquina=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoareaempresaproduBeanSwingJInternalFrame.jTtoolBarTipoAreaEmpresaProdu.setBorder(borderResaltarProductoOrdenDetaProduMaquina);
			
		this.resaltarProductoOrdenDetaProduMaquinaTipoAreaEmpresaProdu= borderResaltarProductoOrdenDetaProduMaquina;

		 return borderResaltarProductoOrdenDetaProduMaquina;
	}



	public Boolean mostrarProductoOrdenDetaProduMaquinaTipoAreaEmpresaProdu=true;

	public Boolean getMostrarProductoOrdenDetaProduMaquinaTipoAreaEmpresaProdu() {
		return this.mostrarProductoOrdenDetaProduMaquinaTipoAreaEmpresaProdu;
	}

	public void setMostrarProductoOrdenDetaProduMaquinaTipoAreaEmpresaProdu(Boolean visibilidadResaltarProductoOrdenDetaProduMaquina) {
		this.mostrarProductoOrdenDetaProduMaquinaTipoAreaEmpresaProdu= visibilidadResaltarProductoOrdenDetaProduMaquina;
	}



	public Boolean activarProductoOrdenDetaProduMaquinaTipoAreaEmpresaProdu=true;

	public Boolean gethabilitarResaltarProductoOrdenDetaProduMaquinaTipoAreaEmpresaProdu() {
		return this.activarProductoOrdenDetaProduMaquinaTipoAreaEmpresaProdu;
	}

	public void setActivarProductoOrdenDetaProduMaquinaTipoAreaEmpresaProdu(Boolean habilitarResaltarProductoOrdenDetaProduMaquina) {
		this.activarProductoOrdenDetaProduMaquinaTipoAreaEmpresaProdu= habilitarResaltarProductoOrdenDetaProduMaquina;
	}


	public Border resaltarProductoProduMaquinaTipoAreaEmpresaProdu=null;

	public Border getResaltarProductoProduMaquinaTipoAreaEmpresaProdu() {
		return this.resaltarProductoProduMaquinaTipoAreaEmpresaProdu;
	}

	public void setResaltarProductoProduMaquinaTipoAreaEmpresaProdu(Border borderResaltarProductoProduMaquina) {
		if(borderResaltarProductoProduMaquina!=null) {
			this.resaltarProductoProduMaquinaTipoAreaEmpresaProdu= borderResaltarProductoProduMaquina;
		}
	}

	public Border setResaltarProductoProduMaquinaTipoAreaEmpresaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAreaEmpresaProduBeanSwingJInternalFrame tipoareaempresaproduBeanSwingJInternalFrame*/) {
		Border borderResaltarProductoProduMaquina=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoareaempresaproduBeanSwingJInternalFrame.jTtoolBarTipoAreaEmpresaProdu.setBorder(borderResaltarProductoProduMaquina);
			
		this.resaltarProductoProduMaquinaTipoAreaEmpresaProdu= borderResaltarProductoProduMaquina;

		 return borderResaltarProductoProduMaquina;
	}



	public Boolean mostrarProductoProduMaquinaTipoAreaEmpresaProdu=true;

	public Boolean getMostrarProductoProduMaquinaTipoAreaEmpresaProdu() {
		return this.mostrarProductoProduMaquinaTipoAreaEmpresaProdu;
	}

	public void setMostrarProductoProduMaquinaTipoAreaEmpresaProdu(Boolean visibilidadResaltarProductoProduMaquina) {
		this.mostrarProductoProduMaquinaTipoAreaEmpresaProdu= visibilidadResaltarProductoProduMaquina;
	}



	public Boolean activarProductoProduMaquinaTipoAreaEmpresaProdu=true;

	public Boolean gethabilitarResaltarProductoProduMaquinaTipoAreaEmpresaProdu() {
		return this.activarProductoProduMaquinaTipoAreaEmpresaProdu;
	}

	public void setActivarProductoProduMaquinaTipoAreaEmpresaProdu(Boolean habilitarResaltarProductoProduMaquina) {
		this.activarProductoProduMaquinaTipoAreaEmpresaProdu= habilitarResaltarProductoProduMaquina;
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

		this.setMostrarProductoOrdenDetaProduMaquinaTipoAreaEmpresaProdu(esInicial);
		this.setMostrarProductoProduMaquinaTipoAreaEmpresaProdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProductoOrdenDetaProduMaquina.class)) {
				this.setMostrarProductoOrdenDetaProduMaquinaTipoAreaEmpresaProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoProduMaquina.class)) {
				this.setMostrarProductoProduMaquinaTipoAreaEmpresaProdu(esAsigna);
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

		this.setActivarProductoOrdenDetaProduMaquinaTipoAreaEmpresaProdu(esInicial);
		this.setActivarProductoProduMaquinaTipoAreaEmpresaProdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProductoOrdenDetaProduMaquina.class)) {
				this.setActivarProductoOrdenDetaProduMaquinaTipoAreaEmpresaProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoProduMaquina.class)) {
				this.setActivarProductoProduMaquinaTipoAreaEmpresaProdu(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoAreaEmpresaProduBeanSwingJInternalFrame tipoareaempresaproduBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarProductoOrdenDetaProduMaquinaTipoAreaEmpresaProdu(esInicial);
		this.setResaltarProductoProduMaquinaTipoAreaEmpresaProdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProductoOrdenDetaProduMaquina.class)) {
				this.setResaltarProductoOrdenDetaProduMaquinaTipoAreaEmpresaProdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ProductoProduMaquina.class)) {
				this.setResaltarProductoProduMaquinaTipoAreaEmpresaProdu(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoAreaEmpresaProdu=true;

	public Boolean getMostrarFK_IdEmpresaTipoAreaEmpresaProdu() {
		return this.mostrarFK_IdEmpresaTipoAreaEmpresaProdu;
	}

	public void setMostrarFK_IdEmpresaTipoAreaEmpresaProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoAreaEmpresaProdu= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoAreaEmpresaProdu=true;

	public Boolean getActivarFK_IdEmpresaTipoAreaEmpresaProdu() {
		return this.activarFK_IdEmpresaTipoAreaEmpresaProdu;
	}

	public void setActivarFK_IdEmpresaTipoAreaEmpresaProdu(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoAreaEmpresaProdu= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoAreaEmpresaProdu=null;

	public Border getResaltarFK_IdEmpresaTipoAreaEmpresaProdu() {
		return this.resaltarFK_IdEmpresaTipoAreaEmpresaProdu;
	}

	public void setResaltarFK_IdEmpresaTipoAreaEmpresaProdu(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoAreaEmpresaProdu= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoAreaEmpresaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAreaEmpresaProduBeanSwingJInternalFrame tipoareaempresaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoAreaEmpresaProdu= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}