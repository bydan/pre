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


import com.bydan.erp.contabilidad.util.TipoMovimientoModuloConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoMovimientoModuloParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoMovimientoModuloParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.puntoventa.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoMovimientoModuloConstantesFunciones extends TipoMovimientoModuloConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoMovimientoModulo";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoMovimientoModulo"+TipoMovimientoModuloConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoMovimientoModuloHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoMovimientoModuloHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoMovimientoModuloConstantesFunciones.SCHEMA+"_"+TipoMovimientoModuloConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoMovimientoModuloHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoMovimientoModuloConstantesFunciones.SCHEMA+"_"+TipoMovimientoModuloConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoMovimientoModuloConstantesFunciones.SCHEMA+"_"+TipoMovimientoModuloConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoMovimientoModuloHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoMovimientoModuloConstantesFunciones.SCHEMA+"_"+TipoMovimientoModuloConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMovimientoModuloConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoMovimientoModuloHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMovimientoModuloConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMovimientoModuloConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoMovimientoModuloHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMovimientoModuloConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoMovimientoModuloConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoMovimientoModuloConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoMovimientoModuloConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoMovimientoModuloConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Movimiento Modulos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Movimiento Modulo";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Movimiento Modulo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoMovimientoModulo";
	public static final String OBJECTNAME="tipomovimientomodulo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="tipo_movimiento_modulo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipomovimientomodulo from "+TipoMovimientoModuloConstantesFunciones.SPERSISTENCENAME+" tipomovimientomodulo";
	public static String QUERYSELECTNATIVE="select "+TipoMovimientoModuloConstantesFunciones.SCHEMA+"."+TipoMovimientoModuloConstantesFunciones.TABLENAME+".id,"+TipoMovimientoModuloConstantesFunciones.SCHEMA+"."+TipoMovimientoModuloConstantesFunciones.TABLENAME+".version_row,"+TipoMovimientoModuloConstantesFunciones.SCHEMA+"."+TipoMovimientoModuloConstantesFunciones.TABLENAME+".id_modulo,"+TipoMovimientoModuloConstantesFunciones.SCHEMA+"."+TipoMovimientoModuloConstantesFunciones.TABLENAME+".codigo,"+TipoMovimientoModuloConstantesFunciones.SCHEMA+"."+TipoMovimientoModuloConstantesFunciones.TABLENAME+".nombre from "+TipoMovimientoModuloConstantesFunciones.SCHEMA+"."+TipoMovimientoModuloConstantesFunciones.TABLENAME;//+" as "+TipoMovimientoModuloConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoMovimientoModuloConstantesFuncionesAdditional tipomovimientomoduloConstantesFuncionesAdditional=null;
	
	public TipoMovimientoModuloConstantesFuncionesAdditional getTipoMovimientoModuloConstantesFuncionesAdditional() {
		return this.tipomovimientomoduloConstantesFuncionesAdditional;
	}
	
	public void setTipoMovimientoModuloConstantesFuncionesAdditional(TipoMovimientoModuloConstantesFuncionesAdditional tipomovimientomoduloConstantesFuncionesAdditional) {
		try {
			this.tipomovimientomoduloConstantesFuncionesAdditional=tipomovimientomoduloConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDMODULO= "id_modulo";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoMovimientoModuloLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoMovimientoModuloConstantesFunciones.IDMODULO)) {sLabelColumna=TipoMovimientoModuloConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(TipoMovimientoModuloConstantesFunciones.CODIGO)) {sLabelColumna=TipoMovimientoModuloConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoMovimientoModuloConstantesFunciones.NOMBRE)) {sLabelColumna=TipoMovimientoModuloConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoMovimientoModuloDescripcion(TipoMovimientoModulo tipomovimientomodulo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipomovimientomodulo !=null/* && tipomovimientomodulo.getId()!=0*/) {
			sDescripcion=tipomovimientomodulo.getnombre();//tipomovimientomodulotipomovimientomodulo.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoMovimientoModuloDescripcionDetallado(TipoMovimientoModulo tipomovimientomodulo) {
		String sDescripcion="";
			
		sDescripcion+=TipoMovimientoModuloConstantesFunciones.ID+"=";
		sDescripcion+=tipomovimientomodulo.getId().toString()+",";
		sDescripcion+=TipoMovimientoModuloConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipomovimientomodulo.getVersionRow().toString()+",";
		sDescripcion+=TipoMovimientoModuloConstantesFunciones.IDMODULO+"=";
		sDescripcion+=tipomovimientomodulo.getid_modulo().toString()+",";
		sDescripcion+=TipoMovimientoModuloConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipomovimientomodulo.getcodigo()+",";
		sDescripcion+=TipoMovimientoModuloConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipomovimientomodulo.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoMovimientoModuloDescripcion(TipoMovimientoModulo tipomovimientomodulo,String sValor) throws Exception {			
		if(tipomovimientomodulo !=null) {
			tipomovimientomodulo.setnombre(sValor);;//tipomovimientomodulotipomovimientomodulo.getnombre().trim();
		}		
	}
	
		

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
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
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("PorIdModuloPorCodigo")) {
			sNombreIndice="Tipo=  Por Modulo Por Codigo";
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

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorIdModuloPorCodigo(Long id_modulo,String codigo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();}
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoMovimientoModulo(TipoMovimientoModulo tipomovimientomodulo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipomovimientomodulo.setcodigo(tipomovimientomodulo.getcodigo().trim());
		tipomovimientomodulo.setnombre(tipomovimientomodulo.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoMovimientoModulos(List<TipoMovimientoModulo> tipomovimientomodulos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoMovimientoModulo tipomovimientomodulo: tipomovimientomodulos) {
			tipomovimientomodulo.setcodigo(tipomovimientomodulo.getcodigo().trim());
			tipomovimientomodulo.setnombre(tipomovimientomodulo.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoMovimientoModulo(TipoMovimientoModulo tipomovimientomodulo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipomovimientomodulo.getConCambioAuxiliar()) {
			tipomovimientomodulo.setIsDeleted(tipomovimientomodulo.getIsDeletedAuxiliar());	
			tipomovimientomodulo.setIsNew(tipomovimientomodulo.getIsNewAuxiliar());	
			tipomovimientomodulo.setIsChanged(tipomovimientomodulo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipomovimientomodulo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipomovimientomodulo.setIsDeletedAuxiliar(false);	
			tipomovimientomodulo.setIsNewAuxiliar(false);	
			tipomovimientomodulo.setIsChangedAuxiliar(false);
			
			tipomovimientomodulo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoMovimientoModulos(List<TipoMovimientoModulo> tipomovimientomodulos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoMovimientoModulo tipomovimientomodulo : tipomovimientomodulos) {
			if(conAsignarBase && tipomovimientomodulo.getConCambioAuxiliar()) {
				tipomovimientomodulo.setIsDeleted(tipomovimientomodulo.getIsDeletedAuxiliar());	
				tipomovimientomodulo.setIsNew(tipomovimientomodulo.getIsNewAuxiliar());	
				tipomovimientomodulo.setIsChanged(tipomovimientomodulo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipomovimientomodulo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipomovimientomodulo.setIsDeletedAuxiliar(false);	
				tipomovimientomodulo.setIsNewAuxiliar(false);	
				tipomovimientomodulo.setIsChangedAuxiliar(false);
				
				tipomovimientomodulo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoMovimientoModulo(TipoMovimientoModulo tipomovimientomodulo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoMovimientoModulos(List<TipoMovimientoModulo> tipomovimientomodulos,Boolean conEnteros) throws Exception  {
		
		for(TipoMovimientoModulo tipomovimientomodulo: tipomovimientomodulos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoMovimientoModulo(List<TipoMovimientoModulo> tipomovimientomodulos,TipoMovimientoModulo tipomovimientomoduloAux) throws Exception  {
		TipoMovimientoModuloConstantesFunciones.InicializarValoresTipoMovimientoModulo(tipomovimientomoduloAux,true);
		
		for(TipoMovimientoModulo tipomovimientomodulo: tipomovimientomodulos) {
			if(tipomovimientomodulo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoMovimientoModulo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoMovimientoModuloConstantesFunciones.getArrayColumnasGlobalesTipoMovimientoModulo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoMovimientoModulo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoMovimientoModuloConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoMovimientoModuloConstantesFunciones.IDMODULO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoMovimientoModulo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(TipoMovimientoModuloConstantesFunciones.IDMODULO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoMovimientoModulo> tipomovimientomodulos,TipoMovimientoModulo tipomovimientomodulo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoMovimientoModulo tipomovimientomoduloAux: tipomovimientomodulos) {
			if(tipomovimientomoduloAux!=null && tipomovimientomodulo!=null) {
				if((tipomovimientomoduloAux.getId()==null && tipomovimientomodulo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipomovimientomoduloAux.getId()!=null && tipomovimientomodulo.getId()!=null){
					if(tipomovimientomoduloAux.getId().equals(tipomovimientomodulo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoMovimientoModulo(List<TipoMovimientoModulo> tipomovimientomodulos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoMovimientoModulo tipomovimientomodulo: tipomovimientomodulos) {			
			if(tipomovimientomodulo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoMovimientoModulo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoMovimientoModuloConstantesFunciones.LABEL_ID, TipoMovimientoModuloConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMovimientoModuloConstantesFunciones.LABEL_VERSIONROW, TipoMovimientoModuloConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMovimientoModuloConstantesFunciones.LABEL_IDMODULO, TipoMovimientoModuloConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMovimientoModuloConstantesFunciones.LABEL_CODIGO, TipoMovimientoModuloConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMovimientoModuloConstantesFunciones.LABEL_NOMBRE, TipoMovimientoModuloConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoMovimientoModulo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoMovimientoModuloConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMovimientoModuloConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMovimientoModuloConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMovimientoModuloConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMovimientoModuloConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoMovimientoModulo() throws Exception  {
		return TipoMovimientoModuloConstantesFunciones.getTiposSeleccionarTipoMovimientoModulo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoMovimientoModulo(Boolean conFk) throws Exception  {
		return TipoMovimientoModuloConstantesFunciones.getTiposSeleccionarTipoMovimientoModulo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoMovimientoModulo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMovimientoModuloConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(TipoMovimientoModuloConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMovimientoModuloConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoMovimientoModuloConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMovimientoModuloConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoMovimientoModuloConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoMovimientoModulo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoMovimientoModulo(TipoMovimientoModulo tipomovimientomoduloAux) throws Exception {
		
			tipomovimientomoduloAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(tipomovimientomoduloAux.getModulo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoMovimientoModulo(List<TipoMovimientoModulo> tipomovimientomodulosTemp) throws Exception {
		for(TipoMovimientoModulo tipomovimientomoduloAux:tipomovimientomodulosTemp) {
			
			tipomovimientomoduloAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(tipomovimientomoduloAux.getModulo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoMovimientoModulo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Modulo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoMovimientoModulo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoMovimientoModulo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoMovimientoModuloConstantesFunciones.getClassesRelationshipsOfTipoMovimientoModulo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoMovimientoModulo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ParametroCompra.class));
				classes.add(new Classe(FacturaProveedor.class));
				classes.add(new Classe(AsientoContableCajaChica.class));
				classes.add(new Classe(FacturaProveedorServicio.class));
				classes.add(new Classe(Secuencial.class));
				classes.add(new Classe(AsientoContable.class));
				classes.add(new Classe(TipoDocumento.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroCompra.class)) {
						classes.add(new Classe(ParametroCompra.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FacturaProveedor.class)) {
						classes.add(new Classe(FacturaProveedor.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AsientoContableCajaChica.class)) {
						classes.add(new Classe(AsientoContableCajaChica.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FacturaProveedorServicio.class)) {
						classes.add(new Classe(FacturaProveedorServicio.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Secuencial.class)) {
						classes.add(new Classe(Secuencial.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AsientoContable.class)) {
						classes.add(new Classe(AsientoContable.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDocumento.class)) {
						classes.add(new Classe(TipoDocumento.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoMovimientoModulo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoMovimientoModuloConstantesFunciones.getClassesRelationshipsFromStringsOfTipoMovimientoModulo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoMovimientoModulo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCompra.class)); continue;
					}

					if(FacturaProveedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaProveedor.class)); continue;
					}

					if(AsientoContableCajaChica.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContableCajaChica.class)); continue;
					}

					if(FacturaProveedorServicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaProveedorServicio.class)); continue;
					}

					if(Secuencial.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Secuencial.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCompra.class)); continue;
					}

					if(FacturaProveedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaProveedor.class)); continue;
					}

					if(AsientoContableCajaChica.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContableCajaChica.class)); continue;
					}

					if(FacturaProveedorServicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaProveedorServicio.class)); continue;
					}

					if(Secuencial.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Secuencial.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
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
	public static void actualizarLista(TipoMovimientoModulo tipomovimientomodulo,List<TipoMovimientoModulo> tipomovimientomodulos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoMovimientoModulo tipomovimientomoduloEncontrado=null;
			
			for(TipoMovimientoModulo tipomovimientomoduloLocal:tipomovimientomodulos) {
				if(tipomovimientomoduloLocal.getId().equals(tipomovimientomodulo.getId())) {
					tipomovimientomoduloEncontrado=tipomovimientomoduloLocal;
					
					tipomovimientomoduloLocal.setIsChanged(tipomovimientomodulo.getIsChanged());
					tipomovimientomoduloLocal.setIsNew(tipomovimientomodulo.getIsNew());
					tipomovimientomoduloLocal.setIsDeleted(tipomovimientomodulo.getIsDeleted());
					
					tipomovimientomoduloLocal.setGeneralEntityOriginal(tipomovimientomodulo.getGeneralEntityOriginal());
					
					tipomovimientomoduloLocal.setId(tipomovimientomodulo.getId());	
					tipomovimientomoduloLocal.setVersionRow(tipomovimientomodulo.getVersionRow());	
					tipomovimientomoduloLocal.setid_modulo(tipomovimientomodulo.getid_modulo());	
					tipomovimientomoduloLocal.setcodigo(tipomovimientomodulo.getcodigo());	
					tipomovimientomoduloLocal.setnombre(tipomovimientomodulo.getnombre());	
					
					
					tipomovimientomoduloLocal.setParametroCompras(tipomovimientomodulo.getParametroCompras());
					tipomovimientomoduloLocal.setFacturaProveedorServicios(tipomovimientomodulo.getFacturaProveedorServicios());
					tipomovimientomoduloLocal.setSecuencials(tipomovimientomodulo.getSecuencials());
					tipomovimientomoduloLocal.setTipoDocumentos(tipomovimientomodulo.getTipoDocumentos());
					
					existe=true;
					break;
				}
			}
			
			if(!tipomovimientomodulo.getIsDeleted()) {
				if(!existe) {
					tipomovimientomodulos.add(tipomovimientomodulo);
				}
			} else {
				if(tipomovimientomoduloEncontrado!=null && permiteQuitar)  {
					tipomovimientomodulos.remove(tipomovimientomoduloEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoMovimientoModulo tipomovimientomodulo,List<TipoMovimientoModulo> tipomovimientomodulos) throws Exception {
		try	{			
			for(TipoMovimientoModulo tipomovimientomoduloLocal:tipomovimientomodulos) {
				if(tipomovimientomoduloLocal.getId().equals(tipomovimientomodulo.getId())) {
					tipomovimientomoduloLocal.setIsSelected(tipomovimientomodulo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoMovimientoModulo(List<TipoMovimientoModulo> tipomovimientomodulosAux) throws Exception {
		//this.tipomovimientomodulosAux=tipomovimientomodulosAux;
		
		for(TipoMovimientoModulo tipomovimientomoduloAux:tipomovimientomodulosAux) {
			if(tipomovimientomoduloAux.getIsChanged()) {
				tipomovimientomoduloAux.setIsChanged(false);
			}		
			
			if(tipomovimientomoduloAux.getIsNew()) {
				tipomovimientomoduloAux.setIsNew(false);
			}	
			
			if(tipomovimientomoduloAux.getIsDeleted()) {
				tipomovimientomoduloAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoMovimientoModulo(TipoMovimientoModulo tipomovimientomoduloAux) throws Exception {
		//this.tipomovimientomoduloAux=tipomovimientomoduloAux;
		
			if(tipomovimientomoduloAux.getIsChanged()) {
				tipomovimientomoduloAux.setIsChanged(false);
			}		
			
			if(tipomovimientomoduloAux.getIsNew()) {
				tipomovimientomoduloAux.setIsNew(false);
			}	
			
			if(tipomovimientomoduloAux.getIsDeleted()) {
				tipomovimientomoduloAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoMovimientoModulo tipomovimientomoduloAsignar,TipoMovimientoModulo tipomovimientomodulo) throws Exception {
		tipomovimientomoduloAsignar.setId(tipomovimientomodulo.getId());	
		tipomovimientomoduloAsignar.setVersionRow(tipomovimientomodulo.getVersionRow());	
		tipomovimientomoduloAsignar.setid_modulo(tipomovimientomodulo.getid_modulo());
		tipomovimientomoduloAsignar.setmodulo_descripcion(tipomovimientomodulo.getmodulo_descripcion());	
		tipomovimientomoduloAsignar.setcodigo(tipomovimientomodulo.getcodigo());	
		tipomovimientomoduloAsignar.setnombre(tipomovimientomodulo.getnombre());	
	}
	
	public static void inicializarTipoMovimientoModulo(TipoMovimientoModulo tipomovimientomodulo) throws Exception {
		try {
				tipomovimientomodulo.setId(0L);	
					
				tipomovimientomodulo.setid_modulo(-1L);	
				tipomovimientomodulo.setcodigo("");	
				tipomovimientomodulo.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoMovimientoModulo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMovimientoModuloConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMovimientoModuloConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMovimientoModuloConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoMovimientoModulo(String sTipo,Row row,Workbook workbook,TipoMovimientoModulo tipomovimientomodulo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomovimientomodulo.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomovimientomodulo.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomovimientomodulo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoMovimientoModulo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoMovimientoModulo() {
		return this.sFinalQueryTipoMovimientoModulo;
	}
	
	public void setsFinalQueryTipoMovimientoModulo(String sFinalQueryTipoMovimientoModulo) {
		this.sFinalQueryTipoMovimientoModulo= sFinalQueryTipoMovimientoModulo;
	}
	
	public Border resaltarSeleccionarTipoMovimientoModulo=null;
	
	public Border setResaltarSeleccionarTipoMovimientoModulo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMovimientoModuloBeanSwingJInternalFrame tipomovimientomoduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipomovimientomoduloBeanSwingJInternalFrame.jTtoolBarTipoMovimientoModulo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoMovimientoModulo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoMovimientoModulo() {
		return this.resaltarSeleccionarTipoMovimientoModulo;
	}
	
	public void setResaltarSeleccionarTipoMovimientoModulo(Border borderResaltarSeleccionarTipoMovimientoModulo) {
		this.resaltarSeleccionarTipoMovimientoModulo= borderResaltarSeleccionarTipoMovimientoModulo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoMovimientoModulo=null;
	public Boolean mostraridTipoMovimientoModulo=true;
	public Boolean activaridTipoMovimientoModulo=true;

	public Border resaltarid_moduloTipoMovimientoModulo=null;
	public Boolean mostrarid_moduloTipoMovimientoModulo=true;
	public Boolean activarid_moduloTipoMovimientoModulo=true;
	public Boolean cargarid_moduloTipoMovimientoModulo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloTipoMovimientoModulo=false;//ConEventDepend=true

	public Border resaltarcodigoTipoMovimientoModulo=null;
	public Boolean mostrarcodigoTipoMovimientoModulo=true;
	public Boolean activarcodigoTipoMovimientoModulo=true;

	public Border resaltarnombreTipoMovimientoModulo=null;
	public Boolean mostrarnombreTipoMovimientoModulo=true;
	public Boolean activarnombreTipoMovimientoModulo=true;

	
	

	public Border setResaltaridTipoMovimientoModulo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMovimientoModuloBeanSwingJInternalFrame tipomovimientomoduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomovimientomoduloBeanSwingJInternalFrame.jTtoolBarTipoMovimientoModulo.setBorder(borderResaltar);
		
		this.resaltaridTipoMovimientoModulo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoMovimientoModulo() {
		return this.resaltaridTipoMovimientoModulo;
	}

	public void setResaltaridTipoMovimientoModulo(Border borderResaltar) {
		this.resaltaridTipoMovimientoModulo= borderResaltar;
	}

	public Boolean getMostraridTipoMovimientoModulo() {
		return this.mostraridTipoMovimientoModulo;
	}

	public void setMostraridTipoMovimientoModulo(Boolean mostraridTipoMovimientoModulo) {
		this.mostraridTipoMovimientoModulo= mostraridTipoMovimientoModulo;
	}

	public Boolean getActivaridTipoMovimientoModulo() {
		return this.activaridTipoMovimientoModulo;
	}

	public void setActivaridTipoMovimientoModulo(Boolean activaridTipoMovimientoModulo) {
		this.activaridTipoMovimientoModulo= activaridTipoMovimientoModulo;
	}

	public Border setResaltarid_moduloTipoMovimientoModulo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMovimientoModuloBeanSwingJInternalFrame tipomovimientomoduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomovimientomoduloBeanSwingJInternalFrame.jTtoolBarTipoMovimientoModulo.setBorder(borderResaltar);
		
		this.resaltarid_moduloTipoMovimientoModulo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloTipoMovimientoModulo() {
		return this.resaltarid_moduloTipoMovimientoModulo;
	}

	public void setResaltarid_moduloTipoMovimientoModulo(Border borderResaltar) {
		this.resaltarid_moduloTipoMovimientoModulo= borderResaltar;
	}

	public Boolean getMostrarid_moduloTipoMovimientoModulo() {
		return this.mostrarid_moduloTipoMovimientoModulo;
	}

	public void setMostrarid_moduloTipoMovimientoModulo(Boolean mostrarid_moduloTipoMovimientoModulo) {
		this.mostrarid_moduloTipoMovimientoModulo= mostrarid_moduloTipoMovimientoModulo;
	}

	public Boolean getActivarid_moduloTipoMovimientoModulo() {
		return this.activarid_moduloTipoMovimientoModulo;
	}

	public void setActivarid_moduloTipoMovimientoModulo(Boolean activarid_moduloTipoMovimientoModulo) {
		this.activarid_moduloTipoMovimientoModulo= activarid_moduloTipoMovimientoModulo;
	}

	public Boolean getCargarid_moduloTipoMovimientoModulo() {
		return this.cargarid_moduloTipoMovimientoModulo;
	}

	public void setCargarid_moduloTipoMovimientoModulo(Boolean cargarid_moduloTipoMovimientoModulo) {
		this.cargarid_moduloTipoMovimientoModulo= cargarid_moduloTipoMovimientoModulo;
	}

	public Border setResaltarcodigoTipoMovimientoModulo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMovimientoModuloBeanSwingJInternalFrame tipomovimientomoduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomovimientomoduloBeanSwingJInternalFrame.jTtoolBarTipoMovimientoModulo.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoMovimientoModulo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoMovimientoModulo() {
		return this.resaltarcodigoTipoMovimientoModulo;
	}

	public void setResaltarcodigoTipoMovimientoModulo(Border borderResaltar) {
		this.resaltarcodigoTipoMovimientoModulo= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoMovimientoModulo() {
		return this.mostrarcodigoTipoMovimientoModulo;
	}

	public void setMostrarcodigoTipoMovimientoModulo(Boolean mostrarcodigoTipoMovimientoModulo) {
		this.mostrarcodigoTipoMovimientoModulo= mostrarcodigoTipoMovimientoModulo;
	}

	public Boolean getActivarcodigoTipoMovimientoModulo() {
		return this.activarcodigoTipoMovimientoModulo;
	}

	public void setActivarcodigoTipoMovimientoModulo(Boolean activarcodigoTipoMovimientoModulo) {
		this.activarcodigoTipoMovimientoModulo= activarcodigoTipoMovimientoModulo;
	}

	public Border setResaltarnombreTipoMovimientoModulo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMovimientoModuloBeanSwingJInternalFrame tipomovimientomoduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomovimientomoduloBeanSwingJInternalFrame.jTtoolBarTipoMovimientoModulo.setBorder(borderResaltar);
		
		this.resaltarnombreTipoMovimientoModulo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoMovimientoModulo() {
		return this.resaltarnombreTipoMovimientoModulo;
	}

	public void setResaltarnombreTipoMovimientoModulo(Border borderResaltar) {
		this.resaltarnombreTipoMovimientoModulo= borderResaltar;
	}

	public Boolean getMostrarnombreTipoMovimientoModulo() {
		return this.mostrarnombreTipoMovimientoModulo;
	}

	public void setMostrarnombreTipoMovimientoModulo(Boolean mostrarnombreTipoMovimientoModulo) {
		this.mostrarnombreTipoMovimientoModulo= mostrarnombreTipoMovimientoModulo;
	}

	public Boolean getActivarnombreTipoMovimientoModulo() {
		return this.activarnombreTipoMovimientoModulo;
	}

	public void setActivarnombreTipoMovimientoModulo(Boolean activarnombreTipoMovimientoModulo) {
		this.activarnombreTipoMovimientoModulo= activarnombreTipoMovimientoModulo;
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
		
		
		this.setMostraridTipoMovimientoModulo(esInicial);
		this.setMostrarid_moduloTipoMovimientoModulo(esInicial);
		this.setMostrarcodigoTipoMovimientoModulo(esInicial);
		this.setMostrarnombreTipoMovimientoModulo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoMovimientoModuloConstantesFunciones.ID)) {
				this.setMostraridTipoMovimientoModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMovimientoModuloConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloTipoMovimientoModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMovimientoModuloConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoMovimientoModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMovimientoModuloConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoMovimientoModulo(esAsigna);
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
		
		
		this.setActivaridTipoMovimientoModulo(esInicial);
		this.setActivarid_moduloTipoMovimientoModulo(esInicial);
		this.setActivarcodigoTipoMovimientoModulo(esInicial);
		this.setActivarnombreTipoMovimientoModulo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoMovimientoModuloConstantesFunciones.ID)) {
				this.setActivaridTipoMovimientoModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMovimientoModuloConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloTipoMovimientoModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMovimientoModuloConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoMovimientoModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMovimientoModuloConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoMovimientoModulo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoMovimientoModuloBeanSwingJInternalFrame tipomovimientomoduloBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoMovimientoModulo(esInicial);
		this.setResaltarid_moduloTipoMovimientoModulo(esInicial);
		this.setResaltarcodigoTipoMovimientoModulo(esInicial);
		this.setResaltarnombreTipoMovimientoModulo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoMovimientoModuloConstantesFunciones.ID)) {
				this.setResaltaridTipoMovimientoModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMovimientoModuloConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloTipoMovimientoModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMovimientoModuloConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoMovimientoModulo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMovimientoModuloConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoMovimientoModulo(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarParametroCompraTipoMovimientoModulo=null;

	public Border getResaltarParametroCompraTipoMovimientoModulo() {
		return this.resaltarParametroCompraTipoMovimientoModulo;
	}

	public void setResaltarParametroCompraTipoMovimientoModulo(Border borderResaltarParametroCompra) {
		if(borderResaltarParametroCompra!=null) {
			this.resaltarParametroCompraTipoMovimientoModulo= borderResaltarParametroCompra;
		}
	}

	public Border setResaltarParametroCompraTipoMovimientoModulo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMovimientoModuloBeanSwingJInternalFrame tipomovimientomoduloBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroCompra=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipomovimientomoduloBeanSwingJInternalFrame.jTtoolBarTipoMovimientoModulo.setBorder(borderResaltarParametroCompra);
			
		this.resaltarParametroCompraTipoMovimientoModulo= borderResaltarParametroCompra;

		 return borderResaltarParametroCompra;
	}



	public Boolean mostrarParametroCompraTipoMovimientoModulo=true;

	public Boolean getMostrarParametroCompraTipoMovimientoModulo() {
		return this.mostrarParametroCompraTipoMovimientoModulo;
	}

	public void setMostrarParametroCompraTipoMovimientoModulo(Boolean visibilidadResaltarParametroCompra) {
		this.mostrarParametroCompraTipoMovimientoModulo= visibilidadResaltarParametroCompra;
	}



	public Boolean activarParametroCompraTipoMovimientoModulo=true;

	public Boolean gethabilitarResaltarParametroCompraTipoMovimientoModulo() {
		return this.activarParametroCompraTipoMovimientoModulo;
	}

	public void setActivarParametroCompraTipoMovimientoModulo(Boolean habilitarResaltarParametroCompra) {
		this.activarParametroCompraTipoMovimientoModulo= habilitarResaltarParametroCompra;
	}


	public Border resaltarFacturaProveedorServicioTipoMovimientoModulo=null;

	public Border getResaltarFacturaProveedorServicioTipoMovimientoModulo() {
		return this.resaltarFacturaProveedorServicioTipoMovimientoModulo;
	}

	public void setResaltarFacturaProveedorServicioTipoMovimientoModulo(Border borderResaltarFacturaProveedorServicio) {
		if(borderResaltarFacturaProveedorServicio!=null) {
			this.resaltarFacturaProveedorServicioTipoMovimientoModulo= borderResaltarFacturaProveedorServicio;
		}
	}

	public Border setResaltarFacturaProveedorServicioTipoMovimientoModulo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMovimientoModuloBeanSwingJInternalFrame tipomovimientomoduloBeanSwingJInternalFrame*/) {
		Border borderResaltarFacturaProveedorServicio=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipomovimientomoduloBeanSwingJInternalFrame.jTtoolBarTipoMovimientoModulo.setBorder(borderResaltarFacturaProveedorServicio);
			
		this.resaltarFacturaProveedorServicioTipoMovimientoModulo= borderResaltarFacturaProveedorServicio;

		 return borderResaltarFacturaProveedorServicio;
	}



	public Boolean mostrarFacturaProveedorServicioTipoMovimientoModulo=true;

	public Boolean getMostrarFacturaProveedorServicioTipoMovimientoModulo() {
		return this.mostrarFacturaProveedorServicioTipoMovimientoModulo;
	}

	public void setMostrarFacturaProveedorServicioTipoMovimientoModulo(Boolean visibilidadResaltarFacturaProveedorServicio) {
		this.mostrarFacturaProveedorServicioTipoMovimientoModulo= visibilidadResaltarFacturaProveedorServicio;
	}



	public Boolean activarFacturaProveedorServicioTipoMovimientoModulo=true;

	public Boolean gethabilitarResaltarFacturaProveedorServicioTipoMovimientoModulo() {
		return this.activarFacturaProveedorServicioTipoMovimientoModulo;
	}

	public void setActivarFacturaProveedorServicioTipoMovimientoModulo(Boolean habilitarResaltarFacturaProveedorServicio) {
		this.activarFacturaProveedorServicioTipoMovimientoModulo= habilitarResaltarFacturaProveedorServicio;
	}


	public Border resaltarSecuencialTipoMovimientoModulo=null;

	public Border getResaltarSecuencialTipoMovimientoModulo() {
		return this.resaltarSecuencialTipoMovimientoModulo;
	}

	public void setResaltarSecuencialTipoMovimientoModulo(Border borderResaltarSecuencial) {
		if(borderResaltarSecuencial!=null) {
			this.resaltarSecuencialTipoMovimientoModulo= borderResaltarSecuencial;
		}
	}

	public Border setResaltarSecuencialTipoMovimientoModulo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMovimientoModuloBeanSwingJInternalFrame tipomovimientomoduloBeanSwingJInternalFrame*/) {
		Border borderResaltarSecuencial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipomovimientomoduloBeanSwingJInternalFrame.jTtoolBarTipoMovimientoModulo.setBorder(borderResaltarSecuencial);
			
		this.resaltarSecuencialTipoMovimientoModulo= borderResaltarSecuencial;

		 return borderResaltarSecuencial;
	}



	public Boolean mostrarSecuencialTipoMovimientoModulo=true;

	public Boolean getMostrarSecuencialTipoMovimientoModulo() {
		return this.mostrarSecuencialTipoMovimientoModulo;
	}

	public void setMostrarSecuencialTipoMovimientoModulo(Boolean visibilidadResaltarSecuencial) {
		this.mostrarSecuencialTipoMovimientoModulo= visibilidadResaltarSecuencial;
	}



	public Boolean activarSecuencialTipoMovimientoModulo=true;

	public Boolean gethabilitarResaltarSecuencialTipoMovimientoModulo() {
		return this.activarSecuencialTipoMovimientoModulo;
	}

	public void setActivarSecuencialTipoMovimientoModulo(Boolean habilitarResaltarSecuencial) {
		this.activarSecuencialTipoMovimientoModulo= habilitarResaltarSecuencial;
	}


	public Border resaltarTipoDocumentoTipoMovimientoModulo=null;

	public Border getResaltarTipoDocumentoTipoMovimientoModulo() {
		return this.resaltarTipoDocumentoTipoMovimientoModulo;
	}

	public void setResaltarTipoDocumentoTipoMovimientoModulo(Border borderResaltarTipoDocumento) {
		if(borderResaltarTipoDocumento!=null) {
			this.resaltarTipoDocumentoTipoMovimientoModulo= borderResaltarTipoDocumento;
		}
	}

	public Border setResaltarTipoDocumentoTipoMovimientoModulo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMovimientoModuloBeanSwingJInternalFrame tipomovimientomoduloBeanSwingJInternalFrame*/) {
		Border borderResaltarTipoDocumento=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipomovimientomoduloBeanSwingJInternalFrame.jTtoolBarTipoMovimientoModulo.setBorder(borderResaltarTipoDocumento);
			
		this.resaltarTipoDocumentoTipoMovimientoModulo= borderResaltarTipoDocumento;

		 return borderResaltarTipoDocumento;
	}



	public Boolean mostrarTipoDocumentoTipoMovimientoModulo=true;

	public Boolean getMostrarTipoDocumentoTipoMovimientoModulo() {
		return this.mostrarTipoDocumentoTipoMovimientoModulo;
	}

	public void setMostrarTipoDocumentoTipoMovimientoModulo(Boolean visibilidadResaltarTipoDocumento) {
		this.mostrarTipoDocumentoTipoMovimientoModulo= visibilidadResaltarTipoDocumento;
	}



	public Boolean activarTipoDocumentoTipoMovimientoModulo=true;

	public Boolean gethabilitarResaltarTipoDocumentoTipoMovimientoModulo() {
		return this.activarTipoDocumentoTipoMovimientoModulo;
	}

	public void setActivarTipoDocumentoTipoMovimientoModulo(Boolean habilitarResaltarTipoDocumento) {
		this.activarTipoDocumentoTipoMovimientoModulo= habilitarResaltarTipoDocumento;
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

		this.setMostrarParametroCompraTipoMovimientoModulo(esInicial);
		this.setMostrarFacturaProveedorServicioTipoMovimientoModulo(esInicial);
		this.setMostrarSecuencialTipoMovimientoModulo(esInicial);
		this.setMostrarTipoDocumentoTipoMovimientoModulo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroCompra.class)) {
				this.setMostrarParametroCompraTipoMovimientoModulo(esAsigna);
				continue;
			}

			if(clase.clas.equals(FacturaProveedorServicio.class)) {
				this.setMostrarFacturaProveedorServicioTipoMovimientoModulo(esAsigna);
				continue;
			}

			if(clase.clas.equals(Secuencial.class)) {
				this.setMostrarSecuencialTipoMovimientoModulo(esAsigna);
				continue;
			}

			if(clase.clas.equals(TipoDocumento.class)) {
				this.setMostrarTipoDocumentoTipoMovimientoModulo(esAsigna);
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

		this.setActivarParametroCompraTipoMovimientoModulo(esInicial);
		this.setActivarFacturaProveedorServicioTipoMovimientoModulo(esInicial);
		this.setActivarSecuencialTipoMovimientoModulo(esInicial);
		this.setActivarTipoDocumentoTipoMovimientoModulo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroCompra.class)) {
				this.setActivarParametroCompraTipoMovimientoModulo(esAsigna);
				continue;
			}

			if(clase.clas.equals(FacturaProveedorServicio.class)) {
				this.setActivarFacturaProveedorServicioTipoMovimientoModulo(esAsigna);
				continue;
			}

			if(clase.clas.equals(Secuencial.class)) {
				this.setActivarSecuencialTipoMovimientoModulo(esAsigna);
				continue;
			}

			if(clase.clas.equals(TipoDocumento.class)) {
				this.setActivarTipoDocumentoTipoMovimientoModulo(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoMovimientoModuloBeanSwingJInternalFrame tipomovimientomoduloBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarParametroCompraTipoMovimientoModulo(esInicial);
		this.setResaltarFacturaProveedorServicioTipoMovimientoModulo(esInicial);
		this.setResaltarSecuencialTipoMovimientoModulo(esInicial);
		this.setResaltarTipoDocumentoTipoMovimientoModulo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroCompra.class)) {
				this.setResaltarParametroCompraTipoMovimientoModulo(esAsigna);
				continue;
			}

			if(clase.clas.equals(FacturaProveedorServicio.class)) {
				this.setResaltarFacturaProveedorServicioTipoMovimientoModulo(esAsigna);
				continue;
			}

			if(clase.clas.equals(Secuencial.class)) {
				this.setResaltarSecuencialTipoMovimientoModulo(esAsigna);
				continue;
			}

			if(clase.clas.equals(TipoDocumento.class)) {
				this.setResaltarTipoDocumentoTipoMovimientoModulo(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoTipoMovimientoModulo=true;

	public Boolean getMostrarBusquedaPorCodigoTipoMovimientoModulo() {
		return this.mostrarBusquedaPorCodigoTipoMovimientoModulo;
	}

	public void setMostrarBusquedaPorCodigoTipoMovimientoModulo(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTipoMovimientoModulo= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoMovimientoModulo=true;

	public Boolean getMostrarBusquedaPorNombreTipoMovimientoModulo() {
		return this.mostrarBusquedaPorNombreTipoMovimientoModulo;
	}

	public void setMostrarBusquedaPorNombreTipoMovimientoModulo(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoMovimientoModulo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloTipoMovimientoModulo=true;

	public Boolean getMostrarFK_IdModuloTipoMovimientoModulo() {
		return this.mostrarFK_IdModuloTipoMovimientoModulo;
	}

	public void setMostrarFK_IdModuloTipoMovimientoModulo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloTipoMovimientoModulo= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTipoMovimientoModulo=true;

	public Boolean getActivarBusquedaPorCodigoTipoMovimientoModulo() {
		return this.activarBusquedaPorCodigoTipoMovimientoModulo;
	}

	public void setActivarBusquedaPorCodigoTipoMovimientoModulo(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTipoMovimientoModulo= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoMovimientoModulo=true;

	public Boolean getActivarBusquedaPorNombreTipoMovimientoModulo() {
		return this.activarBusquedaPorNombreTipoMovimientoModulo;
	}

	public void setActivarBusquedaPorNombreTipoMovimientoModulo(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoMovimientoModulo= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloTipoMovimientoModulo=true;

	public Boolean getActivarFK_IdModuloTipoMovimientoModulo() {
		return this.activarFK_IdModuloTipoMovimientoModulo;
	}

	public void setActivarFK_IdModuloTipoMovimientoModulo(Boolean habilitarResaltar) {
		this.activarFK_IdModuloTipoMovimientoModulo= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTipoMovimientoModulo=null;

	public Border getResaltarBusquedaPorCodigoTipoMovimientoModulo() {
		return this.resaltarBusquedaPorCodigoTipoMovimientoModulo;
	}

	public void setResaltarBusquedaPorCodigoTipoMovimientoModulo(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTipoMovimientoModulo= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTipoMovimientoModulo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMovimientoModuloBeanSwingJInternalFrame tipomovimientomoduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTipoMovimientoModulo= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoMovimientoModulo=null;

	public Border getResaltarBusquedaPorNombreTipoMovimientoModulo() {
		return this.resaltarBusquedaPorNombreTipoMovimientoModulo;
	}

	public void setResaltarBusquedaPorNombreTipoMovimientoModulo(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoMovimientoModulo= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoMovimientoModulo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMovimientoModuloBeanSwingJInternalFrame tipomovimientomoduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoMovimientoModulo= borderResaltar;
	}

	public Border resaltarFK_IdModuloTipoMovimientoModulo=null;

	public Border getResaltarFK_IdModuloTipoMovimientoModulo() {
		return this.resaltarFK_IdModuloTipoMovimientoModulo;
	}

	public void setResaltarFK_IdModuloTipoMovimientoModulo(Border borderResaltar) {
		this.resaltarFK_IdModuloTipoMovimientoModulo= borderResaltar;
	}

	public void setResaltarFK_IdModuloTipoMovimientoModulo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMovimientoModuloBeanSwingJInternalFrame tipomovimientomoduloBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloTipoMovimientoModulo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}