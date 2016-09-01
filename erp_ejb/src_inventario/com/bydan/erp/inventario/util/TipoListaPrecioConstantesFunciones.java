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


import com.bydan.erp.inventario.util.TipoListaPrecioConstantesFunciones;
import com.bydan.erp.inventario.util.TipoListaPrecioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoListaPrecioParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoListaPrecioConstantesFunciones extends TipoListaPrecioConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoListaPrecio";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoListaPrecio"+TipoListaPrecioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoListaPrecioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoListaPrecioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoListaPrecioConstantesFunciones.SCHEMA+"_"+TipoListaPrecioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoListaPrecioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoListaPrecioConstantesFunciones.SCHEMA+"_"+TipoListaPrecioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoListaPrecioConstantesFunciones.SCHEMA+"_"+TipoListaPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoListaPrecioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoListaPrecioConstantesFunciones.SCHEMA+"_"+TipoListaPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoListaPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoListaPrecioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoListaPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoListaPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoListaPrecioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoListaPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoListaPrecioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoListaPrecioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoListaPrecioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoListaPrecioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Lista Precioes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Lista Precio";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Lista Precio";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoListaPrecio";
	public static final String OBJECTNAME="tipolistaprecio";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="tipo_lista_precio";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipolistaprecio from "+TipoListaPrecioConstantesFunciones.SPERSISTENCENAME+" tipolistaprecio";
	public static String QUERYSELECTNATIVE="select "+TipoListaPrecioConstantesFunciones.SCHEMA+"."+TipoListaPrecioConstantesFunciones.TABLENAME+".id,"+TipoListaPrecioConstantesFunciones.SCHEMA+"."+TipoListaPrecioConstantesFunciones.TABLENAME+".version_row,"+TipoListaPrecioConstantesFunciones.SCHEMA+"."+TipoListaPrecioConstantesFunciones.TABLENAME+".id_empresa,"+TipoListaPrecioConstantesFunciones.SCHEMA+"."+TipoListaPrecioConstantesFunciones.TABLENAME+".codigo,"+TipoListaPrecioConstantesFunciones.SCHEMA+"."+TipoListaPrecioConstantesFunciones.TABLENAME+".nombre,"+TipoListaPrecioConstantesFunciones.SCHEMA+"."+TipoListaPrecioConstantesFunciones.TABLENAME+".fecha_desde,"+TipoListaPrecioConstantesFunciones.SCHEMA+"."+TipoListaPrecioConstantesFunciones.TABLENAME+".fecha_hasta,"+TipoListaPrecioConstantesFunciones.SCHEMA+"."+TipoListaPrecioConstantesFunciones.TABLENAME+".esta_activo,"+TipoListaPrecioConstantesFunciones.SCHEMA+"."+TipoListaPrecioConstantesFunciones.TABLENAME+".descripcion from "+TipoListaPrecioConstantesFunciones.SCHEMA+"."+TipoListaPrecioConstantesFunciones.TABLENAME;//+" as "+TipoListaPrecioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoListaPrecioConstantesFuncionesAdditional tipolistaprecioConstantesFuncionesAdditional=null;
	
	public TipoListaPrecioConstantesFuncionesAdditional getTipoListaPrecioConstantesFuncionesAdditional() {
		return this.tipolistaprecioConstantesFuncionesAdditional;
	}
	
	public void setTipoListaPrecioConstantesFuncionesAdditional(TipoListaPrecioConstantesFuncionesAdditional tipolistaprecioConstantesFuncionesAdditional) {
		try {
			this.tipolistaprecioConstantesFuncionesAdditional=tipolistaprecioConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String FECHADESDE= "fecha_desde";
    public static final String FECHAHASTA= "fecha_hasta";
    public static final String ESTAACTIVO= "esta_activo";
    public static final String DESCRIPCION= "descripcion";
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
    	public static final String LABEL_FECHADESDE= "Fecha Desde";
		public static final String LABEL_FECHADESDE_LOWER= "Fecha Desde";
    	public static final String LABEL_FECHAHASTA= "Fecha Hasta";
		public static final String LABEL_FECHAHASTA_LOWER= "Fecha Hasta";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoListaPrecioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoListaPrecioConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoListaPrecioConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoListaPrecioConstantesFunciones.CODIGO)) {sLabelColumna=TipoListaPrecioConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoListaPrecioConstantesFunciones.NOMBRE)) {sLabelColumna=TipoListaPrecioConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoListaPrecioConstantesFunciones.FECHADESDE)) {sLabelColumna=TipoListaPrecioConstantesFunciones.LABEL_FECHADESDE;}
		if(sNombreColumna.equals(TipoListaPrecioConstantesFunciones.FECHAHASTA)) {sLabelColumna=TipoListaPrecioConstantesFunciones.LABEL_FECHAHASTA;}
		if(sNombreColumna.equals(TipoListaPrecioConstantesFunciones.ESTAACTIVO)) {sLabelColumna=TipoListaPrecioConstantesFunciones.LABEL_ESTAACTIVO;}
		if(sNombreColumna.equals(TipoListaPrecioConstantesFunciones.DESCRIPCION)) {sLabelColumna=TipoListaPrecioConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(TipoListaPrecio tipolistaprecio) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tipolistaprecio.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(TipoListaPrecio tipolistaprecio) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tipolistaprecio.getId(),tipolistaprecio.getesta_activo());

		return sDescripcion;
	}	
			
	
	public static String getTipoListaPrecioDescripcion(TipoListaPrecio tipolistaprecio) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipolistaprecio !=null/* && tipolistaprecio.getId()!=0*/) {
			sDescripcion=tipolistaprecio.getcodigo();//tipolistapreciotipolistaprecio.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoListaPrecioDescripcionDetallado(TipoListaPrecio tipolistaprecio) {
		String sDescripcion="";
			
		sDescripcion+=TipoListaPrecioConstantesFunciones.ID+"=";
		sDescripcion+=tipolistaprecio.getId().toString()+",";
		sDescripcion+=TipoListaPrecioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipolistaprecio.getVersionRow().toString()+",";
		sDescripcion+=TipoListaPrecioConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipolistaprecio.getid_empresa().toString()+",";
		sDescripcion+=TipoListaPrecioConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipolistaprecio.getcodigo()+",";
		sDescripcion+=TipoListaPrecioConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipolistaprecio.getnombre()+",";
		sDescripcion+=TipoListaPrecioConstantesFunciones.FECHADESDE+"=";
		sDescripcion+=tipolistaprecio.getfecha_desde().toString()+",";
		sDescripcion+=TipoListaPrecioConstantesFunciones.FECHAHASTA+"=";
		sDescripcion+=tipolistaprecio.getfecha_hasta().toString()+",";
		sDescripcion+=TipoListaPrecioConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=tipolistaprecio.getesta_activo().toString()+",";
		sDescripcion+=TipoListaPrecioConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=tipolistaprecio.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoListaPrecioDescripcion(TipoListaPrecio tipolistaprecio,String sValor) throws Exception {			
		if(tipolistaprecio !=null) {
			tipolistaprecio.setcodigo(sValor);;//tipolistapreciotipolistaprecio.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoListaPrecio(TipoListaPrecio tipolistaprecio,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipolistaprecio.setcodigo(tipolistaprecio.getcodigo().trim());
		tipolistaprecio.setnombre(tipolistaprecio.getnombre().trim());
		tipolistaprecio.setdescripcion(tipolistaprecio.getdescripcion().trim());
	}
	
	public static void quitarEspaciosTipoListaPrecios(List<TipoListaPrecio> tipolistaprecios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoListaPrecio tipolistaprecio: tipolistaprecios) {
			tipolistaprecio.setcodigo(tipolistaprecio.getcodigo().trim());
			tipolistaprecio.setnombre(tipolistaprecio.getnombre().trim());
			tipolistaprecio.setdescripcion(tipolistaprecio.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoListaPrecio(TipoListaPrecio tipolistaprecio,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipolistaprecio.getConCambioAuxiliar()) {
			tipolistaprecio.setIsDeleted(tipolistaprecio.getIsDeletedAuxiliar());	
			tipolistaprecio.setIsNew(tipolistaprecio.getIsNewAuxiliar());	
			tipolistaprecio.setIsChanged(tipolistaprecio.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipolistaprecio.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipolistaprecio.setIsDeletedAuxiliar(false);	
			tipolistaprecio.setIsNewAuxiliar(false);	
			tipolistaprecio.setIsChangedAuxiliar(false);
			
			tipolistaprecio.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoListaPrecios(List<TipoListaPrecio> tipolistaprecios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoListaPrecio tipolistaprecio : tipolistaprecios) {
			if(conAsignarBase && tipolistaprecio.getConCambioAuxiliar()) {
				tipolistaprecio.setIsDeleted(tipolistaprecio.getIsDeletedAuxiliar());	
				tipolistaprecio.setIsNew(tipolistaprecio.getIsNewAuxiliar());	
				tipolistaprecio.setIsChanged(tipolistaprecio.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipolistaprecio.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipolistaprecio.setIsDeletedAuxiliar(false);	
				tipolistaprecio.setIsNewAuxiliar(false);	
				tipolistaprecio.setIsChangedAuxiliar(false);
				
				tipolistaprecio.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoListaPrecio(TipoListaPrecio tipolistaprecio,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoListaPrecios(List<TipoListaPrecio> tipolistaprecios,Boolean conEnteros) throws Exception  {
		
		for(TipoListaPrecio tipolistaprecio: tipolistaprecios) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoListaPrecio(List<TipoListaPrecio> tipolistaprecios,TipoListaPrecio tipolistaprecioAux) throws Exception  {
		TipoListaPrecioConstantesFunciones.InicializarValoresTipoListaPrecio(tipolistaprecioAux,true);
		
		for(TipoListaPrecio tipolistaprecio: tipolistaprecios) {
			if(tipolistaprecio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoListaPrecio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoListaPrecioConstantesFunciones.getArrayColumnasGlobalesTipoListaPrecio(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoListaPrecio(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoListaPrecioConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoListaPrecioConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoListaPrecio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoListaPrecio> tipolistaprecios,TipoListaPrecio tipolistaprecio,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoListaPrecio tipolistaprecioAux: tipolistaprecios) {
			if(tipolistaprecioAux!=null && tipolistaprecio!=null) {
				if((tipolistaprecioAux.getId()==null && tipolistaprecio.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipolistaprecioAux.getId()!=null && tipolistaprecio.getId()!=null){
					if(tipolistaprecioAux.getId().equals(tipolistaprecio.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoListaPrecio(List<TipoListaPrecio> tipolistaprecios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoListaPrecio tipolistaprecio: tipolistaprecios) {			
			if(tipolistaprecio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoListaPrecio() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoListaPrecioConstantesFunciones.LABEL_ID, TipoListaPrecioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoListaPrecioConstantesFunciones.LABEL_VERSIONROW, TipoListaPrecioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoListaPrecioConstantesFunciones.LABEL_IDEMPRESA, TipoListaPrecioConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoListaPrecioConstantesFunciones.LABEL_CODIGO, TipoListaPrecioConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoListaPrecioConstantesFunciones.LABEL_NOMBRE, TipoListaPrecioConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoListaPrecioConstantesFunciones.LABEL_FECHADESDE, TipoListaPrecioConstantesFunciones.FECHADESDE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoListaPrecioConstantesFunciones.LABEL_FECHAHASTA, TipoListaPrecioConstantesFunciones.FECHAHASTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoListaPrecioConstantesFunciones.LABEL_ESTAACTIVO, TipoListaPrecioConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoListaPrecioConstantesFunciones.LABEL_DESCRIPCION, TipoListaPrecioConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoListaPrecio() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoListaPrecioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoListaPrecioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoListaPrecioConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoListaPrecioConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoListaPrecioConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoListaPrecioConstantesFunciones.FECHADESDE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoListaPrecioConstantesFunciones.FECHAHASTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoListaPrecioConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoListaPrecioConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoListaPrecio() throws Exception  {
		return TipoListaPrecioConstantesFunciones.getTiposSeleccionarTipoListaPrecio(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoListaPrecio(Boolean conFk) throws Exception  {
		return TipoListaPrecioConstantesFunciones.getTiposSeleccionarTipoListaPrecio(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoListaPrecio(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoListaPrecioConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoListaPrecioConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoListaPrecioConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoListaPrecioConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoListaPrecioConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoListaPrecioConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoListaPrecioConstantesFunciones.LABEL_FECHADESDE);
			reporte.setsDescripcion(TipoListaPrecioConstantesFunciones.LABEL_FECHADESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoListaPrecioConstantesFunciones.LABEL_FECHAHASTA);
			reporte.setsDescripcion(TipoListaPrecioConstantesFunciones.LABEL_FECHAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoListaPrecioConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(TipoListaPrecioConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoListaPrecioConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(TipoListaPrecioConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoListaPrecio(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoListaPrecio(TipoListaPrecio tipolistaprecioAux) throws Exception {
		
			tipolistaprecioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipolistaprecioAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoListaPrecio(List<TipoListaPrecio> tipolistapreciosTemp) throws Exception {
		for(TipoListaPrecio tipolistaprecioAux:tipolistapreciosTemp) {
			
			tipolistaprecioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipolistaprecioAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoListaPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoListaPrecio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoListaPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoListaPrecioConstantesFunciones.getClassesRelationshipsOfTipoListaPrecio(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoListaPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(ParametroCarteraDefecto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroCarteraDefecto.class)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoListaPrecio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoListaPrecioConstantesFunciones.getClassesRelationshipsFromStringsOfTipoListaPrecio(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoListaPrecio(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(ParametroCarteraDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(ParametroCarteraDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); continue;
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
	public static void actualizarLista(TipoListaPrecio tipolistaprecio,List<TipoListaPrecio> tipolistaprecios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoListaPrecio tipolistaprecioEncontrado=null;
			
			for(TipoListaPrecio tipolistaprecioLocal:tipolistaprecios) {
				if(tipolistaprecioLocal.getId().equals(tipolistaprecio.getId())) {
					tipolistaprecioEncontrado=tipolistaprecioLocal;
					
					tipolistaprecioLocal.setIsChanged(tipolistaprecio.getIsChanged());
					tipolistaprecioLocal.setIsNew(tipolistaprecio.getIsNew());
					tipolistaprecioLocal.setIsDeleted(tipolistaprecio.getIsDeleted());
					
					tipolistaprecioLocal.setGeneralEntityOriginal(tipolistaprecio.getGeneralEntityOriginal());
					
					tipolistaprecioLocal.setId(tipolistaprecio.getId());	
					tipolistaprecioLocal.setVersionRow(tipolistaprecio.getVersionRow());	
					tipolistaprecioLocal.setid_empresa(tipolistaprecio.getid_empresa());	
					tipolistaprecioLocal.setcodigo(tipolistaprecio.getcodigo());	
					tipolistaprecioLocal.setnombre(tipolistaprecio.getnombre());	
					tipolistaprecioLocal.setfecha_desde(tipolistaprecio.getfecha_desde());	
					tipolistaprecioLocal.setfecha_hasta(tipolistaprecio.getfecha_hasta());	
					tipolistaprecioLocal.setesta_activo(tipolistaprecio.getesta_activo());	
					tipolistaprecioLocal.setdescripcion(tipolistaprecio.getdescripcion());	
					
					
					tipolistaprecioLocal.setClientes(tipolistaprecio.getClientes());
					tipolistaprecioLocal.setParametroCarteraDefectos(tipolistaprecio.getParametroCarteraDefectos());
					
					existe=true;
					break;
				}
			}
			
			if(!tipolistaprecio.getIsDeleted()) {
				if(!existe) {
					tipolistaprecios.add(tipolistaprecio);
				}
			} else {
				if(tipolistaprecioEncontrado!=null && permiteQuitar)  {
					tipolistaprecios.remove(tipolistaprecioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoListaPrecio tipolistaprecio,List<TipoListaPrecio> tipolistaprecios) throws Exception {
		try	{			
			for(TipoListaPrecio tipolistaprecioLocal:tipolistaprecios) {
				if(tipolistaprecioLocal.getId().equals(tipolistaprecio.getId())) {
					tipolistaprecioLocal.setIsSelected(tipolistaprecio.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoListaPrecio(List<TipoListaPrecio> tipolistapreciosAux) throws Exception {
		//this.tipolistapreciosAux=tipolistapreciosAux;
		
		for(TipoListaPrecio tipolistaprecioAux:tipolistapreciosAux) {
			if(tipolistaprecioAux.getIsChanged()) {
				tipolistaprecioAux.setIsChanged(false);
			}		
			
			if(tipolistaprecioAux.getIsNew()) {
				tipolistaprecioAux.setIsNew(false);
			}	
			
			if(tipolistaprecioAux.getIsDeleted()) {
				tipolistaprecioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoListaPrecio(TipoListaPrecio tipolistaprecioAux) throws Exception {
		//this.tipolistaprecioAux=tipolistaprecioAux;
		
			if(tipolistaprecioAux.getIsChanged()) {
				tipolistaprecioAux.setIsChanged(false);
			}		
			
			if(tipolistaprecioAux.getIsNew()) {
				tipolistaprecioAux.setIsNew(false);
			}	
			
			if(tipolistaprecioAux.getIsDeleted()) {
				tipolistaprecioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoListaPrecio tipolistaprecioAsignar,TipoListaPrecio tipolistaprecio) throws Exception {
		tipolistaprecioAsignar.setId(tipolistaprecio.getId());	
		tipolistaprecioAsignar.setVersionRow(tipolistaprecio.getVersionRow());	
		tipolistaprecioAsignar.setid_empresa(tipolistaprecio.getid_empresa());
		tipolistaprecioAsignar.setempresa_descripcion(tipolistaprecio.getempresa_descripcion());	
		tipolistaprecioAsignar.setcodigo(tipolistaprecio.getcodigo());	
		tipolistaprecioAsignar.setnombre(tipolistaprecio.getnombre());	
		tipolistaprecioAsignar.setfecha_desde(tipolistaprecio.getfecha_desde());	
		tipolistaprecioAsignar.setfecha_hasta(tipolistaprecio.getfecha_hasta());	
		tipolistaprecioAsignar.setesta_activo(tipolistaprecio.getesta_activo());	
		tipolistaprecioAsignar.setdescripcion(tipolistaprecio.getdescripcion());	
	}
	
	public static void inicializarTipoListaPrecio(TipoListaPrecio tipolistaprecio) throws Exception {
		try {
				tipolistaprecio.setId(0L);	
					
				tipolistaprecio.setid_empresa(-1L);	
				tipolistaprecio.setcodigo("");	
				tipolistaprecio.setnombre("");	
				tipolistaprecio.setfecha_desde(new Date());	
				tipolistaprecio.setfecha_hasta(new Date());	
				tipolistaprecio.setesta_activo(false);	
				tipolistaprecio.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoListaPrecio(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoListaPrecioConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoListaPrecioConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoListaPrecioConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoListaPrecioConstantesFunciones.LABEL_FECHADESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoListaPrecioConstantesFunciones.LABEL_FECHAHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoListaPrecioConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoListaPrecioConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoListaPrecio(String sTipo,Row row,Workbook workbook,TipoListaPrecio tipolistaprecio,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipolistaprecio.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipolistaprecio.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipolistaprecio.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipolistaprecio.getfecha_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipolistaprecio.getfecha_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tipolistaprecio.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipolistaprecio.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoListaPrecio=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoListaPrecio() {
		return this.sFinalQueryTipoListaPrecio;
	}
	
	public void setsFinalQueryTipoListaPrecio(String sFinalQueryTipoListaPrecio) {
		this.sFinalQueryTipoListaPrecio= sFinalQueryTipoListaPrecio;
	}
	
	public Border resaltarSeleccionarTipoListaPrecio=null;
	
	public Border setResaltarSeleccionarTipoListaPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoListaPrecioBeanSwingJInternalFrame tipolistaprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipolistaprecioBeanSwingJInternalFrame.jTtoolBarTipoListaPrecio.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoListaPrecio= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoListaPrecio() {
		return this.resaltarSeleccionarTipoListaPrecio;
	}
	
	public void setResaltarSeleccionarTipoListaPrecio(Border borderResaltarSeleccionarTipoListaPrecio) {
		this.resaltarSeleccionarTipoListaPrecio= borderResaltarSeleccionarTipoListaPrecio;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoListaPrecio=null;
	public Boolean mostraridTipoListaPrecio=true;
	public Boolean activaridTipoListaPrecio=true;

	public Border resaltarid_empresaTipoListaPrecio=null;
	public Boolean mostrarid_empresaTipoListaPrecio=true;
	public Boolean activarid_empresaTipoListaPrecio=true;
	public Boolean cargarid_empresaTipoListaPrecio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoListaPrecio=false;//ConEventDepend=true

	public Border resaltarcodigoTipoListaPrecio=null;
	public Boolean mostrarcodigoTipoListaPrecio=true;
	public Boolean activarcodigoTipoListaPrecio=true;

	public Border resaltarnombreTipoListaPrecio=null;
	public Boolean mostrarnombreTipoListaPrecio=true;
	public Boolean activarnombreTipoListaPrecio=true;

	public Border resaltarfecha_desdeTipoListaPrecio=null;
	public Boolean mostrarfecha_desdeTipoListaPrecio=true;
	public Boolean activarfecha_desdeTipoListaPrecio=false;

	public Border resaltarfecha_hastaTipoListaPrecio=null;
	public Boolean mostrarfecha_hastaTipoListaPrecio=true;
	public Boolean activarfecha_hastaTipoListaPrecio=false;

	public Border resaltaresta_activoTipoListaPrecio=null;
	public Boolean mostraresta_activoTipoListaPrecio=true;
	public Boolean activaresta_activoTipoListaPrecio=true;

	public Border resaltardescripcionTipoListaPrecio=null;
	public Boolean mostrardescripcionTipoListaPrecio=true;
	public Boolean activardescripcionTipoListaPrecio=true;

	
	

	public Border setResaltaridTipoListaPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoListaPrecioBeanSwingJInternalFrame tipolistaprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipolistaprecioBeanSwingJInternalFrame.jTtoolBarTipoListaPrecio.setBorder(borderResaltar);
		
		this.resaltaridTipoListaPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoListaPrecio() {
		return this.resaltaridTipoListaPrecio;
	}

	public void setResaltaridTipoListaPrecio(Border borderResaltar) {
		this.resaltaridTipoListaPrecio= borderResaltar;
	}

	public Boolean getMostraridTipoListaPrecio() {
		return this.mostraridTipoListaPrecio;
	}

	public void setMostraridTipoListaPrecio(Boolean mostraridTipoListaPrecio) {
		this.mostraridTipoListaPrecio= mostraridTipoListaPrecio;
	}

	public Boolean getActivaridTipoListaPrecio() {
		return this.activaridTipoListaPrecio;
	}

	public void setActivaridTipoListaPrecio(Boolean activaridTipoListaPrecio) {
		this.activaridTipoListaPrecio= activaridTipoListaPrecio;
	}

	public Border setResaltarid_empresaTipoListaPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoListaPrecioBeanSwingJInternalFrame tipolistaprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipolistaprecioBeanSwingJInternalFrame.jTtoolBarTipoListaPrecio.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoListaPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoListaPrecio() {
		return this.resaltarid_empresaTipoListaPrecio;
	}

	public void setResaltarid_empresaTipoListaPrecio(Border borderResaltar) {
		this.resaltarid_empresaTipoListaPrecio= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoListaPrecio() {
		return this.mostrarid_empresaTipoListaPrecio;
	}

	public void setMostrarid_empresaTipoListaPrecio(Boolean mostrarid_empresaTipoListaPrecio) {
		this.mostrarid_empresaTipoListaPrecio= mostrarid_empresaTipoListaPrecio;
	}

	public Boolean getActivarid_empresaTipoListaPrecio() {
		return this.activarid_empresaTipoListaPrecio;
	}

	public void setActivarid_empresaTipoListaPrecio(Boolean activarid_empresaTipoListaPrecio) {
		this.activarid_empresaTipoListaPrecio= activarid_empresaTipoListaPrecio;
	}

	public Boolean getCargarid_empresaTipoListaPrecio() {
		return this.cargarid_empresaTipoListaPrecio;
	}

	public void setCargarid_empresaTipoListaPrecio(Boolean cargarid_empresaTipoListaPrecio) {
		this.cargarid_empresaTipoListaPrecio= cargarid_empresaTipoListaPrecio;
	}

	public Border setResaltarcodigoTipoListaPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoListaPrecioBeanSwingJInternalFrame tipolistaprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipolistaprecioBeanSwingJInternalFrame.jTtoolBarTipoListaPrecio.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoListaPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoListaPrecio() {
		return this.resaltarcodigoTipoListaPrecio;
	}

	public void setResaltarcodigoTipoListaPrecio(Border borderResaltar) {
		this.resaltarcodigoTipoListaPrecio= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoListaPrecio() {
		return this.mostrarcodigoTipoListaPrecio;
	}

	public void setMostrarcodigoTipoListaPrecio(Boolean mostrarcodigoTipoListaPrecio) {
		this.mostrarcodigoTipoListaPrecio= mostrarcodigoTipoListaPrecio;
	}

	public Boolean getActivarcodigoTipoListaPrecio() {
		return this.activarcodigoTipoListaPrecio;
	}

	public void setActivarcodigoTipoListaPrecio(Boolean activarcodigoTipoListaPrecio) {
		this.activarcodigoTipoListaPrecio= activarcodigoTipoListaPrecio;
	}

	public Border setResaltarnombreTipoListaPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoListaPrecioBeanSwingJInternalFrame tipolistaprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipolistaprecioBeanSwingJInternalFrame.jTtoolBarTipoListaPrecio.setBorder(borderResaltar);
		
		this.resaltarnombreTipoListaPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoListaPrecio() {
		return this.resaltarnombreTipoListaPrecio;
	}

	public void setResaltarnombreTipoListaPrecio(Border borderResaltar) {
		this.resaltarnombreTipoListaPrecio= borderResaltar;
	}

	public Boolean getMostrarnombreTipoListaPrecio() {
		return this.mostrarnombreTipoListaPrecio;
	}

	public void setMostrarnombreTipoListaPrecio(Boolean mostrarnombreTipoListaPrecio) {
		this.mostrarnombreTipoListaPrecio= mostrarnombreTipoListaPrecio;
	}

	public Boolean getActivarnombreTipoListaPrecio() {
		return this.activarnombreTipoListaPrecio;
	}

	public void setActivarnombreTipoListaPrecio(Boolean activarnombreTipoListaPrecio) {
		this.activarnombreTipoListaPrecio= activarnombreTipoListaPrecio;
	}

	public Border setResaltarfecha_desdeTipoListaPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoListaPrecioBeanSwingJInternalFrame tipolistaprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipolistaprecioBeanSwingJInternalFrame.jTtoolBarTipoListaPrecio.setBorder(borderResaltar);
		
		this.resaltarfecha_desdeTipoListaPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_desdeTipoListaPrecio() {
		return this.resaltarfecha_desdeTipoListaPrecio;
	}

	public void setResaltarfecha_desdeTipoListaPrecio(Border borderResaltar) {
		this.resaltarfecha_desdeTipoListaPrecio= borderResaltar;
	}

	public Boolean getMostrarfecha_desdeTipoListaPrecio() {
		return this.mostrarfecha_desdeTipoListaPrecio;
	}

	public void setMostrarfecha_desdeTipoListaPrecio(Boolean mostrarfecha_desdeTipoListaPrecio) {
		this.mostrarfecha_desdeTipoListaPrecio= mostrarfecha_desdeTipoListaPrecio;
	}

	public Boolean getActivarfecha_desdeTipoListaPrecio() {
		return this.activarfecha_desdeTipoListaPrecio;
	}

	public void setActivarfecha_desdeTipoListaPrecio(Boolean activarfecha_desdeTipoListaPrecio) {
		this.activarfecha_desdeTipoListaPrecio= activarfecha_desdeTipoListaPrecio;
	}

	public Border setResaltarfecha_hastaTipoListaPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoListaPrecioBeanSwingJInternalFrame tipolistaprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipolistaprecioBeanSwingJInternalFrame.jTtoolBarTipoListaPrecio.setBorder(borderResaltar);
		
		this.resaltarfecha_hastaTipoListaPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_hastaTipoListaPrecio() {
		return this.resaltarfecha_hastaTipoListaPrecio;
	}

	public void setResaltarfecha_hastaTipoListaPrecio(Border borderResaltar) {
		this.resaltarfecha_hastaTipoListaPrecio= borderResaltar;
	}

	public Boolean getMostrarfecha_hastaTipoListaPrecio() {
		return this.mostrarfecha_hastaTipoListaPrecio;
	}

	public void setMostrarfecha_hastaTipoListaPrecio(Boolean mostrarfecha_hastaTipoListaPrecio) {
		this.mostrarfecha_hastaTipoListaPrecio= mostrarfecha_hastaTipoListaPrecio;
	}

	public Boolean getActivarfecha_hastaTipoListaPrecio() {
		return this.activarfecha_hastaTipoListaPrecio;
	}

	public void setActivarfecha_hastaTipoListaPrecio(Boolean activarfecha_hastaTipoListaPrecio) {
		this.activarfecha_hastaTipoListaPrecio= activarfecha_hastaTipoListaPrecio;
	}

	public Border setResaltaresta_activoTipoListaPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoListaPrecioBeanSwingJInternalFrame tipolistaprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipolistaprecioBeanSwingJInternalFrame.jTtoolBarTipoListaPrecio.setBorder(borderResaltar);
		
		this.resaltaresta_activoTipoListaPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoTipoListaPrecio() {
		return this.resaltaresta_activoTipoListaPrecio;
	}

	public void setResaltaresta_activoTipoListaPrecio(Border borderResaltar) {
		this.resaltaresta_activoTipoListaPrecio= borderResaltar;
	}

	public Boolean getMostraresta_activoTipoListaPrecio() {
		return this.mostraresta_activoTipoListaPrecio;
	}

	public void setMostraresta_activoTipoListaPrecio(Boolean mostraresta_activoTipoListaPrecio) {
		this.mostraresta_activoTipoListaPrecio= mostraresta_activoTipoListaPrecio;
	}

	public Boolean getActivaresta_activoTipoListaPrecio() {
		return this.activaresta_activoTipoListaPrecio;
	}

	public void setActivaresta_activoTipoListaPrecio(Boolean activaresta_activoTipoListaPrecio) {
		this.activaresta_activoTipoListaPrecio= activaresta_activoTipoListaPrecio;
	}

	public Border setResaltardescripcionTipoListaPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoListaPrecioBeanSwingJInternalFrame tipolistaprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipolistaprecioBeanSwingJInternalFrame.jTtoolBarTipoListaPrecio.setBorder(borderResaltar);
		
		this.resaltardescripcionTipoListaPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionTipoListaPrecio() {
		return this.resaltardescripcionTipoListaPrecio;
	}

	public void setResaltardescripcionTipoListaPrecio(Border borderResaltar) {
		this.resaltardescripcionTipoListaPrecio= borderResaltar;
	}

	public Boolean getMostrardescripcionTipoListaPrecio() {
		return this.mostrardescripcionTipoListaPrecio;
	}

	public void setMostrardescripcionTipoListaPrecio(Boolean mostrardescripcionTipoListaPrecio) {
		this.mostrardescripcionTipoListaPrecio= mostrardescripcionTipoListaPrecio;
	}

	public Boolean getActivardescripcionTipoListaPrecio() {
		return this.activardescripcionTipoListaPrecio;
	}

	public void setActivardescripcionTipoListaPrecio(Boolean activardescripcionTipoListaPrecio) {
		this.activardescripcionTipoListaPrecio= activardescripcionTipoListaPrecio;
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
		
		
		this.setMostraridTipoListaPrecio(esInicial);
		this.setMostrarid_empresaTipoListaPrecio(esInicial);
		this.setMostrarcodigoTipoListaPrecio(esInicial);
		this.setMostrarnombreTipoListaPrecio(esInicial);
		this.setMostrarfecha_desdeTipoListaPrecio(esInicial);
		this.setMostrarfecha_hastaTipoListaPrecio(esInicial);
		this.setMostraresta_activoTipoListaPrecio(esInicial);
		this.setMostrardescripcionTipoListaPrecio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoListaPrecioConstantesFunciones.ID)) {
				this.setMostraridTipoListaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoListaPrecioConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoListaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoListaPrecioConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoListaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoListaPrecioConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoListaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoListaPrecioConstantesFunciones.FECHADESDE)) {
				this.setMostrarfecha_desdeTipoListaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoListaPrecioConstantesFunciones.FECHAHASTA)) {
				this.setMostrarfecha_hastaTipoListaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoListaPrecioConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoTipoListaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoListaPrecioConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionTipoListaPrecio(esAsigna);
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
		
		
		this.setActivaridTipoListaPrecio(esInicial);
		this.setActivarid_empresaTipoListaPrecio(esInicial);
		this.setActivarcodigoTipoListaPrecio(esInicial);
		this.setActivarnombreTipoListaPrecio(esInicial);
		this.setActivarfecha_desdeTipoListaPrecio(esInicial);
		this.setActivarfecha_hastaTipoListaPrecio(esInicial);
		this.setActivaresta_activoTipoListaPrecio(esInicial);
		this.setActivardescripcionTipoListaPrecio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoListaPrecioConstantesFunciones.ID)) {
				this.setActivaridTipoListaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoListaPrecioConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoListaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoListaPrecioConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoListaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoListaPrecioConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoListaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoListaPrecioConstantesFunciones.FECHADESDE)) {
				this.setActivarfecha_desdeTipoListaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoListaPrecioConstantesFunciones.FECHAHASTA)) {
				this.setActivarfecha_hastaTipoListaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoListaPrecioConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoTipoListaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoListaPrecioConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionTipoListaPrecio(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoListaPrecioBeanSwingJInternalFrame tipolistaprecioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoListaPrecio(esInicial);
		this.setResaltarid_empresaTipoListaPrecio(esInicial);
		this.setResaltarcodigoTipoListaPrecio(esInicial);
		this.setResaltarnombreTipoListaPrecio(esInicial);
		this.setResaltarfecha_desdeTipoListaPrecio(esInicial);
		this.setResaltarfecha_hastaTipoListaPrecio(esInicial);
		this.setResaltaresta_activoTipoListaPrecio(esInicial);
		this.setResaltardescripcionTipoListaPrecio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoListaPrecioConstantesFunciones.ID)) {
				this.setResaltaridTipoListaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoListaPrecioConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoListaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoListaPrecioConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoListaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoListaPrecioConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoListaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoListaPrecioConstantesFunciones.FECHADESDE)) {
				this.setResaltarfecha_desdeTipoListaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoListaPrecioConstantesFunciones.FECHAHASTA)) {
				this.setResaltarfecha_hastaTipoListaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoListaPrecioConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoTipoListaPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoListaPrecioConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionTipoListaPrecio(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarClienteTipoListaPrecio=null;

	public Border getResaltarClienteTipoListaPrecio() {
		return this.resaltarClienteTipoListaPrecio;
	}

	public void setResaltarClienteTipoListaPrecio(Border borderResaltarCliente) {
		if(borderResaltarCliente!=null) {
			this.resaltarClienteTipoListaPrecio= borderResaltarCliente;
		}
	}

	public Border setResaltarClienteTipoListaPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoListaPrecioBeanSwingJInternalFrame tipolistaprecioBeanSwingJInternalFrame*/) {
		Border borderResaltarCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipolistaprecioBeanSwingJInternalFrame.jTtoolBarTipoListaPrecio.setBorder(borderResaltarCliente);
			
		this.resaltarClienteTipoListaPrecio= borderResaltarCliente;

		 return borderResaltarCliente;
	}



	public Boolean mostrarClienteTipoListaPrecio=true;

	public Boolean getMostrarClienteTipoListaPrecio() {
		return this.mostrarClienteTipoListaPrecio;
	}

	public void setMostrarClienteTipoListaPrecio(Boolean visibilidadResaltarCliente) {
		this.mostrarClienteTipoListaPrecio= visibilidadResaltarCliente;
	}



	public Boolean activarClienteTipoListaPrecio=true;

	public Boolean gethabilitarResaltarClienteTipoListaPrecio() {
		return this.activarClienteTipoListaPrecio;
	}

	public void setActivarClienteTipoListaPrecio(Boolean habilitarResaltarCliente) {
		this.activarClienteTipoListaPrecio= habilitarResaltarCliente;
	}


	public Border resaltarParametroCarteraDefectoTipoListaPrecio=null;

	public Border getResaltarParametroCarteraDefectoTipoListaPrecio() {
		return this.resaltarParametroCarteraDefectoTipoListaPrecio;
	}

	public void setResaltarParametroCarteraDefectoTipoListaPrecio(Border borderResaltarParametroCarteraDefecto) {
		if(borderResaltarParametroCarteraDefecto!=null) {
			this.resaltarParametroCarteraDefectoTipoListaPrecio= borderResaltarParametroCarteraDefecto;
		}
	}

	public Border setResaltarParametroCarteraDefectoTipoListaPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoListaPrecioBeanSwingJInternalFrame tipolistaprecioBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroCarteraDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipolistaprecioBeanSwingJInternalFrame.jTtoolBarTipoListaPrecio.setBorder(borderResaltarParametroCarteraDefecto);
			
		this.resaltarParametroCarteraDefectoTipoListaPrecio= borderResaltarParametroCarteraDefecto;

		 return borderResaltarParametroCarteraDefecto;
	}



	public Boolean mostrarParametroCarteraDefectoTipoListaPrecio=true;

	public Boolean getMostrarParametroCarteraDefectoTipoListaPrecio() {
		return this.mostrarParametroCarteraDefectoTipoListaPrecio;
	}

	public void setMostrarParametroCarteraDefectoTipoListaPrecio(Boolean visibilidadResaltarParametroCarteraDefecto) {
		this.mostrarParametroCarteraDefectoTipoListaPrecio= visibilidadResaltarParametroCarteraDefecto;
	}



	public Boolean activarParametroCarteraDefectoTipoListaPrecio=true;

	public Boolean gethabilitarResaltarParametroCarteraDefectoTipoListaPrecio() {
		return this.activarParametroCarteraDefectoTipoListaPrecio;
	}

	public void setActivarParametroCarteraDefectoTipoListaPrecio(Boolean habilitarResaltarParametroCarteraDefecto) {
		this.activarParametroCarteraDefectoTipoListaPrecio= habilitarResaltarParametroCarteraDefecto;
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

		this.setMostrarClienteTipoListaPrecio(esInicial);
		this.setMostrarParametroCarteraDefectoTipoListaPrecio(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setMostrarClienteTipoListaPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setMostrarParametroCarteraDefectoTipoListaPrecio(esAsigna);
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

		this.setActivarClienteTipoListaPrecio(esInicial);
		this.setActivarParametroCarteraDefectoTipoListaPrecio(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setActivarClienteTipoListaPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setActivarParametroCarteraDefectoTipoListaPrecio(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoListaPrecioBeanSwingJInternalFrame tipolistaprecioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarClienteTipoListaPrecio(esInicial);
		this.setResaltarParametroCarteraDefectoTipoListaPrecio(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setResaltarClienteTipoListaPrecio(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setResaltarParametroCarteraDefectoTipoListaPrecio(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoListaPrecio=true;

	public Boolean getMostrarFK_IdEmpresaTipoListaPrecio() {
		return this.mostrarFK_IdEmpresaTipoListaPrecio;
	}

	public void setMostrarFK_IdEmpresaTipoListaPrecio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoListaPrecio= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoListaPrecio=true;

	public Boolean getActivarFK_IdEmpresaTipoListaPrecio() {
		return this.activarFK_IdEmpresaTipoListaPrecio;
	}

	public void setActivarFK_IdEmpresaTipoListaPrecio(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoListaPrecio= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoListaPrecio=null;

	public Border getResaltarFK_IdEmpresaTipoListaPrecio() {
		return this.resaltarFK_IdEmpresaTipoListaPrecio;
	}

	public void setResaltarFK_IdEmpresaTipoListaPrecio(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoListaPrecio= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoListaPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoListaPrecioBeanSwingJInternalFrame tipolistaprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoListaPrecio= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}