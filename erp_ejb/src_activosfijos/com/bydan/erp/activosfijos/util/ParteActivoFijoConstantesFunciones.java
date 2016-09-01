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
package com.bydan.erp.activosfijos.util;

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


import com.bydan.erp.activosfijos.util.ParteActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.ParteActivoFijoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.ParteActivoFijoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ParteActivoFijoConstantesFunciones extends ParteActivoFijoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ParteActivoFijo";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParteActivoFijo"+ParteActivoFijoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParteActivoFijoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParteActivoFijoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParteActivoFijoConstantesFunciones.SCHEMA+"_"+ParteActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParteActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParteActivoFijoConstantesFunciones.SCHEMA+"_"+ParteActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParteActivoFijoConstantesFunciones.SCHEMA+"_"+ParteActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParteActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParteActivoFijoConstantesFunciones.SCHEMA+"_"+ParteActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParteActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParteActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParteActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParteActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParteActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParteActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParteActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParteActivoFijoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParteActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParteActivoFijoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parte Activo Fijos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Parte Activo Fijo";
	public static final String SCLASSWEBTITULO_LOWER="Parte Activo Fijo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParteActivoFijo";
	public static final String OBJECTNAME="parteactivofijo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="parte_activo_fijo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parteactivofijo from "+ParteActivoFijoConstantesFunciones.SPERSISTENCENAME+" parteactivofijo";
	public static String QUERYSELECTNATIVE="select "+ParteActivoFijoConstantesFunciones.SCHEMA+"."+ParteActivoFijoConstantesFunciones.TABLENAME+".id,"+ParteActivoFijoConstantesFunciones.SCHEMA+"."+ParteActivoFijoConstantesFunciones.TABLENAME+".version_row,"+ParteActivoFijoConstantesFunciones.SCHEMA+"."+ParteActivoFijoConstantesFunciones.TABLENAME+".id_empresa,"+ParteActivoFijoConstantesFunciones.SCHEMA+"."+ParteActivoFijoConstantesFunciones.TABLENAME+".id_sucursal,"+ParteActivoFijoConstantesFunciones.SCHEMA+"."+ParteActivoFijoConstantesFunciones.TABLENAME+".id_estado_activo_fijo,"+ParteActivoFijoConstantesFunciones.SCHEMA+"."+ParteActivoFijoConstantesFunciones.TABLENAME+".id_detalle_activo_fijo,"+ParteActivoFijoConstantesFunciones.SCHEMA+"."+ParteActivoFijoConstantesFunciones.TABLENAME+".codigo,"+ParteActivoFijoConstantesFunciones.SCHEMA+"."+ParteActivoFijoConstantesFunciones.TABLENAME+".nombre,"+ParteActivoFijoConstantesFunciones.SCHEMA+"."+ParteActivoFijoConstantesFunciones.TABLENAME+".marca,"+ParteActivoFijoConstantesFunciones.SCHEMA+"."+ParteActivoFijoConstantesFunciones.TABLENAME+".serie,"+ParteActivoFijoConstantesFunciones.SCHEMA+"."+ParteActivoFijoConstantesFunciones.TABLENAME+".cantidad,"+ParteActivoFijoConstantesFunciones.SCHEMA+"."+ParteActivoFijoConstantesFunciones.TABLENAME+".foto from "+ParteActivoFijoConstantesFunciones.SCHEMA+"."+ParteActivoFijoConstantesFunciones.TABLENAME;//+" as "+ParteActivoFijoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParteActivoFijoConstantesFuncionesAdditional parteactivofijoConstantesFuncionesAdditional=null;
	
	public ParteActivoFijoConstantesFuncionesAdditional getParteActivoFijoConstantesFuncionesAdditional() {
		return this.parteactivofijoConstantesFuncionesAdditional;
	}
	
	public void setParteActivoFijoConstantesFuncionesAdditional(ParteActivoFijoConstantesFuncionesAdditional parteactivofijoConstantesFuncionesAdditional) {
		try {
			this.parteactivofijoConstantesFuncionesAdditional=parteactivofijoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDESTADOACTIVOFIJO= "id_estado_activo_fijo";
    public static final String IDDETALLEACTIVOFIJO= "id_detalle_activo_fijo";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String MARCA= "marca";
    public static final String SERIE= "serie";
    public static final String CANTIDAD= "cantidad";
    public static final String FOTO= "foto";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDESTADOACTIVOFIJO= "Estado Activo Fijo";
		public static final String LABEL_IDESTADOACTIVOFIJO_LOWER= "Estado Activo Fijo";
    	public static final String LABEL_IDDETALLEACTIVOFIJO= "Detalle Activo Fijo";
		public static final String LABEL_IDDETALLEACTIVOFIJO_LOWER= "Detalle Activo Fijo";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_MARCA= "Marca";
		public static final String LABEL_MARCA_LOWER= "Marca";
    	public static final String LABEL_SERIE= "Serie";
		public static final String LABEL_SERIE_LOWER= "Serie";
    	public static final String LABEL_CANTIDAD= "Cantidad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_FOTO= "Foto";
		public static final String LABEL_FOTO_LOWER= "Foto";
	
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXMARCA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXMARCA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSERIE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSERIE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXFOTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXFOTO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getParteActivoFijoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParteActivoFijoConstantesFunciones.IDEMPRESA)) {sLabelColumna=ParteActivoFijoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ParteActivoFijoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ParteActivoFijoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ParteActivoFijoConstantesFunciones.IDESTADOACTIVOFIJO)) {sLabelColumna=ParteActivoFijoConstantesFunciones.LABEL_IDESTADOACTIVOFIJO;}
		if(sNombreColumna.equals(ParteActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO)) {sLabelColumna=ParteActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO;}
		if(sNombreColumna.equals(ParteActivoFijoConstantesFunciones.CODIGO)) {sLabelColumna=ParteActivoFijoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ParteActivoFijoConstantesFunciones.NOMBRE)) {sLabelColumna=ParteActivoFijoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(ParteActivoFijoConstantesFunciones.MARCA)) {sLabelColumna=ParteActivoFijoConstantesFunciones.LABEL_MARCA;}
		if(sNombreColumna.equals(ParteActivoFijoConstantesFunciones.SERIE)) {sLabelColumna=ParteActivoFijoConstantesFunciones.LABEL_SERIE;}
		if(sNombreColumna.equals(ParteActivoFijoConstantesFunciones.CANTIDAD)) {sLabelColumna=ParteActivoFijoConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(ParteActivoFijoConstantesFunciones.FOTO)) {sLabelColumna=ParteActivoFijoConstantesFunciones.LABEL_FOTO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getParteActivoFijoDescripcion(ParteActivoFijo parteactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parteactivofijo !=null/* && parteactivofijo.getId()!=0*/) {
			sDescripcion=parteactivofijo.getcodigo();//parteactivofijoparteactivofijo.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getParteActivoFijoDescripcionDetallado(ParteActivoFijo parteactivofijo) {
		String sDescripcion="";
			
		sDescripcion+=ParteActivoFijoConstantesFunciones.ID+"=";
		sDescripcion+=parteactivofijo.getId().toString()+",";
		sDescripcion+=ParteActivoFijoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parteactivofijo.getVersionRow().toString()+",";
		sDescripcion+=ParteActivoFijoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=parteactivofijo.getid_empresa().toString()+",";
		sDescripcion+=ParteActivoFijoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=parteactivofijo.getid_sucursal().toString()+",";
		sDescripcion+=ParteActivoFijoConstantesFunciones.IDESTADOACTIVOFIJO+"=";
		sDescripcion+=parteactivofijo.getid_estado_activo_fijo().toString()+",";
		sDescripcion+=ParteActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO+"=";
		sDescripcion+=parteactivofijo.getid_detalle_activo_fijo().toString()+",";
		sDescripcion+=ParteActivoFijoConstantesFunciones.CODIGO+"=";
		sDescripcion+=parteactivofijo.getcodigo()+",";
		sDescripcion+=ParteActivoFijoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=parteactivofijo.getnombre()+",";
		sDescripcion+=ParteActivoFijoConstantesFunciones.MARCA+"=";
		sDescripcion+=parteactivofijo.getmarca()+",";
		sDescripcion+=ParteActivoFijoConstantesFunciones.SERIE+"=";
		sDescripcion+=parteactivofijo.getserie()+",";
		sDescripcion+=ParteActivoFijoConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=parteactivofijo.getcantidad().toString()+",";
		sDescripcion+=ParteActivoFijoConstantesFunciones.FOTO+"=";
		sDescripcion+=parteactivofijo.getfoto()+",";
			
		return sDescripcion;
	}
	
	public static void setParteActivoFijoDescripcion(ParteActivoFijo parteactivofijo,String sValor) throws Exception {			
		if(parteactivofijo !=null) {
			parteactivofijo.setcodigo(sValor);;//parteactivofijoparteactivofijo.getcodigo().trim();
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

	public static String getEstadoActivoFijoDescripcion(EstadoActivoFijo estadoactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadoactivofijo!=null/*&&estadoactivofijo.getId()>0*/) {
			sDescripcion=EstadoActivoFijoConstantesFunciones.getEstadoActivoFijoDescripcion(estadoactivofijo);
		}

		return sDescripcion;
	}

	public static String getDetalleActivoFijoDescripcion(DetalleActivoFijo detalleactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(detalleactivofijo!=null/*&&detalleactivofijo.getId()>0*/) {
			sDescripcion=DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(detalleactivofijo);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdDetalleActivoFijo")) {
			sNombreIndice="Tipo=  Por Detalle Activo Fijo";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoActivoFijo")) {
			sNombreIndice="Tipo=  Por Estado Activo Fijo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdDetalleActivoFijo(Long id_detalle_activo_fijo) {
		String sDetalleIndice=" Parametros->";
		if(id_detalle_activo_fijo!=null) {sDetalleIndice+=" Codigo Unico De Detalle Activo Fijo="+id_detalle_activo_fijo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoActivoFijo(Long id_estado_activo_fijo) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_activo_fijo!=null) {sDetalleIndice+=" Codigo Unico De Estado Activo Fijo="+id_estado_activo_fijo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosParteActivoFijo(ParteActivoFijo parteactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		parteactivofijo.setcodigo(parteactivofijo.getcodigo().trim());
		parteactivofijo.setnombre(parteactivofijo.getnombre().trim());
		parteactivofijo.setmarca(parteactivofijo.getmarca().trim());
		parteactivofijo.setserie(parteactivofijo.getserie().trim());
		parteactivofijo.setfoto(parteactivofijo.getfoto().trim());
	}
	
	public static void quitarEspaciosParteActivoFijos(List<ParteActivoFijo> parteactivofijos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParteActivoFijo parteactivofijo: parteactivofijos) {
			parteactivofijo.setcodigo(parteactivofijo.getcodigo().trim());
			parteactivofijo.setnombre(parteactivofijo.getnombre().trim());
			parteactivofijo.setmarca(parteactivofijo.getmarca().trim());
			parteactivofijo.setserie(parteactivofijo.getserie().trim());
			parteactivofijo.setfoto(parteactivofijo.getfoto().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParteActivoFijo(ParteActivoFijo parteactivofijo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parteactivofijo.getConCambioAuxiliar()) {
			parteactivofijo.setIsDeleted(parteactivofijo.getIsDeletedAuxiliar());	
			parteactivofijo.setIsNew(parteactivofijo.getIsNewAuxiliar());	
			parteactivofijo.setIsChanged(parteactivofijo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parteactivofijo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parteactivofijo.setIsDeletedAuxiliar(false);	
			parteactivofijo.setIsNewAuxiliar(false);	
			parteactivofijo.setIsChangedAuxiliar(false);
			
			parteactivofijo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParteActivoFijos(List<ParteActivoFijo> parteactivofijos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParteActivoFijo parteactivofijo : parteactivofijos) {
			if(conAsignarBase && parteactivofijo.getConCambioAuxiliar()) {
				parteactivofijo.setIsDeleted(parteactivofijo.getIsDeletedAuxiliar());	
				parteactivofijo.setIsNew(parteactivofijo.getIsNewAuxiliar());	
				parteactivofijo.setIsChanged(parteactivofijo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parteactivofijo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parteactivofijo.setIsDeletedAuxiliar(false);	
				parteactivofijo.setIsNewAuxiliar(false);	
				parteactivofijo.setIsChangedAuxiliar(false);
				
				parteactivofijo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParteActivoFijo(ParteActivoFijo parteactivofijo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			parteactivofijo.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresParteActivoFijos(List<ParteActivoFijo> parteactivofijos,Boolean conEnteros) throws Exception  {
		
		for(ParteActivoFijo parteactivofijo: parteactivofijos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				parteactivofijo.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaParteActivoFijo(List<ParteActivoFijo> parteactivofijos,ParteActivoFijo parteactivofijoAux) throws Exception  {
		ParteActivoFijoConstantesFunciones.InicializarValoresParteActivoFijo(parteactivofijoAux,true);
		
		for(ParteActivoFijo parteactivofijo: parteactivofijos) {
			if(parteactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			parteactivofijoAux.setcantidad(parteactivofijoAux.getcantidad()+parteactivofijo.getcantidad());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParteActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParteActivoFijoConstantesFunciones.getArrayColumnasGlobalesParteActivoFijo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParteActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParteActivoFijoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParteActivoFijoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParteActivoFijoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParteActivoFijoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParteActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParteActivoFijo> parteactivofijos,ParteActivoFijo parteactivofijo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParteActivoFijo parteactivofijoAux: parteactivofijos) {
			if(parteactivofijoAux!=null && parteactivofijo!=null) {
				if((parteactivofijoAux.getId()==null && parteactivofijo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parteactivofijoAux.getId()!=null && parteactivofijo.getId()!=null){
					if(parteactivofijoAux.getId().equals(parteactivofijo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParteActivoFijo(List<ParteActivoFijo> parteactivofijos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ParteActivoFijo parteactivofijo: parteactivofijos) {			
			if(parteactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParteActivoFijo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParteActivoFijoConstantesFunciones.LABEL_ID, ParteActivoFijoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParteActivoFijoConstantesFunciones.LABEL_VERSIONROW, ParteActivoFijoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParteActivoFijoConstantesFunciones.LABEL_IDEMPRESA, ParteActivoFijoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParteActivoFijoConstantesFunciones.LABEL_IDSUCURSAL, ParteActivoFijoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParteActivoFijoConstantesFunciones.LABEL_IDESTADOACTIVOFIJO, ParteActivoFijoConstantesFunciones.IDESTADOACTIVOFIJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParteActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO, ParteActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParteActivoFijoConstantesFunciones.LABEL_CODIGO, ParteActivoFijoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParteActivoFijoConstantesFunciones.LABEL_NOMBRE, ParteActivoFijoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParteActivoFijoConstantesFunciones.LABEL_MARCA, ParteActivoFijoConstantesFunciones.MARCA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParteActivoFijoConstantesFunciones.LABEL_SERIE, ParteActivoFijoConstantesFunciones.SERIE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParteActivoFijoConstantesFunciones.LABEL_CANTIDAD, ParteActivoFijoConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParteActivoFijoConstantesFunciones.LABEL_FOTO, ParteActivoFijoConstantesFunciones.FOTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParteActivoFijo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParteActivoFijoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParteActivoFijoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParteActivoFijoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParteActivoFijoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParteActivoFijoConstantesFunciones.IDESTADOACTIVOFIJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParteActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParteActivoFijoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParteActivoFijoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParteActivoFijoConstantesFunciones.MARCA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParteActivoFijoConstantesFunciones.SERIE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParteActivoFijoConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParteActivoFijoConstantesFunciones.FOTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParteActivoFijo() throws Exception  {
		return ParteActivoFijoConstantesFunciones.getTiposSeleccionarParteActivoFijo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParteActivoFijo(Boolean conFk) throws Exception  {
		return ParteActivoFijoConstantesFunciones.getTiposSeleccionarParteActivoFijo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParteActivoFijo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParteActivoFijoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ParteActivoFijoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParteActivoFijoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ParteActivoFijoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParteActivoFijoConstantesFunciones.LABEL_IDESTADOACTIVOFIJO);
			reporte.setsDescripcion(ParteActivoFijoConstantesFunciones.LABEL_IDESTADOACTIVOFIJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParteActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO);
			reporte.setsDescripcion(ParteActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParteActivoFijoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ParteActivoFijoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParteActivoFijoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ParteActivoFijoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParteActivoFijoConstantesFunciones.LABEL_MARCA);
			reporte.setsDescripcion(ParteActivoFijoConstantesFunciones.LABEL_MARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParteActivoFijoConstantesFunciones.LABEL_SERIE);
			reporte.setsDescripcion(ParteActivoFijoConstantesFunciones.LABEL_SERIE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParteActivoFijoConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(ParteActivoFijoConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParteActivoFijoConstantesFunciones.LABEL_FOTO);
			reporte.setsDescripcion(ParteActivoFijoConstantesFunciones.LABEL_FOTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParteActivoFijo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParteActivoFijo(ParteActivoFijo parteactivofijoAux) throws Exception {
		
			parteactivofijoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parteactivofijoAux.getEmpresa()));
			parteactivofijoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parteactivofijoAux.getSucursal()));
			parteactivofijoAux.setestadoactivofijo_descripcion(EstadoActivoFijoConstantesFunciones.getEstadoActivoFijoDescripcion(parteactivofijoAux.getEstadoActivoFijo()));
			parteactivofijoAux.setdetalleactivofijo_descripcion(DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(parteactivofijoAux.getDetalleActivoFijo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesParteActivoFijo(List<ParteActivoFijo> parteactivofijosTemp) throws Exception {
		for(ParteActivoFijo parteactivofijoAux:parteactivofijosTemp) {
			
			parteactivofijoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parteactivofijoAux.getEmpresa()));
			parteactivofijoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parteactivofijoAux.getSucursal()));
			parteactivofijoAux.setestadoactivofijo_descripcion(EstadoActivoFijoConstantesFunciones.getEstadoActivoFijoDescripcion(parteactivofijoAux.getEstadoActivoFijo()));
			parteactivofijoAux.setdetalleactivofijo_descripcion(DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(parteactivofijoAux.getDetalleActivoFijo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParteActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(EstadoActivoFijo.class));
				classes.add(new Classe(DetalleActivoFijo.class));
				
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
					if(clas.clas.equals(EstadoActivoFijo.class)) {
						classes.add(new Classe(EstadoActivoFijo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleActivoFijo.class)) {
						classes.add(new Classe(DetalleActivoFijo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParteActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(EstadoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoActivoFijo.class)); continue;
					}

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
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

					if(EstadoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoActivoFijo.class)); continue;
					}

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParteActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParteActivoFijoConstantesFunciones.getClassesRelationshipsOfParteActivoFijo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParteActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParteActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParteActivoFijoConstantesFunciones.getClassesRelationshipsFromStringsOfParteActivoFijo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParteActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ParteActivoFijo parteactivofijo,List<ParteActivoFijo> parteactivofijos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParteActivoFijo parteactivofijoEncontrado=null;
			
			for(ParteActivoFijo parteactivofijoLocal:parteactivofijos) {
				if(parteactivofijoLocal.getId().equals(parteactivofijo.getId())) {
					parteactivofijoEncontrado=parteactivofijoLocal;
					
					parteactivofijoLocal.setIsChanged(parteactivofijo.getIsChanged());
					parteactivofijoLocal.setIsNew(parteactivofijo.getIsNew());
					parteactivofijoLocal.setIsDeleted(parteactivofijo.getIsDeleted());
					
					parteactivofijoLocal.setGeneralEntityOriginal(parteactivofijo.getGeneralEntityOriginal());
					
					parteactivofijoLocal.setId(parteactivofijo.getId());	
					parteactivofijoLocal.setVersionRow(parteactivofijo.getVersionRow());	
					parteactivofijoLocal.setid_empresa(parteactivofijo.getid_empresa());	
					parteactivofijoLocal.setid_sucursal(parteactivofijo.getid_sucursal());	
					parteactivofijoLocal.setid_estado_activo_fijo(parteactivofijo.getid_estado_activo_fijo());	
					parteactivofijoLocal.setid_detalle_activo_fijo(parteactivofijo.getid_detalle_activo_fijo());	
					parteactivofijoLocal.setcodigo(parteactivofijo.getcodigo());	
					parteactivofijoLocal.setnombre(parteactivofijo.getnombre());	
					parteactivofijoLocal.setmarca(parteactivofijo.getmarca());	
					parteactivofijoLocal.setserie(parteactivofijo.getserie());	
					parteactivofijoLocal.setcantidad(parteactivofijo.getcantidad());	
					parteactivofijoLocal.setfoto(parteactivofijo.getfoto());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!parteactivofijo.getIsDeleted()) {
				if(!existe) {
					parteactivofijos.add(parteactivofijo);
				}
			} else {
				if(parteactivofijoEncontrado!=null && permiteQuitar)  {
					parteactivofijos.remove(parteactivofijoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParteActivoFijo parteactivofijo,List<ParteActivoFijo> parteactivofijos) throws Exception {
		try	{			
			for(ParteActivoFijo parteactivofijoLocal:parteactivofijos) {
				if(parteactivofijoLocal.getId().equals(parteactivofijo.getId())) {
					parteactivofijoLocal.setIsSelected(parteactivofijo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParteActivoFijo(List<ParteActivoFijo> parteactivofijosAux) throws Exception {
		//this.parteactivofijosAux=parteactivofijosAux;
		
		for(ParteActivoFijo parteactivofijoAux:parteactivofijosAux) {
			if(parteactivofijoAux.getIsChanged()) {
				parteactivofijoAux.setIsChanged(false);
			}		
			
			if(parteactivofijoAux.getIsNew()) {
				parteactivofijoAux.setIsNew(false);
			}	
			
			if(parteactivofijoAux.getIsDeleted()) {
				parteactivofijoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParteActivoFijo(ParteActivoFijo parteactivofijoAux) throws Exception {
		//this.parteactivofijoAux=parteactivofijoAux;
		
			if(parteactivofijoAux.getIsChanged()) {
				parteactivofijoAux.setIsChanged(false);
			}		
			
			if(parteactivofijoAux.getIsNew()) {
				parteactivofijoAux.setIsNew(false);
			}	
			
			if(parteactivofijoAux.getIsDeleted()) {
				parteactivofijoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParteActivoFijo parteactivofijoAsignar,ParteActivoFijo parteactivofijo) throws Exception {
		parteactivofijoAsignar.setId(parteactivofijo.getId());	
		parteactivofijoAsignar.setVersionRow(parteactivofijo.getVersionRow());	
		parteactivofijoAsignar.setid_empresa(parteactivofijo.getid_empresa());
		parteactivofijoAsignar.setempresa_descripcion(parteactivofijo.getempresa_descripcion());	
		parteactivofijoAsignar.setid_sucursal(parteactivofijo.getid_sucursal());
		parteactivofijoAsignar.setsucursal_descripcion(parteactivofijo.getsucursal_descripcion());	
		parteactivofijoAsignar.setid_estado_activo_fijo(parteactivofijo.getid_estado_activo_fijo());
		parteactivofijoAsignar.setestadoactivofijo_descripcion(parteactivofijo.getestadoactivofijo_descripcion());	
		parteactivofijoAsignar.setid_detalle_activo_fijo(parteactivofijo.getid_detalle_activo_fijo());
		parteactivofijoAsignar.setdetalleactivofijo_descripcion(parteactivofijo.getdetalleactivofijo_descripcion());	
		parteactivofijoAsignar.setcodigo(parteactivofijo.getcodigo());	
		parteactivofijoAsignar.setnombre(parteactivofijo.getnombre());	
		parteactivofijoAsignar.setmarca(parteactivofijo.getmarca());	
		parteactivofijoAsignar.setserie(parteactivofijo.getserie());	
		parteactivofijoAsignar.setcantidad(parteactivofijo.getcantidad());	
		parteactivofijoAsignar.setfoto(parteactivofijo.getfoto());	
	}
	
	public static void inicializarParteActivoFijo(ParteActivoFijo parteactivofijo) throws Exception {
		try {
				parteactivofijo.setId(0L);	
					
				parteactivofijo.setid_empresa(-1L);	
				parteactivofijo.setid_sucursal(-1L);	
				parteactivofijo.setid_estado_activo_fijo(-1L);	
				parteactivofijo.setid_detalle_activo_fijo(-1L);	
				parteactivofijo.setcodigo("");	
				parteactivofijo.setnombre("");	
				parteactivofijo.setmarca("");	
				parteactivofijo.setserie("");	
				parteactivofijo.setcantidad(0);	
				parteactivofijo.setfoto("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParteActivoFijo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParteActivoFijoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParteActivoFijoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParteActivoFijoConstantesFunciones.LABEL_IDESTADOACTIVOFIJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParteActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParteActivoFijoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParteActivoFijoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParteActivoFijoConstantesFunciones.LABEL_MARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParteActivoFijoConstantesFunciones.LABEL_SERIE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParteActivoFijoConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParteActivoFijoConstantesFunciones.LABEL_FOTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParteActivoFijo(String sTipo,Row row,Workbook workbook,ParteActivoFijo parteactivofijo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parteactivofijo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parteactivofijo.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parteactivofijo.getestadoactivofijo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parteactivofijo.getdetalleactivofijo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parteactivofijo.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parteactivofijo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parteactivofijo.getmarca());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parteactivofijo.getserie());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parteactivofijo.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parteactivofijo.getfoto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParteActivoFijo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParteActivoFijo() {
		return this.sFinalQueryParteActivoFijo;
	}
	
	public void setsFinalQueryParteActivoFijo(String sFinalQueryParteActivoFijo) {
		this.sFinalQueryParteActivoFijo= sFinalQueryParteActivoFijo;
	}
	
	public Border resaltarSeleccionarParteActivoFijo=null;
	
	public Border setResaltarSeleccionarParteActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ParteActivoFijoBeanSwingJInternalFrame parteactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parteactivofijoBeanSwingJInternalFrame.jTtoolBarParteActivoFijo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParteActivoFijo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParteActivoFijo() {
		return this.resaltarSeleccionarParteActivoFijo;
	}
	
	public void setResaltarSeleccionarParteActivoFijo(Border borderResaltarSeleccionarParteActivoFijo) {
		this.resaltarSeleccionarParteActivoFijo= borderResaltarSeleccionarParteActivoFijo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParteActivoFijo=null;
	public Boolean mostraridParteActivoFijo=true;
	public Boolean activaridParteActivoFijo=true;

	public Border resaltarid_empresaParteActivoFijo=null;
	public Boolean mostrarid_empresaParteActivoFijo=true;
	public Boolean activarid_empresaParteActivoFijo=true;
	public Boolean cargarid_empresaParteActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaParteActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_sucursalParteActivoFijo=null;
	public Boolean mostrarid_sucursalParteActivoFijo=true;
	public Boolean activarid_sucursalParteActivoFijo=true;
	public Boolean cargarid_sucursalParteActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalParteActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_estado_activo_fijoParteActivoFijo=null;
	public Boolean mostrarid_estado_activo_fijoParteActivoFijo=true;
	public Boolean activarid_estado_activo_fijoParteActivoFijo=true;
	public Boolean cargarid_estado_activo_fijoParteActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_activo_fijoParteActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_detalle_activo_fijoParteActivoFijo=null;
	public Boolean mostrarid_detalle_activo_fijoParteActivoFijo=true;
	public Boolean activarid_detalle_activo_fijoParteActivoFijo=true;
	public Boolean cargarid_detalle_activo_fijoParteActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_detalle_activo_fijoParteActivoFijo=false;//ConEventDepend=true

	public Border resaltarcodigoParteActivoFijo=null;
	public Boolean mostrarcodigoParteActivoFijo=true;
	public Boolean activarcodigoParteActivoFijo=true;

	public Border resaltarnombreParteActivoFijo=null;
	public Boolean mostrarnombreParteActivoFijo=true;
	public Boolean activarnombreParteActivoFijo=true;

	public Border resaltarmarcaParteActivoFijo=null;
	public Boolean mostrarmarcaParteActivoFijo=true;
	public Boolean activarmarcaParteActivoFijo=true;

	public Border resaltarserieParteActivoFijo=null;
	public Boolean mostrarserieParteActivoFijo=true;
	public Boolean activarserieParteActivoFijo=true;

	public Border resaltarcantidadParteActivoFijo=null;
	public Boolean mostrarcantidadParteActivoFijo=true;
	public Boolean activarcantidadParteActivoFijo=true;

	public Border resaltarfotoParteActivoFijo=null;
	public Boolean mostrarfotoParteActivoFijo=true;
	public Boolean activarfotoParteActivoFijo=true;

	
	

	public Border setResaltaridParteActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ParteActivoFijoBeanSwingJInternalFrame parteactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parteactivofijoBeanSwingJInternalFrame.jTtoolBarParteActivoFijo.setBorder(borderResaltar);
		
		this.resaltaridParteActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParteActivoFijo() {
		return this.resaltaridParteActivoFijo;
	}

	public void setResaltaridParteActivoFijo(Border borderResaltar) {
		this.resaltaridParteActivoFijo= borderResaltar;
	}

	public Boolean getMostraridParteActivoFijo() {
		return this.mostraridParteActivoFijo;
	}

	public void setMostraridParteActivoFijo(Boolean mostraridParteActivoFijo) {
		this.mostraridParteActivoFijo= mostraridParteActivoFijo;
	}

	public Boolean getActivaridParteActivoFijo() {
		return this.activaridParteActivoFijo;
	}

	public void setActivaridParteActivoFijo(Boolean activaridParteActivoFijo) {
		this.activaridParteActivoFijo= activaridParteActivoFijo;
	}

	public Border setResaltarid_empresaParteActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ParteActivoFijoBeanSwingJInternalFrame parteactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parteactivofijoBeanSwingJInternalFrame.jTtoolBarParteActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_empresaParteActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaParteActivoFijo() {
		return this.resaltarid_empresaParteActivoFijo;
	}

	public void setResaltarid_empresaParteActivoFijo(Border borderResaltar) {
		this.resaltarid_empresaParteActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_empresaParteActivoFijo() {
		return this.mostrarid_empresaParteActivoFijo;
	}

	public void setMostrarid_empresaParteActivoFijo(Boolean mostrarid_empresaParteActivoFijo) {
		this.mostrarid_empresaParteActivoFijo= mostrarid_empresaParteActivoFijo;
	}

	public Boolean getActivarid_empresaParteActivoFijo() {
		return this.activarid_empresaParteActivoFijo;
	}

	public void setActivarid_empresaParteActivoFijo(Boolean activarid_empresaParteActivoFijo) {
		this.activarid_empresaParteActivoFijo= activarid_empresaParteActivoFijo;
	}

	public Boolean getCargarid_empresaParteActivoFijo() {
		return this.cargarid_empresaParteActivoFijo;
	}

	public void setCargarid_empresaParteActivoFijo(Boolean cargarid_empresaParteActivoFijo) {
		this.cargarid_empresaParteActivoFijo= cargarid_empresaParteActivoFijo;
	}

	public Border setResaltarid_sucursalParteActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ParteActivoFijoBeanSwingJInternalFrame parteactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parteactivofijoBeanSwingJInternalFrame.jTtoolBarParteActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_sucursalParteActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalParteActivoFijo() {
		return this.resaltarid_sucursalParteActivoFijo;
	}

	public void setResaltarid_sucursalParteActivoFijo(Border borderResaltar) {
		this.resaltarid_sucursalParteActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_sucursalParteActivoFijo() {
		return this.mostrarid_sucursalParteActivoFijo;
	}

	public void setMostrarid_sucursalParteActivoFijo(Boolean mostrarid_sucursalParteActivoFijo) {
		this.mostrarid_sucursalParteActivoFijo= mostrarid_sucursalParteActivoFijo;
	}

	public Boolean getActivarid_sucursalParteActivoFijo() {
		return this.activarid_sucursalParteActivoFijo;
	}

	public void setActivarid_sucursalParteActivoFijo(Boolean activarid_sucursalParteActivoFijo) {
		this.activarid_sucursalParteActivoFijo= activarid_sucursalParteActivoFijo;
	}

	public Boolean getCargarid_sucursalParteActivoFijo() {
		return this.cargarid_sucursalParteActivoFijo;
	}

	public void setCargarid_sucursalParteActivoFijo(Boolean cargarid_sucursalParteActivoFijo) {
		this.cargarid_sucursalParteActivoFijo= cargarid_sucursalParteActivoFijo;
	}

	public Border setResaltarid_estado_activo_fijoParteActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ParteActivoFijoBeanSwingJInternalFrame parteactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parteactivofijoBeanSwingJInternalFrame.jTtoolBarParteActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_estado_activo_fijoParteActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_activo_fijoParteActivoFijo() {
		return this.resaltarid_estado_activo_fijoParteActivoFijo;
	}

	public void setResaltarid_estado_activo_fijoParteActivoFijo(Border borderResaltar) {
		this.resaltarid_estado_activo_fijoParteActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_estado_activo_fijoParteActivoFijo() {
		return this.mostrarid_estado_activo_fijoParteActivoFijo;
	}

	public void setMostrarid_estado_activo_fijoParteActivoFijo(Boolean mostrarid_estado_activo_fijoParteActivoFijo) {
		this.mostrarid_estado_activo_fijoParteActivoFijo= mostrarid_estado_activo_fijoParteActivoFijo;
	}

	public Boolean getActivarid_estado_activo_fijoParteActivoFijo() {
		return this.activarid_estado_activo_fijoParteActivoFijo;
	}

	public void setActivarid_estado_activo_fijoParteActivoFijo(Boolean activarid_estado_activo_fijoParteActivoFijo) {
		this.activarid_estado_activo_fijoParteActivoFijo= activarid_estado_activo_fijoParteActivoFijo;
	}

	public Boolean getCargarid_estado_activo_fijoParteActivoFijo() {
		return this.cargarid_estado_activo_fijoParteActivoFijo;
	}

	public void setCargarid_estado_activo_fijoParteActivoFijo(Boolean cargarid_estado_activo_fijoParteActivoFijo) {
		this.cargarid_estado_activo_fijoParteActivoFijo= cargarid_estado_activo_fijoParteActivoFijo;
	}

	public Border setResaltarid_detalle_activo_fijoParteActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ParteActivoFijoBeanSwingJInternalFrame parteactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parteactivofijoBeanSwingJInternalFrame.jTtoolBarParteActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_detalle_activo_fijoParteActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_detalle_activo_fijoParteActivoFijo() {
		return this.resaltarid_detalle_activo_fijoParteActivoFijo;
	}

	public void setResaltarid_detalle_activo_fijoParteActivoFijo(Border borderResaltar) {
		this.resaltarid_detalle_activo_fijoParteActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_detalle_activo_fijoParteActivoFijo() {
		return this.mostrarid_detalle_activo_fijoParteActivoFijo;
	}

	public void setMostrarid_detalle_activo_fijoParteActivoFijo(Boolean mostrarid_detalle_activo_fijoParteActivoFijo) {
		this.mostrarid_detalle_activo_fijoParteActivoFijo= mostrarid_detalle_activo_fijoParteActivoFijo;
	}

	public Boolean getActivarid_detalle_activo_fijoParteActivoFijo() {
		return this.activarid_detalle_activo_fijoParteActivoFijo;
	}

	public void setActivarid_detalle_activo_fijoParteActivoFijo(Boolean activarid_detalle_activo_fijoParteActivoFijo) {
		this.activarid_detalle_activo_fijoParteActivoFijo= activarid_detalle_activo_fijoParteActivoFijo;
	}

	public Boolean getCargarid_detalle_activo_fijoParteActivoFijo() {
		return this.cargarid_detalle_activo_fijoParteActivoFijo;
	}

	public void setCargarid_detalle_activo_fijoParteActivoFijo(Boolean cargarid_detalle_activo_fijoParteActivoFijo) {
		this.cargarid_detalle_activo_fijoParteActivoFijo= cargarid_detalle_activo_fijoParteActivoFijo;
	}

	public Border setResaltarcodigoParteActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ParteActivoFijoBeanSwingJInternalFrame parteactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parteactivofijoBeanSwingJInternalFrame.jTtoolBarParteActivoFijo.setBorder(borderResaltar);
		
		this.resaltarcodigoParteActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoParteActivoFijo() {
		return this.resaltarcodigoParteActivoFijo;
	}

	public void setResaltarcodigoParteActivoFijo(Border borderResaltar) {
		this.resaltarcodigoParteActivoFijo= borderResaltar;
	}

	public Boolean getMostrarcodigoParteActivoFijo() {
		return this.mostrarcodigoParteActivoFijo;
	}

	public void setMostrarcodigoParteActivoFijo(Boolean mostrarcodigoParteActivoFijo) {
		this.mostrarcodigoParteActivoFijo= mostrarcodigoParteActivoFijo;
	}

	public Boolean getActivarcodigoParteActivoFijo() {
		return this.activarcodigoParteActivoFijo;
	}

	public void setActivarcodigoParteActivoFijo(Boolean activarcodigoParteActivoFijo) {
		this.activarcodigoParteActivoFijo= activarcodigoParteActivoFijo;
	}

	public Border setResaltarnombreParteActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ParteActivoFijoBeanSwingJInternalFrame parteactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parteactivofijoBeanSwingJInternalFrame.jTtoolBarParteActivoFijo.setBorder(borderResaltar);
		
		this.resaltarnombreParteActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreParteActivoFijo() {
		return this.resaltarnombreParteActivoFijo;
	}

	public void setResaltarnombreParteActivoFijo(Border borderResaltar) {
		this.resaltarnombreParteActivoFijo= borderResaltar;
	}

	public Boolean getMostrarnombreParteActivoFijo() {
		return this.mostrarnombreParteActivoFijo;
	}

	public void setMostrarnombreParteActivoFijo(Boolean mostrarnombreParteActivoFijo) {
		this.mostrarnombreParteActivoFijo= mostrarnombreParteActivoFijo;
	}

	public Boolean getActivarnombreParteActivoFijo() {
		return this.activarnombreParteActivoFijo;
	}

	public void setActivarnombreParteActivoFijo(Boolean activarnombreParteActivoFijo) {
		this.activarnombreParteActivoFijo= activarnombreParteActivoFijo;
	}

	public Border setResaltarmarcaParteActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ParteActivoFijoBeanSwingJInternalFrame parteactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parteactivofijoBeanSwingJInternalFrame.jTtoolBarParteActivoFijo.setBorder(borderResaltar);
		
		this.resaltarmarcaParteActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmarcaParteActivoFijo() {
		return this.resaltarmarcaParteActivoFijo;
	}

	public void setResaltarmarcaParteActivoFijo(Border borderResaltar) {
		this.resaltarmarcaParteActivoFijo= borderResaltar;
	}

	public Boolean getMostrarmarcaParteActivoFijo() {
		return this.mostrarmarcaParteActivoFijo;
	}

	public void setMostrarmarcaParteActivoFijo(Boolean mostrarmarcaParteActivoFijo) {
		this.mostrarmarcaParteActivoFijo= mostrarmarcaParteActivoFijo;
	}

	public Boolean getActivarmarcaParteActivoFijo() {
		return this.activarmarcaParteActivoFijo;
	}

	public void setActivarmarcaParteActivoFijo(Boolean activarmarcaParteActivoFijo) {
		this.activarmarcaParteActivoFijo= activarmarcaParteActivoFijo;
	}

	public Border setResaltarserieParteActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ParteActivoFijoBeanSwingJInternalFrame parteactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parteactivofijoBeanSwingJInternalFrame.jTtoolBarParteActivoFijo.setBorder(borderResaltar);
		
		this.resaltarserieParteActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarserieParteActivoFijo() {
		return this.resaltarserieParteActivoFijo;
	}

	public void setResaltarserieParteActivoFijo(Border borderResaltar) {
		this.resaltarserieParteActivoFijo= borderResaltar;
	}

	public Boolean getMostrarserieParteActivoFijo() {
		return this.mostrarserieParteActivoFijo;
	}

	public void setMostrarserieParteActivoFijo(Boolean mostrarserieParteActivoFijo) {
		this.mostrarserieParteActivoFijo= mostrarserieParteActivoFijo;
	}

	public Boolean getActivarserieParteActivoFijo() {
		return this.activarserieParteActivoFijo;
	}

	public void setActivarserieParteActivoFijo(Boolean activarserieParteActivoFijo) {
		this.activarserieParteActivoFijo= activarserieParteActivoFijo;
	}

	public Border setResaltarcantidadParteActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ParteActivoFijoBeanSwingJInternalFrame parteactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parteactivofijoBeanSwingJInternalFrame.jTtoolBarParteActivoFijo.setBorder(borderResaltar);
		
		this.resaltarcantidadParteActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadParteActivoFijo() {
		return this.resaltarcantidadParteActivoFijo;
	}

	public void setResaltarcantidadParteActivoFijo(Border borderResaltar) {
		this.resaltarcantidadParteActivoFijo= borderResaltar;
	}

	public Boolean getMostrarcantidadParteActivoFijo() {
		return this.mostrarcantidadParteActivoFijo;
	}

	public void setMostrarcantidadParteActivoFijo(Boolean mostrarcantidadParteActivoFijo) {
		this.mostrarcantidadParteActivoFijo= mostrarcantidadParteActivoFijo;
	}

	public Boolean getActivarcantidadParteActivoFijo() {
		return this.activarcantidadParteActivoFijo;
	}

	public void setActivarcantidadParteActivoFijo(Boolean activarcantidadParteActivoFijo) {
		this.activarcantidadParteActivoFijo= activarcantidadParteActivoFijo;
	}

	public Border setResaltarfotoParteActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ParteActivoFijoBeanSwingJInternalFrame parteactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parteactivofijoBeanSwingJInternalFrame.jTtoolBarParteActivoFijo.setBorder(borderResaltar);
		
		this.resaltarfotoParteActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfotoParteActivoFijo() {
		return this.resaltarfotoParteActivoFijo;
	}

	public void setResaltarfotoParteActivoFijo(Border borderResaltar) {
		this.resaltarfotoParteActivoFijo= borderResaltar;
	}

	public Boolean getMostrarfotoParteActivoFijo() {
		return this.mostrarfotoParteActivoFijo;
	}

	public void setMostrarfotoParteActivoFijo(Boolean mostrarfotoParteActivoFijo) {
		this.mostrarfotoParteActivoFijo= mostrarfotoParteActivoFijo;
	}

	public Boolean getActivarfotoParteActivoFijo() {
		return this.activarfotoParteActivoFijo;
	}

	public void setActivarfotoParteActivoFijo(Boolean activarfotoParteActivoFijo) {
		this.activarfotoParteActivoFijo= activarfotoParteActivoFijo;
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
		
		
		this.setMostraridParteActivoFijo(esInicial);
		this.setMostrarid_empresaParteActivoFijo(esInicial);
		this.setMostrarid_sucursalParteActivoFijo(esInicial);
		this.setMostrarid_estado_activo_fijoParteActivoFijo(esInicial);
		this.setMostrarid_detalle_activo_fijoParteActivoFijo(esInicial);
		this.setMostrarcodigoParteActivoFijo(esInicial);
		this.setMostrarnombreParteActivoFijo(esInicial);
		this.setMostrarmarcaParteActivoFijo(esInicial);
		this.setMostrarserieParteActivoFijo(esInicial);
		this.setMostrarcantidadParteActivoFijo(esInicial);
		this.setMostrarfotoParteActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.ID)) {
				this.setMostraridParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.IDESTADOACTIVOFIJO)) {
				this.setMostrarid_estado_activo_fijoParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO)) {
				this.setMostrarid_detalle_activo_fijoParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.MARCA)) {
				this.setMostrarmarcaParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.SERIE)) {
				this.setMostrarserieParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.FOTO)) {
				this.setMostrarfotoParteActivoFijo(esAsigna);
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
		
		
		this.setActivaridParteActivoFijo(esInicial);
		this.setActivarid_empresaParteActivoFijo(esInicial);
		this.setActivarid_sucursalParteActivoFijo(esInicial);
		this.setActivarid_estado_activo_fijoParteActivoFijo(esInicial);
		this.setActivarid_detalle_activo_fijoParteActivoFijo(esInicial);
		this.setActivarcodigoParteActivoFijo(esInicial);
		this.setActivarnombreParteActivoFijo(esInicial);
		this.setActivarmarcaParteActivoFijo(esInicial);
		this.setActivarserieParteActivoFijo(esInicial);
		this.setActivarcantidadParteActivoFijo(esInicial);
		this.setActivarfotoParteActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.ID)) {
				this.setActivaridParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.IDESTADOACTIVOFIJO)) {
				this.setActivarid_estado_activo_fijoParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO)) {
				this.setActivarid_detalle_activo_fijoParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.MARCA)) {
				this.setActivarmarcaParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.SERIE)) {
				this.setActivarserieParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.FOTO)) {
				this.setActivarfotoParteActivoFijo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParteActivoFijoBeanSwingJInternalFrame parteactivofijoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParteActivoFijo(esInicial);
		this.setResaltarid_empresaParteActivoFijo(esInicial);
		this.setResaltarid_sucursalParteActivoFijo(esInicial);
		this.setResaltarid_estado_activo_fijoParteActivoFijo(esInicial);
		this.setResaltarid_detalle_activo_fijoParteActivoFijo(esInicial);
		this.setResaltarcodigoParteActivoFijo(esInicial);
		this.setResaltarnombreParteActivoFijo(esInicial);
		this.setResaltarmarcaParteActivoFijo(esInicial);
		this.setResaltarserieParteActivoFijo(esInicial);
		this.setResaltarcantidadParteActivoFijo(esInicial);
		this.setResaltarfotoParteActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.ID)) {
				this.setResaltaridParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.IDESTADOACTIVOFIJO)) {
				this.setResaltarid_estado_activo_fijoParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO)) {
				this.setResaltarid_detalle_activo_fijoParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.MARCA)) {
				this.setResaltarmarcaParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.SERIE)) {
				this.setResaltarserieParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadParteActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParteActivoFijoConstantesFunciones.FOTO)) {
				this.setResaltarfotoParteActivoFijo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParteActivoFijoBeanSwingJInternalFrame parteactivofijoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdDetalleActivoFijoParteActivoFijo=true;

	public Boolean getMostrarFK_IdDetalleActivoFijoParteActivoFijo() {
		return this.mostrarFK_IdDetalleActivoFijoParteActivoFijo;
	}

	public void setMostrarFK_IdDetalleActivoFijoParteActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDetalleActivoFijoParteActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaParteActivoFijo=true;

	public Boolean getMostrarFK_IdEmpresaParteActivoFijo() {
		return this.mostrarFK_IdEmpresaParteActivoFijo;
	}

	public void setMostrarFK_IdEmpresaParteActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaParteActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoActivoFijoParteActivoFijo=true;

	public Boolean getMostrarFK_IdEstadoActivoFijoParteActivoFijo() {
		return this.mostrarFK_IdEstadoActivoFijoParteActivoFijo;
	}

	public void setMostrarFK_IdEstadoActivoFijoParteActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoActivoFijoParteActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalParteActivoFijo=true;

	public Boolean getMostrarFK_IdSucursalParteActivoFijo() {
		return this.mostrarFK_IdSucursalParteActivoFijo;
	}

	public void setMostrarFK_IdSucursalParteActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalParteActivoFijo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdDetalleActivoFijoParteActivoFijo=true;

	public Boolean getActivarFK_IdDetalleActivoFijoParteActivoFijo() {
		return this.activarFK_IdDetalleActivoFijoParteActivoFijo;
	}

	public void setActivarFK_IdDetalleActivoFijoParteActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdDetalleActivoFijoParteActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaParteActivoFijo=true;

	public Boolean getActivarFK_IdEmpresaParteActivoFijo() {
		return this.activarFK_IdEmpresaParteActivoFijo;
	}

	public void setActivarFK_IdEmpresaParteActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaParteActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoActivoFijoParteActivoFijo=true;

	public Boolean getActivarFK_IdEstadoActivoFijoParteActivoFijo() {
		return this.activarFK_IdEstadoActivoFijoParteActivoFijo;
	}

	public void setActivarFK_IdEstadoActivoFijoParteActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoActivoFijoParteActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalParteActivoFijo=true;

	public Boolean getActivarFK_IdSucursalParteActivoFijo() {
		return this.activarFK_IdSucursalParteActivoFijo;
	}

	public void setActivarFK_IdSucursalParteActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalParteActivoFijo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdDetalleActivoFijoParteActivoFijo=null;

	public Border getResaltarFK_IdDetalleActivoFijoParteActivoFijo() {
		return this.resaltarFK_IdDetalleActivoFijoParteActivoFijo;
	}

	public void setResaltarFK_IdDetalleActivoFijoParteActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdDetalleActivoFijoParteActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdDetalleActivoFijoParteActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ParteActivoFijoBeanSwingJInternalFrame parteactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDetalleActivoFijoParteActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaParteActivoFijo=null;

	public Border getResaltarFK_IdEmpresaParteActivoFijo() {
		return this.resaltarFK_IdEmpresaParteActivoFijo;
	}

	public void setResaltarFK_IdEmpresaParteActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaParteActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaParteActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ParteActivoFijoBeanSwingJInternalFrame parteactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaParteActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdEstadoActivoFijoParteActivoFijo=null;

	public Border getResaltarFK_IdEstadoActivoFijoParteActivoFijo() {
		return this.resaltarFK_IdEstadoActivoFijoParteActivoFijo;
	}

	public void setResaltarFK_IdEstadoActivoFijoParteActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdEstadoActivoFijoParteActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdEstadoActivoFijoParteActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ParteActivoFijoBeanSwingJInternalFrame parteactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoActivoFijoParteActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdSucursalParteActivoFijo=null;

	public Border getResaltarFK_IdSucursalParteActivoFijo() {
		return this.resaltarFK_IdSucursalParteActivoFijo;
	}

	public void setResaltarFK_IdSucursalParteActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdSucursalParteActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdSucursalParteActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*ParteActivoFijoBeanSwingJInternalFrame parteactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalParteActivoFijo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}