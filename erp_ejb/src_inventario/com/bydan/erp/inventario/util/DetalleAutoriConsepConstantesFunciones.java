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


import com.bydan.erp.inventario.util.DetalleAutoriConsepConstantesFunciones;
import com.bydan.erp.inventario.util.DetalleAutoriConsepParameterReturnGeneral;
//import com.bydan.erp.inventario.util.DetalleAutoriConsepParameterGeneral;

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
final public class DetalleAutoriConsepConstantesFunciones extends DetalleAutoriConsepConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleAutoriConsep";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleAutoriConsep"+DetalleAutoriConsepConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleAutoriConsepHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleAutoriConsepHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleAutoriConsepConstantesFunciones.SCHEMA+"_"+DetalleAutoriConsepConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleAutoriConsepHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleAutoriConsepConstantesFunciones.SCHEMA+"_"+DetalleAutoriConsepConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleAutoriConsepConstantesFunciones.SCHEMA+"_"+DetalleAutoriConsepConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleAutoriConsepHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleAutoriConsepConstantesFunciones.SCHEMA+"_"+DetalleAutoriConsepConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleAutoriConsepConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleAutoriConsepHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleAutoriConsepConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleAutoriConsepConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleAutoriConsepHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleAutoriConsepConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleAutoriConsepConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleAutoriConsepConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleAutoriConsepConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleAutoriConsepConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Autorizacion Consepes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Detalle Autorizacion Consep";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Autori Consep";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleAutoriConsep";
	public static final String OBJECTNAME="detalleautoriconsep";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="detalle_autori_consep";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detalleautoriconsep from "+DetalleAutoriConsepConstantesFunciones.SPERSISTENCENAME+" detalleautoriconsep";
	public static String QUERYSELECTNATIVE="select "+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME+".id,"+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME+".version_row,"+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME+".id_autori_consep,"+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME+".id_empresa,"+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME+".id_producto,"+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME+".id_unidad,"+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME+".cantidad_anio,"+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME+".cantidad_saldo,"+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME+".id_estado_detalle_autori_consep,"+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME+".nombre from "+DetalleAutoriConsepConstantesFunciones.SCHEMA+"."+DetalleAutoriConsepConstantesFunciones.TABLENAME;//+" as "+DetalleAutoriConsepConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleAutoriConsepConstantesFuncionesAdditional detalleautoriconsepConstantesFuncionesAdditional=null;
	
	public DetalleAutoriConsepConstantesFuncionesAdditional getDetalleAutoriConsepConstantesFuncionesAdditional() {
		return this.detalleautoriconsepConstantesFuncionesAdditional;
	}
	
	public void setDetalleAutoriConsepConstantesFuncionesAdditional(DetalleAutoriConsepConstantesFuncionesAdditional detalleautoriconsepConstantesFuncionesAdditional) {
		try {
			this.detalleautoriconsepConstantesFuncionesAdditional=detalleautoriconsepConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDAUTORICONSEP= "id_autori_consep";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDUNIDAD= "id_unidad";
    public static final String CANTIDADANIO= "cantidad_anio";
    public static final String CANTIDADSALDO= "cantidad_saldo";
    public static final String IDESTADODETALLEAUTORICONSEP= "id_estado_detalle_autori_consep";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDAUTORICONSEP= "Autorizacion Consep";
		public static final String LABEL_IDAUTORICONSEP_LOWER= "Autori Consep";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDUNIDAD= "Unidad";
		public static final String LABEL_IDUNIDAD_LOWER= "Unidad";
    	public static final String LABEL_CANTIDADANIO= "Cantidad";
		public static final String LABEL_CANTIDADANIO_LOWER= "Cantidad Anio";
    	public static final String LABEL_CANTIDADSALDO= "Saldo";
		public static final String LABEL_CANTIDADSALDO_LOWER= "Cantidad Saldo";
    	public static final String LABEL_IDESTADODETALLEAUTORICONSEP= "Estado";
		public static final String LABEL_IDESTADODETALLEAUTORICONSEP_LOWER= "Estado Detalle Autori Consep";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDetalleAutoriConsepLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleAutoriConsepConstantesFunciones.IDAUTORICONSEP)) {sLabelColumna=DetalleAutoriConsepConstantesFunciones.LABEL_IDAUTORICONSEP;}
		if(sNombreColumna.equals(DetalleAutoriConsepConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleAutoriConsepConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleAutoriConsepConstantesFunciones.IDPRODUCTO)) {sLabelColumna=DetalleAutoriConsepConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(DetalleAutoriConsepConstantesFunciones.IDUNIDAD)) {sLabelColumna=DetalleAutoriConsepConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(DetalleAutoriConsepConstantesFunciones.CANTIDADANIO)) {sLabelColumna=DetalleAutoriConsepConstantesFunciones.LABEL_CANTIDADANIO;}
		if(sNombreColumna.equals(DetalleAutoriConsepConstantesFunciones.CANTIDADSALDO)) {sLabelColumna=DetalleAutoriConsepConstantesFunciones.LABEL_CANTIDADSALDO;}
		if(sNombreColumna.equals(DetalleAutoriConsepConstantesFunciones.IDESTADODETALLEAUTORICONSEP)) {sLabelColumna=DetalleAutoriConsepConstantesFunciones.LABEL_IDESTADODETALLEAUTORICONSEP;}
		if(sNombreColumna.equals(DetalleAutoriConsepConstantesFunciones.NOMBRE)) {sLabelColumna=DetalleAutoriConsepConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetalleAutoriConsepDescripcion(DetalleAutoriConsep detalleautoriconsep) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detalleautoriconsep !=null/* && detalleautoriconsep.getId()!=0*/) {
			sDescripcion=detalleautoriconsep.getnombre();//detalleautoriconsepdetalleautoriconsep.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleAutoriConsepDescripcionDetallado(DetalleAutoriConsep detalleautoriconsep) {
		String sDescripcion="";
			
		sDescripcion+=DetalleAutoriConsepConstantesFunciones.ID+"=";
		sDescripcion+=detalleautoriconsep.getId().toString()+",";
		sDescripcion+=DetalleAutoriConsepConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detalleautoriconsep.getVersionRow().toString()+",";
		sDescripcion+=DetalleAutoriConsepConstantesFunciones.IDAUTORICONSEP+"=";
		sDescripcion+=detalleautoriconsep.getid_autori_consep().toString()+",";
		sDescripcion+=DetalleAutoriConsepConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detalleautoriconsep.getid_empresa().toString()+",";
		sDescripcion+=DetalleAutoriConsepConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=detalleautoriconsep.getid_producto().toString()+",";
		sDescripcion+=DetalleAutoriConsepConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=detalleautoriconsep.getid_unidad().toString()+",";
		sDescripcion+=DetalleAutoriConsepConstantesFunciones.CANTIDADANIO+"=";
		sDescripcion+=detalleautoriconsep.getcantidad_anio().toString()+",";
		sDescripcion+=DetalleAutoriConsepConstantesFunciones.CANTIDADSALDO+"=";
		sDescripcion+=detalleautoriconsep.getcantidad_saldo().toString()+",";
		sDescripcion+=DetalleAutoriConsepConstantesFunciones.IDESTADODETALLEAUTORICONSEP+"=";
		sDescripcion+=detalleautoriconsep.getid_estado_detalle_autori_consep().toString()+",";
		sDescripcion+=DetalleAutoriConsepConstantesFunciones.NOMBRE+"=";
		sDescripcion+=detalleautoriconsep.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleAutoriConsepDescripcion(DetalleAutoriConsep detalleautoriconsep,String sValor) throws Exception {			
		if(detalleautoriconsep !=null) {
			detalleautoriconsep.setnombre(sValor);//detalleautoriconsepdetalleautoriconsep.getId().toString();
		}		
	}
	
		

	public static String getAutoriConsepDescripcion(AutoriConsep autoriconsep) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(autoriconsep!=null/*&&autoriconsep.getId()>0*/) {
			sDescripcion=AutoriConsepConstantesFunciones.getAutoriConsepDescripcion(autoriconsep);
		}

		return sDescripcion;
	}

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getProductoDescripcion(Producto producto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(producto!=null/*&&producto.getId()>0*/) {
			sDescripcion=ProductoConstantesFunciones.getProductoDescripcion(producto);
		}

		return sDescripcion;
	}

	public static String getUnidadDescripcion(Unidad unidad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(unidad!=null/*&&unidad.getId()>0*/) {
			sDescripcion=UnidadConstantesFunciones.getUnidadDescripcion(unidad);
		}

		return sDescripcion;
	}

	public static String getEstadoDetalleAutoriConsepDescripcion(EstadoDetalleAutoriConsep estadodetalleautoriconsep) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadodetalleautoriconsep!=null/*&&estadodetalleautoriconsep.getId()>0*/) {
			sDescripcion=EstadoDetalleAutoriConsepConstantesFunciones.getEstadoDetalleAutoriConsepDescripcion(estadodetalleautoriconsep);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAutoriConsep")) {
			sNombreIndice="Tipo=  Por Autorizacion Consep";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoDetalleAutoriConsep")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdUnidad")) {
			sNombreIndice="Tipo=  Por Unidad";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAutoriConsep(Long id_autori_consep) {
		String sDetalleIndice=" Parametros->";
		if(id_autori_consep!=null) {sDetalleIndice+=" Codigo Unico De Autorizacion Consep="+id_autori_consep.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoDetalleAutoriConsep(Long id_estado_detalle_autori_consep) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_detalle_autori_consep!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_estado_detalle_autori_consep.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProducto(Long id_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUnidad(Long id_unidad) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad!=null) {sDetalleIndice+=" Codigo Unico De Unidad="+id_unidad.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetalleAutoriConsep(DetalleAutoriConsep detalleautoriconsep,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detalleautoriconsep.setnombre(detalleautoriconsep.getnombre().trim());
	}
	
	public static void quitarEspaciosDetalleAutoriConseps(List<DetalleAutoriConsep> detalleautoriconseps,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleAutoriConsep detalleautoriconsep: detalleautoriconseps) {
			detalleautoriconsep.setnombre(detalleautoriconsep.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleAutoriConsep(DetalleAutoriConsep detalleautoriconsep,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detalleautoriconsep.getConCambioAuxiliar()) {
			detalleautoriconsep.setIsDeleted(detalleautoriconsep.getIsDeletedAuxiliar());	
			detalleautoriconsep.setIsNew(detalleautoriconsep.getIsNewAuxiliar());	
			detalleautoriconsep.setIsChanged(detalleautoriconsep.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detalleautoriconsep.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detalleautoriconsep.setIsDeletedAuxiliar(false);	
			detalleautoriconsep.setIsNewAuxiliar(false);	
			detalleautoriconsep.setIsChangedAuxiliar(false);
			
			detalleautoriconsep.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleAutoriConseps(List<DetalleAutoriConsep> detalleautoriconseps,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleAutoriConsep detalleautoriconsep : detalleautoriconseps) {
			if(conAsignarBase && detalleautoriconsep.getConCambioAuxiliar()) {
				detalleautoriconsep.setIsDeleted(detalleautoriconsep.getIsDeletedAuxiliar());	
				detalleautoriconsep.setIsNew(detalleautoriconsep.getIsNewAuxiliar());	
				detalleautoriconsep.setIsChanged(detalleautoriconsep.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detalleautoriconsep.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detalleautoriconsep.setIsDeletedAuxiliar(false);	
				detalleautoriconsep.setIsNewAuxiliar(false);	
				detalleautoriconsep.setIsChangedAuxiliar(false);
				
				detalleautoriconsep.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleAutoriConsep(DetalleAutoriConsep detalleautoriconsep,Boolean conEnteros) throws Exception  {
		detalleautoriconsep.setcantidad_anio(0.0);
		detalleautoriconsep.setcantidad_saldo(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDetalleAutoriConseps(List<DetalleAutoriConsep> detalleautoriconseps,Boolean conEnteros) throws Exception  {
		
		for(DetalleAutoriConsep detalleautoriconsep: detalleautoriconseps) {
			detalleautoriconsep.setcantidad_anio(0.0);
			detalleautoriconsep.setcantidad_saldo(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleAutoriConsep(List<DetalleAutoriConsep> detalleautoriconseps,DetalleAutoriConsep detalleautoriconsepAux) throws Exception  {
		DetalleAutoriConsepConstantesFunciones.InicializarValoresDetalleAutoriConsep(detalleautoriconsepAux,true);
		
		for(DetalleAutoriConsep detalleautoriconsep: detalleautoriconseps) {
			if(detalleautoriconsep.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detalleautoriconsepAux.setcantidad_anio(detalleautoriconsepAux.getcantidad_anio()+detalleautoriconsep.getcantidad_anio());			
			detalleautoriconsepAux.setcantidad_saldo(detalleautoriconsepAux.getcantidad_saldo()+detalleautoriconsep.getcantidad_saldo());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleAutoriConsep(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleAutoriConsepConstantesFunciones.getArrayColumnasGlobalesDetalleAutoriConsep(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleAutoriConsep(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleAutoriConsepConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleAutoriConsepConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleAutoriConsep(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleAutoriConsep> detalleautoriconseps,DetalleAutoriConsep detalleautoriconsep,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleAutoriConsep detalleautoriconsepAux: detalleautoriconseps) {
			if(detalleautoriconsepAux!=null && detalleautoriconsep!=null) {
				if((detalleautoriconsepAux.getId()==null && detalleautoriconsep.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detalleautoriconsepAux.getId()!=null && detalleautoriconsep.getId()!=null){
					if(detalleautoriconsepAux.getId().equals(detalleautoriconsep.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleAutoriConsep(List<DetalleAutoriConsep> detalleautoriconseps) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double cantidad_anioTotal=0.0;
		Double cantidad_saldoTotal=0.0;
	
		for(DetalleAutoriConsep detalleautoriconsep: detalleautoriconseps) {			
			if(detalleautoriconsep.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cantidad_anioTotal+=detalleautoriconsep.getcantidad_anio();
			cantidad_saldoTotal+=detalleautoriconsep.getcantidad_saldo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleAutoriConsepConstantesFunciones.CANTIDADANIO);
		datoGeneral.setsDescripcion(DetalleAutoriConsepConstantesFunciones.LABEL_CANTIDADANIO);
		datoGeneral.setdValorDouble(cantidad_anioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleAutoriConsepConstantesFunciones.CANTIDADSALDO);
		datoGeneral.setsDescripcion(DetalleAutoriConsepConstantesFunciones.LABEL_CANTIDADSALDO);
		datoGeneral.setdValorDouble(cantidad_saldoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleAutoriConsep() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleAutoriConsepConstantesFunciones.LABEL_ID, DetalleAutoriConsepConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAutoriConsepConstantesFunciones.LABEL_VERSIONROW, DetalleAutoriConsepConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAutoriConsepConstantesFunciones.LABEL_IDAUTORICONSEP, DetalleAutoriConsepConstantesFunciones.IDAUTORICONSEP,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAutoriConsepConstantesFunciones.LABEL_IDEMPRESA, DetalleAutoriConsepConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAutoriConsepConstantesFunciones.LABEL_IDPRODUCTO, DetalleAutoriConsepConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAutoriConsepConstantesFunciones.LABEL_IDUNIDAD, DetalleAutoriConsepConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAutoriConsepConstantesFunciones.LABEL_CANTIDADANIO, DetalleAutoriConsepConstantesFunciones.CANTIDADANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAutoriConsepConstantesFunciones.LABEL_CANTIDADSALDO, DetalleAutoriConsepConstantesFunciones.CANTIDADSALDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAutoriConsepConstantesFunciones.LABEL_IDESTADODETALLEAUTORICONSEP, DetalleAutoriConsepConstantesFunciones.IDESTADODETALLEAUTORICONSEP,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAutoriConsepConstantesFunciones.LABEL_NOMBRE, DetalleAutoriConsepConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleAutoriConsep() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleAutoriConsepConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAutoriConsepConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAutoriConsepConstantesFunciones.IDAUTORICONSEP;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAutoriConsepConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAutoriConsepConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAutoriConsepConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAutoriConsepConstantesFunciones.CANTIDADANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAutoriConsepConstantesFunciones.CANTIDADSALDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAutoriConsepConstantesFunciones.IDESTADODETALLEAUTORICONSEP;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAutoriConsepConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleAutoriConsep() throws Exception  {
		return DetalleAutoriConsepConstantesFunciones.getTiposSeleccionarDetalleAutoriConsep(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleAutoriConsep(Boolean conFk) throws Exception  {
		return DetalleAutoriConsepConstantesFunciones.getTiposSeleccionarDetalleAutoriConsep(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleAutoriConsep(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAutoriConsepConstantesFunciones.LABEL_IDAUTORICONSEP);
			reporte.setsDescripcion(DetalleAutoriConsepConstantesFunciones.LABEL_IDAUTORICONSEP);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAutoriConsepConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleAutoriConsepConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAutoriConsepConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(DetalleAutoriConsepConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAutoriConsepConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(DetalleAutoriConsepConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAutoriConsepConstantesFunciones.LABEL_CANTIDADANIO);
			reporte.setsDescripcion(DetalleAutoriConsepConstantesFunciones.LABEL_CANTIDADANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAutoriConsepConstantesFunciones.LABEL_CANTIDADSALDO);
			reporte.setsDescripcion(DetalleAutoriConsepConstantesFunciones.LABEL_CANTIDADSALDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAutoriConsepConstantesFunciones.LABEL_IDESTADODETALLEAUTORICONSEP);
			reporte.setsDescripcion(DetalleAutoriConsepConstantesFunciones.LABEL_IDESTADODETALLEAUTORICONSEP);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAutoriConsepConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(DetalleAutoriConsepConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleAutoriConsep(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleAutoriConsep(DetalleAutoriConsep detalleautoriconsepAux) throws Exception {
		
			detalleautoriconsepAux.setautoriconsep_descripcion(AutoriConsepConstantesFunciones.getAutoriConsepDescripcion(detalleautoriconsepAux.getAutoriConsep()));
			detalleautoriconsepAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleautoriconsepAux.getEmpresa()));
			detalleautoriconsepAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detalleautoriconsepAux.getProducto()));
			detalleautoriconsepAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detalleautoriconsepAux.getUnidad()));
			detalleautoriconsepAux.setestadodetalleautoriconsep_descripcion(EstadoDetalleAutoriConsepConstantesFunciones.getEstadoDetalleAutoriConsepDescripcion(detalleautoriconsepAux.getEstadoDetalleAutoriConsep()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleAutoriConsep(List<DetalleAutoriConsep> detalleautoriconsepsTemp) throws Exception {
		for(DetalleAutoriConsep detalleautoriconsepAux:detalleautoriconsepsTemp) {
			
			detalleautoriconsepAux.setautoriconsep_descripcion(AutoriConsepConstantesFunciones.getAutoriConsepDescripcion(detalleautoriconsepAux.getAutoriConsep()));
			detalleautoriconsepAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleautoriconsepAux.getEmpresa()));
			detalleautoriconsepAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detalleautoriconsepAux.getProducto()));
			detalleautoriconsepAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detalleautoriconsepAux.getUnidad()));
			detalleautoriconsepAux.setestadodetalleautoriconsep_descripcion(EstadoDetalleAutoriConsepConstantesFunciones.getEstadoDetalleAutoriConsepDescripcion(detalleautoriconsepAux.getEstadoDetalleAutoriConsep()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleAutoriConsep(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(AutoriConsep.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Unidad.class));
				classes.add(new Classe(EstadoDetalleAutoriConsep.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(AutoriConsep.class)) {
						classes.add(new Classe(AutoriConsep.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Unidad.class)) {
						classes.add(new Classe(Unidad.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoDetalleAutoriConsep.class)) {
						classes.add(new Classe(EstadoDetalleAutoriConsep.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleAutoriConsep(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(AutoriConsep.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AutoriConsep.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
					}

					if(EstadoDetalleAutoriConsep.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoDetalleAutoriConsep.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(AutoriConsep.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AutoriConsep.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
					}

					if(EstadoDetalleAutoriConsep.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoDetalleAutoriConsep.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleAutoriConsep(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleAutoriConsepConstantesFunciones.getClassesRelationshipsOfDetalleAutoriConsep(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleAutoriConsep(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleAutoriConsep(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleAutoriConsepConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleAutoriConsep(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleAutoriConsep(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleAutoriConsep detalleautoriconsep,List<DetalleAutoriConsep> detalleautoriconseps,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleAutoriConsep detalleautoriconsepEncontrado=null;
			
			for(DetalleAutoriConsep detalleautoriconsepLocal:detalleautoriconseps) {
				if(detalleautoriconsepLocal.getId().equals(detalleautoriconsep.getId())) {
					detalleautoriconsepEncontrado=detalleautoriconsepLocal;
					
					detalleautoriconsepLocal.setIsChanged(detalleautoriconsep.getIsChanged());
					detalleautoriconsepLocal.setIsNew(detalleautoriconsep.getIsNew());
					detalleautoriconsepLocal.setIsDeleted(detalleautoriconsep.getIsDeleted());
					
					detalleautoriconsepLocal.setGeneralEntityOriginal(detalleautoriconsep.getGeneralEntityOriginal());
					
					detalleautoriconsepLocal.setId(detalleautoriconsep.getId());	
					detalleautoriconsepLocal.setVersionRow(detalleautoriconsep.getVersionRow());	
					detalleautoriconsepLocal.setid_autori_consep(detalleautoriconsep.getid_autori_consep());	
					detalleautoriconsepLocal.setid_empresa(detalleautoriconsep.getid_empresa());	
					detalleautoriconsepLocal.setid_producto(detalleautoriconsep.getid_producto());	
					detalleautoriconsepLocal.setid_unidad(detalleautoriconsep.getid_unidad());	
					detalleautoriconsepLocal.setcantidad_anio(detalleautoriconsep.getcantidad_anio());	
					detalleautoriconsepLocal.setcantidad_saldo(detalleautoriconsep.getcantidad_saldo());	
					detalleautoriconsepLocal.setid_estado_detalle_autori_consep(detalleautoriconsep.getid_estado_detalle_autori_consep());	
					detalleautoriconsepLocal.setnombre(detalleautoriconsep.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detalleautoriconsep.getIsDeleted()) {
				if(!existe) {
					detalleautoriconseps.add(detalleautoriconsep);
				}
			} else {
				if(detalleautoriconsepEncontrado!=null && permiteQuitar)  {
					detalleautoriconseps.remove(detalleautoriconsepEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleAutoriConsep detalleautoriconsep,List<DetalleAutoriConsep> detalleautoriconseps) throws Exception {
		try	{			
			for(DetalleAutoriConsep detalleautoriconsepLocal:detalleautoriconseps) {
				if(detalleautoriconsepLocal.getId().equals(detalleautoriconsep.getId())) {
					detalleautoriconsepLocal.setIsSelected(detalleautoriconsep.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleAutoriConsep(List<DetalleAutoriConsep> detalleautoriconsepsAux) throws Exception {
		//this.detalleautoriconsepsAux=detalleautoriconsepsAux;
		
		for(DetalleAutoriConsep detalleautoriconsepAux:detalleautoriconsepsAux) {
			if(detalleautoriconsepAux.getIsChanged()) {
				detalleautoriconsepAux.setIsChanged(false);
			}		
			
			if(detalleautoriconsepAux.getIsNew()) {
				detalleautoriconsepAux.setIsNew(false);
			}	
			
			if(detalleautoriconsepAux.getIsDeleted()) {
				detalleautoriconsepAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleAutoriConsep(DetalleAutoriConsep detalleautoriconsepAux) throws Exception {
		//this.detalleautoriconsepAux=detalleautoriconsepAux;
		
			if(detalleautoriconsepAux.getIsChanged()) {
				detalleautoriconsepAux.setIsChanged(false);
			}		
			
			if(detalleautoriconsepAux.getIsNew()) {
				detalleautoriconsepAux.setIsNew(false);
			}	
			
			if(detalleautoriconsepAux.getIsDeleted()) {
				detalleautoriconsepAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleAutoriConsep detalleautoriconsepAsignar,DetalleAutoriConsep detalleautoriconsep) throws Exception {
		detalleautoriconsepAsignar.setId(detalleautoriconsep.getId());	
		detalleautoriconsepAsignar.setVersionRow(detalleautoriconsep.getVersionRow());	
		detalleautoriconsepAsignar.setid_autori_consep(detalleautoriconsep.getid_autori_consep());
		detalleautoriconsepAsignar.setautoriconsep_descripcion(detalleautoriconsep.getautoriconsep_descripcion());	
		detalleautoriconsepAsignar.setid_empresa(detalleautoriconsep.getid_empresa());
		detalleautoriconsepAsignar.setempresa_descripcion(detalleautoriconsep.getempresa_descripcion());	
		detalleautoriconsepAsignar.setid_producto(detalleautoriconsep.getid_producto());
		detalleautoriconsepAsignar.setproducto_descripcion(detalleautoriconsep.getproducto_descripcion());	
		detalleautoriconsepAsignar.setid_unidad(detalleautoriconsep.getid_unidad());
		detalleautoriconsepAsignar.setunidad_descripcion(detalleautoriconsep.getunidad_descripcion());	
		detalleautoriconsepAsignar.setcantidad_anio(detalleautoriconsep.getcantidad_anio());	
		detalleautoriconsepAsignar.setcantidad_saldo(detalleautoriconsep.getcantidad_saldo());	
		detalleautoriconsepAsignar.setid_estado_detalle_autori_consep(detalleautoriconsep.getid_estado_detalle_autori_consep());
		detalleautoriconsepAsignar.setestadodetalleautoriconsep_descripcion(detalleautoriconsep.getestadodetalleautoriconsep_descripcion());	
		detalleautoriconsepAsignar.setnombre(detalleautoriconsep.getnombre());	
	}
	
	public static void inicializarDetalleAutoriConsep(DetalleAutoriConsep detalleautoriconsep) throws Exception {
		try {
				detalleautoriconsep.setId(0L);	
					
				detalleautoriconsep.setid_autori_consep(-1L);	
				detalleautoriconsep.setid_empresa(-1L);	
				detalleautoriconsep.setid_producto(-1L);	
				detalleautoriconsep.setid_unidad(-1L);	
				detalleautoriconsep.setcantidad_anio(0.0);	
				detalleautoriconsep.setcantidad_saldo(0.0);	
				detalleautoriconsep.setid_estado_detalle_autori_consep(-1L);	
				detalleautoriconsep.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleAutoriConsep(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAutoriConsepConstantesFunciones.LABEL_IDAUTORICONSEP);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAutoriConsepConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAutoriConsepConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAutoriConsepConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAutoriConsepConstantesFunciones.LABEL_CANTIDADANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAutoriConsepConstantesFunciones.LABEL_CANTIDADSALDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAutoriConsepConstantesFunciones.LABEL_IDESTADODETALLEAUTORICONSEP);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAutoriConsepConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleAutoriConsep(String sTipo,Row row,Workbook workbook,DetalleAutoriConsep detalleautoriconsep,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleautoriconsep.getautoriconsep_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleautoriconsep.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleautoriconsep.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleautoriconsep.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleautoriconsep.getcantidad_anio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleautoriconsep.getcantidad_saldo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleautoriconsep.getestadodetalleautoriconsep_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleautoriconsep.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleAutoriConsep=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleAutoriConsep() {
		return this.sFinalQueryDetalleAutoriConsep;
	}
	
	public void setsFinalQueryDetalleAutoriConsep(String sFinalQueryDetalleAutoriConsep) {
		this.sFinalQueryDetalleAutoriConsep= sFinalQueryDetalleAutoriConsep;
	}
	
	public Border resaltarSeleccionarDetalleAutoriConsep=null;
	
	public Border setResaltarSeleccionarDetalleAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAutoriConsepBeanSwingJInternalFrame detalleautoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detalleautoriconsepBeanSwingJInternalFrame.jTtoolBarDetalleAutoriConsep.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleAutoriConsep= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleAutoriConsep() {
		return this.resaltarSeleccionarDetalleAutoriConsep;
	}
	
	public void setResaltarSeleccionarDetalleAutoriConsep(Border borderResaltarSeleccionarDetalleAutoriConsep) {
		this.resaltarSeleccionarDetalleAutoriConsep= borderResaltarSeleccionarDetalleAutoriConsep;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleAutoriConsep=null;
	public Boolean mostraridDetalleAutoriConsep=true;
	public Boolean activaridDetalleAutoriConsep=true;

	public Border resaltarid_autori_consepDetalleAutoriConsep=null;
	public Boolean mostrarid_autori_consepDetalleAutoriConsep=true;
	public Boolean activarid_autori_consepDetalleAutoriConsep=true;
	public Boolean cargarid_autori_consepDetalleAutoriConsep=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_autori_consepDetalleAutoriConsep=false;//ConEventDepend=true

	public Border resaltarid_empresaDetalleAutoriConsep=null;
	public Boolean mostrarid_empresaDetalleAutoriConsep=true;
	public Boolean activarid_empresaDetalleAutoriConsep=true;
	public Boolean cargarid_empresaDetalleAutoriConsep=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleAutoriConsep=false;//ConEventDepend=true

	public Border resaltarid_productoDetalleAutoriConsep=null;
	public Boolean mostrarid_productoDetalleAutoriConsep=true;
	public Boolean activarid_productoDetalleAutoriConsep=true;
	public Boolean cargarid_productoDetalleAutoriConsep=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoDetalleAutoriConsep=false;//ConEventDepend=true

	public Border resaltarid_unidadDetalleAutoriConsep=null;
	public Boolean mostrarid_unidadDetalleAutoriConsep=true;
	public Boolean activarid_unidadDetalleAutoriConsep=true;
	public Boolean cargarid_unidadDetalleAutoriConsep=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadDetalleAutoriConsep=false;//ConEventDepend=true

	public Border resaltarcantidad_anioDetalleAutoriConsep=null;
	public Boolean mostrarcantidad_anioDetalleAutoriConsep=true;
	public Boolean activarcantidad_anioDetalleAutoriConsep=true;

	public Border resaltarcantidad_saldoDetalleAutoriConsep=null;
	public Boolean mostrarcantidad_saldoDetalleAutoriConsep=true;
	public Boolean activarcantidad_saldoDetalleAutoriConsep=true;

	public Border resaltarid_estado_detalle_autori_consepDetalleAutoriConsep=null;
	public Boolean mostrarid_estado_detalle_autori_consepDetalleAutoriConsep=true;
	public Boolean activarid_estado_detalle_autori_consepDetalleAutoriConsep=true;
	public Boolean cargarid_estado_detalle_autori_consepDetalleAutoriConsep=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_detalle_autori_consepDetalleAutoriConsep=false;//ConEventDepend=true

	public Border resaltarnombreDetalleAutoriConsep=null;
	public Boolean mostrarnombreDetalleAutoriConsep=true;
	public Boolean activarnombreDetalleAutoriConsep=false;

	
	

	public Border setResaltaridDetalleAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAutoriConsepBeanSwingJInternalFrame detalleautoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleautoriconsepBeanSwingJInternalFrame.jTtoolBarDetalleAutoriConsep.setBorder(borderResaltar);
		
		this.resaltaridDetalleAutoriConsep= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleAutoriConsep() {
		return this.resaltaridDetalleAutoriConsep;
	}

	public void setResaltaridDetalleAutoriConsep(Border borderResaltar) {
		this.resaltaridDetalleAutoriConsep= borderResaltar;
	}

	public Boolean getMostraridDetalleAutoriConsep() {
		return this.mostraridDetalleAutoriConsep;
	}

	public void setMostraridDetalleAutoriConsep(Boolean mostraridDetalleAutoriConsep) {
		this.mostraridDetalleAutoriConsep= mostraridDetalleAutoriConsep;
	}

	public Boolean getActivaridDetalleAutoriConsep() {
		return this.activaridDetalleAutoriConsep;
	}

	public void setActivaridDetalleAutoriConsep(Boolean activaridDetalleAutoriConsep) {
		this.activaridDetalleAutoriConsep= activaridDetalleAutoriConsep;
	}

	public Border setResaltarid_autori_consepDetalleAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAutoriConsepBeanSwingJInternalFrame detalleautoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleautoriconsepBeanSwingJInternalFrame.jTtoolBarDetalleAutoriConsep.setBorder(borderResaltar);
		
		this.resaltarid_autori_consepDetalleAutoriConsep= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_autori_consepDetalleAutoriConsep() {
		return this.resaltarid_autori_consepDetalleAutoriConsep;
	}

	public void setResaltarid_autori_consepDetalleAutoriConsep(Border borderResaltar) {
		this.resaltarid_autori_consepDetalleAutoriConsep= borderResaltar;
	}

	public Boolean getMostrarid_autori_consepDetalleAutoriConsep() {
		return this.mostrarid_autori_consepDetalleAutoriConsep;
	}

	public void setMostrarid_autori_consepDetalleAutoriConsep(Boolean mostrarid_autori_consepDetalleAutoriConsep) {
		this.mostrarid_autori_consepDetalleAutoriConsep= mostrarid_autori_consepDetalleAutoriConsep;
	}

	public Boolean getActivarid_autori_consepDetalleAutoriConsep() {
		return this.activarid_autori_consepDetalleAutoriConsep;
	}

	public void setActivarid_autori_consepDetalleAutoriConsep(Boolean activarid_autori_consepDetalleAutoriConsep) {
		this.activarid_autori_consepDetalleAutoriConsep= activarid_autori_consepDetalleAutoriConsep;
	}

	public Boolean getCargarid_autori_consepDetalleAutoriConsep() {
		return this.cargarid_autori_consepDetalleAutoriConsep;
	}

	public void setCargarid_autori_consepDetalleAutoriConsep(Boolean cargarid_autori_consepDetalleAutoriConsep) {
		this.cargarid_autori_consepDetalleAutoriConsep= cargarid_autori_consepDetalleAutoriConsep;
	}

	public Border setResaltarid_empresaDetalleAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAutoriConsepBeanSwingJInternalFrame detalleautoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleautoriconsepBeanSwingJInternalFrame.jTtoolBarDetalleAutoriConsep.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleAutoriConsep= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleAutoriConsep() {
		return this.resaltarid_empresaDetalleAutoriConsep;
	}

	public void setResaltarid_empresaDetalleAutoriConsep(Border borderResaltar) {
		this.resaltarid_empresaDetalleAutoriConsep= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleAutoriConsep() {
		return this.mostrarid_empresaDetalleAutoriConsep;
	}

	public void setMostrarid_empresaDetalleAutoriConsep(Boolean mostrarid_empresaDetalleAutoriConsep) {
		this.mostrarid_empresaDetalleAutoriConsep= mostrarid_empresaDetalleAutoriConsep;
	}

	public Boolean getActivarid_empresaDetalleAutoriConsep() {
		return this.activarid_empresaDetalleAutoriConsep;
	}

	public void setActivarid_empresaDetalleAutoriConsep(Boolean activarid_empresaDetalleAutoriConsep) {
		this.activarid_empresaDetalleAutoriConsep= activarid_empresaDetalleAutoriConsep;
	}

	public Boolean getCargarid_empresaDetalleAutoriConsep() {
		return this.cargarid_empresaDetalleAutoriConsep;
	}

	public void setCargarid_empresaDetalleAutoriConsep(Boolean cargarid_empresaDetalleAutoriConsep) {
		this.cargarid_empresaDetalleAutoriConsep= cargarid_empresaDetalleAutoriConsep;
	}

	public Border setResaltarid_productoDetalleAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAutoriConsepBeanSwingJInternalFrame detalleautoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleautoriconsepBeanSwingJInternalFrame.jTtoolBarDetalleAutoriConsep.setBorder(borderResaltar);
		
		this.resaltarid_productoDetalleAutoriConsep= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoDetalleAutoriConsep() {
		return this.resaltarid_productoDetalleAutoriConsep;
	}

	public void setResaltarid_productoDetalleAutoriConsep(Border borderResaltar) {
		this.resaltarid_productoDetalleAutoriConsep= borderResaltar;
	}

	public Boolean getMostrarid_productoDetalleAutoriConsep() {
		return this.mostrarid_productoDetalleAutoriConsep;
	}

	public void setMostrarid_productoDetalleAutoriConsep(Boolean mostrarid_productoDetalleAutoriConsep) {
		this.mostrarid_productoDetalleAutoriConsep= mostrarid_productoDetalleAutoriConsep;
	}

	public Boolean getActivarid_productoDetalleAutoriConsep() {
		return this.activarid_productoDetalleAutoriConsep;
	}

	public void setActivarid_productoDetalleAutoriConsep(Boolean activarid_productoDetalleAutoriConsep) {
		this.activarid_productoDetalleAutoriConsep= activarid_productoDetalleAutoriConsep;
	}

	public Boolean getCargarid_productoDetalleAutoriConsep() {
		return this.cargarid_productoDetalleAutoriConsep;
	}

	public void setCargarid_productoDetalleAutoriConsep(Boolean cargarid_productoDetalleAutoriConsep) {
		this.cargarid_productoDetalleAutoriConsep= cargarid_productoDetalleAutoriConsep;
	}

	public Border setResaltarid_unidadDetalleAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAutoriConsepBeanSwingJInternalFrame detalleautoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleautoriconsepBeanSwingJInternalFrame.jTtoolBarDetalleAutoriConsep.setBorder(borderResaltar);
		
		this.resaltarid_unidadDetalleAutoriConsep= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadDetalleAutoriConsep() {
		return this.resaltarid_unidadDetalleAutoriConsep;
	}

	public void setResaltarid_unidadDetalleAutoriConsep(Border borderResaltar) {
		this.resaltarid_unidadDetalleAutoriConsep= borderResaltar;
	}

	public Boolean getMostrarid_unidadDetalleAutoriConsep() {
		return this.mostrarid_unidadDetalleAutoriConsep;
	}

	public void setMostrarid_unidadDetalleAutoriConsep(Boolean mostrarid_unidadDetalleAutoriConsep) {
		this.mostrarid_unidadDetalleAutoriConsep= mostrarid_unidadDetalleAutoriConsep;
	}

	public Boolean getActivarid_unidadDetalleAutoriConsep() {
		return this.activarid_unidadDetalleAutoriConsep;
	}

	public void setActivarid_unidadDetalleAutoriConsep(Boolean activarid_unidadDetalleAutoriConsep) {
		this.activarid_unidadDetalleAutoriConsep= activarid_unidadDetalleAutoriConsep;
	}

	public Boolean getCargarid_unidadDetalleAutoriConsep() {
		return this.cargarid_unidadDetalleAutoriConsep;
	}

	public void setCargarid_unidadDetalleAutoriConsep(Boolean cargarid_unidadDetalleAutoriConsep) {
		this.cargarid_unidadDetalleAutoriConsep= cargarid_unidadDetalleAutoriConsep;
	}

	public Border setResaltarcantidad_anioDetalleAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAutoriConsepBeanSwingJInternalFrame detalleautoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleautoriconsepBeanSwingJInternalFrame.jTtoolBarDetalleAutoriConsep.setBorder(borderResaltar);
		
		this.resaltarcantidad_anioDetalleAutoriConsep= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_anioDetalleAutoriConsep() {
		return this.resaltarcantidad_anioDetalleAutoriConsep;
	}

	public void setResaltarcantidad_anioDetalleAutoriConsep(Border borderResaltar) {
		this.resaltarcantidad_anioDetalleAutoriConsep= borderResaltar;
	}

	public Boolean getMostrarcantidad_anioDetalleAutoriConsep() {
		return this.mostrarcantidad_anioDetalleAutoriConsep;
	}

	public void setMostrarcantidad_anioDetalleAutoriConsep(Boolean mostrarcantidad_anioDetalleAutoriConsep) {
		this.mostrarcantidad_anioDetalleAutoriConsep= mostrarcantidad_anioDetalleAutoriConsep;
	}

	public Boolean getActivarcantidad_anioDetalleAutoriConsep() {
		return this.activarcantidad_anioDetalleAutoriConsep;
	}

	public void setActivarcantidad_anioDetalleAutoriConsep(Boolean activarcantidad_anioDetalleAutoriConsep) {
		this.activarcantidad_anioDetalleAutoriConsep= activarcantidad_anioDetalleAutoriConsep;
	}

	public Border setResaltarcantidad_saldoDetalleAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAutoriConsepBeanSwingJInternalFrame detalleautoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleautoriconsepBeanSwingJInternalFrame.jTtoolBarDetalleAutoriConsep.setBorder(borderResaltar);
		
		this.resaltarcantidad_saldoDetalleAutoriConsep= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_saldoDetalleAutoriConsep() {
		return this.resaltarcantidad_saldoDetalleAutoriConsep;
	}

	public void setResaltarcantidad_saldoDetalleAutoriConsep(Border borderResaltar) {
		this.resaltarcantidad_saldoDetalleAutoriConsep= borderResaltar;
	}

	public Boolean getMostrarcantidad_saldoDetalleAutoriConsep() {
		return this.mostrarcantidad_saldoDetalleAutoriConsep;
	}

	public void setMostrarcantidad_saldoDetalleAutoriConsep(Boolean mostrarcantidad_saldoDetalleAutoriConsep) {
		this.mostrarcantidad_saldoDetalleAutoriConsep= mostrarcantidad_saldoDetalleAutoriConsep;
	}

	public Boolean getActivarcantidad_saldoDetalleAutoriConsep() {
		return this.activarcantidad_saldoDetalleAutoriConsep;
	}

	public void setActivarcantidad_saldoDetalleAutoriConsep(Boolean activarcantidad_saldoDetalleAutoriConsep) {
		this.activarcantidad_saldoDetalleAutoriConsep= activarcantidad_saldoDetalleAutoriConsep;
	}

	public Border setResaltarid_estado_detalle_autori_consepDetalleAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAutoriConsepBeanSwingJInternalFrame detalleautoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleautoriconsepBeanSwingJInternalFrame.jTtoolBarDetalleAutoriConsep.setBorder(borderResaltar);
		
		this.resaltarid_estado_detalle_autori_consepDetalleAutoriConsep= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_detalle_autori_consepDetalleAutoriConsep() {
		return this.resaltarid_estado_detalle_autori_consepDetalleAutoriConsep;
	}

	public void setResaltarid_estado_detalle_autori_consepDetalleAutoriConsep(Border borderResaltar) {
		this.resaltarid_estado_detalle_autori_consepDetalleAutoriConsep= borderResaltar;
	}

	public Boolean getMostrarid_estado_detalle_autori_consepDetalleAutoriConsep() {
		return this.mostrarid_estado_detalle_autori_consepDetalleAutoriConsep;
	}

	public void setMostrarid_estado_detalle_autori_consepDetalleAutoriConsep(Boolean mostrarid_estado_detalle_autori_consepDetalleAutoriConsep) {
		this.mostrarid_estado_detalle_autori_consepDetalleAutoriConsep= mostrarid_estado_detalle_autori_consepDetalleAutoriConsep;
	}

	public Boolean getActivarid_estado_detalle_autori_consepDetalleAutoriConsep() {
		return this.activarid_estado_detalle_autori_consepDetalleAutoriConsep;
	}

	public void setActivarid_estado_detalle_autori_consepDetalleAutoriConsep(Boolean activarid_estado_detalle_autori_consepDetalleAutoriConsep) {
		this.activarid_estado_detalle_autori_consepDetalleAutoriConsep= activarid_estado_detalle_autori_consepDetalleAutoriConsep;
	}

	public Boolean getCargarid_estado_detalle_autori_consepDetalleAutoriConsep() {
		return this.cargarid_estado_detalle_autori_consepDetalleAutoriConsep;
	}

	public void setCargarid_estado_detalle_autori_consepDetalleAutoriConsep(Boolean cargarid_estado_detalle_autori_consepDetalleAutoriConsep) {
		this.cargarid_estado_detalle_autori_consepDetalleAutoriConsep= cargarid_estado_detalle_autori_consepDetalleAutoriConsep;
	}

	public Border setResaltarnombreDetalleAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAutoriConsepBeanSwingJInternalFrame detalleautoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleautoriconsepBeanSwingJInternalFrame.jTtoolBarDetalleAutoriConsep.setBorder(borderResaltar);
		
		this.resaltarnombreDetalleAutoriConsep= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreDetalleAutoriConsep() {
		return this.resaltarnombreDetalleAutoriConsep;
	}

	public void setResaltarnombreDetalleAutoriConsep(Border borderResaltar) {
		this.resaltarnombreDetalleAutoriConsep= borderResaltar;
	}

	public Boolean getMostrarnombreDetalleAutoriConsep() {
		return this.mostrarnombreDetalleAutoriConsep;
	}

	public void setMostrarnombreDetalleAutoriConsep(Boolean mostrarnombreDetalleAutoriConsep) {
		this.mostrarnombreDetalleAutoriConsep= mostrarnombreDetalleAutoriConsep;
	}

	public Boolean getActivarnombreDetalleAutoriConsep() {
		return this.activarnombreDetalleAutoriConsep;
	}

	public void setActivarnombreDetalleAutoriConsep(Boolean activarnombreDetalleAutoriConsep) {
		this.activarnombreDetalleAutoriConsep= activarnombreDetalleAutoriConsep;
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
		
		
		this.setMostraridDetalleAutoriConsep(esInicial);
		this.setMostrarid_autori_consepDetalleAutoriConsep(esInicial);
		this.setMostrarid_empresaDetalleAutoriConsep(esInicial);
		this.setMostrarid_productoDetalleAutoriConsep(esInicial);
		this.setMostrarid_unidadDetalleAutoriConsep(esInicial);
		this.setMostrarcantidad_anioDetalleAutoriConsep(esInicial);
		this.setMostrarcantidad_saldoDetalleAutoriConsep(esInicial);
		this.setMostrarid_estado_detalle_autori_consepDetalleAutoriConsep(esInicial);
		this.setMostrarnombreDetalleAutoriConsep(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleAutoriConsepConstantesFunciones.ID)) {
				this.setMostraridDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAutoriConsepConstantesFunciones.IDAUTORICONSEP)) {
				this.setMostrarid_autori_consepDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAutoriConsepConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAutoriConsepConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAutoriConsepConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAutoriConsepConstantesFunciones.CANTIDADANIO)) {
				this.setMostrarcantidad_anioDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAutoriConsepConstantesFunciones.CANTIDADSALDO)) {
				this.setMostrarcantidad_saldoDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAutoriConsepConstantesFunciones.IDESTADODETALLEAUTORICONSEP)) {
				this.setMostrarid_estado_detalle_autori_consepDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAutoriConsepConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreDetalleAutoriConsep(esAsigna);
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
		
		
		this.setActivaridDetalleAutoriConsep(esInicial);
		this.setActivarid_autori_consepDetalleAutoriConsep(esInicial);
		this.setActivarid_empresaDetalleAutoriConsep(esInicial);
		this.setActivarid_productoDetalleAutoriConsep(esInicial);
		this.setActivarid_unidadDetalleAutoriConsep(esInicial);
		this.setActivarcantidad_anioDetalleAutoriConsep(esInicial);
		this.setActivarcantidad_saldoDetalleAutoriConsep(esInicial);
		this.setActivarid_estado_detalle_autori_consepDetalleAutoriConsep(esInicial);
		this.setActivarnombreDetalleAutoriConsep(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleAutoriConsepConstantesFunciones.ID)) {
				this.setActivaridDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAutoriConsepConstantesFunciones.IDAUTORICONSEP)) {
				this.setActivarid_autori_consepDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAutoriConsepConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAutoriConsepConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAutoriConsepConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAutoriConsepConstantesFunciones.CANTIDADANIO)) {
				this.setActivarcantidad_anioDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAutoriConsepConstantesFunciones.CANTIDADSALDO)) {
				this.setActivarcantidad_saldoDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAutoriConsepConstantesFunciones.IDESTADODETALLEAUTORICONSEP)) {
				this.setActivarid_estado_detalle_autori_consepDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAutoriConsepConstantesFunciones.NOMBRE)) {
				this.setActivarnombreDetalleAutoriConsep(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleAutoriConsepBeanSwingJInternalFrame detalleautoriconsepBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleAutoriConsep(esInicial);
		this.setResaltarid_autori_consepDetalleAutoriConsep(esInicial);
		this.setResaltarid_empresaDetalleAutoriConsep(esInicial);
		this.setResaltarid_productoDetalleAutoriConsep(esInicial);
		this.setResaltarid_unidadDetalleAutoriConsep(esInicial);
		this.setResaltarcantidad_anioDetalleAutoriConsep(esInicial);
		this.setResaltarcantidad_saldoDetalleAutoriConsep(esInicial);
		this.setResaltarid_estado_detalle_autori_consepDetalleAutoriConsep(esInicial);
		this.setResaltarnombreDetalleAutoriConsep(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleAutoriConsepConstantesFunciones.ID)) {
				this.setResaltaridDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAutoriConsepConstantesFunciones.IDAUTORICONSEP)) {
				this.setResaltarid_autori_consepDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAutoriConsepConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAutoriConsepConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAutoriConsepConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAutoriConsepConstantesFunciones.CANTIDADANIO)) {
				this.setResaltarcantidad_anioDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAutoriConsepConstantesFunciones.CANTIDADSALDO)) {
				this.setResaltarcantidad_saldoDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAutoriConsepConstantesFunciones.IDESTADODETALLEAUTORICONSEP)) {
				this.setResaltarid_estado_detalle_autori_consepDetalleAutoriConsep(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAutoriConsepConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreDetalleAutoriConsep(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleAutoriConsepBeanSwingJInternalFrame detalleautoriconsepBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAutoriConsepDetalleAutoriConsep=true;

	public Boolean getMostrarFK_IdAutoriConsepDetalleAutoriConsep() {
		return this.mostrarFK_IdAutoriConsepDetalleAutoriConsep;
	}

	public void setMostrarFK_IdAutoriConsepDetalleAutoriConsep(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAutoriConsepDetalleAutoriConsep= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleAutoriConsep=true;

	public Boolean getMostrarFK_IdEmpresaDetalleAutoriConsep() {
		return this.mostrarFK_IdEmpresaDetalleAutoriConsep;
	}

	public void setMostrarFK_IdEmpresaDetalleAutoriConsep(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleAutoriConsep= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoDetalleAutoriConsepDetalleAutoriConsep=true;

	public Boolean getMostrarFK_IdEstadoDetalleAutoriConsepDetalleAutoriConsep() {
		return this.mostrarFK_IdEstadoDetalleAutoriConsepDetalleAutoriConsep;
	}

	public void setMostrarFK_IdEstadoDetalleAutoriConsepDetalleAutoriConsep(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoDetalleAutoriConsepDetalleAutoriConsep= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoDetalleAutoriConsep=true;

	public Boolean getMostrarFK_IdProductoDetalleAutoriConsep() {
		return this.mostrarFK_IdProductoDetalleAutoriConsep;
	}

	public void setMostrarFK_IdProductoDetalleAutoriConsep(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDetalleAutoriConsep= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadDetalleAutoriConsep=true;

	public Boolean getMostrarFK_IdUnidadDetalleAutoriConsep() {
		return this.mostrarFK_IdUnidadDetalleAutoriConsep;
	}

	public void setMostrarFK_IdUnidadDetalleAutoriConsep(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadDetalleAutoriConsep= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAutoriConsepDetalleAutoriConsep=true;

	public Boolean getActivarFK_IdAutoriConsepDetalleAutoriConsep() {
		return this.activarFK_IdAutoriConsepDetalleAutoriConsep;
	}

	public void setActivarFK_IdAutoriConsepDetalleAutoriConsep(Boolean habilitarResaltar) {
		this.activarFK_IdAutoriConsepDetalleAutoriConsep= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleAutoriConsep=true;

	public Boolean getActivarFK_IdEmpresaDetalleAutoriConsep() {
		return this.activarFK_IdEmpresaDetalleAutoriConsep;
	}

	public void setActivarFK_IdEmpresaDetalleAutoriConsep(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleAutoriConsep= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoDetalleAutoriConsepDetalleAutoriConsep=true;

	public Boolean getActivarFK_IdEstadoDetalleAutoriConsepDetalleAutoriConsep() {
		return this.activarFK_IdEstadoDetalleAutoriConsepDetalleAutoriConsep;
	}

	public void setActivarFK_IdEstadoDetalleAutoriConsepDetalleAutoriConsep(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoDetalleAutoriConsepDetalleAutoriConsep= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoDetalleAutoriConsep=true;

	public Boolean getActivarFK_IdProductoDetalleAutoriConsep() {
		return this.activarFK_IdProductoDetalleAutoriConsep;
	}

	public void setActivarFK_IdProductoDetalleAutoriConsep(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDetalleAutoriConsep= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadDetalleAutoriConsep=true;

	public Boolean getActivarFK_IdUnidadDetalleAutoriConsep() {
		return this.activarFK_IdUnidadDetalleAutoriConsep;
	}

	public void setActivarFK_IdUnidadDetalleAutoriConsep(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadDetalleAutoriConsep= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAutoriConsepDetalleAutoriConsep=null;

	public Border getResaltarFK_IdAutoriConsepDetalleAutoriConsep() {
		return this.resaltarFK_IdAutoriConsepDetalleAutoriConsep;
	}

	public void setResaltarFK_IdAutoriConsepDetalleAutoriConsep(Border borderResaltar) {
		this.resaltarFK_IdAutoriConsepDetalleAutoriConsep= borderResaltar;
	}

	public void setResaltarFK_IdAutoriConsepDetalleAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAutoriConsepBeanSwingJInternalFrame detalleautoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAutoriConsepDetalleAutoriConsep= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleAutoriConsep=null;

	public Border getResaltarFK_IdEmpresaDetalleAutoriConsep() {
		return this.resaltarFK_IdEmpresaDetalleAutoriConsep;
	}

	public void setResaltarFK_IdEmpresaDetalleAutoriConsep(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleAutoriConsep= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAutoriConsepBeanSwingJInternalFrame detalleautoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleAutoriConsep= borderResaltar;
	}

	public Border resaltarFK_IdEstadoDetalleAutoriConsepDetalleAutoriConsep=null;

	public Border getResaltarFK_IdEstadoDetalleAutoriConsepDetalleAutoriConsep() {
		return this.resaltarFK_IdEstadoDetalleAutoriConsepDetalleAutoriConsep;
	}

	public void setResaltarFK_IdEstadoDetalleAutoriConsepDetalleAutoriConsep(Border borderResaltar) {
		this.resaltarFK_IdEstadoDetalleAutoriConsepDetalleAutoriConsep= borderResaltar;
	}

	public void setResaltarFK_IdEstadoDetalleAutoriConsepDetalleAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAutoriConsepBeanSwingJInternalFrame detalleautoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoDetalleAutoriConsepDetalleAutoriConsep= borderResaltar;
	}

	public Border resaltarFK_IdProductoDetalleAutoriConsep=null;

	public Border getResaltarFK_IdProductoDetalleAutoriConsep() {
		return this.resaltarFK_IdProductoDetalleAutoriConsep;
	}

	public void setResaltarFK_IdProductoDetalleAutoriConsep(Border borderResaltar) {
		this.resaltarFK_IdProductoDetalleAutoriConsep= borderResaltar;
	}

	public void setResaltarFK_IdProductoDetalleAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAutoriConsepBeanSwingJInternalFrame detalleautoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDetalleAutoriConsep= borderResaltar;
	}

	public Border resaltarFK_IdUnidadDetalleAutoriConsep=null;

	public Border getResaltarFK_IdUnidadDetalleAutoriConsep() {
		return this.resaltarFK_IdUnidadDetalleAutoriConsep;
	}

	public void setResaltarFK_IdUnidadDetalleAutoriConsep(Border borderResaltar) {
		this.resaltarFK_IdUnidadDetalleAutoriConsep= borderResaltar;
	}

	public void setResaltarFK_IdUnidadDetalleAutoriConsep(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAutoriConsepBeanSwingJInternalFrame detalleautoriconsepBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadDetalleAutoriConsep= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}