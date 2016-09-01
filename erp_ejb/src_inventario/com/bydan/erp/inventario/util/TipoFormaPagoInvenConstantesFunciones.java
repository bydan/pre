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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.TipoFormaPagoInvenConstantesFunciones;
import com.bydan.erp.inventario.util.TipoFormaPagoInvenParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoFormaPagoInvenParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoFormaPagoInvenConstantesFunciones extends TipoFormaPagoInvenConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoFormaPagoInven";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoFormaPagoInven"+TipoFormaPagoInvenConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoFormaPagoInvenHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoFormaPagoInvenHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoFormaPagoInvenConstantesFunciones.SCHEMA+"_"+TipoFormaPagoInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoFormaPagoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoFormaPagoInvenConstantesFunciones.SCHEMA+"_"+TipoFormaPagoInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoFormaPagoInvenConstantesFunciones.SCHEMA+"_"+TipoFormaPagoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoFormaPagoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoFormaPagoInvenConstantesFunciones.SCHEMA+"_"+TipoFormaPagoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFormaPagoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoFormaPagoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFormaPagoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFormaPagoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoFormaPagoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFormaPagoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoFormaPagoInvenConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoFormaPagoInvenConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoFormaPagoInvenConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoFormaPagoInvenConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Forma Pago Invenes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Forma Pago Inven";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Forma Pago Inven";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoFormaPagoInven";
	public static final String OBJECTNAME="tipoformapagoinven";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="tipo_forma_pago_inven";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoformapagoinven from "+TipoFormaPagoInvenConstantesFunciones.SPERSISTENCENAME+" tipoformapagoinven";
	public static String QUERYSELECTNATIVE="select "+TipoFormaPagoInvenConstantesFunciones.SCHEMA+"."+TipoFormaPagoInvenConstantesFunciones.TABLENAME+".id,"+TipoFormaPagoInvenConstantesFunciones.SCHEMA+"."+TipoFormaPagoInvenConstantesFunciones.TABLENAME+".version_row,"+TipoFormaPagoInvenConstantesFunciones.SCHEMA+"."+TipoFormaPagoInvenConstantesFunciones.TABLENAME+".id_empresa,"+TipoFormaPagoInvenConstantesFunciones.SCHEMA+"."+TipoFormaPagoInvenConstantesFunciones.TABLENAME+".codigo,"+TipoFormaPagoInvenConstantesFunciones.SCHEMA+"."+TipoFormaPagoInvenConstantesFunciones.TABLENAME+".nombre from "+TipoFormaPagoInvenConstantesFunciones.SCHEMA+"."+TipoFormaPagoInvenConstantesFunciones.TABLENAME;//+" as "+TipoFormaPagoInvenConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoFormaPagoInvenConstantesFuncionesAdditional tipoformapagoinvenConstantesFuncionesAdditional=null;
	
	public TipoFormaPagoInvenConstantesFuncionesAdditional getTipoFormaPagoInvenConstantesFuncionesAdditional() {
		return this.tipoformapagoinvenConstantesFuncionesAdditional;
	}
	
	public void setTipoFormaPagoInvenConstantesFuncionesAdditional(TipoFormaPagoInvenConstantesFuncionesAdditional tipoformapagoinvenConstantesFuncionesAdditional) {
		try {
			this.tipoformapagoinvenConstantesFuncionesAdditional=tipoformapagoinvenConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
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
	
	public static String getTipoFormaPagoInvenLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoFormaPagoInvenConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoFormaPagoInvenConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoFormaPagoInvenConstantesFunciones.CODIGO)) {sLabelColumna=TipoFormaPagoInvenConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoFormaPagoInvenConstantesFunciones.NOMBRE)) {sLabelColumna=TipoFormaPagoInvenConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoFormaPagoInvenDescripcion(TipoFormaPagoInven tipoformapagoinven) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoformapagoinven !=null/* && tipoformapagoinven.getId()!=0*/) {
			sDescripcion=tipoformapagoinven.getcodigo();//tipoformapagoinventipoformapagoinven.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoFormaPagoInvenDescripcionDetallado(TipoFormaPagoInven tipoformapagoinven) {
		String sDescripcion="";
			
		sDescripcion+=TipoFormaPagoInvenConstantesFunciones.ID+"=";
		sDescripcion+=tipoformapagoinven.getId().toString()+",";
		sDescripcion+=TipoFormaPagoInvenConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoformapagoinven.getVersionRow().toString()+",";
		sDescripcion+=TipoFormaPagoInvenConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipoformapagoinven.getid_empresa().toString()+",";
		sDescripcion+=TipoFormaPagoInvenConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoformapagoinven.getcodigo()+",";
		sDescripcion+=TipoFormaPagoInvenConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoformapagoinven.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoFormaPagoInvenDescripcion(TipoFormaPagoInven tipoformapagoinven,String sValor) throws Exception {			
		if(tipoformapagoinven !=null) {
			tipoformapagoinven.setcodigo(sValor);;//tipoformapagoinventipoformapagoinven.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoFormaPagoInven(TipoFormaPagoInven tipoformapagoinven,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoformapagoinven.setcodigo(tipoformapagoinven.getcodigo().trim());
		tipoformapagoinven.setnombre(tipoformapagoinven.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoFormaPagoInvens(List<TipoFormaPagoInven> tipoformapagoinvens,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoFormaPagoInven tipoformapagoinven: tipoformapagoinvens) {
			tipoformapagoinven.setcodigo(tipoformapagoinven.getcodigo().trim());
			tipoformapagoinven.setnombre(tipoformapagoinven.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoFormaPagoInven(TipoFormaPagoInven tipoformapagoinven,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoformapagoinven.getConCambioAuxiliar()) {
			tipoformapagoinven.setIsDeleted(tipoformapagoinven.getIsDeletedAuxiliar());	
			tipoformapagoinven.setIsNew(tipoformapagoinven.getIsNewAuxiliar());	
			tipoformapagoinven.setIsChanged(tipoformapagoinven.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoformapagoinven.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoformapagoinven.setIsDeletedAuxiliar(false);	
			tipoformapagoinven.setIsNewAuxiliar(false);	
			tipoformapagoinven.setIsChangedAuxiliar(false);
			
			tipoformapagoinven.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoFormaPagoInvens(List<TipoFormaPagoInven> tipoformapagoinvens,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoFormaPagoInven tipoformapagoinven : tipoformapagoinvens) {
			if(conAsignarBase && tipoformapagoinven.getConCambioAuxiliar()) {
				tipoformapagoinven.setIsDeleted(tipoformapagoinven.getIsDeletedAuxiliar());	
				tipoformapagoinven.setIsNew(tipoformapagoinven.getIsNewAuxiliar());	
				tipoformapagoinven.setIsChanged(tipoformapagoinven.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoformapagoinven.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoformapagoinven.setIsDeletedAuxiliar(false);	
				tipoformapagoinven.setIsNewAuxiliar(false);	
				tipoformapagoinven.setIsChangedAuxiliar(false);
				
				tipoformapagoinven.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoFormaPagoInven(TipoFormaPagoInven tipoformapagoinven,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoFormaPagoInvens(List<TipoFormaPagoInven> tipoformapagoinvens,Boolean conEnteros) throws Exception  {
		
		for(TipoFormaPagoInven tipoformapagoinven: tipoformapagoinvens) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoFormaPagoInven(List<TipoFormaPagoInven> tipoformapagoinvens,TipoFormaPagoInven tipoformapagoinvenAux) throws Exception  {
		TipoFormaPagoInvenConstantesFunciones.InicializarValoresTipoFormaPagoInven(tipoformapagoinvenAux,true);
		
		for(TipoFormaPagoInven tipoformapagoinven: tipoformapagoinvens) {
			if(tipoformapagoinven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoFormaPagoInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoFormaPagoInvenConstantesFunciones.getArrayColumnasGlobalesTipoFormaPagoInven(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoFormaPagoInven(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoFormaPagoInvenConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoFormaPagoInvenConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoFormaPagoInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoFormaPagoInven> tipoformapagoinvens,TipoFormaPagoInven tipoformapagoinven,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoFormaPagoInven tipoformapagoinvenAux: tipoformapagoinvens) {
			if(tipoformapagoinvenAux!=null && tipoformapagoinven!=null) {
				if((tipoformapagoinvenAux.getId()==null && tipoformapagoinven.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoformapagoinvenAux.getId()!=null && tipoformapagoinven.getId()!=null){
					if(tipoformapagoinvenAux.getId().equals(tipoformapagoinven.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoFormaPagoInven(List<TipoFormaPagoInven> tipoformapagoinvens) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoFormaPagoInven tipoformapagoinven: tipoformapagoinvens) {			
			if(tipoformapagoinven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoFormaPagoInven() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoFormaPagoInvenConstantesFunciones.LABEL_ID, TipoFormaPagoInvenConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFormaPagoInvenConstantesFunciones.LABEL_VERSIONROW, TipoFormaPagoInvenConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFormaPagoInvenConstantesFunciones.LABEL_IDEMPRESA, TipoFormaPagoInvenConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFormaPagoInvenConstantesFunciones.LABEL_CODIGO, TipoFormaPagoInvenConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFormaPagoInvenConstantesFunciones.LABEL_NOMBRE, TipoFormaPagoInvenConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoFormaPagoInven() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoFormaPagoInvenConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFormaPagoInvenConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFormaPagoInvenConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFormaPagoInvenConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFormaPagoInvenConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFormaPagoInven() throws Exception  {
		return TipoFormaPagoInvenConstantesFunciones.getTiposSeleccionarTipoFormaPagoInven(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFormaPagoInven(Boolean conFk) throws Exception  {
		return TipoFormaPagoInvenConstantesFunciones.getTiposSeleccionarTipoFormaPagoInven(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFormaPagoInven(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFormaPagoInvenConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoFormaPagoInvenConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFormaPagoInvenConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoFormaPagoInvenConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFormaPagoInvenConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoFormaPagoInvenConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoFormaPagoInven(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoFormaPagoInven(TipoFormaPagoInven tipoformapagoinvenAux) throws Exception {
		
			tipoformapagoinvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoformapagoinvenAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoFormaPagoInven(List<TipoFormaPagoInven> tipoformapagoinvensTemp) throws Exception {
		for(TipoFormaPagoInven tipoformapagoinvenAux:tipoformapagoinvensTemp) {
			
			tipoformapagoinvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoformapagoinvenAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoFormaPagoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoFormaPagoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoFormaPagoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoFormaPagoInvenConstantesFunciones.getClassesRelationshipsOfTipoFormaPagoInven(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoFormaPagoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoFormaPagoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoFormaPagoInvenConstantesFunciones.getClassesRelationshipsFromStringsOfTipoFormaPagoInven(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoFormaPagoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoFormaPagoInven tipoformapagoinven,List<TipoFormaPagoInven> tipoformapagoinvens,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoFormaPagoInven tipoformapagoinvenEncontrado=null;
			
			for(TipoFormaPagoInven tipoformapagoinvenLocal:tipoformapagoinvens) {
				if(tipoformapagoinvenLocal.getId().equals(tipoformapagoinven.getId())) {
					tipoformapagoinvenEncontrado=tipoformapagoinvenLocal;
					
					tipoformapagoinvenLocal.setIsChanged(tipoformapagoinven.getIsChanged());
					tipoformapagoinvenLocal.setIsNew(tipoformapagoinven.getIsNew());
					tipoformapagoinvenLocal.setIsDeleted(tipoformapagoinven.getIsDeleted());
					
					tipoformapagoinvenLocal.setGeneralEntityOriginal(tipoformapagoinven.getGeneralEntityOriginal());
					
					tipoformapagoinvenLocal.setId(tipoformapagoinven.getId());	
					tipoformapagoinvenLocal.setVersionRow(tipoformapagoinven.getVersionRow());	
					tipoformapagoinvenLocal.setid_empresa(tipoformapagoinven.getid_empresa());	
					tipoformapagoinvenLocal.setcodigo(tipoformapagoinven.getcodigo());	
					tipoformapagoinvenLocal.setnombre(tipoformapagoinven.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoformapagoinven.getIsDeleted()) {
				if(!existe) {
					tipoformapagoinvens.add(tipoformapagoinven);
				}
			} else {
				if(tipoformapagoinvenEncontrado!=null && permiteQuitar)  {
					tipoformapagoinvens.remove(tipoformapagoinvenEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoFormaPagoInven tipoformapagoinven,List<TipoFormaPagoInven> tipoformapagoinvens) throws Exception {
		try	{			
			for(TipoFormaPagoInven tipoformapagoinvenLocal:tipoformapagoinvens) {
				if(tipoformapagoinvenLocal.getId().equals(tipoformapagoinven.getId())) {
					tipoformapagoinvenLocal.setIsSelected(tipoformapagoinven.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoFormaPagoInven(List<TipoFormaPagoInven> tipoformapagoinvensAux) throws Exception {
		//this.tipoformapagoinvensAux=tipoformapagoinvensAux;
		
		for(TipoFormaPagoInven tipoformapagoinvenAux:tipoformapagoinvensAux) {
			if(tipoformapagoinvenAux.getIsChanged()) {
				tipoformapagoinvenAux.setIsChanged(false);
			}		
			
			if(tipoformapagoinvenAux.getIsNew()) {
				tipoformapagoinvenAux.setIsNew(false);
			}	
			
			if(tipoformapagoinvenAux.getIsDeleted()) {
				tipoformapagoinvenAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoFormaPagoInven(TipoFormaPagoInven tipoformapagoinvenAux) throws Exception {
		//this.tipoformapagoinvenAux=tipoformapagoinvenAux;
		
			if(tipoformapagoinvenAux.getIsChanged()) {
				tipoformapagoinvenAux.setIsChanged(false);
			}		
			
			if(tipoformapagoinvenAux.getIsNew()) {
				tipoformapagoinvenAux.setIsNew(false);
			}	
			
			if(tipoformapagoinvenAux.getIsDeleted()) {
				tipoformapagoinvenAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoFormaPagoInven tipoformapagoinvenAsignar,TipoFormaPagoInven tipoformapagoinven) throws Exception {
		tipoformapagoinvenAsignar.setId(tipoformapagoinven.getId());	
		tipoformapagoinvenAsignar.setVersionRow(tipoformapagoinven.getVersionRow());	
		tipoformapagoinvenAsignar.setid_empresa(tipoformapagoinven.getid_empresa());
		tipoformapagoinvenAsignar.setempresa_descripcion(tipoformapagoinven.getempresa_descripcion());	
		tipoformapagoinvenAsignar.setcodigo(tipoformapagoinven.getcodigo());	
		tipoformapagoinvenAsignar.setnombre(tipoformapagoinven.getnombre());	
	}
	
	public static void inicializarTipoFormaPagoInven(TipoFormaPagoInven tipoformapagoinven) throws Exception {
		try {
				tipoformapagoinven.setId(0L);	
					
				tipoformapagoinven.setid_empresa(-1L);	
				tipoformapagoinven.setcodigo("");	
				tipoformapagoinven.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoFormaPagoInven(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFormaPagoInvenConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFormaPagoInvenConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFormaPagoInvenConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoFormaPagoInven(String sTipo,Row row,Workbook workbook,TipoFormaPagoInven tipoformapagoinven,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoformapagoinven.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoformapagoinven.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoformapagoinven.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoFormaPagoInven=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoFormaPagoInven() {
		return this.sFinalQueryTipoFormaPagoInven;
	}
	
	public void setsFinalQueryTipoFormaPagoInven(String sFinalQueryTipoFormaPagoInven) {
		this.sFinalQueryTipoFormaPagoInven= sFinalQueryTipoFormaPagoInven;
	}
	
	public Border resaltarSeleccionarTipoFormaPagoInven=null;
	
	public Border setResaltarSeleccionarTipoFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoInvenBeanSwingJInternalFrame tipoformapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoformapagoinvenBeanSwingJInternalFrame.jTtoolBarTipoFormaPagoInven.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoFormaPagoInven= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoFormaPagoInven() {
		return this.resaltarSeleccionarTipoFormaPagoInven;
	}
	
	public void setResaltarSeleccionarTipoFormaPagoInven(Border borderResaltarSeleccionarTipoFormaPagoInven) {
		this.resaltarSeleccionarTipoFormaPagoInven= borderResaltarSeleccionarTipoFormaPagoInven;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoFormaPagoInven=null;
	public Boolean mostraridTipoFormaPagoInven=true;
	public Boolean activaridTipoFormaPagoInven=true;

	public Border resaltarid_empresaTipoFormaPagoInven=null;
	public Boolean mostrarid_empresaTipoFormaPagoInven=true;
	public Boolean activarid_empresaTipoFormaPagoInven=true;
	public Boolean cargarid_empresaTipoFormaPagoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoFormaPagoInven=false;//ConEventDepend=true

	public Border resaltarcodigoTipoFormaPagoInven=null;
	public Boolean mostrarcodigoTipoFormaPagoInven=true;
	public Boolean activarcodigoTipoFormaPagoInven=true;

	public Border resaltarnombreTipoFormaPagoInven=null;
	public Boolean mostrarnombreTipoFormaPagoInven=true;
	public Boolean activarnombreTipoFormaPagoInven=true;

	
	

	public Border setResaltaridTipoFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoInvenBeanSwingJInternalFrame tipoformapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoformapagoinvenBeanSwingJInternalFrame.jTtoolBarTipoFormaPagoInven.setBorder(borderResaltar);
		
		this.resaltaridTipoFormaPagoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoFormaPagoInven() {
		return this.resaltaridTipoFormaPagoInven;
	}

	public void setResaltaridTipoFormaPagoInven(Border borderResaltar) {
		this.resaltaridTipoFormaPagoInven= borderResaltar;
	}

	public Boolean getMostraridTipoFormaPagoInven() {
		return this.mostraridTipoFormaPagoInven;
	}

	public void setMostraridTipoFormaPagoInven(Boolean mostraridTipoFormaPagoInven) {
		this.mostraridTipoFormaPagoInven= mostraridTipoFormaPagoInven;
	}

	public Boolean getActivaridTipoFormaPagoInven() {
		return this.activaridTipoFormaPagoInven;
	}

	public void setActivaridTipoFormaPagoInven(Boolean activaridTipoFormaPagoInven) {
		this.activaridTipoFormaPagoInven= activaridTipoFormaPagoInven;
	}

	public Border setResaltarid_empresaTipoFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoInvenBeanSwingJInternalFrame tipoformapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoformapagoinvenBeanSwingJInternalFrame.jTtoolBarTipoFormaPagoInven.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoFormaPagoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoFormaPagoInven() {
		return this.resaltarid_empresaTipoFormaPagoInven;
	}

	public void setResaltarid_empresaTipoFormaPagoInven(Border borderResaltar) {
		this.resaltarid_empresaTipoFormaPagoInven= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoFormaPagoInven() {
		return this.mostrarid_empresaTipoFormaPagoInven;
	}

	public void setMostrarid_empresaTipoFormaPagoInven(Boolean mostrarid_empresaTipoFormaPagoInven) {
		this.mostrarid_empresaTipoFormaPagoInven= mostrarid_empresaTipoFormaPagoInven;
	}

	public Boolean getActivarid_empresaTipoFormaPagoInven() {
		return this.activarid_empresaTipoFormaPagoInven;
	}

	public void setActivarid_empresaTipoFormaPagoInven(Boolean activarid_empresaTipoFormaPagoInven) {
		this.activarid_empresaTipoFormaPagoInven= activarid_empresaTipoFormaPagoInven;
	}

	public Boolean getCargarid_empresaTipoFormaPagoInven() {
		return this.cargarid_empresaTipoFormaPagoInven;
	}

	public void setCargarid_empresaTipoFormaPagoInven(Boolean cargarid_empresaTipoFormaPagoInven) {
		this.cargarid_empresaTipoFormaPagoInven= cargarid_empresaTipoFormaPagoInven;
	}

	public Border setResaltarcodigoTipoFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoInvenBeanSwingJInternalFrame tipoformapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoformapagoinvenBeanSwingJInternalFrame.jTtoolBarTipoFormaPagoInven.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoFormaPagoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoFormaPagoInven() {
		return this.resaltarcodigoTipoFormaPagoInven;
	}

	public void setResaltarcodigoTipoFormaPagoInven(Border borderResaltar) {
		this.resaltarcodigoTipoFormaPagoInven= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoFormaPagoInven() {
		return this.mostrarcodigoTipoFormaPagoInven;
	}

	public void setMostrarcodigoTipoFormaPagoInven(Boolean mostrarcodigoTipoFormaPagoInven) {
		this.mostrarcodigoTipoFormaPagoInven= mostrarcodigoTipoFormaPagoInven;
	}

	public Boolean getActivarcodigoTipoFormaPagoInven() {
		return this.activarcodigoTipoFormaPagoInven;
	}

	public void setActivarcodigoTipoFormaPagoInven(Boolean activarcodigoTipoFormaPagoInven) {
		this.activarcodigoTipoFormaPagoInven= activarcodigoTipoFormaPagoInven;
	}

	public Border setResaltarnombreTipoFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoInvenBeanSwingJInternalFrame tipoformapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoformapagoinvenBeanSwingJInternalFrame.jTtoolBarTipoFormaPagoInven.setBorder(borderResaltar);
		
		this.resaltarnombreTipoFormaPagoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoFormaPagoInven() {
		return this.resaltarnombreTipoFormaPagoInven;
	}

	public void setResaltarnombreTipoFormaPagoInven(Border borderResaltar) {
		this.resaltarnombreTipoFormaPagoInven= borderResaltar;
	}

	public Boolean getMostrarnombreTipoFormaPagoInven() {
		return this.mostrarnombreTipoFormaPagoInven;
	}

	public void setMostrarnombreTipoFormaPagoInven(Boolean mostrarnombreTipoFormaPagoInven) {
		this.mostrarnombreTipoFormaPagoInven= mostrarnombreTipoFormaPagoInven;
	}

	public Boolean getActivarnombreTipoFormaPagoInven() {
		return this.activarnombreTipoFormaPagoInven;
	}

	public void setActivarnombreTipoFormaPagoInven(Boolean activarnombreTipoFormaPagoInven) {
		this.activarnombreTipoFormaPagoInven= activarnombreTipoFormaPagoInven;
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
		
		
		this.setMostraridTipoFormaPagoInven(esInicial);
		this.setMostrarid_empresaTipoFormaPagoInven(esInicial);
		this.setMostrarcodigoTipoFormaPagoInven(esInicial);
		this.setMostrarnombreTipoFormaPagoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFormaPagoInvenConstantesFunciones.ID)) {
				this.setMostraridTipoFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoInvenConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoInvenConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoInvenConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoFormaPagoInven(esAsigna);
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
		
		
		this.setActivaridTipoFormaPagoInven(esInicial);
		this.setActivarid_empresaTipoFormaPagoInven(esInicial);
		this.setActivarcodigoTipoFormaPagoInven(esInicial);
		this.setActivarnombreTipoFormaPagoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFormaPagoInvenConstantesFunciones.ID)) {
				this.setActivaridTipoFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoInvenConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoInvenConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoInvenConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoFormaPagoInven(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoFormaPagoInvenBeanSwingJInternalFrame tipoformapagoinvenBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoFormaPagoInven(esInicial);
		this.setResaltarid_empresaTipoFormaPagoInven(esInicial);
		this.setResaltarcodigoTipoFormaPagoInven(esInicial);
		this.setResaltarnombreTipoFormaPagoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFormaPagoInvenConstantesFunciones.ID)) {
				this.setResaltaridTipoFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoInvenConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoInvenConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoFormaPagoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormaPagoInvenConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoFormaPagoInven(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoFormaPagoInvenBeanSwingJInternalFrame tipoformapagoinvenBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaTipoFormaPagoInven=true;

	public Boolean getMostrarFK_IdEmpresaTipoFormaPagoInven() {
		return this.mostrarFK_IdEmpresaTipoFormaPagoInven;
	}

	public void setMostrarFK_IdEmpresaTipoFormaPagoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoFormaPagoInven= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoFormaPagoInven=true;

	public Boolean getActivarFK_IdEmpresaTipoFormaPagoInven() {
		return this.activarFK_IdEmpresaTipoFormaPagoInven;
	}

	public void setActivarFK_IdEmpresaTipoFormaPagoInven(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoFormaPagoInven= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoFormaPagoInven=null;

	public Border getResaltarFK_IdEmpresaTipoFormaPagoInven() {
		return this.resaltarFK_IdEmpresaTipoFormaPagoInven;
	}

	public void setResaltarFK_IdEmpresaTipoFormaPagoInven(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoFormaPagoInven= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoFormaPagoInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormaPagoInvenBeanSwingJInternalFrame tipoformapagoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoFormaPagoInven= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}