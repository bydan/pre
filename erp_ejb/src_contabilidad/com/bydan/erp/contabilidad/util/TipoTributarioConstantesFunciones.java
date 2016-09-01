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


import com.bydan.erp.contabilidad.util.TipoTributarioConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoTributarioParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoTributarioParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoTributarioConstantesFunciones extends TipoTributarioConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoTributario";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoTributario"+TipoTributarioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoTributarioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoTributarioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoTributarioConstantesFunciones.SCHEMA+"_"+TipoTributarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoTributarioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoTributarioConstantesFunciones.SCHEMA+"_"+TipoTributarioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoTributarioConstantesFunciones.SCHEMA+"_"+TipoTributarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoTributarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoTributarioConstantesFunciones.SCHEMA+"_"+TipoTributarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTributarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoTributarioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTributarioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTributarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoTributarioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoTributarioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoTributarioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoTributarioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoTributarioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoTributarioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Tributarios";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Tributario";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Tributario";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoTributario";
	public static final String OBJECTNAME="tipotributario";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="tipo_tributario";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipotributario from "+TipoTributarioConstantesFunciones.SPERSISTENCENAME+" tipotributario";
	public static String QUERYSELECTNATIVE="select "+TipoTributarioConstantesFunciones.SCHEMA+"."+TipoTributarioConstantesFunciones.TABLENAME+".id,"+TipoTributarioConstantesFunciones.SCHEMA+"."+TipoTributarioConstantesFunciones.TABLENAME+".version_row,"+TipoTributarioConstantesFunciones.SCHEMA+"."+TipoTributarioConstantesFunciones.TABLENAME+".id_pais,"+TipoTributarioConstantesFunciones.SCHEMA+"."+TipoTributarioConstantesFunciones.TABLENAME+".codigo,"+TipoTributarioConstantesFunciones.SCHEMA+"."+TipoTributarioConstantesFunciones.TABLENAME+".nombre from "+TipoTributarioConstantesFunciones.SCHEMA+"."+TipoTributarioConstantesFunciones.TABLENAME;//+" as "+TipoTributarioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoTributarioConstantesFuncionesAdditional tipotributarioConstantesFuncionesAdditional=null;
	
	public TipoTributarioConstantesFuncionesAdditional getTipoTributarioConstantesFuncionesAdditional() {
		return this.tipotributarioConstantesFuncionesAdditional;
	}
	
	public void setTipoTributarioConstantesFuncionesAdditional(TipoTributarioConstantesFuncionesAdditional tipotributarioConstantesFuncionesAdditional) {
		try {
			this.tipotributarioConstantesFuncionesAdditional=tipotributarioConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPAIS= "id_pais";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoTributarioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoTributarioConstantesFunciones.IDPAIS)) {sLabelColumna=TipoTributarioConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(TipoTributarioConstantesFunciones.CODIGO)) {sLabelColumna=TipoTributarioConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoTributarioConstantesFunciones.NOMBRE)) {sLabelColumna=TipoTributarioConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoTributarioDescripcion(TipoTributario tipotributario) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipotributario !=null/* && tipotributario.getId()!=0*/) {
			sDescripcion=tipotributario.getcodigo();//tipotributariotipotributario.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoTributarioDescripcionDetallado(TipoTributario tipotributario) {
		String sDescripcion="";
			
		sDescripcion+=TipoTributarioConstantesFunciones.ID+"=";
		sDescripcion+=tipotributario.getId().toString()+",";
		sDescripcion+=TipoTributarioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipotributario.getVersionRow().toString()+",";
		sDescripcion+=TipoTributarioConstantesFunciones.IDPAIS+"=";
		sDescripcion+=tipotributario.getid_pais().toString()+",";
		sDescripcion+=TipoTributarioConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipotributario.getcodigo()+",";
		sDescripcion+=TipoTributarioConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipotributario.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoTributarioDescripcion(TipoTributario tipotributario,String sValor) throws Exception {			
		if(tipotributario !=null) {
			tipotributario.setcodigo(sValor);;//tipotributariotipotributario.getcodigo().trim();
		}		
	}
	
		

	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorId")) {
			sNombreIndice="Tipo=  Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("PorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorId(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" Id="+id.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoTributario(TipoTributario tipotributario,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipotributario.setcodigo(tipotributario.getcodigo().trim());
		tipotributario.setnombre(tipotributario.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoTributarios(List<TipoTributario> tipotributarios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoTributario tipotributario: tipotributarios) {
			tipotributario.setcodigo(tipotributario.getcodigo().trim());
			tipotributario.setnombre(tipotributario.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoTributario(TipoTributario tipotributario,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipotributario.getConCambioAuxiliar()) {
			tipotributario.setIsDeleted(tipotributario.getIsDeletedAuxiliar());	
			tipotributario.setIsNew(tipotributario.getIsNewAuxiliar());	
			tipotributario.setIsChanged(tipotributario.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipotributario.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipotributario.setIsDeletedAuxiliar(false);	
			tipotributario.setIsNewAuxiliar(false);	
			tipotributario.setIsChangedAuxiliar(false);
			
			tipotributario.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoTributarios(List<TipoTributario> tipotributarios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoTributario tipotributario : tipotributarios) {
			if(conAsignarBase && tipotributario.getConCambioAuxiliar()) {
				tipotributario.setIsDeleted(tipotributario.getIsDeletedAuxiliar());	
				tipotributario.setIsNew(tipotributario.getIsNewAuxiliar());	
				tipotributario.setIsChanged(tipotributario.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipotributario.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipotributario.setIsDeletedAuxiliar(false);	
				tipotributario.setIsNewAuxiliar(false);	
				tipotributario.setIsChangedAuxiliar(false);
				
				tipotributario.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoTributario(TipoTributario tipotributario,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoTributarios(List<TipoTributario> tipotributarios,Boolean conEnteros) throws Exception  {
		
		for(TipoTributario tipotributario: tipotributarios) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoTributario(List<TipoTributario> tipotributarios,TipoTributario tipotributarioAux) throws Exception  {
		TipoTributarioConstantesFunciones.InicializarValoresTipoTributario(tipotributarioAux,true);
		
		for(TipoTributario tipotributario: tipotributarios) {
			if(tipotributario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoTributario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoTributarioConstantesFunciones.getArrayColumnasGlobalesTipoTributario(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoTributario(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoTributario(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoTributario> tipotributarios,TipoTributario tipotributario,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoTributario tipotributarioAux: tipotributarios) {
			if(tipotributarioAux!=null && tipotributario!=null) {
				if((tipotributarioAux.getId()==null && tipotributario.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipotributarioAux.getId()!=null && tipotributario.getId()!=null){
					if(tipotributarioAux.getId().equals(tipotributario.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoTributario(List<TipoTributario> tipotributarios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoTributario tipotributario: tipotributarios) {			
			if(tipotributario.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoTributario() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoTributarioConstantesFunciones.LABEL_ID, TipoTributarioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoTributarioConstantesFunciones.LABEL_VERSIONROW, TipoTributarioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoTributarioConstantesFunciones.LABEL_IDPAIS, TipoTributarioConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoTributarioConstantesFunciones.LABEL_CODIGO, TipoTributarioConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoTributarioConstantesFunciones.LABEL_NOMBRE, TipoTributarioConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoTributario() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoTributarioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoTributarioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoTributarioConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoTributarioConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoTributarioConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoTributario() throws Exception  {
		return TipoTributarioConstantesFunciones.getTiposSeleccionarTipoTributario(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoTributario(Boolean conFk) throws Exception  {
		return TipoTributarioConstantesFunciones.getTiposSeleccionarTipoTributario(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoTributario(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoTributarioConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(TipoTributarioConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoTributarioConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoTributarioConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoTributarioConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoTributarioConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoTributario(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoTributario(TipoTributario tipotributarioAux) throws Exception {
		
			tipotributarioAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipotributarioAux.getPais()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoTributario(List<TipoTributario> tipotributariosTemp) throws Exception {
		for(TipoTributario tipotributarioAux:tipotributariosTemp) {
			
			tipotributarioAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipotributarioAux.getPais()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoTributario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Pais.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoTributario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoTributario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoTributarioConstantesFunciones.getClassesRelationshipsOfTipoTributario(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoTributario(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Sri.class));
				classes.add(new Classe(ImportarExportar.class));
				classes.add(new Classe(TransaccionLocal.class));
				classes.add(new Classe(FacturaProveedorServicio.class));
				classes.add(new Classe(FacturaProveedor.class));
				classes.add(new Classe(Definicion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Sri.class)) {
						classes.add(new Classe(Sri.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ImportarExportar.class)) {
						classes.add(new Classe(ImportarExportar.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TransaccionLocal.class)) {
						classes.add(new Classe(TransaccionLocal.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FacturaProveedorServicio.class)) {
						classes.add(new Classe(FacturaProveedorServicio.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FacturaProveedor.class)) {
						classes.add(new Classe(FacturaProveedor.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Definicion.class)) {
						classes.add(new Classe(Definicion.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoTributario(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoTributarioConstantesFunciones.getClassesRelationshipsFromStringsOfTipoTributario(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoTributario(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Sri.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sri.class)); continue;
					}

					if(ImportarExportar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ImportarExportar.class)); continue;
					}

					if(TransaccionLocal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TransaccionLocal.class)); continue;
					}

					if(FacturaProveedorServicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaProveedorServicio.class)); continue;
					}

					if(FacturaProveedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaProveedor.class)); continue;
					}

					if(Definicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Definicion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Sri.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sri.class)); continue;
					}

					if(ImportarExportar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ImportarExportar.class)); continue;
					}

					if(TransaccionLocal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TransaccionLocal.class)); continue;
					}

					if(FacturaProveedorServicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaProveedorServicio.class)); continue;
					}

					if(FacturaProveedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaProveedor.class)); continue;
					}

					if(Definicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Definicion.class)); continue;
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
	public static void actualizarLista(TipoTributario tipotributario,List<TipoTributario> tipotributarios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoTributario tipotributarioEncontrado=null;
			
			for(TipoTributario tipotributarioLocal:tipotributarios) {
				if(tipotributarioLocal.getId().equals(tipotributario.getId())) {
					tipotributarioEncontrado=tipotributarioLocal;
					
					tipotributarioLocal.setIsChanged(tipotributario.getIsChanged());
					tipotributarioLocal.setIsNew(tipotributario.getIsNew());
					tipotributarioLocal.setIsDeleted(tipotributario.getIsDeleted());
					
					tipotributarioLocal.setGeneralEntityOriginal(tipotributario.getGeneralEntityOriginal());
					
					tipotributarioLocal.setId(tipotributario.getId());	
					tipotributarioLocal.setVersionRow(tipotributario.getVersionRow());	
					tipotributarioLocal.setid_pais(tipotributario.getid_pais());	
					tipotributarioLocal.setcodigo(tipotributario.getcodigo());	
					tipotributarioLocal.setnombre(tipotributario.getnombre());	
					
					
					tipotributarioLocal.setTransaccionLocals(tipotributario.getTransaccionLocals());
					tipotributarioLocal.setFacturaProveedorServicios(tipotributario.getFacturaProveedorServicios());
					tipotributarioLocal.setDefinicions(tipotributario.getDefinicions());
					
					existe=true;
					break;
				}
			}
			
			if(!tipotributario.getIsDeleted()) {
				if(!existe) {
					tipotributarios.add(tipotributario);
				}
			} else {
				if(tipotributarioEncontrado!=null && permiteQuitar)  {
					tipotributarios.remove(tipotributarioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoTributario tipotributario,List<TipoTributario> tipotributarios) throws Exception {
		try	{			
			for(TipoTributario tipotributarioLocal:tipotributarios) {
				if(tipotributarioLocal.getId().equals(tipotributario.getId())) {
					tipotributarioLocal.setIsSelected(tipotributario.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoTributario(List<TipoTributario> tipotributariosAux) throws Exception {
		//this.tipotributariosAux=tipotributariosAux;
		
		for(TipoTributario tipotributarioAux:tipotributariosAux) {
			if(tipotributarioAux.getIsChanged()) {
				tipotributarioAux.setIsChanged(false);
			}		
			
			if(tipotributarioAux.getIsNew()) {
				tipotributarioAux.setIsNew(false);
			}	
			
			if(tipotributarioAux.getIsDeleted()) {
				tipotributarioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoTributario(TipoTributario tipotributarioAux) throws Exception {
		//this.tipotributarioAux=tipotributarioAux;
		
			if(tipotributarioAux.getIsChanged()) {
				tipotributarioAux.setIsChanged(false);
			}		
			
			if(tipotributarioAux.getIsNew()) {
				tipotributarioAux.setIsNew(false);
			}	
			
			if(tipotributarioAux.getIsDeleted()) {
				tipotributarioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoTributario tipotributarioAsignar,TipoTributario tipotributario) throws Exception {
		tipotributarioAsignar.setId(tipotributario.getId());	
		tipotributarioAsignar.setVersionRow(tipotributario.getVersionRow());	
		tipotributarioAsignar.setid_pais(tipotributario.getid_pais());
		tipotributarioAsignar.setpais_descripcion(tipotributario.getpais_descripcion());	
		tipotributarioAsignar.setcodigo(tipotributario.getcodigo());	
		tipotributarioAsignar.setnombre(tipotributario.getnombre());	
	}
	
	public static void inicializarTipoTributario(TipoTributario tipotributario) throws Exception {
		try {
				tipotributario.setId(0L);	
					
				tipotributario.setid_pais(-1L);	
				tipotributario.setcodigo("");	
				tipotributario.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoTributario(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoTributarioConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoTributarioConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoTributarioConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoTributario(String sTipo,Row row,Workbook workbook,TipoTributario tipotributario,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipotributario.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipotributario.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipotributario.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoTributario=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoTributario() {
		return this.sFinalQueryTipoTributario;
	}
	
	public void setsFinalQueryTipoTributario(String sFinalQueryTipoTributario) {
		this.sFinalQueryTipoTributario= sFinalQueryTipoTributario;
	}
	
	public Border resaltarSeleccionarTipoTributario=null;
	
	public Border setResaltarSeleccionarTipoTributario(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTributarioBeanSwingJInternalFrame tipotributarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipotributarioBeanSwingJInternalFrame.jTtoolBarTipoTributario.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoTributario= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoTributario() {
		return this.resaltarSeleccionarTipoTributario;
	}
	
	public void setResaltarSeleccionarTipoTributario(Border borderResaltarSeleccionarTipoTributario) {
		this.resaltarSeleccionarTipoTributario= borderResaltarSeleccionarTipoTributario;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoTributario=null;
	public Boolean mostraridTipoTributario=true;
	public Boolean activaridTipoTributario=true;

	public Border resaltarid_paisTipoTributario=null;
	public Boolean mostrarid_paisTipoTributario=true;
	public Boolean activarid_paisTipoTributario=true;
	public Boolean cargarid_paisTipoTributario=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisTipoTributario=false;//ConEventDepend=true

	public Border resaltarcodigoTipoTributario=null;
	public Boolean mostrarcodigoTipoTributario=true;
	public Boolean activarcodigoTipoTributario=true;

	public Border resaltarnombreTipoTributario=null;
	public Boolean mostrarnombreTipoTributario=true;
	public Boolean activarnombreTipoTributario=true;

	
	

	public Border setResaltaridTipoTributario(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTributarioBeanSwingJInternalFrame tipotributarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipotributarioBeanSwingJInternalFrame.jTtoolBarTipoTributario.setBorder(borderResaltar);
		
		this.resaltaridTipoTributario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoTributario() {
		return this.resaltaridTipoTributario;
	}

	public void setResaltaridTipoTributario(Border borderResaltar) {
		this.resaltaridTipoTributario= borderResaltar;
	}

	public Boolean getMostraridTipoTributario() {
		return this.mostraridTipoTributario;
	}

	public void setMostraridTipoTributario(Boolean mostraridTipoTributario) {
		this.mostraridTipoTributario= mostraridTipoTributario;
	}

	public Boolean getActivaridTipoTributario() {
		return this.activaridTipoTributario;
	}

	public void setActivaridTipoTributario(Boolean activaridTipoTributario) {
		this.activaridTipoTributario= activaridTipoTributario;
	}

	public Border setResaltarid_paisTipoTributario(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTributarioBeanSwingJInternalFrame tipotributarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipotributarioBeanSwingJInternalFrame.jTtoolBarTipoTributario.setBorder(borderResaltar);
		
		this.resaltarid_paisTipoTributario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisTipoTributario() {
		return this.resaltarid_paisTipoTributario;
	}

	public void setResaltarid_paisTipoTributario(Border borderResaltar) {
		this.resaltarid_paisTipoTributario= borderResaltar;
	}

	public Boolean getMostrarid_paisTipoTributario() {
		return this.mostrarid_paisTipoTributario;
	}

	public void setMostrarid_paisTipoTributario(Boolean mostrarid_paisTipoTributario) {
		this.mostrarid_paisTipoTributario= mostrarid_paisTipoTributario;
	}

	public Boolean getActivarid_paisTipoTributario() {
		return this.activarid_paisTipoTributario;
	}

	public void setActivarid_paisTipoTributario(Boolean activarid_paisTipoTributario) {
		this.activarid_paisTipoTributario= activarid_paisTipoTributario;
	}

	public Boolean getCargarid_paisTipoTributario() {
		return this.cargarid_paisTipoTributario;
	}

	public void setCargarid_paisTipoTributario(Boolean cargarid_paisTipoTributario) {
		this.cargarid_paisTipoTributario= cargarid_paisTipoTributario;
	}

	public Border setResaltarcodigoTipoTributario(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTributarioBeanSwingJInternalFrame tipotributarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipotributarioBeanSwingJInternalFrame.jTtoolBarTipoTributario.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoTributario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoTributario() {
		return this.resaltarcodigoTipoTributario;
	}

	public void setResaltarcodigoTipoTributario(Border borderResaltar) {
		this.resaltarcodigoTipoTributario= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoTributario() {
		return this.mostrarcodigoTipoTributario;
	}

	public void setMostrarcodigoTipoTributario(Boolean mostrarcodigoTipoTributario) {
		this.mostrarcodigoTipoTributario= mostrarcodigoTipoTributario;
	}

	public Boolean getActivarcodigoTipoTributario() {
		return this.activarcodigoTipoTributario;
	}

	public void setActivarcodigoTipoTributario(Boolean activarcodigoTipoTributario) {
		this.activarcodigoTipoTributario= activarcodigoTipoTributario;
	}

	public Border setResaltarnombreTipoTributario(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTributarioBeanSwingJInternalFrame tipotributarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipotributarioBeanSwingJInternalFrame.jTtoolBarTipoTributario.setBorder(borderResaltar);
		
		this.resaltarnombreTipoTributario= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoTributario() {
		return this.resaltarnombreTipoTributario;
	}

	public void setResaltarnombreTipoTributario(Border borderResaltar) {
		this.resaltarnombreTipoTributario= borderResaltar;
	}

	public Boolean getMostrarnombreTipoTributario() {
		return this.mostrarnombreTipoTributario;
	}

	public void setMostrarnombreTipoTributario(Boolean mostrarnombreTipoTributario) {
		this.mostrarnombreTipoTributario= mostrarnombreTipoTributario;
	}

	public Boolean getActivarnombreTipoTributario() {
		return this.activarnombreTipoTributario;
	}

	public void setActivarnombreTipoTributario(Boolean activarnombreTipoTributario) {
		this.activarnombreTipoTributario= activarnombreTipoTributario;
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
		
		
		this.setMostraridTipoTributario(esInicial);
		this.setMostrarid_paisTipoTributario(esInicial);
		this.setMostrarcodigoTipoTributario(esInicial);
		this.setMostrarnombreTipoTributario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoTributarioConstantesFunciones.ID)) {
				this.setMostraridTipoTributario(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTributarioConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisTipoTributario(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTributarioConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoTributario(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTributarioConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoTributario(esAsigna);
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
		
		
		this.setActivaridTipoTributario(esInicial);
		this.setActivarid_paisTipoTributario(esInicial);
		this.setActivarcodigoTipoTributario(esInicial);
		this.setActivarnombreTipoTributario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoTributarioConstantesFunciones.ID)) {
				this.setActivaridTipoTributario(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTributarioConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisTipoTributario(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTributarioConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoTributario(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTributarioConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoTributario(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoTributarioBeanSwingJInternalFrame tipotributarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoTributario(esInicial);
		this.setResaltarid_paisTipoTributario(esInicial);
		this.setResaltarcodigoTipoTributario(esInicial);
		this.setResaltarnombreTipoTributario(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoTributarioConstantesFunciones.ID)) {
				this.setResaltaridTipoTributario(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTributarioConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisTipoTributario(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTributarioConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoTributario(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoTributarioConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoTributario(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarTransaccionLocalTipoTributario=null;

	public Border getResaltarTransaccionLocalTipoTributario() {
		return this.resaltarTransaccionLocalTipoTributario;
	}

	public void setResaltarTransaccionLocalTipoTributario(Border borderResaltarTransaccionLocal) {
		if(borderResaltarTransaccionLocal!=null) {
			this.resaltarTransaccionLocalTipoTributario= borderResaltarTransaccionLocal;
		}
	}

	public Border setResaltarTransaccionLocalTipoTributario(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTributarioBeanSwingJInternalFrame tipotributarioBeanSwingJInternalFrame*/) {
		Border borderResaltarTransaccionLocal=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipotributarioBeanSwingJInternalFrame.jTtoolBarTipoTributario.setBorder(borderResaltarTransaccionLocal);
			
		this.resaltarTransaccionLocalTipoTributario= borderResaltarTransaccionLocal;

		 return borderResaltarTransaccionLocal;
	}



	public Boolean mostrarTransaccionLocalTipoTributario=true;

	public Boolean getMostrarTransaccionLocalTipoTributario() {
		return this.mostrarTransaccionLocalTipoTributario;
	}

	public void setMostrarTransaccionLocalTipoTributario(Boolean visibilidadResaltarTransaccionLocal) {
		this.mostrarTransaccionLocalTipoTributario= visibilidadResaltarTransaccionLocal;
	}



	public Boolean activarTransaccionLocalTipoTributario=true;

	public Boolean gethabilitarResaltarTransaccionLocalTipoTributario() {
		return this.activarTransaccionLocalTipoTributario;
	}

	public void setActivarTransaccionLocalTipoTributario(Boolean habilitarResaltarTransaccionLocal) {
		this.activarTransaccionLocalTipoTributario= habilitarResaltarTransaccionLocal;
	}


	public Border resaltarFacturaProveedorServicioTipoTributario=null;

	public Border getResaltarFacturaProveedorServicioTipoTributario() {
		return this.resaltarFacturaProveedorServicioTipoTributario;
	}

	public void setResaltarFacturaProveedorServicioTipoTributario(Border borderResaltarFacturaProveedorServicio) {
		if(borderResaltarFacturaProveedorServicio!=null) {
			this.resaltarFacturaProveedorServicioTipoTributario= borderResaltarFacturaProveedorServicio;
		}
	}

	public Border setResaltarFacturaProveedorServicioTipoTributario(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTributarioBeanSwingJInternalFrame tipotributarioBeanSwingJInternalFrame*/) {
		Border borderResaltarFacturaProveedorServicio=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipotributarioBeanSwingJInternalFrame.jTtoolBarTipoTributario.setBorder(borderResaltarFacturaProveedorServicio);
			
		this.resaltarFacturaProveedorServicioTipoTributario= borderResaltarFacturaProveedorServicio;

		 return borderResaltarFacturaProveedorServicio;
	}



	public Boolean mostrarFacturaProveedorServicioTipoTributario=true;

	public Boolean getMostrarFacturaProveedorServicioTipoTributario() {
		return this.mostrarFacturaProveedorServicioTipoTributario;
	}

	public void setMostrarFacturaProveedorServicioTipoTributario(Boolean visibilidadResaltarFacturaProveedorServicio) {
		this.mostrarFacturaProveedorServicioTipoTributario= visibilidadResaltarFacturaProveedorServicio;
	}



	public Boolean activarFacturaProveedorServicioTipoTributario=true;

	public Boolean gethabilitarResaltarFacturaProveedorServicioTipoTributario() {
		return this.activarFacturaProveedorServicioTipoTributario;
	}

	public void setActivarFacturaProveedorServicioTipoTributario(Boolean habilitarResaltarFacturaProveedorServicio) {
		this.activarFacturaProveedorServicioTipoTributario= habilitarResaltarFacturaProveedorServicio;
	}


	public Border resaltarDefinicionTipoTributario=null;

	public Border getResaltarDefinicionTipoTributario() {
		return this.resaltarDefinicionTipoTributario;
	}

	public void setResaltarDefinicionTipoTributario(Border borderResaltarDefinicion) {
		if(borderResaltarDefinicion!=null) {
			this.resaltarDefinicionTipoTributario= borderResaltarDefinicion;
		}
	}

	public Border setResaltarDefinicionTipoTributario(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTributarioBeanSwingJInternalFrame tipotributarioBeanSwingJInternalFrame*/) {
		Border borderResaltarDefinicion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipotributarioBeanSwingJInternalFrame.jTtoolBarTipoTributario.setBorder(borderResaltarDefinicion);
			
		this.resaltarDefinicionTipoTributario= borderResaltarDefinicion;

		 return borderResaltarDefinicion;
	}



	public Boolean mostrarDefinicionTipoTributario=true;

	public Boolean getMostrarDefinicionTipoTributario() {
		return this.mostrarDefinicionTipoTributario;
	}

	public void setMostrarDefinicionTipoTributario(Boolean visibilidadResaltarDefinicion) {
		this.mostrarDefinicionTipoTributario= visibilidadResaltarDefinicion;
	}



	public Boolean activarDefinicionTipoTributario=true;

	public Boolean gethabilitarResaltarDefinicionTipoTributario() {
		return this.activarDefinicionTipoTributario;
	}

	public void setActivarDefinicionTipoTributario(Boolean habilitarResaltarDefinicion) {
		this.activarDefinicionTipoTributario= habilitarResaltarDefinicion;
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

		this.setMostrarTransaccionLocalTipoTributario(esInicial);
		this.setMostrarFacturaProveedorServicioTipoTributario(esInicial);
		this.setMostrarDefinicionTipoTributario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TransaccionLocal.class)) {
				this.setMostrarTransaccionLocalTipoTributario(esAsigna);
				continue;
			}

			if(clase.clas.equals(FacturaProveedorServicio.class)) {
				this.setMostrarFacturaProveedorServicioTipoTributario(esAsigna);
				continue;
			}

			if(clase.clas.equals(Definicion.class)) {
				this.setMostrarDefinicionTipoTributario(esAsigna);
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

		this.setActivarTransaccionLocalTipoTributario(esInicial);
		this.setActivarFacturaProveedorServicioTipoTributario(esInicial);
		this.setActivarDefinicionTipoTributario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TransaccionLocal.class)) {
				this.setActivarTransaccionLocalTipoTributario(esAsigna);
				continue;
			}

			if(clase.clas.equals(FacturaProveedorServicio.class)) {
				this.setActivarFacturaProveedorServicioTipoTributario(esAsigna);
				continue;
			}

			if(clase.clas.equals(Definicion.class)) {
				this.setActivarDefinicionTipoTributario(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoTributarioBeanSwingJInternalFrame tipotributarioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarTransaccionLocalTipoTributario(esInicial);
		this.setResaltarFacturaProveedorServicioTipoTributario(esInicial);
		this.setResaltarDefinicionTipoTributario(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TransaccionLocal.class)) {
				this.setResaltarTransaccionLocalTipoTributario(esAsigna);
				continue;
			}

			if(clase.clas.equals(FacturaProveedorServicio.class)) {
				this.setResaltarFacturaProveedorServicioTipoTributario(esAsigna);
				continue;
			}

			if(clase.clas.equals(Definicion.class)) {
				this.setResaltarDefinicionTipoTributario(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoTipoTributario=true;

	public Boolean getMostrarBusquedaPorCodigoTipoTributario() {
		return this.mostrarBusquedaPorCodigoTipoTributario;
	}

	public void setMostrarBusquedaPorCodigoTipoTributario(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTipoTributario= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorIdTipoTributario=true;

	public Boolean getMostrarBusquedaPorIdTipoTributario() {
		return this.mostrarBusquedaPorIdTipoTributario;
	}

	public void setMostrarBusquedaPorIdTipoTributario(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdTipoTributario= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoTributario=true;

	public Boolean getMostrarBusquedaPorNombreTipoTributario() {
		return this.mostrarBusquedaPorNombreTipoTributario;
	}

	public void setMostrarBusquedaPorNombreTipoTributario(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoTributario= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisTipoTributario=true;

	public Boolean getMostrarFK_IdPaisTipoTributario() {
		return this.mostrarFK_IdPaisTipoTributario;
	}

	public void setMostrarFK_IdPaisTipoTributario(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisTipoTributario= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTipoTributario=true;

	public Boolean getActivarBusquedaPorCodigoTipoTributario() {
		return this.activarBusquedaPorCodigoTipoTributario;
	}

	public void setActivarBusquedaPorCodigoTipoTributario(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTipoTributario= habilitarResaltar;
	}

	public Boolean activarBusquedaPorIdTipoTributario=true;

	public Boolean getActivarBusquedaPorIdTipoTributario() {
		return this.activarBusquedaPorIdTipoTributario;
	}

	public void setActivarBusquedaPorIdTipoTributario(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdTipoTributario= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoTributario=true;

	public Boolean getActivarBusquedaPorNombreTipoTributario() {
		return this.activarBusquedaPorNombreTipoTributario;
	}

	public void setActivarBusquedaPorNombreTipoTributario(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoTributario= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisTipoTributario=true;

	public Boolean getActivarFK_IdPaisTipoTributario() {
		return this.activarFK_IdPaisTipoTributario;
	}

	public void setActivarFK_IdPaisTipoTributario(Boolean habilitarResaltar) {
		this.activarFK_IdPaisTipoTributario= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTipoTributario=null;

	public Border getResaltarBusquedaPorCodigoTipoTributario() {
		return this.resaltarBusquedaPorCodigoTipoTributario;
	}

	public void setResaltarBusquedaPorCodigoTipoTributario(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTipoTributario= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTipoTributario(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTributarioBeanSwingJInternalFrame tipotributarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTipoTributario= borderResaltar;
	}

	public Border resaltarBusquedaPorIdTipoTributario=null;

	public Border getResaltarBusquedaPorIdTipoTributario() {
		return this.resaltarBusquedaPorIdTipoTributario;
	}

	public void setResaltarBusquedaPorIdTipoTributario(Border borderResaltar) {
		this.resaltarBusquedaPorIdTipoTributario= borderResaltar;
	}

	public void setResaltarBusquedaPorIdTipoTributario(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTributarioBeanSwingJInternalFrame tipotributarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdTipoTributario= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoTributario=null;

	public Border getResaltarBusquedaPorNombreTipoTributario() {
		return this.resaltarBusquedaPorNombreTipoTributario;
	}

	public void setResaltarBusquedaPorNombreTipoTributario(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoTributario= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoTributario(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTributarioBeanSwingJInternalFrame tipotributarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoTributario= borderResaltar;
	}

	public Border resaltarFK_IdPaisTipoTributario=null;

	public Border getResaltarFK_IdPaisTipoTributario() {
		return this.resaltarFK_IdPaisTipoTributario;
	}

	public void setResaltarFK_IdPaisTipoTributario(Border borderResaltar) {
		this.resaltarFK_IdPaisTipoTributario= borderResaltar;
	}

	public void setResaltarFK_IdPaisTipoTributario(ParametroGeneralUsuario parametroGeneralUsuario/*TipoTributarioBeanSwingJInternalFrame tipotributarioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisTipoTributario= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}